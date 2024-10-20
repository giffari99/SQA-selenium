package com.juaracoding;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class HandlingAlert {
    public static void main(String[] args) {
        System.setProperty("webdriver.gecko.driver","C:\\my tools\\geckodriver.exe");
        WebDriver driver = new FirefoxDriver();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        System.out.printf("Open Browser");
        driver.get("https://demoqa.com/alerts");

        js.executeScript("window.scrollBy(0,250)");


        driver.findElement(By.id("alertButton")).click();
        Utils.delay(2);
        driver.switchTo().alert().accept(); // Alert / peringatan    ok
        System.out.println("Alert Button");
        Utils.delay(2);

        driver.findElement(By.id("timerAlertButton")).click();
        Utils.delay(5);
        driver.switchTo().alert().accept(); // Alert / peringatan   ok
        System.out.println("Timer Alert Button");
        Utils.delay(2);

        driver.findElement(By.id("confirmButton")).click();
        Utils.delay(2);
        driver.switchTo().alert().dismiss(); // Alert / peringatan    cancel
        System.out.println("Comfirm Alert Button");
        Utils.delay(2);


        driver.findElement(By.id("promtButton")).click();
        Utils.delay(2);

        driver.switchTo().alert().sendKeys("Juara Coding"); // isi data  di dalem Alert / peringatan ok,
        Utils.delay(2);

        driver.switchTo().alert().accept(); // Alert / peringatan    ok
        System.out.println("Comfirm Alert Button");



        //delay 3 detik
        Utils.delay(3);
        driver.quit();
        System.out.println("Quit Browser");
    }


}
