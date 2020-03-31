package event;

/**
 * @author sercansensulun on 11.03.2020.
 */
public abstract class SeleniumEvent<T>{
    /**
     * Indicates event is happened successfully.
     */
    private boolean isSuccess;
    /**
     * parameter is needed for some events.
     */
    private T parameter;
    /**
     * If event does happened successfully, it explains why in terms of end user.
     * And also, this helps to log for each action.
     */
    private String informationMessage;
    /**
     * If event does not happened successfully, it explains why in terms of end user.
     * And also, this helps to log for each action.
     */
    private String errorMessage;
    /**
     * If event does not happened successfully, it explains why in terms of more technical user.
     * And also, this helps to log for each action.
     */
    private String innerExceptionMessage;
    /**
     * If event does not happened successfully, it includes exception message that explains
     * why in terms of more technical user.
     */
    private Exception exception;

    /**
     * If event is fail.
     * @param errorMessage
     * @param exception
     */
    public SeleniumEvent(String errorMessage, Exception exception){
        this.errorMessage = errorMessage;
        this.innerExceptionMessage = exception.toString();
        this.exception = exception;
        this.isSuccess = false;
    }

    /**
     * If event is success and has parameter to return, use it.
     * @param parameter
     * @param informationMessage
     */
    public SeleniumEvent(T parameter,String informationMessage) {
        this.parameter = parameter;
        this.informationMessage = informationMessage;
        this.isSuccess = true;
    }

    /**
     * If event is success without any parameter, use it.
     * @param informationMessage
     */
    public SeleniumEvent(String informationMessage){
        this.informationMessage = informationMessage;
        this.isSuccess = true;
    }


    public String getInformationMessage() {
        return informationMessage;
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

    public String getErrorMessage() {
        return errorMessage;
    }

    public Exception getException() {
        return exception;
    }
}
