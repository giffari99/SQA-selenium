package com.juaracoding;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class HandlingModalDialogs {
    public static void main(String[] args) {
        System.setProperty("webdriver.gecko.driver","C:\\my tools\\geckodriver.exe");
        WebDriver driver = new FirefoxDriver();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        System.out.printf("Open Browser");
        driver.get("https://demoqa.com/browser-windows");


        js.executeScript("window.scrollBy(0,250)");

        //navigate

        driver.get("https://demoqa.com/modal-dialogs");
        System.out.println("current URL : " + driver.getCurrentUrl());
        Utils.delay(3);
        js.executeScript("window.scrollBy(0,250)");
        driver.findElement(By.id("showSmallModal")).click();
        Utils.delay(3);
        driver.findElement(By.id("closeSmallModal")).click();
        Utils.delay(3);
        driver.findElement(By.id("showLargeModal")).click();
        Utils.delay(3);
        driver.findElement(By.id("closeLargeModal")).click();

        driver.navigate().back();
        System.out.println("Current URL :" + driver.getCurrentUrl());
        driver.navigate().refresh();



        Utils.delay(5);
        driver.quit();
        System.out.println("Quit Browser");
    }


}
