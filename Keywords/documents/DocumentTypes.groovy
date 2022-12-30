package documents

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

public class DocumentTypes {

	AutomaticActions automaticActions = new AutomaticActions();

	@Keyword
	def verifyShippingInstruction() {
		WebUI.waitForElementPresent(findTestObject('Object Repository/Pricing Page/Documents/TypeOfDoc - Shipping Instruction'), 0)
		WebUI.verifyElementPresent(findTestObject('Object Repository/Pricing Page/Documents/TypeOfDoc - Shipping Instruction'), 0)
	}

	@Keyword
	def verifyCertificatOrigine() {
		if(!(automaticActions.verifyCertificatOriginFranceExpected())) {
			WebUI.waitForElementNotPresent(findTestObject('Object Repository/Pricing Page/Documents/TypeOfDoc - Certificat Origine'),0)
			WebUI.verifyElementNotPresent(findTestObject('Object Repository/Pricing Page/Documents/TypeOfDoc - Certificat Origine'),0)
		}
		else {
			automaticActions.verifyCertificatOriginFranceExpected()
		}
	}

	@Keyword
	def verifyProformaSp() {
		if(!(automaticActions.verifyProformaSpFranceExpected())) {
			WebUI.waitForElementNotPresent(findTestObject('Object Repository/Pricing Page/Documents/TypeOfDoc -  Proforma SP'),0)
			WebUI.verifyElementNotPresent(findTestObject('Object Repository/Pricing Page/Documents/TypeOfDoc -  Proforma SP'),0)
		}
		else {
			automaticActions.verifyProformaSpFranceExpected()
		}
	}

	@Keyword
	def verifyDeliveryNote() {
		if(!(automaticActions.verifyDeliveryNoteFranceExpected())) {
			WebUI.waitForElementNotPresent(findTestObject('Object Repository/Pricing Page/Documents/TypeOfDoc - DeliveryNote'),0)
			WebUI.verifyElementNotPresent(findTestObject('Object Repository/Pricing Page/Documents/TypeOfDoc - DeliveryNote'),0)
		}
		else {
			automaticActions.verifyDeliveryNoteFranceExpected()
		}
	}

	@Keyword
	def verifyCites() {
		if(!(automaticActions.verifyCitesFranceExpected())) {
			WebUI.waitForElementNotPresent(findTestObject('Object Repository/Pricing Page/Documents/TypeOfDoc - CITES'),0)
			WebUI.verifyElementNotPresent(findTestObject('Object Repository/Pricing Page/Documents/TypeOfDoc - CITES'),0)
		}
		else {
			automaticActions.verifyCitesFranceExpected()
		}
	}

	@Keyword
	def verifyAWB() {
		WebUI.waitForElementPresent(findTestObject('Object Repository/Pricing Page/Documents/TypeOfDoc - AWB'), 0)
		WebUI.verifyElementPresent(findTestObject('Object Repository/Pricing Page/Documents/TypeOfDoc - AWB'), 0)
	}

	@Keyword
	def verfiyCMR() {
		WebUI.waitForElementPresent(findTestObject('Object Repository/Pricing Page/Documents/TypeOfDoc - CMR'), 0)
		WebUI.verifyElementPresent(findTestObject('Object Repository/Pricing Page/Documents/TypeOfDoc - CMR'), 0)
	}

	@Keyword
	def verfiyOther() {
		WebUI.waitForElementPresent(findTestObject('Object Repository/Pricing Page/Documents/TypeOfDoc - Other'), 0)
		WebUI.verifyElementPresent(findTestObject('Object Repository/Pricing Page/Documents/TypeOfDoc - Other'), 0)
	}
}
