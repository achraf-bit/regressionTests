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
import com.kms.katalon.core.configuration.RunConfiguration
import org.openqa.selenium.Keys as Keys
import internal.GlobalVariable

public class Documents {
	@Keyword
	def uploadDocument() {
		WebUI.uploadFile(findTestObject('Object Repository/Pricing Page/Documents/TypeOfDoc - Other'), RunConfiguration.getProjectDir() + '/Data Files/Upload File/testChanel.txt')
		WebUI.verifyElementVisible(findTestObject('Pricing Page/Documents/Upload Document/file_Uploaded'))
	}

	@Keyword
	def exportDocument() {
		WebUI.click(findTestObject('Pricing Page/Documents/Export Documents/button_Export'))
		WebUI.click(findTestObject('Pricing Page/Documents/Export Documents/button_Template'))
		WebUI.click(findTestObject('Pricing Page/Documents/Export Documents/select_Template'))
		WebUI.click(findTestObject('Pricing Page/Documents/Export Documents/button_Actions'))
		WebUI.click(findTestObject('Pricing Page/Documents/Export Documents/select_BC'))
		WebUI.click(findTestObject('Pricing Page/Documents/Export Documents/button_Confirm'))
		WebUI.verifyElementVisible(findTestObject('Pricing Page/Documents/Export Documents/file_Exported'))
	}

	@Keyword
	def exportAtrTemplate() {
		WebUI.click(findTestObject('Pricing Page/Documents/Export Documents/button_Export'))
		WebUI.waitForElementNotPresent(findTestObject('Object Repository/Pricing Page/Documents/Export Documents/template Loader'), 0)
		WebUI.setText(findTestObject('Object Repository/Pricing Page/Documents/Export Documents/input_Template'),'ATR')
		WebUI.sendKeys(findTestObject('Object Repository/Pricing Page/Documents/Export Documents/input_Template'), Keys.chord(Keys.ENTER))
		WebUI.click(findTestObject('Object Repository/Pricing Page/Documents/Export Documents/input_PDF_formatPDF'))
		WebUI.setText(findTestObject('Object Repository/Pricing Page/Documents/Export Documents/input_Documents type'),'Other')
		WebUI.sendKeys(findTestObject('Object Repository/Pricing Page/Documents/Export Documents/input_Documents type'), Keys.chord(Keys.ENTER))
		WebUI.click(findTestObject('Pricing Page/Documents/Export Documents/button_Confirm'))
		WebUI.waitForElementNotPresent(findTestObject('Object Repository/Home Page/Modal/page loader'), 0)
		WebUI.waitForElementVisible(findTestObject('Pricing Page/Documents/Export Documents/file_Exported'),0)
		WebUI.verifyElementVisible(findTestObject('Pricing Page/Documents/Export Documents/file_Exported'))
	}
	@Keyword
	def exportAttestationDeVenteTemplate() {
		WebUI.click(findTestObject('Pricing Page/Documents/Export Documents/button_Export'))
		WebUI.waitForElementNotPresent(findTestObject('Object Repository/Pricing Page/Documents/Export Documents/template Loader'), 0)
		WebUI.setText(findTestObject('Object Repository/Pricing Page/Documents/Export Documents/input_Template'),'Attestation de Vente')
		WebUI.sendKeys(findTestObject('Object Repository/Pricing Page/Documents/Export Documents/input_Template'), Keys.chord(Keys.ENTER))
		WebUI.click(findTestObject('Object Repository/Pricing Page/Documents/Export Documents/input_PDF_formatPDF'))
		WebUI.setText(findTestObject('Object Repository/Pricing Page/Documents/Export Documents/input_Documents type'),'Other')
		WebUI.sendKeys(findTestObject('Object Repository/Pricing Page/Documents/Export Documents/input_Documents type'), Keys.chord(Keys.ENTER))
		WebUI.click(findTestObject('Pricing Page/Documents/Export Documents/button_Confirm'))
		WebUI.waitForElementNotPresent(findTestObject('Object Repository/Home Page/Modal/page loader'), 0)
		WebUI.waitForElementVisible(findTestObject('Pricing Page/Documents/Export Documents/file_Exported'),0)
		WebUI.verifyElementVisible(findTestObject('Pricing Page/Documents/Export Documents/file_Exported'))
	}
	@Keyword
	def exportBonDeChargementTemplate() {
		WebUI.click(findTestObject('Pricing Page/Documents/Export Documents/button_Export'))
		WebUI.waitForElementNotPresent(findTestObject('Object Repository/Pricing Page/Documents/Export Documents/template Loader'), 0)
		WebUI.setText(findTestObject('Object Repository/Pricing Page/Documents/Export Documents/input_Template'),'Bon de Chargement')
		WebUI.sendKeys(findTestObject('Object Repository/Pricing Page/Documents/Export Documents/input_Template'), Keys.chord(Keys.ENTER))
		WebUI.click(findTestObject('Object Repository/Pricing Page/Documents/Export Documents/input_PDF_formatPDF'))
		WebUI.setText(findTestObject('Object Repository/Pricing Page/Documents/Export Documents/input_Documents type'),'Other')
		WebUI.sendKeys(findTestObject('Object Repository/Pricing Page/Documents/Export Documents/input_Documents type'), Keys.chord(Keys.ENTER))
		WebUI.click(findTestObject('Pricing Page/Documents/Export Documents/button_Confirm'))
		WebUI.waitForElementNotPresent(findTestObject('Object Repository/Home Page/Modal/page loader'), 0)
		WebUI.waitForElementVisible(findTestObject('Pricing Page/Documents/Export Documents/file_Exported'),0)
		WebUI.verifyElementVisible(findTestObject('Pricing Page/Documents/Export Documents/file_Exported'))
	}
	@Keyword
	def exportCertificatOrigineTemplate() {
		WebUI.click(findTestObject('Pricing Page/Documents/Export Documents/button_Export'))
		WebUI.waitForElementNotPresent(findTestObject('Object Repository/Pricing Page/Documents/Export Documents/template Loader'), 0)
		WebUI.setText(findTestObject('Object Repository/Pricing Page/Documents/Export Documents/input_Template'),"Certificat d'origine")
		WebUI.sendKeys(findTestObject('Object Repository/Pricing Page/Documents/Export Documents/input_Template'), Keys.chord(Keys.ENTER))
		WebUI.click(findTestObject('Object Repository/Pricing Page/Documents/Export Documents/input_PDF_formatPDF'))
		WebUI.setText(findTestObject('Object Repository/Pricing Page/Documents/Export Documents/input_Documents type'),'Other')
		WebUI.sendKeys(findTestObject('Object Repository/Pricing Page/Documents/Export Documents/input_Documents type'), Keys.chord(Keys.ENTER))
		WebUI.click(findTestObject('Pricing Page/Documents/Export Documents/button_Confirm'))
		WebUI.waitForElementNotPresent(findTestObject('Object Repository/Home Page/Modal/page loader'), 0)
		WebUI.waitForElementVisible(findTestObject('Pricing Page/Documents/Export Documents/file_Exported'),0)
		WebUI.verifyElementVisible(findTestObject('Pricing Page/Documents/Export Documents/file_Exported'))
	}
	@Keyword
	def exportDDT_EU_Template() {
		WebUI.click(findTestObject('Pricing Page/Documents/Export Documents/button_Export'))
		WebUI.waitForElementNotPresent(findTestObject('Object Repository/Pricing Page/Documents/Export Documents/template Loader'), 0)
		WebUI.setText(findTestObject('Object Repository/Pricing Page/Documents/Export Documents/input_Template'),'DDT EU')
		WebUI.sendKeys(findTestObject('Object Repository/Pricing Page/Documents/Export Documents/input_Template'), Keys.chord(Keys.ENTER))
		WebUI.click(findTestObject('Object Repository/Pricing Page/Documents/Export Documents/input_PDF_formatPDF'))
		WebUI.setText(findTestObject('Object Repository/Pricing Page/Documents/Export Documents/input_Documents type'),'Other')
		WebUI.sendKeys(findTestObject('Object Repository/Pricing Page/Documents/Export Documents/input_Documents type'), Keys.chord(Keys.ENTER))
		WebUI.click(findTestObject('Pricing Page/Documents/Export Documents/button_Confirm'))
		WebUI.waitForElementNotPresent(findTestObject('Object Repository/Home Page/Modal/page loader'), 0)
		WebUI.waitForElementVisible(findTestObject('Pricing Page/Documents/Export Documents/file_Exported'),0)
		WebUI.verifyElementVisible(findTestObject('Pricing Page/Documents/Export Documents/file_Exported'))
	}
	@Keyword
	def exportDDT_EXTRA_EU_Template() {
		WebUI.click(findTestObject('Pricing Page/Documents/Export Documents/button_Export'))
		WebUI.waitForElementNotPresent(findTestObject('Object Repository/Pricing Page/Documents/Export Documents/template Loader'), 0)
		WebUI.setText(findTestObject('Object Repository/Pricing Page/Documents/Export Documents/input_Template'),'DDT EXTRA EU')
		WebUI.sendKeys(findTestObject('Object Repository/Pricing Page/Documents/Export Documents/input_Template'), Keys.chord(Keys.ENTER))
		WebUI.click(findTestObject('Object Repository/Pricing Page/Documents/Export Documents/input_PDF_formatPDF'))
		WebUI.setText(findTestObject('Object Repository/Pricing Page/Documents/Export Documents/input_Documents type'),'Other')
		WebUI.sendKeys(findTestObject('Object Repository/Pricing Page/Documents/Export Documents/input_Documents type'), Keys.chord(Keys.ENTER))
		WebUI.click(findTestObject('Pricing Page/Documents/Export Documents/button_Confirm'))
		WebUI.waitForElementNotPresent(findTestObject('Object Repository/Home Page/Modal/page loader'), 0)
		WebUI.waitForElementVisible(findTestObject('Pricing Page/Documents/Export Documents/file_Exported'),0)
		WebUI.verifyElementVisible(findTestObject('Pricing Page/Documents/Export Documents/file_Exported'))
	}
	@Keyword
	def exportDDT_ITALIE_Template() {
		WebUI.click(findTestObject('Pricing Page/Documents/Export Documents/button_Export'))
		WebUI.waitForElementNotPresent(findTestObject('Object Repository/Pricing Page/Documents/Export Documents/template Loader'), 0)
		WebUI.setText(findTestObject('Object Repository/Pricing Page/Documents/Export Documents/input_Template'),'DDT ITALIE')
		WebUI.sendKeys(findTestObject('Object Repository/Pricing Page/Documents/Export Documents/input_Template'), Keys.chord(Keys.ENTER))
		WebUI.click(findTestObject('Object Repository/Pricing Page/Documents/Export Documents/input_PDF_formatPDF'))
		WebUI.setText(findTestObject('Object Repository/Pricing Page/Documents/Export Documents/input_Documents type'),'Other')
		WebUI.sendKeys(findTestObject('Object Repository/Pricing Page/Documents/Export Documents/input_Documents type'), Keys.chord(Keys.ENTER))
		WebUI.click(findTestObject('Pricing Page/Documents/Export Documents/button_Confirm'))
		WebUI.waitForElementNotPresent(findTestObject('Object Repository/Home Page/Modal/page loader'), 0)
		WebUI.waitForElementVisible(findTestObject('Pricing Page/Documents/Export Documents/file_Exported'),0)
		WebUI.verifyElementVisible(findTestObject('Pricing Page/Documents/Export Documents/file_Exported'))
	}


	@Keyword
	def exportDDT_ITALY_SB_Template() {
		WebUI.click(findTestObject('Pricing Page/Documents/Export Documents/button_Export'))
		WebUI.waitForElementNotPresent(findTestObject('Object Repository/Pricing Page/Documents/Export Documents/template Loader'), 0)
		WebUI.setText(findTestObject('Object Repository/Pricing Page/Documents/Export Documents/input_Template'),'DDT ITALY SB')
		WebUI.sendKeys(findTestObject('Object Repository/Pricing Page/Documents/Export Documents/input_Template'), Keys.chord(Keys.ENTER))
		WebUI.click(findTestObject('Object Repository/Pricing Page/Documents/Export Documents/input_PDF_formatPDF'))
		WebUI.setText(findTestObject('Object Repository/Pricing Page/Documents/Export Documents/input_Documents type'),'Other')
		WebUI.sendKeys(findTestObject('Object Repository/Pricing Page/Documents/Export Documents/input_Documents type'), Keys.chord(Keys.ENTER))
		WebUI.click(findTestObject('Pricing Page/Documents/Export Documents/button_Confirm'))
		WebUI.waitForElementNotPresent(findTestObject('Object Repository/Home Page/Modal/page loader'), 0)
		WebUI.waitForElementVisible(findTestObject('Pricing Page/Documents/Export Documents/file_Exported'),0)
		WebUI.verifyElementVisible(findTestObject('Pricing Page/Documents/Export Documents/file_Exported'))
	}
	@Keyword
	def exportEUR1_Template() {
		WebUI.click(findTestObject('Pricing Page/Documents/Export Documents/button_Export'))
		WebUI.waitForElementNotPresent(findTestObject('Object Repository/Pricing Page/Documents/Export Documents/template Loader'), 0)
		WebUI.setText(findTestObject('Object Repository/Pricing Page/Documents/Export Documents/input_Template'),'EUR1')
		WebUI.sendKeys(findTestObject('Object Repository/Pricing Page/Documents/Export Documents/input_Template'), Keys.chord(Keys.ENTER))
		WebUI.click(findTestObject('Object Repository/Pricing Page/Documents/Export Documents/input_PDF_formatPDF'))
		WebUI.setText(findTestObject('Object Repository/Pricing Page/Documents/Export Documents/input_Documents type'),'Other')
		WebUI.sendKeys(findTestObject('Object Repository/Pricing Page/Documents/Export Documents/input_Documents type'), Keys.chord(Keys.ENTER))
		WebUI.click(findTestObject('Pricing Page/Documents/Export Documents/button_Confirm'))
		WebUI.waitForElementNotPresent(findTestObject('Object Repository/Home Page/Modal/page loader'), 0)
		WebUI.waitForElementVisible(findTestObject('Pricing Page/Documents/Export Documents/file_Exported'),0)
		WebUI.verifyElementVisible(findTestObject('Pricing Page/Documents/Export Documents/file_Exported'))
	}
	@Keyword
	def exportPackingListTemplate() {
		WebUI.click(findTestObject('Pricing Page/Documents/Export Documents/button_Export'))
		WebUI.waitForElementNotPresent(findTestObject('Object Repository/Pricing Page/Documents/Export Documents/template Loader'), 0)
		WebUI.setText(findTestObject('Object Repository/Pricing Page/Documents/Export Documents/input_Template'),'Packing List')
		WebUI.sendKeys(findTestObject('Object Repository/Pricing Page/Documents/Export Documents/input_Template'), Keys.chord(Keys.ENTER))
		WebUI.click(findTestObject('Object Repository/Pricing Page/Documents/Export Documents/input_PDF_formatPDF'))
		WebUI.setText(findTestObject('Object Repository/Pricing Page/Documents/Export Documents/input_Documents type'),'Other')
		WebUI.sendKeys(findTestObject('Object Repository/Pricing Page/Documents/Export Documents/input_Documents type'), Keys.chord(Keys.ENTER))
		WebUI.click(findTestObject('Pricing Page/Documents/Export Documents/button_Confirm'))
		WebUI.waitForElementNotPresent(findTestObject('Object Repository/Home Page/Modal/page loader'), 0)
		WebUI.waitForElementVisible(findTestObject('Pricing Page/Documents/Export Documents/file_Exported'),0)
		WebUI.verifyElementVisible(findTestObject('Pricing Page/Documents/Export Documents/file_Exported'))
	}

	@Keyword
	def exportShippingInstructionTemplate() {
		WebUI.click(findTestObject('Pricing Page/Documents/Export Documents/button_Export'))
		WebUI.waitForElementNotPresent(findTestObject('Object Repository/Pricing Page/Documents/Export Documents/template Loader'), 0)
		WebUI.setText(findTestObject('Object Repository/Pricing Page/Documents/Export Documents/input_Template'),'Shipping Instruction')
		WebUI.sendKeys(findTestObject('Object Repository/Pricing Page/Documents/Export Documents/input_Template'), Keys.chord(Keys.ENTER))
		WebUI.click(findTestObject('Object Repository/Pricing Page/Documents/Export Documents/input_PDF_formatPDF'))
		WebUI.setText(findTestObject('Object Repository/Pricing Page/Documents/Export Documents/input_Documents type'),'Shipping Instruction')
		WebUI.sendKeys(findTestObject('Object Repository/Pricing Page/Documents/Export Documents/input_Documents type'), Keys.chord(Keys.ENTER))
		WebUI.click(findTestObject('Pricing Page/Documents/Export Documents/button_Confirm'))
		WebUI.waitForElementNotPresent(findTestObject('Object Repository/Home Page/Modal/page loader'), 0)
		WebUI.waitForElementVisible(findTestObject('Pricing Page/Documents/Export Documents/file_Exported'),0)
		WebUI.verifyElementVisible(findTestObject('Pricing Page/Documents/Export Documents/file_Exported'))
	}
	@Keyword
	def exportSRITemplate() {
		WebUI.click(findTestObject('Pricing Page/Documents/Export Documents/button_Export'))
		WebUI.waitForElementNotPresent(findTestObject('Object Repository/Pricing Page/Documents/Export Documents/template Loader'), 0)
		WebUI.setText(findTestObject('Object Repository/Pricing Page/Documents/Export Documents/input_Template'),'SRI')
		WebUI.sendKeys(findTestObject('Object Repository/Pricing Page/Documents/Export Documents/input_Template'), Keys.chord(Keys.ENTER))
		WebUI.click(findTestObject('Object Repository/Pricing Page/Documents/Export Documents/input_PDF_formatPDF'))
		WebUI.setText(findTestObject('Object Repository/Pricing Page/Documents/Export Documents/input_Documents type'),'Other')
		WebUI.sendKeys(findTestObject('Object Repository/Pricing Page/Documents/Export Documents/input_Documents type'), Keys.chord(Keys.ENTER))
		WebUI.click(findTestObject('Pricing Page/Documents/Export Documents/button_Confirm'))
		WebUI.waitForElementNotPresent(findTestObject('Object Repository/Home Page/Modal/page loader'), 0)
		WebUI.waitForElementVisible(findTestObject('Pricing Page/Documents/Export Documents/file_Exported'),0)
		WebUI.verifyElementVisible(findTestObject('Pricing Page/Documents/Export Documents/file_Exported'))
	}
	@Keyword
	def exportStatementTemplate() {
		WebUI.click(findTestObject('Pricing Page/Documents/Export Documents/button_Export'))
		WebUI.waitForElementNotPresent(findTestObject('Object Repository/Pricing Page/Documents/Export Documents/template Loader'), 0)
		WebUI.setText(findTestObject('Object Repository/Pricing Page/Documents/Export Documents/input_Template'),'Statement')
		WebUI.sendKeys(findTestObject('Object Repository/Pricing Page/Documents/Export Documents/input_Template'), Keys.chord(Keys.ENTER))
		WebUI.click(findTestObject('Object Repository/Pricing Page/Documents/Export Documents/input_PDF_formatPDF'))
		WebUI.setText(findTestObject('Object Repository/Pricing Page/Documents/Export Documents/input_Documents type'),'Other')
		WebUI.sendKeys(findTestObject('Object Repository/Pricing Page/Documents/Export Documents/input_Documents type'), Keys.chord(Keys.ENTER))
		WebUI.click(findTestObject('Pricing Page/Documents/Export Documents/button_Confirm'))
		WebUI.waitForElementNotPresent(findTestObject('Object Repository/Home Page/Modal/page loader'), 0)
		WebUI.waitForElementVisible(findTestObject('Pricing Page/Documents/Export Documents/file_Exported'),0)
		WebUI.verifyElementVisible(findTestObject('Pricing Page/Documents/Export Documents/file_Exported'))
	}

	@Keyword
	def verifyCertificatOriginExpected() {
		WebUI.waitForElementPresent(findTestObject('Pricing Page/Documents/TypeOfDoc - Certificat Origine'), 0)
		WebUI.verifyElementPresent(findTestObject('Pricing Page/Documents/TypeOfDoc - Certificat Origine'), 0)
	}
}





