package com.WebAutomationProject.SeleniumBasic;

public class ex_013_Locators {

    //Locators are used in Selenium to find and interact with web elements
    // (like buttons, input fields, links, etc.) on a web page.

    // Locator are static method of by class
    // there are 8 type locators


    // Locators //
    // Id    driver.findElement(By.id("value"));
    // name
    // className
    // TagName
    // link text
    // partial link text
    // Css selector
    // xpath


    // xpath
    // XPath (XML Path Language) is a query language used to locate nodes in XML documents.
    // Selenium uses XPath to locate elements in a HTML DOM structure
    // there are two type of xpath

    // Absolute xpath

    // Absolute xpath is full xpath
    // it start from the root node and goes down to the element step by step
    // fox ex : -  html/header/body/div/form/input
    // it start with single forward slash
    // it time-consuming and lengthen
    // it Breaks easily if there is any UI or DOM change

    // relative xpath

    // relative xpath start from the double forward slash //
    // relative xpath is short focuses on specific elements or attributes
    // A path that starts from anywhere in the DOM, not necessarily from root
    // it save the dime
    // we can handle dynamic element
    // it provides multiple method to find the webElement.
    // //input[@id='value']

    // method of relative xpath
    // with attribute
    // //input[@id='value']
    // Multiple attribute
    // //img[@attr1='value1' and @attr2='value2']

    // with text function

    //contains function : - Matches partial attribute or text value
    // //input[contains(@id,'value')];
    // //input[contains(text(),'text')]

    //Start-with (like other end-wth() sub-string())
    //Matches beginning of a value

    //input[starts-with(@id,'startValue')]
    //button[starts-with(text(), 'Log')]

    //normalized-space
    //Ignores extra whitespaces before/after text.
    //Button[normalized-space(text()=text)]
    //input[normalized-space(@placeholder)=' Copy me ']

    // xpath with index
    // div[@id='value'][1]

    //*[id='value']: -  * is used to from the all the Elements


    // and and or condition
    //button[@id="btn-login" and @type="submit"]
    //button[@id="btn-login" or @class="btn btn-primary btn-s-wide"]

    /*  Xpath axis
    // for your information > it is used in Web tables, Forms

       in the XML document,
       we have relationship between various nodes to locate those nodes in the dom structure

        Ancestor
       //div[@class="Mammal"]/ancestor::div

        Child
       //div[@class="Mammal"]/child::div

        Following-sibling
       //div[@class="Mammal"]/following-sibling::div

       Preceding-sibling
       //div[@class="Mammal"]/preceding-sibling::div

       Parent
       //div[@class="Mammal"]/parent::div

       Descendant
       //div[@class="Mammal"]/descendant::div


      CSS Selector
      A CSS selector is a pattern used to select HTML elements
      based on their tag name, id, class, attributes, or position in the page

       Syntax	Example	Description
        Attribute Selectors
       [attr]	input[required]	Elements with required attribute
       [attr="value"]	input[type="text"]	Attribute equals value
       [attr^="val"]	a[href^="https"]	Starts with "https"
       [attr$="val"]	img[src$=".png"]	Ends with ".png"
       [attr*="val"]	input[name*="user"]	Contains "user"

      Selector	   Syntax	   Example	   Matches
      Universal	   *	             *	   All elements
            Tag	   tagname	       div     All <div> elements
             ID	   #id	     #loginBtn	   Element with id="loginBtn"
          Class	   .class	      .btn	   Elements with class="btn"

       | Symbol      | Meaning          | Example   | Description                      |
| ----------- | ---------------- | --------- | -------------------------------- |
| ` ` (space) | Descendant       | `div p`   | `<p>` inside `<div>` (any level) |
| `>`         | Direct child     | `ul > li` | `<li>` directly inside `<ul>`    |
| `+`         | Adjacent sibling | `h1 + p`  | `<p>` immediately after `<h1>`   |
| `~`         | General sibling  | `h1 ~ p`  | All `<p>` siblings after `<h1>`  |



//  https://devhints.io/xpath  < this is the cheat sheet for all the xpath



    * */

}
