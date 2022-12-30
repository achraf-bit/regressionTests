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

public class Flags {

	@Keyword
	def addNewFlag() {
		WebUI.click(findTestObject('Object Repository/Home Page/Sidebar/button_Settings'))
		WebUI.click(findTestObject('Object Repository/Settings/Breadcumbs/button_My company'))
		WebUI.click(findTestObject('Object Repository/Settings/Flags Settings/button_Flags'))
		WebUI.click(findTestObject('Object Repository/Settings/Dashboard/header/button_Add'))
		WebUI.waitForElementVisible(findTestObject('Object Repository/Settings/Flags Settings/input_Reference'), 0)
		WebUI.setText(findTestObject('Object Repository/Settings/Flags Settings/input_Reference'), 'test2')
		WebUI.setText(findTestObject('Object Repository/Settings/Flags Settings/input_Name'), 'test2')
		WebUI.click(findTestObject('Object Repository/Settings/Flags Settings/input_Icon'))
		WebUI.sendKeys(findTestObject('Object Repository/Settings/Flags Settings/input_Icon'),Keys.chord(Keys.ENTER))
		WebUI.setText(findTestObject('Object Repository/Settings/Flags Settings/input_Color'), '"#00ff1a"')
		WebUI.click(findTestObject('Object Repository/Settings/Dashboard/button_Add'))
		WebUI.waitForElementVisible(findTestObject('Object Repository/Settings/Flags Settings/input_Reference Dashboard'), 0)
		WebUI.setText(findTestObject('Object Repository/Settings/Flags Settings/input_Reference Dashboard'), 'test2')
		WebUI.delay(3)
		WebUI.verifyElementVisible(findTestObject('Object Repository/Settings/Dashboard/first checkbox of the list'))
	}

	@Keyword
	def editFlag() {
		WebUI.click(findTestObject('Object Repository/Home Page/Sidebar/button_Settings'))
		WebUI.click(findTestObject('Object Repository/Settings/Breadcumbs/button_My company'))
		WebUI.click(findTestObject('Object Repository/Settings/Flags Settings/button_Flags'))
		WebUI.waitForElementVisible(findTestObject('Object Repository/Settings/Flags Settings/input_Reference Dashboard'), 0)
		WebUI.setText(findTestObject('Object Repository/Settings/Flags Settings/input_Reference Dashboard'), 'test2')
		WebUI.delay(3)
		WebUI.check(findTestObject('Object Repository/Settings/Dashboard/first checkbox of the list'))
		WebUI.click(findTestObject('Object Repository/Settings/Dashboard/header/button_Edit'))
		WebUI.waitForElementVisible(findTestObject('Object Repository/Settings/Flags Settings/input_Reference'), 0)
		WebUI.setText(findTestObject('Object Repository/Settings/Flags Settings/input_Reference'), 'test3')
		WebUI.setText(findTestObject('Object Repository/Settings/Flags Settings/input_Name'), 'test3')
		WebUI.click(findTestObject('Object Repository/Settings/Flags Settings/input_Icon'))
		WebUI.sendKeys(findTestObject('Object Repository/Settings/Flags Settings/input_Icon'),Keys.chord(Keys.ENTER))
		WebUI.setText(findTestObject('Object Repository/Settings/Flags Settings/input_Color'), '"#bb00ff"')
		WebUI.click(findTestObject('Object Repository/Settings/Dashboard/button_Update'))
		WebUI.waitForElementVisible(findTestObject('Object Repository/Settings/Flags Settings/input_Reference Dashboard'), 0)
		WebUI.setText(findTestObject('Object Repository/Settings/Flags Settings/input_Reference Dashboard'), 'test3')
		WebUI.delay(3)
		WebUI.verifyElementVisible(findTestObject('Object Repository/Settings/Dashboard/first checkbox of the list'))
	}
	@Keyword
	def deleteFlag() {
		WebUI.click(findTestObject('Object Repository/Home Page/Sidebar/button_Settings'))
		WebUI.click(findTestObject('Object Repository/Settings/Breadcumbs/button_My company'))
		WebUI.click(findTestObject('Object Repository/Settings/Flags Settings/button_Flags'))
		WebUI.waitForElementVisible(findTestObject('Object Repository/Settings/Flags Settings/input_Reference Dashboard'), 0)
		WebUI.setText(findTestObject('Object Repository/Settings/Flags Settings/input_Reference Dashboard'), 'test3')
		WebUI.delay(3)
		WebUI.check(findTestObject('Object Repository/Settings/Dashboard/first checkbox of the list'))
		WebUI.click(findTestObject('Object Repository/Settings/Dashboard/header/button_Delete'))
		WebUI.click(findTestObject('Object Repository/Home Page/Modal/button_Yes_Cancel'))
		WebUI.waitForElementVisible(findTestObject('Object Repository/Settings/Flags Settings/input_Reference Dashboard'), 0)
		WebUI.setText(findTestObject('Object Repository/Settings/Flags Settings/input_Reference Dashboard'), 'test3')
		WebUI.delay(3)
		WebUI.verifyElementNotPresent(findTestObject('Object Repository/Settings/Dashboard/first checkbox of the list'), 0)
	}
}

