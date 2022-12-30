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
CustomKeywords.'settings.Address.createNewAddress'()
CustomKeywords.'settings.Address.editAnAddress'()
CustomKeywords.'settings.Address.deleteAnAddress'()

CustomKeywords.'settings.CostsCenter.addNewCostCenter'()
CustomKeywords.'settings.CostsCenter.editLastCostCenter'()
CustomKeywords.'settings.CostsCenter.deleteLastCostCenter'()

CustomKeywords.'settings.CostsItems.addCostItem'()
CustomKeywords.'settings.CostsItems.editCostItem'()
CustomKeywords.'settings.CostsItems.deleteCostItem'()

CustomKeywords.'settings.Flags.addNewFlag'()
CustomKeywords.'settings.Flags.editFlag'()
CustomKeywords.'settings.Flags.deleteFlag'()

CustomKeywords.'settings.TypeOfGoods.addTypeOfGoods'()
CustomKeywords.'settings.TypeOfGoods.editTypeOfGoods'()
CustomKeywords.'settings.TypeOfGoods.deleteTypeOfGoods'()

CustomKeywords.'settings.TypeOfVariants.addTypeOfVariants'()
CustomKeywords.'settings.TypeOfVariants.editTypeOfVariants'()
CustomKeywords.'settings.TypeOfVariants.deleteTypeOfVariants'()

CustomKeywords.'settings.OrderPriority.addNewOrderPriority'()
CustomKeywords.'settings.OrderPriority.editOrderPriority'()
CustomKeywords.'settings.OrderPriority.deleteOrderPriority'()

CustomKeywords.'settings.TypeOfDangerousGoods.addNewTypeOfDangerousGoods'()
CustomKeywords.'settings.TypeOfDangerousGoods.editTypeOfDangerousGoods'()
CustomKeywords.'settings.TypeOfDangerousGoods.deleteTypeOfDangerousGoods'()

CustomKeywords.'settings.TypeOfPackaging.addNewTypeOfPackaging'()
CustomKeywords.'settings.TypeOfPackaging.editTypeOfPackaging'()
CustomKeywords.'settings.TypeOfPackaging.deleteTypeOfPackaging'()

CustomKeywords.'settings.UnitOfMeasure.addUnitOfMeasure'()
CustomKeywords.'settings.UnitOfMeasure.editUnitOfMeasure'()
CustomKeywords.'settings.UnitOfMeasure.deleteUnitOfMeasure'()

CustomKeywords.'settings.IncidentCategory.addIncidentCategory'()
CustomKeywords.'settings.IncidentCategory.editIncidentCategory'()
CustomKeywords.'settings.IncidentCategory.deleteIncidentCategory'()
/*
CustomKeywords.'settings.ConfigurationField.addConfigurationField'()
CustomKeywords.'settings.ConfigurationField.editConfigurationField'()
CustomKeywords.'settings.ConfigurationField.deleteConfigurationField'()
*/
CustomKeywords.'settings.Incoterms.addNewIncoterm'()
CustomKeywords.'settings.Incoterms.editIncoterm'()
CustomKeywords.'settings.Incoterms.deleteIncoterm'()

CustomKeywords.'settings.TypeOfFlow.addNewTypeOfFlow'()
CustomKeywords.'settings.TypeOfFlow.editTypeOfFlow'()
CustomKeywords.'settings.TypeOfFlow.deleteTypeOfFlow'()

CustomKeywords.'settings.RefusalReason.addNewRefusalReason'()
CustomKeywords.'settings.RefusalReason.editRefusalReason'()
CustomKeywords.'settings.RefusalReason.deleteRefusalReason'()


