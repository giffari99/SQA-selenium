package com.juaracoding;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class HandlingWindow {
    public static void main(String[] args) {
        System.setProperty("webdriver.gecko.driver","C:\\my tools\\geckodriver.exe");
        WebDriver driver = new FirefoxDriver();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        System.out.printf("Open Browser");
        driver.get("https://demoqa.com/browser-windows");


        js.executeScript("window.scrollBy(0,250)");

        driver.findElement(By.id("tabButton")).click();

        ArrayList<String> tab = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tab.get(1));
        String txtSampHeading = driver.findElement(By.id("sampleHeading")).getText();
        System.out.println(txtSampHeading);
        Utils.delay(5);
        driver.switchTo().window(tab.get(0));
        String titlePage = driver.findElement(By.cssSelector("#browserWindows > h1")).getText();
        System.out.println(titlePage);




        //delay
        Utils.delay(5);
        driver.quit();
        System.out.println("Quit Browser");
    }


}
