import jdk.jfr.Description;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HomeworkFour {
    private static WebDriver driver;
    @BeforeClass
    public static void setUp() {
        driver = new ChromeDriver();
    }
    @AfterClass
    public static void tearDown() {
        driver.quit();
    }
    String url = "http://qajava.skillbox.ru/module04/lesson3/index.html";
    private By nameField = By.cssSelector(".form-input.fio");
    private By streetField = By.cssSelector(".form-input.street");
    private By houseField = By.cssSelector(".form-input.house");
    private By flatField = By.cssSelector(".form-input.flat");
    private By dateField = By.cssSelector(".form-input.date");
    private By submitButton = By.className("form-submit");
    private By showwNameField = By.cssSelector(".fio.data.show-fio");
    private By showStreet = By.cssSelector(".show-street");
    private By showHouse = By.cssSelector(".show-house");
    private By showFlat = By.cssSelector(".show-flat");
    private By showDate = By.cssSelector(".show-date");

    @Test
    @Description("Создание заявки на вызов мастера")
    public void masterTicket() {
        String name = "Геннадий";
        String street = "Садовая";
        String house = "33";
        String flat = "123";
        String date = "22.05,2023";
        driver.get(url);
        driver.findElement(nameField).sendKeys(name);
        driver.findElement(streetField).sendKeys(street);
        driver.findElement(houseField).sendKeys(house);
        driver.findElement(flatField).sendKeys(flat);
        driver.findElement(dateField).sendKeys(date);
        driver.findElement(submitButton).click();
        Assert.assertTrue("Поле с именем не отображается",driver.findElement(showwNameField).isDisplayed());
        Assert.assertEquals("Ошибка в поле с именем","\"Геннадий\"",driver.findElement(showwNameField).getText());
        Assert.assertTrue("Поле с улицей не отображается",driver.findElement(showStreet).isDisplayed());
        Assert.assertEquals("Ошибка в поле с улицей","\"Садовая\"",driver.findElement(showStreet).getText());
        Assert.assertTrue("Поле с домом не отображается",driver.findElement(showHouse).isDisplayed());
        Assert.assertEquals("Ошибка в поле с домом","\"33\"",driver.findElement(showHouse).getText());
        Assert.assertTrue("Поле с квартирой не отображается",driver.findElement(showFlat).isDisplayed());
        Assert.assertEquals("Ошибка в поле с квартирой","\"123\"",driver.findElement(showFlat).getText());
        Assert.assertTrue("Поле с датой не отображается",driver.findElement(showDate).isDisplayed());
        Assert.assertEquals("Ошибка в поле с датой","\"22.05,2023\"",driver.findElement(showDate).getText());
    }
}
