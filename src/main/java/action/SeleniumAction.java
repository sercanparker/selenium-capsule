package action;

/**
 * @author sercansensulun on 11.03.2020.
 */
public abstract class SeleniumAction<T>{
    /**
     * Indicates action is happened successfully.
     */
    private boolean isSuccess;
    /**
     * parameter is needed for some actions.
     */
    private T parameter;
    /**
     * If action does not happened successfully, it explains why in terms of end user.
     */
    private String exceptionMessage;
    /**
     * If action does not happened successfully, it explains why in terms of more technical user.
     */
    private String innerExceptionMessage;


    public SeleniumAction(T parameter) {
        this.parameter = parameter;
        this.isSuccess = true;
    }

    public SeleniumAction(String exceptionMessage, String innerExceptionMessage){
        this.exceptionMessage = exceptionMessage;
        this.innerExceptionMessage = innerExceptionMessage;
        this.isSuccess = false;
    }

    public String getExceptionMessage() {
        return exceptionMessage;
    }

    public T getParameter() {
        return parameter;
    }

    public boolean isSuccess() {
        return isSuccess;
    }

    public String getInnerExceptionMessage() {
        return innerExceptionMessage;
    }
}
