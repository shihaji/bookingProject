package com.cts.eezee.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.Map.Entry;

import com.cts.eezee.model.Booking;
import com.cts.eezee.model.Vehicle;

public class TransportService {

	private Vehicle vehicle;

	public Vehicle getVehicle() {
		return vehicle;
	}

	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}

	public void registerBooking(Booking booking) throws ParseException {

		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the customer name");
		booking.setCustomerName(sc.nextLine());
		System.out.println("Enter the mobile number");
		booking.setMobileNumber(sc.nextLong());
		System.out.println("Enter the destination");
		booking.setDestination(sc.next());
		System.out.println("Enter the date of journey<dd-MM-yyyy>");
		booking.setDateOfJourney(new SimpleDateFormat("dd-MM-yyyy").parse(sc.next()));
		
		calculateTravelCost(vehicle.getSource(), booking.getDestination(), booking.getDateOfJourney());
		

	}

	public void calculateTravelCost(String source, String destination, Date doj) {

		if(checkAvailableDateForTravel(doj)) {
			
			System.out.println("Total travel cost is rs ."+getCost(destination));
			
		}else {
			System.out.println("Invalid Travel Date");
		}

	}

	public boolean checkAvailableDateForTravel(Date doj) {

		// code here

		return (new Date().equals(doj))||(doj.after(new Date()));
	}

	public double getCost(String destination) {

	    Set<String> set=vehicle.getDestinationMap().keySet();
	    
	    for(String s:set) {
	    	if(s.equals(destination)) {
	    		return vehicle.getDestinationMap().get(s);
	    	}
	    }

		return 0.0;
	}

}
