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

public class ConfigurationField {
	@Keyword
	def addConfigurationField() {
		WebUI.click(findTestObject('Object Repository/Home Page/Sidebar/button_Settings'))
		WebUI.click(findTestObject('Object Repository/Settings/Breadcumbs/button_My company'))
		WebUI.click(findTestObject('Object Repository/Settings/Configuration Field Settings/button_Configuration Field'))
		WebUI.waitForElementVisible(findTestObject('Object Repository/Settings/Configuration Field Settings/input_Configuration Filed name in Dashboard'),0)
		WebUI.click(findTestObject('Object Repository/Settings/Dashboard/header/button_Add'))
		WebUI.waitForElementVisible(findTestObject('Object Repository/Settings/Configuration Field Settings/input_Name FR'), 0)
		WebUI.setText(findTestObject('Object Repository/Settings/Configuration Field Settings/input_Name FR'), 'test1')
		WebUI.setText(findTestObject('Object Repository/Settings/Configuration Field Settings/input_Name EN'), 'test1')
		WebUI.click(findTestObject('Object Repository/Settings/Configuration Field Settings/input_Concatenate values in consolidation Yes'))
		WebUI.click(findTestObject('Object Repository/Settings/Configuration Field Settings/input_Dropdown list Yes'))
		WebUI.waitForElementVisible(findTestObject('Object Repository/Settings/Configuration Field Settings/input_Possible values'),0)
		WebUI.setText(findTestObject('Object Repository/Settings/Configuration Field Settings/input_Possible values'),'test1')
		WebUI.sendKeys(findTestObject('Object Repository/Settings/Incident Category Settings/input_Sub category'), Keys.chord(Keys.ENTER))
		WebUI.setText(findTestObject('Object Repository/Settings/Configuration Field Settings/textarea_Description'), 'test1')
		WebUI.setText(findTestObject('Object Repository/Settings/Configuration Field Settings/input_Setting type'), 'test1')
		WebUI.setText(findTestObject('Object Repository/Settings/Configuration Field Settings/textarea_Help text'),'test1')
		WebUI.setText(findTestObject('Object Repository/Settings/Configuration Field Settings/input_Default value'),'test1')
		WebUI.setText(findTestObject('Object Repository/Settings/Configuration Field Settings/input_Column size'),'1')
		WebUI.setText(findTestObject('Object Repository/Settings/Configuration Field Settings/input_Priority'),'1')
		WebUI.click(findTestObject('Object Repository/Settings/Configuration Field Settings/button_Visible'))
		WebUI.click(findTestObject('Object Repository/Settings/Configuration Field Settings/button_Required'))
		WebUI.click(findTestObject('Object Repository/Settings/Configuration Field Settings/button_Editable'))
		WebUI.click(findTestObject('Object Repository/Settings/Configuration Field Settings/button_Sortable'))
		WebUI.click(findTestObject('Object Repository/Settings/Configuration Field Settings/button_Filterable'))
		WebUI.click(findTestObject('Object Repository/Home Page/Modal/button_Save'))
		WebUI.waitForElementVisible(findTestObject('Object Repository/Growl Notification/flash_Notice_Operation successfully completed'), 0,FailureHandling.CONTINUE_ON_FAILURE)
		WebUI.verifyElementVisible(findTestObject('Object Repository/Growl Notification/flash_Notice_Operation successfully completed'),FailureHandling.CONTINUE_ON_FAILURE)
		WebUI.waitForElementVisible(findTestObject('Object Repository/Settings/Configuration Field Settings/input_Configuration Filed name in Dashboard'),0)
		WebUI.setText(findTestObject('Object Repository/Settings/Configuration Field Settings/input_Configuration Filed name in Dashboard'),'test1')
		WebUI.delay(3)
		WebUI.verifyElementVisible(findTestObject('Object Repository/Settings/Dashboard/first checkbox of the list'))
	}
	@Keyword
	def editConfigurationField() {
		WebUI.click(findTestObject('Object Repository/Home Page/Sidebar/button_Settings'))
		WebUI.click(findTestObject('Object Repository/Settings/Breadcumbs/button_My company'))
		WebUI.click(findTestObject('Object Repository/Settings/Configuration Field Settings/button_Configuration Field'))
		WebUI.waitForElementVisible(findTestObject('Object Repository/Settings/Configuration Field Settings/input_Configuration Filed name in Dashboard'),0)
		WebUI.setText(findTestObject('Object Repository/Settings/Configuration Field Settings/input_Configuration Filed name in Dashboard'),'test1')
		WebUI.delay(3)
		WebUI.click(findTestObject('Object Repository/Settings/Dashboard/first checkbox of the list'))
		WebUI.click(findTestObject('Object Repository/Settings/Dashboard/header/button_Edit'))
		WebUI.waitForElementVisible(findTestObject('Object Repository/Settings/Configuration Field Settings/input_Name FR'), 0)
		WebUI.setText(findTestObject('Object Repository/Settings/Configuration Field Settings/input_Name FR'), 'test2')
		WebUI.setText(findTestObject('Object Repository/Settings/Configuration Field Settings/input_Name EN'), 'test2')
		WebUI.click(findTestObject('Object Repository/Settings/Configuration Field Settings/input_Concatenate values in consolidation No'))
		WebUI.click(findTestObject('Object Repository/Settings/Configuration Field Settings/input_Dropdown list No'))
		WebUI.setText(findTestObject('Object Repository/Settings/Configuration Field Settings/textarea_Description'), 'test2')
		WebUI.setText(findTestObject('Object Repository/Settings/Configuration Field Settings/input_Setting type'), 'test2')
		WebUI.setText(findTestObject('Object Repository/Settings/Configuration Field Settings/textarea_Help text'),'test2')
		WebUI.setText(findTestObject('Object Repository/Settings/Configuration Field Settings/input_Default value'),'test2')
		WebUI.setText(findTestObject('Object Repository/Settings/Configuration Field Settings/input_Column size'),'2')
		WebUI.setText(findTestObject('Object Repository/Settings/Configuration Field Settings/input_Priority'),'2')
		WebUI.click(findTestObject('Object Repository/Settings/Configuration Field Settings/button_Visible'))
		WebUI.click(findTestObject('Object Repository/Settings/Configuration Field Settings/button_Required'))
		WebUI.click(findTestObject('Object Repository/Settings/Configuration Field Settings/button_Editable'))
		WebUI.click(findTestObject('Object Repository/Settings/Configuration Field Settings/button_Sortable'))
		WebUI.click(findTestObject('Object Repository/Settings/Configuration Field Settings/button_Filterable'))
		WebUI.click(findTestObject('Object Repository/Home Page/Modal/button_Save'))
		WebUI.waitForElementVisible(findTestObject('Object Repository/Growl Notification/flash_Notice_Operation successfully completed'), 0,FailureHandling.CONTINUE_ON_FAILURE)
		WebUI.verifyElementVisible(findTestObject('Object Repository/Growl Notification/flash_Notice_Operation successfully completed'),FailureHandling.CONTINUE_ON_FAILURE)
		WebUI.waitForElementVisible(findTestObject('Object Repository/Settings/Configuration Field Settings/input_Configuration Filed name in Dashboard'),0)
		WebUI.setText(findTestObject('Object Repository/Settings/Configuration Field Settings/input_Configuration Filed name in Dashboard'),'test2')
		WebUI.delay(3)
		WebUI.verifyElementVisible(findTestObject('Object Repository/Settings/Dashboard/first checkbox of the list'))
	}

	@Keyword
	def deleteConfigurationField() {
		WebUI.click(findTestObject('Object Repository/Home Page/Sidebar/button_Settings'))
		WebUI.click(findTestObject('Object Repository/Settings/Breadcumbs/button_My company'))
		WebUI.click(findTestObject('Object Repository/Settings/Configuration Field Settings/button_Configuration Field'))
		WebUI.waitForElementVisible(findTestObject('Object Repository/Settings/Configuration Field Settings/input_Configuration Filed name in Dashboard'),0)
		WebUI.setText(findTestObject('Object Repository/Settings/Configuration Field Settings/input_Configuration Filed name in Dashboard'),'test2')
		WebUI.delay(3)
		WebUI.click(findTestObject('Object Repository/Settings/Dashboard/first checkbox of the list'))
		WebUI.click(findTestObject('Object Repository/Settings/Dashboard/header/button_Delete'))
		WebUI.click(findTestObject('Object Repository/Home Page/Modal/button_Yes_Cancel'))
		WebUI.waitForElementVisible(findTestObject('Object Repository/Growl Notification/flash_Notice_Operation successfully completed'), 0,FailureHandling.CONTINUE_ON_FAILURE)
		WebUI.verifyElementVisible(findTestObject('Object Repository/Growl Notification/flash_Notice_Operation successfully completed'),FailureHandling.CONTINUE_ON_FAILURE)
		WebUI.waitForElementVisible(findTestObject('Object Repository/Settings/Configuration Field Settings/input_Configuration Filed name in Dashboard'),0)
		WebUI.setText(findTestObject('Object Repository/Settings/Configuration Field Settings/input_Configuration Filed name in Dashboard'),'test2')
		WebUI.delay(3)
		WebUI.verifyElementNotPresent(findTestObject('Object Repository/Settings/Dashboard/first checkbox of the list'),0)
	}
}
