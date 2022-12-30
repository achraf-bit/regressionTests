package auth

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

public class Login { 
	@Keyword
	def loginSuperAdmin() {
		login(GlobalVariable.superadmin_1_username, GlobalVariable.superadmin_1_password)
	}

	def login(String username, String password) {
		WebUI.openBrowser(GlobalVariable.app_url)

		WebUI.setText(findTestObject('Object Repository/SSO Keycloak/input_usernameOrEmail'), username)

		WebUI.setEncryptedText(findTestObject('Object Repository/SSO Keycloak/input_Password'), password)

		WebUI.click(findTestObject('Object Repository/SSO Keycloak/btn_SignIn'))

		WebUI.waitForElementVisible(findTestObject('Object Repository/TMS Commons/Header/Logo MyTower'), 20)
	}
}
