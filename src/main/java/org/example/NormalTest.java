package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class NormalTest {
    public static void main(String[] args) {
        new NormalTest("Iván", "Gómez", "QA Analyst", "09/27/2001");
    }

    public void testField(String xpath, String inputText, WebDriver driver) {
        WebElement field = driver.findElement(By.xpath(xpath));
        field.sendKeys(inputText);
    }

    public void clickElement(String xpath, WebDriver driver) {
        WebElement element = driver.findElement(By.xpath(xpath));
        element.click();
    }

    public void comboBoxSelect(String xpath, WebDriver driver, String optionText) {
        Select select = new Select(driver.findElement(By.xpath(xpath)));
        select.selectByVisibleText(optionText);
    }

    public NormalTest(String _nombre, String _apellido, String _jobTitle, String _date) {
        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver-win64\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://formy-project.herokuapp.com/form");

        System.out.println(driver.getTitle());

        testField("(//input[@id='first-name'])[1]", _nombre, driver);
        testField("(//input[@id='last-name'])[1]", _apellido, driver);
        testField("(//input[@id='job-title'])[1]", _jobTitle, driver);

        clickElement("(//input[@id='radio-button-1'])[1]", driver);
        clickElement("(//input[@id='checkbox-1'])[1]", driver);

        comboBoxSelect("(//select[@id='select-menu'])[1]", driver, "5-9");

        testField("(//input[@id='datepicker'])[1]", _date, driver);
        System.out.println(driver.getTitle());


    }
}