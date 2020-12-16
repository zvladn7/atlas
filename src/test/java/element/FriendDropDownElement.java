package element;


import io.qameta.atlas.webdriver.AtlasWebElement;
import io.qameta.atlas.webdriver.extension.FindBy;

public interface FriendDropDownElement extends AtlasWebElement<FriendDropDownElement> {

    @FindBy(".//div[contains(@class,'card-section')]")
    AtlasWebElement<FriendDropDownElement> friend();

}