package steps;

import driver.DriverWorker;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import pages.ChannelPage;
import pages.LoginPage;
import pages.MainPage;


public class Steps {
    private WebDriver driver;

    private final Logger logger = LogManager.getRootLogger();

    public void initBrowser()
    {   driver = DriverWorker.getDriver(); }

    public void closeDriver()
    {
        DriverWorker.closeDriver();
    }

    public void login(String username, String password)
    {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.openPage();
        loginPage.login(username, password);
        MainPage mainPage = new MainPage(driver);
        mainPage.openPage();
    }
    public boolean isLoggedIn(String username)
    {
        MainPage mainPage = new MainPage(driver);
        logger.info(mainPage.getLoggedInUserName().trim());
        return (mainPage.getLoggedInUserName().trim().equals(username));
    }
    public void watchFollowing()
    {
        MainPage mainPage = new MainPage(driver);
        mainPage.watchFollowing();
    }
    public boolean isFollowingOpened() {
        MainPage mainPage = new MainPage(driver);
        return mainPage.getFavesAttribute().trim().equals("favorites ng-scope active");
    }
    public void followChannel()
    {
        ChannelPage channelPage = new ChannelPage(driver);
        channelPage.openPage();
        channelPage.followChannel();
    }
    public boolean isChannelFollowed() {
        ChannelPage channelPage = new ChannelPage(driver);
        return channelPage.getFollowedTitle().trim().equals("Вы подписаны");
    }
    public void postComment(String comment)
    {
        ChannelPage channelPage = new ChannelPage(driver);
        channelPage.openPage();
        channelPage.postComment(comment);
    }
    public boolean isCommentAdded(String comment)
    {
        ChannelPage channelPage = new ChannelPage(driver);
        return channelPage.getCommentText().trim().equals(comment);
    }
    public void enterCompetition()
    {
        MainPage mainPage = new MainPage(driver);
        mainPage.openPage();
        mainPage.enterCompetition();
    }
    public boolean isCompetitionEntered()
    {
        MainPage mainPage = new MainPage(driver);
        return mainPage.getTitleCompetition().trim().equals("Для участия в турнире вам нужно:");
    }
}
