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
    @FindBy(xpath = "//i[@class='fa fa-search']")
    WebElement btnSearch;
    @FindBy(xpath = "//table[@id='dataTable-detail-offering']//tbody/tr")
    List<WebElement> tableRows;
    @FindBy(xpath = "//table[@id='dataTable-detail-offering']//tbody/tr/td")
    List<WebElement> tableColumns;
    @FindBy(xpath = "//table[@id='dataTable-detail-offering']")
    WebElement table;
    @FindBy(xpath = "//td[@class='dataTables_empty']")
    WebElement dataTabelsEmpty;
    @FindBy(xpath = "//select[@name='dataTable-detail-offering_length']")
    WebElement dropdownEntries;
    @FindBy(xpath = "//a[@class='btn btn-sm btn-danger']")
    WebElement btnBack;

    public int getNoOfRows() {
        return (tableRows.size());
    }

    public int getNoOfColums() {
        return (tableColumns.size());
    }

    public boolean searchOfferingByName(String name) {
        boolean result = false;
        for (int i = 1; i <= getNoOfRows(); i++) {
            String nameId = table.findElement(By.xpath("//table[@id='dataTable-detail-offering']//tbody/tr[" + i + "]/td[2]")).getText();
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
        this.btnSearch.click();
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

    public void selectValueDorpdown(String value) {
        Select drpEntires = new Select(dropdownEntries);
        drpEntires.selectByValue(value);
    }

    public boolean countValue(int value) {
        boolean result = false;
        for (int i = 1; i <= getNoOfRows(); i++) {
            if (i <= 10) {
                result = true;
            }
        }
        return result;
    }

    public void clickBtnBack() {
        this.btnBack.click();
    }
}
