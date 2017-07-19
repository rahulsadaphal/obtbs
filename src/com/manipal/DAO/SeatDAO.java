package com.manipal.DAO;

import java.util.List;

import com.manipal.model.Seat;

public interface SeatDAO 
{	
	public List<Seat> retrieveSeatList();
	
	public Seat retrieveSeat(String seatId);
	
	public String doEditSeat(String seatId,Seat updatedseat);
	
	public String doAddSeat(Seat seat);
	

}
