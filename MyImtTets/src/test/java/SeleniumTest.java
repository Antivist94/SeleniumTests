import jdk.jfr.Description;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumTest {
    private WebDriver driver;
    @Before
    public void setUp() {
        this.driver = new ChromeDriver();
    }
    @Test
    @Description("Тестовый тест")
    public void testHello1() {
        driver.get("https://lm.skillbox.cc/qa_tester/module01/");
        driver.findElement(By.name("name")).sendKeys("Вася");
        driver.findElement(By.className("button")).click();
        var actualResult = driver.findElement(By.className("start-screen")).getText();
        var expectedResult = "Привет, Вася!";
        Assert.assertEquals(expectedResult,actualResult);
    }
    @Test
    @Description("Тестовый тест")
    public void testHello2() {
        driver.get("https://lm.skillbox.cc/qa_tester/module01/");
        driver.findElement(By.name("name")).sendKeys("Leco");
        driver.findElement(By.className("button")).click();
        var actualResult = driver.findElement(By.className("start-screen")).getText();
        var expectedResult = "Привет, Leco!";
        Assert.assertEquals(expectedResult,actualResult);
    }
    @After
    public void tearDown() {
        driver.quit();
    }

}
