package event;

/**
 * @author sercansensulun on 11.03.2020.
 */
public class GetTextEvent extends SeleniumEvent<String> {

    public GetTextEvent(String errorMessage, Exception exception) {
        super(errorMessage, exception);
    }

    public GetTextEvent(String parameter, String informationMessage) {
        super(parameter, informationMessage);
    }

    public GetTextEvent(String informationMessage) {
        super(informationMessage);
    }
}
