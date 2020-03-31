import capsule.SeleniumCapsule;
import event.ClickEvent;
import event.EnterTextEvent;
import event.GetTextEvent;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

/**
 * @author sercansensulun on 15.03.2020.
 */
public class TestGoogle {

    private SeleniumCapsule seleniumCapsule;

    @BeforeMethod
    public void beforeClass(){

        System.setProperty("webdriver.chrome.driver","PATH_OF_DRIVER");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.google.com/");
        seleniumCapsule = new SeleniumCapsule(driver,5);
    }

    @AfterMethod
    public void afterTest(){
        seleniumCapsule.closeBrowser();
    }

    @Test
    public void testClick(){

        ClickEvent clickEvent =
                seleniumCapsule.clickWithXpath("(//input[@name=\"btnI\"])[2]");
        Assert.assertTrue(clickEvent.isSuccess());

        //you can log these messages based on operation success.
        //clickEvent.getInformationMessage();
        //clickEvent.getErrorMessage();
        //clickEvent.getInnerExceptionMessage();
    }

    @Test
    public void testInvalidClick(){

        ClickEvent clickEvent =
                seleniumCapsule.clickWithXpath("(//input[@name=\"foo\"])[2]");
        Assert.assertTrue(!clickEvent.isSuccess());
        Assert.assertNotNull(clickEvent.getInnerExceptionMessage());
        Assert.assertTrue(!clickEvent.getInnerExceptionMessage().isEmpty());
        Assert.assertNotNull(clickEvent.getErrorMessage());
        Assert.assertTrue(!clickEvent.getErrorMessage().isEmpty());
    }

    @Test
    public void testEnterText(){

        EnterTextEvent enterTextEvent =
                seleniumCapsule.enterTextWithXpath("selenium", "//input[@type=\"text\"]");
        Assert.assertTrue(enterTextEvent.isSuccess());
    }

    @Test
    public void testInvalidEnterText(){

        EnterTextEvent enterTextEvent =
                seleniumCapsule.enterTextWithXpath("selenium", "//input[@type=\"foo\"]");
        Assert.assertTrue(!enterTextEvent.isSuccess());
        Assert.assertNotNull(enterTextEvent.getInnerExceptionMessage());
        Assert.assertTrue(!enterTextEvent.getInnerExceptionMessage().isEmpty());
        Assert.assertNotNull(enterTextEvent.getErrorMessage());
        Assert.assertTrue(!enterTextEvent.getErrorMessage().isEmpty());
    }

    @Test
    public void testGetText(){

        GetTextEvent getTextEvent =
                seleniumCapsule.getTextWithXpath("//a[text() = \"Gmail\"]");
        Assert.assertTrue(getTextEvent.isSuccess());
        Assert.assertEquals(getTextEvent.getParameter(), "Gmail");
    }

    @Test
    public void testInvalidGetText(){
        GetTextEvent getTextEvent =
                seleniumCapsule.getTextWithXpath("//a[text() = \"foo\"]");
        Assert.assertTrue(!getTextEvent.isSuccess());
        Assert.assertNull(getTextEvent.getParameter());
        Assert.assertNotNull(getTextEvent.getInnerExceptionMessage());
        Assert.assertTrue(!getTextEvent.getInnerExceptionMessage().isEmpty());
        Assert.assertNotNull(getTextEvent.getErrorMessage());
        Assert.assertTrue(!getTextEvent.getErrorMessage().isEmpty());
    }



}
