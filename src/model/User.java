
package model;

import java.io.Serializable;
import java.util.Objects;

public class User implements Serializable{
	
    private static final long serialVersionUID= 1L;

    private String username; 
    private String password;
    private String employeeId;
    
    
	public User(String username, String password, String employeeId) {
		super();
		this.username = username;
		this.password = password;
		this.employeeId = employeeId;
		
	}
	public User(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}
		
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(username);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		return Objects.equals(username, other.username);
	}
public String toString() {
	 return "User [ User Name=" + this.username + "]";
}
//for user
public String fullToString() {
	 return "User [ User Name=" + this.username +" Password= "+this.password + "]";
}

}