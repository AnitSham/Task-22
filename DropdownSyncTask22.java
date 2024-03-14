package com.guvi.selenium;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DropdownSyncTask22 {

	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://phptravels.com/demo/");
		driver.findElement(By.name("first_name")).sendKeys("Test");
		driver.findElement(By.name("last_name")).sendKeys("User");
		driver.findElement(By.name("business_name")).sendKeys("TestUser");
		driver.findElement(By.name("email")).sendKeys("testuser@gmail.com");
		WebElement E1 = driver.findElement(By.id("numb1"));
		WebElement E2 = driver.findElement(By.id("numb2"));

		String x = E1.getText();
		String y = E2.getText();

		int i = Integer.parseInt(x);
		System.out.println("First Element:" + i);

		int j = Integer.parseInt(y);
		System.out.println("Second Element:" + j);

		int z = i + j;
		System.out.println("Sum is: " + z);

		String s = Integer.toString(z);
		WebElement Sum = driver.findElement(By.id("number"));
		Sum.sendKeys(s);
		driver.findElement(By.cssSelector("div button[id='demo']")).click();
		String txt = driver.findElement(By.xpath("//p[@class='text-center cw']")).getText();
		System.out.println(txt);

		WebElement Exp = driver.findElement(By.xpath("//strong[text()=' Thank you!']"));
		WebDriverWait explicitwait = new WebDriverWait(driver, Duration.ofSeconds(10));
		explicitwait.until(ExpectedConditions.visibilityOf(Exp));
		System.out.println(Exp.getText());

		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String path = System.getProperty("user.dir");
		File dest = new File(path + "/screenshots/Screen.png");
		try {
			FileHandler.copy(src, dest);
		} catch (IOException excep) {
			excep.printStackTrace();
		}

	}

}
