import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.atlas.core.Atlas;
import io.qameta.atlas.webdriver.WebDriverConfiguration;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.opera.OperaDriver;
import pages.LoginPage;
import site.Site;

import static ru.yandex.qatools.matchers.webdriver.DisplayedMatcher.displayed;


public class LoginTest {

    private Atlas atlas;
    private WebDriver driver;

    @Before
    public void startDriver() {
        WebDriverManager.operadriver().setup();
        driver = new OperaDriver();
        atlas = new Atlas(new WebDriverConfiguration(driver, "https://ok.ru/"));
    }

    @Test
    public void test() {
        LoginPage loginPage = onSite().onLoginPage();
        loginPage.selectButton("Войти в Одноклассники").click();
        loginPage.errorMsg("Введите логин").should(displayed());

        loginPage.selectInput("Телефон или адрес эл. почты").sendKeys("*");
        loginPage.selectButton("Войти в Одноклассники").click();
        loginPage.errorMsg("Введите пароль").should(displayed());

        loginPage.selectInput("Пароль").sendKeys("*");
        loginPage.selectButton("Войти в Одноклассники").click();
        loginPage.errorMsg("Неправильно указан логин и/или пароль").should(displayed());
    }

    private Site onSite() {
        return atlas.create(driver, Site.class);
    }

    @After
    public void stopDriver() {
        driver.quit();
    }
}
