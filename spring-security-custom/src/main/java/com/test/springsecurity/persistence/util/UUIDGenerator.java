package com.test.springsecurity.persistence.util;

import java.io.Serializable;
import java.util.UUID;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SessionImplementor;
import org.hibernate.id.IdentifierGenerator;

public class UUIDGenerator implements IdentifierGenerator {

	/*
	 * public static void main(String[] args) { for (int i = 0; i < 10; i++) {
	 * System.out.println(new HomeUnionIdGenerator().generate(null, null));
	 * System.out.println(new HomeUnionIdGenerator().generate(null, null)
	 * .toString().length()); } }
	 */

	@Override
	public Serializable generate(SessionImplementor arg0, Object arg1) throws HibernateException {
		return UUID.randomUUID().toString();
	}

}
