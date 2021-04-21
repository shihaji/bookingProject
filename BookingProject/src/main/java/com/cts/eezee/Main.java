package com.cts.eezee;

import java.text.ParseException;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cts.eezee.model.Booking;
import com.cts.eezee.model.Vehicle;
import com.cts.eezee.service.TransportService;

public class Main {

	public static void main(String[] args) throws ParseException {
		
		ApplicationContext ctx=new ClassPathXmlApplicationContext("bean.xml");
		
		TransportService ts=ctx.getBean(TransportService.class);
		
		Booking booking=ctx.getBean(Booking.class);
		
		ts.registerBooking(booking);
		
	
		
		
	}

}
