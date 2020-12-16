package layouts;

import io.qameta.atlas.webdriver.AtlasWebElement;
import io.qameta.atlas.webdriver.extension.FindBy;
import io.qameta.atlas.webdriver.extension.Param;

public interface WithInput {

    @FindBy(".//label[text()='{{ value }}']/../..//input")
    AtlasWebElement selectInput(@Param("value") String value);

}
