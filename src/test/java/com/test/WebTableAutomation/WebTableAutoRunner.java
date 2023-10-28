package com.test.WebTableAutomation;

import java.util.List;
import java.util.Scanner;

import org.openqa.selenium.remote.RemoteWebDriver;

import stevejobs.WebsiteUtilities;

public class WebTableAutoRunner {

	public static void main(String[] args) throws Exception{
		
		Scanner sc= new Scanner(System.in);
		System.out.println("Enter browser name::");
		String bn=sc.nextLine();
		System.out.println("Enter trip value::(0 or 1) ");
		int trip=Integer.parseInt(sc.nextLine());
		System.out.println("Enter from city:: ");
		String fromCity=sc.nextLine();
		System.out.println("Enter to city::");
		String toCity=sc.nextLine();
		System.out.println("Enter year:: ");
		int year=Integer.parseInt(sc.nextLine());
		System.out.println("Enter month:: ");
		String month=sc.nextLine();
		System.out.println("Enter date::");
		int date=sc.nextInt();
		int returnYear=0;
		String returnMonth="";
		int returnDay=0;
		if(trip==1) {
			System.out.println("Enter return year");
			returnYear=sc.nextInt();
			sc.nextLine();
			System.out.println("Enter return month");
			returnMonth=sc.nextLine();
			System.out.println("Enter return date");
			returnDay=sc.nextInt();
		}//if
		sc.close();
		
		WebsiteUtilities utility=new WebsiteUtilities();
		RemoteWebDriver driver= utility.getBrowserName(bn);
		utility.launchSite(driver, "https://beta.spicejet.com", 5000);
		
		WebTableAutoPage page =new WebTableAutoPage(driver);
		if(trip==0) {
			page.clickOneWayTrip();
			Thread.sleep(5000);
		}else {
			page.clickRoundTrip();
			Thread.sleep(5000);
		}
		
		page.setFromCity(fromCity);
		Thread.sleep(2000);
		page.setToCity(toCity);
		Thread.sleep(2000);
		
		page.setDepartureDate(year, month, date);
		Thread.sleep(5000);
		
		if(trip==1) {
			page.setReturnDate(returnYear, returnMonth, returnDay);
			Thread.sleep(5000);
		}
		
		page.clickNext();
		Thread.sleep(10000);
		
		System.out.println("departure flight list:: "+page.getDepartureFlightList());
		System.out.println("specified departure flight fare:: "+page.getDepartureFlightFare(0));
		System.out.println("all departure flight fares:: "+page.getAllDepartureFlightFares());
		
		//page.selectLowestDepartureFare();
		page.selectHeighestDepartureFare();
		
		
		if(trip==1) {
			System.out.println("return flight list:: "+page.getReturnFlightList());
			System.out.println("specified return flight fare"+page.getReturnFlightFare(0));
			System.out.println("all return flight fares:: "+page.getAllReturnFlightFares());
			//page.selectLowestReturnFlightFare();
			page.selectHeighestReturnFlightFare();
		}
		//close site
		//utility.closeBrowser(driver);

	}

}
