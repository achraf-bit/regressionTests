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

CustomKeywords.'auth.Login.loginSuperAdmin'()

CustomKeywords.'modules.Transport.openDashboardTransport'()

CustomKeywords.'modules.Transport.openTrFromDashboard'('ESC-A16309')

CustomKeywords.'modules.Transport.clickDuplicateOnTrForm'()

customerReference = CustomKeywords.'modules.Transport.fillCustomerReference'()

CustomKeywords.'modules.Transport.confirmFirstValorizedQuoteOnTrForm'()

CustomKeywords.'modules.Transport.cancelTrOnTrForm'()

CustomKeywords.'modules.Transport.clickDuplicateOnTrForm'()

CustomKeywords.'modules.Transport.clickSaveAsPendingOnTrForm'()

CustomKeywords.'modules.Transport.cancelTrOnTrForm'()

WebUI.closeBrowser()

