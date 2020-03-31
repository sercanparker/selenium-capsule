package capsule;

import constant.InfoMessage;
import event.ClickEvent;
import event.EnterTextEvent;
import event.GetTextEvent;
import event.WaitEvent;
import constant.ErrorMessage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * @author sercansensulun on 11.03.2020.
 */
public class SeleniumCapsule implements ISeleniumCapsule{

    private WebDriver driver;
    private WebDriverWait wait;


    public SeleniumCapsule(WebDriver driver, long waitTimeoutInSeconds){
        this.driver = driver;
        this.wait = new  WebDriverWait(getDriver(), waitTimeoutInSeconds);
    }

    public WebDriver getDriver() {
        return driver;
    }


    /**
     * Clicks to web element that is found by given xpath.
     * @param xpath
     * @return
     * @see ClickEvent
     */
    public ClickEvent clickWithXpath(String xpath) {
        WaitEvent waitEvent = waitUntilClickableWithXpath(xpath);
        if (!waitEvent.isSuccess()){
            return new ClickEvent(waitEvent.getErrorMessage(), waitEvent.getException());
        }
        WebElement webElement = waitEvent.getParameter();
        webElement.click();
        return new ClickEvent(String.format(InfoMessage.CLICKED, xpath));
    }

    /**
     * Enters the text to web element that is found by given xpath.
     * @param text
     * @param xpath
     * @return
     * @see EnterTextEvent
     */
    public EnterTextEvent enterTextWithXpath(String text, String xpath) {
        WaitEvent waitEvent = waitUntilClickableWithXpath(xpath);
        if (!waitEvent.isSuccess()){
            return new EnterTextEvent(waitEvent.getErrorMessage(), waitEvent.getException());
        }
        WebElement webElement = waitEvent.getParameter();
        webElement.click();
        webElement.clear();
        webElement.sendKeys(text);
        return new EnterTextEvent(String.format(InfoMessage.TEXT_ENTERED, text,xpath));
    }

    /**
     * Gets the text located on web element that is found by given xpath.
     * @param xpath
     * @return
     * @see GetTextEvent
     */
    public GetTextEvent getTextWithXpath(String xpath) {
        WaitEvent waitEvent = waitUntilVisibleWithXpath(xpath);
        if (!waitEvent.isSuccess()){
            return new GetTextEvent(waitEvent.getErrorMessage(), waitEvent.getException());
        }
        WebElement webElement = waitEvent.getParameter();
        String text = webElement.getText();
        return new GetTextEvent(text, String.format(InfoMessage.TEXT_RETREIVED, text, xpath));
    }

    /**
     * Close current browser.
     */
    @Override
    public void closeBrowser() {
        getDriver().close();
    }

    /**
     * Sleeps until given parameter.
     * @param milliseconds
     */
    @Override
    public void sleep(long milliseconds) throws InterruptedException {
        Thread.sleep(milliseconds);
    }

    /**
     * Waits until web element that is found by given xpath is clickable.
     * @param xpath
     * @return
     * @see WaitEvent
     */
    private WaitEvent waitUntilClickableWithXpath(String xpath){
        try {
            WebElement webElement = this.wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
            if (webElement == null){
                return new WaitEvent(String.format(ErrorMessage.WAIT_UNTIL_CLICKABLE, xpath),
                        new Exception(String.format(ErrorMessage.WAIT_UNTIL_CLICKABLE, xpath)));
            }
            return new WaitEvent(webElement, null);
        }catch (Exception e){
            return new WaitEvent(String.format(ErrorMessage.WAIT_UNTIL_CLICKABLE, xpath), e);
        }
    }

    /**
     * Waits until web element that ıs found by given xpath is visible.
     * @param xpath
     * @return
     * @see WaitEvent
     */
    private WaitEvent waitUntilVisibleWithXpath(String xpath){
        try {
            WebElement webElement = this.wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
            if (webElement == null){
                return new WaitEvent(String.format(ErrorMessage.WAIT_UNTIL_VISIBLE, xpath),
                        new Exception(String.format(ErrorMessage.WAIT_UNTIL_VISIBLE, xpath)));
            }
            return new WaitEvent(webElement, null);
        }catch (Exception e){
            return new WaitEvent(String.format(ErrorMessage.WAIT_UNTIL_VISIBLE, xpath), e);
        }
    }


}
