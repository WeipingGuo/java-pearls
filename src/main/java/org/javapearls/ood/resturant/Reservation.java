package org.javapearls.ood.resturant;

import java.util.Date;

public class Reservation {

	private Table table;
	private Customer customer;
	private int expectedPeople;
	private Date time;

	private ReservationStatus status;

	public Reservation(Table table, Customer customer, int expectedPeople){
		this.table = table;
		this.customer = customer;
		this.expectedPeople = expectedPeople;
		time = new Date(System.currentTimeMillis());
		status = ReservationStatus.active;
	}

	public Table getTable(){
		return this.table;
	}
	public Customer getCustomer(){
		return this.customer;
	}
	public int getExpectedPeople(){
		return this.expectedPeople;
	}
	public Date getReservationTime(){
		return this.time;
	}
	public void setStatus(ReservationStatus status){
		this.status = status;
	}
	public boolean isExpired(){
		return this.status == ReservationStatus.expired;
	}
}
