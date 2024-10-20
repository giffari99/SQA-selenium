package com.juaracoding;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.awt.*;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class SeleniumCollection {
    public static void main(String[] args) {

        System.setProperty("webdriver.gecko.driver","C:\\my tools\\geckodriver.exe");
        WebDriver driver = new FirefoxDriver();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        System.out.println("Open Browser");
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

//        js.executeScript("window.scrollBy(0,300)");

//
//
//        List<WebElement> listInput = driver.findElements(By.xpath("//input"));
//        System.out.println("Jumlah tag HTML input = " +listInput.size());
//
//        for (int i = 0; i < listInput.size(); i++) {
//            System.out.println(listInput.get(i).getAttribute("type"));
//        }
//
//        for (int i = 1; i < listInput.size(); i++) {
//            listInput.get(i).sendKeys("invalid");
//
//        }
//
//
//        LoginPage.loginUser(driver, "Admin", "aaadmin123");

        //-------------- 1 -- mengambil jumlah list menu----------------------

//        List<WebElement> listMenu = driver.findElements(By.xpath("//li[@class='oxd-main-menu-item-wrapper']"));
//        System.out.println(listMenu.size());

        // ------------------------end ----------------------


        //--------------- 2 --- mengambil tulisan alert saat salah masukan akun
//        String txtInvalid = driver.findElement(By.xpath("//p[contains(@class,'alert-content-text')]")).getText();
//        System.out.println(txtInvalid);
        // ----------------------- end ------------------------------


        // ------------ 3 --- memasukan teks, lalu select all, dan delete teks
        driver.findElement(By.xpath("//input[@name='username']")).sendKeys("selenium");
        driver.findElement(By.xpath("//input[@name='username']")).sendKeys(Keys.CONTROL+"A");
        Utils.delay(3);
        driver.findElement(By.xpath("//input[@name='username']")).sendKeys(Keys.DELETE);
        //----------------------- end --------------------------------

//        Utils.delay(5);

        // --------------- 4 --- mengambil jumlah listtrend dan munculkan ke console data list trend
        driver.get("https://www.tokopedia.com/");
        List<WebElement> listTrend = driver.findElements(By.xpath("//a[@data-testid='trendkingKeywordList']"));
        System.out.println(listTrend.size());

        for(WebElement listTrends : listTrend){
            System.out.println(listTrends.getText());
        }
        //-------------------------------- end ------------------


//        String price = "Rp3.600.000";
//        String priceClr = price.replace("Rp", "");
//        double priceConv = Double.parseDouble(priceClr.replace(".", ""));
//        System.out.println(priceConv+1000);



        //delay
        Utils.delay(2);
        driver.quit();
        System.out.println("Quit Browser");
    }


}
