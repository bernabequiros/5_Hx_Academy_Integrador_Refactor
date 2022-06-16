import hexacta.driver.WebDriverManager;
import org.junit.After;
import org.openqa.selenium.WebDriver;
import java.time.Duration;

public class BaseTest {
    protected WebDriver driver;

    public BaseTest() {
        this.driver = WebDriverManager.getCurrentInstance().getCurrentDriver();
        this.driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
        this.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        this.driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(10));
        this.driver.manage().window().maximize();
    }

    public void goBack() {
        this.driver.navigate().back();
    }


    public void navigateTo(String url) {
        this.driver.get(url);
    }

    @After
    public void tearDown() {
        WebDriverManager.getCurrentInstance().destroy();
    }

}