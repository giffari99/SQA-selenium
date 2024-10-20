package com.juaracoding;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TextBox {
    public static void main(String[] args) {
        System.setProperty("webdriver.gecko.driver","C:\\my tools\\geckodriver.exe");
        WebDriver driver = new FirefoxDriver();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        driver.manage().window().maximize();
        System.out.printf("Open Browser");
        driver.get("https://demoqa.com/text-box");


        js.executeScript("window.scrollBy(0,350)");

        driver.findElement(By.id("userName")).sendKeys("giffari");
        driver.findElement(By.id("userEmail")).sendKeys("giffari@gmail.com");
        driver.findElement(By.id("currentAddress")).sendKeys("Jakarta");
        driver.findElement(By.id("permanentAddress")).sendKeys("jakarta");
        driver.findElement(By.id("submit")).click();


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
