import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SocksSiteTests {
    private static WebDriver driver;
    @BeforeClass
    public static void setUp() {
        driver = new ChromeDriver();
    }
    @AfterClass
    public static void tearDown() {
        driver.quit();
    }
}
