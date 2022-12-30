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
import com.kms.katalon.core.webui.keyword.internal.WebUIAbstractKeyword
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import org.openqa.selenium.Keys as Keys
import internal.GlobalVariable

public class Address {
	@Keyword
	def createNewAddress() {
		WebUI.click(findTestObject('Object Repository/Home Page/Sidebar/button_Settings'))
		WebUI.click(findTestObject('Object Repository/Settings/Breadcumbs/button_My company'))
		WebUI.click(findTestObject('Object Repository/Settings/Address Settings/button_Address'))
		WebUI.click(findTestObject('Object Repository/Settings/Dashboard/header/button_Add'))
		WebUI.waitForElementVisible(findTestObject('Object Repository/Settings/Address Settings/input_Reference'), 0)
		WebUI.delay(3)
		WebUI.setText(findTestObject('Object Repository/Settings/Address Settings/input_Reference'), 'R1')
		WebUI.setText(findTestObject('Object Repository/Settings/Address Settings/input_Company'), 'VEMARS CCSA')
		WebUI.setText(findTestObject('Object Repository/Settings/Address Settings/input_Recipients identity'), 'VEMARS WALIS')
		WebUI.setText(findTestObject('Object Repository/Settings/Address Settings/input_Address_street'), '121-1160, Komagatani')
		WebUI.setText(findTestObject('Object Repository/Settings/Address Settings/input_Additional address_secondaryStreet'), '12-32, Akasaka 1-chome')
		WebUI.setText(findTestObject('Object Repository/Settings/Address Settings/input_Additional address 2_secondaryAdditionalAddress'), ' 394-1122, Maruyamakitako')
		WebUI.setText(findTestObject('Object Repository/Settings/Address Settings/input_City'), ' Habikino-shi')
		WebUI.setText(findTestObject('Object Repository/Settings/Address Settings/input_ZIP code'), '5830000')
		WebUI.setText(findTestObject('Object Repository/Settings/Address Settings/input_Status'), 'Osaka')
		WebUI.setText(findTestObject('Object Repository/Settings/Address Settings/input_New Country Address'), 'Japan')
		WebUI.sendKeys(findTestObject('Object Repository/Settings/Address Settings/input_New Country Address'),Keys.chord(Keys.ENTER))
		WebUI.setText(findTestObject('Object Repository/Settings/Address Settings/input_AirportPort'), 'Osakas Kansai Airport')
		WebUI.setText(findTestObject('Object Repository/Settings/Address Settings/input_Phone'), '+8186-015-1631')
		WebUI.setText(findTestObject('Object Repository/Settings/Address Settings/input_E-mail'), 'kanai.daian@fallinhay.com')
		WebUI.setText(findTestObject('Object Repository/Settings/Address Settings/input_Opening hours'), '11')
		WebUI.setText(findTestObject('Object Repository/Settings/Address Settings/input_Commentaire'), 'false')
		WebUI.setText(findTestObject('Object Repository/Settings/Address Settings/select_Visibility'), 'all')
		WebUI.sendKeys(findTestObject('Object Repository/Settings/Address Settings/select_Visibility'),Keys.chord(Keys.ENTER))
		WebUI.setText(findTestObject('Object Repository/Settings/Address Settings/input_OriginDestination user'), 'Osaka')
		WebUI.setText(findTestObject('Object Repository/Settings/Address Settings/input_VAT identification number'), 'R1')
		WebUI.setText(findTestObject('Object Repository/Settings/Address Settings/input_SIREN'), '12453')
		WebUI.setText(findTestObject('Object Repository/Settings/Address Settings/input_SIRET'), '124500')
		WebUI.setText(findTestObject('Object Repository/Settings/Address Settings/input_Latitude'), '111101')
		WebUI.setText(findTestObject('Object Repository/Settings/Address Settings/input_Longitude'), '12022')
		WebUI.click(findTestObject('Object Repository/Settings/Modal/button_Save'))
		WebUI.waitForElementVisible(findTestObject('Object Repository/Growl Notification/flash_Notice_Operation successfully completed'), 0,FailureHandling.CONTINUE_ON_FAILURE)
		WebUI.verifyElementVisible(findTestObject('Object Repository/Growl Notification/flash_Notice_Operation successfully completed') ,FailureHandling.CONTINUE_ON_FAILURE)
	}

	@Keyword
	def deleteAnAddress() {
		WebUI.click(findTestObject('Object Repository/Home Page/Sidebar/button_Settings'))
		WebUI.click(findTestObject('Object Repository/Settings/Breadcumbs/button_My company'))
		WebUI.click(findTestObject('Object Repository/Settings/Address Settings/button_Address'))
		WebUI.setText(findTestObject('Object Repository/Settings/Address Settings/input_Reference Dashboard'), 'R2')
		WebUI.delay(3)
		WebUI.check(findTestObject('Object Repository/Settings/Dashboard/first checkbox of the list'))
		WebUI.click(findTestObject('Object Repository/Settings/Dashboard/header/button_Delete'))
		WebUI.click(findTestObject('Object Repository/TMS Commons/Modal/Modal (old) yes button'))
		WebUI.waitForElementVisible(findTestObject('Object Repository/Growl Notification/flash_Notice_Operation successfully completed'), 0,FailureHandling.CONTINUE_ON_FAILURE)
		WebUI.verifyElementVisible(findTestObject('Object Repository/Growl Notification/flash_Notice_Operation successfully completed'),FailureHandling.CONTINUE_ON_FAILURE)
	}

	@Keyword
	def editAnAddress() {
		WebUI.click(findTestObject('Object Repository/Home Page/Sidebar/button_Settings'))
		WebUI.click(findTestObject('Object Repository/Settings/Breadcumbs/button_My company'))
		WebUI.click(findTestObject('Object Repository/Settings/Address Settings/button_Address'))
		WebUI.waitForElementVisible(findTestObject('Object Repository/Settings/Address Settings/input_Reference Dashboard'),0)
		WebUI.setText(findTestObject('Object Repository/Settings/Address Settings/input_Reference Dashboard'), 'R1')
		WebUI.delay(3)
		WebUI.check(findTestObject('Object Repository/Settings/Dashboard/first checkbox of the list'))
		WebUI.click(findTestObject('Object Repository/Settings/Dashboard/header/button_Edit'))
		WebUI.waitForElementVisible(findTestObject('Object Repository/Settings/Address Settings/input_Reference'), 0)
		WebUI.delay(3)
		WebUI.setText(findTestObject('Object Repository/Settings/Address Settings/input_Reference'), 'R2')
		WebUI.setText(findTestObject('Object Repository/Settings/Address Settings/input_Company'), 'Sinopec Group')
		WebUI.setText(findTestObject('Object Repository/Settings/Address Settings/input_Recipients identity'), 'Sinopec')
		WebUI.setText(findTestObject('Object Repository/Settings/Address Settings/input_Address_street'), 'Da Zhi Lu 66hao Ge Ge Wu 2702shi')
		WebUI.setText(findTestObject('Object Repository/Settings/Address Settings/input_Additional address_secondaryStreet'), '13-55 Da Zhi Lu 66hao ')
		WebUI.setText(findTestObject('Object Repository/Settings/Address Settings/input_Additional address 2_secondaryAdditionalAddress'), ' 120985, Maruyamakitako')
		WebUI.setText(findTestObject('Object Repository/Settings/Address Settings/input_City'), ' Wuhan - Jiangan District')
		WebUI.setText(findTestObject('Object Repository/Settings/Address Settings/input_ZIP code'), '6200000')
		WebUI.setText(findTestObject('Object Repository/Settings/Address Settings/input_Status'), 'Hubei')
		WebUI.setText(findTestObject('Object Repository/Settings/Address Settings/input_New Country Address'), 'China')
		WebUI.sendKeys(findTestObject('Object Repository/Settings/Address Settings/input_New Country Address'),Keys.chord(Keys.ENTER))
		WebUI.setText(findTestObject('Object Repository/Settings/Address Settings/input_AirportPort'), 'Hubei Airport')
		WebUI.setText(findTestObject('Object Repository/Settings/Address Settings/input_Phone'), '+8613073326105')
		WebUI.setText(findTestObject('Object Repository/Settings/Address Settings/input_E-mail'), 'VEMARS.WALI@fallinhay.com')
		WebUI.setText(findTestObject('Object Repository/Settings/Address Settings/input_Opening hours'), '13')
		WebUI.setText(findTestObject('Object Repository/Settings/Address Settings/input_Commentaire'), 'true')
		WebUI.sendKeys(findTestObject('Object Repository/Settings/Address Settings/select_Visibility'), Keys.chord(Keys.BACK_SPACE))
		WebUI.setText(findTestObject('Object Repository/Settings/Address Settings/select_Visibility'), 'Chanel')
		WebUI.sendKeys(findTestObject('Object Repository/Settings/Address Settings/select_Visibility'),Keys.chord(Keys.ENTER))
		WebUI.setText(findTestObject('Object Repository/Settings/Address Settings/input_OriginDestination user'), 'Hubei')
		WebUI.setText(findTestObject('Object Repository/Settings/Address Settings/input_VAT identification number'), 'R2')
		WebUI.setText(findTestObject('Object Repository/Settings/Address Settings/input_SIREN'), '1200000')
		WebUI.setText(findTestObject('Object Repository/Settings/Address Settings/input_SIRET'), '1200001')
		WebUI.setText(findTestObject('Object Repository/Settings/Address Settings/input_Latitude'), '125021')
		WebUI.setText(findTestObject('Object Repository/Settings/Address Settings/input_Longitude'), '125600')
		WebUI.click(findTestObject('Object Repository/Settings/Modal/button_Save'))
		WebUI.waitForElementPresent(findTestObject('Object Repository/Growl Notification/flash_Notice_Operation successfully completed'), 0,FailureHandling.CONTINUE_ON_FAILURE)
		WebUI.verifyElementVisible(findTestObject('Object Repository/Growl Notification/flash_Notice_Operation successfully completed'),FailureHandling.CONTINUE_ON_FAILURE)
	}
}
