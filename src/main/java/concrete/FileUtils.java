package concrete;

import java.io.*;
import java.util.Date;

/**
 * @author sercansensulun on 30.05.2020.
 */
public class FileUtils {

    private static final String N11_CSV_FILE_PATH = "src/main/resources/n11_credentials.csv";
    private static final String CSV_SPLIT_BY = ","; // use comma as separator
    private static final String N11_SELECTED_ITEM_TXT_PATH = "src/main/resources/n11_selected_items.txt";

    public static void writeN11SelectedItemDetails(String content){
        try {
            File file = new File(N11_SELECTED_ITEM_TXT_PATH);
            file.createNewFile();
            try(PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(N11_SELECTED_ITEM_TXT_PATH, true)))) {
                out.println(content + " | " + new Date().toString());
            } catch (IOException e) {
                System.err.println(e);
            }
        } catch (IOException e) {
            System.out.println("An error occurred. While writing on txt file. " + e.toString());
            e.printStackTrace();
        }
    }

    public static Credentials getN11Credentials(){
        BufferedReader br = null;
        String line = "";
        try {
            br = new BufferedReader(new FileReader(N11_CSV_FILE_PATH));
            while ((line = br.readLine()) != null) {
                String[] credentials = line.split(CSV_SPLIT_BY);
                if (credentials[0] == null || credentials[1] == null){
                    throw new Exception("Cannot read credentials from file. Path is " + N11_CSV_FILE_PATH);
                }
                return new Credentials(credentials[0], credentials[1], credentials[2]);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }



}
