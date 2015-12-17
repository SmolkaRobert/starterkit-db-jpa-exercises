package com.capgemini.databases.jpa;

import com.capgemini.databases.jpa.entity.EmployeesEntity;

/**
 * Unit test for simple App.
 */
public class JpaAppTest

{
	@org.junit.Test
	public void testGetEn() {
		EmployeesEntity aFind = new JpaApp().getEntityByKey("91112901234");
		org.junit.Assert.assertNotNull(aFind);
		
//		AEnt aFindN = new JpaApp().getEntityByKey("11132423");
//		org.junit.Assert.assertNull(aFindN);
	}
}
