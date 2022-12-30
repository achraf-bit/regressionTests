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

public class DocumentTemplatesCounter {
	@Keyword
	def addNewDocumentTemplatesCounter() {
		WebUI.click(findTestObject('Object Repository/Home Page/Sidebar/button_Settings'))
		WebUI.click(findTestObject('Object Repository/Settings/Breadcumbs/button_My company'))
		WebUI.click(findTestObject('Object Repository/Settings/Document Templates Counter Settings/button_Document templates counter'))
		WebUI.waitForElementVisible(findTestObject('Object Repository/Settings/Dashboard/first input in dashboard'),0)
		WebUI.click(findTestObject('Object Repository/Settings/Dashboard/header/button_Add'))
		WebUI.waitForElementVisible(findTestObject('Object Repository/Settings/Document Templates Counter Settings/input_Label'), 0)
		WebUI.setText(findTestObject('Object Repository/Settings/Document Templates Counter Settings/input_Label'), 'test1')
		WebUI.setText(findTestObject('Object Repository/Settings/Document Templates Counter Settings/input_Prefix'), 'test1')
		WebUI.click(findTestObject('Object Repository/Settings/Modal/button_Save'))
		WebUI.waitForElementVisible(findTestObject('Object Repository/Growl Notification/flash_Notice_Operation successfully completed'), 0,FailureHandling.CONTINUE_ON_FAILURE)
		WebUI.verifyElementVisible(findTestObject('Object Repository/Growl Notification/flash_Notice_Operation successfully completed'),FailureHandling.CONTINUE_ON_FAILURE)
		WebUI.waitForElementVisible(findTestObject('Object Repository/Settings/Dashboard/first input in dashboard'),0)
		WebUI.setText(findTestObject('Object Repository/Settings/Dashboard/first input in dashboard'),'test1')
		WebUI.delay(3)
		WebUI.verifyElementVisible(findTestObject('Object Repository/Settings/Dashboard/first checkbox of the list'))
	}

	@Keyword
	def editDocumentTemplatesCounter() {
		WebUI.click(findTestObject('Object Repository/Home Page/Sidebar/button_Settings'))
		WebUI.click(findTestObject('Object Repository/Settings/Breadcumbs/button_My company'))
		WebUI.click(findTestObject('Object Repository/Settings/Document Templates Counter Settings/button_Document templates counter'))
		WebUI.waitForElementVisible(findTestObject('Object Repository/Settings/Dashboard/first input in dashboard'),0)
		WebUI.setText(findTestObject('Object Repository/Settings/Dashboard/first input in dashboard'),'test1')
		WebUI.delay(3)
		WebUI.click(findTestObject('Object Repository/Settings/Dashboard/first checkbox of the list'))
		WebUI.click(findTestObject('Object Repository/Settings/Dashboard/header/button_Edit'))
		WebUI.waitForElementVisible(findTestObject('Object Repository/Settings/Document Templates Counter Settings/input_Label'), 0)
		WebUI.setText(findTestObject('Object Repository/Settings/Document Templates Counter Settings/input_Label'), 'test2')
		WebUI.setText(findTestObject('Object Repository/Settings/Document Templates Counter Settings/input_Prefix'), 'test2')
		WebUI.setText(findTestObject('Object Repository/Settings/Document Templates Counter Settings/input_Minimal number of digits'),'2')
		WebUI.setText(findTestObject('Object Repository/Settings/Document Templates Counter Settings/input__startNumber'),'2')
		WebUI.click(findTestObject('Object Repository/Settings/Document Templates Counter Settings/input_Mode ANNUAL'))
		WebUI.click(findTestObject('Object Repository/Settings/Modal/button_Save'))
		WebUI.waitForElementVisible(findTestObject('Object Repository/Growl Notification/flash_Notice_Operation successfully completed'), 0 ,FailureHandling.CONTINUE_ON_FAILURE)
		WebUI.verifyElementVisible(findTestObject('Object Repository/Growl Notification/flash_Notice_Operation successfully completed'),FailureHandling.CONTINUE_ON_FAILURE)
		WebUI.waitForElementVisible(findTestObject('Object Repository/Settings/Dashboard/first input in dashboard'),0)
		WebUI.setText(findTestObject('Object Repository/Settings/Dashboard/first input in dashboard'),'test2')
		WebUI.delay(3)
		WebUI.verifyElementVisible(findTestObject('Object Repository/Settings/Dashboard/first checkbox of the list'))
	}

	@Keyword
	def deleteDocumentTemplatesCounter(){
		WebUI.click(findTestObject('Object Repository/Home Page/Sidebar/button_Settings'))
		WebUI.click(findTestObject('Object Repository/Settings/Breadcumbs/button_My company'))
		WebUI.click(findTestObject('Object Repository/Settings/Document Templates Counter Settings/button_Document templates counter'))
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
