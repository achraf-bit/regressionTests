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

import org.openqa.selenium.WebElement

import internal.GlobalVariable

public class AutomaticActions {



	def getNameCountryOrigin() {
		def countryName = WebUI.getText(findTestObject('Object Repository/Pricing Page/Form/country_Origin_Name')).trim()
		def countryOrigin = countryName
		if(countryOrigin.contains(" (")) {
			countryOrigin = countryOrigin.substring(countryOrigin.indexOf("(")+1,countryOrigin.indexOf(")"))
		}
		println(countryOrigin)
		return countryOrigin
	}



	def getNameCountryDest() {
		def countryName = WebUI.getText(findTestObject('Object Repository/Pricing Page/Form/country_Dest_Name')).trim()
		def countryDest = countryName
		if(countryName.contains(" (")) {
			countryDest = countryDest.substring(countryDest.indexOf("(")+1,countryDest.indexOf(")"))
		}
		println(countryDest)
		return countryDest
	}



	def getItemCites() {
		List<WebElement> itemCites = WebUI.findWebElements(findTestObject('Object Repository/Pricing Page/Form/item_Cites'),30)
		def item
		for (int i= 0; i < itemCites.size(); i++) {
			if(itemCites.get(i).getText() == "CIT") {
				item = itemCites.get(i).getText()
			}
		}
		return item
	}

	@Keyword
	def verifyCertificatOriginFranceExpected() {
		if((getNameCountryOrigin()=="France") && (getNameCountryDest()=="China" || getNameCountryDest()=="United Arab Emirates" ||
		getNameCountryDest()=="Kuwait" || getNameCountryDest()=="Qatar" || getNameCountryDest()=="Thailand" ||
		getNameCountryDest()=="Turkey"|| getNameCountryDest()=="Vietnam")) {
			WebUI.waitForElementPresent(findTestObject('Pricing Page/Documents/TypeOfDoc - Certificat Origine'), 0)
			WebUI.verifyElementPresent(findTestObject('Pricing Page/Documents/TypeOfDoc - Certificat Origine'), 0)
		}
	}
	@Keyword
	def verifyCitesFranceExpected() {

		if((getNameCountryOrigin()=="France" )&& (getNameCountryDest()=="Australia"|| getNameCountryDest()=="Brazil" ||
		getNameCountryDest()=="Canada" || getNameCountryDest()=="Switzerland" || getNameCountryDest()=="United Kingdom" ||
		getNameCountryDest()=="Hong Kong" || getNameCountryDest()=="Indonesia" || getNameCountryDest()=="Japan" ||
		getNameCountryDest()=="South Korea" || getNameCountryDest()=="Lebanon" || getNameCountryDest()=="Monaco" ||
		getNameCountryDest()=="Mexico" || getNameCountryDest()=="Malaysia" || getNameCountryDest()=="Panama" ||
		getNameCountryDest()=="Russia" || getNameCountryDest()=="United States" || getNameCountryDest()=="China" ||
		getNameCountryDest()=="United Arab Emirates" || getNameCountryDest()=="Kuwait" || getNameCountryDest()=="Qatar" ||
		getNameCountryDest()=="Thailand" || getNameCountryDest()=="Turkey"|| getNameCountryDest()=="Vietnam")
		&& (getItemCites()=="CIT")) {
			WebUI.waitForElementPresent(findTestObject('Object Repository/Pricing Page/Documents/TypeOfDoc - CITES'), 0)
			WebUI.verifyElementPresent(findTestObject('Object Repository/Pricing Page/Documents/TypeOfDoc - CITES'), 0)
		}
	}



	@Keyword
	def verifyProformaSpFranceExpected() {
		if((getNameCountryOrigin()=="France" ) && (getNameCountryDest()=="Australia"|| getNameCountryDest()=="Brazil" ||
		getNameCountryDest()=="Canada" || getNameCountryDest()=="Switzerland" || getNameCountryDest()=="United Kingdom" ||
		getNameCountryDest()=="Hong Kong" || getNameCountryDest()=="Indonesia" || getNameCountryDest()=="Japan" ||
		getNameCountryDest()=="South Korea" || getNameCountryDest()=="Monaco" ||
		getNameCountryDest()=="Mexico" || getNameCountryDest()=="Malaysia" || getNameCountryDest()=="Panama" ||
		getNameCountryDest()=="United States" ||getNameCountryDest()=="China" ||
		getNameCountryDest()=="United Arab Emirates" ||getNameCountryDest()=="Kuwait" || getNameCountryDest()=="Qatar" ||
		getNameCountryDest()=="Thailand" || getNameCountryDest()=="Turkey"|| getNameCountryDest()=="Vietnam")) {
			WebUI.waitForElementPresent(findTestObject('Object Repository/Pricing Page/Documents/TypeOfDoc -  Proforma SP'), 0)
			WebUI.verifyElementPresent(findTestObject('Object Repository/Pricing Page/Documents/TypeOfDoc -  Proforma SP'), 0)
		}
	}

	@Keyword
	def verifyDeliveryNoteFranceExpected() {
		if((getNameCountryOrigin()=="France") && (getNameCountryDest()=="China" || getNameCountryDest()=="United Arab Emirates" ||
		getNameCountryDest()=="Kuwait" || getNameCountryDest()=="Qatar" || getNameCountryDest()=="Thailand" ||
		getNameCountryDest()=="Turkey"|| getNameCountryDest()=="Vietnam")) {
			WebUI.waitForElementPresent(findTestObject('Object Repository/Pricing Page/Documents/TypeOfDoc - DeliveryNote'), 0)
			WebUI.verifyElementPresent(findTestObject('Object Repository/Pricing Page/Documents/TypeOfDoc - DeliveryNote'), 0)
		}
	}
}




