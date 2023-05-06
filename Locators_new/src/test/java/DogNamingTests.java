import jdk.jfr.Description;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DogNamingTests {
    private static WebDriver driver;
    @BeforeClass
    public static void setUp() {
        driver = new ChromeDriver();
    }
    @AfterClass
    public static void tearDown() {
        driver.quit();
    }
    private By emailLocator = By.name("email");
    private By boyButtonLocator = By.id("boy");
    private By girlButtonLocator = By.id("girl");
    private By submitButton = By.id("sendMe");
    private By resultTextLocator = By.className("result-text");
    private By resultEmail = By.className("your-email");
    private By anotherEmail = By.id("anotherEmail");

    @Test
    @Description("(+) выбрать мальчика и указать емейл")
    public void dogNameSiteTest1 () {
        String email = "test@dogmail.com";
        String expected = "Хорошо, мы пришлём имя для вашего мальчика на e-mail:";
        driver.get("http://qajava.skillbox.ru/module04/lesson2/practice/");
        driver.findElement(emailLocator).sendKeys(email);
        driver.findElement(boyButtonLocator).click();
        driver.findElement(submitButton).click();
        Assert.assertTrue("Сообщение не отображается",driver.findElement(resultTextLocator).isDisplayed());
        String actual =  driver.findElement(resultTextLocator).getText();
        Assert.assertEquals("В сообщении ошибка",expected,actual);
        Assert.assertEquals("В указанном емейл ошибка",email,driver.findElement(resultEmail).getText());
    }
    @Test
    @Description("(+) выбрать девочку и указать емейл")
    public void dogNameSiteTest2 () {
        String email = "testgirl@dogmail.com";
        String expected = "Хорошо, мы пришлём имя для вашей девочки на e-mail:";
        driver.get("http://qajava.skillbox.ru/module04/lesson2/practice/");
        driver.findElement(emailLocator).sendKeys(email);
        driver.findElement(girlButtonLocator).click();
        driver.findElement(submitButton).click();
        Assert.assertTrue("Сообщение не отображается",driver.findElement(resultTextLocator).isDisplayed());
        String actual =  driver.findElement(resultTextLocator).getText();
        Assert.assertEquals("В сообщении ошибка",expected,actual);
        Assert.assertEquals("В указанном емейл ошибка",email,driver.findElement(resultEmail).getText());
    }
    @Test
    @Description("Тест кнопки Указать другой емейл")
    public void dogNameSiteTest3 () {
        driver.get("http://qajava.skillbox.ru/module04/lesson2/practice/");
        driver.findElement(girlButtonLocator).click();
        driver.findElement(submitButton).click();
        driver.findElement(anotherEmail).click();
        String actual = driver.findElement(submitButton).getText().toLowerCase();
        Assert.assertEquals("Кнопка Подобрать имя не отображается","подобрать имя",actual);
    }
}