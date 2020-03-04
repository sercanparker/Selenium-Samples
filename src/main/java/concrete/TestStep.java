package concrete;

/**
 * @author sercansensulun on 4.03.2020.
 */
public class TestStep {

    private boolean isSuccess;
    private String information;


    public TestStep(boolean isSuccess, String information) {
        this.isSuccess = isSuccess;
        this.information = information;
    }


    public String getInformation() {
        return information;
    }

    public boolean isSuccess() {
        return isSuccess;
    }

}
