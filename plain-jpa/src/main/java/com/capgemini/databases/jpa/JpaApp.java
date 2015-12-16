package com.capgemini.databases.jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.apache.log4j.Logger;

/**
 * Hello world!
 *
 */
public class JpaApp 
{
	static Logger logger = Logger.getLogger(JpaApp.class);
	
   
    public EmployeesEntity getEntityByKey(String key) {

    	EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("plain-jpa");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        
        EmployeesEntity aE = entityManager.find(EmployeesEntity.class, key);
        //TODO RSmolka remove sysouts
        System.out.println(aE.getPesel());
        System.out.println(aE.getLastName());
//        aE.setName("fff");
//        aE.setName("fff");
//        entityManager.flush();
        
        entityManager.close();
        entityManagerFactory.close();

        return aE;
    }
}
