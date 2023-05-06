import jdk.jfr.Description;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class KittensTests {
    private static WebDriver driver;
    @BeforeClass
    public static void setUp() {
        driver = new ChromeDriver();
    }
    @AfterClass
    public static void tearDown() {
        driver.quit();
    }
    private By emailLocator = By.className("email");
    private By writeToMeButtonLocator = By.id("write-to-me");
    private By resultEmailLocator = By.className("result-email");
    private By typeAnotherEmailLocator = By.id("anotherEmail");
    @Test
    @Description("Тест на поле для ввода емейл")
    public void emailField () {
        String email = "test@sus.com";
        driver.get("http://qajava.skillbox.ru/module04/lesson2/");
        driver.findElement(emailLocator).sendKeys(email);
        driver.findElement(writeToMeButtonLocator).click();
        Assert.assertTrue("Текст с емейл не отображается",driver.findElement(resultEmailLocator).isDisplayed());
        Assert.assertEquals("Ошибка в отображаемом емейл",email,driver.findElement(resultEmailLocator).getText());
    }
    @Test
    @Description("Тест на отправку заявки без указания почты")
    public void emailField2 () {
        driver.get("http://qajava.skillbox.ru/module04/lesson2/");
        driver.findElement(writeToMeButtonLocator).click();
        Assert.assertTrue("Кнопка для ввода другого емейл не отображается",driver.findElement(typeAnotherEmailLocator).isDisplayed());

    }

}
