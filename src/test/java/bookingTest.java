import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class bookingTest extends baseClass{
    chooseDeluxe ChooseDeluxe;

    @BeforeSuite
    public void setup(){
        loadConfig();launchApplication();
        System.out.println("Configuration and browser initialized");
    }
    @AfterSuite
    public void close(){
        System.out.println("Last method");
        driver.quit();
    }
    @Test
    public void bookhotel(){
        ChooseDeluxe = new chooseDeluxe();
        boolean result = ChooseDeluxe.validateLogo();
        Assert.assertTrue(result);

    }
}
