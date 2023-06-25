import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class chooseDeluxe extends baseClass {

    @FindBy(xpath = "//*[@id=\"date-start\"]")
    WebElement arrivaldate;
    @FindBy(xpath = "//*[@id=\"to-place\"]")
    WebElement nightsTospent;
    @FindBy(xpath = "//*[@id=\"flights\"]/form/div/div[3]/div/input")
    WebElement AdultsNumber;
    @FindBy(xpath = "//*[@id=\"flights\"]/form/div/div[4]/section/input")
    WebElement ChildrenNumber;
    @FindBy(xpath = "//*[@id=\"clockdemo-page\"]/div[2]/div[2]/div/div/div/div[1]/div/ul/li/a")
    WebElement checkavailability;
    @FindBy(xpath = "//*[@id=\"flights\"]/form/div/div[5]/input")
    WebElement bookNow;
    @FindBy(xpath = "/html/body/div[1]/div/div[1]/header/div/div/div/h1/a/img")
    WebElement logo;
    //initialize constructor

    public chooseDeluxe(){
        PageFactory.initElements(driver,this);
    }
public boolean validateLogo(){
        return logo.isDisplayed();
}
public checkAvailabilityObjects booking(String arrival, String nightstospent, String adultsnum, String childrennum){
        arrivaldate.sendKeys(arrival);
    nightsTospent.sendKeys(nightstospent);
    AdultsNumber.sendKeys(adultsnum);
    ChildrenNumber.sendKeys(childrennum);
    bookNow.click();
    return new checkAvailabilityObjects();
}
}
