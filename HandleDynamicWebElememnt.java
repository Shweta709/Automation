import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandleDynamicWebElememnt {

	public static void main(String[] args) throws Exception {
		
		WebDriver driver;
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.get("https://www.google.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		By search_locator=By.xpath("//textarea[@title='Search']");
		By TestingTool=By.xpath("//div[contains(@jsname,'rVKIyd')]/div");
		
		By more=By.xpath("//span[@class='PBBEhf' and @aria-label]");
		By toolsName=By.xpath("//aside[@data-id='4ae52f7e']/div/div");
		
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
		WebElement search=driver.findElement(search_locator);
		search.sendKeys("Testing Tools");
		search.sendKeys(Keys.ENTER);
		wait.until(ExpectedConditions.elementToBeClickable(more));
		driver.findElement(more).click();
		wait.until(ExpectedConditions.elementToBeClickable(TestingTool));
		List<WebElement> total_testingTools=driver.findElements(TestingTool);
		System.out.println(total_testingTools.size());
		for(WebElement testingName:total_testingTools) {
			System.out.println(testingName.getText());
		}
	
		//List<WebElement> tools=wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(toolsName));
		List<WebElement> tools=driver.findElements(toolsName);
		System.out.println(tools.size());
		
		
		for(int i=0;i<total_testingTools.size();i++) {
			//Thread.sleep(5000);
		wait.until(ExpectedConditions.visibilityOfAllElements(driver.findElements(By.xpath("//div[contains(@jsname,'rVKIyd')]/div[2]"))));
			total_testingTools.get(i).click();
			
			for(WebElement testingName1:tools) {
				System.out.println(testingName1.getText());
			}
			
		}
		driver.close();
		
		

	}

}
