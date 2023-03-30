package com.projectlamar.utils;

public enum TestScenarios {
    //Scenario Modul Login Page
    T1("Check access login page with invalid url"),
    T2("Check access login page with invalid url"),
    T3("Check Login is Failed with invalid password"),
    T4("Check Login is Falied with invalid username"),
    T5("Check Login is Falied with null password"),
    T6("Check Login is Failed with null username"),
    T7("Check Login is falied with null username and password"),
    T8("Check Login is success with valid credentials"),

    //Test Scenario Modul Dashboar - 7 hari
    T9("Test access halaman Detail data overing 7 hari"),
    T10("Test Search data by Name"),
    T11("Test Search data by Name with invalid keyword"),
    T12("Test Search data by Name with keyword kombinasi karakter"),
    T13("Test show entries"),
    T14("Test tombol back"),

    //Test Scenario Modul Dashboar - 10 hari
    T15("Test access halaman Detail data overing 10 hari"),
    T16("Test Search data by Name"),
    T17("Test Search data by Name with invalid keyword"),
    T18("Test Search data by Name with keyword kombinasi karakter"),
    T19("Test show entries"),
    T20("Test tombol back"),

    //Test Scenario Modul Dashboar - 14 hari
    T21("Test access halaman Detail data overing 14 hari"),
    T22("Test Search data by Name"),
    T23("Test Search data by Name with invalid keyword"),
    T24("Test Search data by Name with keyword kombinasi karakter"),
    T25("Test show entries"),
    T26("Test tombol back");

    private String testCaseName;
    TestScenarios(String value) {
        testCaseName = value;
    }

    public String getTestCaseName(){
        return testCaseName;
    }
}
