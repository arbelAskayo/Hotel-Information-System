package model;


import java.io.Serializable;
import java.util.Collections;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import utils.Specialization;

public class Department implements Serializable {

	private String departmentId;
	private Specialization specialization;
	private DepartmentManager depManager;
	private HashSet <Employee> allEmployees;
	
	//serialVersion
    private static final long serialVersionUID= 1L;
	
	
	public Department(String departmentId, Specialization specialization) {
		super();
		this.departmentId = departmentId;
		this.specialization = specialization;
		this.depManager = null;
		this.allEmployees = new HashSet<Employee>();
	}
	
	public String getDepartmentId() {
		return departmentId;
	}
	public void setDepartmentId(String departmentId) {
		this.departmentId = departmentId;
	}
	public Specialization getSpecialization() {
		return specialization;
	}
	public void setSpecialization(Specialization specialization) {
		this.specialization = specialization;
	}
	public DepartmentManager getDepManager() {
		return depManager;
	}
	public void setDepManager(DepartmentManager depManager) {
		this.depManager = depManager;
	}
	public Set<Employee> getAllEmployees() {
		return Collections.unmodifiableSet(allEmployees);
	}
	public void setAllEmployees(HashSet<Employee> allEmployees) {
		this.allEmployees = allEmployees;
	}
	@Override
	public String toString() {
		return "Department [departmentId=" + departmentId + ", specialization=" + specialization + "]";
	}

	
	
	
	@Override
	public int hashCode() {
		return Objects.hash(departmentId, specialization);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Department other = (Department) obj;
		return Objects.equals(departmentId, other.departmentId) && specialization == other.specialization;
	}

	public boolean addEmployee(Employee e) {
		if(e==null || this.allEmployees.contains(e))
			return false;
		else {
			this.allEmployees.add(e);
			return true;	
		}
	}
	
	public boolean removeEmployee(Employee e) {
		if(e==null || !this.allEmployees.contains(e))
			return false;
		else {
			
			this.allEmployees.remove(e);
			return true;	
		}
	}
	
	
	}
