package modules

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

public class Transport {
	@Keyword
	def openDashboardPricing() {
		WebUI.click(findTestObject('TMS Commons/Header/Menu Module button'))
		WebUI.click(findTestObject('TMS Commons/Header/Module Pricing button'))
		WebUI.waitForElementPresent(findTestObject('Object Repository/Transport/List/Pricing-Transport List Any Header'), 20)
		WebUI.delay(2)
	}

	@Keyword
	def openDashboardTransport() {
		WebUI.click(findTestObject('TMS Commons/Header/Menu Module button'))
		WebUI.click(findTestObject('Object Repository/TMS Commons/Header/Module Transport button'))
		WebUI.waitForElementPresent(findTestObject('Object Repository/Transport/List/Pricing-Transport List Any Header'), 20)
		WebUI.delay(2)
	}

	@Keyword
	def openTrFromDashboard(String trReference) {
		WebUI.setText(findTestObject('Transport/List/Search by term'), trReference)
		WebUI.click(findTestObject('Transport/List/First checkbox of list'))
		WebUI.click(findTestObject('Transport/List/Edit Button'))
		WebUI.waitForElementVisible(findTestObject('Transport/Form/Header/Breadcrumb - Ref TR'), 10)
	}

	@Keyword
	def openTrOnPricingUsingUrl(String trId) {
		WebUI.navigateToUrl(GlobalVariable.app_url + '/app/pricing/details/' + trId);
		WebUI.waitForElementVisible(findTestObject('Transport/Form/Header/Breadcrumb - Ref TR'), 60)
	}

	@Keyword
	def openTrOnTransportUsingUrl(String trId) {
		WebUI.navigateToUrl(GlobalVariable.app_url + '/app/transport-management/details/' + trId);
	}

	@Keyword
	def accessToFirstTrDetails() {
		WebUI.waitForElementVisible(findTestObject('Object Repository/Transport/List/First checkbox of list'), 0)
		WebUI.check(findTestObject('Object Repository/Transport/List/First checkbox of list'))
		WebUI.click(findTestObject('Transport/List/Edit Button'))
		WebUI.verifyElementPresent(findTestObject('Object Repository/Pricing Page/Breadcrumbs/tr_Reference'),0)
	}

	@Keyword
	def cancelTrAfterConfirmation() {
		WebUI.click(findTestObject('Pricing Page/Breadcrumbs/button_Menu'))
		WebUI.click(findTestObject('Pricing Page/Breadcrumbs/button_Cancel'))
		WebUI.click(findTestObject('Home Page/Modal/button_Yes_Cancel'))
		WebUI.waitForElementVisible(findTestObject('Pricing Page/Header/status_TR_Cancelled'), 0)
		WebUI.verifyElementVisible(findTestObject('Pricing Page/Header/status_TR_Cancelled'))
	}

	@Keyword
	def clickDuplicateOnTrForm() {
		WebUI.waitForElementVisible(findTestObject('Transport/Form/ActionButton/Action Button - More'), 10)
		WebUI.click(findTestObject('Transport/Form/ActionButton/Action Button - More'))
		WebUI.click(findTestObject('Transport/Form/ActionButton/Action Button - Duplicate'))
		WebUI.waitForElementNotPresent(findTestObject('Object Repository/TMS Commons/Form/Form global loader'), 30)
		WebUI.waitForElementVisible(findTestObject('Transport/Form/Header/StatusBar Status Chip'), 10)
		WebUI.verifyElementText(findTestObject('Transport/Form/Header/StatusBar Status Chip'), 'Not saved')
	}

	@Keyword
	def clickSaveAsPendingOnTrForm() {
		WebUI.click(findTestObject('Transport/Form/ActionButton/Action Button - Save as pending'))
		WebUI.waitForElementNotPresent(findTestObject('Object Repository/TMS Commons/Form/Form global loader'), 30)
		WebUI.waitForElementVisible(findTestObject('Transport/Form/Header/Breadcrumb - Ref TR'), 10)
		WebUI.verifyElementText(findTestObject('Transport/Form/Header/StatusBar Status Chip'), 'Pending')
	}

	@Keyword
	def confirmFirstValorizedQuoteOnTrForm() {
		WebUI.waitForElementVisible(findTestObject('Transport/Form/Quotations/First valorized quote - Checkbox'), 20)
		WebUI.check(findTestObject('Transport/Form/Quotations/First valorized quote - Checkbox'))
		WebUI.click(findTestObject('Transport/Form/Quotations/First valorized quote - Select for confirmation'))
		WebUI.click(findTestObject('Transport/Form/ActionButton/Action Button - Confirm quote'))
		WebUI.waitForElementNotPresent(findTestObject('Object Repository/TMS Commons/Form/Form global loader'), 30)
		WebUI.waitForElementVisible(findTestObject('Transport/Form/Header/Header Stepper'), 20)
	}

	@Keyword
	def askQuotationFirstCarrierOnTrForm() {
		WebUI.waitForElementVisible(findTestObject('Transport/Form/Quotations/First quote - Checkbox'), 20)
		WebUI.check(findTestObject('Transport/Form/Quotations/First quote - Checkbox'))
		WebUI.click(findTestObject('Transport/Form/ActionButton/Action Button - Ask quotation'))
		WebUI.waitForElementNotPresent(findTestObject('Object Repository/TMS Commons/Form/Form global loader'), 30)
		WebUI.waitForElementVisible(findTestObject('Transport/Form/Header/Header Stepper'), 20)
	}

	@Keyword
	def cancelTrOnTrForm() {
		WebUI.click(findTestObject('Transport/Form/ActionButton/Action Button - More'))
		WebUI.click(findTestObject('Transport/Form/ActionButton/Action Button - Cancel'))
		WebUI.click(findTestObject('TMS Commons/Modal/Modal (old) yes button'))
		WebUI.waitForElementNotPresent(findTestObject('Object Repository/TMS Commons/Form/Form global loader'), 30)
		WebUI.waitForElementPresent(findTestObject('Transport/Form/Header/StatusBar Status Chip'), 20)
		WebUI.verifyElementText(findTestObject('Transport/Form/Header/StatusBar Status Chip'), 'Cancelled')
	}

	@Keyword
	def getTrReferenceFromForm() {
		def breadcrumbText = WebUI.getText(findTestObject('Object Repository/Transport/Form/Header/Breadcrumb - Ref TR')).trim()
		def refTr = breadcrumbText
		if(breadcrumbText.contains(" (")) {
			refTr = refTr.substring(0, refTr.indexOf(" ("))
		}
		return refTr
	}

	@Keyword
	def fillCustomerReference() {
		def generatedCustomerRef = "KATALON-" + System.currentTimeMillis()
		WebUI.setText(findTestObject('Object Repository/Transport/Form/Field/Field - Customer Reference'), generatedCustomerRef)
		return generatedCustomerRef
	}
}
