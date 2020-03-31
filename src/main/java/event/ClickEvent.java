package event;

/**
 * @author sercansensulun on 11.03.2020.
 */
public class ClickEvent extends SeleniumEvent {

    public ClickEvent(String informationMessage){
        super(informationMessage);
    }

    public ClickEvent(String errorMessage, Exception exception) {
        super(errorMessage, exception);
    }

}
