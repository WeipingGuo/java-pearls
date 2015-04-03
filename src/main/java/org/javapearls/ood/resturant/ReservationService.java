package org.javapearls.ood.resturant;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SuppressWarnings("unused")
public class ReservationService {

	private Map<Table, List<Reservation>> reservMap =
		new HashMap<Table, List<Reservation>>();
	private Map<Date, List<Reservation>> reservTime =
		new HashMap<Date, List<Reservation>>();

}
