package strategypayment;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

public class paymentDAO {
	private static String  connectionUrl = "";
	private static Properties dbprops = null;
	static ArrayList<CreditCard> list=new ArrayList<CreditCard>();
	static ArrayList<Paypal> list1=new ArrayList<Paypal>();
	static
	{
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
		System.out.println("");
		 dbprops = DatabaseProperties.getInstance().getProperties();
		connectionUrl = "jdbc:mysql://" 
				+ dbprops.getProperty("server") 
				+ ":" + dbprops.getProperty("port")
				+ "/" + dbprops.getProperty("database")+"?autoReconnect=true&useSSL=false";
		}
		catch(Exception e) 
		{
			e.printStackTrace();
		}
	}
	
	{
		System.out.println("Called when the class is initialized");
	}
	
	public static Connection getConnection() throws Exception
	{
		Connection con = DriverManager.getConnection(connectionUrl, dbprops.getProperty("userid"), dbprops.getProperty("password"));
return con;
	}
    
	public static ArrayList<CreditCard> selectCreditCard() {
		Connection con = null;
		
		try {
			con = getConnection();
			PreparedStatement stmt = con.prepareStatement("select * from creditcard");
			ResultSet rs = stmt.executeQuery();
		while(rs.next()) 
		{
			CreditCard credit=new CreditCard(rs.getInt("cc"),rs.getString("pwd"),rs.getInt("amt"));
			list.add(credit);
		}
				
		} catch (Exception e) {
			System.out.println(e);
		}
		finally
		{
			if(con != null)
			{
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			}
		}
		return list;
	}
	
	public static ArrayList<Paypal> selectPaypal() {
		Connection con = null;
		
		try {
			con = getConnection();
			PreparedStatement stmt = con.prepareStatement("select * from paypal");
			ResultSet rs = stmt.executeQuery();
		while(rs.next()) 
		{
			Paypal paypal=new Paypal(rs.getString("email"),rs.getString("password"),rs.getInt("amt"));
			list1.add(paypal);
		}
				
		} catch (Exception e) {
			System.out.println(e);
		}
		finally
		{
			if(con != null)
			{
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			}
		}
		return list1;
	}
	
	public static  void updateCCbalance(int balance,int oldbalance,int ccc) {
Connection con = null;
int newbalance;
newbalance=oldbalance-balance;
		try {
			con = getConnection();
			PreparedStatement stmt = con.prepareStatement("update creditcard set amt=? where cc=?");
			stmt.setInt(1,newbalance );
			stmt.setInt(2,ccc);
			int rs = stmt.executeUpdate();
			if(rs==1) {
				System.out.println("update done successfully");
			}
				
		} catch (Exception e) {
			System.out.println(e);
		}
		finally
		{
			if(con != null)
			{
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			}
		}
	
	}

}
