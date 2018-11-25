package com.pbi.dao;


import com.pbi.bean.User;

public interface  PbiLicenseDAO {
	public String setDataToDatabase(User user) throws Exception;
}
