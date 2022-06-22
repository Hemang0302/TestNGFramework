import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class TestNGHappyFlow {
    WebDriver driver;


    @Test(priority = 1)
    void openBrowser() {
        System.out.println("Open Browser");
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demo.nopcommerce.com/");
    }

    @Test(priority = 2)
    void selectComputer() {
        System.out.println("Select Computer");
        driver.findElement(By.xpath("/html/body/div[6]/div[2]/ul[1]/li[1]/a")).click();
    }

    @Test(priority = 3)
    void selectDesktop() {
        System.out.println("Select Desktop");
        driver.findElement(By.xpath("/html/body/div[6]/div[3]/div/div[3]/div/div[2]/div[1]/div/div[1]/div/h2/a")).click();
    }

    @Test(priority = 4)
    void addCart() {
        System.out.println("Add Cart Lenova IdeaCenter 600");
        driver.findElement(By.xpath("/html/body/div[6]/div[3]/div/div[3]/div/div[2]/div[2]/div[2]/div/div/div[3]/div/div[2]/div[3]/div[2]/button[1]")).click();
    }

    @Test(priority = 5)
    void goToShoppingCart() {
        System.out.println("Go to Shopping Cart");
        driver.findElement(By.xpath("//*[@id=\"topcartlink\"]/a/span[1]")).click();
        //Alert alert = driver.switchTo().alert();
        //System.out.println(alert.getText());
        //  alert.accept();
        //driver.quit();
    }

    @Test(priority = 6)
    void cartUpdateQuantity() {
        System.out.println("Cart update Quantity");
        driver.findElement(By.className("qty-input")).click();
        driver.findElement(By.className("qty-input")).clear();
        driver.findElement(By.className("qty-input")).sendKeys("3");
        driver.findElement(By.id("updatecart")).click();
    }

    @Test(priority = 7)
    void checkout() {
        System.out.println("agree terms and check out");
        driver.findElement(By.id("termsofservice")).click();
        driver.findElement(By.id("checkout")).click();

    }

    @Test(priority = 8)
    void checkoutAsGuest() throws InterruptedException {
        System.out.println("check out as Guest");
        driver.findElement(By.xpath("/html/body/div[6]/div[3]/div/div/div/div[2]/div[1]/div[1]/div[3]/button[1]")).click();
        driver.findElement(By.id("BillingNewAddress_FirstName")).sendKeys("Hemang");
        driver.findElement(By.id("BillingNewAddress_LastName")).sendKeys("Patel");
        driver.findElement(By.id("BillingNewAddress_Email")).sendKeys("Tester@gmail.com");
        Select drpCountry = new Select(driver.findElement(By.id("BillingNewAddress_CountryId")));
        drpCountry.selectByVisibleText("United Kingdom");
        driver.findElement(By.id("BillingNewAddress_City")).sendKeys("Leicester");
        driver.findElement(By.id("BillingNewAddress_Address1")).sendKeys("101 Humberstone Lane");
        driver.findElement(By.id("BillingNewAddress_ZipPostalCode")).sendKeys("Le10BH");
        driver.findElement(By.id("BillingNewAddress_PhoneNumber")).sendKeys("078745465");
        driver.findElement(By.id("BillingNewAddress_FaxNumber")).sendKeys("07845475");
        driver.findElement(By.xpath("//*[@id=\"billing-buttons-container\"]/button[4]")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//input[@id='shippingoption_1' and@value='Next Day Air___Shipping.FixedByWeightByTotal']")).click();
        driver.findElement(By.xpath("//button[@class='button-1 shipping-method-next-step-button']")).click();

    }
@Test(priority = 9)
    void Payment() throws InterruptedException {
    System.out.println("Payment Method to enter");
    Thread.sleep(1000);
    driver.findElement(By.xpath("//input[@id='paymentmethod_1' and @value='Payments.Manual']")).click();
    driver.findElement(By.xpath("//*[@id=\"payment-method-buttons-container\"]/button")).click();
    Thread.sleep(500);
    Select cardType = new Select(driver.findElement(By.id("CreditCardType")));
    cardType.selectByVisibleText("Master card");
    driver.findElement(By.xpath("//*[@id=\"CardholderName\"]")).sendKeys("Tester");
    driver.findElement(By.xpath("//*[@id=\"CardNumber\"]")).sendKeys("8745456445454512");
    Thread.sleep(500);
    Select expMonth = new Select(driver.findElement(By.id("ExpireMonth")));
    expMonth.selectByVisibleText("08");
    Select expYear = new Select(driver.findElement(By.id("ExpireYear")));
    expYear.selectByVisibleText("2025");
    driver.findElement(By.xpath("//*[@id=\"CardCode\"]")).sendKeys("854");
    driver.findElement(By.xpath("//*[@id=\"payment-info-buttons-container\"]/button")).click();
}

    }





