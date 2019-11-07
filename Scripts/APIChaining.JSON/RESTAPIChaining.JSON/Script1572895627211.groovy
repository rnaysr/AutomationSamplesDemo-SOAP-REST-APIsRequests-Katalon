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

' call listofuser api in a variable =response '
Response = WS.sendRequest(findTestObject('UserRestService-Extracting data from JSON responses and chaining requests/ListUsers'))

' parsing json file '
def slurper = new groovy.json.JsonSlurper()

def result = slurper.parseText(Response.getResponseBodyContent())

' get index of location of the user and put it in value '
def value = result.data[0].first_name

' print value '
println('value is ' + value)

' add value in global variable '
GlobalVariable.username = value

' print global variable '
println('global variable is :' + GlobalVariable.username)

' call other api that has a global variable '

//WS.sendRequestAndVerify(findTestObject('UserRestService-Extracting data from JSON responses and chaining requests/UpdateUser'))

' Passing Values from Response to Request  '

WS.sendRequest(findTestObject('UserRestService-Extracting data from JSON responses and chaining requests/UpdateUser', [('username') : result.data[0].first_name]))



