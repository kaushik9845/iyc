package com.iyc.dao;

import java.math.BigInteger;
import java.util.List;

import com.iyc.entity.User;


public interface LoginDao {
	
	List<User> validate(String uname,String pword);
	
	String addMobileUser(String name, String dob, BigInteger mobile);

}
