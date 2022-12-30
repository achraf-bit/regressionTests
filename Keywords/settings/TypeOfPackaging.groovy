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

import internal.GlobalVariable

public class TypeOfPackaging {
	@Keyword
	def addNewTypeOfPackaging() {
		WebUI.click(findTestObject('Object Repository/Home Page/Sidebar/button_Settings'))
		WebUI.click(findTestObject('Object Repository/Settings/Breadcumbs/button_My company'))
		WebUI.click(findTestObject('Object Repository/Settings/Type Of Packaging Settings/button_Type of packaging'))
		WebUI.waitForElementVisible(findTestObject('Object Repository/Settings/Type Of Packaging Settings/input_Code Type Of Packaging Dashboard'),0)
		WebUI.click(findTestObject('Object Repository/Settings/Dashboard/header/button_Add'))
		WebUI.waitForElementVisible(findTestObject('Object Repository/Settings/Type Of Packaging Settings/input_Code'), 0)
		WebUI.setText(findTestObject('Object Repository/Settings/Type Of Packaging Settings/input_Code'), '1')
		WebUI.setText(findTestObject('Object Repository/Settings/Type Of Packaging Settings/input_Label'), 'test')
		WebUI.click(findTestObject('Object Repository/Home Page/Modal/button_Save'))
		WebUI.waitForElementVisible(findTestObject('Object Repository/Growl Notification/flash_Notice_Operation successfully completed'), 0,FailureHandling.CONTINUE_ON_FAILURE)
		WebUI.verifyElementVisible(findTestObject('Object Repository/Growl Notification/flash_Notice_Operation successfully completed'),FailureHandling.CONTINUE_ON_FAILURE)
		WebUI.waitForElementVisible(findTestObject('Object Repository/Settings/Type Of Packaging Settings/input_Code Type Of Packaging Dashboard'),0)
		WebUI.setText(findTestObject('Object Repository/Settings/Type Of Packaging Settings/input_Code Type Of Packaging Dashboard'),'1')
		WebUI.delay(3)
		WebUI.verifyElementVisible(findTestObject('Object Repository/Settings/Dashboard/first checkbox of the list'))
	}
	@Keyword
	def editTypeOfPackaging() {
		WebUI.click(findTestObject('Object Repository/Home Page/Sidebar/button_Settings'))
		WebUI.click(findTestObject('Object Repository/Settings/Breadcumbs/button_My company'))
		WebUI.click(findTestObject('Object Repository/Settings/Type Of Packaging Settings/button_Type of packaging'))
		WebUI.waitForElementVisible(findTestObject('Object Repository/Settings/Type Of Packaging Settings/input_Code Type Of Packaging Dashboard'),0)
		WebUI.setText(findTestObject('Object Repository/Settings/Type Of Packaging Settings/input_Code Type Of Packaging Dashboard'),'1')
		WebUI.delay(3)
		WebUI.click(findTestObject('Object Repository/Settings/Dashboard/first checkbox of the list'))
		WebUI.click(findTestObject('Object Repository/Settings/Dashboard/header/button_Edit'))
		WebUI.waitForElementVisible(findTestObject('Object Repository/Settings/Type Of Packaging Settings/input_Code'), 0)
		WebUI.setText(findTestObject('Object Repository/Settings/Type Of Packaging Settings/input_Code'), '2')
		WebUI.setText(findTestObject('Object Repository/Settings/Type Of Packaging Settings/input_Label'), 'test2')
		WebUI.click(findTestObject('Object Repository/Home Page/Modal/button_Save'))
		WebUI.waitForElementVisible(findTestObject('Object Repository/Growl Notification/flash_Notice_Operation successfully completed'), 0,FailureHandling.CONTINUE_ON_FAILURE)
		WebUI.verifyElementVisible(findTestObject('Object Repository/Growl Notification/flash_Notice_Operation successfully completed'),FailureHandling.CONTINUE_ON_FAILURE)
		WebUI.waitForElementVisible(findTestObject('Object Repository/Settings/Type Of Packaging Settings/input_Code Type Of Packaging Dashboard'),0)
		WebUI.setText(findTestObject('Object Repository/Settings/Type Of Packaging Settings/input_Code Type Of Packaging Dashboard'),'2')
		WebUI.delay(3)
		WebUI.verifyElementVisible(findTestObject('Object Repository/Settings/Dashboard/first checkbox of the list'))
	}
	@Keyword
	def deleteTypeOfPackaging(){
		WebUI.click(findTestObject('Object Repository/Home Page/Sidebar/button_Settings'))
		WebUI.click(findTestObject('Object Repository/Settings/Breadcumbs/button_My company'))
		WebUI.click(findTestObject('Object Repository/Settings/Type Of Packaging Settings/button_Type of packaging'))
		WebUI.waitForElementVisible(findTestObject('Object Repository/Settings/Type Of Packaging Settings/input_Code Type Of Packaging Dashboard'),0)
		WebUI.setText(findTestObject('Object Repository/Settings/Type Of Packaging Settings/input_Code Type Of Packaging Dashboard'),'2')
		WebUI.delay(3)
		WebUI.click(findTestObject('Object Repository/Settings/Dashboard/first checkbox of the list'))
		WebUI.click(findTestObject('Object Repository/Settings/Dashboard/header/button_Delete'))
		WebUI.click(findTestObject('Object Repository/Home Page/Modal/button_Yes_Cancel'))
		WebUI.waitForElementVisible(findTestObject('Object Repository/Settings/Type Of Packaging Settings/input_Code Type Of Packaging Dashboard'),0)
		WebUI.setText(findTestObject('Object Repository/Settings/Type Of Packaging Settings/input_Code Type Of Packaging Dashboard'),'2')
		WebUI.delay(3)
		WebUI.verifyElementNotPresent(findTestObject('Object Repository/Settings/Dashboard/first checkbox of the list'),0)
	}
}
