// @author: Ipek Deniz Simsek
// Tests for www.useinsider.com

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class InsiderTestMain {

    private final static String insiderWebsiteUrl = "https://useinsider.com/";
    private final static String chromeWebDriverPath = "/Users/ipekdenizsimsek/Desktop/Selenium/chromedriver";
    private final static int browserWidth = 1450;
    private final static int browserHeight = 1800;
    private final static boolean runInBackground = true;

    public static void main (String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", chromeWebDriverPath);

        ChromeOptions options = new ChromeOptions();

        if (runInBackground) {
            options.addArguments("--headless");
        }

        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().setSize(new Dimension(browserWidth, browserHeight));

        HomePage homePage = new HomePage(driver, insiderWebsiteUrl);
        homePage.validatePage();
        homePage.clickMoreButton();
        homePage.findAndClickCareersButton();

        CareersPage careersPage = new CareersPage(driver);
        careersPage.validatePage();
        careersPage.clickFindYourDreamsBtn();

        OpenPositionsPage openPositionsPage = new OpenPositionsPage(driver);
        openPositionsPage.checkJobListExists();
        openPositionsPage.selectIstanbulTurkeyFromFilterByLocationSelect();
        openPositionsPage.selectQualityAssuranceFromFilterByDepartmentSelect();
        openPositionsPage.scrollToJobPosts();
        openPositionsPage.validateJobPosts();
        openPositionsPage.clickApplyNowBtn();

        //Assert.assertTrue((driver.getCurrentUrl().contains("jobs.lever.co"))); // Does not work, due to new tab

        return;
    }
}
