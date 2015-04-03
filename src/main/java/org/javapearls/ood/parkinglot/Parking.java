package org.javapearls.ood.parkinglot;

import java.util.Date;

/**
 * A class to represent a parking event
 *
 * @author wguo
 *
 */
public class Parking {

	private Car car;
	private ParkingSpace space;
	private Date startTime;
	private Date endTime;


	public Parking(Car car, ParkingSpace space){
		this.car = car;
		this.space = space;
		startTime = new Date();
	}

	public Car getCar() {
		return car;
	}
	public void setCar(Car car) {
		this.car = car;
	}
	public ParkingSpace getSpace() {
		return space;
	}
	public void setSpace(ParkingSpace space) {
		this.space = space;
	}
	public Date getStartTime() {
		return startTime;
	}
	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}
	public Date getEndTime() {
		return endTime;
	}
	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}


}
