package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class myTest {
    String url = "https://formy-project.herokuapp.com/form";
    String driverPath = "C:\\chromedriver-win64\\chromedriver.exe";
    String browserDriver ="webdriver.chrome.driver";
    WebDriver driver = new ChromeDriver();

    public static void main(String[] args) {
        new myTest("Iván", "Gómez", "QA Analyst", "09/27/2001");
    }

    public void testField(String xpath, String inputText) {
        WebElement field = driver.findElement(By.xpath(xpath));
        field.sendKeys(inputText);
    }

    public void clickElement(String xpath) {
        WebElement element = driver.findElement(By.xpath(xpath));
        element.click();
    }

    public void comboBoxSelect(String xpath, String optionText) {
        Select select = new Select(driver.findElement(By.xpath(xpath)));
        select.selectByVisibleText(optionText);
    }

    public myTest(String nombre, String apellido, String jobTitle, String date) {
        System.setProperty(browserDriver, driverPath);

        driver.get(url);
        System.out.println(driver.getTitle());

        testField("(//input[@id='first-name'])[1]", nombre);
        testField("(//input[@id='last-name'])[1]", apellido);
        testField("(//input[@id='job-title'])[1]", jobTitle);

        clickElement("(//input[@id='radio-button-1'])[1]");
        clickElement("(//input[@id='checkbox-1'])[1]");

        comboBoxSelect("(//select[@id='select-menu'])[1]", "5-9");

        testField("(//input[@id='datepicker'])[1]", date);
        System.out.println(driver.getTitle());


    }
}