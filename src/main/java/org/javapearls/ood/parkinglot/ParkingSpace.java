package org.javapearls.ood.parkinglot;


/**
 * The actual parking spot
 *
 * @author wguo
 *
 */
public class ParkingSpace {

	private int id;
	private ParkingType type;
	private int floor;

	public ParkingSpace(){

	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public ParkingType getType() {
		return type;
	}
	public void setType(ParkingType type) {
		this.type = type;
	}
	public int getFloor() {
		return floor;
	}
	public void setFloor(int floor) {
		this.floor = floor;
	}
}
