package com.gusev;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class SeleniumMain {
    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver","D:\\TestProject\\FirstSeleniumProject\\src\\main\\resources\\chromedriver.exe");
        WebDriver driver;
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-sandbox");
        driver = new ChromeDriver(options);
        driver.get("https://yandex.ru");
    }
}
