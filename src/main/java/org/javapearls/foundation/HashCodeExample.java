package org.javapearls.foundation;

public class HashCodeExample {

	private boolean booleanValue;
	private byte byteValue;
	private long time;
	private double salary;


	private int hash = 0;

	public HashCodeExample(boolean b, byte f, long l, double s){
		this.booleanValue = b;
		this.byteValue = f;
		this.time = l;
		this.salary = s;
	}


	@Override
	public int hashCode() {
		int result = hash;

		if (result == 0){

			//31 * i == (i << 5) - i
			final int prime = 31;
			result = 1;
			result = ((result << 5) - result) + (booleanValue ? 1231 : 1237);
			result = prime * result + byteValue;
			long temp;
			temp = Double.doubleToLongBits(salary);
			result = prime * result + (int) (temp ^ (temp >>> 32));
			result = prime * result + (int) (time ^ (time >>> 32));

			hash = result;
		}

		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		HashCodeExample other = (HashCodeExample) obj;
		if (booleanValue != other.booleanValue)
			return false;
		if (byteValue != other.byteValue)
			return false;
		if (Double.doubleToLongBits(salary) != Double
				.doubleToLongBits(other.salary))
			return false;
		if (time != other.time)
			return false;
		return true;
	}

}
