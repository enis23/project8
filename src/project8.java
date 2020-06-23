
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class project8 {

    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\k-eni\\Desktop\\Selenium\\chromedriver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://test-basqar.mersys.io");
        driver.manage().window().maximize();
        driver.findElement(By.cssSelector("[formcontrolname=\"username\"]")).sendKeys("admin");
        driver.findElement(By.cssSelector("[formcontrolname=\"password\"]")).sendKeys("admin");
        driver.findElement(By.cssSelector("button[aria-label=\"LOGIN\"]")).click();

        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

        driver.findElement(By.xpath("//span[contains(text(),'Setup')]")).click();
        driver.findElement(By.xpath("//span[contains(text(),'Parameters')]")).click();
        driver.findElement(By.xpath("//span[contains(text(),'Nationalities')]")).click();

        WebDriverWait wait = new WebDriverWait( driver, 5 );

        driver.findElement(By.xpath("//*[@class='mat-mini-fab mat-button-base mat-accent']")).click();
        List<WebElement> list = driver.findElements(By.xpath("//*[@class='mat-form-field-infix']//child::input"));
        String randomString=getRandomString(8);
        list.get(1).sendKeys(randomString);
        driver.findElement(By.xpath("//*[contains(text(),'Save')]")).click();
        driver.findElement(By.xpath("//*[contains(text(),'Edit')]")).click();

    }

    private static String getRandomString(int i) {
        String letters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        StringBuilder randomStr = new StringBuilder();

        for (int j = 0; j < i; j++) {
            int random = new Random().nextInt(letters.length());
            randomStr.append(letters.charAt(random));
        }
        return randomStr.toString();

    }
}
