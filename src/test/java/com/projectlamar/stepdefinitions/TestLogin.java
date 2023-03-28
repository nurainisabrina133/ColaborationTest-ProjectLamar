package com.projectlamar.stepdefinitions;

import com.projectlamar.hooks.Hooks;
import com.projectlamar.pages.LoginPage;
import com.relevantcodes.extentreports.ExtentTest;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class TestLogin {
    public static WebDriver driver;
    public static ExtentTest extentTest;
    public static LoginPage loginPage = new LoginPage();

    public TestLogin(){
        driver = Hooks.driver;
        extentTest =Hooks.extentTest;
    }
    @Given("Input url web lamar yang benar {string}")
    public void input_url_web_lamar_yang_benar(String url) {
        driver.get(url);
    }

    @Then("Menampilkan halaman login {string}")
    public void menampilkan_halaman_login(String expect) {
        Assert.assertTrue(loginPage.getTitlePage().contains(expect));
    }

    @When("Input username yang terdaftar {string}")
    public void input_username_yang_terdaftar(String username) {
        loginPage.setTxtUsername(username);
    }

    @When("Input password yang terdaftar {string}")
    public void input_password_yang_terdaftar(String password) {
        loginPage.setTxtPassword(password);
    }

    @When("Klik tombol Sign In")
    public void klik_tombol_sign_in() {
        loginPage.clickBtnSignIn();
    }

    @Then("Berhasil login dan menampilkan halaman dashboard {string}")
    public void berhasil_login_dan_menampilkan_halaman_dashboard(String txtDashboardPage) {
        Assert.assertTrue(loginPage.getTextDashboardPage().contains(txtDashboardPage));
    }
}
