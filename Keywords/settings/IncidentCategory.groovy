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

public class IncidentCategory {
	@Keyword
	def addIncidentCategory() {
		WebUI.click(findTestObject('Object Repository/Home Page/Sidebar/button_Settings'))
		WebUI.click(findTestObject('Object Repository/Settings/Breadcumbs/button_My company'))
		WebUI.click(findTestObject('Object Repository/Settings/Incident Category Settings/button_Incident category'))
		WebUI.waitForElementVisible(findTestObject('Object Repository/Settings/Incident Category Settings/input_Code Incident category Dashboard'),0)
		WebUI.click(findTestObject('Object Repository/Settings/Dashboard/header/button_Add'))
		WebUI.waitForElementVisible(findTestObject('Object Repository/Settings/Incident Category Settings/input_Code'), 0)
		WebUI.setText(findTestObject('Object Repository/Settings/Incident Category Settings/input_Code'), 'test')
		WebUI.setText(findTestObject('Object Repository/Settings/Incident Category Settings/input_Label'), 'test')
		WebUI.setText(findTestObject('Object Repository/Settings/Incident Category Settings/input_Order'), '1')
		WebUI.setText(findTestObject('Object Repository/Settings/Incident Category Settings/input_Sub category'), 'test')
		WebUI.sendKeys(findTestObject('Object Repository/Settings/Incident Category Settings/input_Sub category'), Keys.chord(Keys.ENTER))
		WebUI.click(findTestObject('Object Repository/Settings/Incident Category Settings/select_Incident type'))
		WebUI.click(findTestObject('Object Repository/Settings/Incident Category Settings/select the first option'))
		WebUI.click(findTestObject('Object Repository/Home Page/Modal/button_Save'))
		WebUI.waitForElementVisible(findTestObject('Object Repository/Growl Notification/flash_Notice_Operation successfully completed'), 0,FailureHandling.CONTINUE_ON_FAILURE)
		WebUI.verifyElementVisible(findTestObject('Object Repository/Growl Notification/flash_Notice_Operation successfully completed'),FailureHandling.CONTINUE_ON_FAILURE)
		WebUI.waitForElementVisible(findTestObject('Object Repository/Settings/Incident Category Settings/input_Code Incident category Dashboard'),0)
		WebUI.setText(findTestObject('Object Repository/Settings/Incident Category Settings/input_Code Incident category Dashboard'),'test')
		WebUI.delay(3)
		WebUI.verifyElementVisible(findTestObject('Object Repository/Settings/Dashboard/first checkbox of the list'))
	}
	@Keyword
	def editIncidentCategory() {
		WebUI.click(findTestObject('Object Repository/Home Page/Sidebar/button_Settings'))
		WebUI.click(findTestObject('Object Repository/Settings/Breadcumbs/button_My company'))
		WebUI.click(findTestObject('Object Repository/Settings/Incident Category Settings/button_Incident category'))
		WebUI.waitForElementVisible(findTestObject('Object Repository/Settings/Incident Category Settings/input_Code Incident category Dashboard'),0)
		WebUI.setText(findTestObject('Object Repository/Settings/Incident Category Settings/input_Code Incident category Dashboard'),'test')
		WebUI.delay(3)
		WebUI.click(findTestObject('Object Repository/Settings/Dashboard/first checkbox of the list'))
		WebUI.click(findTestObject('Object Repository/Settings/Dashboard/header/button_Edit'))
		WebUI.waitForElementVisible(findTestObject('Object Repository/Settings/Incident Category Settings/input_Code'), 0)
		WebUI.setText(findTestObject('Object Repository/Settings/Incident Category Settings/input_Code'), 'test2')
		WebUI.setText(findTestObject('Object Repository/Settings/Incident Category Settings/input_Label'), 'test2')
		WebUI.setText(findTestObject('Object Repository/Settings/Incident Category Settings/input_Order'), '2')
		WebUI.click(findTestObject('Object Repository/Settings/Incident Category Settings/button_Clean text'))
		WebUI.setText(findTestObject('Object Repository/Settings/Incident Category Settings/input_Sub category'), 'test2')
		WebUI.sendKeys(findTestObject('Object Repository/Settings/Incident Category Settings/input_Sub category'), Keys.chord(Keys.ENTER))
		WebUI.click(findTestObject('Object Repository/Settings/Incident Category Settings/select_Incident type'))
		WebUI.click(findTestObject('Object Repository/Settings/Incident Category Settings/select the second option'))
		WebUI.click(findTestObject('Object Repository/Home Page/Modal/button_Save'))
		WebUI.waitForElementVisible(findTestObject('Object Repository/Growl Notification/flash_Notice_Operation successfully completed'), 0,FailureHandling.CONTINUE_ON_FAILURE)
		WebUI.verifyElementVisible(findTestObject('Object Repository/Growl Notification/flash_Notice_Operation successfully completed'),FailureHandling.CONTINUE_ON_FAILURE)
		WebUI.waitForElementVisible(findTestObject('Object Repository/Settings/Incident Category Settings/input_Code Incident category Dashboard'),0)
		WebUI.setText(findTestObject('Object Repository/Settings/Incident Category Settings/input_Code Incident category Dashboard'),'test2')
		WebUI.delay(3)
		WebUI.verifyElementVisible(findTestObject('Object Repository/Settings/Dashboard/first checkbox of the list'))
	}
	@Keyword
	def deleteIncidentCategory() {
		WebUI.click(findTestObject('Object Repository/Home Page/Sidebar/button_Settings'))
		WebUI.click(findTestObject('Object Repository/Settings/Breadcumbs/button_My company'))
		WebUI.click(findTestObject('Object Repository/Settings/Incident Category Settings/button_Incident category'))
		WebUI.waitForElementVisible(findTestObject('Object Repository/Settings/Incident Category Settings/input_Code Incident category Dashboard'),0)
		WebUI.setText(findTestObject('Object Repository/Settings/Incident Category Settings/input_Code Incident category Dashboard'),'test2')
		WebUI.delay(3)
		WebUI.click(findTestObject('Object Repository/Settings/Dashboard/first checkbox of the list'))
		WebUI.click(findTestObject('Object Repository/Settings/Dashboard/header/button_Delete'))
		WebUI.click(findTestObject('Object Repository/Home Page/Modal/button_Yes_Cancel'))
		WebUI.waitForElementVisible(findTestObject('Object Repository/Growl Notification/flash_Notice_Operation successfully completed'), 0,FailureHandling.CONTINUE_ON_FAILURE)
		WebUI.verifyElementVisible(findTestObject('Object Repository/Growl Notification/flash_Notice_Operation successfully completed'),FailureHandling.CONTINUE_ON_FAILURE)
		WebUI.waitForElementVisible(findTestObject('Object Repository/Settings/Incident Category Settings/input_Code Incident category Dashboard'),0)
		WebUI.setText(findTestObject('Object Repository/Settings/Incident Category Settings/input_Code Incident category Dashboard'),'test2')
		WebUI.delay(3)
		WebUI.verifyElementNotPresent(findTestObject('Object Repository/Settings/Dashboard/first checkbox of the list'),0)
	}
}
