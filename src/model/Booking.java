package model;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;



public class Booking implements Serializable, Comparable<Booking>{
	private static int runningNumber =1;
    private String bookingNumber;
    private String roomNumber;
    private Customer customer;
    private Date checkInDate;
    private Integer numberOfDays;
    private double totalRevenue;
    private double totalCost;
    
  //serialVersion
    private static final long serialVersionUID= 1L;

   
    
    // Constructor
    public Booking(String roomNumber, Customer customer, 
    		Date checkInDate, Integer numberOfDays) {
		        this.bookingNumber = (String.valueOf(this.runningNumber++));
		        this.roomNumber = roomNumber;
		        this.customer = customer;
		        this.checkInDate = checkInDate;
		        this.numberOfDays = numberOfDays;
		        this.totalCost = calculateTotalCost();
		        this.totalRevenue = calculateTotalRevenue();
            }
    


	public static int getRunningNumber() {
		return runningNumber;
	}

	// Getters and Setters
    public String getBookingNumber() {
        return bookingNumber;
    }

    public void setBookingNumber(String bookingNumber) {
        this.bookingNumber = bookingNumber;
    }
    
    public String getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(String roomNumber) {
        this.roomNumber = roomNumber;
    }

    

    public Customer getCustomer() {
		return customer;
	}



	public void setCustomer(Customer customer) {
		this.customer = customer;
	}



	public Date getCheckInDate() {
        return checkInDate;
    }

    public void setCheckInDate(Date checkInDate) {
        this.checkInDate = checkInDate;
    }

   

    public double getTotalRevenue() {
        return totalRevenue;
    }

    public void setTotalRevenue(double totalRevenue) {
        this.totalRevenue = totalRevenue;
    }
    
    

	public Integer getNumberOfDays() {
		return numberOfDays;
	}

	public void setNumberOfDays(Integer numberOfDays) {
		this.numberOfDays = numberOfDays;
	}

	public double getTotalCost() {
		return totalCost;
	}

	public void setTotalCost(double totalCost) {
		this.totalCost = totalCost;
	}

	public double calculateTotalRevenue() {
		for(Room s: Hotel.getInstance().getAllRooms().values())
	       {
	    	   if(s.getRoomNumber().equals(roomNumber))
	    	   {
	    		  this.totalRevenue = numberOfDays * s.getDailyPrice();
	    	   }
	    	   
	       }
	       return totalRevenue;
	}
	
	public double calculateTotalCost() {
		for(Room s: Hotel.getInstance().getAllRooms().values())
	       {
	    	   if(s.getRoomNumber().equals(roomNumber))
	    	   {
	    		  this.totalCost = numberOfDays * s.getAvgDailyCost();
	    	   }   
	       }
	       return totalCost;
	}



	@Override
	public String toString() {
		return "Booking [bookingNumber=" + bookingNumber + ", roomNumber=" + roomNumber + ", customer id=" + customer.getId()
				+ ", checkInDate=" + checkInDate + ", numberOfDays=" + numberOfDays + ", totalRevenue=" + totalRevenue
				+ "]";
	}



	@Override
	public int hashCode() {
		return Objects.hash(bookingNumber, checkInDate, customer, numberOfDays, roomNumber, totalCost, totalRevenue);
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Booking other = (Booking) obj;
		return Objects.equals(bookingNumber, other.bookingNumber) && Objects.equals(checkInDate, other.checkInDate)
				&& Objects.equals(customer, other.customer) && Objects.equals(numberOfDays, other.numberOfDays)
				&& Objects.equals(roomNumber, other.roomNumber)
				&& Double.doubleToLongBits(totalCost) == Double.doubleToLongBits(other.totalCost)
				&& Double.doubleToLongBits(totalRevenue) == Double.doubleToLongBits(other.totalRevenue);
	}



	@Override
	public int compareTo(Booking o) {
		// TODO Auto-generated method stub
		return Integer.parseInt(getBookingNumber())-Integer.parseInt(o.getBookingNumber());
	}



	public static void resetRunningNumber() {
		// TODO Auto-generated method stub
		runningNumber =1;
	}
	
	public static void setRunningNumber(Integer i) {
		if(i!=null) {
			Booking.runningNumber =i;
		}
		else {
			Booking.runningNumber =1;
		}
		}


	




   
	
	
}

