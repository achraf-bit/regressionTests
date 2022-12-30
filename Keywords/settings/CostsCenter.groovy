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

public class CostsCenter {
	def costCenter

	@Keyword
	def addNewCostCenter() {
		WebUI.click(findTestObject('Object Repository/Home Page/Sidebar/button_Settings'))
		WebUI.click(findTestObject('Object Repository/Settings/Breadcumbs/button_My company'))
		WebUI.click(findTestObject('Object Repository/Settings/Costs Center Settings/button_Costs center'))
		WebUI.waitForElementVisible(findTestObject('Object Repository/Settings/Costs Center Settings/input_Cost center'), 0)
		WebUI.setText(findTestObject('Object Repository/Settings/Costs Center Settings/input_Cost center'), 'test1')
		WebUI.click(findTestObject('Object Repository/Settings/Costs Center Settings/button_Save Cost Center'))
		WebUI.waitForElementVisible(findTestObject('Object Repository/Growl Notification/flash_Notice_Operation successfully completed'), 0,FailureHandling.CONTINUE_ON_FAILURE)
		WebUI.verifyElementVisible(findTestObject('Object Repository/Growl Notification/flash_Notice_Operation successfully completed'),FailureHandling.CONTINUE_ON_FAILURE)
		costCenter = WebUI.getAttribute(findTestObject('Object Repository/Settings/Costs Center Settings/button_Last Cost Center Created'),'innerText')
		WebUI.verifyMatch(costCenter, 'test1' , true, FailureHandling.CONTINUE_ON_FAILURE)
	}
	@Keyword
	def editLastCostCenter() {
		WebUI.click(findTestObject('Object Repository/Home Page/Sidebar/button_Settings'))
		WebUI.click(findTestObject('Object Repository/Settings/Breadcumbs/button_My company'))
		WebUI.click(findTestObject('Object Repository/Settings/Costs Center Settings/button_Costs center'))
		WebUI.waitForElementVisible(findTestObject('Object Repository/Settings/Costs Center Settings/input_Cost center'), 0)
		WebUI.click(findTestObject('Object Repository/Settings/Costs Center Settings/button_Last Cost Center Created'))
		WebUI.setText(findTestObject('Object Repository/Settings/Costs Center Settings/input_Cost center'), 'test2')
		WebUI.click(findTestObject('Object Repository/Settings/Costs Center Settings/button_Save Cost Center'))
		WebUI.waitForElementVisible(findTestObject('Object Repository/Growl Notification/flash_Notice_Operation successfully completed'), 0,FailureHandling.CONTINUE_ON_FAILURE)
		WebUI.verifyElementVisible(findTestObject('Object Repository/Growl Notification/flash_Notice_Operation successfully completed'),FailureHandling.CONTINUE_ON_FAILURE)
		costCenter = WebUI.getAttribute(findTestObject('Object Repository/Settings/Costs Center Settings/button_Last Cost Center Created'),'innerText')
		WebUI.verifyMatch(costCenter, 'test2' , true, FailureHandling.CONTINUE_ON_FAILURE)
	}
	@Keyword
	def deleteLastCostCenter() {
		WebUI.click(findTestObject('Object Repository/Home Page/Sidebar/button_Settings'))
		WebUI.click(findTestObject('Object Repository/Settings/Breadcumbs/button_My company'))
		WebUI.click(findTestObject('Object Repository/Settings/Costs Center Settings/button_Costs center'))
		WebUI.waitForElementVisible(findTestObject('Object Repository/Settings/Costs Center Settings/input_Cost center'), 0)
		WebUI.click(findTestObject('Object Repository/Settings/Costs Center Settings/button_Delete Last Cost Center Created'))
		WebUI.click(findTestObject('Object Repository/Home Page/Modal/button_Yes_Cancel'))
		WebUI.waitForElementVisible(findTestObject('Object Repository/Growl Notification/flash_Notice_Operation successfully completed'), 0,FailureHandling.CONTINUE_ON_FAILURE)
		WebUI.verifyElementVisible(findTestObject('Object Repository/Growl Notification/flash_Notice_Operation successfully completed'),FailureHandling.CONTINUE_ON_FAILURE)
	}
}

