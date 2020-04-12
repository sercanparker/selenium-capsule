# selenium-capsule
Encapsulates selenium functionalities from pages or test suites.\
![Alt text](icon/selenium-capsule.png) 
## :information_desk_person: Installation
### Maven
check here : https://github.com/sercanparker/selenium-capsule/packages/180938
```xml
<dependency>
  <groupId>com.selenium-capsule</groupId>
  <artifactId>selenium-capsule</artifactId>
  <version>1.0.0</version>
</dependency>
```
## :bow: Usage
check here : https://github.com/sercanparker/selenium-capsule/blob/master/src/test/java/TestGoogle.java
```java
System.setProperty("webdriver.chrome.driver","PATH_OF_DRIVER");
WebDriver driver = new ChromeDriver();
driver.manage().window().maximize();
driver.get("https://www.google.com/");
seleniumCapsule = new SeleniumCapsule(driver,5);
```

```java
ClickEvent clickEvent = seleniumCapsule.clickWithXpath("(//input[@name=\"btnI\"])[2]");
Assert.assertTrue(clickEvent.isSuccess());
//you can log these messages based on operation success.
//clickEvent.getInformationMessage();
//clickEvent.getErrorMessage();
//clickEvent.getInnerExceptionMessage();
```

```java
EnterTextEvent enterTextEvent = seleniumCapsule.enterTextWithXpath("selenium", "//input[@type=\"foo\"]");
Assert.assertTrue(!enterTextEvent.isSuccess());
Assert.assertNotNull(enterTextEvent.getInnerExceptionMessage());
Assert.assertTrue(!enterTextEvent.getInnerExceptionMessage().isEmpty());
Assert.assertNotNull(enterTextEvent.getErrorMessage());
Assert.assertTrue(!enterTextEvent.getErrorMessage().isEmpty());
```

```java
GetTextEvent getTextEvent = seleniumCapsule.getTextWithXpath("//a[text() = \"Gmail\"]");
Assert.assertTrue(getTextEvent.isSuccess());
Assert.assertEquals(getTextEvent.getParameter(), "Gmail");
```


 
