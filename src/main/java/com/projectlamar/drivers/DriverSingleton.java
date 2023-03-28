package com.projectlamar.drivers;

import com.projectlamar.drivers.strategies.DriverStrategy;
import com.projectlamar.drivers.strategies.DriverStrategyImplementer;
import com.projectlamar.utils.Constants;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class DriverSingleton {
    private static DriverSingleton instance = null;
    private static WebDriver driver;
    private DriverSingleton(String driver){
        instancetiate(driver);
    }

    public WebDriver instancetiate(String strategy){
        DriverStrategy driverStrategy = DriverStrategyImplementer.chooseStrategy(strategy);
        driver = driverStrategy.setStrategy();
        driver.manage().timeouts().implicitlyWait(Constants.TIMEOUTS, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        return driver;
    }
    public static DriverSingleton getInstance(String driver){
        if (instance == null){
            instance = new DriverSingleton(driver);
        }
        return instance;
    }
    public static WebDriver getDriver(){
        return driver;
    }
    public static void closeObjectInstance(){
        instance = null;
        driver.quit();
    }
}