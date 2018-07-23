import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import org.openqa.selenium.By
import org.openqa.selenium.WebElement

import com.kms.katalon.core.logging.KeywordLogger
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webui.driver.DriverFactory
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

KeywordLogger logger = new KeywordLogger()

WebUI.openBrowser('')
WebUI.navigateToUrl('https://react-table.js.org/#/story/simple-table')

// make sure that the default contents to be present
WebUI.verifyElementPresent(findTestObject(
	'Page_React Table/div_root'), 10)

// wait for the top <iframe> to be present
WebUI.verifyElementPresent(findTestObject(
	'Page_React Table/iframe1'), 10)

// switch into the top <iframe>
WebUI.switchToFrame(findTestObject(
	'Page_React Table/iframe1'), 10)

// wait for the contents in the top <iframe> to be present
WebUI.verifyElementPresent(findTestObject(
	'Page_React Table/iframe1components/div_root'), 30)

// switch into the nested <iframe>
WebUI.verifyElementPresent(findTestObject(
	'Page_React Table/iframe1components/iframe2'), 10)

WebUI.switchToFrame(findTestObject(
	'Page_React Table/iframe1components/iframe2'), 10)

WebUI.verifyElementPresent(findTestObject(
	'Page_React Table/iframe1components/iframe2components/div_root'), 30)

// Now I can get access to the ReactTable
WebUI.verifyElementPresent(findTestObject(
	'Page_React Table/iframe1components/iframe2components/div_ReactTable'), 10)


// click the "First Name" to sort rows in ascending order
WebUI.verifyElementPresent(findTestObject(
	'Page_React Table/iframe1components/iframe2components/div_ReactTable_columnLabel_First Name'), 10)
WebUI.click(findTestObject(
	'Page_React Table/iframe1components/iframe2components/div_ReactTable_columnLabel_First Name'))

// my test fixture
def fixture = [
	['ability',  'wool',      '28', 'complicated' , '38' ],
	['able',     'cup',       '12', 'complicated' , '45' ],
	['accident', 'marketing', '0' , 'relationship', '40' ]
]

def driver = DriverFactory.getWebDriver()

// grab list of <div class="rt-tr-group"> as rows of the ReactTable
List<WebElement> rows = driver.findElements(By.cssSelector('.ReactTable .rt-table .rt-tbody .rt-tbody div.rt-tr-group'))

// test if each fixture record is found in the rows
def failureCount = 0
for (List<String> record : fixture) {
	def firstName = record[0]
	def lastName  = record[1]
	def age       = record[2]
	def status    = record[3]
	def visits    = record[4]
	//
	boolean found = false
	for (int i = 0; i < rows.size(); i++) {
		WebElement row = rows[i]
		List<WebElement> columns = row.findElements(By.cssSelector('div.rt-td'))
		if (columns[0] == firstName &&
			columns[1] == lastName  &&
			columns[2] == age       &&
			columns[3] == status    &&
			columns[4] == visits      ) {
			found = true
			WebUI.comment("${columns[0]}/${columns[1]}/${columns[2]}/${columns[3]}/${columns[4]} is found")
			break
		}
	}
	if (!found) {
		failureCount += 1
		logger.logFailed("${firstName}/${lastName}/${age}/${status}/${visits} is NOT found")
	}
}

// go back to the top level contents
WebUI.switchToDefaultContent()

// Well done!
WebUI.closeBrowser()

// mark failure
if (failureCount > 0) {
	KeywordUtil.markFailed("${failureCount} failures")
}


