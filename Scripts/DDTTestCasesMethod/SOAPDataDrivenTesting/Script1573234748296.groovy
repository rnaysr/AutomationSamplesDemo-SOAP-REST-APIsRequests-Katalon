import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable

println('.........country code is : ' + countrycode)

println('.........capital is : ' + capital)

println('.........curruncy is : ' + curruncy)

Response1=WS.sendRequest(findTestObject('APIChaining.XML/GetCapitalCity', [('countryISOCode') : countrycode]))



WS.verifyElementText(Response1, 'CapitalCityResponse.CapitalCityResult', capital)


Response2=WS.sendRequest(findTestObject('APIChaining.XML/GetCurrencySoapRequest', [('countryISOcode') : countrycode
	, ('Auth') : 'Basic cmFuYTpyYW5h']))


WS.verifyElementText(Response2, 'CountryCurrencyResponse.CountryCurrencyResult.sName', curruncy)

