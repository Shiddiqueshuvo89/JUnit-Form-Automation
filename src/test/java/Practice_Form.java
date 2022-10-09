import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

public class Practice_Form {

    WebDriver driver;

    @Before
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "./src/test/resources/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headed");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

    }

    @Test
    public void getTitle() throws InterruptedException {

        driver.get("https://demoqa.com/automation-practice-form");
        Thread.sleep(2000);
        driver.manage().window().maximize();

        String text= driver.findElement(By.tagName("h5")).getText();
        Assert.assertEquals("Student Registration Form",text);

//    ------------------------Form Displayed Or Not-------------------

        WebElement displayed=driver.findElement(By.id("userForm"));
        Assert.assertTrue(displayed.isDisplayed());

    }

    //      --------------------Writing on Text Box Areas----------------
    @Test
    public void formAutomation() throws InterruptedException {

        driver.get("https://demoqa.com/automation-practice-form");
        driver.findElement(By.id("firstName")).sendKeys("Shiddique");
        driver.findElement(By.id("lastName")).sendKeys("Shuvo");
        Thread.sleep(500);
        driver.findElement(By.id("userEmail")).sendKeys("shiddiqueshuvo@gmail.com");
        Thread.sleep(500);

        WebElement radioButtonFemale=driver.findElement
                (By.xpath("//label[contains(text(),'Female')]"));
        radioButtonFemale.click();
        //checking if the other radio button gets deselected or not after clicking another radio button.
        WebElement radioButtonMale=driver.findElement
                (By.xpath("//label[contains(text(),'Male')]"));
        Thread.sleep(1200);
        if(!radioButtonMale.isSelected()) {
            radioButtonMale.click();
        }
        System.out.println("Female radio button is deselected and Male radio button is selected");
        Thread.sleep(2000);

        driver.findElement(By.id("userNumber")).sendKeys("1777696605");
        Thread.sleep(1500);
        driver.findElement(By.id("currentAddress")).sendKeys("Ashkona, Hajj Camp");
        Thread.sleep(2000);

        //        ----------------------Date Picker-------------------

        WebElement calendarInput= driver.findElement(By.id("dateOfBirthInput"));
        calendarInput.sendKeys(Keys.CONTROL+"a");
        Thread.sleep(1000);
        calendarInput.sendKeys("01/05/1998");
        Thread.sleep(1000);
        calendarInput.sendKeys(Keys.ENTER);

        //      --------------------Subject Choose--------------

        WebElement subjectChoose= driver.findElement(By.id("subjectsInput"));
        subjectChoose.sendKeys("Physics");
        Thread.sleep(2000);

        subjectChoose.sendKeys(Keys.ENTER);
        subjectChoose.sendKeys("Math");
        Thread.sleep(2000);
        subjectChoose.sendKeys(Keys.ENTER);

        // ----------------- Selecting the Check box ----------------

        WebElement sportsCheckBox= driver.findElement(By.id("hobbies-checkbox-1"));
        Actions action =new Actions(driver);

        //if first check box is not selected.
        if(!sportsCheckBox.isSelected()) {
            action.moveToElement(sportsCheckBox).click().perform();
        }
        WebElement readingCheckBox=driver.findElement(By.id("hobbies-checkbox-2"));
        //if the second check box is enabled click on it.
        Thread.sleep(1000);
        if(sportsCheckBox.isEnabled()){
            action.moveToElement(readingCheckBox).click().perform();
        }

        //  --------------Uploading Pictures----------------

        Thread.sleep(1000);
        WebElement uploadPic= driver.findElement(By.id("uploadPicture"));
        uploadPic.sendKeys("C:\\Users\\DOLPHIN\\OneDrive\\Desktop\\Shuvo.jpg");
        Thread.sleep(2000);

        //      ---------------State Choose---------------

        WebElement state= driver.findElement(By.id("react-select-3-input"));
        state.sendKeys("Ha");
        Thread.sleep(1000);
        state.sendKeys(Keys.ENTER);
        Thread.sleep(2000);

        //      --------------City choose---------------

        WebElement city= driver.findElement(By.id("react-select-4-input"));
        city.sendKeys("Jai");
        Thread.sleep(2000);
        city.sendKeys(Keys.ENTER);
        Thread.sleep(2000);

        //    -------------- Submit Button --------------

        WebElement submitButton= driver.findElement(By.cssSelector("[type=submit]"));
        Thread.sleep(2000);
        action.moveToElement(submitButton).sendKeys(Keys.ENTER).perform();

    }

    @After
    public void closeBrowser() {

        driver.quit();

    }

}