How to React.js-powered WebUI with Katalon Studio
=====

# What is this repository?

This is a [Katalon Studio](https://www.katalon.com/) project for demonstration purpose.
You can clone this out onto you PC and execute it with your Katalon Stduio.

This demo project was developed using Katalon Studio version 5.4.2

This demo project was developed in the hope that it will respond to a post in the Katalon Form: ["Does Katalon Studio support React.js Applications"](
https://forum.katalon.com/discussion/4391/does-katalon-studio-support-react-js-applications).

The original question was:
>Does katalon studio support react.js web applications?
Using selenium web driver we are finding it challenging to identify unique locators. Our application is built on react.js and was wondering if katalon studio supports react.js applications.

# About this demonstration

This katalon studio project executes a automated test against a React.js-powered application:

- https://react-table.js.org/#/story/simple-table

The test opens the URL in browser, find the table displayed, click a column labeled 'First name' to sort the rows, then tries to find expected data in the table.

![ReactTable - Simple Table demo](https://github.com/kazurayam/KatalonDiscussion4391/blob/master/docs/react-table_js_org_demo.png)

## How to run the demonstration

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
One thing to be noted is that the Test Object I made, for example [Object Repository/Page_React Table/iframe1components/iframe2components/div_ReactTable](https://github.com/kazurayam/KatalonDiscussion4391/blob/master/Object%20Repository/Page_React%20Table/iframe1components/iframe2components/div_ReactTable.rs) does Not have parent object.

![]()



### waiting for elements present carefully

### Katalon's Recorder and Spy do not help much

### need skill for Browser's DevTool, XPath, CSS selector

## Related discussions

https://forum.katalon.com/discussion/5236/possible-bug-with-web-object-spy-and-elements-in-iframe
