package org.hexa;

import java.io.IOException;

import org.LibGlobal.LibGlobal;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.pages.BookaHotel;
import org.pages.BookingConfirmation;
import org.pages.LoginPage;
import org.pages.SearchHotel;
import org.pages.SelectHotel;

public class Sample extends LibGlobal {
	
	public void login() throws IOException {

		getDriver();
		maximizeWindow();
		implicitWait(10);
		loadUrl("https://adactinhotelapp.com/");
		String url = getPageUrl();
		System.out.println(url);
		updateData("Adactin", 0, 2, "PageTitle");
		String title = getPageTitle();
		updateData("Adactin", 1, 2, title);
		
	LoginPage loginpage=new LoginPage();
		
		insertValue(loginpage.getTxtUserName(), getData("Adactin", 1, 0));
		;
		insertValue(loginpage.getTxtPassword(), getData("Adactin", 1, 1));
	
	

		elementClick(loginpage.getBtnLogin());
	}

	public void searchHotel() throws IOException {
		SearchHotel searchhotel=new SearchHotel();
		
		selectOptionByText(searchhotel.getDdLocation(), getData("Adactin", 1, 3));

	
		selectOptionByText(searchhotel.getDdhotelname(), getData("Adactin", 1, 4));

		selectOptionByText(searchhotel.getDdroomtype(), getData("Adactin", 1, 5));

		selectOptionByText(searchhotel.getDdroomnos(), getData("Adactin", 1, 6));

	
	clearData(searchhotel.getDdcheckIn());
	insertValue(searchhotel.getDdcheckIn(), getData("Adactin", 1, 7));

	
	clearData(searchhotel.getDdcheckOut());
	insertValue(searchhotel.getDdcheckOut(), getData("Adactin", 1, 8));

		selectOptionByText(searchhotel.getDdadultroom(), getData("Adactin", 1, 9));

		selectOptionByText(searchhotel.getDdchildroom(), getData("Adactin", 1, 10));

		
		elementClick(searchhotel.getBtnSearch());

	}

	public void selectHotel() {
		SelectHotel selecthotel=new SelectHotel();
		
		elementClick(selecthotel.getRadioBtn());
		elementClick(selecthotel.getContinueBtn());

	}

	public void bookAHotel() throws IOException {
		BookaHotel bookahotel=new BookaHotel();

		insertValue(bookahotel.getTxtFirstName(), getData("Adactin", 1, 11));


		insertValue(bookahotel.getTxtLastname(), getData("Adactin", 1, 12));

		insertValue(bookahotel.getTxtAddress(), getData("Adactin", 1, 13));


		insertValue(bookahotel.getTxtCredit(), getData("Adactin", 1, 14));

		selectOptionByText(bookahotel.getDdcctype(), getData("Adactin", 1, 15));

		selectOptionByText(bookahotel.getDdexpmonth(), getData("Adactin", 1, 16));

		selectOptionByText(bookahotel.getDdexpyear(), getData("Adactin", 1, 17));

		insertValue(bookahotel.getTxtCvv(), getData("Adactin", 1, 18));

		elementClick(bookahotel.getBtnBook());

	}

	public void bookingConfirmation() throws IOException {
		BookingConfirmation bookingconfirmation=new BookingConfirmation();

		updateData("Adactin", 0, 19, "orderIdNo");
		String orderIdNo = getAttribute(bookingconfirmation.getOrderId(), "value");
		updateData("Adactin", 1, 19, orderIdNo);
		
		System.out.println("OrderIDNo:::"+orderIdNo);
	}

	public static void main(String[] args) throws IOException {
		Sample h = new Sample();
		h.login();
		h.searchHotel();
		h.selectHotel();
		h.bookAHotel();
		h.bookingConfirmation();
	}

}
