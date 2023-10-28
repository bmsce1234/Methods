package com.test.CheckBox.RadioButton;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class TestCheckBoxRadioButtonPage {

	//private RemoteWebDriver driver;
	
	@FindBy(name="tip1")
	private WebElement checkBox1;
	
	@FindBy(name="tip2")
	private WebElement checkBox2;
	
	@FindBy(xpath = "//input[@value='3']")
	private WebElement radioButton1;
	
	@FindBy(xpath = "//input[@value='4']")
	private WebElement radioButton2;
	
	public TestCheckBoxRadioButtonPage(RemoteWebDriver driver) {
		//this.driver=driver;
		
		AjaxElementLocatorFactory aFactory=new AjaxElementLocatorFactory(driver, 20);
		PageFactory.initElements(aFactory, this);
	}
	
	//operational methods select checkbox
	public void selectCheckBox(int index) {
		/*if(index==1) {
			if(!checkBox1.isSelected()) {
				checkBox1.click();
			}
		}else if(index==2) {
			if(!checkBox2.isSelected()) {
				checkBox2.click();
			}
		}else {
			System.out.println("wrong index");
			System.exit(0);
		}*/
		
		
		//using switch case
		/*switch (index) {
		case 1:
			if(!checkBox1.isSelected())
				checkBox1.click();
			break;
		case 2:
			if(!checkBox2.isSelected())
				checkBox2.click();
			break;
		default:
			System.out.println("invalid index");
			System.exit(0);
		}*/
		
		//using another element
		WebElement chkBox=null;
		if(index==1)
			chkBox=checkBox1;
		else if(index==2)
			chkBox=checkBox2;
		else {
			System.out.println("wrong index");
		    System.exit(0);
		}
		
		if(!chkBox.isSelected())
			chkBox.click();
	}//selectCheckBox
	
	//deselect checkBox
	public void deSelectCheckBox(int index) {
		/*if(index==1) {
			if(checkBox1.isSelected()) {
				checkBox1.click();
			}
		}else if(index==2) {
			if(checkBox2.isSelected()) {
				checkBox2.click();
			}
		}else {
			System.out.println("wrong index");
			System.exit(0);
		}*/
		
		/*//using switch case
		switch (index) {
		case 1:
			if(checkBox1.isSelected())
				checkBox1.click();
			break;
		case 2:
			if(checkBox2.isSelected())
				checkBox2.click();
			break;
		default:
			System.out.println("invalid index");
			System.exit(0);
		}*/
		
		//using another element
		WebElement dSeChkBox=null;
		
		if(index==1)
			dSeChkBox=checkBox1;
		else if(index==2)
			dSeChkBox=checkBox2;
		else {
			System.out.println("wrong index");
			System.exit(0);
		}
		
		if(dSeChkBox.isSelected())
			dSeChkBox.click();
		
	}//deSelectCheckBox
	
	public boolean verifyCheckBox(int index) {
		/*if(index==1) {
			if(checkBox1.isDisplayed()) {
				if(checkBox1.isEnabled()) {
					if(checkBox1.isSelected()) {
						return true;
					}else {
						System.out.println("is selected");
						return false;
					}
				}else {
					System.out.println("is enabled");
					return false;
				}
			}else {
				System.out.println("is displayed");
				return false;
			}
		}else if(index==2) {
			if(checkBox2.isDisplayed()) {
				if(checkBox2.isEnabled()) {
					return checkBox2.isSelected()?true:false;
				}else {
					return false;
				}
			}else {
				return false;
			}
		}else {
			System.out.println("Wrong index");
			return false;
		}*/
		
		//using another element
		WebElement opChkBox=null;
		
		if(index==1)
			opChkBox=checkBox1;
		else if(index==2)
			opChkBox=checkBox2;
		else {
			System.out.println("wrong index");
			System.exit(0);
		}
		
		if(opChkBox.isDisplayed())
			if(opChkBox.isEnabled())
				return opChkBox.isSelected()?true:false;
			else
				return false;
		else
			return false;
		
		
	}//verify check box
	
	//click radio button
	public void clickRadioButton(int index) {
		/*if(index==1) {
			radioButton1.click();
		}else if(index==2) {
			radioButton2.click();
		}else {
			System.out.println("Wrong index");
			System.exit(0);
		}
	}//click Radio button*/
		
		
		//using switch case
		switch (index) {
		case 1:
			radioButton1.click();
			break;
  
		case 2:
			radioButton2.click();
			break;
		default:
			System.out.println("invalid index");
			System.exit(0);
		}
		
	}
	
	//verify radio button
	public boolean verifyRadioButton(int index) {
		/*if(index==1) {
			if(radioButton1.isDisplayed()) {
				if(radioButton1.isEnabled()) {
					if(radioButton1.isSelected()&&!radioButton2.isSelected()) {
						return true;
					}else {
						return false;
					}
				}else {
					return false;
				}
			}else {
				return false;
			}
		}else if(index==2) {
			if(radioButton2.isDisplayed()) {
				if(radioButton2.isEnabled()) {
					if(!radioButton1.isSelected()&&radioButton2.isSelected()) {
						return true;
					}else {
						System.out.println("isSelected");
						return false;
					}
				}else {
					System.out.println("isEnabled");
					return false;
				}
			}else {
				System.out.println("isDisplayed");
				return false;
			}
		}else {
			System.out.println("Wrong index");
			return false;
		}*/
		
		WebElement rdio1=null;
		WebElement rdio2=null;
		
		if(index==1) {
			rdio1=radioButton1;
			rdio2=radioButton2;
		}else if(index==2) {
			rdio1=radioButton2;
			rdio2=radioButton1;
		}else {
			System.out.println("wrong index");
			System.exit(0);
		}
		
		if(rdio1.isDisplayed()&&rdio2.isDisplayed())
			if(rdio1.isEnabled()&&rdio2.isEnabled())
				return rdio1.isSelected()&& !rdio2.isSelected()?true:false;
			else
				return false;
		else
			return false;
		   
			
	}
}

