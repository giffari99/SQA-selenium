package com.juaracoding;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class LinkText {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","C:\\my tools\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        driver.manage().window().maximize();
        System.out.printf("Open Browser");
        driver.get("https://www.google.com/");


        driver.findElement(By.linkText("Gmail")).click();



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
