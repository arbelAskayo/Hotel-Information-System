package model;

import java.io.Serializable;
import java.util.Objects;

import utils.Area;
import utils.Gender;

public class Person implements Serializable, Comparable<Person>{
    private String id;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private Area area;
    private Gender gender;
    private int yearOfBirth;
    
  //serialVersion
    private static final long serialVersionUID= 1L;

    public Person(String id, String firstName,String lastName, String phoneNumber,Area area, Gender gender, int yearOfBirth) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.area = area;
        this.gender = gender;
        this.yearOfBirth = yearOfBirth;
    }

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public Area getArea() {
		return area;
	}

	public void setArea(Area area) {
		this.area = area;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}
	
	

	public int getYearOfBirth() {
		return yearOfBirth;
	}

	public void setYearOfBirth(int yearOfBirth) {
		this.yearOfBirth = yearOfBirth;
	}

	@Override
	public String toString() {
		return "Person [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", phoneNumber="
				+ phoneNumber + ", area=" + area + ", gender=" + gender + ", yearOfBirth=" + yearOfBirth + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(area, firstName, gender, id, lastName, phoneNumber, yearOfBirth);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Person other = (Person) obj;
		return area == other.area && Objects.equals(firstName, other.firstName) && gender == other.gender
				&& Objects.equals(id, other.id) && Objects.equals(lastName, other.lastName)
				&& Objects.equals(phoneNumber, other.phoneNumber) && yearOfBirth == other.yearOfBirth;
	}

	@Override
	public int compareTo(Person o) {
		// TODO Auto-generated method stub
		Integer.parseInt(getId());
		return Integer.parseInt(getId()) - Integer.parseInt(o.getId());
	}

	
    

    
}
