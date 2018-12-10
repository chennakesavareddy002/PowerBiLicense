package com.pbi.resources;

import com.pbi.dao.PbiLicenseDAO;
import com.pbi.dao.PbiLicenseDAOImpl;
import com.pbi.service.PbiLicenseService;
import com.pbi.service.PbiLicenseServiceImpl;

public class Factory {
	public PbiLicenseDAO getPbiLicenseDao() {
		return new PbiLicenseDAOImpl();
	}
	public PbiLicenseService getPbiLicenseService() {
		return  new PbiLicenseServiceImpl();
	}
}
