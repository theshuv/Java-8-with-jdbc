package dao;

import java.sql.Date;
import java.util.ArrayList;

import pojo.Vendors;

public interface IvendDao {
	ArrayList<Vendors> viewall(String city,Date date)throws Exception;
	String update(String newcity , String phone_no , String email)throws Exception;
	String delete(String email)throws Exception;

}
