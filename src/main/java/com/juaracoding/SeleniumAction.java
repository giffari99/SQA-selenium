package com.juaracoding;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.beans.PropertyChangeListener;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class SeleniumAction {
    public static void main(String[] args) {

        System.setProperty("webdriver.gecko.driver","C:\\my tools\\geckodriver.exe");
        WebDriver driver = new FirefoxDriver();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        System.out.println("Open Browser");
        driver.get("https://www.browserstack.com/");

        Utils.delay(2);

        WebElement menuBootcamp = driver.findElement(By.xpath("//button[@id='products-dd-toggle']"));
        WebElement menuDevelopers = driver.findElement(By.xpath("//button[@id='developers-dd-toggle']"));

        Actions actions = new Actions(driver);
        actions.moveToElement(menuBootcamp).build().perform();
        Utils.delay(2);
        actions.moveToElement(menuDevelopers).build().perform();

        List<WebElement> listMenuDevelopers = driver.findElements(By.xpath("//div[@class='bstack-mm-sub-li']"));
        System.out.println(listMenuDevelopers.size());

        for(WebElement listMenuDev : listMenuDevelopers){
            System.out.println(listMenuDev.getText());
        }
        Utils.delay(2);
        driver.findElement(By.xpath("//span[normalize-space()='Documentation']")).click();
        Utils.delay(2);
        driver.navigate().back();
        Utils.delay(2);
        // -- harus di panggil ulang dengan nama yg berbeda apabila ingin di panggil kembali
        WebElement menuDeveloper = driver.findElement(By.xpath("//button[@id='developers-dd-toggle']"));
        actions.moveToElement(menuDeveloper).build().perform();





        //delay
        Utils.delay(1);
        driver.quit();
        System.out.println("Quit Browser");
    }
}
