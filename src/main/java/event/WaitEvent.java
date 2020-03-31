package event;

import org.openqa.selenium.WebElement;

/**
 * @author sercansensulun on 14.03.2020.
 */
public class WaitEvent extends SeleniumEvent<WebElement> {


    public WaitEvent(String errorMessage, Exception exception) {
        super(errorMessage, exception);
    }

    public WaitEvent(WebElement parameter, String informationMessage) {
        super(parameter, informationMessage);
    }
}
