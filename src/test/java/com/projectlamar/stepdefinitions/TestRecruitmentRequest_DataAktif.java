package com.projectlamar.stepdefinitions;

import com.projectlamar.hooks.Hooks;
import com.projectlamar.pages.LoginPage;
import com.projectlamar.pages.RecruitmentPage_DataAktif;
import com.projectlamar.utils.Constants;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;

import java.io.File;
import java.util.HashMap;

public class TestRecruitmentRequest_DataAktif {
    public static WebDriver driver;
    public static ExtentTest extentTest;
    public static RecruitmentPage_DataAktif dataAktif = new RecruitmentPage_DataAktif();
    public static LoginPage loginPage = new LoginPage();


    public TestRecruitmentRequest_DataAktif() {
        driver = Hooks.driver;
        extentTest = Hooks.extentTest;
    }

    @When("Klik menu Reqruitment Request")
    public void klik_menu_reqruitment_request() {
        dataAktif.clickMenuRecruitment();
        extentTest.log(LogStatus.PASS, "Klik menu Reqruitment Request");
    }

    @When("Klik menu data aktif")
    public void klik_menu_data_aktif() {
        dataAktif.clickMenuDataAktif();
        extentTest.log(LogStatus.PASS, "Klik menu data aktif");
        Hooks.delay(1);
    }

    @Then("Menampilkan halaman data aktif {string}")
    public void menampilkan_halaman_data_aktif(String txtHeader) {
        Assert.assertTrue(dataAktif.getTxtHeaderDataAktif().contains(txtHeader));
        extentTest.log(LogStatus.PASS, "Menampilkan halaman data aktif");
        Hooks.delay(2);
    }

    @When("Pilih value status {string}")
    public void pilih_value_status(String status) {
        if (status.equals("open")) {
            dataAktif.clickDropdownStatus();
            dataAktif.setDrpStatus("OPEN");
            extentTest.log(LogStatus.PASS, "Pilih value status open");
        } else if (status.equals("closed")) {
            dataAktif.clickDropdownStatus();
            dataAktif.setDrpStatus("CLOSED");
            extentTest.log(LogStatus.PASS, "Pilih value status closed");
        } else if (status.equals("cancel")) {
            dataAktif.clickDropdownStatus();
            dataAktif.setDrpStatus("CANCEL");
            extentTest.log(LogStatus.PASS, "Pilih value status cancel");
        } else if (status.equals("hold")) {
            dataAktif.clickDropdownStatus();
            dataAktif.setDrpStatus("HOLD");
            extentTest.log(LogStatus.PASS, "Pilih value status hold");
        }
    }

    @When("Klik tombol filter")
    public void klik_tombol_filter() {
        dataAktif.clickBtnFilter();
        extentTest.log(LogStatus.PASS, "Klik tombol filter");
        Hooks.delay(1);
    }

    @Then("Menampilkan data aktif berdasarkan status")
    public void menampilkan_data_aktif_dengan_status_pending() {
        Assert.assertEquals(dataAktif.countRows(), true);
        extentTest.log(LogStatus.PASS, "Menampilkan data aktif berdasarkan status");
        Hooks.delay(1);
    }

    @When("Klik tombol + pada kolom No")
    public void klik_tombol_plus() {
        dataAktif.clickBtnPlus();
        extentTest.log(LogStatus.PASS, "Klik tombol +");
        Hooks.delay(1);
    }

    @Then("Check data sesuai dengan status {string}")
    public void check_data_sesuai_dengan_status(String status) {
        if (status.equals("OPEN")) {
            Assert.assertTrue(dataAktif.getTxtStatusOpen().contains(status));
            extentTest.log(LogStatus.PASS, "Check data dengan status open");
        } else if (status.equals("CLOSED")) {
            Assert.assertTrue(dataAktif.getTxtStatusClosed().contains(status));
            extentTest.log(LogStatus.PASS, "Check data dengan status closed");
        } else if (status.equals("CANCEL")) {
            Assert.assertTrue(dataAktif.getTxtStatusCancel().contains(status));
            extentTest.log(LogStatus.PASS, "Check data dengan status cancel");
        } else if (status.equals("HOLD")) {
            Assert.assertTrue(dataAktif.getTxtStatusHold().contains(status));
            extentTest.log(LogStatus.PASS, "Check data dengan status hold");
        }
    }

    @When("Pilih value status")
    public void pilih_value_status() {
        dataAktif.setDrpStatus("CANCEL");
        extentTest.log(LogStatus.PASS, "Pilih value status");
    }

    @When("Klik tombol reset")
    public void klik_tombol_reset() {
        dataAktif.clickBtnReset();
        extentTest.log(LogStatus.PASS, "Klik tombol reset");
    }

    @Then("Value pada kolom filter status ter-reset")
    public void value_pada_kolom_filter_status_ter_reset() {
        Assert.assertEquals(dataAktif.getTxtStatusEmpty(""), "");
        extentTest.log(LogStatus.PASS, "Value pada kolom filter status ter-reset");
        Hooks.delay(1);
    }

    @When("Klik dropdown value entries")
    public void klik_dropdown_value_entries() {
        dataAktif.clickBtnRefresh();
        Hooks.delay(1);
        dataAktif.clikDropdownEntries();
        extentTest.log(LogStatus.PASS, "Klik dropdown value entries");
    }

    @When("Pilih value entrie")
    public void pilih_value_entrie() {
        dataAktif.setDrpEntries("25");
        extentTest.log(LogStatus.PASS, "Pilih value entries");
    }

    @Then("Menampilkan data aktif dengan jumlah record berdasarkan value")
    public void menampilkan_data_aktif_dengan_jumlah_record_berdasarkan_value() {
        Assert.assertEquals(dataAktif.countRowsEntries(25), true);
        extentTest.log(LogStatus.PASS, "Menampilkan data aktif dengan jumlah record berdasarkan value");
        Hooks.delay(1);
    }

    @When("Input keyword search {string}")
    public void input_valid_keyword(String keyword) {
        dataAktif.setTxtSearch(keyword);
        extentTest.log(LogStatus.PASS, "Input valid keyword");
    }

    @When("Klik tombol search")
    public void klik_tombol_search() {
        dataAktif.clickBtnSearch();
        extentTest.log(LogStatus.PASS, "Klik tombol search");
        Hooks.delay(1);
    }

    @Then("Menampilkan data aktif sesuai dengan keyword search {string}")
    public void menampilkan_data_aktif_sesuai_dengan_keyword_search(String txtResult) {
        Assert.assertEquals(dataAktif.searchDataAktif(txtResult), true);
        extentTest.log(LogStatus.PASS, "Menampilkan data aktif sesuai dengan keyword search");
        Hooks.delay(1);
    }

    @Then("Menampilkan data aktif dengan invalid keyword {string}")
    public void menampilkan_data_aktif_dengan_invalid_keyword(String txtResult) {
        Assert.assertEquals(dataAktif.getTextDataTableEmpty(txtResult), txtResult);
        extentTest.log(LogStatus.PASS, "Menampilkan data aktif dengan invalid keyword");
        Hooks.delay(1);
    }

    @When("Klik tombol View Data")
    public void klik_tombol_view_data() {
        dataAktif.clickBtnViewData();
        extentTest.log(LogStatus.PASS, "Klik tombol view data");
        Hooks.delay(1);
    }

    @Then("Menampilkan view detail data recruitment request aktif")
    public void menampilkan_view_detail_data_recruitment_request_aktif() {
        Assert.assertTrue(dataAktif.getTxtViewDataAktif().contains("Jumlah Kebutuhan"));
        extentTest.log(LogStatus.PASS, "Menampilkan view detail data recruitment request aktif");
        Hooks.delay(1);
    }

    @When("Klik tombol update status")
    public void klik_tombol_update_status() {
        dataAktif.clickBtnUpdateStatus();
        extentTest.log(LogStatus.PASS, "Klik tombol update status");
    }

    @When("Pilih status pada tampilan modal update status {string}")
    public void pilih_status_pada_tampilan_modal_update_status(String status) {
        dataAktif.clickDrpdownUpdateStatus();
        Hooks.delay(1);
        dataAktif.setDrpUpdateStatus(status);
        extentTest.log(LogStatus.PASS, "Pilih status pada tampilan modal update status");
    }

    @When("Input notes {string}")
    public void input_notes(String notes) {
        dataAktif.setTxtNotes(notes);
        extentTest.log(LogStatus.PASS, "Input notes");
    }

    @When("Klik tombol update")
    public void klik_tombol_update() {
        dataAktif.clickBtnUpdate();
        extentTest.log(LogStatus.PASS, "Klik tombol update");
        Hooks.delay(1);
    }

    @When("Klik tombol Ok pada pesan alert")
    public void klik_tombol_ok_pada_pesan_alert() {
        driver.switchTo().alert().accept();
        extentTest.log(LogStatus.PASS, "Klik tombol Ok pada pesan alert");
    }

    @Then("Menampilkan pesan alert success {string}")
    public void menampilkan_pesan_alert_success(String txtAlert) {
        if (txtAlert.contains("Success")) {
            Assert.assertTrue(dataAktif.getTxtSuccesUptStatus().contains(txtAlert));
            extentTest.log(LogStatus.PASS, "Menampilkan pesan alert success");
            dataAktif.clickBtnPlus();
            Hooks.delay(1);
        } else if (txtAlert.contains("true")) {
            Assert.assertTrue(dataAktif.getRequired().contains(txtAlert));
            extentTest.log(LogStatus.PASS, "Proses Update status gagal");
            Hooks.delay(1);
        }
    }

    @When("Klik tombol cancel")
    public void klik_tombol_cancel(){
        dataAktif.clickBtnBatal();
        extentTest.log(LogStatus.PASS, "Klik tombol cancel");
    }

    @When("Klik tombol back data aktif")
    public void klik_tombol_back_data_aktif(){
        dataAktif.clickBtnBack();
        extentTest.log(LogStatus.PASS, "Klik tombol back ke data aktif");
        Hooks.delay(1);
    }

    @When("Klik tombol Download Data")
    public void klik_tombol_download_data() {
        Hooks.delay(1);
        dataAktif.clickBtnDownload();
        extentTest.log(LogStatus.PASS, "Klik tombol download");
        Hooks.delay(2);
    }

    @Then("Data aktif terdownload")
    public void data_aktif_terdownload(){
        File fileLocation = new File("C:\\Users\\User\\Downloads");
        File[] totalFiles = fileLocation.listFiles();
        for (File file:totalFiles) {
            if (file.getName().contains("doc.pdf")) {
                System.out.println("File is downloaded");
                break;
            }
        }
        System.out.println("Download berhasil");
        Hooks.delay(3);
    }
}
