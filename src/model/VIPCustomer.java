package model;


import java.util.Date;
import java.util.Objects;

import utils.Area;
import utils.Gender;

public class VIPCustomer extends Customer{
	
    protected double discountPercentage;

	public VIPCustomer(String id, String firstName, String lastName, String phoneNumber, Area area, Gender gender,
			int yearOfBirth, Date dateOfJoining, double discountPercentage) {
		super(id, firstName, lastName, phoneNumber, area, gender,yearOfBirth, dateOfJoining);
		this.discountPercentage = discountPercentage;
		this.setClasName("VIPCustomer");
	}

	public double getDiscountPercentage() {
		return discountPercentage;
	}



	public void setDiscountPercentage(double discountPercentage) {
		this.discountPercentage = discountPercentage;
	}

	@Override
	public String toString() {
		return super.toString() + " " +"discountPercentage=" + discountPercentage + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(discountPercentage);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		VIPCustomer other = (VIPCustomer) obj;
		return Double.doubleToLongBits(discountPercentage) == Double.doubleToLongBits(other.discountPercentage);
	}


	
}

