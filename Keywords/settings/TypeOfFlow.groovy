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
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import org.openqa.selenium.Keys as Keys
import internal.GlobalVariable

public class TypeOfFlow {
	@Keyword
	def addNewTypeOfFlow() {
		WebUI.click(findTestObject('Object Repository/Home Page/Sidebar/button_Settings'))
		WebUI.click(findTestObject('Object Repository/Settings/Breadcumbs/button_My company'))
		WebUI.click(findTestObject('Object Repository/Settings/Type of Flow Settings/button_Type of flow'))
		WebUI.waitForElementVisible(findTestObject('Object Repository/Settings/Type of Flow Settings/input_Designation Dashboard'),0)
		WebUI.click(findTestObject('Object Repository/Settings/Dashboard/header/button_Add'))
		WebUI.waitForElementVisible(findTestObject('Object Repository/Settings/Type of Flow Settings/input_Designation'), 0)
		WebUI.setText(findTestObject('Object Repository/Settings/Type of Flow Settings/input_Designation'), 'test')
		WebUI.setText(findTestObject('Object Repository/Settings/Type of Flow Settings/input_Code'), '1')
		WebUI.click(findTestObject('Object Repository/Settings/Type of Flow Settings/input_Select Incoterms'))
		WebUI.sendKeys(findTestObject('Object Repository/Settings/Type of Flow Settings/input_Select Incoterms'),Keys.chord(Keys.ENTER))
		WebUI.check(findTestObject('Object Repository/Settings/Settings Commons/checkbox_Means Of Transport (AIR)'))
		WebUI.check(findTestObject('Object Repository/Settings/Settings Commons/checkbox_Means Of Transport (SEA)'))
		WebUI.check(findTestObject('Object Repository/Settings/Settings Commons/checkbox_Means Of Transport (ROAD)'))
		WebUI.click(findTestObject('Object Repository/Settings/Settings Commons/checkbox_Means Of Transport (INTEGRATOR)'))
		WebUI.check(findTestObject('Object Repository/Settings/Settings Commons/checkbox_Means Of Transport (RAIL)'))
		WebUI.check(findTestObject('Object Repository/Settings/Settings Commons/checkbox_Means Of Transport (WATERWAY)'))
		WebUI.click(findTestObject('Object Repository/Settings/Type of Flow Settings/input_Select Schemas psl'))
		WebUI.sendKeys(findTestObject('Object Repository/Settings/Type of Flow Settings/input_Select Schemas psl'),Keys.chord(Keys.ENTER))
		WebUI.click(findTestObject('Object Repository/Settings/Type of Flow Settings/radio_Tracking level (By transport)'))
		WebUI.click(findTestObject('Object Repository/Settings/Dashboard/button_Add'))
		WebUI.waitForElementVisible(findTestObject('Object Repository/Settings/Type of Flow Settings/input_Designation Dashboard'),0)
		WebUI.setText(findTestObject('Object Repository/Settings/Type of Flow Settings/input_Designation Dashboard'),'test')
		WebUI.delay(3)
		WebUI.verifyElementVisible(findTestObject('Object Repository/Settings/Dashboard/first checkbox of the list'))
	}

	@Keyword
	def editTypeOfFlow() {
		WebUI.click(findTestObject('Object Repository/Home Page/Sidebar/button_Settings'))
		WebUI.click(findTestObject('Object Repository/Settings/Breadcumbs/button_My company'))
		WebUI.click(findTestObject('Object Repository/Settings/Type of Flow Settings/button_Type of flow'))
		WebUI.waitForElementVisible(findTestObject('Object Repository/Settings/Type of Flow Settings/input_Designation Dashboard'),0)
		WebUI.setText(findTestObject('Object Repository/Settings/Type of Flow Settings/input_Designation Dashboard'),'test')
		WebUI.delay(3)
		WebUI.click(findTestObject('Object Repository/Settings/Dashboard/first checkbox of the list'))
		WebUI.click(findTestObject('Object Repository/Settings/Dashboard/header/button_Edit'))
		WebUI.waitForElementVisible(findTestObject('Object Repository/Settings/Type of Flow Settings/input_Designation'), 0)
		WebUI.setText(findTestObject('Object Repository/Settings/Type of Flow Settings/input_Designation'), 'test2')
		WebUI.setText(findTestObject('Object Repository/Settings/Type of Flow Settings/input_Code'), '2')
		WebUI.click(findTestObject('Object Repository/Settings/Type of Flow Settings/button_Clean Select incoterms'))
		WebUI.click(findTestObject('Object Repository/Settings/Type of Flow Settings/input_Select Incoterms'))
		WebUI.sendKeys(findTestObject('Object Repository/Settings/Type of Flow Settings/input_Select Incoterms'),Keys.chord(Keys.DOWN))
		WebUI.sendKeys(findTestObject('Object Repository/Settings/Type of Flow Settings/input_Select Incoterms'),Keys.chord(Keys.ENTER))
		WebUI.uncheck(findTestObject('Object Repository/Settings/Settings Commons/checkbox_Means Of Transport (AIR)'))
		WebUI.uncheck(findTestObject('Object Repository/Settings/Settings Commons/checkbox_Means Of Transport (SEA)'))
		WebUI.check(findTestObject('Object Repository/Settings/Settings Commons/checkbox_Means Of Transport (ROAD)'))
		WebUI.click(findTestObject('Object Repository/Settings/Settings Commons/checkbox_Means Of Transport (INTEGRATOR)'))
		WebUI.check(findTestObject('Object Repository/Settings/Settings Commons/checkbox_Means Of Transport (RAIL)'))
		WebUI.check(findTestObject('Object Repository/Settings/Settings Commons/checkbox_Means Of Transport (WATERWAY)'))
		WebUI.click(findTestObject('Object Repository/Settings/Type of Flow Settings/button_Clean Select schemas psl'))
		WebUI.click(findTestObject('Object Repository/Settings/Type of Flow Settings/input_Select Schemas psl'))
		WebUI.sendKeys(findTestObject('Object Repository/Settings/Type of Flow Settings/input_Select Schemas psl'),Keys.chord(Keys.DOWN))
		WebUI.sendKeys(findTestObject('Object Repository/Settings/Type of Flow Settings/input_Select Schemas psl'),Keys.chord(Keys.ENTER))
		WebUI.click(findTestObject('Object Repository/Settings/Type of Flow Settings/radio_Tracking level (Palette)'))
		WebUI.click(findTestObject('Object Repository/Settings/Dashboard/button_Update'))
		WebUI.waitForElementVisible(findTestObject('Object Repository/Settings/Type of Flow Settings/input_Designation Dashboard'),0)
		WebUI.setText(findTestObject('Object Repository/Settings/Type of Flow Settings/input_Designation Dashboard'),'test2')
		WebUI.delay(3)
		WebUI.verifyElementVisible(findTestObject('Object Repository/Settings/Dashboard/first checkbox of the list'))
	}

	@Keyword
	def deleteTypeOfFlow(){
		WebUI.click(findTestObject('Object Repository/Home Page/Sidebar/button_Settings'))
		WebUI.click(findTestObject('Object Repository/Settings/Breadcumbs/button_My company'))
		WebUI.click(findTestObject('Object Repository/Settings/Type of Flow Settings/button_Type of flow'))
		WebUI.waitForElementVisible(findTestObject('Object Repository/Settings/Type of Flow Settings/input_Designation Dashboard'),0)
		WebUI.setText(findTestObject('Object Repository/Settings/Type of Flow Settings/input_Designation Dashboard'),'test2')
		WebUI.delay(3)
		WebUI.click(findTestObject('Object Repository/Settings/Dashboard/first checkbox of the list'))
		WebUI.click(findTestObject('Object Repository/Settings/Dashboard/header/button_Delete'))
		WebUI.click(findTestObject('Object Repository/Home Page/Modal/button_Yes_Cancel'))
		WebUI.waitForElementVisible(findTestObject('Object Repository/Settings/Type of Flow Settings/input_Designation Dashboard'),0)
		WebUI.setText(findTestObject('Object Repository/Settings/Type of Flow Settings/input_Designation Dashboard'),'test2')
		WebUI.delay(3)
		WebUI.verifyElementNotPresent(findTestObject('Object Repository/Settings/Dashboard/first checkbox of the list'),0)
	}
}
