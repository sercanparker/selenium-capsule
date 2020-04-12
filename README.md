# selenium-capsule
Encapsulates selenium functionalities from pages or test suites.\
![Alt text](icon/selenium-capsule.png) 
## :information_desk_person: Installation
### Maven
```shell
<dependency>
  <groupId>com.selenium-capsule</groupId>
  <artifactId>selenium-capsule</artifactId>
  <version>1.0.0</version>
</dependency>
```
## :bow: Usage
```java
System.setProperty("webdriver.chrome.driver","PATH_OF_DRIVER");
WebDriver driver = new ChromeDriver();
driver.manage().window().maximize();
driver.get("https://www.google.com/");
seleniumCapsule = new SeleniumCapsule(driver,5);
```
 
