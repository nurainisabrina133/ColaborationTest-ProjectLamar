package com.projectlamar.pages;

import com.projectlamar.drivers.DriverSingleton;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.security.PublicKey;
import java.util.List;

public class RTODataPengajuanPage {
    private WebDriver driver;

    public RTODataPengajuanPage() {
        this.driver = DriverSingleton.getDriver();
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//h1[@class='page-header']")
    WebElement textApproveRRF;

    @FindBy(xpath = "//a[normalize-space()='Approve RRF']")
    WebElement btnApproveRRF;

    @FindBy(xpath = "//tbody/tr[1]/td[8]/center[1]/div[1]/a[3]/span[1]")
    WebElement btnView;

    @FindBy(xpath = "//h4[normalize-space()='Jumlah Kebutuhan']")
    WebElement textDetailApproveRRF;

    @FindBy(xpath = "//body/div[@id='page-container']/div[@id='content']/div[@class='row']/div[@class='col-lg-11 ui-sortable ml-5']/a[1]")
    WebElement btnBack;

    @FindBy(xpath = "//input[@type='search']")
    WebElement textSearch;

    @FindBy(xpath = "//i[@class='fa fa-search']")
    WebElement btnSearch;

    @FindBy(xpath = "//*[@id=\"dataTable-setup\"]/tbody/tr[1]/td[2]/h5") //finnacel
    WebElement textSearchbyname;

    @FindBy(xpath = "//td[@class='dataTables_empty']")
    WebElement noDataavailableintable;

    @FindBy(xpath = "//tbody/tr[1]/td[2]") //Kredivo
    WebElement textSearchbyprojectname;

    @FindBy(xpath = "//*[@id=\"dataTable-setup\"]/tbody/tr[1]/td[8]/center/div/a[2]") //approve
    WebElement btnApprove;

    @FindBy(xpath = "//a[normalize-space()='IT']")
    WebElement btnIT;

    @FindBy(xpath = "//a[normalize-space()='NON IT']")
    WebElement btnNonIT;

    @FindBy(xpath = "//select[@name='dataTable-setup_length']")
    WebElement textDropdownentries;

    @FindBy(xpath = "//h1[@class='page-header']")
    WebElement textheaderApproverrf;

    @FindBy(xpath = "//strong[normalize-space()='Berhasil!']")
    WebElement textBerhasil;

    @FindBy(xpath = "//span[@id='btnRefresh']")
    WebElement btnRefresh;

    @FindBy(xpath = "//input[@type='search']")
    WebElement textBlank;

    @FindBy(xpath = "//table[@id='dataTable-setup']//tbody/tr")
    List<WebElement> tableRows;

    @FindBy(xpath = "//tbody/tr[1]/td[8]/center[1]/div[1]/a[4]")
    WebElement btnReturn;

    @FindBy(xpath = "//button[normalize-space()='Update']")
    WebElement btnUpdate;

    @FindBy(xpath = "//button[@id='batal']")
    WebElement btnBatalUpdate;

    @FindBy(xpath = "//textarea[@id='note']")
    WebElement textNote;




    public void setTextNote(String keyword) {
        this.textNote.sendKeys(keyword);
    }

    public void clickbtnUpdate() {
        this.btnUpdate.click();
    }

    public void clickbtnBatalUpdate() {
        this.btnBatalUpdate.click();
    }

    public void clickbtnReturn() {
        this.btnReturn.click();
    }

    public int getRows() {
        return (tableRows.size());
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

    public boolean countRowsSearchby() {
        boolean result = false;
        for (int i = 1; i <= getRows(); i++) {
            if (i <= getRows()) {
                result = true;
            }
        }
        return result;
    }

    public void clickBtnApproveRRF() {

        this.btnApproveRRF.click();
    }

    public void clickBtnView() {

        this.btnView.click();
    }

    public void clickBtnBack() {

        this.btnBack.click();
    }

    public String gettextApproveRRF() {

        return this.textApproveRRF.getText();
    }

    public String gettextDetailApproveRRF() {

        return this.textDetailApproveRRF.getText();
    }

    public void setTextSearch(String keyword) {
        this.textSearch.clear();
        this.textSearch.sendKeys(keyword);
    }

    public void btnSearch() {

        this.btnSearch.click();
    }

    public String gettextSearchbyname() {

        return this.textSearchbyname.getText();
    }

    public String getnoDataavailable() {
        return this.noDataavailableintable.getText();
    }

    public String gettextSearchbyprojectname() {
        return this.textSearchbyprojectname.getText();
    }

    public void btnApprove() {
        this.btnApprove.click();
    }

    public void btnIT() {
        this.btnIT.click();
    }

    public void btnNonIT() {
        this.btnNonIT.click();
    }

    public void klikDropdownentries() {
        this.textDropdownentries.click();
    }

    public String gettextheaderApproverrf() {

        return this.textheaderApproverrf.getText();
    }

    public String gettextBerhasil() {
        return this.textBerhasil.getText();
    }

    public void btnRefresh() {
        this.btnRefresh.click();
    }

    public String gettextBlank() {
        return this.textBlank.getText();
    }

    public void setvalueentries(String value) {
        Select entries = new Select(textDropdownentries);
        entries.selectByValue(value);
    }
}
