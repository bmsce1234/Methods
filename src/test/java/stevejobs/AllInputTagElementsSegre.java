package stevejobs;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import sun.security.util.Password;

public class AllInputTagElementsSegre {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		RemoteWebDriver driver=new ChromeDriver();
		driver.get("https://www.facebook.com");
		
		List<WebElement> l=driver.findElements(By.xpath("//input"));
		
		int passBox=0,txtBox=0,chkBox=0,radioBtn=0
				,mail=0,hidden=0,others=0;
		
		System.out.println("total element size is "+l.size());
		for(WebElement e:l) {
			String x=e.getAttribute("type");
			
			switch(x) {
			case "radio":
				radioBtn++;
				break;
			case "checkbox":
				chkBox++;
				break;
			case "textbox":
				txtBox++;
				break;
			case "password":
				passBox++;
				break;
			case "mail":
				mail++;
				break;
			case "hidden":
				hidden++;
				break;
			default:
				others++;
			}
		}
		
		System.out.println("radio button count is "+radioBtn);
		System.out.println("check box count is "+chkBox);
		System.out.println("textbox count is "+txtBox);
		System.out.println("password box count is "+passBox);
		System.out.println("mail box count is "+mail);
		System.out.println("hiiden element count is "+hidden);
		System.out.println("other elements count is "+others);
		driver.close();
	}

}
