package action;

/**
 * @author sercansensulun on 11.03.2020.
 */
public class ClickAction extends SeleniumAction {
    public ClickAction(Object parameter) {
        super(parameter);
    }

    public ClickAction(String exceptionMessage, String innerExceptionMessage) {
        super(exceptionMessage, innerExceptionMessage);
    }
}
