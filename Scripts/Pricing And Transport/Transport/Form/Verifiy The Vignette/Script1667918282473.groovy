import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys


import java.awt.event.InputEvent;
CustomKeywords.'auth.Login.loginSuperAdmin'()
WebUI.click(findTestObject('Object Repository/Home Page/Sidebar/button_Settings'))
WebUI.click(findTestObject('Object Repository/Settings/Breadcumbs/button_My company'))
WebUI.click(findTestObject('Object Repository/Settings/Transportation Plans Settings/button_Transportation plans'))
WebUI.waitForElementVisible(findTestObject('Object Repository/Settings/Transportation Plans Settings/input_Reference Transportations Plans Dashboard'), 0)
WebUI.setText(findTestObject('Object Repository/Settings/Transportation Plans Settings/input_Reference Transportations Plans Dashboard'), 'DAH')
WebUI.delay(3)
WebUI.waitForElementVisible(findTestObject('Object Repository/Settings/Transportation Plans Settings/first checkbox'), 0)
WebUI.check(findTestObject('Object Repository/Settings/Transportation Plans Settings/first checkbox'))
WebUI.click(findTestObject('Object Repository/Settings/Transportation Plans Settings/button_Edit Transportation plans'))
WebUI.waitForElementVisible(findTestObject('Object Repository/Settings/Transportation Plans Settings/input_Transportation Plans Carrier Name'), 0)
carrierValue1 =  WebUI.getText(findTestObject('Object Repository/Settings/Transportation Plans Settings/input_Transportation Plans Carrier Name'))
carrierPrice1 =  WebUI.getText(findTestObject('Object Repository/Settings/Transportation Plans Settings/input_Transportation Plans Carrier Price'))
println(carrierValue1)
println(carrierPrice1)
WebUI.click(findTestObject('Object Repository/Home Page/Modal/button_Close'))
CustomKeywords.'modules.Pricing.accessToPricing'()
WebUI.setText(findTestObject('Object Repository/Pricing Page/Dashboard/input_Carrier Code Dashboard'), 'DAH')
WebUI.delay(3)
CustomKeywords.'modules.Pricing.accessToFirstTrDetails'()
WebUI.waitForElementVisible(findTestObject('Object Repository/Pricing Page/Form/vignette carrier name'), 0)
def carrierName = WebUI.getText(findTestObject('Object Repository/Pricing Page/Form/vignette carrier name'))
def carrierPrice = WebUI.getText(findTestObject('Object Repository/Pricing Page/Form/vignette carrier price'))
WebUI.verifyMatch(carrierName, carrierValue1.replace(/^(\S+)/, ''), false,FailureHandling.CONTINUE_ON_FAILURE)
WebUI.verifyMatch(carrierPrice,carrierPrice1, false,FailureHandling.CONTINUE_ON_FAILURE)
println(carrierName)
println(carrierPrice)
