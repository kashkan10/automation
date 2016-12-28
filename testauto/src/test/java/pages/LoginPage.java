package pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class LoginPage extends AbstractPage {
    private final Logger logger = LogManager.getRootLogger();
    private final String BASE_URL = "https://goodgame.ru/login/";

    @FindBy(xpath = "/html/body/div[1]/div/div/div[2]/div[1]/div[3]/div[1]/a")
    private WebElement logpassButton;

    @FindBy(id = "login-log")
    private WebElement inputLogin;

    @FindBy(id = "login-pass")
    private WebElement inputPassword;

    @FindBy(xpath = "/html/body/div[1]/div/div/div[2]/div[2]/div[2]/form/div[3]/input")
    private WebElement buttonSubmit;

    public LoginPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }
    @Override
    public void openPage()
    {
        driver.navigate().to(BASE_URL);
    }

    public void login(String username, String password)
    {
        logpassButton.click();
        inputLogin.sendKeys(username);
        inputPassword.sendKeys(password);
        buttonSubmit.click();
        buttonSubmit.click();
        logger.info("Login performed");
    }
}
