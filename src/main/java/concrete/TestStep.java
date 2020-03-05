package concrete;

/**
 * @author sercansensulun on 4.03.2020.
 */
public class TestStep<T> {

    private boolean isSuccess;
    private String information;
    private T parameter;


    public TestStep(boolean isSuccess, String information, T parameter) {
        this.isSuccess = isSuccess;
        this.information = information;
        this.parameter = parameter;
    }
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

    public T getParameter() {
        return parameter;
    }
}
