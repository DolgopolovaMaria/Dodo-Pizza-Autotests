package helpers;

import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.WebDriver;

import static com.codeborne.selenide.Selenide.getUserAgent;
import static io.restassured.RestAssured.given;

public class ApiHelper {

    static String rerfName = "rerf",
            ipp_uidName = "ipp_uid",
            workflowIdName = "WorkflowId",
            ipp_keyName = "ipp_key";

    public static void addProductToCart(String producctBodyId, String productHeaderId) {
        String userAgent = getUserAgent();

        WebDriver driver = WebDriverRunner.getWebDriver();
        String rerfValue = driver.manage().getCookieNamed(rerfName).getValue();
        String ipp_uidValue = driver.manage().getCookieNamed(ipp_uidName).getValue();
        String workflowIdValue = driver.manage().getCookieNamed(workflowIdName).getValue();
        String ipp_keyValue = driver.manage().getCookieNamed(ipp_keyName).getValue();

        given()
                .log().uri()
                .log().body()
                .log().cookies()
                .when()
                .formParam("productId", producctBodyId)
                .contentType("application/x-www-form-urlencoded")
                .accept("*/*")
                .header("Accept-Language", "ru-RU,ru;q=0.9,en-US;q=0.8,en;q=0.7")
                .header("Cache-Control", "max-age=0")
                .header("Connection", "keep-alive")
                .header("Origin", "https://dodopizza.ru")
                .header("Referer", "https://dodopizza.ru/peterburg/vokzalnaya7?product=" + productHeaderId)
                .header("Sec-Fetch-Dest", "empty")
                .header("Sec-Fetch-Mode", "cors")
                .header("Sec-Fetch-Site", "same-origin")
                .header("X-Requested-With", "XMLHttpRequest")
                .header("User-Agent", userAgent)
                .cookies(rerfName, rerfValue)
                .cookies(ipp_uidName, ipp_uidValue)
                .cookies(workflowIdName, workflowIdValue)
                .cookies(ipp_keyName, ipp_keyValue)
                .post("https://dodopizza.ru/api/workflow/cart/product")
                .then()
                .log().status()
                .log().body()
                .statusCode(200);
    }
}
