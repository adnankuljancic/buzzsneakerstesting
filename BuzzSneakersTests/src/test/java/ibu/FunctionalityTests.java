package ibu;

import java.util.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import com.beust.jcommander.internal.Console;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.net.MalformedURLException;
import java.net.URL;

public class FunctionalityTests {
  private static WebDriver driver;
  private static String baseUrl;
  private static Map<String, Object> vars;

  @BeforeAll
  static void setUp() {
    System.setProperty("webdriver.chrome.driver", "C:\\Users\\User\\Documents\\chromedriver.exe");
    ChromeOptions options = new ChromeOptions();
		options.addArguments("--start-maximized");
    driver = new ChromeDriver(options);
    baseUrl = "https://www.buzzsneakers.ba/";
  }

  /**
   * 
   */
  @AfterAll
  public static void tearDown() {
    driver.quit();
  }

  @Test
  public void SearchTest() throws InterruptedException {
    driver.get(baseUrl);
    Thread.sleep(3000);
    driver.findElement(By.xpath("//nav/div[3]")).click();
    driver.findElement(By.id("search-text")).sendKeys("nike");
    driver.findElement(By.id("search-text")).sendKeys(Keys.ENTER);
    Thread.sleep(3000);
    String link = driver.getCurrentUrl();
    assertEquals("https://www.buzzsneakers.ba/proizvodi?search=nike", link);
  }

  @Test
  public void AddToCartTest() throws InterruptedException {
    driver.get(baseUrl);
    Thread.sleep(3000);
    WebElement cookies = driver.findElement(By.xpath("/html/body/div[12]/div/div/div[1]/div[2]/div[3]/button"));
    cookies.click();
    JavascriptExecutor js = (JavascriptExecutor) driver;
	  js.executeScript("window.scrollBy(0,600)", "");
    WebElement element = driver.findElement(By.xpath("/html/body/div[3]/div[3]/div/div[2]/div/div[2]/div/div/div[1]/div/div/div/div[1]/div[1]/div[3]/div[5]/a"));
    element.click();
    Thread.sleep(3000);
    WebElement size = driver.findElement(By.xpath("/html/body/div[3]/div[3]/div[1]/div[1]/div/div/div[1]/div[2]/div[5]/ul/li[7]"));
    size.click();
    WebElement addToCart = driver.findElement(By.xpath("/html/body/div[3]/div[3]/div[1]/div[1]/div/div/div[1]/div[2]/div[7]/div[4]/button"));
    addToCart.click();
    Thread.sleep(3000);
    WebElement cartIcon = driver.findElement(By.xpath("/html/body/div[1]/div/div[4]/div[1]/div[1]/a/div[2]"));
    String itemCount = cartIcon.getText();
    int count = Integer.parseInt(itemCount);
    assertEquals(1, count);
  }

  @Test
  public void LogIn() throws InterruptedException {
    driver.get(baseUrl);
    Thread.sleep(3000);
    driver.findElement(By.xpath("//nav[2]/ul/li/a/span")).click();
    driver.findElement(By.id("login_email")).click();
    driver.findElement(By.id("login_email")).sendKeys("adnan.kuljancic@stu.ibu.edu.ba");
    driver.findElement(By.id("login_password")).click();
    driver.findElement(By.id("login_password")).sendKeys("aditarik1");
    driver.findElement(By.xpath("//button[@type=\'submit\']")).click();
    Thread.sleep(5000);
    String name = driver.findElement(By.xpath("/html/body/div[1]/div/div[1]/div/div[3]/div/nav[2]/ul/li[1]/a/span")).getText();
    assertEquals("Adnan Kuljancic", name);
  }

  @Test
  public void AddToWishlist() throws InterruptedException {
    driver.get(baseUrl);
    Thread.sleep(3000);
    WebElement cookies = driver.findElement(By.xpath("/html/body/div[12]/div/div/div[1]/div[2]/div[3]/button"));
    cookies.click();
    driver.findElement(By.xpath("//nav[2]/ul/li/a/span")).click();
    driver.findElement(By.id("login_email")).click();
    driver.findElement(By.id("login_email")).sendKeys("adnan.kuljancic@stu.ibu.edu.ba");
    driver.findElement(By.id("login_password")).click();
    driver.findElement(By.id("login_password")).sendKeys("aditarik1");
    driver.findElement(By.xpath("//button[@type=\'submit\']")).click();
    Thread.sleep(5000);
    JavascriptExecutor js = (JavascriptExecutor) driver;
	  js.executeScript("window.scrollBy(0,600)", "");
    WebElement element = driver.findElement(By.xpath("/html/body/div[3]/div[3]/div/div[2]/div/div[2]/div/div/div[1]/div/div/div/div[1]/div[1]/div[1]/div[5]/div"));
    element.click();
    Thread.sleep(3000);
    WebElement favoritesIcon = driver.findElement(By.xpath("/html/body/div[1]/div/div[4]/div[2]/a/div[2]"));
    int count = Integer.parseInt(favoritesIcon.getText());
    assertEquals(1, count);
  }

  @Test
  public void RemoveFromWishlist() throws InterruptedException {
    driver.get(baseUrl);
    Thread.sleep(3000);
    WebElement cookies = driver.findElement(By.xpath("/html/body/div[12]/div/div/div[1]/div[2]/div[3]/button"));
    cookies.click();
    driver.findElement(By.xpath("//nav[2]/ul/li/a/span")).click();
    driver.findElement(By.id("login_email")).click();
    driver.findElement(By.id("login_email")).sendKeys("adnan.kuljancic@stu.ibu.edu.ba");
    driver.findElement(By.id("login_password")).click();
    driver.findElement(By.id("login_password")).sendKeys("aditarik1");
    driver.findElement(By.xpath("//button[@type=\'submit\']")).click();
    Thread.sleep(3000);
    WebElement favoritesIcon = driver.findElement(By.xpath("/html/body/div[1]/div/div[4]/div[2]/a/div[2]"));
    favoritesIcon.click();
    Thread.sleep(3000);
    driver.findElement(By.xpath("/html/body/div[3]/div[2]/div[2]/div[2]/div/div/div/div/div[2]/div/div/div[2]/div/span")).click();
    Thread.sleep(3000);
    driver.findElement(By.xpath("/html/body/div[14]/div/div/div[2]/button[2]")).click();
    Thread.sleep(5000);
    favoritesIcon = driver.findElement(By.xpath("/html/body/div[1]/div/div[4]/div[2]/a/div[2]"));
    int count = Integer.parseInt(favoritesIcon.getText());
    assertEquals(0, count);
  }

  

  
}
