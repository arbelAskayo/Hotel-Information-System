package model;


import java.util.Objects;

import utils.Area;
import utils.Gender;

public class Employee extends Person{

    private double salary;
    private Department department;
    private int startOfWork;
    private User user;	

	public Employee(String id, String firstName, String lastName, String phoneNumber, Area area, Gender gender,
			int yearOfBirth,int startOfWork,double salary, Department department) {
		super(id, firstName, lastName, phoneNumber, area, gender,yearOfBirth);
		this.salary = salary;
		this.department = department;
		this.startOfWork = startOfWork;
	}


	public int getStartOfWork() {
		return startOfWork;
	}


	public void setStartOfWork(int startOfWork) {
		this.startOfWork = startOfWork;
	}


	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public Department getDepartment() {
		return department;
	}


	public void setDepartment(Department department) {
		this.department = department;
	}
//get user
	public User getUser() {
		Hotel.getInstance().getAllUsers().values().stream().forEach(u->{if(u.getEmployeeId().equals(this.getId())) {user=u; }});
		return user;
	}

	@Override
	public String toString() {
	
	//getting employee user
		Hotel.getInstance().getAllUsers().values().stream().forEach(u->{if(u.getEmployeeId().equals(this.getId())) {user=u; }});
		
		return   "Employee [id " +getId() +" salary=" + salary + ", department=" + department + ", startOfWork=" + startOfWork + "]"+user.toString();
	}
	
	public String fullToString() {
	
	//getting employee user and pass
		Hotel.getInstance().getAllUsers().values().stream().forEach(u->{if(u.getEmployeeId().equals(this.getId())) {user=u; }});
		
		return   "Employee [id " +getId() +" salary=" + salary + ", department=" + department + ", startOfWork=" + startOfWork + "]"+user.fullToString();
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(department, salary, startOfWork);
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
		Employee other = (Employee) obj;
		return Objects.equals(department, other.department)
				&& Double.doubleToLongBits(salary) == Double.doubleToLongBits(other.salary)
				&& startOfWork == other.startOfWork;
	}


	


    
}
