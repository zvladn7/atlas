package layouts;

import extension.ToolbarButtonContainText;
import io.qameta.atlas.webdriver.AtlasWebElement;
import io.qameta.atlas.webdriver.extension.Param;

public interface WithToolbarButton {

    @ToolbarButtonContainText("{{ value }}")
    AtlasWebElement selectToolbarButton(@Param("value") String value);

}
