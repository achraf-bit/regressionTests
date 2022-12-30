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

public class DocumentTypes {
	@Keyword
	def addNewDocumentType() {
		WebUI.click(findTestObject('Object Repository/Home Page/Sidebar/button_Settings'))
		WebUI.click(findTestObject('Object Repository/Settings/Breadcumbs/button_My company'))
		WebUI.click(findTestObject('Object Repository/Settings/Document Types Settings/button_Document types'))
		WebUI.waitForElementVisible(findTestObject('Object Repository/Settings/Document Types Settings/input_Name Dashboard'),0)
		WebUI.click(findTestObject('Object Repository/Settings/Dashboard/header/button_Add'))
		WebUI.waitForElementVisible(findTestObject('Object Repository/Settings/Document Types Settings/input_Name'), 0)
		WebUI.setText(findTestObject('Object Repository/Settings/Document Types Settings/input_Name'), 'test1')
		WebUI.setText(findTestObject('Object Repository/Settings/Document Types Settings/input_Code'), '1')
		WebUI.setText(findTestObject('Object Repository/Settings/Document Types Settings/input_Order'), '1')
		WebUI.click(findTestObject('Object Repository/Settings/Document Types Settings/input_Visibility components'))
		WebUI.sendKeys(findTestObject('Object Repository/Settings/Document Types Settings/input_Visibility components'),Keys.chord(Keys.ENTER))
		WebUI.click(findTestObject('Object Repository/Settings/Document Types Settings/input_Main component'))
		WebUI.sendKeys(findTestObject('Object Repository/Settings/Document Types Settings/input_Main component'),Keys.chord(Keys.ENTER))
		WebUI.click(findTestObject('Object Repository/Settings/Document Types Settings/input_Supported extensions'))
		WebUI.sendKeys(findTestObject('Object Repository/Settings/Document Types Settings/input_Supported extensions'),Keys.chord(Keys.ENTER))
		WebUI.check(findTestObject('Object Repository/Settings/Document Types Settings/input_Expected Document'))
		WebUI.check(findTestObject('Object Repository/Settings/Document Types Settings/input_Required Document'))
		WebUI.check(findTestObject('Object Repository/Settings/Document Types Settings/input_Document overwritten with each update'))
		WebUI.click(findTestObject('Object Repository/Settings/Dashboard/button_Add'))
		WebUI.waitForElementVisible(findTestObject('Object Repository/Growl Notification/flash_Notice_Operation successfully completed'), 0,FailureHandling.CONTINUE_ON_FAILURE)
		WebUI.verifyElementVisible(findTestObject('Object Repository/Growl Notification/flash_Notice_Operation successfully completed'),FailureHandling.CONTINUE_ON_FAILURE)
		WebUI.waitForElementVisible(findTestObject('Object Repository/Settings/Document Types Settings/input_Name Dashboard'),0)
		WebUI.setText(findTestObject('Object Repository/Settings/Document Types Settings/input_Name Dashboard'),'test1')
		WebUI.delay(3)
		WebUI.verifyElementVisible(findTestObject('Object Repository/Settings/Dashboard/first checkbox of the list'))
	}
	@Keyword
	def editDocumentType() {
		WebUI.click(findTestObject('Object Repository/Home Page/Sidebar/button_Settings'))
		WebUI.click(findTestObject('Object Repository/Settings/Breadcumbs/button_My company'))
		WebUI.click(findTestObject('Object Repository/Settings/Document Types Settings/button_Document types'))
		WebUI.waitForElementVisible(findTestObject('Object Repository/Settings/Document Types Settings/input_Name Dashboard'),0)
		WebUI.setText(findTestObject('Object Repository/Settings/Document Types Settings/input_Name Dashboard'),'test1')
		WebUI.delay(3)
		WebUI.click(findTestObject('Object Repository/Settings/Dashboard/first checkbox of the list'))
		WebUI.click(findTestObject('Object Repository/Settings/Dashboard/header/button_Edit'))
		WebUI.waitForElementVisible(findTestObject('Object Repository/Settings/Document Types Settings/input_Name'), 0)
		WebUI.setText(findTestObject('Object Repository/Settings/Document Types Settings/input_Name'), 'test2')
		WebUI.setText(findTestObject('Object Repository/Settings/Document Types Settings/input_Code'), '2')
		WebUI.setText(findTestObject('Object Repository/Settings/Document Types Settings/input_Order'), '2')
		WebUI.click(findTestObject('Object Repository/Settings/Document Types Settings/input_Visibility components'))
		WebUI.sendKeys(findTestObject('Object Repository/Settings/Document Types Settings/input_Visibility components'),Keys.chord(Keys.BACK_SPACE))
		WebUI.sendKeys(findTestObject('Object Repository/Settings/Document Types Settings/input_Visibility components'),Keys.chord(Keys.DOWN))
		WebUI.sendKeys(findTestObject('Object Repository/Settings/Document Types Settings/input_Visibility components'),Keys.chord(Keys.ENTER))
		WebUI.click(findTestObject('Object Repository/Settings/Document Types Settings/input_Main component'))
		WebUI.sendKeys(findTestObject('Object Repository/Settings/Document Types Settings/input_Main component'),Keys.chord(Keys.BACK_SPACE))
		WebUI.sendKeys(findTestObject('Object Repository/Settings/Document Types Settings/input_Main component'),Keys.chord(Keys.DOWN))
		WebUI.sendKeys(findTestObject('Object Repository/Settings/Document Types Settings/input_Main component'),Keys.chord(Keys.ENTER))
		WebUI.click(findTestObject('Object Repository/Settings/Document Types Settings/input_Supported extensions'))
		WebUI.sendKeys(findTestObject('Object Repository/Settings/Document Types Settings/input_Supported extensions'),Keys.chord(Keys.BACK_SPACE))
		WebUI.sendKeys(findTestObject('Object Repository/Settings/Document Types Settings/input_Supported extensions'),Keys.chord(Keys.DOWN))
		WebUI.sendKeys(findTestObject('Object Repository/Settings/Document Types Settings/input_Supported extensions'),Keys.chord(Keys.ENTER))
		WebUI.uncheck(findTestObject('Object Repository/Settings/Document Types Settings/input_Activate'))
		WebUI.uncheck(findTestObject('Object Repository/Settings/Document Types Settings/input_Expected Document'))
		WebUI.uncheck(findTestObject('Object Repository/Settings/Document Types Settings/input_Required Document'))
		WebUI.uncheck(findTestObject('Object Repository/Settings/Document Types Settings/input_Document overwritten with each update'))
		WebUI.click(findTestObject('Object Repository/Settings/Document Types Settings/button_Edit'))
		WebUI.waitForElementVisible(findTestObject('Object Repository/Growl Notification/flash_Notice_Operation successfully completed'), 0,FailureHandling.CONTINUE_ON_FAILURE)
		WebUI.verifyElementVisible(findTestObject('Object Repository/Growl Notification/flash_Notice_Operation successfully completed'),FailureHandling.CONTINUE_ON_FAILURE)
		WebUI.waitForElementVisible(findTestObject('Object Repository/Settings/Document Types Settings/input_Name Dashboard'),0)
		WebUI.setText(findTestObject('Object Repository/Settings/Document Types Settings/input_Name Dashboard'),'test2')
		WebUI.delay(3)
		WebUI.verifyElementVisible(findTestObject('Object Repository/Settings/Dashboard/first checkbox of the list'))
	}
	@Keyword
	def deleteDocumentType(){
		WebUI.click(findTestObject('Object Repository/Home Page/Sidebar/button_Settings'))
		WebUI.click(findTestObject('Object Repository/Settings/Breadcumbs/button_My company'))
		WebUI.click(findTestObject('Object Repository/Settings/Document Types Settings/button_Document types'))
		WebUI.waitForElementVisible(findTestObject('Object Repository/Settings/Document Types Settings/input_Name Dashboard'),0)
		WebUI.setText(findTestObject('Object Repository/Settings/Document Types Settings/input_Name Dashboard'),'test2')
		WebUI.delay(3)
		WebUI.waitForElementVisible(findTestObject('Object Repository/Settings/Dashboard/first checkbox of the list'),0)
		WebUI.click(findTestObject('Object Repository/Settings/Dashboard/first checkbox of the list'))
		WebUI.click(findTestObject('Object Repository/Settings/Dashboard/header/button_Delete'))
		WebUI.click(findTestObject('Object Repository/Settings/Modal/button_Yes'))	
		WebUI.waitForElementVisible(findTestObject('Object Repository/Settings/Document Types Settings/input_Name Dashboard'),0)
		WebUI.setText(findTestObject('Object Repository/Settings/Document Types Settings/input_Name Dashboard'),'test2')
		WebUI.delay(3)
		WebUI.verifyElementNotPresent(findTestObject('Object Repository/Settings/Dashboard/first checkbox of the list'),0)
	}
}
