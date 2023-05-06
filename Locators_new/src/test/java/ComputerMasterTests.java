import jdk.jfr.Description;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ComputerMasterTests {
    private static WebDriver driver;
    @BeforeClass
    public static void setUp() {
        driver = new ChromeDriver();
    }
    @AfterClass
    public static void tearDown() {
        driver.quit();
    }

    private By nameLocator = By.cssSelector(".data.text");
    private By emailLocator = By.cssSelector(".data.field");
    private By commentField = By.cssSelector(".field.text");
    private By submitButton = By.id("comment");

    @Test
    @Description("Отправка комментария")
    public void sendComment() {
        String email = "tets@mail.com";
        String name = "Тестерито";
        String comment = "Этот комментарий содержит в себе много благодарственных слов!!!";
        driver.get("http://qajava.skillbox.ru/module04/lesson3/os.html");
        driver.findElement(nameLocator).sendKeys(name);
        driver.findElement(emailLocator).sendKeys(email);
        driver.findElement(commentField).sendKeys(comment);
        driver.findElement(submitButton).click();
        Assert.assertTrue("Сообщения с благодарностью нет",driver.findElement(By.className("message-header")).isDisplayed());
    }


}
