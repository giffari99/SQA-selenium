package com.juaracoding;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.concurrent.TimeUnit;

public class HandlingSelect {
    public static void main(String[] args) {

        System.setProperty("webdriver.gecko.driver","C:\\my tools\\geckodriver.exe");
        WebDriver driver = new FirefoxDriver();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        System.out.printf("Open Browser");
        driver.get("https://demoqa.com/select-menu");

        js.executeScript("window.scrollBy(0,300)");

        //chek menggunakan xpath lalu di prin ke konsole
//        String txtTitlePage = driver.findElement(By.xpath("//*[@id=\"selectMenuContainer\"]/h1")).getText();
//        System.out.println(txtTitlePage);

        //chek menggunakan copy relative xpath
        String txtTitlePage = driver.findElement(By.xpath("//h1[@class='text-center']")).getText();
        System.out.println(txtTitlePage);


        //chek select old
        WebElement selectColor = driver.findElement(By.id("oldSelectMenu"));
        Select select = new Select(selectColor);
        //---------------------------------------------
        select.selectByIndex(7);
        Utils.delay(2);
        select.selectByValue("red"); // attribute value
        Utils.delay(2);
        select.selectByVisibleText("Indigo");





        //delay
        Utils.delay(2);
        driver.quit();
        System.out.println("Quit Browser");
    }
}
