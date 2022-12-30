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

public class TransportaionPlans {

	@Keyword
	def addTransportaionPlanValorization(){
		WebUI.click(findTestObject('Object Repository/Home Page/Sidebar/button_Settings'))
		WebUI.click(findTestObject('Object Repository/Settings/Breadcumbs/button_My company'))
		WebUI.click(findTestObject('Object Repository/Settings/Transportation Plans Settings/button_Transportation plans'))
		WebUI.click(findTestObject('Object Repository/Settings/Transportation Plans Settings/button_Add_Transportation plans'))
		WebUI.setText(findTestObject('Object Repository/Settings/Transportation Plans Settings/input_Reference_transportPlan'), 'AUT')
		WebUI.setText(findTestObject('Object Repository/Settings/Transportation Plans Settings/input_Type Transportation plan'), 'Transportation')
		WebUI.sendKeys(findTestObject('Object Repository/Settings/Transportation Plans Settings/input_Type Transportation plan'), Keys.chord(Keys.ENTER))
		WebUI.click(findTestObject('Object Repository/Settings/Transportation Plans Settings/button_Add field Inputs'))
		WebUI.setText(findTestObject('Object Repository/Settings/Transportation Plans Settings/input__First Field Input'), 'Carrier Code')
		WebUI.sendKeys(findTestObject('Object Repository/Settings/Transportation Plans Settings/input__First Field Input'), Keys.chord(Keys.ENTER))
		WebUI.setText(findTestObject('Object Repository/Settings/Transportation Plans Settings/input_First Value Input'), 'AUT')
		WebUI.sendKeys(findTestObject('Object Repository/Settings/Transportation Plans Settings/input_First Value Input'), Keys.chord(Keys.ENTER))
		WebUI.click(findTestObject('Object Repository/Settings/Transportation Plans Settings/button_Add Field Outputs'))
		WebUI.setText(findTestObject('Object Repository/Settings/Transportation Plans Settings/input_First Field Output'), 'Carrier')
		WebUI.sendKeys(findTestObject('Object Repository/Settings/Transportation Plans Settings/input_First Field Output'), Keys.chord(Keys.ENTER))
		WebUI.setText(findTestObject('Object Repository/Settings/Transportation Plans Settings/input_First Value Output'), 'M')
		WebUI.sendKeys(findTestObject('Object Repository/Settings/Transportation Plans Settings/input_First Value Output'), Keys.chord(Keys.ENTER))
		WebUI.click(findTestObject('Object Repository/Settings/Transportation Plans Settings/button_Add Field Outputs'))
		WebUI.setText(findTestObject('Object Repository/Settings/Transportation Plans Settings/input_Seconde Field Output'),"Price")
		WebUI.sendKeys(findTestObject('Object Repository/Settings/Transportation Plans Settings/input_Seconde Field Output'), Keys.chord(Keys.ENTER))
		WebUI.setText(findTestObject('Object Repository/Settings/Transportation Plans Settings/input_Seconde Value Output'),"2")
		WebUI.sendKeys(findTestObject('Object Repository/Settings/Transportation Plans Settings/input_Seconde Value Output'), Keys.chord(Keys.ENTER))
		WebUI.click(findTestObject('Object Repository/Home Page/Modal/button_Save'))
		WebUI.waitForElementVisible(findTestObject('Object Repository/Growl Notification/flash_Notice_Operation successfully completed'), 0,FailureHandling.CONTINUE_ON_FAILURE)
		WebUI.verifyElementVisible(findTestObject('Object Repository/Growl Notification/flash_Notice_Operation successfully completed'),FailureHandling.CONTINUE_ON_FAILURE)
	}

	@Keyword
	def deleteTransportationPlanValorization(){
		WebUI.click(findTestObject('Object Repository/Home Page/Sidebar/button_Settings'))
		WebUI.click(findTestObject('Object Repository/Settings/Breadcumbs/button_My company'))
		WebUI.click(findTestObject('Object Repository/Settings/Transportation Plans Settings/button_Transportation plans'))
		WebUI.waitForElementVisible(findTestObject('Object Repository/Settings/Transportation Plans Settings/input_Reference Transportations Plans Dashboard'), 0)
		WebUI.setText(findTestObject('Object Repository/Settings/Transportation Plans Settings/input_Reference Transportations Plans Dashboard'), 'AUT')
		WebUI.delay(3)
		WebUI.waitForElementVisible(findTestObject('Object Repository/Settings/Transportation Plans Settings/first checkbox'), 0)
		WebUI.check(findTestObject('Object Repository/Settings/Transportation Plans Settings/first checkbox'))
		WebUI.click(findTestObject('Object Repository/Settings/Transportation Plans Settings/button_delete_Transportation plans'))
		WebUI.click(findTestObject('Object Repository/Home Page/Modal/button_Ok'))
		WebUI.waitForElementVisible(findTestObject('Object Repository/Growl Notification/flash_Notice_Operation successfully completed'), 0,FailureHandling.CONTINUE_ON_FAILURE)
		WebUI.verifyElementVisible(findTestObject('Object Repository/Growl Notification/flash_Notice_Operation successfully completed'),FailureHandling.CONTINUE_ON_FAILURE)
	}

	@Keyword
	def verifyVisibiltyOfVignetteCarrierInTR(){
		WebUI.waitForElementVisible(findTestObject('Object Repository/Pricing Page/Form/input_Carrier Code'), 0)
		WebUI.setText(findTestObject('Object Repository/Pricing Page/Form/input_Carrier Code'), 'GTL')
		WebUI.click(findTestObject('Object Repository/Pricing Page/Form/button_Refresh quotes'))
		WebUI.click(findTestObject('Object Repository/Pricing Page/Breadcrumbs/button_Save'))
		WebUI.waitForElementVisible(findTestObject('Object Repository/Growl Notification/flash_Notice_Operation successfully completed'),0,FailureHandling.CONTINUE_ON_FAILURE)
		WebUI.verifyElementVisible(findTestObject('Object Repository/Growl Notification/flash_Notice_Operation successfully completed'),FailureHandling.CONTINUE_ON_FAILURE)
		WebUI.waitForElementVisible(findTestObject('Object Repository/Pricing Page/Form/vignette last carrier name'), 0)	
		def carrierName = WebUI.getText(findTestObject('Object Repository/Pricing Page/Form/vignette last carrier name'))
		def carrierPrice = WebUI.getText(findTestObject('Object Repository/Pricing Page/Form/vignette carrier price'))
		WebUI.verifyMatch(carrierName, 'International (GTL International)', false,FailureHandling.CONTINUE_ON_FAILURE)
		WebUI.verifyMatch(carrierPrice, '1 EUR', false,FailureHandling.CONTINUE_ON_FAILURE)
	}
}
