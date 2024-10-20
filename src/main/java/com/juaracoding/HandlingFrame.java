package com.juaracoding;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class HandlingFrame {

    public static void main(String[] args) {
        System.setProperty("webdriver.gecko.driver", "C:\\my tools\\geckodriver.exe");
        WebDriver driver = new FirefoxDriver();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        System.out.printf("Open Browser");
        driver.get("https://demoqa.com/frames");

        js.executeScript("window.scrollBy(0,250)");

        WebElement frameOne = driver.findElement(By.id("frame1"));
        driver.switchTo().frame(frameOne);
        String txtSampleHeading = driver.findElement(By.id("sampleHeading")).getText();
        System.out.println(txtSampleHeading);

        driver.switchTo().defaultContent();

        String txtTitleFrame = driver.findElement(By.cssSelector("#framesWrapper > h1")).getText();
        System.out.println(txtTitleFrame);


        //delay
        Utils.delay(5);
        driver.quit();
        System.out.println("Quit Browser");
    }

}
