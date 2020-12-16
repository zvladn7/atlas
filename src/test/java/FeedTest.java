import org.junit.Test;
import pages.FeedPage;

import static org.hamcrest.Matchers.*;

public class FeedTest extends BaseTest {

    @Test
    public void test() {
        FeedPage feedPage = onSite().onFeedPage();
//        feedPage.selectToolbarButton("Сообщения").click();
        feedPage.search().click();
        feedPage.search().friendsList()
                .waitUntil(hasSize(greaterThan(0)))
//                .waitUntil(hasSize(equalTo(2)))
                .should(hasSize(lessThan(5)));
    }

}
