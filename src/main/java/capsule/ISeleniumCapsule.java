package capsule;

import action.ClickAction;
import action.EnterTextAction;
import action.GetTextAction;

/**
 * @author sercansensulun on 11.03.2020.
 */
public interface ISeleniumCapsule {

    ClickAction clickWithXpath(String xpath);
    EnterTextAction enterTextWithXpath(String text, String xpath);
    GetTextAction getTextWithXpath(String xpath);

}
