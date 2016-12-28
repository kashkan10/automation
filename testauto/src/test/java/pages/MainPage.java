package pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;


public class MainPage extends AbstractPage {
    private final Logger logger = LogManager.getRootLogger();
    private final String BASE_URL = "https://goodgame.ru/";

    @FindBy(xpath = "//*[@id=\"top\"]/div[2]/div/a")
    private WebElement title;

    @FindBy(xpath = "/html/body/div[1]/div[3]/div[4]/div[2]/ul/li[1]/a/span")
    private WebElement faveButton;

    @FindBy(xpath = "//*[@id=\"top\"]/div[1]/ul/li[3]/a")
    private WebElement competitionLink;

    @FindBy(xpath = "//*[@id=\"entire\"]/div[1]/div/div/div[2]/div/div/div[2]/div/div[1]/div[1]/a")
    private WebElement compLink;

    @FindBy(xpath = "//*[@id=\"entire\"]/div[1]/div/div[1]/div[2]/div/div/div/div[1]/div/div[3]/a")
    private WebElement enterButton;

    @FindBy(xpath = "//*[@id=\"entire\"]/div[1]/div/div[1]/div[2]/ng-include/div/h2")
    private WebElement titleCompetition;

    public MainPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }
    @Override
    public void openPage()
    {
        driver.navigate().to(BASE_URL);
    }

    public String getLoggedInUserName() { return title.getText(); }

    public void watchFollowing()
    { faveButton.click();  }

    public String getFavesAttribute() { return faveButton.getAttribute("class");}

    public void enterCompetition()
    {
        competitionLink.click();
        compLink.click();
        enterButton.click();
    }
    public String getTitleCompetition()
    {
        return titleCompetition.getText();
    }
}
