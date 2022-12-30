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
import groovy.json.JsonSlurper as JsonSlurper
import com.kms.katalon.core.testobject.RequestObject as RequestObject
import org.openqa.selenium.WebElement as WebElement
import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import org.openqa.selenium.WebDriver
import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory
import org.openqa.selenium.By;

def request = ((findTestObject('Object Repository/API Testing/Create TR')) as RequestObject)
def requestJson = request.getHttpBody();

JsonSlurper slurper = new JsonSlurper()
Map parsedJson = slurper.parseText(requestJson)

// TR Creation using API
def createResponse = WS.sendRequest(request)
WS.verifyResponseStatusCode(createResponse, 200)
Map parsedResponseJson = slurper.parseText(createResponse.getResponseText())
def trRef = parsedResponseJson['transportReference']
// END TR Creation using API


CustomKeywords.'auth.Login.loginSuperAdmin'()
CustomKeywords.'modules.Pricing.accessToPricing'()
CustomKeywords.'modules.Pricing.accessToFirstTrDetails'()


//get code Incoterm 
value = WebUI.getAttribute(findTestObject('Object Repository/Pricing Page/Form/input_Incoterm2'), 'innerText')
WebUI.verifyMatch(value, parsedJson['incotermCode'], true, FailureHandling.CONTINUE_ON_FAILURE)
println(value)

//get PSL Schema
value = WebUI.getAttribute(findTestObject('Object Repository/Pricing Page/Form/input_PSL_Shema2'), 'innerText')
WebUI.verifyMatch(value, parsedJson['pslSchemaCode'], true, FailureHandling.CONTINUE_ON_FAILURE)
println(value)

//get mode of transport
value = WebUI.getAttribute(findTestObject('Object Repository/Pricing Page/Form/button_Mode_Of_Transport'), 'innerText')
WebUI.verifyMatch(value.toUpperCase(), parsedJson['transportMethod'], true, FailureHandling.CONTINUE_ON_FAILURE)
println(value)

//verify eligible for consolidation
if (parsedJson['eligibleForConsolidation']) {
    WebUI.verifyElementChecked(findTestObject('Object Repository/Pricing Page/Form/radio_EligibleForConsolidation'), 10, FailureHandling.CONTINUE_ON_FAILURE)
} else {
    WebUI.verifyElementNotChecked(findTestObject('Object Repository/Pricing Page/Form/radio_EligibleForConsolidation', FailureHandling.CONTINUE_ON_FAILURE), 
        10)
}

//get date of goods availability
value = WebUI.getAttribute(findTestObject('Object Repository/Pricing Page/Form/input_Date of goods availability'), 'value')
WebUI.verifyMatch(value, (parsedJson['dateOfGoodsAvailability']).substring(0, 10), true, FailureHandling.CONTINUE_ON_FAILURE)
println(value)

//get Owner of the request from settings
WebUI.click(findTestObject('Object Repository/Home Page/Sidebar/button_Settings'))
WebUI.click(findTestObject('Object Repository/Settings/Breadcumbs/button_My company'))
WebUI.click(findTestObject('Object Repository/Settings/Users Settings/button_Users'))
WebUI.waitForElementVisible(findTestObject('Object Repository/Settings/Users Settings/input_Email Users'), 0)
WebUI.setText(findTestObject('Object Repository/Settings/Users Settings/input_Email Users'),parsedJson['shipperUserEmail'])
WebUI.delay(3)
user = WebUI.getText(findTestObject('Object Repository/Transport/List/first cell in a row'))
//get type of flow from settings
WebUI.click(findTestObject('Object Repository/Home Page/Sidebar/button_Settings'))
WebUI.click(findTestObject('Object Repository/Settings/Breadcumbs/button_My company'))
WebUI.click(findTestObject('Object Repository/Settings/Type of Flow Settings/button_Type of flow'))
WebUI.waitForElementVisible(findTestObject('Object Repository/Settings/Type of Flow Settings/input_Type of flow code'), 0)
WebUI.setText(findTestObject('Object Repository/Settings/Type of Flow Settings/input_Type of flow code'),parsedJson['typeOfFlowCode'])
WebUI.delay(3)
typeOfFlowCode = WebUI.getText(findTestObject('Object Repository/Transport/List/first cell in a row'))
//get address destination from settings
WebUI.click(findTestObject('Object Repository/Home Page/Sidebar/button_Settings'))
WebUI.click(findTestObject('Object Repository/Settings/Breadcumbs/button_My company'))
WebUI.click(findTestObject('Object Repository/Settings/Address Settings/button_Address'))
WebUI.waitForElementVisible(findTestObject('Object Repository/Settings/Address Settings/input_Reference Dashboard'), 0)
WebUI.setText(findTestObject('Object Repository/Settings/Address Settings/input_Reference Dashboard'),parsedJson['addressDest']['reference'])
WebUI.delay(3)
WebUI.check(findTestObject('Object Repository/Settings/Dashboard/first checkbox of the list'))
WebUI.waitForElementClickable(findTestObject('Object Repository/Settings/Dashboard/header/button_Edit'), 0)
WebUI.click(findTestObject('Object Repository/Settings/Dashboard/header/button_Edit'))
referenceDest = WebUI.getAttribute(findTestObject('Object Repository/Settings/Address Settings/input_Reference'), 'value')
companyDest =  WebUI.getAttribute(findTestObject('Object Repository/Settings/Address Settings/input_Company'), 'value')
addressDest =   WebUI.getAttribute(findTestObject('Object Repository/Settings/Address Settings/input_Address_street'), 'value')
cityDest =  WebUI.getAttribute(findTestObject('Object Repository/Settings/Address Settings/input_City'), 'value')
zipCodeDest =  WebUI.getAttribute(findTestObject('Object Repository/Settings/Address Settings/input_ZIP code'), 'value')
countryDest = WebUI.getAttribute(findTestObject('Object Repository/Settings/Address Settings/input_Country'), 'innerText')
WebUI.click(findTestObject('Object Repository/Settings/Modal/button_Cancel'))
//get service level from settings
WebUI.click(findTestObject('Object Repository/Home Page/Sidebar/button_Settings'))
WebUI.click(findTestObject('Object Repository/Settings/Breadcumbs/button_My company'))
WebUI.click(findTestObject('Object Repository/Settings/Service Level Settings/button_Services level'))
WebUI.waitForElementVisible(findTestObject('Object Repository/Settings/Service Level Settings/input_Reference'),0)
WebUI.setText(findTestObject('Object Repository/Settings/Service Level Settings/input_Reference'),parsedJson['serviceLevelReference'])
serviceLevel= WebUI.getText(findTestObject('Object Repository/Transport/List/second cell in a row'))

CustomKeywords.'modules.Pricing.accessToPricing'()
CustomKeywords.'modules.Pricing.accessToFirstTrDetails'()
//verify Owner of the request
WebUI.waitForElementVisible(findTestObject('Object Repository/Pricing Page/Form/input owner of the request'), 0)
value = WebUI.getAttribute(findTestObject('Object Repository/Pricing Page/Form/input owner of the request'),'innerText')
WebUI.verifyMatch(value, user, true, FailureHandling.CONTINUE_ON_FAILURE)
//verify type of flow
value = WebUI.getAttribute(findTestObject('Object Repository/Pricing Page/Form/input_Type_Of_Flow2'),'innerText')
WebUI.verifyMatch(value, typeOfFlowCode, true, FailureHandling.CONTINUE_ON_FAILURE)
//verify address origin
WebUI.waitForElementClickable(findTestObject('TMS Commons/Form/Edit Address Form/button_Edit_Address_From'), 0)
WebUI.enhancedClick(findTestObject('Object Repository/TMS Commons/Form/Edit Address Form/button_Edit_Address_From'))
reference = WebUI.getAttribute(findTestObject('Object Repository/TMS Commons/Form/Edit Address Form/input_Address_Reference'), 'value')
WebUI.verifyMatch(reference, parsedJson['addressOrigin'].get('reference'), true, FailureHandling.CONTINUE_ON_FAILURE)

company = WebUI.getAttribute(findTestObject('Object Repository/TMS Commons/Form/Edit Address Form/input_Company'), 'value')
WebUI.verifyMatch(company, parsedJson['addressOrigin'].get('company'), true, FailureHandling.CONTINUE_ON_FAILURE)

address = WebUI.getAttribute(findTestObject('Object Repository/TMS Commons/Form/Edit Address Form/input_Address'), 'value')
WebUI.verifyMatch(address, parsedJson['addressOrigin'].get('address').replace(",",""), true, FailureHandling.CONTINUE_ON_FAILURE)

city = WebUI.getAttribute(findTestObject('Object Repository/TMS Commons/Form/Edit Address Form/input_City'), 'value')
WebUI.verifyMatch(city.trim(), parsedJson['addressOrigin'].get('city'), true, FailureHandling.CONTINUE_ON_FAILURE)

zipCode = WebUI.getAttribute(findTestObject('Object Repository/TMS Commons/Form/Edit Address Form/input_Zip_code'), 'value')
WebUI.verifyMatch(zipCode, parsedJson['addressOrigin'].get('zipCode'), true, FailureHandling.CONTINUE_ON_FAILURE)

//verify address destination
WebUI.click(findTestObject('Object Repository/TMS Commons/Form/Edit Address Form/button_Close'))
WebUI.waitForElementClickable(findTestObject('Object Repository/TMS Commons/Form/Edit Address Form/button_Edit_Address_To'), 0)
WebUI.enhancedClick(findTestObject('Object Repository/TMS Commons/Form/Edit Address Form/button_Edit_Address_To'))
reference = WebUI.getAttribute(findTestObject('Object Repository/TMS Commons/Form/Edit Address Form/input_Address_Reference'), 'value')
WebUI.verifyMatch(reference, parsedJson['addressDest'].get('reference'), true, FailureHandling.CONTINUE_ON_FAILURE)

company = WebUI.getAttribute(findTestObject('Object Repository/TMS Commons/Form/Edit Address Form/input_Company'), 'value')
WebUI.verifyMatch(company, parsedJson['addressDest'].get('company'), true, FailureHandling.CONTINUE_ON_FAILURE)

address = WebUI.getAttribute(findTestObject('Object Repository/TMS Commons/Form/Edit Address Form/input_Address'), 'value')
WebUI.verifyMatch(address, parsedJson['addressDest'].get('address').replace(",",""), true, FailureHandling.CONTINUE_ON_FAILURE)

city = WebUI.getAttribute(findTestObject('Object Repository/TMS Commons/Form/Edit Address Form/input_City'), 'value')
WebUI.verifyMatch(city.trim(), parsedJson['addressDest'].get('city'), true, FailureHandling.CONTINUE_ON_FAILURE)

zipCode = WebUI.getAttribute(findTestObject('Object Repository/TMS Commons/Form/Edit Address Form/input_Zip_code'), 'value')
WebUI.verifyMatch(zipCode, parsedJson['addressDest'].get('zipCode'), true, FailureHandling.CONTINUE_ON_FAILURE)
WebUI.verifyMatch(reference, referenceDest, true, FailureHandling.CONTINUE_ON_FAILURE)

company = WebUI.getAttribute(findTestObject('Object Repository/TMS Commons/Form/Edit Address Form/input_Company'), 'value')
WebUI.verifyMatch(company, companyDest, true, FailureHandling.CONTINUE_ON_FAILURE)

address = WebUI.getAttribute(findTestObject('Object Repository/TMS Commons/Form/Edit Address Form/input_Address'), 'value')
WebUI.verifyMatch(address, addressDest, true, FailureHandling.CONTINUE_ON_FAILURE)

city = WebUI.getAttribute(findTestObject('Object Repository/TMS Commons/Form/Edit Address Form/input_City'), 'value')
WebUI.verifyMatch(city.trim(), cityDest, true, FailureHandling.CONTINUE_ON_FAILURE)

zipCode = WebUI.getAttribute(findTestObject('Object Repository/TMS Commons/Form/Edit Address Form/input_Zip_code'), 'value')
WebUI.verifyMatch(zipCode, zipCodeDest, true, FailureHandling.CONTINUE_ON_FAILURE)

country = WebUI.getAttribute(findTestObject('Object Repository/TMS Commons/Form/Edit Address Form/input_Country'), 'innerText')
WebUI.verifyMatch(country, countryDest, true, FailureHandling.CONTINUE_ON_FAILURE)


//get code Incoterm
value = WebUI.getAttribute(findTestObject('Object Repository/Pricing Page/Form/input_Incoterm2'), 'innerText')
WebUI.verifyMatch(value, parsedResponseJson['incotermCode'], true, FailureHandling.CONTINUE_ON_FAILURE)
println(value)

//get PSL Schema
value = WebUI.getAttribute(findTestObject('Object Repository/Pricing Page/Form/input_PSL_Shema2'), 'innerText')
WebUI.verifyMatch(value, parsedJson['pslSchemaCode'], true, FailureHandling.CONTINUE_ON_FAILURE)
println(value)

//get mode of transport
value = WebUI.getAttribute(findTestObject('Object Repository/Pricing Page/Form/button_Mode_Of_Transport'), 'innerText')
WebUI.verifyMatch(value.toUpperCase(), parsedJson['transportMethod'], true, FailureHandling.CONTINUE_ON_FAILURE)
println(value)

//verify eligible for consolidation
if (parsedJson['eligibleForConsolidation']) {
	WebUI.verifyElementChecked(findTestObject('Object Repository/Pricing Page/Form/radio_EligibleForConsolidation'), 10, FailureHandling.CONTINUE_ON_FAILURE)
} else {
	WebUI.verifyElementNotChecked(findTestObject('Object Repository/Pricing Page/Form/radio_EligibleForConsolidation', FailureHandling.CONTINUE_ON_FAILURE),
		10)
}

//get date of goods availability
value = WebUI.getAttribute(findTestObject('Object Repository/Pricing Page/Form/input_Date of goods availability'), 'value')
WebUI.verifyMatch(value, (parsedJson['dateOfGoodsAvailability']).substring(0, 10), true, FailureHandling.CONTINUE_ON_FAILURE)
println(value)


//verify customer reference
value = WebUI.getAttribute(findTestObject('Object Repository/Pricing Page/Form/input_Customer_Reference'), 'value')
WebUI.verifyMatch(value, parsedJson['customerReference'], true,FailureHandling.CONTINUE_ON_FAILURE)

//verify BC or DN number
value = WebUI.getAttribute(findTestObject('Object Repository/Pricing Page/Form/input_BC or DN number'), 'value')
WebUI.verifyMatch(value, parsedJson['bc_or_dn_transport_request'], true,FailureHandling.CONTINUE_ON_FAILURE)

//verify BC date creation
value = WebUI.getAttribute(findTestObject('Object Repository/Pricing Page/Form/input_BC date creation'), 'value')
WebUI.verifyMatch(value, parsedJson['bc_date_creation_transport_request'], true,FailureHandling.CONTINUE_ON_FAILURE)

//verify BC date validated
value = WebUI.getAttribute(findTestObject('Object Repository/Pricing Page/Form/input_BC date validated'), 'value')
WebUI.verifyMatch(value, parsedJson['bc_date_validated_transport_request'], true,FailureHandling.CONTINUE_ON_FAILURE)

//verify Source 
//verify Source
value = WebUI.getAttribute(findTestObject('Object Repository/Pricing Page/Form/input_Source'), 'value')
WebUI.verifyMatch(value, parsedJson['source_transport_request'], true,FailureHandling.CONTINUE_ON_FAILURE)

//verify Carrier Code
value = WebUI.getAttribute(findTestObject('Object Repository/Pricing Page/Form/input_Carrier Code'), 'value')
WebUI.verifyMatch(value, parsedJson['carrier_code_transport_request'], true,FailureHandling.CONTINUE_ON_FAILURE)

//verify Type of Shipment
value = WebUI.getAttribute(findTestObject('Object Repository/Pricing Page/Form/input_Type_Of_Shipment'), 'value')
WebUI.verifyMatch(value, parsedJson['type_of_shipment_transport_request'], true,FailureHandling.CONTINUE_ON_FAILURE)

//verify Code chargeur connu
value = WebUI.getAttribute(findTestObject('Object Repository/Pricing Page/Form/input_Code chargeur connu'), 'value')
WebUI.verifyMatch(value, parsedJson['code_chargeur_connu_transport_request'], true,FailureHandling.CONTINUE_ON_FAILURE)

//verify Repair invoice number
value = WebUI.getAttribute(findTestObject('Object Repository/Pricing Page/Form/input_Repair invoice number'), 'value')
WebUI.verifyMatch(value, parsedJson['repair_invoice_number_transport_request'], true,FailureHandling.CONTINUE_ON_FAILURE)

//verify File Timestamp
value = WebUI.getAttribute(findTestObject('Object Repository/Pricing Page/Form/input_File Timestamp'), 'value')
//timestamp =String.format("%.0f", parsedJson['file_timestamp_transport_request'])
WebUI.verifyMatch(value, String.format("%.0f", parsedJson['file_timestamp_transport_request']) , true,FailureHandling.CONTINUE_ON_FAILURE)

//verify Manhattan Shipment ID
value = WebUI.getAttribute(findTestObject('Object Repository/Pricing Page/Form/input_Manhattan Shipment ID'), 'value')
WebUI.verifyMatch(value, parsedJson['manhattan_shipment_id_transport_request'], true,FailureHandling.CONTINUE_ON_FAILURE)

//verify Transitflag
value = WebUI.getAttribute(findTestObject('Object Repository/Pricing Page/Form/input_Transitflag'), 'value')
WebUI.verifyMatch(value, parsedJson['transitflag_transport_request'], true,FailureHandling.CONTINUE_ON_FAILURE)

//verify TVA
value = WebUI.getAttribute(findTestObject('Object Repository/Pricing Page/Form/input_TVA'), 'value')
WebUI.verifyMatch(value, parsedJson['tva_transport_request'], true,FailureHandling.CONTINUE_ON_FAILURE)

//verify EORI
value = WebUI.getAttribute(findTestObject('Object Repository/Pricing Page/Form/input_EORI'), 'value')
WebUI.verifyMatch(value, parsedJson['eori_transport_request'], true,FailureHandling.CONTINUE_ON_FAILURE)

//verify Environment
value = WebUI.getAttribute(findTestObject('Object Repository/Pricing Page/Form/input_Environment'), 'value')
WebUI.verifyMatch(value, parsedJson['environment_transport_request'], true,FailureHandling.CONTINUE_ON_FAILURE)

//verify Message ID
value = WebUI.getAttribute(findTestObject('Object Repository/Pricing Page/Form/input_Message ID'), 'value')
WebUI.verifyMatch(value, parsedJson['message_id_transport_request'], true,FailureHandling.CONTINUE_ON_FAILURE)

//verify PDF Link
value = WebUI.getAttribute(findTestObject('Object Repository/Pricing Page/Form/input_PDF Link'), 'value')
WebUI.verifyMatch(value, parsedJson['pdf_link_transport_request'], true,FailureHandling.CONTINUE_ON_FAILURE)

//verify Cumulated invoice number
value = WebUI.getAttribute(findTestObject('Object Repository/Pricing Page/Form/input_Cumulated invoice number'), 'value')
WebUI.verifyMatch(value, parsedJson['cumulated_invoice_number_transport_request'], true,FailureHandling.CONTINUE_ON_FAILURE)

//verify Cumulated SRI number
value = WebUI.getAttribute(findTestObject('Object Repository/Pricing Page/Form/input_Cumulated SRI number'), 'value')
WebUI.verifyMatch(value, parsedJson['cumulated_sri_number_transport_request'], true,FailureHandling.CONTINUE_ON_FAILURE)

//verify TR Alerting (multi carrier / multi transport mode / multi incoterm)
value = WebUI.getAttribute(findTestObject('Object Repository/Pricing Page/Form/input_TR Alerting (multi carrier  multi transport mode  multi incoterm)'), 'value')
WebUI.verifyMatch(value, parsedJson['tr_alerting_multi_carrier_multi_1__transport_request'], true,FailureHandling.CONTINUE_ON_FAILURE)

//verify Incoterm ID
value = WebUI.getAttribute(findTestObject('Object Repository/Pricing Page/Form/input_Incoterm ID'), 'value')
WebUI.verifyMatch(value, parsedJson['incoterm_id_transport_request'], true,FailureHandling.CONTINUE_ON_FAILURE)

//verify Incoterm Location
value = WebUI.getAttribute(findTestObject('Object Repository/Pricing Page/Form/input_Incoterm Location'), 'value')
WebUI.verifyMatch(value, parsedJson['incoterm_location_transport_request'], true,FailureHandling.CONTINUE_ON_FAILURE)

//verify Final Ship to Code
value = WebUI.getAttribute(findTestObject('Object Repository/Pricing Page/Form/select_Ship to code'), 'value')
//WebUI.verifyMatch(value, parsedJson['parcel_final_shipto_code_packaging'], true,FailureHandling.CONTINUE_ON_FAILURE)


//verify Total Palette number

//verify Final destination country
value = WebUI.getAttribute(findTestObject('Object Repository/Pricing Page/Form/select_Final destination country'), 'value')
WebUI.verifyMatch(value, parsedJson['destination_country_transport_request'], true,FailureHandling.CONTINUE_ON_FAILURE)

//verify Serial Number Research
value = WebUI.getAttribute(findTestObject('Object Repository/Pricing Page/Form/input_Serial Number Research'), 'value')
WebUI.verifyMatch(value, parsedJson['serial_number_research_transport_request'], true,FailureHandling.CONTINUE_ON_FAILURE)

//verify Service level
value = WebUI.getAttribute(findTestObject('Object Repository/Pricing Page/Form/select_Service_Level'), 'innerText')
WebUI.verifyMatch(value, serviceLevel, true,FailureHandling.CONTINUE_ON_FAILURE)

//verify Invoice currency
value = WebUI.getAttribute(findTestObject('Object Repository/Pricing Page/Form/select_Invoice_Currency'), 'value')
WebUI.verifyMatch(value, parsedJson['currencyInvoiceCode'], true,FailureHandling.CONTINUE_ON_FAILURE)

//verify Bill To Code
value = WebUI.getAttribute(findTestObject('Object Repository/Pricing Page/Form/input_Bill To Code'), 'value')
WebUI.verifyMatch(value, parsedJson['bill_to_code_transport_request'], true,FailureHandling.CONTINUE_ON_FAILURE)

//verify Bill To Company Code
value = WebUI.getAttribute(findTestObject('Object Repository/Pricing Page/Form/input_Bill To Company Code'), 'value')
WebUI.verifyMatch(value, parsedJson['bill_to_company_code_transport_request'], true,FailureHandling.CONTINUE_ON_FAILURE)

//verify Bill To name
value = WebUI.getAttribute(findTestObject('Object Repository/Pricing Page/Form/input_Bill To name'), 'value')
WebUI.verifyMatch(value, parsedJson['bill_to_name_transport_request'], true,FailureHandling.CONTINUE_ON_FAILURE)

//verify Bill To address 1
value = WebUI.getAttribute(findTestObject('Object Repository/Pricing Page/Form/input_Bill To address 1'), 'value')
WebUI.verifyMatch(value, parsedJson['bill_to_adress_1_transport_request'], true,FailureHandling.CONTINUE_ON_FAILURE)

//verify Bill To address 2
value = WebUI.getAttribute(findTestObject('Object Repository/Pricing Page/Form/input_Bill To address 2'), 'value')
WebUI.verifyMatch(value, parsedJson['bill_to_address_2_transport_request'], true,FailureHandling.CONTINUE_ON_FAILURE)

//verify Bill To address 3
value = WebUI.getAttribute(findTestObject('Object Repository/Pricing Page/Form/input_Bill To address 3'), 'value')
WebUI.verifyMatch(value, parsedJson['bill_to_address_3_transport_request'], true,FailureHandling.CONTINUE_ON_FAILURE)

//verify Bill To address 4
value = WebUI.getAttribute(findTestObject('Object Repository/Pricing Page/Form/input_Bill To address 4'), 'value')
WebUI.verifyMatch(value, parsedJson['bill_to_address_4_transport_request'], true,FailureHandling.CONTINUE_ON_FAILURE)

//verify Bill To Zip Code
value = WebUI.getAttribute(findTestObject('Object Repository/Pricing Page/Form/input_Bill To Zip Code'), 'value')
WebUI.verifyMatch(value, parsedJson['bill_to_zip_code_transport_request'], true,FailureHandling.CONTINUE_ON_FAILURE)

//verify Bill To City
value = WebUI.getAttribute(findTestObject('Object Repository/Pricing Page/Form/input_Bill To City'), 'value')
WebUI.verifyMatch(value, parsedJson['bill_to_city_transport_request'], true,FailureHandling.CONTINUE_ON_FAILURE)

//verify Bill To Post Code
value = WebUI.getAttribute(findTestObject('Object Repository/Pricing Page/Form/input_Bill To Post Code'), 'value')
WebUI.verifyMatch(value, parsedJson['bill_to_post_code_transport_request'], true,FailureHandling.CONTINUE_ON_FAILURE)

//verify Bill To District
value = WebUI.getAttribute(findTestObject('Object Repository/Pricing Page/Form/input_Bill To District'), 'value')
WebUI.verifyMatch(value, parsedJson['bill_to_district_transport_request'], true,FailureHandling.CONTINUE_ON_FAILURE)

//verify Bill To Admin Sub
value = WebUI.getAttribute(findTestObject('Object Repository/Pricing Page/Form/input_Bill To Admin Sub'), 'value')
WebUI.verifyMatch(value, parsedJson['bill_to_admin_sub_transport_request'], true,FailureHandling.CONTINUE_ON_FAILURE)

//verify Bill To Country
value = WebUI.getAttribute(findTestObject('Object Repository/Pricing Page/Form/input_Bill To Country'), 'value')
WebUI.verifyMatch(value, parsedJson['bill_to_iso2_country_code_transport_request'], true,FailureHandling.CONTINUE_ON_FAILURE)

//verify Carrier Name
value = WebUI.getAttribute(findTestObject('Object Repository/Pricing Page/Form/input_Carrier Name'), 'value')
WebUI.verifyMatch(value, parsedJson['carrier_name_transport_request'], true,FailureHandling.CONTINUE_ON_FAILURE)

//verify Carrier Address 1
value = WebUI.getAttribute(findTestObject('Object Repository/Pricing Page/Form/input_Carrier Address 1'), 'value')
WebUI.verifyMatch(value, parsedJson['carrier_address_1_transport_request'], true,FailureHandling.CONTINUE_ON_FAILURE)

//verify Carrier Address 2
value = WebUI.getAttribute(findTestObject('Object Repository/Pricing Page/Form/input_Carrier Address 2'), 'value')
WebUI.verifyMatch(value, parsedJson['carrier_address_2_transport_request'], true,FailureHandling.CONTINUE_ON_FAILURE)

//verify Carrier Address 3
value = WebUI.getAttribute(findTestObject('Object Repository/Pricing Page/Form/input_Carrier Address 3'), 'value')
WebUI.verifyMatch(value, parsedJson['carrier_address_3_transport_request'], true,FailureHandling.CONTINUE_ON_FAILURE)

//verify Carrier Address 4
value = WebUI.getAttribute(findTestObject('Object Repository/Pricing Page/Form/input_Carrier Address 4'), 'value')
WebUI.verifyMatch(value, parsedJson['carrier_address_4_transport_request'], true,FailureHandling.CONTINUE_ON_FAILURE)

//verify Carrier Zip Code
value = WebUI.getAttribute(findTestObject('Object Repository/Pricing Page/Form/input_Carrier Zip Code'), 'value')
WebUI.verifyMatch(value, parsedJson['carier_zip_code_transport_request'], true,FailureHandling.CONTINUE_ON_FAILURE)

//verify Carrier City
value = WebUI.getAttribute(findTestObject('Object Repository/Pricing Page/Form/input_Carrier City'), 'value')
WebUI.verifyMatch(value, parsedJson['carrier_city_transport_request'], true,FailureHandling.CONTINUE_ON_FAILURE)

//verify Carrier Post Code
value = WebUI.getAttribute(findTestObject('Object Repository/Pricing Page/Form/input_Carrier Post Code'), 'value')
WebUI.verifyMatch(value, parsedJson['carrier_post_code_transport_request'], true,FailureHandling.CONTINUE_ON_FAILURE)

//verify Carrier District
value = WebUI.getAttribute(findTestObject('Object Repository/Pricing Page/Form/input_Carrier District'), 'value')
WebUI.verifyMatch(value, parsedJson['carrier_district_transport_request'], true,FailureHandling.CONTINUE_ON_FAILURE)

//verify Carrier AdminSub
value = WebUI.getAttribute(findTestObject('Object Repository/Pricing Page/Form/input_Carrier AdminSub'), 'value')
WebUI.verifyMatch(value, parsedJson['carrier_adminsub_transport_request'], true,FailureHandling.CONTINUE_ON_FAILURE)

//verify Carrier Country
value = WebUI.getAttribute(findTestObject('Object Repository/Pricing Page/Form/input_Carrier Country'), 'value')
WebUI.verifyMatch(value, parsedJson['carrier_iso2_country_code_transport_request'], true,FailureHandling.CONTINUE_ON_FAILURE)

//verify Exportateur Code
value = WebUI.getAttribute(findTestObject('Object Repository/Pricing Page/Form/input_Exportateur Code'), 'value')
WebUI.verifyMatch(value, parsedJson['exportateur_information_exportateur_code_transport_request'], true,FailureHandling.CONTINUE_ON_FAILURE)

//verify Exportateur name
value = WebUI.getAttribute(findTestObject('Object Repository/Pricing Page/Form/input_Exportateur name'), 'value')
WebUI.verifyMatch(value, parsedJson['exportateur_name_transport_request'], true,FailureHandling.CONTINUE_ON_FAILURE)

//verify Exportateur Address 1
value = WebUI.getAttribute(findTestObject('Object Repository/Pricing Page/Form/input_Exportateur Address 1'), 'value')
WebUI.verifyMatch(value, parsedJson['exportateur_address_1_transport_request'], true,FailureHandling.CONTINUE_ON_FAILURE)

//verify Exportateur Address 2
value = WebUI.getAttribute(findTestObject('Object Repository/Pricing Page/Form/input_Exportateur Address 2'), 'value')
WebUI.verifyMatch(value, parsedJson['exportateur_address_2_transport_request'], true,FailureHandling.CONTINUE_ON_FAILURE)

//verify Exportateur Address 3
value = WebUI.getAttribute(findTestObject('Object Repository/Pricing Page/Form/input_Exportateur Address 3'), 'value')
WebUI.verifyMatch(value, parsedJson['exportateur_address_3_transport_request'], true,FailureHandling.CONTINUE_ON_FAILURE)

//verify Exportateur Address 4
value = WebUI.getAttribute(findTestObject('Object Repository/Pricing Page/Form/input_Exportateur Address 4'), 'value')
WebUI.verifyMatch(value, parsedJson['exportateur_address_4_transport_request'], true,FailureHandling.CONTINUE_ON_FAILURE)

//verify Exportateur Zip Code
value = WebUI.getAttribute(findTestObject('Object Repository/Pricing Page/Form/input_Exportateur Zip Code'), 'value')
WebUI.verifyMatch(value, parsedJson['exportateur_zip_code_transport_request'], true,FailureHandling.CONTINUE_ON_FAILURE)

//verify Exportateur City
value = WebUI.getAttribute(findTestObject('Object Repository/Pricing Page/Form/input_Exportateur City'), 'value')
WebUI.verifyMatch(value, parsedJson['exportateur_city_transport_request'], true,FailureHandling.CONTINUE_ON_FAILURE)

//verify Exportateur Post Code
value = WebUI.getAttribute(findTestObject('Object Repository/Pricing Page/Form/input_Exportateur Post Code'), 'value')
WebUI.verifyMatch(value, parsedJson['exportateur_post_code_transport_request'], true,FailureHandling.CONTINUE_ON_FAILURE)

//verify Exportateur District
value = WebUI.getAttribute(findTestObject('Object Repository/Pricing Page/Form/input_Exportateur District'), 'value')
WebUI.verifyMatch(value, parsedJson['exportateur_district_transport_request'], true,FailureHandling.CONTINUE_ON_FAILURE)

//verify Exportateur AdminSub
value = WebUI.getAttribute(findTestObject('Object Repository/Pricing Page/Form/input_Exportateur AdminSub'), 'value')
WebUI.verifyMatch(value, parsedJson['exportateur_adminsub_transport_request'], true,FailureHandling.CONTINUE_ON_FAILURE)

//verify Exportateur Country
value = WebUI.getAttribute(findTestObject('Object Repository/Pricing Page/Form/input_Exportateur Country'), 'value')
WebUI.verifyMatch(value, parsedJson['exportateur_iso2_country_code_transport_request'], true,FailureHandling.CONTINUE_ON_FAILURE)

//verify Package and articles
WebDriver driver = DriverFactory.getWebDriver()
 List<WebElement> myElements = driver.findElements(By.xpath('(//div[@class="ag-cell ag-cell-not-inline-editing ag-cell-auto-height ag-cell-range-left"]//div[@class="ag-selection-checkbox"])'))
int size = myElements.size()
int articlesSize= (int)(myElements.size())/2
articlesSize--
println(articlesSize)
 for(WebElement e : myElements) {
	 e.click();
	//WebUI.waitForElementVisible(findTestObject('Object Repository/Test Unit/button Edit Articles'),0 ,FailureHandling.CONTINUE_ON_FAILURE)
	 if(WebUI.verifyElementVisible(findTestObject('Object Repository/Test Unit/button Edit Articles'), FailureHandling.OPTIONAL )) {
		 WebUI.click(findTestObject('Object Repository/Test Unit/button Edit Articles'))
		 if(WebUI.verifyElementVisible(findTestObject('Object Repository/Pricing Page/Form/Packaging Form/label_Edit the packaging') ,FailureHandling.OPTIONAL))
		 {
		 size-=3
		 //verify Package Reference
		 WebUI.waitForElementVisible(findTestObject('Object Repository/Pricing Page/Form/Packaging Form/input_Package Reference'),0)
		 value = WebUI.getAttribute( findTestObject('Object Repository/Pricing Page/Form/Packaging Form/input_Package Reference'), 'value')
		 WebUI.verifyMatch(value, parsedJson['packages']['packageReference'][size], true, FailureHandling.CONTINUE_ON_FAILURE)
		 //verify Category
		 value = WebUI.getAttribute( findTestObject('Object Repository/Pricing Page/Form/Packaging Form/select_Package Category'), 'value')
		 WebUI.verifyMatch(value, parsedJson['packages']['packageCategory'][size], true, FailureHandling.CONTINUE_ON_FAILURE)
		 //verify Unitary Quantity
		 value = WebUI.getAttribute( findTestObject('Object Repository/Pricing Page/Form/Packaging Form/input_Unitary Quantity'), 'value')
		 WebUI.verifyMatch(value, (String)parsedJson['packages']['unitaryQuantity'][size], true, FailureHandling.CONTINUE_ON_FAILURE)
		 //verify Total Quantity
		 value = WebUI.getAttribute(findTestObject('Object Repository/Pricing Page/Form/Packaging Form/input_Total Quantity'), 'value')
		 WebUI.verifyMatch(value, (String)parsedJson['packages']['totalQuantity'][size], true, FailureHandling.CONTINUE_ON_FAILURE)
		 //verify Height
		 value = WebUI.getAttribute(findTestObject('Object Repository/Pricing Page/Form/Packaging Form/input_Height'), 'value')
		 WebUI.verifyMatch(value, String.format("%.0f",Double.parseDouble(parsedJson['packages']['height'][size])), true, FailureHandling.CONTINUE_ON_FAILURE)
		 //verify Width
		 value = WebUI.getAttribute(findTestObject('Object Repository/Pricing Page/Form/Packaging Form/input_Width'), 'value')
		 WebUI.verifyMatch(value, String.format("%.0f",Double.parseDouble(parsedJson['packages']['width'][size])), true, FailureHandling.CONTINUE_ON_FAILURE)
		 //verify Length
		 value = WebUI.getAttribute(findTestObject('Object Repository/Pricing Page/Form/Packaging Form/input_Length'), 'value')
		 WebUI.verifyMatch(value, String.format("%.0f",Double.parseDouble(parsedJson['packages']['length'][size])), true, FailureHandling.CONTINUE_ON_FAILURE)
		 //verify Volume
		 value = WebUI.getAttribute( findTestObject('Object Repository/Pricing Page/Form/Packaging Form/input_Volume'), 'value')
		 WebUI.verifyMatch(value, parsedJson['packages']['volume'][size], true, FailureHandling.CONTINUE_ON_FAILURE)
		 //verify Total volume
		 value = WebUI.getAttribute(findTestObject('Object Repository/Pricing Page/Form/Packaging Form/input_Total Volume'), 'value')
		 WebUI.verifyMatch(value, parsedJson['packages']['totalVolume'][size], true, FailureHandling.CONTINUE_ON_FAILURE)
		 //verify Net weight
		 value = WebUI.getAttribute(findTestObject('Object Repository/Pricing Page/Form/Packaging Form/input_Net weight'), 'value')
		 WebUI.verifyMatch(value, parsedJson['packages']['unitaryNetWeight'][size], true, FailureHandling.CONTINUE_ON_FAILURE)
		 //verify Total net weight
		 value = WebUI.getAttribute(findTestObject('Object Repository/Pricing Page/Form/Packaging Form/input_Total net weight'), 'value')
		 WebUI.verifyMatch(value, parsedJson['packages']['totalNetWeight'][size], true, FailureHandling.CONTINUE_ON_FAILURE)
		 //verify Gross weight
		 value = WebUI.getAttribute(findTestObject('Object Repository/Pricing Page/Form/Packaging Form/input_Gross weight'), 'value')
		 WebUI.verifyMatch(value, parsedJson['packages']['unitaryGrossWeight'][size], true, FailureHandling.CONTINUE_ON_FAILURE)
		 //verify Total Gross weight
		 value = WebUI.getAttribute(findTestObject('Object Repository/Pricing Page/Form/Packaging Form/input_Total Gross weight'), 'value')
		 WebUI.verifyMatch(value, parsedJson['packages']['totalGrossWeight'][size], true, FailureHandling.CONTINUE_ON_FAILURE)
		 //verify Package Type
		 //verify Unit Type
		 //verify Homogeneous
		 if(parsedJson['packages']['homogeneous'][size])
		 {
		 WebUI.verifyElementChecked( findTestObject('Object Repository/Pricing Page/Form/Packaging Form/radio_Homogeneous No'), 30)
		 }
		 else {
		 WebUI.verifyElementChecked( findTestObject('Object Repository/Pricing Page/Form/Packaging Form/radio_Homogeneous Yes'), 30)
		 }
		 //verify Parcel ID
		 value = WebUI.getAttribute(findTestObject('Object Repository/Pricing Page/Form/Packaging Form/input_Parcel ID'), 'value')
		 WebUI.verifyMatch(value, parsedJson['packages']['parcel_id_packaging'][size], true, FailureHandling.CONTINUE_ON_FAILURE)
		 //verify SSCC Parcel ID
		 value = WebUI.getAttribute(findTestObject('Object Repository/Pricing Page/Form/Packaging Form/input_SSCC Parcel ID'), 'value')
		 WebUI.verifyMatch(value, parsedJson['packages']['sscc_parcel_id_packaging'][size], true, FailureHandling.CONTINUE_ON_FAILURE)
		 //verify BC or DN number
		 value = WebUI.getAttribute(findTestObject('Object Repository/Pricing Page/Form/Packaging Form/input_BC or DN number'), 'value')
		 WebUI.verifyMatch(value, parsedJson['packages']['bc_or_dn_number_packaging'][size], true, FailureHandling.CONTINUE_ON_FAILURE)
		 //verify Delivery Note
		 value = WebUI.getAttribute(findTestObject('Object Repository/Pricing Page/Form/Packaging Form/input_Delivery Note'), 'value')
		 WebUI.verifyMatch(value, parsedJson['packages']['delivery_note_packaging'][size], true, FailureHandling.CONTINUE_ON_FAILURE)
		 //verify Parcelname
		 value = WebUI.getAttribute(findTestObject('Object Repository/Pricing Page/Form/Packaging Form/input_Parcelname'), 'value')
		 WebUI.verifyMatch(value, parsedJson['packages']['parcelname_packaging'][size], true, FailureHandling.CONTINUE_ON_FAILURE)
		 //verify Invoice number
		 value = WebUI.getAttribute(findTestObject('Object Repository/Pricing Page/Form/Packaging Form/input_Invoice number'), 'value')
		 WebUI.verifyMatch(value, parsedJson['packages']['invoice_number_packaging'][size], true, FailureHandling.CONTINUE_ON_FAILURE)
		 //verify Document type code
		 value = WebUI.getAttribute( findTestObject('Object Repository/Pricing Page/Form/Packaging Form/input_Document type code'), 'value')
		 WebUI.verifyMatch(value, parsedJson['packages']['document_type_code_packaging'][size], true, FailureHandling.CONTINUE_ON_FAILURE)
		 //verify Document Type Description
		 value = WebUI.getAttribute(findTestObject('Object Repository/Pricing Page/Form/Packaging Form/input_Document Type Description'), 'value')
		 WebUI.verifyMatch(value, parsedJson['packages']['document_type_description_packaging'][size], true, FailureHandling.CONTINUE_ON_FAILURE)
		 //verify Document Label
		 value = WebUI.getAttribute(findTestObject('Object Repository/Pricing Page/Form/Packaging Form/input_Document Label'), 'value')
		 WebUI.verifyMatch(value, parsedJson['packages']['document_label_packaging'][size], true, FailureHandling.CONTINUE_ON_FAILURE)
		 //verify Invoice date
		 //value = WebUI.getAttribute(findTestObject('Object Repository/Pricing Page/Form/Packaging Form/input_Invoice date'), 'value')
		 //WebUI.verifyMatch(value, parsedJson['packages']['invoice_date_packaging'][size], true, FailureHandling.CONTINUE_ON_FAILURE)
		 //verify SRI number
		 value = WebUI.getAttribute( findTestObject('Object Repository/Pricing Page/Form/Packaging Form/input_SRI number'), 'value')
		 WebUI.verifyMatch(value, (String)parsedJson['packages']['sri_number_packaging'][size], true, FailureHandling.CONTINUE_ON_FAILURE)
		 //verify SRI Date
		 //value = WebUI.getAttribute(findTestObject('Object Repository/Pricing Page/Form/Packaging Form/input_SRI Date'), 'value')
		 //WebUI.verifyMatch(value, parsedJson['packages']['sri_date_packaging'][size], true, FailureHandling.CONTINUE_ON_FAILURE)
		 //verify Parcel Final ShipTo Code
		 //verify Parcel Final Ship To Company Code
		 //verify Parcel Final ShipTo Name
		 //verify Parcel Final ShipTo Address1
		 //verify Parcel Final ShipTo Address 2
		 //verify Parcel Final ShipTo Address 3
		 //verify Parcel Final ShipTo Address 4
		 //verify Parcel Final ShipTo Zip Code
		 //verify Parcel Final ShipTo City
		 //verify Parcel Final ShipTo Post Code
		 //verify Parcel Final ShipTo District
		 //verify Parcel Final ShipTo AdminSub
		 //verify Parcel Final ShipTo ISO2 Country Code
		 //verify Parcel Sold To Code
		 value = WebUI.getAttribute( findTestObject('Object Repository/Pricing Page/Form/Packaging Form/input_Parcel Sold To Code'), 'value')
		 WebUI.verifyMatch(value, parsedJson['packages']['parcel_sold_to_code_packaging'][size], true, FailureHandling.CONTINUE_ON_FAILURE)
		 //verify Parcel Sold To Company Code
		 value = WebUI.getAttribute( findTestObject('Object Repository/Pricing Page/Form/Packaging Form/input_Parcel Sold To Company Code'), 'value')
		 WebUI.verifyMatch(value, parsedJson['packages']['parcel_sold_to_company_code_packaging'][size], true, FailureHandling.CONTINUE_ON_FAILURE)
		 //verify Parcel Sold To Adress 1
		 value = WebUI.getAttribute( findTestObject('Object Repository/Pricing Page/Form/Packaging Form/input_Parcel Sold To Adress 1'), 'value')
		 WebUI.verifyMatch(value, parsedJson['packages']['parcel_sold_to_adress_1_packaging'][size], true, FailureHandling.CONTINUE_ON_FAILURE)
		 //verify Parcel Sold To Adress 2
		 value = WebUI.getAttribute( findTestObject('Object Repository/Pricing Page/Form/Packaging Form/input_Parcel Sold To Adress 2'), 'value')
		 WebUI.verifyMatch(value, parsedJson['packages']['parcel_sold_to_adress_2_packaging'][size], true, FailureHandling.CONTINUE_ON_FAILURE)
		 //verify Parcel Sold To Adress 3
		 //verify Parcel Sold To Adress 4
		 //verify Parcel Sold To Zip Code
		 value = WebUI.getAttribute( findTestObject('Object Repository/Pricing Page/Form/Packaging Form/input_Parcel Sold To Zip Code'), 'value')
		 WebUI.verifyMatch(value, parsedJson['packages']['parcel_sold_to_zip_code_packaging'][size], true, FailureHandling.CONTINUE_ON_FAILURE)
		 //verify Parcel Sold To City
		 value = WebUI.getAttribute( findTestObject('Object Repository/Pricing Page/Form/Packaging Form/input_Parcel Sold To City'), 'value')
		 WebUI.verifyMatch(value, parsedJson['packages']['parcel_sold_to_city_packaging'][size], true, FailureHandling.CONTINUE_ON_FAILURE)
		 //verify Parcel Sold To Post Code
		 value = WebUI.getAttribute( findTestObject('Object Repository/Pricing Page/Form/Packaging Form/input_Parcel Sold To Post Code'), 'value')
		 WebUI.verifyMatch(value, parsedJson['packages']['parcel_sold_to_post_code_packaging'][size], true, FailureHandling.CONTINUE_ON_FAILURE)
		 //verify Parcel Sold To District
		 //verify Parcel Sold To Admin Sub
		 //verify Parcel Sold To Country
		 value = WebUI.getAttribute(  findTestObject('Object Repository/Pricing Page/Form/Packaging Form/input_Parcel Sold To Country'), 'value')
		 WebUI.verifyMatch(value, parsedJson['packages']['parcel_sold_to_country_packaging'][size], true, FailureHandling.CONTINUE_ON_FAILURE)
		 //verify Parcel Sold To Name
		 value = WebUI.getAttribute( findTestObject('Object Repository/Pricing Page/Form/Packaging Form/input_Parcel Sold To Name'), 'value')
		 WebUI.verifyMatch(value, parsedJson['packages']['parcel_sold_to_name_packaging'][size], true, FailureHandling.CONTINUE_ON_FAILURE)
		 //verify Parcel Bill To Code
		 //verify Invoice Total Net Amount HT
		 value = WebUI.getAttribute( findTestObject('Object Repository/Pricing Page/Form/Packaging Form/input_Invoice Total Net Amount HT'), 'value')
		 WebUI.verifyMatch(value, String.format("%.0f",Double.parseDouble(parsedJson['packages']['parcel_total_net_amount_ht_packaging'][size])), true, FailureHandling.CONTINUE_ON_FAILURE)
		 //verify Invoice Total Gross Amount TTC
		 value = WebUI.getAttribute( findTestObject('Object Repository/Pricing Page/Form/Packaging Form/input_Invoice Total Gross Amount TTC'), 'value')
		 WebUI.verifyMatch(value, String.format("%.0f",parsedJson['packages']['parcel_total_gross_amount_ttc_packaging'][size]), true, FailureHandling.CONTINUE_ON_FAILURE)
		 //verify Invoice VAT Ship From
		 //verify Invoice VAT Bill To
		 //veirfy Invoice Total Number of Parcel
		 value = WebUI.getAttribute(findTestObject('Object Repository/Pricing Page/Form/Packaging Form/input_Invoice Total Number of Parcel'), 'value')
		 WebUI.verifyMatch(value, (String)parsedJson['packages']['invoice_total_number_of_parcel_packaging'][size], true, FailureHandling.CONTINUE_ON_FAILURE)
		 //verifyInvoice Total Gross Weight KG
		 value = WebUI.getAttribute(findTestObject('Object Repository/Pricing Page/Form/Packaging Form/input_Invoice Total Gross Weight KG'), 'value')
		 WebUI.verifyMatch(value, parsedJson['packages']['invoice_total_gross_weight_kg_packaging'][size], true, FailureHandling.CONTINUE_ON_FAILURE)
		 //verify Invoice Total Net Weight KG
		 value = WebUI.getAttribute(findTestObject('Object Repository/Pricing Page/Form/Packaging Form/input_Invoice Total Net Weight KG'), 'value')
		 WebUI.verifyMatch(value, (String)parsedJson['packages']['invoice_total_net_weight_kg_packaging'][size], true, FailureHandling.CONTINUE_ON_FAILURE)
		 //verify Invoice comment
		 //verify Invoice Total Quantity of Item
		 value = WebUI.getAttribute( findTestObject('Object Repository/Pricing Page/Form/Packaging Form/input_Invoice Total Quantity of Item'), 'value')
		 WebUI.verifyMatch(value, String.format("%.0f",parsedJson['packages']['invoice_total_quantity_of_item_packaging'][size]), true, FailureHandling.CONTINUE_ON_FAILURE)
		 //verify Parcel Total Amount
		 value = WebUI.getAttribute( findTestObject('Object Repository/Pricing Page/Form/Packaging Form/input_Parcel Total Amount'), 'value')
		 WebUI.verifyMatch(value, String.format("%.0f",Double.parseDouble(parsedJson['packages']['parcel_total_amount_packaging'][size])), true, FailureHandling.CONTINUE_ON_FAILURE)
		 //verify Quantity of item
		 value = WebUI.getAttribute(findTestObject('Object Repository/Pricing Page/Form/Packaging Form/input_Quantity of item'), 'value')
		 WebUI.verifyMatch(value, parsedJson['packages']['quantity_of_item_packaging'][size], true, FailureHandling.CONTINUE_ON_FAILURE)
		 //verify Parcel Dimension Unit
		 //verify Col/Hous
		 value = WebUI.getAttribute(findTestObject('Object Repository/Pricing Page/Form/Packaging Form/input_ColHous'), 'value')
		 WebUI.verifyMatch(value, parsedJson['packages']['col_hous_packaging'][size], true, FailureHandling.CONTINUE_ON_FAILURE)
		 //verify Stock déporté

		 
		 }
		 if(WebUI.verifyElementVisible(findTestObject('Object Repository/Pricing Page/Form/Article Form/label_Edit article'),FailureHandling.OPTIONAL))
		 {
		 size++
		 //verify Package Reference
		 WebUI.waitForElementVisible(findTestObject('Object Repository/Pricing Page/Form/Article Form/input_Reference'),0)
		 value = WebUI.getAttribute( findTestObject('Object Repository/Pricing Page/Form/Article Form/input_Reference'), 'value')
		 WebUI.verifyMatch(value, parsedJson['packages']['packageReference'][size], true, FailureHandling.CONTINUE_ON_FAILURE)
		 //verify Quantity
		 value = WebUI.getAttribute( findTestObject('Object Repository/Pricing Page/Form/Article Form/input_Quantity'), 'value')
		 WebUI.verifyMatch(value, String.format("%.0f",Double.parseDouble(parsedJson['packages']['unit'].getAt('quantity')[articlesSize])), true, FailureHandling.CONTINUE_ON_FAILURE)
		 //verify Net weight (Kg)
		 //verify Total net weight (Kg)
		 //verify Serial Number
		 //verify Itemdescription
		 value = WebUI.getAttribute(findTestObject('Object Repository/Pricing Page/Form/Article Form/input_Itemdescription'), 'value')
		 WebUI.verifyMatch(value, parsedJson['packages']['unit'].getAt('itemdescription_transport_request')[articlesSize], true, FailureHandling.CONTINUE_ON_FAILURE)
		 //verify Shipping status
		 //verify Item Net Weight
		 value = WebUI.getAttribute( findTestObject('Object Repository/Pricing Page/Form/Article Form/input_Item Net Weight'), 'value')
		 WebUI.verifyMatch(value, parsedJson['packages']['unit'].getAt('item_net_weight_unit')[articlesSize], true, FailureHandling.CONTINUE_ON_FAILURE)
		 //verify Unit weight
		 
		 
		 /*value = WebUI.getAttribute(findTestObject('Object Repository/Pricing Page/Form/Article Form/input_Unit weight'), 'value')
		 WebUI.verifyMatch(value, String.format("%.0f",Double.parseDouble( parsedJson['packages']['unit'].getAt('unitWeight')[articlesSize])), true, FailureHandling.CONTINUE_ON_FAILURE)*/
		 //verify Item Packing Slip
		 value = WebUI.getAttribute( findTestObject('Object Repository/Pricing Page/Form/Article Form/input_Item Packing Slip'), 'value')
		 WebUI.verifyMatch(value, parsedJson['packages']['unit'].getAt('item_packing_slip_unit')[articlesSize], true, FailureHandling.CONTINUE_ON_FAILURE)
		 //verify Unit Type
		 //verify Item Customs Value EUR
		 //verify  Item line Invoice comment
		 //verify Item Delivery Note
		 value = WebUI.getAttribute(findTestObject('Object Repository/Pricing Page/Form/Article Form/input_Item Delivery Note'), 'value')
		 WebUI.verifyMatch(value, parsedJson['packages']['unit'].getAt('item_delivery_note_unit')[articlesSize], true, FailureHandling.CONTINUE_ON_FAILURE)
		 //verify Item Claim Nbr
		 //verify Item Code
		 value = WebUI.getAttribute(findTestObject('Object Repository/Pricing Page/Form/Article Form/input_Item Code'), 'value')
		 WebUI.verifyMatch(value, parsedJson['packages']['unit'].getAt('item_code_unit')[articlesSize], true, FailureHandling.CONTINUE_ON_FAILURE)
		 //verify Item Network
		 value = WebUI.getAttribute(findTestObject('Object Repository/Pricing Page/Form/Article Form/input_Item Network'), 'value')
		 WebUI.verifyMatch(value, parsedJson['packages']['unit'].getAt('item_network_unit')[articlesSize], true, FailureHandling.CONTINUE_ON_FAILURE)
		 //verify Item Barcode
		 value = WebUI.getAttribute(findTestObject('Object Repository/Pricing Page/Form/Article Form/input_Item Barcode'), 'value')
		 WebUI.verifyMatch(value, parsedJson['packages']['unit'].getAt('item_barcode_unit')[articlesSize], true, FailureHandling.CONTINUE_ON_FAILURE)
		 //verify Item Season
		 value = WebUI.getAttribute(findTestObject('Object Repository/Pricing Page/Form/Article Form/input_Item Season'), 'value')
		 WebUI.verifyMatch(value, parsedJson['packages']['unit'].getAt('item_season_unit')[articlesSize], true, FailureHandling.CONTINUE_ON_FAILURE)
		 //verify Item Qty/Size
		 value = WebUI.getAttribute(findTestObject('Object Repository/Pricing Page/Form/Article Form/input_Item QtySize'), 'value')
		 WebUI.verifyMatch(value, parsedJson['packages']['unit'].getAt('item_qty_size_unit')[articlesSize], true, FailureHandling.CONTINUE_ON_FAILURE)
		 //verify Item Special Finish Code
		 value = WebUI.getAttribute(findTestObject('Object Repository/Pricing Page/Form/Article Form/input_Item Special Finish Code'), 'value')
		 if(parsedJson['packages']['unit'].getAt('item_special_finish_code_unit')[articlesSize]==null){
		   WebUI.verifyMatch(value, '', true, FailureHandling.CONTINUE_ON_FAILURE)
		 }
		 else{
		   WebUI.verifyMatch(value, parsedJson['packages']['unit'].getAt('item_special_finish_code_unit')[articlesSize], true, FailureHandling.CONTINUE_ON_FAILURE)
		 }
		 //verify Item Order Date
		 /*value = WebUI.getAttribute(findTestObject('Object Repository/Pricing Page/Form/Article Form/input_Item Order Date'), 'value')
		 WebUI.verifyMatch(value, parsedJson['packages']['unit'].getAt('item_order_date_unit')[articlesSize], true, FailureHandling.CONTINUE_ON_FAILURE)*/
		 //verify Item Color
		 value = WebUI.getAttribute(findTestObject('Object Repository/Pricing Page/Form/Article Form/input_Item Color'), 'value')
		 WebUI.verifyMatch(value, parsedJson['packages']['unit'].getAt('item_color_unit')[articlesSize], true, FailureHandling.CONTINUE_ON_FAILURE)
		 //verify Item Style
		 value = WebUI.getAttribute(findTestObject('Object Repository/Pricing Page/Form/Article Form/input_Item Style'), 'value')
		 WebUI.verifyMatch(value, parsedJson['packages']['unit'].getAt('item_style_unit')[articlesSize], true, FailureHandling.CONTINUE_ON_FAILURE)
		 //verify Item Made In
		 value = WebUI.getAttribute( findTestObject('Object Repository/Pricing Page/Form/Article Form/input_Item Made In'), 'value')
		 WebUI.verifyMatch(value, parsedJson['packages']['unit'].getAt('item_made_in_unit')[articlesSize], true, FailureHandling.CONTINUE_ON_FAILURE)
		 //verify Item Manufacture Proces
		 //verify Item Composition
		 value = WebUI.getAttribute(findTestObject('Object Repository/Pricing Page/Form/Article Form/input_Item Composition'), 'value')
		 WebUI.verifyMatch(value, parsedJson['packages']['unit'].getAt('item_composition_unit')[articlesSize], true, FailureHandling.CONTINUE_ON_FAILURE)
		 //verify Item Unit Price
		 value = WebUI.getAttribute(findTestObject('Object Repository/Pricing Page/Form/Article Form/input_Item Unit Price'), 'value')
		 WebUI.verifyMatch(value, String.format("%.0f",Double.parseDouble(parsedJson['packages']['unit'].getAt('item_unit_price_unit')[articlesSize])), true, FailureHandling.CONTINUE_ON_FAILURE)
		 //verify Item Line Total Gross Amount
		 value = WebUI.getAttribute(findTestObject('Object Repository/Pricing Page/Form/Article Form/input_Item Line Total Gross Amount'), 'value')
		 WebUI.verifyMatch(value, String.format("%.0f",parsedJson['packages']['unit'].getAt('item_line_total_gross_amount_unit')[articlesSize]), true, FailureHandling.CONTINUE_ON_FAILURE)
		 //verify Item CITES
		 //verify Item Attestation
		 //verify Item Product Line
		 value = WebUI.getAttribute(findTestObject('Object Repository/Pricing Page/Form/Article Form/input_Item Product Line'), 'value')
		 WebUI.verifyMatch(value, parsedJson['packages']['unit'].getAt('item_product_line_unit')[articlesSize], true, FailureHandling.CONTINUE_ON_FAILURE)
		 //verify Item Form
		 value = WebUI.getAttribute(findTestObject('Object Repository/Pricing Page/Form/Article Form/input_Item Form'), 'value')
		 WebUI.verifyMatch(value, parsedJson['packages']['unit'].getAt('item_form_unit')[articlesSize], true, FailureHandling.CONTINUE_ON_FAILURE)
		 //verify Item Order Nbr
		 value = WebUI.getAttribute( findTestObject('Object Repository/Pricing Page/Form/Article Form/input_Item Order Nbr'), 'value')
		 WebUI.verifyMatch(value, parsedJson['packages']['unit'].getAt('item_order_nbr_unit')[articlesSize], true, FailureHandling.CONTINUE_ON_FAILURE)
		 //verify Item Order Line Nbr
		 value = WebUI.getAttribute(findTestObject('Object Repository/Pricing Page/Form/Article Form/input_Item Order Line Nbr'), 'value')
		 WebUI.verifyMatch(value, parsedJson['packages']['unit'].getAt('item_order_line_nbr_unit')[articlesSize], true, FailureHandling.CONTINUE_ON_FAILURE)
		 //verify Item Item Customer PO Nbr
		 //verify Item Original Warehouse
		 value = WebUI.getAttribute(findTestObject('Object Repository/Pricing Page/Form/Article Form/input_Item Original Warehouse'), 'value')
		 WebUI.verifyMatch(value, parsedJson['packages']['unit'].getAt('item_original_warehouse_unit')[articlesSize], true, FailureHandling.CONTINUE_ON_FAILURE)
		 //verify Item Location
		 //verify Item Mag
		 value = WebUI.getAttribute( findTestObject('Object Repository/Pricing Page/Form/Article Form/input_Item Mag'), 'value')
		 WebUI.verifyMatch(value, parsedJson['packages']['unit'].getAt('item_mag_unit')[articlesSize], true, FailureHandling.CONTINUE_ON_FAILURE)
		 //verify Item Customs Code
		 value = WebUI.getAttribute( findTestObject('Object Repository/Pricing Page/Form/Article Form/input_Item Customs Code'), 'value')
		 WebUI.verifyMatch(value, parsedJson['packages']['unit'].getAt('item_customs_code_unit')[articlesSize], true, FailureHandling.CONTINUE_ON_FAILURE)
		 //verify Item Line Total Net Amount
		 value = WebUI.getAttribute(findTestObject('Object Repository/Pricing Page/Form/Article Form/input_Item Line Total Net Amount'), 'value')
		 WebUI.verifyMatch(value, String.format("%.0f",Double.parseDouble(parsedJson['packages']['unit'].getAt('item_line_total_net_amount_unit')[articlesSize])), true, FailureHandling.CONTINUE_ON_FAILURE)
		 //verify Item Preferential Origin
		 value = WebUI.getAttribute(findTestObject('Object Repository/Pricing Page/Form/Article Form/input_Item Preferential Origin'), 'value')
		 WebUI.verifyMatch(value, parsedJson['packages']['unit'].getAt('item_preferential_origin_unit')[articlesSize], true, FailureHandling.CONTINUE_ON_FAILURE)
		 //verify Comment
		 articlesSize--
		  
		 }
		 
	 }
	 e.click();
   }



