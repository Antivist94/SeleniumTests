import jdk.jfr.Description;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Movie {
    private WebDriver driver;
    @Before
    public void setUp() {
        this.driver = new ChromeDriver();
    }
    @Test
    @Description("Тест №1. Регистрация")
    public void test1 () {
        driver.get("https://lm.skillbox.cc/qa_tester/module06/register/");
        driver.findElement(By.id("name")).sendKeys("Любое");
        driver.findElement(By.id("email")).sendKeys("skillbox@test.ru");
        driver.findElement(By.id("password")).sendKeys("qwerty!123");
        driver.findElement(By.className("form-submit")).click();
        var actualResult = driver.findElement(By.className("form-result")).getText();
        var expectedResult = "Вам на почту skillbox@test.ru отправлено письмо";
        Assert.assertEquals(expectedResult,actualResult);
    }
    @Test
    @Description("Тест №2. Регистрация без заполнения обязательных полей")
    public void test2 () {
        driver.get("https://lm.skillbox.cc/qa_tester/module06/register/");
        driver.findElement(By.className("form-submit")).click();
        var actualResult = driver.findElement(By.className("form-errors")).getText();
        var expectedResult = "Некорректный email или пароль";
        Assert.assertEquals(actualResult,expectedResult);
    }
    @Test
    @Description("Тест №3. Поиск полей на сайте онлайн-кинотеатра")
    public void testLocators () {
        driver.get("https://lm.skillbox.cc/qa_tester/module05/practice1/");
        driver.findElement(By.id("email")).sendKeys("idfield@test.com");
        driver.findElement(By.name("password")).sendKeys("123qwerty");
        driver.findElement(By.id("confirm_password")).sendKeys("123qwerty");
    }
    @Test
    @Description("Магазин обуви, тест №1. Позитивный тест + тест на ГЗ, выбор 44 размера обуви.")
    public void testShoesShop1 () {
        driver.get("https://lm.skillbox.cc/qa_tester/module03/practice1/");
        driver.findElement(By.id("size")).sendKeys("44");
        driver.findElement(By.id("check-size-button")).click();
        var actualResult = driver.findElement(By.id("size-success")).getText();
        var expectedResult = "В нашем магазине есть обувь вашего размера";
        Assert.assertEquals(actualResult,expectedResult);
    }
    @Test
    @Description("Магазин обуви, тест №2. Тест на ГЗ, выбор 34 размера обуви.")
    public void testShoesShop2 () {
        driver.get("https://lm.skillbox.cc/qa_tester/module03/practice1/");
        driver.findElement(By.tagName("input")).sendKeys("34");
        driver.findElement(By.tagName("button")).click();
        var actualResult = driver.findElement(By.id("size-success")).getText();
        var expectedResult = "В нашем магазине есть обувь вашего размера";
        Assert.assertEquals(actualResult,expectedResult);
    }
    @Test
    @Description("Магазин обуви, тест №3. Тест на ГЗ, выбор 33 размера обуви.")
    public void testShoesShop3 () {
        driver.get("https://lm.skillbox.cc/qa_tester/module03/practice1/");
        driver.findElement(By.name("check")).sendKeys("33");
        driver.findElement(By.id("check-size-button")).click();
        var actualResult = driver.findElement(By.tagName("label")).getText();
        var expectedResult = "В нашем магазине нет обуви вашего размера";
        Assert.assertEquals(actualResult,expectedResult);
    }
    @Test
    @Description("Магазин обуви, тест №4. Тест на ГЗ, выбор 45 размера обуви.")
    public void testShoesShop4 () {
        driver.get("https://lm.skillbox.cc/qa_tester/module03/practice1/");
        driver.findElement(By.id("size")).sendKeys("45");
        driver.findElement(By.tagName("button")).click();
        var actualResult = driver.findElement(By.id("size-error")).getText();
        var expectedResult = "В нашем магазине нет обуви вашего размера";
        Assert.assertEquals(actualResult,expectedResult);
    }
    @Test
    @Description("Магазин обуви, тест №5. Тест на пустое поле.")
    public void testShoesShop5 () {
        driver.get("https://lm.skillbox.cc/qa_tester/module03/practice1/");
        driver.findElement(By.id("check-size-button")).click();
        var actualResult = driver.findElement(By.tagName("label")).getText();
        var expectedResult = "Введите размер обуви!";
        Assert.assertEquals(actualResult,expectedResult);
    }
    @Test
    @Description("(-)Магазин обуви, тест №6. Тест на некорректный ввод поле значений.")
    public void negativeTestShoesShop1 () {
        driver.get("https://lm.skillbox.cc/qa_tester/module03/practice1/");
        driver.findElement(By.name("check")).sendKeys("&uhfa9");
        driver.findElement(By.tagName("button")).click();
        var actualResult = driver.findElement(By.tagName("label")).getText();
        var expectedResult = "Введите размер обуви!";
        Assert.assertEquals(actualResult,expectedResult);
    }
    @After
    public void tearDown() {
        driver.quit();
    }
}
