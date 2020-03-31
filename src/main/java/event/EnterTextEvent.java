package event;

/**
 * @author sercansensulun on 11.03.2020.
 */
public class EnterTextEvent extends SeleniumEvent {


    public EnterTextEvent(String errorMessage, Exception exception) {
        super(errorMessage, exception);
    }

    public EnterTextEvent(String informationMessage) {
        super(informationMessage);
    }
}
