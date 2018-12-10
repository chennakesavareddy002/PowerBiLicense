package com.pbi.dao;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.pbi.bean.User;
import com.pbi.entity.UserEntity;
import com.pbi.resources.HibernateUtility;

public class PbiLicenseDAOImpl implements PbiLicenseDAO {

	@Override
	public Integer setDataToDatabase(User user) throws Exception {
		SessionFactory sessionFactory=null;
		Session session=null;
		Integer returnedValue=null;
		try {
			sessionFactory=HibernateUtility.createSessionFactory();
			session=sessionFactory.openSession();
			session.getTransaction().begin();
			UserEntity userEntity=new UserEntity();
			userEntity.setAliasName(user.getAliasName());
			userEntity.setEmailAddress(user.getEmailAddress());
			userEntity.setTypeOfLicense(user.getTypeOfLicense());
			Date currentDate=new Date();
			String requestedDate=new SimpleDateFormat("yyyy/MM/dd").format(currentDate);
			userEntity.setRequestedDate(requestedDate);
			returnedValue=(Integer) session.save(userEntity);
			session.getTransaction().commit();
		}catch (Exception exception) {
			Logger logger=Logger.getLogger(this.getClass());
			logger.debug(exception);
			exception.printStackTrace();
			throw new Exception("DAO.TECHNICAL_ERROR");
		}finally {
			if(session!=null) {
				if(session.isOpen()) {
					session.close();
				}
			}
		}
		return returnedValue;
	}

}
