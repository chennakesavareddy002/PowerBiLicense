package com.pbi.service;

import com.pbi.bean.User;
import com.pbi.dao.PbiLicenseDAO;
import com.pbi.resources.Factory;

public class PbiLicenseServiceImpl implements PbiLicenseService {
	@Override
	public void provideLicense(User user) throws Exception {
		Factory factory=new Factory();
		PbiLicenseDAO pbiLicenseDAO = factory.getPbiLicenseDao();
		try {
			Integer returmadValue=pbiLicenseDAO.setDataToDatabase(user);
			if(returmadValue==null) {
				throw new Exception("PBILICENSESERVICE.FAILD");
			}
			else {
				throw new Exception("PBILICENSESERVICE.SUCCESS");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw e;
		}
	}

}
