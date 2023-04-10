package com.projectlamar.stepdefinitions;

import com.projectlamar.hooks.Hooks;
import com.projectlamar.pages.LoginPage;
import com.projectlamar.pages.RTODataPengajuanPage;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class TestRTODataPengajuan {
    public static WebDriver driver;
    public static ExtentTest extentTest;
    public static RTODataPengajuanPage rtoDataPengajuanPage = new RTODataPengajuanPage();

    public static LoginPage loginPage = new LoginPage();

    public TestRTODataPengajuan() {
        driver = Hooks.driver;
        extentTest = Hooks.extentTest;
    }

    @When("Klik Approve RRF")
    public void klik_approve_rrf() {
        loginPage.loginUser("m", "m1");
        rtoDataPengajuanPage.clickBtnApproveRRF();
        extentTest.log(LogStatus.PASS, "Klik Approve RRF");
        Hooks.delay(2);

    }

    @When("Klik View Data Pengajuan")
    public void klik_view_data_pengajuan() {
        Hooks.delay(2);
        rtoDataPengajuanPage.clickBtnView();
        Hooks.delay(2);
        extentTest.log(LogStatus.PASS, "Klik View Data");
    }

    @Then("Menampilkan Halaman Data Aktif Pengajuan")
    public void menampilkan_halaman_data_aktif_pengajuan() {
        System.out.println(rtoDataPengajuanPage.gettextDetailApproveRRF());
        Assert.assertEquals(rtoDataPengajuanPage.gettextDetailApproveRRF(), "Jumlah Kebutuhan");
        rtoDataPengajuanPage.clickBtnBack();
        extentTest.log(LogStatus.PASS, "Menampilkan Halaman Data Aktif");
        Hooks.delay(2);
    }

    @When("Input valid keyword {string}")
    public void input_valid_keyword(String keyword) {
        Hooks.delay(2);
        rtoDataPengajuanPage.setTextSearch(keyword);
        extentTest.log(LogStatus.PASS, "Input Valid keyword");
    }

    @And("Klik tombol search")
    public void klik_tombol_search() {
        rtoDataPengajuanPage.btnSearch();
        extentTest.log(LogStatus.PASS, "Klik tombol search");
        Hooks.delay(2);
    }

    @Then("Menampilkan data sesuai dengan keyword yang diinput")
    public void menampilkan_data_sesuai_dengan_keyword_diinput() {
        //System.out.println(rtoDataPengajuanPage.gettextSearchbyname());
        Assert.assertEquals(rtoDataPengajuanPage.countRowsSearchby(), true);
        extentTest.log(LogStatus.PASS, "Menampilkan data sesuai dengan keyword yang diinput");
        Hooks.delay(2);
    }

    @When("Input invalid keyword {string}")
    public void input_invalid_keyword(String keyword) {
        rtoDataPengajuanPage.setTextSearch(keyword);
        extentTest.log(LogStatus.PASS, "Input invalid keyword");
        Hooks.delay(2);
    }

    @Then("Menampilkan No data available in table pada tabel data")
    public void menampilkan_no_data_available_in_table_pada_tabel_data_pengajuan() {
        Assert.assertTrue(rtoDataPengajuanPage.getnoDataavailable().contains("No data available in table"));
        extentTest.log(LogStatus.PASS, "Menampilkan No data available in table pada tabel data");
        Hooks.delay(2);
    }

//    @When("Input keyword Kredivo")
//    public void input_keyword_kredivo() {
//        Hooks.delay(1);
//        rtoDataPengajuanPage.setTextSearch("Kredivo");
//        extentTest.log(LogStatus.PASS, "Input keyword Kredivo");
//    }

    @Then("Menampilkan data dengan nama project")
    public void mnampilkan_data_dengan_nama_project() {
        Assert.assertEquals(rtoDataPengajuanPage.countRowsSearchby(), true);
        extentTest.log(LogStatus.PASS, "Menampilkan data dengan nama project");
        Hooks.delay(2);
    }

    @When("Klik tombol Approve")
    public void klik_tombol_Approve() {
        rtoDataPengajuanPage.btnApprove();
        extentTest.log(LogStatus.PASS, "Klik tombol Approve");
        Hooks.delay(2);
    }

    @And("Klik tombol IT")
    public void klik_tombol_IT() {
        rtoDataPengajuanPage.btnIT();
        extentTest.log(LogStatus.PASS, "Klik tombol IT");
        Hooks.delay(2);
    }

    @And("Klik tombol NON IT")
    public void klik_tombol_non_IT() {
        rtoDataPengajuanPage.btnNonIT();
        extentTest.log(LogStatus.PASS, "Klik tombol NON IT");
        Hooks.delay(2);
    }

    @When("Klik dropdown value")
    public void klik_dropdown_value() {
        rtoDataPengajuanPage.klikDropdownentries();
        extentTest.log(LogStatus.PASS, "Klik dropdown value");
        Hooks.delay(2);
    }

    @And("Klik tombol back")
    public void klik_tombol_back() {
        rtoDataPengajuanPage.clickBtnBack();
        extentTest.log(LogStatus.PASS, "Klik tombol back");
        Hooks.delay(2);
    }

    @Then("Kembali ke halaman Approve RRF")
    public void kembali_ke_halaman_approve_rrf() {
        Assert.assertEquals(rtoDataPengajuanPage.gettextheaderApproverrf(), "Approve RRF");
        extentTest.log(LogStatus.PASS, "Kembali ke halaman Approve RRF");
        Hooks.delay(2);
    }

    @Then("Menampilkan Halaman Approve RRF")
    public void menampilkan_halaman_approve_rrf() {
        Hooks.delay(2);
        Assert.assertTrue(rtoDataPengajuanPage.gettextheaderApproverrf().contains("Approve RRF"));
        extentTest.log(LogStatus.PASS, "Menampilkan Halaman Approve RRF");
    }

    @And("Klik ok pada notifikasi approve recruitment request")
    public void klik_ok_pada_notifikasi_approve_recruitment_request() {
        Hooks.delay(2);
        driver.switchTo().alert().accept();
        extentTest.log(LogStatus.PASS, "Klik ok pada notifikasi approve recruitment request");
        Hooks.delay(2);
    }

    @And("Klik cancel pada notifikasi approve recruitment request")
    public void klik_cancel_pada_notifikasi_approve_recruitment_request() {
        driver.switchTo().alert().dismiss();
        extentTest.log(LogStatus.PASS, "Klik cancel pada notifikasi approve recruitment request");
        Hooks.delay(2);
    }

    @Then("Status berhasil diupdate")
    public void status_berhasil_diupdate() {
        Assert.assertTrue(rtoDataPengajuanPage.gettextBerhasil().contains("Berhasil!"));
        extentTest.log(LogStatus.PASS, "Status berhasil diupdate");
        Hooks.delay(2);
    }

    @When("Klik tombol Refresh")
    public void klik_tombol_refresh() {
        rtoDataPengajuanPage.btnRefresh();
        extentTest.log(LogStatus.PASS, "Klik tombol Refresh");
        Hooks.delay(2);
    }

    @And("Text keyword tereset")
    public void text_keyword_tereset() {
        System.out.println(rtoDataPengajuanPage.gettextheaderApproverrf());
        Assert.assertEquals(rtoDataPengajuanPage.gettextheaderApproverrf(), "Approve RRF");
        extentTest.log(LogStatus.PASS, "Text keyword tereset");
        Hooks.delay(2);
    }

    @And("Pilih value entries {string}")
    public void pilih_value_entries(String value) {
        rtoDataPengajuanPage.setvalueentries(value);
        extentTest.log(LogStatus.PASS, "Pilih value entries");
        Hooks.delay(2);
    }

    @Then("Menampilkan data aktif dengan jumlah record berdasarkan value")
    public void menampilkan_data_aktif_dengan_jumlah_record_berdasarkan_value() {
        Assert.assertEquals(rtoDataPengajuanPage.countRows(10), true);
        extentTest.log(LogStatus.PASS, "Menampilkan data aktif dengan jumlah record berdasarkan value");
        Hooks.delay(2);
    }

    @When("Klik tombol Return")
    public void klik_tombol_return() {
        rtoDataPengajuanPage.clickbtnReturn();
        extentTest.log(LogStatus.PASS, "Klik tombol Return");
        Hooks.delay(2);
    }

    @And("Input Keyword Note")
    public void input_keyword_note() {
        rtoDataPengajuanPage.setTextNote("Jakarta");
        extentTest.log(LogStatus.PASS, "Input Keyword Note");
        Hooks.delay(2);
    }

    @Then("Klik tombol Update")
    public void klik_tombol_update() {
        rtoDataPengajuanPage.clickbtnUpdate();
        extentTest.log(LogStatus.PASS, "Klik tombol Update");
        Hooks.delay(2);
    }

    @And("Klik tombol Batal")
    public void klik_tombol_batal(){
        rtoDataPengajuanPage.clickbtnBatalUpdate();
        extentTest.log(LogStatus.PASS, "Klik tombol Batal");
        Hooks.delay(2);
    }

}
