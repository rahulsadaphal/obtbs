package com.manipal.service.impl;

import java.util.List;

import com.manipal.DAO.SeatDAO;
import com.manipal.DAO.jdbc.SeatDAOImpl;
import com.manipal.model.Seat;
import com.manipal.service.SeatService;

public class SeatServiceImpl implements SeatService
{
	SeatDAO seatDAO;

	public SeatServiceImpl()
	{
		seatDAO = new SeatDAOImpl();
	}
	// -------------------------------------------------------------------------------------------
	@Override
	public List<Seat> retrieveSeatList() {
		// TODO Auto-generated method stub
		return seatDAO.retrieveSeatList();
	}
	// -------------------------------------------------------------------------------------------
	@Override
	public Seat retrieveSeat(String seatId) {
		// TODO Auto-generated method stub
		return seatDAO.retrieveSeat(seatId);
	}
	// -------------------------------------------------------------------------------------------
	@Override
	public String doEditSeat(String seatId, Seat updatedseat) {
		// TODO Auto-generated method stub
		return seatDAO.doEditSeat(seatId, updatedseat);
	}
	// -------------------------------------------------------------------------------------------
	@Override
	public String doAddSeat(Seat seat) {
		// TODO Auto-generated method stub
		return seatDAO.doAddSeat(seat);
	}

}
