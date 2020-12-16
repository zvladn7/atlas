package element;

import io.qameta.atlas.core.api.Retry;
import io.qameta.atlas.webdriver.AtlasWebElement;
import io.qameta.atlas.webdriver.ElementsCollection;
import io.qameta.atlas.webdriver.extension.FindBy;
import jdk.jfr.Description;
import org.openqa.selenium.WebElement;

public interface FriendsDropDownList extends AtlasWebElement<FriendsDropDownList> {

    @Description("Список друзей")
    @FindBy(".//div[contains(@class, 'user-card')]")
    @Retry(timeout = 2000, polling = 400)
    ElementsCollection<FriendDropDownElement> friendsList();

}
