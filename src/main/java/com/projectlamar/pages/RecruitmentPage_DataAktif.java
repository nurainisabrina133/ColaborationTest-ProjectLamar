package com.projectlamar.pages;

import com.projectlamar.drivers.DriverSingleton;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class RecruitmentPage_DataAktif {
    private WebDriver driver;

    public RecruitmentPage_DataAktif() {
        this.driver = DriverSingleton.getDriver();
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//a[normalize-space()='Recruitment Request']")
    WebElement menuRecruitment;
    @FindBy(xpath = "//span[@class='d-sm-block d-none'][normalize-space()='Data Aktif']")
    WebElement menuDataAktif;
    @FindBy(xpath = "//select[@id='filterStatus']")
    WebElement dropdownStatus;
    @FindBy(xpath = "//button[@id='btn-filter']")
    WebElement btnFilter;
    @FindBy(xpath = "//button[@id='btn-reset']")
    WebElement btnReset;
    @FindBy(xpath = "//select[@name='table_length']")
    WebElement dropdownEntries;
    @FindBy(xpath = "//h1[@class='page-header']")
    WebElement txtHeaderDataAktif;
    @FindBy(xpath = "//select[@id='filterStatus']/option")
    List<WebElement> statusList;
    @FindBy(xpath = "//table[@id='table']//tbody/tr[1]/td[1]")
    WebElement btnPlus;
    @FindBy(xpath = "//span[@class='dtr-data']//span[@class='badge badge-primary'][normalize-space()='OPEN']")
    WebElement textStatusOpen;
    @FindBy(xpath = "//span[@class='dtr-data']//span[@class='badge badge-success'][normalize-space()='CLOSED']")
    WebElement textStatusClosed;
    @FindBy(xpath = "//span[@class='dtr-data']//span[@class='badge badge-danger'][normalize-space()='CANCEL']")
    WebElement textStatusCancel;
    @FindBy(xpath = "//span[@class='dtr-data']//span[@class='badge badge-warning'][normalize-space()='HOLD']")
    WebElement textStatusHold;
    @FindBy(xpath = "//table[@id='table']")
    WebElement tableDataAktif;
    @FindBy(xpath = "//table[@id='table']//tbody/tr")
    List<WebElement> tableRows;
    @FindBy(xpath = "//input[@type='search']")
    WebElement textSearch;
    @FindBy(xpath = "//i[@class='fa fa-search']")
    WebElement btnSearch;
    @FindBy(xpath = "//span[@id='btnRefresh']")
    WebElement btnRefresh;
    @FindBy(xpath = "//td[@class='dataTables_empty']")
    WebElement txtDataEmpty;
    @FindBy(xpath = "//span[@class='dtr-data']//a[@title='View Data']")
    WebElement btnViewDataAktif;
    @FindBy(xpath = "//h4[normalize-space()='Jumlah Kebutuhan']")
    WebElement txtViewDataAktif;
    @FindBy(xpath = "//body/div[@id='page-container']/div[@id='content']/div[@class='row']/div[@class='col-lg-11 ui-sortable ml-5']/a[1]")
    WebElement btnBack;
    @FindBy(xpath = "//*[@id=\"download\"]")
    WebElement downloadData;
    @FindBy(xpath = "//span[@class='dtr-data']//a[@title='Download Data']")
    WebElement btnDownloadData;
    @FindBy(xpath = "//span[@class='dtr-data']//a[@title='Update Status']")
    WebElement btnUpdateStatus;
    @FindBy(xpath = "//select[@id='status']")
    WebElement dropDownUptStatus;
    @FindBy(xpath = "//textarea[@id='note']")
    WebElement txtNotes;
    @FindBy(xpath = "//button[normalize-space()='Update']")
    WebElement btnUpdate;
    @FindBy(xpath = "//button[@id='batal']")
    WebElement btnBatal;
    @FindBy(xpath = "//strong[normalize-space()='Success !']")
    WebElement txtSuccesUptStatus;

    public String getTxtSuccesUptStatus(){
        return txtSuccesUptStatus.getText();
    }
    public void clickMenuRecruitment() {
        this.menuRecruitment.click();
    }

    public void clickBtnReset() {
        this.btnReset.click();
    }

    public void clickBtnFilter() {
        this.btnFilter.click();
    }

    public void clickMenuDataAktif() {
        this.menuDataAktif.click();
    }

    public void clickDropdownStatus() {
        this.dropdownStatus.click();
    }

    public String getTxtHeaderDataAktif() {
        return this.txtHeaderDataAktif.getText();
    }

    public int indexStatus() {
        return this.statusList.size();
    }

    public void setDrpStatus(String value) {
        Select drpStatus = new Select(dropdownStatus);
        drpStatus.selectByValue(value);
    }

    public void clickBtnPlus() {
        this.btnPlus.click();
    }

    public String getTxtStatusCancel(){
        return this.textStatusCancel.getText();
    }
    public String getTxtStatusEmpty(String value){
        Select drpStatus = new Select(dropdownStatus);
        drpStatus.selectByValue(value);
        return value;
    }

    public String getTxtStatusClosed(){
        return this.textStatusClosed.getText();
    }
    public String getTxtStatusHold(){
        return this.textStatusHold.getText();
    }
    public String getTxtStatusOpen() {
       return this.textStatusOpen.getText();
    }

    public int getNoOfRows() {
        return this.tableRows.size();
    }

    public boolean countRows() {
        boolean result = false;
        for (int i = 1; i <= getNoOfRows(); i++) {
            if (i <= getNoOfRows()) {
                result = true;
            }
        }
        return result;
    }

    public void clikDropdownEntries(){
        this.dropdownEntries.click();
    }

    public boolean countRowsEntries(int value) {
        boolean result = false;
        for (int i = 1; i <= getNoOfRows(); i++) {
            if (i <= value) {
                result = true;
            } else if (i > 10 && i>=value) {
                result = true;
            }else if (i > 25 && i>=value) {
                result = true;
            }else if (i > 50 && i>=value) {
                result = true;
            }else{
                result = false;
            }
        }
        return result;
    }

    public void setDrpEntries(String value) {
        Select drpEntires = new Select(dropdownEntries);
        drpEntires.selectByValue(value);
    }

    public void setTxtSearch(String keyword){
        this.textSearch.clear();
        this.textSearch.sendKeys(keyword);
    }
     public void clickBtnSearch(){
        this.btnSearch.click();
     }

     public void clickBtnRefresh(){
        this.btnRefresh.click();
     }

    public boolean searchDataAktif(String keyword) {
        boolean result = false;
        for (int i = 1; i <= getNoOfRows(); i++) {
            //search by namaProject
            String namaProject = tableDataAktif.findElement(By.xpath("//table[@id='table']//tbody/tr[" + i + "]/td[3]")).getText();
            //search by nama klien
            String namaKlien = tableDataAktif.findElement(By.xpath("//table[@id='table']//tbody/tr[" + i + "]/td[4]")).getText();
            //search by jenis kerjasama
            String jenisKerjasama = tableDataAktif.findElement(By.xpath("//table[@id='table']//tbody/tr[" + i + "]/td[5]")).getText();
            //search by nama posisi
            String namaPosisi = tableDataAktif.findElement(By.xpath("//table[@id='table']//tbody/tr[" + i + "]/td[6]")).getText();
            //search by status kontrak
            String statusKontrak = tableDataAktif.findElement(By.xpath("//table[@id='table']//tbody/tr[" + i + "]/td[7]")).getText();
            //search by penempatan
            String penempatan = tableDataAktif.findElement(By.xpath("//table[@id='table']//tbody/tr[" + i + "]/td[8]")).getText();
            //search by jam kerja
            String jamKerja = tableDataAktif.findElement(By.xpath("//table[@id='table']//tbody/tr[" + i + "]/td[9]")).getText();
            //search by pendidikan
            String pendidikan = tableDataAktif.findElement(By.xpath("//table[@id='table']//tbody/tr[" + i + "]/td[10]")).getText();

            //kondisi ketika melakukan search by keyword
            if (namaProject.equals(keyword)) {
                result = true;
            } else if (namaKlien.equals(keyword)) {
                result = true;
            } else if (jenisKerjasama.equals(keyword)) {
                result = true;
            } else if (namaPosisi.equals(keyword)) {
                result = true;
            } else if (statusKontrak.equals(keyword)) {
                result = true;
            } else if (penempatan.equals(keyword)) {
                result = true;
            } else if (jamKerja.equals(keyword)) {
                result = true;
            } else if (pendidikan.equals(keyword)) {
                result = true;
            }
        }
        return result;
    }

    public String getTextDataTableEmpty(String keyword) {
        return this.txtDataEmpty.getText();
    }

    public void clickBtnViewData(){
        this.btnViewDataAktif.click();
    }

    public String getTxtViewDataAktif(){
        return txtViewDataAktif.getText();
    }

    public void clickBtnBack(){
        this.btnBack.click();
    }

    public void clickDownload(){
        this.downloadData.click();
    }

    public void clickBtnDownload(){
        this.btnDownloadData.click();
    }

    public void clickBtnUpdateStatus(){
        this.btnUpdateStatus.click();
    }

    public void setDrpUpdateStatus(String value) {
        Select drpUptStatus = new Select(dropDownUptStatus);
        drpUptStatus.selectByValue(value);
    }

    public void setTxtNotes(String notes){
        this.txtNotes.clear();
        this.txtNotes.sendKeys(notes);
    }

    public void clickBtnUpdate(){
        this.btnUpdate.click();
    }

    public void clickBtnBatal(){
        this.btnBatal.click();
    }

    public void clickDrpdownUpdateStatus(){
        this.dropDownUptStatus.click();
    }

    public String getRequired(){
        return this.dropDownUptStatus.getAttribute("required");
    }
}
