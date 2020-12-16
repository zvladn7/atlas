package layouts;

import element.FriendsDropDownList;
import io.qameta.atlas.core.api.Retry;
import io.qameta.atlas.webdriver.extension.FindBy;

public interface WithToolbar extends  WithToolbarButton {

    @FindBy(".//div[@id='toolbar_search']")
    @Retry(timeout = 10000, polling = 1000)
    FriendsDropDownList search();

}
