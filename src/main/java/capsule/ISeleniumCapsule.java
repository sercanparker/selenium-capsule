package capsule;

import event.ClickEvent;
import event.EnterTextEvent;
import event.GetTextEvent;

/**
 * @author sercansensulun on 11.03.2020.
 */
public interface ISeleniumCapsule {

    ClickEvent clickWithXpath(String xpath);
    EnterTextEvent enterTextWithXpath(String text, String xpath);
    GetTextEvent getTextWithXpath(String xpath);
    void closeBrowser();
    void sleep(long milliseconds) throws InterruptedException;

}
