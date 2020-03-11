package action;

/**
 * @author sercansensulun on 11.03.2020.
 */
public class GetTextAction extends SeleniumAction<String> {
    public GetTextAction(String parameter) {
        super(parameter);
    }

    public GetTextAction(String exceptionMessage, String innerExceptionMessage) {
        super(exceptionMessage, innerExceptionMessage);
    }
}
