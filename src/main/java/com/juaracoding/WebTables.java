package com.juaracoding;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class WebTables {
    public static void main(String[] args) {
        System.setProperty("webdriver.gecko.driver","C:\\my tools\\geckodriver.exe");
        WebDriver driver = new FirefoxDriver();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        System.out.printf("Open Browser");
        driver.get("https://demoqa.com/webtables");

        //web scrapping
        String txtTitlePage = driver.findElement(By.cssSelector("#app > div > div > div >"+
                        "div.col-12.mt-4.col-md-6 > h1")).getText();
        System.out.println(txtTitlePage);

        // tag get title / nama web
        String tagTitle = driver.getTitle();
        System.out.println(tagTitle);

        // get current url / link web
        String currentUrl = driver.getCurrentUrl();
        System.out.println(currentUrl);

        js.executeScript("window.scrollBy(0,250)"); // Scroll

        // add data

        driver.findElement(By.id("addNewRecordButton")).click();
        Utils.delay(2);
        driver.findElement(By.id("firstName")).sendKeys("ahay");
        Utils.delay(2);
        driver.findElement(By.id("lastName")).sendKeys("uhuy");
        Utils.delay(2);
        driver.findElement(By.id("userEmail")).sendKeys("uhuy@Gmail.com");
        Utils.delay(2);
        driver.findElement(By.id("age")).sendKeys("24");
        Utils.delay(2);
        driver.findElement(By.id("salary")).sendKeys("10000000");
        Utils.delay(2);
        driver.findElement(By.id("department")).sendKeys("BUMN");
        Utils.delay(2);
        driver.findElement(By.id("submit")).click();
        Utils.delay(2);

        // edit data

        driver.findElement(By.id("edit-record-1")).click();
        driver.findElement(By.id("firstName")).clear();
        Utils.delay(1);
        driver.findElement(By.id("firstName")).sendKeys("ahay");
        Utils.delay(1);
        driver.findElement(By.id("lastName")).clear();
        Utils.delay(1);
        driver.findElement(By.id("lastName")).sendKeys("uhuy");
        Utils.delay(1);
        driver.findElement(By.id("submit")).click();
        Utils.delay(1);
        // delete DATA

        driver.findElement(By.id("delete-record-1")).click();




        //delay 2 detik
        Utils.delay(2);
        driver.quit();
        System.out.println("Quit Browser");
    }


    public static void delay(long detik){
        try {
            Thread.sleep(detik*1000);
        } catch (InterruptedException e){
            throw new RuntimeException(e);
        }
    }


}
