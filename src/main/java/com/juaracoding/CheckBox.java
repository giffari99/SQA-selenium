package com.juaracoding;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class CheckBox {
    public static void main(String[] args) {
        System.setProperty("webdriver.gecko.driver","C:\\my tools\\geckodriver.exe");
        WebDriver driver = new FirefoxDriver();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        driver.manage().window().maximize();
        System.out.printf("Open Browser");
        driver.get("https://demoqa.com/checkbox");



        js.executeScript("window.scrollBy(0,250)");
        Utils.delay(2);
        driver.findElement(By.cssSelector("#tree-node > ol > li > span > button > svg")).click();
        driver.findElement(By.cssSelector("#tree-node > ol > li > ol > li:nth-child(2) > span > label > span.rct-checkbox > svg")).click();



        //delay 5 detik
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e){
            throw new RuntimeException(e);
        }


        driver.quit();
        System.out.printf("Quit Browser");

    }
}
