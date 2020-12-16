package layouts;

import io.qameta.atlas.webdriver.AtlasWebElement;
import io.qameta.atlas.webdriver.extension.FindBy;
import io.qameta.atlas.webdriver.extension.Param;

public interface WithErrorMsg {

    @FindBy(".//div[text()='{{ value }}']")
    AtlasWebElement errorMsg(@Param("value") String value);

}
