import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.junit.Assert;

public class HomePage {

    private WebDriver driver;
    private final String expectedPageTitle = "Insider | Platform for individualized, cross-channel customer experiences"; // HTML field title, if available page loaded.


    @FindBy(xpath = "/html/body/nav/div[2]/div/ul[1]/li[5]/a")
    private WebElement moreButton;

    private String careersButtonXpath = "//*[@id=\"navbarNavDropdown\"]/ul[1]/li[5]/div/div[1]/div[3]/div/a";

    public HomePage (WebDriver driver, String pageUrl) {
        this.driver=driver;
        driver.get(pageUrl);
        PageFactory.initElements(driver, this);
    }


    public void clickMoreButton() {
        this.moreButton.click();
    }

    public void findAndClickCareersButton() {
        this.driver.findElement(By.xpath(careersButtonXpath)).click();
    }

    public void validatePage() {
        Assert.assertTrue(expectedPageTitle.equals(driver.getTitle()));
    }
}
