package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\geeky\\OneDrive\\Desktop\\DemoTest\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://petvet-ai-9237c.web.app/login");
        driver.manage().window().maximize();

        // Fill in the login form
        WebElement emailInput = driver.findElement(By.xpath("//*[@id=\"field-:r0:\"]"));
        WebElement passwordInput = driver.findElement(By.xpath("//*[@id=\"field-:r1:\"]"));
        WebElement loginButton = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div[1]/form/div/button"));


        emailInput.sendKeys("asadghafoor26.figma@gmail.com");
        passwordInput.sendKeys("Test1234");
        loginButton.click();

//        int timeoutInSeconds = 10; // Set the desired timeout in seconds
//        long startTime = System.currentTimeMillis();
//
//        while (System.currentTimeMillis() - startTime < timeoutInSeconds * 1000) {
//            // Continue waiting for the specified duration
//        }
        Thread.sleep(8000);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(7));

        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"root\"]/div/div[2]/div[1]/div[2]/div[1]/button")));
        element.click();

        //Add Pet
        //Step 1 Of 4
        WebElement selectPet = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div/div/div[3]/div/div/div/div[1]"));
        selectPet.click();
        WebElement optionSelection = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div/div/div[3]/div/div/div/div[2]/div[1]"));
        optionSelection.click();
        WebElement clickContinue = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div/div/div[3]/div/div/button"));
        clickContinue.click();
        //Step 2 Of 4
        WebElement breedDropdown = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div/div/div[3]/div/form/div/div[2]/div/input"));
        breedDropdown.sendKeys("afghan");
        //Wait to Load WebElements

        WebElement element1 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"root\"]/div/div/div/div/div[3]/div/form/div/div[2]/div[2]/div[1]/p")));
        element1.click();
        WebElement continueClick = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div/div/div[3]/div/form/div/button"));
        continueClick.click();
        //Step 3 Of 4
        WebElement enterName = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div/div/div[3]/div/form/div/input[1]"));
        enterName.sendKeys("Inda");
        WebElement enterAge = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div/div/div[3]/div/form/div/input[2]"));
        enterAge.sendKeys("1 Year");
        driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div/div/div[3]/div/form/div/button")).click();
        //Step 4 Of 4
        driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div/div/div[3]/div/div/div[2]/button[1]")).click();

        //Edit Pet

        //pen Added Pets
        WebElement myPets = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"root\"]/div/div[1]/div/div[3]")));
        myPets.click();
        //Select pet from dropdown options
        driver.findElement(By.xpath("/html/body/div[1]/div/div[1]/div/div[3]/div/div/div/div/div[1]")).click();
        //Enable user to Edit Pet
        driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div[1]/button")).click();
        //First clear the field data to enter new data
        WebElement petName = driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div[2]/div[1]/form/div/div[2]/div[1]/input"));

        // Edit the fields by sending new input values
        petName.clear(); // Clear the current value
        petName.sendKeys("Russian Husky"); // Type the new pet name
        WebElement petAge = driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div[2]/div[1]/form/div/div[2]/div[2]/input"));
        petAge.clear(); //Clear the current value
        petAge.sendKeys("6 Months"); //Type the new pet Age
        //Save changes
        WebElement save = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div[1]/form/div/button")));
        save.click();

        //Chat wih AI Vet

        //Thread is in pause
        Thread.sleep(2000);
        //Click on Chat with AI Vet
        WebElement chatAi = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//p[normalize-space()='Get helpful advice (free)']")));
        chatAi.click();

        //Pause current thread for 2 seconds
        Thread.sleep(3000);

        //Select Pet to start with
        WebElement selectPets = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='chakra-stack css-duo73g']//div[2]")));
        selectPets.click();
        //Pause current thread for 5 seconds
        Thread.sleep(5000);

        WebElement inputField = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='chakra-stack css-1cbppnq']//input[@placeholder='Type a Message']")));
        //Enter the query
        inputField.sendKeys("Itching problem");
        //Click enter to get response from AI
        WebElement submit = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='chakra-stack css-1cbppnq']//button[@type='button']//*[name()='svg']")));
        submit.click();
       //Wait for AI response to proceed further. ttttts

        //Pause current thread for 10 seconds
        Thread.sleep(15000);

        //Enter another query

        WebElement inputField1 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='chakra-stack css-1cbppnq']//input[@placeholder='Type a Message']")));
        //Enter the query
        inputField1.sendKeys("Stomach problem");
        //Click enter to get response from AI
        driver.findElement(By.xpath("//div[@class='chakra-stack css-1cbppnq']//button[@type='button']//*[name()='svg']")).click();
        Thread.sleep(15000);
        //FAQs Section
        driver.findElement(By.xpath("//p[@class='chakra-text css-yr2c7q']")).click();
        //Click on FAQ
        driver.findElement(By.xpath("//p[normalize-space()='What is Chat GPT?']")).click();

        //Delete Pet

        driver.findElement(By.xpath("//div[@class='chakra-accordion css-1ki54i']//div[3]")).click();
        driver.findElement(By.xpath("//div[@class='css-17ih52v']//*[name()='svg']")).click();
        driver.findElement(By.xpath("//button[@aria-label='delete']//*[name()='svg']")).click();

        //Logout User

        driver.findElement(By.xpath("//button[normalize-space()='Log Out']")).click();


        //driver.quit();
    }
}
