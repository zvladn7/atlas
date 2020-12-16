package pages;

import io.qameta.atlas.webdriver.WebPage;
import layouts.WithButton;
import layouts.WithErrorMsg;
import layouts.WithInput;

public interface LoginPage extends WebPage, WithInput, WithButton, WithErrorMsg {
}
