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

Response = WS.sendRequest(findTestObject('CountryinfoService/ListCountries'))

// Parse XML file
String xml1 = Response.responseBodyContent

def dataValue = new XmlSlurper().parseText(xml1)

assert dataValue.name() == 'ListOfCountryNamesByNameResponse'

// get value that want to check and add to variable 

String valueResponse = dataValue.ListOfCountryNamesByNameResponse.ListOfCountryNamesByNameResult.tCountryCodeAndName[0].sISOCode

assert valueResponse == 'AX'

// THE EXTRACTED COUNTRY

println(" THE EXTRACTED COUNTRY: "+ valueResponse)

// put value in globalvariable 
GlobalVariable.countryCode = dataValue.ListOfCountryNamesByNameResponse.ListOfCountryNamesByNameResult.tCountryCodeAndName[0].sISOCode

// print Gvalue 
println('Global Variable : '+ GlobalVariable.countryCode)

WS.sendRequestAndVerify(findTestObject('CountryinfoService/GetCapitalCity'))

