package com.juaracoding;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.security.PublicKey;
import java.util.concurrent.TimeUnit;

public class CustomAssert {
    public static void main(String[] args) {
        System.setProperty("webdriver.gecko.driver","C:\\my tools\\geckodriver.exe");
        WebDriver driver = new FirefoxDriver();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        System.out.printf("Open Browser");
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

        //negative
        loginUser(driver, "Invalid", "Invalid");

        String txtInvalidCredentials = driver.findElement(By.xpath("//p[contains(@class, 'oxd-alert-content-text')]")).getText();
        System.out.println(txtInvalidCredentials);

        customAssertValid(txtInvalidCredentials, "Invalid credentials");

        //positiv

        loginUser(driver, "Admin", "admin123");
        String txtDashboard = driver.findElement(By.xpath("//h6[contains(@class, 'topbar-header-breadcrumb')]")).getText();
        System.out.println(txtDashboard);

        customAssertEquals(txtDashboard, "Dashboard");

        //delay
        Utils.delay(2);
        driver.quit();
        System.out.println("Quit Browser");
    }


    public static void customAssertEquals(String actual, String expected){
        if(actual.equals(expected)){
            System.out.println("Passed");
        }else {
            System.out.println("Valid");
        }
    }

    public static void customAssertValid(String actual, String expected){
        if(actual.equals(expected)){
            System.out.println("Passed");
        }else {
            System.out.println("Valid");
        }
    }



    public static void loginUser(WebDriver driver, String username, String password){

        driver.findElement(By.xpath("//input[@name='username']")).sendKeys(username);
        Utils.delay(2);
        driver.findElement(By.xpath("//input[@name='password']")).sendKeys(password);
        Utils.delay(2);
        WebElement btnLogin = driver.findElement(By.xpath("//button[@type='submit']"));
        btnLogin.click();

    }


}
