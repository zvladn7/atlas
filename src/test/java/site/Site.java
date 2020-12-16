package site;

import io.qameta.atlas.webdriver.WebSite;
import io.qameta.atlas.webdriver.extension.Page;
import pages.FeedPage;
import pages.LoginPage;

public interface Site extends WebSite {
    @Page
    LoginPage onLoginPage();

    @Page(url = "feed")
    FeedPage onFeedPage();

}