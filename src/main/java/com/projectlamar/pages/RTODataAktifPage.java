package com.projectlamar.pages;

import com.projectlamar.drivers.DriverSingleton;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class RTODataAktifPage {
    private WebDriver driver;

    public RTODataAktifPage() {
        this.driver = DriverSingleton.getDriver();
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//span[@class='d-sm-block d-none'][normalize-space()='Data Aktif']")
    WebElement btnDataAktif;

    public void clickbtnDataAktif() {
        this.btnDataAktif.click();
    }

    @FindBy(xpath = "//h1[normalize-space()='Index RRF Aktif']")
    WebElement textIndexRRFAktif;

    public String gettextIndexRRFAktif(){
        return this.textIndexRRFAktif.getText();
    }

    @FindBy(xpath = "//body[1]/div[3]/div[4]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/table[1]/tbody[1]/tr[1]/td[8]/center[1]/div[1]/a[1]")
    WebElement btnView;

    public void clickbtnview() {
        this.btnView.click();
    }

    @FindBy(xpath = "//h4[normalize-space()='Jumlah Kebutuhan']")
    WebElement textJumlahKebutuhan;

    public String gettextJumlahKebutuhan(){
        return this.textJumlahKebutuhan.getText();
    }

    @FindBy(xpath = "//select[@name='dataTable-setup-aktif_length']")
    WebElement DropdownValueDataAktif;

    public void clickDropdownValueDataAktif(){
        this.DropdownValueDataAktif.click();
    }

    public void setvalueentries(String value) {
        Select entries = new Select(DropdownValueDataAktif);
        entries.selectByValue(value);
    }

    public boolean countRows(int value) {
        boolean result = false;
        for (int i = 1; i <= getRows(); i++) {
            if (i <= value) {
                result = true;
            }
        }
        return result;
    }

    @FindBy(xpath = "//table[@id='dataTable-setup-aktif']")
    List<WebElement> tableRows;

    public int getRows(){
        return this.tableRows.size();
    }

    @FindBy(xpath = "//input[@type='search']")
    WebElement textSearch;

    public void setTextSearch(String keyword) {
        this.textSearch.clear();
        this.textSearch.sendKeys(keyword);
    }

    @FindBy(xpath = "//i[@class='fa fa-search']")
    WebElement btnSearch;

    public void clickbtnSearch() {
        this.btnSearch.click();
    }

    public boolean countRowsSearchby() {
        boolean result = false;
        for (int i = 1; i <= getRows(); i++) {
            if (i <= getRows()) {
                result = true;
            }
        }
        return result;
    }

    @FindBy(xpath = "//td[@class='dataTables_empty']")
    WebElement noDataAvailable;

    public String gettextnoDAtaAvailable(){
        return this.noDataAvailable.getText();
    }

    @FindBy(xpath = "//span[@id='btnRefresh']")
    WebElement btnRefresh;

    public void clickbtnRefresh() {
        this.btnRefresh.click();
    }

    @FindBy(xpath = "//*[@id=\"dataTable-setup-aktif\"]/tbody/tr[1]/td[8]/center/div/a[2]")
    WebElement btnDownload;

    public void clickbtnDwonload() {
        this.btnDownload.click();
    }

    @FindBy(xpath = "//body/div[@id='page-container']/div[@id='content']/div[@class='row']/div[@class='col-lg-11 ui-sortable ml-5']/a[2]")
    WebElement btnBack;

    public void clickbtnBack(){
        this.btnBack.click();
    }

    @FindBy(xpath = "//a[@class='dropdown-toggle']")
    WebElement btnIconUser;

    public void clickbtnIconUser(){
        this.btnIconUser.click();
    }

    @FindBy(xpath = "//a[normalize-space()='Log Out']")
    WebElement btnLogout;

    public void clickbtnLogout(){
        this.btnLogout.click();
    }

    @FindBy(xpath = "//div[@class='login-header']")
    WebElement textUserLogin;

    public String gettextUserLogin(){
        return this.textUserLogin.getText();
    }
}
