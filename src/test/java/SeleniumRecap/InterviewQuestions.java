package SeleniumRecap;

public class InterviewQuestions {

    /*
1 - What are the advantages and disadvantages of Selenium?

    Advantages: *Free resources
                *Supports multi languages
                *Has big community
    Disadvantages: *You cannot automate captcha, pics ,mobile apps
                   *no customer service
                   *It automates only web apps
                   *It doest have any system to generate reports
                    we use testNG cucumber etc

2 - What type of testing can you automate with selenium?

    *Regression
    *Smoke
    *Functional testing (positive and negative testing)

3 - What are the text types we do not automate with Selenium?

    *Performance testing (Jmeter --> its not hard to learn)
    *Manual Testing (Captcha , Pics )
    *Non-Functional Testing (stress testing , loading testing , performance
    *Adhoc testing  ( random testing ) monkey testing same thing  both are manual

4 - What are locator in Selenium? What types of locators do you use in your framework?

    --> Locator it is a way to find element/s from DOM (development tool/page)
        Locators that im using in my framework are:
        --> ID --> finds element with ID attribute
        --> Name --> finds e with Name attribute
        --> ClassName --> finds e with a ClassName attribute
        -->  TagName --> finds e with a TagName
        --> LinkText --> finds e with "a" tagName and "text"
        --> PartialLikText --> finds e with 'a' tagName and "partialText' or fullText
        --> css --> finds e with a css. --> for if (#) and for class(.)
        --> Xpath --> finds e with xPath

5 - (cvs) How do you handle dynamic elements in UI automation ?

    --> In my project I faced many dynamic elements during automation :
        --> To handle this issue I did :
            --> I used parent child relationship for the elements
            --> I used different ways to locate element like following, preceding, contains) *
            --> I found element with a different attribute witch are not equal

6 - Difference between driver.get and driver.navigate?

    --> Navigate() --> It doesn't wait WebElements to be loaded from the page. It waits for only specific elements
                       you are looking for.
                   --> It has methods: to , refresh , back ,forward

    --> Get() --> It waits all the web elements from page to be loaded
              --> It does not have any methods.

7 - Difference between driver.close and driver.quit?

    --> Driver.close --> It specifically closes the window that your driver is pointing
                         * It closes only 1 tab
    --> Driver.quit --> It closes all tabs opened during the automation

8 - What is Xpath and can you tell me about types of Xpath? Witch one do you use the most?
8.1 - What is a difference between Absolute and Relative?
    --> Xpath its one of the locators in Selenium I use to find the element?

        There are 2 types of xPath:
        1 - Absolute -->  it goes all the way from top (html) to child
                          it starts with a single /

        2 - Relative --> it goes directly to child or parent child
                     -->  it starts with a //

                          -Relative Xpath
                              __xpathMethods
                             -->//tagNAme[@attribute='attribute value'];
                             -->//tagName[contains(text(),'TextValue')];
                             -->//tagName[.='TextValue'];
                              -->//tagName[contains(@attribute name,'attribute value')];
                              -->//a[.='terms of service']//following-sibling::input --> following sibling
                              -->//a[.='terms of service']//preceding-sibling::input --> preceding sibling

    --> I use definitely relativeXpath since its more functional and effective to locate the element

9 - How do you handle dropDowns? (static or dynamic)

    --> In my project I was handling the drop-downs with a different ways:
        --> I would definitely check tag of the webElement(location)
            IF --> location has SELECT tagName then I use SELECT class. Select select = new Select (element location)
            IF --> location doesn't have SELECT tagName then I can use :
                    --> Actions class methods like click or WebEElement methods click and choose
                    --> I would send sendKeys() to choose the option

10  - Can you tell me what do you know about select class and its methods ?

        Select class it is a way to handle dropDowns:
            --> It is really usefully for my project. It must have Select tagName.
            Methods:
            elect select = new Select (element location)
            select.selectByVisibleText
            select.selectByValue
            select.selectByIndex --> not recommender
            select.getFirstSelectedOption  --> return String
            select.getOptions --> will give you all options --> List<String>

11 - What kind of Exception have you faced in your Automation Framework?

    --> NoSuchElementException
    --> StaleElementReferenceException
    --> ElementInterceptedException
    --> ElementIsNotIntractableException
    --> NoSuchWindowException
    --> NoSuchFrameException
    --> TestNG
    --> InvalidSelector
    --> TimeOutException

12 - How do you handle StaleElementReferenceException

    In my project this exception in one of the hard ones that giving me a headache
    --> This exception happens when:  *dom is not updating fast
                                      *dom element value is changed
                                      *the page is refreshed

    --> WaitTimes might solve this issue
        --> Thread.sleep or Explicitly.wait with condition
     ** --> reassign or reinitialize the webElement
        --> refresh

13 - How do you handle popups:
13.1 - Can you tell me methods that you hande JS alert
     There are different types of popUps I faced during automation:
    --> OS popup --> We cannot handle it directly with Selenium
    --> HTML popUp --> I just need to find element and click on it OK or Cancel
    --> JS popUp --> I handle it with alert interface

    Alert alert = driver.switchTi.Alert
    alert.accept --> clicks OK
    alert.dismiss --> click cancel
    alert.getText --> getting text
    alert.sendKeys --> sends key

14 - What do you know about iFrame ? How do you handle this in your automation?

    --> iFrame is html inside of html
    --> it is used for protection purposes
    --> Widely used for adds , videos , documentation

    --> First need to switch your frame based on value of your webElement;
        --> driver.switchTo.frame(id, name)
        --> driver.switchTo.frame(WebElement)
        --> driver.switchTo.frame(index)
        --> driver.switchTo.ParentFrame  --> going to parent frame
        --> driver.switchTo.defaultContent --> going to main html no matter from what level if nested

    NOTE: If you do not handle this iFrame you will get NoSuchElementException
    NOTE: if the value of the switch frame is wrong you will get NoSuchFrameException

15 - What do you know about Actions class? Can you tell me methods you use the most during the automation?

    Action class basically does the functionality of mouse it is really usefully in my automation
    to handle some elements. Methods are:

  **--> contextClick --> right click on the webElement
    --> DoubleClick
    --> DragAndDrop --> from one spot to another
    --> clickAndHold --> clicks and hold
    --> MoveToElement -->  it hover over the element
    --> release --> it releases  element you holds
    --> click
    --> sendKeys ()
 ***--> perform --> it performs action methods. Without it will not work

16 - What is a difference between driver.findElement/s ?

    Find element:  --> driver.findElement By locator
                   --> return single webElement
                   --> if fails : noSuchElement
    Find elements: --> driver.findElements By locator
                   --> returns List<WebElement>
                   --> if fails return empty list

17 - Can you tell me some drier and webElement methods you use during the automation mostly?

    Driver Methods: * get() *navigate() * getTitle() * getCurrentUrl()
                    * switchTo() * quit() * close() * GetWindowHandle/s () * Manage()

    WebElement Methods: * click() * sendKeys() * getText() * isDisplayed()
                        * isSelected() * getCssValue() * clear() * submit()* getAttribute()


18 - What is a difference between checkBox and radioButton?

    checkBox --> you can click multiple boxed with your button
    radioButton -->  you can choose only one. (circle)

19 - How do you handle multiple windows in automation? And what is a difference between getWindowHandle/s?

    To be able to handle windows:

    I need to switch my driver to specific window with my logic.

    Set<String> allWindows = driver.getWindowHandles();
    for(String pageID : allWindows ){
    driver.switchTo.Window(PageID);
    if(driver.getTitle.contains(expectedTitle)}
    break;

    1 - Use windowHandles to store all pages ID
    2 - Loop through all pages and switch
    3 - Break the loop when title is what im looking for

NOTE: getWindowHandle --> returns String single page ID
      getWindowHandles --> returns Set<String> with all unique pages IDs

20 - How do you scroll down or up in WebBrowser during the automation?

 ***--> I mostly use JS scrollIntoView script(I store it in my BrowserUtils for anytime usage)
    --> Actions.scrollByAmount (x,y)
    --> Keys.PageUp or Down --> all the way up or down
    --> Keys.ArrowUp or Down --> scroll by a little

21 - How do you upload file in Selenium.

    --> Fist of all you need to find a location of choose button.
    --> Find path of file that you're going to upload //c:desktop/file.png
    --> Send keys of the location to the choose button

22 - What is a difference between Asser and SoftAsser ?

    Assert: is a class that has some methods to validate actual and expected data
    Assert.assertEquals, assertTrue, asserFalse
    When it fails it throws exception right the way and stop executing code

    Soft Assert: class that has some methods and validate actual and expected data
    We need to create an object
    SoftAsser softAssert = new SoftAssert();
    When it fails it does not throw and exception and keeps executing next code
    ***You must use AssertAll() to make it work properly otherwise it will pass all the time

23 - Can you tell me about your Singleton Pattern Design? Can you make a constructor private, static, final?

    First of all I appreciate for this question since i sile singleton logic because in the past I was working on my driver and getting load
    of NULL POINTER exception. With the help of Singleton I centralized my driver with reduced the amount of exception
     I got with mean it is more reliable and safe to use

     --> I basically Encapsulate my Singleton

        --> I need to have a private WebDriver;
        --> I need to have Private Constructor
        --> Put if condition to check my driver is NULL or not
        --> create a public method to call from other class

24 - What kind of TestNG annotation do you use in you project? Can you tell me hat is purpose of the @Parameter

25 - What do you know about @DataProvider and why do you use it ?

26 - Wait do you know about WaitTimes and can you tell me the difference between Thread.speed , Implicitly-Explicitly-Fluent wait?















     NOTE: if you do not handle this iframe, you will get NOSUCHELEMENT exception
     NOTE:if the value








































     */
}
