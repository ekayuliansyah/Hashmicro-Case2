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

WebUI.callTestCase(findTestCase('Login Homepage/Successful Login'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.verifyElementPresent(findTestObject('Object Repository/Page_Swag Labs/div_Swag Labs'), 0)

WebUI.verifyElementText(findTestObject('Object Repository/Page_Swag Labs/div_Sauce Labs Fleece Jacket'), 'Sauce Labs Fleece Jacket')

WebUI.click(findTestObject('Object Repository/Page_Swag Labs/button_Add to cart'))

WebUI.verifyElementText(findTestObject('Object Repository/Page_Swag Labs/button_Remove'), 'Remove')

WebUI.click(findTestObject('Object Repository/Page_Swag Labs/a_1'))

WebUI.verifyElementText(findTestObject('Object Repository/Page_Swag Labs/span_Your Cart'), 'Your Cart')

WebUI.click(findTestObject('Object Repository/Page_Swag Labs/div_1'))

WebUI.doubleClick(findTestObject('Object Repository/Page_Swag Labs/div_1'))

WebUI.verifyElementText(findTestObject('Object Repository/Page_Swag Labs/div_Sauce Labs Fleece Jacket'), 'Sauce Labs Fleece Jacket')

WebUI.click(findTestObject('Object Repository/Page_Swag Labs/button_Checkout'))

WebUI.verifyElementText(findTestObject('Object Repository/Page_Swag Labs/span_Checkout Your Information'), 'Checkout: Your Information')

WebUI.setText(findTestObject('Object Repository/Page_Swag Labs/input_Checkout Your Information_firstName'), 'Jhon')

WebUI.setText(findTestObject('Object Repository/Page_Swag Labs/input_Checkout Your Information_lastName'), 'Doe')

WebUI.setText(findTestObject('Object Repository/Page_Swag Labs/input_Checkout Your Information_postalCode'), '661622')

WebUI.click(findTestObject('Object Repository/Page_Swag Labs/input_Cancel_continue'))

WebUI.verifyElementText(findTestObject('Object Repository/Page_Swag Labs/span_Checkout Overview'), 'Checkout: Overview')

WebUI.verifyElementText(findTestObject('Object Repository/Page_Swag Labs/div_49.99'), '$49.99')

WebUI.verifyElementText(findTestObject('Object Repository/Page_Swag Labs/div_Tax 4.00'), 'Tax: $4.00')

WebUI.verifyElementText(findTestObject('Object Repository/Page_Swag Labs/div_Total 53.99'), 'Total: $53.99')

// Get the text values of inventory_item_price, summary_tax_label, and summary_total_label
def inventoryItemPrice = WebUI.getText(findTestObject('Object Repository/Page_Swag Labs/div_49.99'))

def summaryTaxLabel = WebUI.getText(findTestObject('Object Repository/Page_Swag Labs/div_Tax 4.00'))

def summaryTotalLabel = WebUI.getText(findTestObject('Object Repository/Page_Swag Labs/div_Total 53.99'))

// Convert the text values to numbers by extracting the numeric parts
def itemPriceValue = Double.parseDouble(inventoryItemPrice.replaceAll('[^0-9.]', ''))

def taxValue = Double.parseDouble(summaryTaxLabel.replaceAll('[^0-9.]', ''))

def expectedTotal = itemPriceValue + taxValue

// Convert summaryTotalLabel to a number for comparison
def actualTotal = Double.parseDouble(summaryTotalLabel.replaceAll('[^0-9.]', ''))

// Assert that the calculated total matches the displayed total
if (expectedTotal != actualTotal) {
    KeywordUtil.markFailedAndStop("The calculated total $expectedTotal does not match the displayed total $actualTotal.")
}

WebUI.click(findTestObject('Object Repository/Page_Swag Labs/button_Finish'))

WebUI.verifyElementText(findTestObject('Object Repository/Page_Swag Labs/h2_Thank you for your order'), 'Thank you for your order!')

WebUI.click(findTestObject('Object Repository/Page_Swag Labs/button_Back Home'))

WebUI.closeBrowser()

