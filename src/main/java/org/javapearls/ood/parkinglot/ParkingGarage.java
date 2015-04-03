package org.javapearls.ood.parkinglot;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author wguo
 *
 */
public class ParkingGarage {

	// OR use three lists to store ParkingSpaces
	private List<ParkingSpace> vacantSpaces = new ArrayList<ParkingSpace>();
	private List<Parking> parkings = new ArrayList<Parking>();
	private ParkingRater rater;

	public ParkingGarage(){
		rater = new ParkingRater(15.0);
	}

	public void init(List<ParkingSpace> all){
		vacantSpaces.addAll(all);
	}

	/**
	 * Park a car to the garage
	 * @param car
	 * @param type what type of parking space is needed
	 * @return
	 */
	public boolean park(Car car, ParkingType type){

		// find a vacant space
		ParkingSpace ps = findVacantSpace(type);
		if (ps == null){
			return false;
		}

		// remove the parking space from the vacant queue
		vacantSpaces.remove(ps);

		Parking parking = new Parking(car, ps);
		parkings.add(parking);
		return true;
	}

	/**
	 * move the car from the parking space
	 *
	 * @param car
	 * @return
	 */
	public boolean unpark(Car car){

		Parking pk = findParking(car);
		// the car is not parked here
		if (pk == null){
			return false;
		}

		pk.setEndTime(new Date());

		// calculate the parking fee
		rater.calculate(pk);

		// return space to the vacant list
		vacantSpaces.add(pk.getSpace());

		// remove the parking from list
		parkings.remove(pk);

		return true;
	}


	/**
	 * locate a car where it is parked
	 *
	 * @param car
	 * @return
	 */
	public ParkingSpace locate(Car car){

		for (Parking p : parkings){
			if (car == p.getCar() || car.equals(p.getCar())){
				return p.getSpace();
			}
		}
		return null;
	}

	/**
	 * parking event for given car
	 *
	 * @param car
	 * @return
	 */
	private Parking findParking(Car car){
		for (Parking p : parkings){
			if (car == p.getCar() || car.equals(p.getCar())){
				return p;
			}
		}
		return null;
	}

	/**
	 * find vacant parking space for given type
	 *
	 * @param type
	 * @return
	 */
	private ParkingSpace findVacantSpace(ParkingType type){

		for (ParkingSpace s : vacantSpaces){
			if (s.getType() == type){
				return s;
			}
		}
		return null;
	}


	public boolean isFull(){
		return vacantSpaces.size() == 0;
	}

}
