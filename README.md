How to test React.js-powered WebUI with Katalon Studio
=====

# What is this repository?

This is a [Katalon Studio](https://www.katalon.com/) project for demonstration purpose.
You can clone this out onto you PC and execute it with your Katalon Stduio.

This demo project was developed using Katalon Studio version 5.4.2

This demo project was developed in the hope that it will solve a problem raised by a post in the Katalon Form: ["Does Katalon Studio support React.js Applications"](
https://forum.katalon.com/discussion/4391/does-katalon-studio-support-react-js-applications).

The original question was:
>Does katalon studio support react.js web applications?
Using selenium web driver we are finding it challenging to identify unique locators. Our application is built on react.js and was wondering if katalon studio supports react.js applications.

# About this demonstration

This katalon studio project executes a automated test against a React.js-powered application:

- https://react-table.js.org/#/story/simple-table

The test opens the URL in browser, find the table displayed, click a column labeled 'First name' to sort the rows, then tries to find expected data in the table.

![ReactTable - Simple Table demo](https://github.com/kazurayam/KatalonDiscussion4391/blob/master/docs/react-table_js_org_demo.png)

I hope that this demo project proves that you can test a web application powered by React.js using Katalon Studio.

## How to run the demo

1. git clone this project `KatalonDiscussion4391` to your local PC
2. open the project `KatalonDiscussion 4391` with Katalon Studio ver5.4 or higher.
3. load the test case `TC1`
4. run the test case `TC1` with your favorite Browser (Firefox or Chrome)
5. The test case clicks the `First Name` so that the rows of tables are sorted.
6. The test case tries to find a few expected fixture in the table rows. The test case records boolean result (Found or NotFound).   
7. The test case should run through to the end without significant processing error.
8. However the test case is likely to report FAILURE, which means the number of unfound data > 0. This is due to the odd behavior of the AUT: data displayed in the [Application Under Test](https://react-table.js.org/#/story/simple-table)'s Table changes all the time.



## What I have learned.

I am not familiar with React.js at all now (July 2018). This is my first experience of the React.js framework. Therefore I can not say anything definite about *how to test React.js-powered application using Katalon Studio*. All I can do is just to describe what I have done and found.

I want you to read the test case  [TC1](https://github.com/kazurayam/KatalonDiscussion4391/blob/master/Scripts/TC1/Script1532262700819.groovy) where you would find a few tips and tricks.

### dealing with nested &lt;iframe&gt;

The [Application Under Test](https://react-table.js.org/#/story/simple-table) contains 2 nested &lt;iframe&gt;. The test case [TC1](https://github.com/kazurayam/KatalonDiscussion4391/blob/master/Scripts/TC1/Script1532262700819.groovy) calls [WebUI.switchToFrame](https://docs.katalon.com/display/KD/%5BWebUI%5D+Switch+To+Frame) in order to switch the scope of DOM navigation.

### What is `Parent iframe` ?

One thing to be noted is that the Test Objects I made, for example [Object Repository/Page_React Table/iframe1components/iframe2components/div_ReactTable](https://github.com/kazurayam/KatalonDiscussion4391/blob/master/Object%20Repository/Page_React%20Table/iframe1components/iframe2components/div_ReactTable.rs) does NOT have parent object.

![No parent object](https://github.com/kazurayam/KatalonDiscussion4391/blob/master/docs/no_parent_iframe.png)

In the Test Objct's Settings UI I found an option named `Parent iframe`. I tried this opton on, then it did not work for me. So I descided not to use the `Parent iframe` option.

### waiting for elements present carefully

You can easily find that the test case [TC1](https://github.com/kazurayam/KatalonDiscussion4391/blob/master/Scripts/TC1/Script1532262700819.groovy) makes frequent call to WebUI.verifyElementPresent(). This is to wait for the documents in &lt;iframe&gt; to be loaded. It depends how long seconds it would take for document loading.

### Katalon's Recorder and Spy do not help

Once I tried Katalon's Recoder to auto-generate Test Objects which point parts of ReactTable. It generated many test objects, but I found these auto-generated stuff useless. I haven't spent long thinking about why. Just I created my Test Objects manually, one-by-one, specifying appropriate selectors by XPath and CSS Selectors while paying attention to `WebUI.switchToFrame()`  processing.

### Skill for Browser's DevTool, XPath, CSS selector needed

If you are going to test React.js-powered appliation, you should not expect Recorder and Spy to help you at all. The real testers should get well-trained themselves for the following 3 items:
- [Browser's DevTool, DOM viewer](https://developers.google.com/web/tools/chrome-devtools/inspect-styles/edit-dom?hl=en)
- [XPath](https://www.w3schools.com/xml/xpath_intro.asp)
- [CSS Selector](https://www.w3schools.com/cssref/css_selectors.asp)

### Katalon Studio is not concerned about the JavaScript frameworks

Katalon Studio runs on top of the Selenium WebDriver. WebDriver looks at DOM in Browser. DOM --- Document Object Model --- is what you can see in the Browsers DevTool's DOM Viewer. Katalon Studio and Selenium Webdriver --- they are not aware at all how the DOM is constructed with which JavaScript frameworks. Katalon Studio does not know jQuery, Angular, React at all. Katalon (= Selenium WebDriver) looks at DOM; that's all.

Therefore I think it is not appropriate to state "Katalon Studio supports React.js-powered application". No. Katalon knows nothing about React.js.

## Related discussions

1. https://forum.katalon.com/discussion/5236/possible-bug-with-web-object-spy-and-elements-in-iframe
