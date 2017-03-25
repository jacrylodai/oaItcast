package com.ldp.oa.common.test;

import org.hibernate.SessionFactory;
import org.junit.Test;

public class SessionFactoryTest extends BeanSpring{

	@Test
	public void testSessionFactory(){
		SessionFactory sessionFactory = 
			(SessionFactory) context.getBean("sessionFactory");
	}
	
}
