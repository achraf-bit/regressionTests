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

public class TypeOfDangerousGoods {
	@Keyword
	def addNewTypeOfDangerousGoods() {
		WebUI.click(findTestObject('Object Repository/Home Page/Sidebar/button_Settings'))
		WebUI.click(findTestObject('Object Repository/Settings/Breadcumbs/button_My company'))
		WebUI.click(findTestObject('Object Repository/Settings/Type Of Dangerous Goods Settings/button_Type of dangerous goods'))
		WebUI.waitForElementVisible(findTestObject('Object Repository/Settings/Type Of Dangerous Goods Settings/input_Code Type Of Dangerous Goods Dashboard'),0)
		WebUI.click(findTestObject('Object Repository/Settings/Dashboard/header/button_Add'))
		WebUI.waitForElementPresent(findTestObject('Object Repository/Settings/Type Of Dangerous Goods Settings/input_Code Type Of Dangerous Goods'), 0)
		WebUI.delay(3)
		WebUI.setText(findTestObject('Object Repository/Settings/Type Of Dangerous Goods Settings/input_Code Type Of Dangerous Goods'), '1')
		WebUI.setText(findTestObject('Object Repository/Settings/Type Of Dangerous Goods Settings/input_Type of dangerous goods (typeOfDangerousGoods)'), 'test')
		WebUI.setText(findTestObject('Object Repository/Settings/Type Of Dangerous Goods Settings/input_Onu Number'), '1')
		WebUI.setText(findTestObject('Object Repository/Settings/Type Of Dangerous Goods Settings/input_Id number'), '1')
		WebUI.click(findTestObject('Object Repository/Settings/Type Of Dangerous Goods Settings/select_Unit Of Measurement'))
		WebUI.click(findTestObject('Object Repository/Settings/Type Of Dangerous Goods Settings/select first option'))
		WebUI.click(findTestObject('Object Repository/Settings/Type Of Dangerous Goods Settings/input_Dangerous environment Yes'))
		WebUI.setText(findTestObject('Object Repository/Settings/Type Of Dangerous Goods Settings/input_Coef 1.1.3.6'),'1')
		WebUI.click(findTestObject('Object Repository/Settings/Type Of Dangerous Goods Settings/input_N.O.S Yes'))
		WebUI.setText(findTestObject('Object Repository/Settings/Type Of Dangerous Goods Settings/input_Comments'),'test')
		WebUI.setText(findTestObject('Object Repository/Settings/Type Of Dangerous Goods Settings/input_Instructions'),'test')
		WebUI.click(findTestObject('Object Repository/Home Page/Modal/button_Save'))
		WebUI.waitForElementPresent(findTestObject('Object Repository/Growl Notification/flash_Notice_Operation successfully completed'), 0,FailureHandling.CONTINUE_ON_FAILURE)
		WebUI.verifyElementVisible(findTestObject('Object Repository/Growl Notification/flash_Notice_Operation successfully completed'),FailureHandling.CONTINUE_ON_FAILURE)
		WebUI.waitForElementVisible(findTestObject('Object Repository/Settings/Type Of Dangerous Goods Settings/input_Code Type Of Dangerous Goods Dashboard'),0)
		WebUI.setText(findTestObject('Object Repository/Settings/Type Of Goods Settings/input_Code Dashboard'),'1')
		WebUI.delay(3)
		WebUI.verifyElementVisible(findTestObject('Object Repository/Settings/Dashboard/first checkbox of the list'))
	}

	@Keyword
	def editTypeOfDangerousGoods() {
		WebUI.click(findTestObject('Object Repository/Home Page/Sidebar/button_Settings'))
		WebUI.click(findTestObject('Object Repository/Settings/Breadcumbs/button_My company'))
		WebUI.click(findTestObject('Object Repository/Settings/Type Of Dangerous Goods Settings/button_Type of dangerous goods'))
		WebUI.waitForElementVisible(findTestObject('Object Repository/Settings/Type Of Dangerous Goods Settings/input_Code Type Of Dangerous Goods Dashboard'),0)
		WebUI.setText(findTestObject('Object Repository/Settings/Type Of Dangerous Goods Settings/input_Code Type Of Dangerous Goods Dashboard'),'1')
		WebUI.delay(3)
		WebUI.click(findTestObject('Object Repository/Settings/Dashboard/first checkbox of the list'))
		WebUI.click(findTestObject('Object Repository/Settings/Dashboard/header/button_Edit'))
		WebUI.waitForElementPresent(findTestObject('Object Repository/Settings/Type Of Dangerous Goods Settings/input_Code Type Of Dangerous Goods'), 0)
		WebUI.delay(3)
		WebUI.setText(findTestObject('Object Repository/Settings/Type Of Dangerous Goods Settings/input_Code Type Of Dangerous Goods'), '2')
		WebUI.setText(findTestObject('Object Repository/Settings/Type Of Dangerous Goods Settings/input_Type of dangerous goods (typeOfDangerousGoods)'), 'test2')
		WebUI.setText(findTestObject('Object Repository/Settings/Type Of Dangerous Goods Settings/input_Onu Number'), '2')
		WebUI.setText(findTestObject('Object Repository/Settings/Type Of Dangerous Goods Settings/input_Id number'), '2')
		WebUI.click(findTestObject('Object Repository/Settings/Type Of Dangerous Goods Settings/select_Unit Of Measurement'))
		WebUI.click(findTestObject('Object Repository/Settings/Type Of Dangerous Goods Settings/select first option'))
		WebUI.click(findTestObject('Object Repository/Settings/Type Of Dangerous Goods Settings/input_Dangerous environment No'))
		WebUI.setText(findTestObject('Object Repository/Settings/Type Of Dangerous Goods Settings/input_Coef 1.1.3.6'),'2')
		WebUI.click(findTestObject('Object Repository/Settings/Type Of Dangerous Goods Settings/input_N.O.S No'))
		WebUI.setText(findTestObject('Object Repository/Settings/Type Of Dangerous Goods Settings/input_Comments'),'test2')
		WebUI.setText(findTestObject('Object Repository/Settings/Type Of Dangerous Goods Settings/input_Instructions'),'test2')
		WebUI.click(findTestObject('Object Repository/Home Page/Modal/button_Save'))
		WebUI.waitForElementPresent(findTestObject('Object Repository/Growl Notification/flash_Notice_Operation successfully completed'), 0,FailureHandling.CONTINUE_ON_FAILURE)
		WebUI.verifyElementVisible(findTestObject('Object Repository/Growl Notification/flash_Notice_Operation successfully completed'),FailureHandling.CONTINUE_ON_FAILURE)
		WebUI.waitForElementVisible(findTestObject('Object Repository/Settings/Type Of Goods Settings/input_Code Dashboard'),0)
		WebUI.setText(findTestObject('Object Repository/Settings/Type Of Goods Settings/input_Code Dashboard'),'2')
		WebUI.delay(3)
		WebUI.verifyElementVisible(findTestObject('Object Repository/Settings/Dashboard/first checkbox of the list'))
	}

	@Keyword
	def deleteTypeOfDangerousGoods(){
		WebUI.click(findTestObject('Object Repository/Home Page/Sidebar/button_Settings'))
		WebUI.click(findTestObject('Object Repository/Settings/Breadcumbs/button_My company'))
		WebUI.click(findTestObject('Object Repository/Settings/Type Of Dangerous Goods Settings/button_Type of dangerous goods'))
		WebUI.waitForElementVisible(findTestObject('Object Repository/Settings/Type Of Dangerous Goods Settings/input_Code Type Of Dangerous Goods Dashboard'),0)
		WebUI.setText(findTestObject('Object Repository/Settings/Type Of Dangerous Goods Settings/input_Code Type Of Dangerous Goods Dashboard'),'2')
		WebUI.delay(3)
		WebUI.click(findTestObject('Object Repository/Settings/Dashboard/first checkbox of the list'))
		WebUI.click(findTestObject('Object Repository/Settings/Dashboard/header/button_Delete'))
		WebUI.click(findTestObject('Object Repository/Home Page/Modal/button_Yes_Cancel'))
		WebUI.waitForElementPresent(findTestObject('Object Repository/Growl Notification/flash_Notice_Operation successfully completed'), 0,FailureHandling.CONTINUE_ON_FAILURE)
		WebUI.verifyElementVisible(findTestObject('Object Repository/Growl Notification/flash_Notice_Operation successfully completed'),FailureHandling.CONTINUE_ON_FAILURE)
		WebUI.waitForElementVisible(findTestObject('Object Repository/Settings/Type Of Dangerous Goods Settings/input_Code Type Of Dangerous Goods Dashboard'),0)
		WebUI.setText(findTestObject('Object Repository/Settings/Type Of Dangerous Goods Settings/input_Code Type Of Dangerous Goods Dashboard'),'2')
		WebUI.delay(3)
		WebUI.verifyElementNotPresent(findTestObject('Object Repository/Settings/Dashboard/first checkbox of the list'),0)
	}
}
