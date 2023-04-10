package com.projectlamar.stepdefinitions;

import com.projectlamar.hooks.Hooks;
import com.projectlamar.pages.DashboardPage;
import com.projectlamar.pages.LoginPage;
import com.projectlamar.utils.Constants;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class TestDashboard {
    public static WebDriver driver;
    public static ExtentTest extentTest;
    public static DashboardPage dashboardPage = new DashboardPage();
    public static LoginPage loginPage = new LoginPage();

    public TestDashboard() {
        driver = Hooks.driver;
        extentTest = Hooks.extentTest;
    }

    @When("Klik tombol view detail 7 hari")
    public void klik_tombol_view_detail_7_hari() {
        driver.switchTo().alert().accept();
        Hooks.delay(1);
        dashboardPage.clickBtnViewData7Hari();
        extentTest.log(LogStatus.PASS, "Klik tombol view detail 7 hari");
    }

    @When("Klik tombol view detail 10 hari")
    public void klik_tombol_view_detail_10_hari() {
        Hooks.delay(1);
        dashboardPage.clickBtnViewData10Hari();
        extentTest.log(LogStatus.PASS, "Klik tombol view detail 10 hari");
    }

    @When("Klik tombol view detail 14 hari")
    public void klik_tombol_view_detail_14_hari() {
        Hooks.delay(1);
        dashboardPage.clickBtnViewData14Hari();
        extentTest.log(LogStatus.PASS, "Klik tombol view detail 14 hari");
    }

    @Then("Menampilkan halaman form detail data offering {string}")
    public void menampilkan_halaman_form_detail_data_offering(String txtFormDetail) {
        Hooks.delay(1);
        Assert.assertEquals(dashboardPage.getTxtDetailDataOffering(), txtFormDetail);
        extentTest.log(LogStatus.PASS, "Menampilkan halaman form detail data offering");
    }

    @When("Input keyword by name {string}")
    public void input_keyword_by_name(String nama) {
        dashboardPage.setTxtSearch(nama);
        extentTest.log(LogStatus.PASS, "Input keyword by name");
    }

    @When("Click tombol search")
    public void click_tombol_search() {
        dashboardPage.clickBtnSearch();
        extentTest.log(LogStatus.PASS, "Click tombol search");
        Hooks.delay(1);
    }

    @Then("Menampilkan data offering")
    public void menampilkan_data_offering() {
        boolean status = dashboardPage.searchOfferingByName("SITTI");
        Assert.assertEquals(status, true);
        extentTest.log(LogStatus.PASS, "Menampilkan data offering");
    }

    @Then("Menampilkan pesan data offering kosong")
    public void menampilkan_pesan_data_offering_kosong() {
        Assert.assertTrue(dashboardPage.getTextDataTableEmpty().contains("No data available in table"));
        extentTest.log(LogStatus.PASS, "Menampilkan data offering kosong");
    }

    @When("Klik dropdown value")
    public void klik_dropdown_value() {
        dashboardPage.clickDropdownEntries();
        extentTest.log(LogStatus.PASS, "Klik dropdown value");
    }
    @When("Klik tombol back client")
    public void klik_button_back_client(){
        dashboardPage.clickBtnBackClient();
        driver.switchTo().alert().accept();
        extentTest.log(LogStatus.PASS, "Klik tombol back");
        Hooks.delay(1);
    }

    @When("Select value entire {string}")
    public void select_value_entire(String valueDrp) {
        dashboardPage.selectValueDropdownOffering("10");
        extentTest.log(LogStatus.PASS, "Select value entrie {10}");
        Hooks.delay(1);
    }

    @Then("Menampilkan data offering dengan jumlah record berdasarkan value")
    public void menampilkan_data_offering_dengan_jumlah_record_berdasarkan_value() {
        Assert.assertEquals(dashboardPage.countValue(10), true);
        extentTest.log(LogStatus.PASS, "Cek jumlah record pada table");
    }

    @When("Klik tombol back")
    public void klik_tombol_back() {
        dashboardPage.clickBtnBack();
        driver.switchTo().alert().accept();
        extentTest.log(LogStatus.PASS, "Klik tombol back");
        Hooks.delay(2);
    }

    @When("Klik dropdown value clients")
    public void klik_dropdown_value_clients(){
        dashboardPage.clickDropdownEntriesClient();
        extentTest.log(LogStatus.PASS, "Klik dropdown value clients");
    }

    @Then("Kembali ke menu dashboard {string}")
    public void kembali_ke_menu_dashboard(String txtDashboard) {
        Assert.assertTrue(loginPage.getTextDashboardPage().contains(txtDashboard));
        extentTest.log(LogStatus.PASS, "Kembali ke menu Dashboard");
    }

    @When("Klik tombol jumlah client")
    public void klik_tombol_jumlah_client() {
        dashboardPage.clickBtnJumlahClient();
        extentTest.log(LogStatus.PASS, "Klik tombol jumlah client");
        Hooks.delay(1);
    }

    @When("Select value client entire {string}")
    public void select_value_client_entrie(String value){
        dashboardPage.selectValueDropdownClient("10");
        extentTest.log(LogStatus.PASS, "Select value entrie {10}");
        Hooks.delay(1);
    }

    @Then("Menampilkan halaman form detail client {string}")
    public void menampilkan_halaman_form_detail_client(String txtJumlahClientPage) {
        Assert.assertTrue(dashboardPage.getTxtJumlahClient().contains(txtJumlahClientPage));
        extentTest.log(LogStatus.PASS, "Menampilkan halaman form detail client");
    }

    @When("Input keyword by client name {string}")
    public void input_keyword_by_client_name(String clientName) {
        dashboardPage.setTxtSearch(clientName);
        extentTest.log(LogStatus.PASS, "Input keyword by client name");
    }

    @Then("Menampilkan data client")
    public void menampilkan_data_client() {
        dashboardPage.searchClientByName("HCI");
        boolean status = dashboardPage.searchClientByName("HCI");
        Assert.assertEquals(status, true);
        extentTest.log(LogStatus.PASS, "Menampilkan data client");
    }

    @Then("Menampilkan pesan data client kosong")
    public void menampilkan_pesan_data_client_kosong() {
        Assert.assertTrue(dashboardPage.getTextDataTableEmpty().contains("No data available in table"));
        extentTest.log(LogStatus.PASS, "Menampilkan data client kosong");
    }

    @Then("Menampilkan data client dengan jumlah record berdasarkan value")
    public void menampilkan_data_client_dengan_jumlah_record_berdasarkan_value() {
        Assert.assertEquals(dashboardPage.countValueClients(10), true);
        extentTest.log(LogStatus.PASS, "Cek jumlah record pada table");
    }

}
