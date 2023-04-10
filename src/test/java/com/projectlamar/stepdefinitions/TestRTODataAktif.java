package com.projectlamar.stepdefinitions;

import com.projectlamar.hooks.Hooks;
import com.projectlamar.pages.LoginPage;
import com.projectlamar.pages.RTODataAktifPage;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class TestRTODataAktif {
    public static WebDriver driver;
    public static ExtentTest extentTest;
    public static RTODataAktifPage rtoDataAktif = new RTODataAktifPage();

    public static LoginPage loginPage = new LoginPage();

    public TestRTODataAktif() {
        driver = Hooks.driver;
        extentTest = Hooks.extentTest;
    }

    @When("Klik Data Aktif")
    public void klik_data_aktif() {
        rtoDataAktif.clickbtnDataAktif();
        Hooks.delay(1);
        extentTest.log(LogStatus.PASS, "Klik Data Aktif");
        Hooks.delay(2);
    }

    @Then("Menampilkan Index RRF Aktif")
    public void menampilkan_index_rrf_aktif() {
        Assert.assertEquals(rtoDataAktif.gettextIndexRRFAktif(), "Index RRF Aktif");
        extentTest.log(LogStatus.PASS, "Menampilan Index RRF Aktif");
        Hooks.delay(2);
    }

    @When("Klik View Data")
    public void klik_view_data() {
        rtoDataAktif.clickbtnDataAktif();
        rtoDataAktif.clickbtnview();
        Hooks.delay(1);
        extentTest.log(LogStatus.PASS, "Klik View Data");
        Hooks.delay(2);
    }

    @Then("Menampilkan Halaman Data Aktif")
    public void menampilkan_halaman_data_aktif() {
        Assert.assertEquals(rtoDataAktif.gettextJumlahKebutuhan(), "Jumlah Kebutuhan");
        extentTest.log(LogStatus.PASS, "Menampilkan Halaman Data Aktif");
        rtoDataAktif.clickbtnBack();
        Hooks.delay(2);
    }

    @When("Klik dropdown value Data Aktif")
    public void klik_dropdown_value_data_aktif() {
        rtoDataAktif.clickDropdownValueDataAktif();
        extentTest.log(LogStatus.PASS, "Klik dropdown value Data Aktif");
        Hooks.delay(2);
    }

    @When("Pilih value entries {string} Data Aktif")
    public void pilih_value_entries_data_aktif(String value) {
        rtoDataAktif.setvalueentries("10");
        Hooks.delay(1);
        extentTest.log(LogStatus.PASS, "Pilih value entries Data Aktif");
        Hooks.delay(2);

    }

    @Then("Menampilkan data aktif dengan jumlah record berdasarkan value Data Aktif")
    public void menampilkan_data_aktif_dengan_jumlah_record_berdasarkan_value_data_aktif() {
        Assert.assertEquals(rtoDataAktif.countRows(10), true);
        extentTest.log(LogStatus.PASS, "Menampilkan data aktif dengan jumlah record berdasarkan value Data Aktif");
        Hooks.delay(2);

    }

    @When("Input valid keyword {string} from Data Aktif")
    public void input_valid_keyword_from_data_aktif(String keyword) {
        Hooks.delay(2);
        rtoDataAktif.setTextSearch(keyword);
        extentTest.log(LogStatus.PASS, "Input Valid keyword");
        Hooks.delay(2);
    }

    @When("Input invalid keyword {string} from data aktif")
    public void input_invalid_keyword_from_data_aktif(String keyword) {
        Hooks.delay(1);
        rtoDataAktif.setTextSearch(keyword);
        extentTest.log(LogStatus.PASS, "Input invalid keyword");
        Hooks.delay(2);
    }

    @When("Klik tombol search from Data Aktif")
    public void klik_tombol_search_from_data_aktif() {
        rtoDataAktif.clickbtnSearch();
        Hooks.delay(1);
        extentTest.log(LogStatus.PASS, "Klik tombol search from Data Aktif");
        Hooks.delay(2);
    }

    @Then("Menampilkan data sesuai dengan keyword yang diinput form Data Aktif")
    public void menampilkan_data_sesuai_dengan_keyword_yang_diinput_form_data_aktif() {
        Assert.assertEquals(rtoDataAktif.countRowsSearchby(), true);
        extentTest.log(LogStatus.PASS, "Menampilkan data sesuai dengan keyword yang diinput diinput form Data Aktif");
        Hooks.delay(2);
    }

    @Then("Menampilkan No data available in table pada tabel data from Data Aktif")
    public void menampilkan_no_data_available_in_table_pada_tabel_data_from_data_aktif() {
        Assert.assertTrue(rtoDataAktif.gettextnoDAtaAvailable().contains("No data available in table"));
        Hooks.delay(1);
        extentTest.log(LogStatus.PASS, "Menampilkan No data available in table pada tabel data");
        Hooks.delay(2);
    }

    @When("Klik tombol Refresh From Data Aktif")
    public void klik_tombol_refresh_from_data_aktif() {
        rtoDataAktif.clickbtnRefresh();
        extentTest.log(LogStatus.PASS, "Klik tombol Refresh From Data Aktif");
        Hooks.delay(2);
    }

    @Then("Kembali ke Halaman Index RRF Aktif")
    public void kembali_ke_halaman_index_rrf_aktif() {
        Assert.assertTrue(rtoDataAktif.gettextIndexRRFAktif().contains("Index RRF Aktif"));
        extentTest.log(LogStatus.PASS, "Kembali ke Halaman Index RRF Aktif");
        Hooks.delay(2);
    }

    @When("Klik tombol Download Data")
    public void klik_tombol_download_data() {
        rtoDataAktif.clickbtnDwonload();
        extentTest.log(LogStatus.PASS, "Klik tombol Donload Data");
        Hooks.delay(2);
    }

    @Then("Download Berhasil")
    public void download_berhasil() {
        System.out.println("Download Berhasil");
        extentTest.log(LogStatus.PASS, "Download Berhasil");
        Hooks.delay(2);
    }

    @When("Klik Icon User")
    public void klik_icon_user() {
        rtoDataAktif.clickbtnIconUser();
        extentTest.log(LogStatus.PASS, "Klik Icon User");
        Hooks.delay(2);
    }

    @When("Klik tombol Logout")
    public void klik_tombol_logout() {
        rtoDataAktif.clickbtnLogout();
        extentTest.log(LogStatus.PASS, "Klik Tombol Logout");
        Hooks.delay(2);
    }

    @Then("Menampilkan Halaman Login")
    public void menampilkan_halaman_login() {
        System.out.println("Menampilkan Halaman Login");
        Assert.assertTrue(rtoDataAktif.gettextUserLogin().contains("User Login"));
        extentTest.log(LogStatus.PASS, "Menampilkan Halaman Login");

    }
}
