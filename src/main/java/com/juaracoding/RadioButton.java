package com.juaracoding;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class RadioButton {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","C:\\my tools\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        driver.manage().window().maximize();
        System.out.printf("Open Browser");
        driver.get("https://demoqa.com/radio-button");
       js.executeScript("window.scrollBy(0,250)"); // Scroll


        driver.findElement(By.cssSelector("#app > div > div > div > div.col-12.mt-4.col-md-6 >"+
                "div:nth-child(3) > div:nth-child(2)")).click();
        Utils.delay(2);
        driver.findElement(By.cssSelector("#app > div > div > div > div.col-12.mt-4.col-md-6 >"+
                "div:nth-child(3) > div:nth-child(3)")).click();




        //delay 3 detik
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e){
            throw new RuntimeException(e);
        }


        driver.quit();
        System.out.printf("Quit Browser");

    }
}
