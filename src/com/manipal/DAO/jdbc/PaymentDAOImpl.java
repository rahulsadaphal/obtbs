package com.manipal.DAO.jdbc;

import static com.manipal.DAO.jdbc.ConnectionHelper.cleanup;
import static com.manipal.DAO.jdbc.ConnectionHelper.getMySqlConnection;

import com.manipal.DAO.PaymentDAO;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.ResultSet;

public class PaymentDAOImpl implements PaymentDAO
{

	@Override
	public String validateAccount(String cardNumber, String expiry,
			String cvv, double amount) {
		
		System.out.println("In Payment Section");
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		ResultSet rs2=null;
		long value = 0;

		try {
			con = getMySqlConnection();
			String query = "SELECT * FROM CARD_DETAILS WHERE CARD_NUMBER=? AND CVV=?";
			pst = (PreparedStatement) con.prepareStatement(query);
			
			pst.setString(1, cardNumber);
			pst.setString(2, cvv);
			
			rs = (ResultSet) pst.executeQuery();
			while(rs.next())
			{
				if(rs.getDouble("BALANCE")>=amount)
				{
					double remain = (rs.getDouble("BALANCE")-amount);
					System.out.println(remain);
					String subQuery = "UPDATE CARD_DETAILS SET BALANCE=? WHERE CARD_NUMBER=?";
					pst = (PreparedStatement) con.prepareStatement(subQuery);
					pst.setDouble(1, remain);
					pst.setString(2, rs.getString("CARD_NUMBER"));	
					pst.executeUpdate();
					//con.commit();
					return "Payment Done Successfully";
				}
				else 
				{
					return "You have Insufficient Balance";
				}
			}
			return "You have Entered Wrong Details";

			

		} catch (Exception e) {
			/*LOGGER.debug(e.getMessage());*/
			throw new RuntimeException(e.getMessage());
		} finally {
			cleanup(con, pst, rs);
		}
	}

	@Override
	public String validateAccount2(String accountNumber, String bank,
			String ifsc, double amount) {
		// TODO Auto-generated method stub
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		ResultSet rs2=null;
		long value = 0;

		try {
			con = getMySqlConnection();
			String query = "SELECT * FROM NET_BANKING_DETAILS WHERE ACCOUNT_NUMBER=? AND IFSC_CODE=?";
			pst = (PreparedStatement) con.prepareStatement(query);
			
			pst.setString(1, accountNumber);
			pst.setString(2, ifsc);
			
			rs = (ResultSet) pst.executeQuery();
			while(rs.next())
			{
				if((rs.getString("BANK_NAME").equals(bank)) && (rs.getDouble("BALANCE")>=amount))
				{
					String subQuery = "UPDATE NET_BANKING_DETAILS SET BALANCE=? WHERE ACCOUNT_NUMBER=?";
					pst = (PreparedStatement) con.prepareStatement(subQuery);
					pst.setDouble(1, (rs.getDouble("BALANCE")-amount));
					pst.setString(2, rs.getString("ACCOUNT_NUMBER"));
					pst.executeUpdate();
					/*con.commit();*/
					return "Payment Done Successfully";
				}
				else 
				{
					return "You have Insufficient Balance";
				}
			}
			return "You have Entered Wrong Details";

			

		} catch (Exception e) {
			/*LOGGER.debug(e.getMessage());*/
			throw new RuntimeException(e.getMessage());
		} finally {
			cleanup(con, pst, rs);
		}
	}

}
