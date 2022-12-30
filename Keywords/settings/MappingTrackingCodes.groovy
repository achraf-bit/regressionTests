package settings

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import org.openqa.selenium.Keys as Keys
import internal.GlobalVariable

public class MappingTrackingCodes {

	@Keyword
	def addNewMappingTrackingCode() {
		WebUI.click(findTestObject('Object Repository/Home Page/Sidebar/button_Settings'))
		WebUI.click(findTestObject('Object Repository/Settings/Breadcumbs/button_My company'))
		WebUI.click(findTestObject('Object Repository/Settings/Mapping Tracking Codes Settings/button_Mapping tracking codes'))
		WebUI.waitForElementVisible(findTestObject('Object Repository/Settings/Dashboard/first input in dashboard'),0)
		WebUI.click(findTestObject('Object Repository/Settings/Dashboard/header/button_Add'))
		WebUI.waitForElementVisible(findTestObject('Object Repository/Settings/Mapping Tracking Codes Settings/input_Normalized psl code'), 0)
		WebUI.setText(findTestObject('Object Repository/Settings/Mapping Tracking Codes Settings/input_Normalized psl code'), 'test')
		WebUI.click(findTestObject('Object Repository/Settings/Mapping Tracking Codes Settings/input_Shipper'))
		WebUI.sendKeys(findTestObject('Object Repository/Settings/Mapping Tracking Codes Settings/input_Shipper'), Keys.chord(Keys.ENTER))
		WebUI.click(findTestObject('Object Repository/Settings/Mapping Tracking Codes Settings/input_Deviation Category'))
		WebUI.sendKeys(findTestObject('Object Repository/Settings/Mapping Tracking Codes Settings/input_Deviation Category'), Keys.chord(Keys.ENTER))
		WebUI.setText(findTestObject('Object Repository/Settings/Mapping Tracking Codes Settings/input_Descriptive carrier psl code'), 'test')
		WebUI.setText(findTestObject('Object Repository/Settings/Mapping Tracking Codes Settings/input_Carrier psl code'), '1')
		WebUI.click(findTestObject('Object Repository/Settings/Mapping Tracking Codes Settings/select_Event Type'))
		WebUI.sendKeys(findTestObject('Object Repository/Settings/Mapping Tracking Codes Settings/select_Event Type'), Keys.chord(Keys.DOWN))
		WebUI.sendKeys(findTestObject('Object Repository/Settings/Mapping Tracking Codes Settings/select_Event Type'), Keys.chord(Keys.ENTER))
		WebUI.click(findTestObject('Object Repository/Settings/Mapping Tracking Codes Settings/input_Carrier'))
		WebUI.sendKeys(findTestObject('Object Repository/Settings/Mapping Tracking Codes Settings/input_Carrier'), Keys.chord(Keys.ENTER))
		WebUI.setText(findTestObject('Object Repository/Settings/Mapping Tracking Codes Settings/input_Number of reason code'), '1')
		WebUI.setText(findTestObject('Object Repository/Settings/Mapping Tracking Codes Settings/input_Reason code'), 'test')
		WebUI.setText(findTestObject('Object Repository/Settings/Mapping Tracking Codes Settings/input_Descriptive reason code'), 'test')
		WebUI.click(findTestObject('Object Repository/Settings/Dashboard/button_Add'))
		WebUI.waitForElementVisible(findTestObject('Object Repository/Growl Notification/flash_Notice_Operation successfully completed'), 0,FailureHandling.CONTINUE_ON_FAILURE)
		WebUI.verifyElementVisible(findTestObject('Object Repository/Growl Notification/flash_Notice_Operation successfully completed'),FailureHandling.CONTINUE_ON_FAILURE)
		WebUI.waitForElementVisible(findTestObject('Object Repository/Settings/Dashboard/first input in dashboard'),0)
		WebUI.setText(findTestObject('Object Repository/Settings/Dashboard/first input in dashboard'),'test')
		WebUI.delay(3)
		WebUI.verifyElementVisible(findTestObject('Object Repository/Settings/Dashboard/first checkbox of the list'))
	}

	@Keyword
	def editMappingTrackingCode() {
		WebUI.click(findTestObject('Object Repository/Home Page/Sidebar/button_Settings'))
		WebUI.click(findTestObject('Object Repository/Settings/Breadcumbs/button_My company'))
		WebUI.click(findTestObject('Object Repository/Settings/Mapping Tracking Codes Settings/button_Mapping tracking codes'))
		WebUI.waitForElementVisible(findTestObject('Object Repository/Settings/Dashboard/first input in dashboard'),0)
		WebUI.setText(findTestObject('Object Repository/Settings/Dashboard/first input in dashboard'),'test')
		WebUI.delay(3)
		WebUI.click(findTestObject('Object Repository/Settings/Dashboard/first checkbox of the list'))
		WebUI.click(findTestObject('Object Repository/Settings/Dashboard/header/button_Edit'))
		WebUI.waitForElementVisible(findTestObject('Object Repository/Settings/Mapping Tracking Codes Settings/input_Normalized psl code'), 0)
		WebUI.setText(findTestObject('Object Repository/Settings/Mapping Tracking Codes Settings/input_Normalized psl code'), 'test2')
		WebUI.click(findTestObject('Object Repository/Settings/Mapping Tracking Codes Settings/input_Shipper'))
		WebUI.sendKeys(findTestObject('Object Repository/Settings/Mapping Tracking Codes Settings/input_Shipper'), Keys.chord(Keys.DOWN))
		WebUI.sendKeys(findTestObject('Object Repository/Settings/Mapping Tracking Codes Settings/input_Shipper'), Keys.chord(Keys.ENTER))
		WebUI.click(findTestObject('Object Repository/Settings/Mapping Tracking Codes Settings/input_Deviation Category'))
		WebUI.sendKeys(findTestObject('Object Repository/Settings/Mapping Tracking Codes Settings/input_Deviation Category'), Keys.chord(Keys.DOWN))
		WebUI.sendKeys(findTestObject('Object Repository/Settings/Mapping Tracking Codes Settings/input_Deviation Category'), Keys.chord(Keys.ENTER))
		WebUI.setText(findTestObject('Object Repository/Settings/Mapping Tracking Codes Settings/input_Descriptive carrier psl code'), 'test2')
		WebUI.setText(findTestObject('Object Repository/Settings/Mapping Tracking Codes Settings/input_Carrier psl code'), '2')
		WebUI.click(findTestObject('Object Repository/Settings/Mapping Tracking Codes Settings/select_Event Type'))
		WebUI.sendKeys(findTestObject('Object Repository/Settings/Mapping Tracking Codes Settings/select_Event Type'), Keys.chord(Keys.DOWN))
		WebUI.sendKeys(findTestObject('Object Repository/Settings/Mapping Tracking Codes Settings/select_Event Type'), Keys.chord(Keys.ENTER))
		WebUI.click(findTestObject('Object Repository/Settings/Mapping Tracking Codes Settings/input_Carrier'))
		WebUI.sendKeys(findTestObject('Object Repository/Settings/Mapping Tracking Codes Settings/input_Carrier'), Keys.chord(Keys.DOWN))
		WebUI.sendKeys(findTestObject('Object Repository/Settings/Mapping Tracking Codes Settings/input_Carrier'), Keys.chord(Keys.ENTER))
		WebUI.setText(findTestObject('Object Repository/Settings/Mapping Tracking Codes Settings/input_Number of reason code'), '2')
		WebUI.setText(findTestObject('Object Repository/Settings/Mapping Tracking Codes Settings/input_Reason code'), 'test2')
		WebUI.setText(findTestObject('Object Repository/Settings/Mapping Tracking Codes Settings/input_Descriptive reason code'), 'test2')
		WebUI.click(findTestObject('Object Repository/Settings/Dashboard/button_Update'))
		WebUI.waitForElementVisible(findTestObject('Object Repository/Growl Notification/flash_Notice_Operation successfully completed'), 0 ,FailureHandling.CONTINUE_ON_FAILURE)
		WebUI.verifyElementVisible(findTestObject('Object Repository/Growl Notification/flash_Notice_Operation successfully completed'),FailureHandling.CONTINUE_ON_FAILURE)
		WebUI.waitForElementVisible(findTestObject('Object Repository/Settings/Dashboard/first input in dashboard'),0)
		WebUI.setText(findTestObject('Object Repository/Settings/Dashboard/first input in dashboard'),'test2')
		WebUI.delay(3)
		WebUI.verifyElementVisible(findTestObject('Object Repository/Settings/Dashboard/first checkbox of the list'))
	}

	@Keyword
	def deleteMappingTrackingCode(){
		WebUI.click(findTestObject('Object Repository/Home Page/Sidebar/button_Settings'))
		WebUI.click(findTestObject('Object Repository/Settings/Breadcumbs/button_My company'))
		WebUI.click(findTestObject('Object Repository/Settings/Mapping Tracking Codes Settings/button_Mapping tracking codes'))
		WebUI.waitForElementVisible(findTestObject('Object Repository/Settings/Dashboard/first input in dashboard'),0)
		WebUI.setText(findTestObject('Object Repository/Settings/Dashboard/first input in dashboard'),'test2')
		WebUI.delay(3)
		WebUI.click(findTestObject('Object Repository/Settings/Dashboard/first checkbox of the list'))
		WebUI.click(findTestObject('Object Repository/Settings/Dashboard/header/button_Delete'))
		WebUI.click(findTestObject('Object Repository/Settings/Modal/button_Yes'))
		WebUI.waitForElementVisible(findTestObject('Object Repository/Settings/Dashboard/first input in dashboard'),0)
		WebUI.setText(findTestObject('Object Repository/Settings/Dashboard/first input in dashboard'),'test2')
		WebUI.delay(3)
		WebUI.verifyElementNotPresent(findTestObject('Object Repository/Settings/Dashboard/first checkbox of the list'),0)
	}
}
