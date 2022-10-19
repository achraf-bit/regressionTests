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
import org.openqa.selenium.By as By
import org.openqa.selenium.Keys as Keys

String typeOfShipment = 'KATALON-' + System.currentTimeMillis()

CustomKeywords.'auth.Login.loginSuperAdmin'()

CustomKeywords.'modules.Transport.openTrOnPricingUsingUrl'('16178')

CustomKeywords.'modules.Transport.clickDuplicateOnTrForm'()

WebUI.setText(findTestObject('Transport/Form/Field/Field - Type Of Shipment'), typeOfShipment)

CustomKeywords.'modules.Transport.fillCustomerReference'()

CustomKeywords.'modules.Transport.askQuotationFirstCarrierOnTrForm'()

def refTr1 = CustomKeywords.'modules.Transport.getTrReferenceFromForm'()

CustomKeywords.'modules.Transport.clickDuplicateOnTrForm'()

CustomKeywords.'modules.Transport.fillCustomerReference'()

CustomKeywords.'modules.Transport.askQuotationFirstCarrierOnTrForm'()

def refTr2 = CustomKeywords.'modules.Transport.getTrReferenceFromForm'()

CustomKeywords.'modules.Transport.openDashboardPricing'()

WebUI.click(findTestObject('Transport/List/ActionButton/Action Button - Consolidation propositions'))

for (int refreshPropRetryCount = 0; refreshPropRetryCount < 3; refreshPropRetryCount++) {
    def waitFailureHandling = refreshPropRetryCount == 2 ? FailureHandling.STOP_ON_FAILURE : FailureHandling.OPTIONAL

    if (!(WebUI.waitForElementPresent(findTestObject('Object Repository/Transport/Consolidation Propositions/First checkbox of list'), 
        30, waitFailureHandling))) {
        WebUI.click(findTestObject('Object Repository/Transport/Consolidation Propositions/Action Button - Refresh'))

        continue
    }
    
    WebUI.setText(findTestObject('Object Repository/Transport/Consolidation Propositions/QuickFilter - TypeOfShipment (CustomLayout 0)'), 
        typeOfShipment)

    if (!(WebUI.waitForElementPresent(findTestObject('Object Repository/Transport/Consolidation Propositions/First checkbox of list'), 
        30, waitFailureHandling))) {
        WebUI.click(findTestObject('Object Repository/Transport/Consolidation Propositions/Action Button - Refresh'))

        continue
    } else {
        break
    }
}

WebUI.click(findTestObject('Object Repository/Transport/Consolidation Propositions/First checkbox of list'))

WebUI.click(findTestObject('Object Repository/Transport/Consolidation Propositions/Btn open proposition in form'))

WebUI.waitForElementVisible(findTestObject('Transport/Form/Header/StatusBar Status Chip'), 0)

WebUI.verifyElementText(findTestObject('Transport/Form/Header/StatusBar Status Chip'), 'Not saved')

WebUI.verifyElementChecked(findTestObject('Transport/Form/Field/Field - Consolidated - Yes'), 0)

WebUI.closeBrowser()

