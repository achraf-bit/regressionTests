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
import org.openqa.selenium.Keys as Keys
import internal.GlobalVariable

public class Pricing {

	@Keyword
	def CreateNewTr() {
		WebUI.click(findTestObject('Home Page/Navbar/Add Button/button_Add'))
		WebUI.click(findTestObject('Home Page/Navbar/Add Button/button_Transport_Request'))
		WebUI.waitForElementVisible(findTestObject('Object Repository/Pricing Page/Form/select_tet'),0)
		WebUI.click(findTestObject('Object Repository/Pricing Page/Form/select_tet'))
		WebUI.sendKeys(findTestObject('Object Repository/Pricing Page/Form/select_tet'),Keys.chord(Keys.DOWN))
		WebUI.sendKeys(findTestObject('Object Repository/Pricing Page/Form/select_tet'),Keys.chord(Keys.ENTER))
		WebUI.click(findTestObject('Pricing Page/Form/input_From_Form'))
		WebUI.click(findTestObject('Pricing Page/Form/first_Address_Proposal'))
		WebUI.click(findTestObject('Pricing Page/Form/input_To_form'))
		WebUI.click(findTestObject('Pricing Page/Form/second_Address_Proposal'))
		WebUI.click(findTestObject('Pricing Page/Form/button_Mode_Of_Transport Air'))
		WebUI.click(findTestObject('Pricing Page/Form/input_Type_Of_Flow'))
		WebUI.click(findTestObject('Pricing Page/Form/type_Of_Flow_Grand Export Chanel (Door to Airport)'))
		WebUI.click(findTestObject('Pricing Page/Form/input_Incoterm'))
		WebUI.click(findTestObject('Pricing Page/Form/icoterm_DAP'))
		WebUI.click(findTestObject('Pricing Page/Form/input_PSL_Shema'))
		WebUI.click(findTestObject('Pricing Page/Form/PSL_Shema_Grand Export Chanel (Door to Airport)'))
		WebUI.waitForElementVisible(findTestObject('Pricing Page/Form/button_Mode_Of_Transport Air'), 0)
		WebUI.setText(findTestObject('Pricing Page/Form/input_Date of goods availability'), '14/10/2022')
		fillCustomerReference()
		WebUI.setText(findTestObject('Pricing Page/Form/input_Carrier Code'), 'SAF')
		WebUI.setText(findTestObject('Pricing Page/Form/input_Type_Of_Shipment'), 'testAuto')
		WebUI.click(findTestObject('Pricing Page/Form/select_Service_Level'))
		WebUI.click(findTestObject('Pricing Page/Form/service_Level Standard'))
		WebUI.click(findTestObject('Pricing Page/Form/select_Invoice_Currency'))
		WebUI.click(findTestObject('Pricing Page/Form/Invoice_Currency Euro'))
		WebUI.click(findTestObject('Pricing Page/Form/button_Add_Unit'))
		WebUI.setText(findTestObject('Pricing Page/Form/input_UnitReference'), '123')
		WebUI.setText(findTestObject('Pricing Page/Form/input_Quantity'), '10')
		WebUI.click(findTestObject('Pricing Page/Form/button_Save_An_Article'))
	}


	@Keyword
	def accessToPricing() {
		WebUI.click(findTestObject('Home Page/Navbar/Module/button_Module'))
		WebUI.click(findTestObject('Home Page/Navbar/Module/button_Module_Pricing'))
		WebUI.verifyElementVisible(findTestObject('Pricing Page/Access To Pricing/a_Pricing'))
	}

	@Keyword
	def getTrReference() {
		WebUI.waitForElementVisible(findTestObject('Object Repository/Pricing Page/Form/input_Customer_Reference'), 0)
		def  refCustomer = WebUI.getAttribute(findTestObject('Object Repository/Pricing Page/Form/input_Customer_Reference'), 'value')
		return refCustomer
	}

	@Keyword
	def fillCustomerReference() {
		def generatedCustomerRef = "ref" + System.currentTimeMillis()
		WebUI.setText(findTestObject('Pricing Page/Form/input_Customer_Reference'), generatedCustomerRef)
		return generatedCustomerRef
	}

	@Keyword
	def accessToFirstTrDetails() {
		WebUI.waitForElementVisible(findTestObject('Pricing Page/TR Details/checkbox_TR'), 0)
		WebUI.check(findTestObject('Pricing Page/TR Details/checkbox_TR'))
		WebUI.click(findTestObject('Pricing Page/TR Details/button_View'))
		WebUI.verifyElementPresent(findTestObject('Object Repository/Pricing Page/Breadcrumbs/tr_Reference'),0)
		getTrReference()
	}

	@Keyword

	def saveAsPending() {
		WebUI.click(findTestObject('Pricing Page/Breadcrumbs/button_Save_As_Pending'))
		WebUI.waitForElementVisible(findTestObject('Pricing Page/Breadcrumbs/div_Pending'), 0)
		WebUI.verifyElementVisible(findTestObject('Pricing Page/Breadcrumbs/div_Pending'))
	}


	@Keyword
	def duplicateTr() {
		WebUI.setText(findTestObject('Pricing Page/Form/input_Search_By_Term'), 'DNS027317')
		WebUI.delay(5)
		WebUI.sendKeys(findTestObject('Pricing Page/Form/input_Search_By_Term'),Keys.chord(Keys.ENTER))
		accessToFirstTrDetails();
		WebUI.click(findTestObject('Pricing Page/Breadcrumbs/button_Menu'))
		WebUI.click(findTestObject('Pricing Page/Breadcrumbs/button_Duplicate'))
		WebUI.delay(5)
		WebUI.click(findTestObject('Pricing Page/Form/radio_EligibleForConsolidation'))
		WebUI.click(findTestObject('Pricing Page/Form/button_References'))
		fillCustomerReference()
		WebUI.setText(findTestObject('Pricing Page/Form/input_Type_Of_Shipment'), 'testAuto')
	}

	@Keyword
	def selectCarrier() {
		WebUI.click(findTestObject('Pricing Page/Confirm Pending/button_Pricing'))
		WebUI.click(findTestObject('Pricing Page/Confirm Pending/checkbox_Carrier'))
	}

	@Keyword
	def selectCarrierWithValorization() {
		WebUI.click(findTestObject('Pricing Page/Confirm Pending/checkbox_Carrier_With_Valorization'))
	}

	@Keyword
	def confirmPending() {
		WebUI.click(findTestObject('Pricing Page/Confirm Pending/button_Confirm_Pending'))
		WebUI.waitForElementVisible(findTestObject('Pricing Page/Confirm Pending/div_In process waiting for quote'),0)
		WebUI.verifyElementVisible(findTestObject('Pricing Page/Confirm Pending/div_In process waiting for quote'))
	}

	@Keyword
	def verifyAlert() {
		WebUI.verifyElementVisible(findTestObject('Home Page/Navbar/Notifications/notification'))
		WebUI.click(findTestObject('Home Page/Navbar/Notifications/button_Bell'))
		WebUI.click(findTestObject('Home Page/Navbar/Notifications/div_Alert'))
		WebUI.click(findTestObject('Home Page/Navbar/Notifications/button_Bell'))
	}

	@Keyword
	def addQuotation() {
		WebUI.click(findTestObject('Pricing Page/Add Quotation/button_Pricing'))
		WebUI.click(findTestObject('Pricing Page/Add Quotation/add_Quotation'))
		WebUI.setText(findTestObject('Pricing Page/Add Quotation/input_Total_Time'), '48')
		WebUI.setText(findTestObject('Pricing Page/Add Quotation/input_Total_Price'), '200000')
		WebUI.click(findTestObject('Pricing Page/Add Quotation/validate_Quotation'))
		WebUI.click(findTestObject('Pricing Page/Breadcrumbs/button_Save'))
		WebUI.verifyElementVisible(findTestObject('Pricing Page/Add Quotation/div_Waiting for confirmation'))
	}

	@Keyword
	def confirmQuotation() {
		WebUI.click(findTestObject('Pricing Page/Add Quotation/button_Pricing'))
		WebUI.click(findTestObject('Pricing Page/Confirm Quotation/select_For_Confirmation'))
		WebUI.click(findTestObject('Pricing Page/Confirm Quotation/button_Confirm_Quote'))
		WebUI.waitForElementVisible(findTestObject('Pricing Page/Confirm Quotation/waiting for pick up'),0)
		WebUI.verifyElementVisible(findTestObject('Pricing Page/Confirm Quotation/waiting for pick up'))
	}

	@Keyword
	def consolidateTr() {
		WebUI.click(findTestObject('Pricing Page/Consolidation/button_Consolidation propositions'))
		WebUI.click(findTestObject('Pricing Page/Consolidation/button_Calculate_Consolidation'))
		WebUI.verifyElementVisible(findTestObject('Object Repository/Growl Notification/flash_Notice_Propositions calculation will start'))
		WebUI.click(findTestObject('Object Repository/Growl Notification/button_Close'))
		WebUI.delay(3)
		WebUI.click(findTestObject('Pricing Page/Consolidation/button_Refresh_Consolidation'))
		WebUI.delay(3)
		WebUI.waitForElementVisible(findTestObject('Pricing Page/Consolidation/input_Type_Of_Shipment'), 0)
		WebUI.waitForElementVisible(findTestObject('Pricing Page/TR Details/checkbox_TR'), 0)
		WebUI.setText(findTestObject('Pricing Page/Consolidation/input_Type_Of_Shipment'), 'testAuto')
		WebUI.delay(3)
		WebUI.waitForElementVisible(findTestObject('Pricing Page/TR Details/checkbox_TR'), 0)
		WebUI.click(findTestObject('Pricing Page/TR Details/checkbox_TR'))
		WebUI.click(findTestObject('Pricing Page/Consolidation/button_Open_In_Creation_Form'))
	}

	@Keyword
	def addTrToConsolidationPropositions() {
		WebUI.click(findTestObject('Object Repository/Pricing Page/Consolidation/button_Consolidation'))
		WebUI.click(findTestObject('Object Repository/Pricing Page/Consolidation/input_Select a transport request to add it to the consolidation'))
		WebUI.click(findTestObject('Object Repository/Pricing Page/Consolidation/select_First element from the list'))
		WebUI.click(findTestObject('Object Repository/Pricing Page/Consolidation/button_Update consolidation info'))
		WebUI.click(findTestObject('Object Repository/Home Page/Modal/button_Ok'))
		WebUI.waitForElementVisible(findTestObject('Object Repository/Growl Notification/flash_Notice_Operation successfully completed'), 0)
		WebUI.verifyElementVisible(findTestObject('Object Repository/Growl Notification/flash_Notice_Operation successfully completed'))
	}

	@Keyword
	def fillRequiredFieldAfterConsolidation() {
		if(WebUI.verifyElementVisible(findTestObject('Pricing Page/Form/input_From_Form'),FailureHandling.OPTIONAL)) {
			WebUI.click(findTestObject('Pricing Page/Form/input_From_Form'))
			WebUI.click(findTestObject('Pricing Page/Form/first_Address_Proposal'))
		}

		if(WebUI.verifyElementVisible(findTestObject('Pricing Page/Form/input_To_form'),FailureHandling.OPTIONAL)) {
			WebUI.click(findTestObject('Pricing Page/Form/input_To_form'))
			WebUI.click(findTestObject('Pricing Page/Form/second_Address_Proposal'))
		}

		if(WebUI.verifyElementVisible(findTestObject('Pricing Page/Form/input_Type_Of_Flow'),FailureHandling.OPTIONAL)) {
			WebUI.click(findTestObject('Pricing Page/Form/input_Type_Of_Flow'))
			WebUI.click(findTestObject('Pricing Page/Form/type_Of_Flow_Grand Export Chanel (Door to Airport)'))
		}

		if(WebUI.verifyElementVisible(findTestObject('Pricing Page/Form/input_Incoterm'),FailureHandling.OPTIONAL)) {
			WebUI.click(findTestObject('Pricing Page/Form/input_Incoterm'))
			WebUI.click(findTestObject('Pricing Page/Form/icoterm_DAP'))
		}
		if(WebUI.verifyElementVisible(findTestObject('Pricing Page/Form/input_PSL_Shema'),FailureHandling.OPTIONAL)) {
			WebUI.click(findTestObject('Pricing Page/Form/input_PSL_Shema'))
			WebUI.click(findTestObject('Pricing Page/Form/PSL_Shema_Grand Export Chanel (Door to Airport)'))
		}
		WebUI.setText(findTestObject('Pricing Page/Form/input_Date of goods availability'), '14/10/2022')
		WebUI.setText(findTestObject('Pricing Page/Form/input_Carrier Code'), 'SAF')
	}

	@Keyword
	def addMask() {
		WebUI.click(findTestObject('Pricing Page/Breadcrumbs/button_Menu'))
		WebUI.click(findTestObject('Pricing Page/Breadcrumbs/button_Mask'))
		WebUI.setText(findTestObject('Home Page/Modal/input_Mask_Title'), 'test Auto')
		WebUI.click(findTestObject('Home Page/Modal/button_Save_Mask'))
		if (WebUI.verifyElementVisible(findTestObject('Home Page/Modal/button_Save_Mask'))) {
			WebUI.click(findTestObject('Home Page/Modal/button_Save_Mask'))
		}
		WebUI.click(findTestObject('Home Page/Sidebar/button_List'))
		WebUI.verifyElementVisible(findTestObject('Home Page/Sidebar/Mask_test Auto'))
	}

	@Keyword
	def saveTR() {
		WebUI.click(findTestObject('Pricing Page/Breadcrumbs/button_Save'))
		WebUI.waitForElementVisible(findTestObject('Object Repository/Growl Notification/flash_Notice_Operation successfully completed'), 0)
		WebUI.verifyElementVisible(findTestObject('Object Repository/Growl Notification/flash_Notice_Operation successfully completed'))
	}
}
