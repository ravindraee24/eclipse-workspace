package com.gvsms.services;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.StoredProcedureQuery;

import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.NativeQuery;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
@Service
public class DBService implements DBServiceint {
	@PersistenceContext
	EntityManager manager;
	@Override 
	public boolean insercallbackboot(long _transactionId_,String _recieptId_,long _recpient_,String _sender_,String _description_,String _totalPdu_,String _message_,String _deliverystatus_,String _deliverydt_,String _submitdt_) {
		StoredProcedureQuery storedProcedure = manager.createStoredProcedureQuery("INSERT_CALLBACK_BOOT")
                .registerStoredProcedureParameter(0 , Long.class , ParameterMode.IN)
                .registerStoredProcedureParameter(1 , String.class, ParameterMode.IN)
                .registerStoredProcedureParameter(2 , Long.class, ParameterMode.IN)
                .registerStoredProcedureParameter(3 , String.class, ParameterMode.IN)
                .registerStoredProcedureParameter(4 , String.class , ParameterMode.IN)
                .registerStoredProcedureParameter(5 , String.class, ParameterMode.IN)
                .registerStoredProcedureParameter(6 , String.class, ParameterMode.IN)
                .registerStoredProcedureParameter(7 , String.class, ParameterMode.IN)
                .registerStoredProcedureParameter(8 , String.class , ParameterMode.IN)
                .registerStoredProcedureParameter(9 , String.class, ParameterMode.IN);
        
         
        storedProcedure .setParameter(0, _transactionId_)
                        .setParameter(1, _recieptId_)
                        .setParameter(2, _recpient_)
                        .setParameter(3, _sender_)
                        .setParameter(4, _description_)
                        .setParameter(5, _totalPdu_)
                        .setParameter(6, _message_)
                        .setParameter(7, _deliverystatus_)
                        .setParameter(8, _deliverydt_)
                        .setParameter(9, _submitdt_)
        ;
         
        storedProcedure.execute();
			return true;
	}
	@Override
	public List insercallbackboot()
	{
		StoredProcedureQuery storedProcedure = manager.createStoredProcedureQuery("SELECT_MESSAGE_PROCESS");
		//storedProcedure.getMaxResults();
		List<Object> results = storedProcedure.getResultList();
		return results;
	}
	
}
