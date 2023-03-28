package com.projectlamar.utils;

public enum TestScenarios {
    T1("Check access login page with invalid url"),
    T2("Check access login page with invalid url"),
    T3("Check Login is Failed with invalid username"),
    T4("Check Login is success with valid credentials");

    private String testCaseName;
    TestScenarios(String value) {
        testCaseName = value;
    }

    public String getTestCaseName(){
        return testCaseName;
    }
}
