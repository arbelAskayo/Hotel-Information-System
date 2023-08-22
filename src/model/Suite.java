package model;

import java.util.Objects;

import utils.MyFileLogWriter;

public class Suite extends SuperiorRoom implements Upgrade{
    private double balconySize;
    private final String name = "Suite";
    private boolean flag=false;
    

	public Suite(double dailyPrice, int floor, double avgDailyCost, double roomGrade, int maxPopulationCapacity,
			int size, boolean hasView, boolean hasJaccozi, double balconySize) {
		super(dailyPrice, floor, avgDailyCost, roomGrade, maxPopulationCapacity, size, hasView, hasJaccozi);
		this.setRoomNumber(name);
		this.balconySize = balconySize;
	}


	public double getBalconySize() {
		return balconySize;
	}
	



	public void setBalconySize(double balconySize) {
		this.balconySize = balconySize;
	}





	@Override
	public String toString() {
		return super.toString()+ " balconySize=" + balconySize + "]";
	}



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(balconySize, name);
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
		Suite other = (Suite) obj;
		return Double.doubleToLongBits(balconySize) == Double.doubleToLongBits(other.balconySize)
				&& Objects.equals(name, other.name);
	}


	@Override
	public void describeSpecialProperties() {
		// TODO Auto-generated method stub
		MyFileLogWriter.println("balcony Size <" +balconySize+">");

	}


	@Override
	public void upgrade() {
		// TODO Auto-generated method stub
		flag=true;
		this.setMaxPopulationCapacity(this.getMaxPopulationCapacity()+4);
	}

    
}
