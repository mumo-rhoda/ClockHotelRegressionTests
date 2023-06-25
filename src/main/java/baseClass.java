import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class baseClass {

public static Properties prop;
public static WebDriver driver;

public void loadConfig() {
    try {

        prop = new Properties();

        FileInputStream fileconf = new FileInputStream("Configuration/config.properties");

        prop.load(fileconf);
    } catch (FileNotFoundException e) {
        e.printStackTrace();
    } catch (IOException e) {
        e.printStackTrace();
    }
}
    public static void launchApplication() {

        if (prop.getProperty("browser").equalsIgnoreCase("edge")) {
            System.setProperty("webdriver.edge.driver", "drivers/msedgedriver.exe");
            driver = new EdgeDriver();
        } else if (prop.getProperty("browser").equalsIgnoreCase("Firefox")) {
            System.setProperty("webdriver.gecko.driver", "drivers/geckodriver.exe");
            driver = new FirefoxDriver();
        } else if (prop.getProperty("browser").equalsIgnoreCase("chrome")) {
            //System.setProperty("webdriver.chrome.drive", "drivers/chromedriver.exe");
            //driver =new ChromeDriver();
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--remote-allow-origins=*");
            driver = new ChromeDriver(options);
        }
        driver.manage().window().maximize();
        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        //driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        //Launching the URL
        driver.get(prop.getProperty("url"));
    }

}

