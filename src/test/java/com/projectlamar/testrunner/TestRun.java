
package com.projectlamar.testrunner;


import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions(
        features = "src/main/resources/features/07-RecruitmentRequest_DataPengajuan.feature",
        glue = {"com.projectlamar"},
        dryRun = false,
        plugin = {"pretty","html:target/cucumber-report.html","json:target/cucumber-report.json"}
)   

public class TestRun extends AbstractTestNGCucumberTests {

}
