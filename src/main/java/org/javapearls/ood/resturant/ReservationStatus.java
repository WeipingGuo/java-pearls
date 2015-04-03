package org.javapearls.ood.resturant;

public enum ReservationStatus {
	active("reserved"),
	expired("customer did not use the table for given timeslot");

	private String reason;
	private ReservationStatus(String reason){
		this.reason = reason;
	}
	public String reason(){
		return this.reason;
	}

}
