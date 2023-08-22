package model;

import java.util.Objects;

import utils.MyFileLogWriter;

public class StandardRoom extends Room {
    private boolean hasView;
    private final String name = "StandardRoom";


	public StandardRoom(double dailyPrice, int floor, double avgDailyCost, double roomGrade, int maxPopulationCapacity,
			int size, boolean hasView) {
		super(dailyPrice, floor, avgDailyCost, roomGrade, maxPopulationCapacity, size);
		this.setRoomNumber(name);
		this.hasView = hasView;
	}

	public boolean isHasView() {
		return hasView;
	}

	public void setHasView(boolean hasView) {
		this.hasView = hasView;
	}
	

	@Override
	public String toString() {
		return  super.toString() + " hasView=" + hasView  ;
	}

	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(hasView, name);
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
		StandardRoom other = (StandardRoom) obj;
		return hasView == other.hasView && Objects.equals(name, other.name);
	}


	@Override
	public void describeSpecialProperties() {
		// TODO Auto-generated method stub
		MyFileLogWriter.println("has View <"+hasView+">");

	}


	

    
}
