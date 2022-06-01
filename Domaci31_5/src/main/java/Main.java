
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

//Napisati dva smoke testa za https://www.telerik.com/support/demos:
//Proveriti da klikom na Desktop odlazimo na tu sekciju
//Proveriti da klikom na Mobile odlazimo na tu sekciju
//Koristiti TestNG, asserte.
//Domaći na git
public class Main {
    private WebDriver driver;
    @BeforeClass
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\mlade\\IdeaProjects\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver();   
    }
    @BeforeMethod
    public void beforeMethod(){
        driver.navigate().to("https://www.telerik.com/support/demos");
        driver.manage().window().maximize();
    }
    @AfterClass
    public void afterClass(){
        driver.close();
    }
    // ne znam da li je trebalo da se testira da li skroluje do te sekcije ili samo naslov sekcije
    // u svakom slucaju ne bih ni znao da odradim za skrolovanje ;D
    @Test
    public void testDesktopTitle() {
        WebElement desktop = driver.findElement(By.xpath("//*[@id=\"ContentPlaceholder1_T53129E6C012_Col00\"]/nav/div/div[2]/a[2]"));
        desktop.click();
        WebElement desktopSection = driver.findElement(By.id("desktop"));
        String expectedTitle = "Desktop";
        String actualTitle = desktopSection.getText();
        Assert.assertEquals(actualTitle, expectedTitle);
    }
    @Test
    public void testMobileTitle(){
        WebElement mobile = driver.findElement(By.xpath("//*[@id=\"ContentPlaceholder1_T53129E6C012_Col00\"]/nav/div/div[2]/a[3]"));
        mobile.click();
        WebElement mobileSection = driver.findElement(By.id("mobile"));
        String expectedTitle = "Mobile";
        String actualTitle = mobileSection.getText();
        Assert.assertEquals(actualTitle, expectedTitle);
    }
}
