package model;


import java.util.Collections;
import java.util.Date;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import utils.Area;
import utils.Gender;

public class Customer extends Person {
	private String clasName = "Customer";
	private Date dateOfJoining;
	private HashSet <Booking> allBookings;
	
	public Customer(String id, String firstName, String lastName, String phoneNumber, Area area, Gender gender,
			int yearOfBirth, Date dateOfJoining) {
		super(id, firstName, lastName, phoneNumber, area, gender, yearOfBirth);
		this.dateOfJoining = dateOfJoining;
		this.allBookings = new HashSet <Booking>();
	}


	public Date getDateOfJoining() {
		return dateOfJoining;
	}


	public void setDateOfJoining(Date dateOfJoining) {
		this.dateOfJoining = dateOfJoining;
	}


	public Set<Booking> getAllBookings() {
		return Collections.unmodifiableSet(allBookings);
	}


	public void setAllBookings(HashSet<Booking> allBookings) {
		this.allBookings = allBookings;
	}
	
	


	public String getClasName() {
		return clasName;
	}

	

	public void setClasName(String clasName) {
		this.clasName = clasName;
	}


	@Override
	public String toString() {
		return clasName+ " " + super.toString() + "dateOfJoining=" + String.valueOf(dateOfJoining) + ", allBookings=" + allBookings + "]";
	}





	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(clasName, dateOfJoining);
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
		Customer other = (Customer) obj;
		return Objects.equals(clasName, other.clasName) && Objects.equals(dateOfJoining, other.dateOfJoining);
	}


	public boolean addBooking(Booking b) {
		if(b==null || this.allBookings.contains(b))
			return false;
		else {
			this.allBookings.add(b);
			return true;	
		}
	}
		
	public boolean removeBooking(Booking b) {
		if(b==null || !this.allBookings.contains(b))
			return false;
		else {
			this.allBookings.remove(b);
			return true;	
		}
		
	}




	
	
	

}
