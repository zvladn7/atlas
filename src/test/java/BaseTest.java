import extension.FindToolbarButtonExtension;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.atlas.core.Atlas;
import io.qameta.atlas.webdriver.WebDriverConfiguration;
import io.qameta.atlas.webdriver.extension.ExtractMethodExtension;
import io.qameta.atlas.webdriver.extension.FilterCollectionExtension;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.opera.OperaDriver;
import pages.LoginPage;
import site.Site;

public class BaseTest {
    protected static String BOT_LOGIN = "TechoBot8";
    protected static String BOT_PASSWORD = "TechnoPolis19";
    private Atlas atlas;
    private WebDriver driver;

    @Before
    public void startDriver() {
        WebDriverManager.operadriver().setup();
        driver = new OperaDriver();
        atlas = new Atlas(new WebDriverConfiguration(driver, "https://ok.ru/"))
                .extension(new FindToolbarButtonExtension())
                .extension(new ExtractMethodExtension())
                .extension(new FilterCollectionExtension());
        LoginPage loginPage = onSite().onLoginPage();
        loginPage.selectInput("Телефон или адрес эл. почты").sendKeys(BOT_LOGIN);
        loginPage.selectInput("Пароль").sendKeys(BOT_PASSWORD);
        loginPage.selectButton("Войти в Одноклассники").click();
    }


    protected Site onSite() {
        return atlas.create(driver, Site.class);
    }

    @After
    public void stopDriver() {
        driver.quit();
    }

}
