package com.tml.hulcsvexport.dataservice;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.StoredProcedureQuery;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Service;

import com.tml.hulcsvexport.model.Dataset;
@Service
public class dataService {
	@PersistenceContext
    private EntityManager entityManager;
	public List<Dataset> InsertDataToCallback( ){
				
		Query query = entityManager.createNativeQuery("SELECT mcbid AS id,REPLACE (vmn,'8800707070','7303658515')vmn,`inserttime`,`coupon`,`operator`,`circle`,MD5(msisdn)msisdn,missedcalldate FROM `mcb_calldetails`WHERE inserttime> DATE_SUB(CURDATE(), INTERVAL 1 WEEK)",Dataset.class); 

        
        
    List<Dataset> s=    query.getResultList();
    return s;
	}

}
