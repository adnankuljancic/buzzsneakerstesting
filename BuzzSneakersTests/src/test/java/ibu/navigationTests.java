package ibu;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class navigationTests {
    private static WebDriver webDriver;

    @Test
    void navigatesToBuzzSarajevo2() throws InterruptedException {
        webDriver.findElement(By.xpath("//nav[3]/ul/li/a/span")).click();
        webDriver.findElement(By.xpath("//div[2]/div/div/div/div/div/a/img")).click();
        webDriver.findElement(By.xpath("//body/div[3]")).click();
        WebElement title = webDriver.findElement(By.tagName("h1"));
        assertEquals("BUZZ SARAJEVO 2", title.getText());

    }

    @Test
    void navigatesToNikeProducts() throws InterruptedException {
        webDriver.findElement(By.linkText("BRENDOVI")).click();
        webDriver.findElement(By.xpath("//div[2]/div/div/div/a/img")).click();
        assertEquals("https://www.buzzsneakers.ba/proizvodi/nike", webDriver.getCurrentUrl());

    }

    @Test
    void navigatesToInstagramPage() throws InterruptedException {
        
        WebElement cookies = webDriver.findElement(By.xpath("/html/body/div[12]/div/div/div[1]/div[2]/div[3]/button"));
        cookies.click();
        WebElement instagramImg=webDriver.findElement(By.xpath("/html/body/div[4]/div[1]/div/div/div[2]/div/div[2]/div[2]/div/a"));   
        instagramImg.click();
        Thread.sleep(3000);   
        assertEquals("https://www.instagram.com/buzzsneakerstation/", webDriver.getCurrentUrl());

    }
    

    @BeforeAll
    static void beforeClass() {
        webDriver = new ChromeDriver();

    }

    @BeforeEach
    void setUp() {
        webDriver.get("https://www.buzzsneakers.ba/");
    }

    @AfterEach
    void tearDown() {

    }

    @AfterAll
    static void afterClass() {
        webDriver.quit();

    }

}
