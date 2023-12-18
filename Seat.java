package Trainwagon;

public class Seat {
	private String seatNumber;
    private String occupant;

    public Seat(String seatNumber) {
        this.seatNumber = seatNumber;
        this.occupant = null;
    }

    public String getSeatNumber() {
        return seatNumber;
    }

    public String getOccupant() {
        return occupant;
    }

    public void assignSeat(String occupant) {
        this.occupant = occupant;
    }

    public boolean isOccupied() {
        return occupant != null;
    }
    
    public boolean isBroken() {
        return seatNumber.equals("3") || seatNumber.equals("9") || seatNumber.equals("10");
    }

}
