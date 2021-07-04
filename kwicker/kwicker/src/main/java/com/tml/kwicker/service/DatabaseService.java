package com.tml.kwicker.service;

import org.springframework.util.StringUtils;

import com.tml.kwicker.model.DataModel;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.StoredProcedureQuery;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.NativeQuery;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class DatabaseService  {

	@PersistenceContext
    private EntityManager entityManager;
	public Boolean InsertDataToCallback( String _transactionId_, String _recieptId_, String _recpient_, String _sender_, String _description_, String _totalPdu_, String _message_, String _deliverystatus_, String _deliverydt_, String _submitdt_){
		Configuration configuration = new Configuration();
		configuration.configure("hibernate.cfg.xml");
		// <!-- Database connection settings -->
		configuration.setProperty("hibernate.connection.url", "jdbc:mysql://192.168.25.130:3306/activeconnectdlr?autoReconnect=true&useSSL=false");//Here pass connection url
		configuration.setProperty("hibernate.connection.username", "root");//Here your connection username
		configuration.setProperty("hibernate.connection.password", "");//Here your connection password
		SessionFactory sessionFactory = configuration.buildSessionFactory();
		
		StoredProcedureQuery query = sessionFactory.createEntityManager().createStoredProcedureQuery("INSERT_CALLBACK_KWICKER_PANEL"); 

        //Declare the parameters in the same order
        query.registerStoredProcedureParameter(1, String.class, ParameterMode.IN);
        query.registerStoredProcedureParameter(2, String.class, ParameterMode.IN);
        query.registerStoredProcedureParameter(3, String.class, ParameterMode.IN);
        query.registerStoredProcedureParameter(4, String.class, ParameterMode.IN);
        query.registerStoredProcedureParameter(5, String.class, ParameterMode.IN);
        query.registerStoredProcedureParameter(6, String.class, ParameterMode.IN);
        query.registerStoredProcedureParameter(7, String.class, ParameterMode.IN);
        query.registerStoredProcedureParameter(8, String.class, ParameterMode.IN);
        query.registerStoredProcedureParameter(9, String.class, ParameterMode.IN);
        query.registerStoredProcedureParameter(10, String.class, ParameterMode.IN);
        //Pass the parameter values
        //query.setParameter(1,"USER_P_WEB" );
        query.setParameter(1, _transactionId_);
        query.setParameter(2, _recieptId_);
        query.setParameter(3, _recpient_);
        query.setParameter(4, _sender_);
        query.setParameter(5, _description_);
        query.setParameter(6, _totalPdu_);
        query.setParameter(7, _message_);
        query.setParameter(8, _deliverystatus_);
        query.setParameter(9, _deliverydt_);
        query.setParameter(10, _submitdt_);
        //query.setParameter(3, "USER");
        //Execute query
        
    Boolean s=    query.execute();
    return s;
	}
	
	
	public List<DataModel> Selectdata(String username, String password){
		Query  query = entityManager.createNativeQuery("SELECT message_id,recpient,description,dlr_state,done_date,submission_date,sender_name,message_pdu FROM progate_mdr_tbl  WHERE user_code=130378 AND source_id= 'campaign' AND submission_date  >= DATE_SUB(NOW(),INTERVAL 1 HOUR)  AND dlr_state='DELIVERY_FAILED'",DataModel.class); 

        //Declare the parameters in the same order
        //query.setParameter(1, String.class);
        //query.registerStoredProcedureParameter(2, String.class, ParameterMode.IN);
        //query.registerStoredProcedureParameter(3, String.class, ParameterMode.IN);

        //Pass the parameter values
        //query.setParameter(1,"USER_P_WEB" );
        //query.setParameter(1, username);
        //query.setParameter(3, "USER");
        //Execute query
    List s=    query.getResultList();
    return s;
	}
}
