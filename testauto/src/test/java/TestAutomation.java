import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import steps.Steps;

public class TestAutomation {
    private Steps steps;
    private final String USERNAME = "dragao11";
    private final String PASSWORD = "zxcasdqwe1";
    private final String COMMENT = "Отлично!";

    @BeforeMethod(description = "Init browser")
    public void setUp()
    {
        steps = new Steps();
        steps.initBrowser();
    }
    @Test(description = "Login to GG")
    public void oneCanLogin()
    {
        steps.login(USERNAME, PASSWORD);
        Assert.assertTrue(steps.isLoggedIn(USERNAME));
    }
    @Test(description = "Follow channel")
    public void oneCanFollowChannel()
    {
        steps.login(USERNAME, PASSWORD);
        steps.followChannel();
        Assert.assertTrue(steps.isChannelFollowed());
    }
    @Test(description = "Post a comment")
    public void oneCanPostComment()
    {
        steps.login(USERNAME, PASSWORD);
        steps.postComment(COMMENT);
        Assert.assertTrue(steps.isCommentAdded(COMMENT));
    }
    @Test(description = "Enter competition")
    public void oneCanEnterCompetition()
    {
        steps.login(USERNAME, COMMENT);
        steps.enterCompetition();
        Assert.assertTrue(steps.isCompetitionEntered());
    }
    @Test(description = "Watch followings")
    public void oneCanOpenFollowings()
    {
        steps.login(USERNAME, PASSWORD);
        steps.watchFollowing();
        Assert.assertTrue(steps.isFollowingOpened());
    }
    @AfterMethod(description = "Stop Browser")
    public void stopBrowser()
    {
        steps.closeDriver();
    }
}
