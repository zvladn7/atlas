package extension;


import io.qameta.atlas.core.Atlas;
import io.qameta.atlas.core.api.MethodExtension;
import io.qameta.atlas.core.api.Target;
import io.qameta.atlas.core.internal.Configuration;
import io.qameta.atlas.core.target.LazyTarget;
import io.qameta.atlas.core.util.MethodInfo;
import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebElement;

import java.lang.reflect.Method;
import java.util.Optional;

import static java.lang.String.format;

public class FindToolbarButtonExtension implements MethodExtension {


    @Override
    public Object invoke(Object proxy, MethodInfo methodInfo, Configuration config) throws Throwable {
        assert proxy instanceof SearchContext;
        String text = methodInfo.getMethod().getAnnotation(ToolbarButtonContainText.class).value();
        Optional<String> parameter = methodInfo.getParameter(String.class);
        if (text.equals("{{ value }}")) {
            text = parameter.get();
        }
        String xpath = format(".//*[@class='toolbar_nav_i_ic']/div[text()='%s']", text);
        SearchContext context = (SearchContext) proxy;
        WebElement element = context.findElement(By.xpath(xpath));
        final Target target = new LazyTarget("name", () -> element);
        return new Atlas().create(target, methodInfo.getMethod().getReturnType());
    }

    @Override
    public boolean test(Method method) {
        return method.isAnnotationPresent(ToolbarButtonContainText.class);
    }
}
