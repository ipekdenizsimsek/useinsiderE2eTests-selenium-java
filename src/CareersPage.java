import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CareersPage {


    private WebDriver driver;

    @FindBy(xpath = "//*[@id=\"page-head\"]/div/div/div[1]/div/div/a")
    private WebElement findYourDreamJobBtn;

    @FindBy(id = "location-slider")
    private WebElement locationSliderSection;

    @FindBy(id = "find-job-widget")
    private WebElement findJobWidget;

    @FindBy(xpath = "/html/body/div[1]/div/div/section[4]/div/div/div/div/div/div[1]/div/h2")
    private WebElement lifeAtInsiderText;

    @FindBy(id = "career-find-our-calling")
    private WebElement teamsSection;

    CareersPage(WebDriver driver) throws InterruptedException {
        this.driver = driver;
        Thread.sleep(3000);
        PageFactory.initElements(driver, this);
    }

    public void clickFindYourDreamsBtn() {
        this.findYourDreamJobBtn.click();
    }

    public void validatePage() {
        driver.findElement(By.id("location-slider"));
        driver.findElement(By.id("find-job-widget"));
        driver.findElement(By.id("career-find-our-calling"));
        driver.findElement(By.xpath("/html/body/div[1]/div/div/section[4]/div/div/div/div/div/div[1]/div/h2"));
        driver.findElement(By.xpath("//*[@id=\"page-head\"]/div/div/div[1]/div/div/a"));
    }


}

