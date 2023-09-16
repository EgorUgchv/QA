package influential;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.net.URISyntaxException;
import java.time.Duration;
import java.util.Random;

public class SignUp {

    @Test
    public void signUp() throws URISyntaxException {
        System.setProperty("webdriver.chrome.driver", "src/main/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        Keys enter = Keys.ENTER;

        driver.get("https://demoqa.com/automation-practice-form");

        Duration Duration;
        WebDriverWait wait = new WebDriverWait(driver, java.time.Duration.ofSeconds(3));

        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector("form")));

        driver.findElement(By.id("firstName")).sendKeys("Borys");
        driver.findElement(By.id("lastName")).sendKeys("Voronov");

        Random random = new Random();

        int num = random.nextInt(60) +1;

        String email = "soft" + num + "@mail.com";

        driver.findElement(By.id("userEmail")).sendKeys(email);

        WebElement radioButton = driver.findElement(By.xpath("//div[@class = 'custom-control custom-radio custom-control-inline']/label[@for ='gender-radio-1']"));
        radioButton.click();

        driver.findElement(By.id("userNumber")).sendKeys("89845672310");

        driver.findElement(By.id("dateOfBirthInput")).click();
        WebElement year = driver.findElement(By.className("react-datepicker__year-select"));
        year.click();
        Select selectYear = new Select(year);
        selectYear.selectByVisibleText("1978");

        WebElement month = driver.findElement(By.className("react-datepicker__month-select"));
        month.click();
        Select selectMonth = new Select(month);
        selectMonth.selectByVisibleText("October");

        WebElement day = driver.findElement(By.xpath("//div[@class = 'react-datepicker__day react-datepicker__day--015 react-datepicker__day--weekend']"));
        day.click();

        WebElement sub = driver.findElement(By.xpath("//input[@id='subjectsInput']"));
        sub.sendKeys("Maths");
        sub.sendKeys(enter);

        driver.findElement(By.xpath("//div[@class = 'custom-control custom-checkbox custom-control-inline']/label[@for = 'hobbies-checkbox-1']")).click();

        WebElement upld = driver.findElement(By.id("uploadPicture"));
        String path = new File(SignUp.class.getProtectionDomain().getCodeSource().getLocation().toURI()).getPath();
        System.out.println(path);
        String filePath = path + "/TestImage.png";
        upld.sendKeys(filePath);

        driver.findElement(By.id("currentAddress")).sendKeys("Kazan");

        WebElement state = driver.findElement(By.id("react-select-3-input"));
        state.sendKeys("NCR");
        state.sendKeys(enter);

        WebElement city = driver.findElement(By.id("react-select-4-input"));
        city.sendKeys("Noida");
        city.sendKeys(enter);
        city.sendKeys(enter);

        driver.quit();
    }
}
