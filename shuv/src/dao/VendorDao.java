package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import pojo.Vendors;

import static Utils.DbUtils.fetchconnection;

public class VendorDao implements IvendDao,AutoCloseable{
	private Connection cn;
	private PreparedStatement ps1,ps2,ps3;
	
	public VendorDao() throws Exception{
		
		cn=fetchconnection();
		ps1=cn.prepareStatement("select * from vendors where city=? and reg_date > ?");
		ps2=cn.prepareStatement("update vendors set city=?,phone_no=? where email=?");
		ps3=cn.prepareStatement("delete from vendors where email=?");
		
	}

	@Override
	public void close() throws Exception {
	if(ps1!=null)
		ps1.close();
	if(ps2!=null)
		ps2.close();
	if(ps3!=null)
		ps3.close();
	}

	@Override
	public ArrayList<Vendors> viewall(String city, Date date) throws Exception {
		ps1.setString(1, city);
		ps1.setDate(2, date);
		
		ArrayList<Vendors>l1=new ArrayList<>();
		try(ResultSet rst=ps1.executeQuery()){
			while(rst.next())
				l1.add(new Vendors(rst.getInt(1), rst.getString(2), rst.getString(3), rst.getString(4), rst.getString(5), rst.getDate(6)));
			return l1;
			
		}
		
	}

	@Override
	public String update(String newcity , String phone_no , String email) throws Exception {
		ps2.setString(1, newcity);
		ps2.setString(2, phone_no);
		ps2.setString(3, email);
		int rst=ps2.executeUpdate();
		if(rst>0)
			System.out.println("Vendor details Successfully Updated");
		return "Vendor not found";
		
		
		
	}

	@Override
	public String delete(String email) throws Exception {
		ps3.setString(1, email);
		
		int rst=ps3.executeUpdate();
		if(rst>0)
			System.out.println("Vendor details successfully Deleted");
		return "Invalid vendor email";
		
		
		
	}

}
