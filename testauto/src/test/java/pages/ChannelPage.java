package pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class ChannelPage extends AbstractPage {
    private final Logger logger = LogManager.getRootLogger();
    private final String BASE_URL = "https://goodgame.ru/channel/dragao11/";

    @FindBy(xpath = "//*[@id=\"entire\"]/div/div/div[2]/div/div[2]/div[1]/gg-subscribe/div/a/span[6]")
    private WebElement followButton;

    @FindBy(xpath = "//*[@id=\"entire\"]/div/div/div[2]/div/div[2]/div[1]/gg-subscribe/div/a/span[4]")
    private WebElement followedButton;

    @FindBy(xpath = "//*[@id=\"cke_1_contents\"]/div")
    private WebElement inputForm;

    @FindBy(xpath = "//*[@id=\"entire\"]/div/div/div[4]/div[2]/div/div[3]/div[2]/div/div[2]/div/a")
    private WebElement submitButton;

    @FindBy(xpath = "//*[@id=\"comment-4048411\"]/div/div/div/div[3]/div/p")
    private WebElement commentText;

    public ChannelPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }
    @Override
    public void openPage()
    {
        driver.navigate().to(BASE_URL);
    }

    public void followChannel()
    {
        followButton.click();
    }
    public String getFollowedTitle() {return followedButton.getText();}

    public void postComment(String comment)
    {
        ((JavascriptExecutor)driver).executeScript("window.scrollBy(" + 0 + "," + 10000 + ");");
        inputForm.sendKeys(comment);
        submitButton.click();
    }
    public String getCommentText() { return commentText.getText();}
}
