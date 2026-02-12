package com.lld.designPattern;

import com.lld.designPattern.bookmyshow.BookMyShow;
import com.lld.designPattern.carRentalSystem.RentalSystem;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DesignPatternApplication {

	public static void main(String[] args) {
		SpringApplication.run(DesignPatternApplication.class, args);
		//RentalSystem rentalSystem = new RentalSystem();

		BookMyShow bookMyShow = new BookMyShow();
	}

}
