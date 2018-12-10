package com.pbi.dao;


import com.pbi.bean.User;

public interface  PbiLicenseDAO {
	public Integer setDataToDatabase(User user) throws Exception;
}
