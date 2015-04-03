package org.javapearls.ood.parkinglot;

public class ParkingRater {

	private double hourlyRate;

	public ParkingRater(double rate){
		this.hourlyRate = rate;
	}


	/**
	 * calculate the parking fee
	 *
	 * @param parking
	 * @return
	 */
	public double calculate(Parking parking){

		long elapse = (parking.getEndTime().getTime() - parking.getStartTime().getTime()) /1000;

		int hours = (int)( (elapse % 3600 == 0)? (elapse / 3600) : (elapse /3600 + 1));

		return hours * hourlyRate;
	}

}
