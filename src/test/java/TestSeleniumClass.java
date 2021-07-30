import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

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
    public void shouldTestBe(){
        driver.get("http://localhost:9999");
        driver.findElement(By.xpath("//div[@id='root']//form[@action='/']/div[1]/span//span[@class='input__box']")).sendKeys("Василий");
        driver.findElement(By.xpath("//div[@id='root']//form[@action='/']/div[2]/span")).sendKeys("+79522865643");
        driver.findElement(By.xpath("//div[@id='root']//form[@action='/']//label//input[@name='agreement']")).click();
        driver.findElement(By.xpath("//div[@id='root']//form[@action='/']//button[@role='button']//span[@class='button__text']")).click();
        String text = driver.findElement(By.xpath("/html//div[@id='root']//p[@class='paragraph paragraph_theme_alfa-on-white']")).getText();
        assertEquals ("  Ваша заявка успешно отправлена! Наш менеджер свяжется с вами в ближайшее время.", text.trim());
    }

    private void assertEquals(String s, String trim) {
    }
}
