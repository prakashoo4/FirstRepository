package org.step;

import org.base.BaseClass;
import org.openqa.selenium.WebElement;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepClass extends BaseClass {
	@Given("User should be in the adactin login page")
	public void tc01() {
		getDriver("https://adactinhotelapp.com/BookHotel.php");
	    
	}
	@When("User should enter the {string} and {string}")
	public void tc02(String user, String pass) {
	    WebElement username = locaterId("username");
	    username.sendKeys(user);
	    
	    WebElement password = locaterId("password");
	    password.sendKeys(pass);
	}
	@When("User should click the login button")
	public void tc03() {
		WebElement login = locatername("login");
	    login.click();
	}
	@When("User should enter the {string},{string},{string},{string}")
	public void tc04(String location, String hotel, String room, String Norooms) {
	  
		WebElement locater = locaterId("location");
		locater.sendKeys(location);
		
		WebElement hotels = locaterId("hotels");
		hotels.sendKeys(hotel);
		
		WebElement roomtype = locaterId("room_type");
		roomtype.sendKeys(room);
		
		WebElement roomno = locaterId("room_nos");
		roomno.sendKeys(Norooms);
		
		
	}
	@When("User should enter date {string} and {string}")
	public void tc05(String checkin, String checkout) {
		
		WebElement indate = locaterId("datepick_in");
		indate.sendKeys(checkin);
		
		WebElement outdate = locaterId("datepick_out");
		outdate.sendKeys(checkout);
		
	}
	@When("User should select the {string} and {string}")
	public void tc06(String adult, String child) {
		
		WebElement adultroom = locaterId("adult_room");
		adultroom.sendKeys(adult);
		
		WebElement childroom = locaterId("child_room");
		childroom.sendKeys(child);
	    
	}
	@When("User should click the search button")
	public void tc07() {
		
		WebElement searchbutton = locaterId("Submit");
		searchbutton.click();
	    
	}
	@When("User should click the radio button")
	public void tc08() {
		
		WebElement ratiobutton = locaterId("radiobutton_0");
		ratiobutton.click();
	    
	}
	@When("User should click the continue button")
	public void tc09() {
		
		WebElement continuebutton = locaterId("continue");
		continuebutton.click();
	     
	}
	@When("User should enter name {string} and {string}")
	public void tc10(String fname, String lname) {
		
		WebElement firstname = locaterId("first_name");
		firstname.sendKeys(fname);
		
		WebElement lastname = locaterId("last_name");
		lastname.sendKeys(lname);
	    
	}
	@When("User should enter th address {string}")
	public void tc11(String address) {
		
		WebElement Address = locaterId("address");
		Address.sendKeys(address);
	     
	}
	@When("User should enter credit card type {string}")
	public void tc12(String credit) {
	
		WebElement creditcard = locaterId("cc_num");
		creditcard.sendKeys(credit);
	     
	}
	@When("User should enter card type {string}")
	public void tc13(String credittype) {
		WebElement creditcarttype = locaterId("cc_type");
		creditcarttype.sendKeys(credittype);
	    
	}
	@When("User should enter valid date {string} and {string}")
	public void tc14(String month, String year) {
	    WebElement expmonth = locaterId("cc_exp_month");
	    expmonth.sendKeys(month);
	    
	    WebElement expyear = locaterId("cc_exp_year");
	    expyear.sendKeys(year);
	}
	@When("User should enter cv number {string}")
	public void tc15(String cvnum) {
		
		WebElement cvnumber = locaterId("cc_cvv");
		cvnumber.sendKeys(cvnum);
	   
	}
	@When("User should click book now button")
	public void tc16() {
		WebElement booknow = locaterId("book_now");
		booknow.click();
	    
	}
	@Then("User should verify sucessfull book the hotel")
	public void tc17() {
		System.out.println("User should verify sucessfull book the hotel");
	} 
}