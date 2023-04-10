package com.projectlamar.pages;

import com.projectlamar.drivers.DriverSingleton;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class DashboardPage {
    private WebDriver driver;

    public DashboardPage() {
        this.driver = DriverSingleton.getDriver();
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//div[@class='widget widget-stats bg-success']//a[contains(text(),'View Detail')]")
    WebElement btnViewDetailData7hari;
    @FindBy(xpath = "//div[@class='widget widget-stats bg-warning']//a[contains(text(),'View Detail')]")
    WebElement btnViewDetailData10hari;
    @FindBy(xpath = "//div[@class='widget widget-stats bg-secondary']//a[contains(text(),'View Detail')]")
    WebElement btnViewDetailData14hari;
    @FindBy(xpath = "//h4[normalize-space()='Detail Data Offering']")
    WebElement txtDetailDataOffering7;
    @FindBy(xpath = "//h4[@class='panel-title']")
    WebElement txtDetailDataOffering10;
    @FindBy(xpath = "//input[@type='search']")
    WebElement txtSearch;
    @FindBy(xpath = "//select[@name='dataTable-detail-clients_length']")
    WebElement txtSearchClient;
    @FindBy(xpath = "//i[@class='fa fa-search']")
    WebElement btnSearch;
    @FindBy(xpath = "//table[@id='dataTable-detail-offering']//tbody/tr")
    List<WebElement> tableOfferingRows;
    @FindBy(xpath = "//table[@id='dataTable-detail-clients']//tbody/tr")
    List<WebElement> tableClientRows;
    @FindBy(xpath = "//table[@id='dataTable-detail-offering']//tbody/tr/td")
    List<WebElement> tableOfferingColumns;
    @FindBy(xpath = "//table[@id='dataTable-detail-offering']")
    WebElement tableOffering;
    @FindBy(xpath = "//table[@id='dataTable-detail-clients']")
    WebElement tableClient;
    @FindBy(xpath = "//td[@class='dataTables_empty']")
    WebElement dataTabelsEmpty;
    @FindBy(xpath = "//select[@name='dataTable-detail-offering_length']")
    WebElement dropdownEntries;
    @FindBy(xpath = "//a[@class='btn btn-sm btn-danger']")
    WebElement btnBack;
    @FindBy(xpath = "//a[@title='Back']")
    WebElement btnBackClient;
    @FindBy(xpath = "//h1[@class='page-header']")
    WebElement txtJumlahClient;
    @FindBy(xpath = "//span[@class='pull-right badge bg-primary']")
    WebElement btnJumlahClient;
    @FindBy(xpath = "//span[@id='btnSearch']")
    WebElement btnSearchClient;
    @FindBy(xpath = "//select[@name='dataTable-detail-clients_length']")
    WebElement dropdownEntriesClient;

    public int getNoOfRows() {
        return (tableOfferingRows.size());
    }

    public int getNoOfRowsClient() {
        return (tableClientRows.size());
    }

    public int getNoOfColums() {
        return (tableOfferingColumns.size());
    }

    public boolean searchOfferingByName(String name) {
        boolean result = false;
        for (int i = 1; i <= getNoOfRows(); i++) {
            String nameId = tableOffering.findElement(By.xpath("//table[@id='dataTable-detail-offering']//tbody/tr[" + i + "]/td[2]")).getText();
            System.out.println(nameId);
            if (nameId.equals(name)) {
                result = true;
            }
        }
        return result;
    }

    public String getTextDataTableEmpty() {
        return this.dataTabelsEmpty.getText();
    }

    public void setTxtSearch(String keyword) {
        this.txtSearch.clear();
        this.txtSearch.sendKeys(keyword);
    }

    public void clickBtnSearch() {
        if (this.btnSearch.isDisplayed()) {
            this.btnSearch.click();
        } else if (this.btnSearchClient.isDisplayed()) {
            this.btnSearchClient.click();
        }
    }

    public void clickBtnViewData7Hari() {
        this.btnViewDetailData7hari.click();
    }

    public void clickBtnViewData14Hari() {
        this.btnViewDetailData14hari.click();
    }

    public void clickBtnViewData10Hari() {
        this.btnViewDetailData10hari.click();
    }

    public String getTxtDetailDataOffering() {
        String resultTxt = "";
        if (txtDetailDataOffering7.isDisplayed()) {
            resultTxt = this.txtDetailDataOffering7.getText();
        } else if (txtDetailDataOffering10.isDisplayed()) {
            resultTxt = this.txtDetailDataOffering10.getText();
        }
        return resultTxt;
    }

    public void clickDropdownEntries() {
        this.dropdownEntries.click();
    }

    public void clickDropdownEntriesClient() {
        this.dropdownEntriesClient.click();
    }

    public void selectValueDropdownOffering(String value) {
        Select drpEntires = new Select(dropdownEntries);
        drpEntires.selectByValue(value);
    }

    public void selectValueDropdownClient(String value) {
        Select drpEntires = new Select(dropdownEntriesClient);
        drpEntires.selectByValue(value);
    }

    public boolean countValue(int value) {
        boolean result = false;
        for (int i = 1; i <= getNoOfRows(); i++) {
            if (i <= value) {
                result = true;
            }
        }
        return result;
    }

    public void clickBtnBack() {
        this.btnBack.click();
    }

    public void clickBtnBackClient() {
        this.btnBackClient.click();
    }

    public String getTxtJumlahClient() {
        return this.txtJumlahClient.getText();
    }

    public void clickBtnJumlahClient() {
        this.btnJumlahClient.click();
    }

    public boolean searchClientByName(String client) {
        boolean result = false;
        for (int i = 1; i <= getNoOfRowsClient(); i++) {
            String clientId = tableClient.findElement(By.xpath("//table[@id='dataTable-detail-clients']//tbody/tr[" + i + "]/td[2]")).getText();
            System.out.println(clientId);
            if (clientId.equals(client)) {
                result = true;
            }
        }
        return result;
    }

    public boolean countValueClients(int value) {
        boolean result = false;
        for (int i = 1; i <= getNoOfRowsClient(); i++) {
            if (i <= 10) {
                result = true;
            } else if (i >= 10 && i <= 25) {
                result = true;
            }
        }
        return result;
    }
}
