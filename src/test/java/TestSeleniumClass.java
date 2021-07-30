import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestSeleniumClass {
    private WebDriver driver;

    @BeforeAll
    static void setUpAll(){
        System.setProperty("webdriver.chrome.driver","C:\\Users\\arodkina\\IdeaProjects\\test-2-1\\driver\\chromedriver.exe");
    }

    @BeforeEach
    void setUp() {
        driver = new ChromeDriver();

    }

    @AfterEach
    void tearDown(){
        driver.quit();
        driver = null;
    }

    @Test
    public void shouldTestBe() throws InterruptedException {
        driver.get("http://localhost:9999");
        Thread.sleep(500);
        WebElement form = driver.findElement(By.xpath("//div[@id='root']/div[@class='App_appContainer__3jRx1']"));
        Thread.sleep(500);
        driver.findElement(By.cssSelector("[data-test-id=name] input")).sendKeys("Василий");
        driver.findElement(By.cssSelector("[data-test-id=phone] input")).sendKeys("+79522865643");
        driver.findElement(By.cssSelector("[data-test-id=agreement]")).click();
        driver.findElement(By.className("button__text")).click();
        String text = driver.findElement(By.xpath("//div[@id='root']/div[@class='App_appContainer__3jRx1']//p[@class='paragraph paragraph_theme_alfa-on-white']")).getText();
        assertEquals ("Ваша заявка успешно отправлена! Наш менеджер свяжется с вами в ближайшее время.", text.trim());
    }

    @Test
    public void wrongPhoneSelenium() throws InterruptedException {
        driver.get("http://localhost:9999");
        Thread.sleep(500);
        WebElement form = driver.findElement(By.xpath("//div[@id='root']/div[@class='App_appContainer__3jRx1']"));
        driver.findElement(By.cssSelector("[data-test-id=name] input")).sendKeys("Василий");
        driver.findElement(By.cssSelector("[data-test-id=phone] input")).sendKeys("+7952");
        driver.findElement(By.cssSelector("[data-test-id=agreement]")).click();
        driver.findElement(By.className("button__text")).click();
        String text = driver.findElement(By.xpath("//div[@id='root']/div[@class='App_appContainer__3jRx1']/form[@action='/']/div[2]/span/span[@class='input__inner']/span[@class='input__sub']")).getText();
        assertEquals ("Телефон указан неверно. Должно быть 11 цифр, например, +79012345678.", text.trim());
    }
}
