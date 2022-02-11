package com.scanner;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;

public class MobileStaticAnalysis {
    private WebDriver driver;
    String path = System.getProperty("path");
    String buildName = System.getProperty("buildName");
    String url = System.getProperty("url");

    @Test
    public void runScanner() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.setAcceptInsecureCerts(true);
        options.addArguments("--incognito");
        options.setHeadless(true);

        //https://stackoverflow.com/questions/47685618/unable-to-download-pdf-file-in-chrome-browser-using-selenium-java
        Map<String, Object> preferences = new Hashtable<String, Object>();
        preferences.put("plugins.always_open_pdf_externally", true);
        options.setExperimentalOption("prefs", preferences);

        // disable flash and the PDF viewer
        preferences.put("plugins.plugins_disabled", new String[]{
                "Chrome PDF Viewer"
        });
        driver = new ChromeDriver(options);
        try {
            driver.get(url);
            WebElement el = driver.findElement(By.id("uploadFile"));
            el.sendKeys(path + buildName);
        } catch (NoSuchElementException e) {
            Assert.fail("Unable to import .apk/.ipa file, Please check if your application is running or Internet connection is up!");
        }
        WebDriverWait wait = new WebDriverWait(driver, 600);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("fa-box-open")));
        ((JavascriptExecutor) driver).executeScript("window.open()");
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        driver.get(url);
        List<WebElement> recentScans = driver.findElements(By.linkText("RECENT SCANS"));
        recentScans.get(1).click();
        List<WebElement> rows = driver.findElements(By.tagName("tr"));
        int count = rows.size();
        for (int i = 1; i < count; i++) {
            WebElement fileName = driver.findElement(By.cssSelector("tr:nth-child(" + i + ") > td:nth-child(2)"));
            if (fileName.getText().equals(buildName)) {
                WebElement pdfBtn = driver.findElement(By.xpath("//tr[" + i + "]//a[2]"));
                pdfBtn.click();
                break;
            }
        }
        driver.manage().window().maximize();
        driver.quit();
    }

}
