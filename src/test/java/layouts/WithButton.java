package layouts;

import io.qameta.atlas.webdriver.AtlasWebElement;
import io.qameta.atlas.webdriver.extension.FindBy;
import io.qameta.atlas.webdriver.extension.Param;

public interface WithButton {

    @FindBy(".//*[contains(@value,'{{ value }}')]")
    AtlasWebElement selectButton(@Param("value") String value);

}
