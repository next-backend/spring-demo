package com.example.demo.test.web;

import io.github.bonigarcia.wdm.DriverManagerType;
import lombok.extern.slf4j.Slf4j;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.ChromeDriverManager;

import static org.junit.Assert.assertEquals;

@Slf4j
public class HelloServletFunctionalTest {
    private WebDriver driver;

    @BeforeClass
    public static void setupClass() {
        ChromeDriverManager.getInstance(DriverManagerType.CHROME).setup();
    }

    @Before
    public void setUp() {
        driver = new ChromeDriver();
    }

    @After
    public void tearDown() {
        if (driver != null)
            driver.quit();
    }

//    @Test
    public void sayHello() {
        driver.get("http://www.baidu.com");

//        driver.findElement(By.id("say-hello-text-input")).sendKeys("Dolly");
//        driver.findElement(By.id("say-hello-button")).click();
        log.debug("title -> " ,driver.getTitle());
        log.debug("source -> " ,driver.getPageSource());
//        assertEquals("Hello Page", driver.getTitle());
//        assertEquals("Hello, Dolly!", driver.findElement(By.tagName("h2")).getText());
    }
}
