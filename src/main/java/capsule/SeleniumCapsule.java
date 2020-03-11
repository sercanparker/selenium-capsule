package capsule;

import action.ClickAction;
import action.EnterTextAction;
import action.GetTextAction;
import org.openqa.selenium.WebDriver;

/**
 * @author sercansensulun on 11.03.2020.
 */
public class SeleniumCapsule implements ISeleniumCapsule{

    private WebDriver driver;

    public SeleniumCapsule(WebDriver driver){
        this.driver = driver;
    }

    public WebDriver getDriver() {
        return driver;
    }


    /**
     * Clicks to web element that is found by given xpath.
     * @param xpath
     * @return
     * @see ClickAction
     */
    public ClickAction clickWithXpath(String xpath) {
        return null;
    }

    /**
     * Enters the text to web element that is found by given xpath.
     * @param text
     * @param xpath
     * @return
     * @see EnterTextAction
     */
    public EnterTextAction enterTextWithXpath(String text, String xpath) {
        return null;
    }

    /**
     * Gets the text located on web element that is found by given xpath.
     * @param xpath
     * @return
     * @see GetTextAction
     */
    public GetTextAction getTextWithXpath(String xpath) {
        return null;
    }
}
