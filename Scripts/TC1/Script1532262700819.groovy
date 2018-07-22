import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.checkpoint.CheckpointFactory as CheckpointFactory
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as MobileBuiltInKeywords
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testcase.TestCaseFactory as TestCaseFactory
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testdata.TestDataFactory as TestDataFactory
import com.kms.katalon.core.testobject.ObjectRepository as ObjectRepository
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WSBuiltInKeywords
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUiBuiltInKeywords
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys

WebUI.openBrowser('')

WebUI.navigateToUrl('https://react-table.js.org/#/story/simple-table')

//WebUI.click(findTestObject('Page_React Table - A lightweight fa/img'))

WebUI.verifyElementPresent(findTestObject('Page_React Table - A lightweight fa/div_foot'), 10, FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('Page_React Table - A lightweight fa/div_foot'))

WebUI.click(findTestObject('Page_React Table - A lightweight fa/div_sheet'))

WebUI.click(findTestObject('Page_React Table - A lightweight fa/div_2'))

WebUI.click(findTestObject('Page_React Table - A lightweight fa/div_relationship'))

WebUI.click(findTestObject('Page_React Table - A lightweight fa/div_22'))

WebUI.click(findTestObject('Page_React Table - A lightweight fa/div_Name'))

WebUI.click(findTestObject('Page_React Table - A lightweight fa/div_Info'))

WebUI.click(findTestObject('Page_React Table - A lightweight fa/div_Stats'))

WebUI.click(findTestObject('Page_React Table - A lightweight fa/div_React-Table - Simple Table'))

WebUI.closeBrowser()

