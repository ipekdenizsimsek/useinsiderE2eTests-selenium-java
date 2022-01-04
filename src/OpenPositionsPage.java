import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class OpenPositionsPage {
    private WebDriver driver;


    @FindBy(xpath = "//*[@id=\"filter-by-location\"]")
    private WebElement filterByLocationWebElement;

    @FindBy(xpath = "//*[@id=\"filter-by-department\"]")
    private WebElement filterByDepartmentWebElement;

    OpenPositionsPage(WebDriver driver) throws InterruptedException {
        this.driver = driver;
        Thread.sleep(3000);

        PageFactory.initElements(driver, this);
    }

    public void selectIstanbulTurkeyFromFilterByLocationSelect () throws InterruptedException {
        Select filterByLocationSelect = new Select(this.filterByLocationWebElement);
        filterByLocationSelect.selectByVisibleText("Istanbul, Turkey");
        Thread.sleep(3000);
    }

    public void selectQualityAssuranceFromFilterByDepartmentSelect () throws InterruptedException {
        Select filterByDepartmentSelect = new Select(this.filterByDepartmentWebElement);
        filterByDepartmentSelect.selectByVisibleText("Quality Assurance");
        Thread.sleep(3000);
    }

    public void checkJobListExists() {
        WebElement jobPostWidget = driver.findElement(By.id("career-position-list"));
    }

    public void clickApplyNowBtn() { // Click invisible button
        driver.findElement(By.xpath("//*[@id=\"jobs-list\"]/div[2]/div/a")).click();
    }

    public void scrollToJobPosts() throws InterruptedException {
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        jse.executeScript("window.scrollBy(0,565)");
        Thread.sleep(3000);
    }

    public void validateJobPosts() {
        List<WebElement> positionListItems = driver.findElements(By.className("position-list-item"));
        for (WebElement positionListItem: positionListItems) {
            Assert.assertTrue(positionListItem.findElement(By.className("position-title")).getText().contains("Quality Assurance"));
            Assert.assertTrue(positionListItem.findElement(By.className("position-location")).getText().contains("Istanbul, Turkey"));
            Assert.assertTrue(positionListItem.findElement(By.className("position-department")).getText().contains("Quality Assurance"));
        }
    }
}
