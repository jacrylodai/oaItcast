package com.ldp.oa.resource.dao.impl;

import java.sql.SQLException;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.stereotype.Repository;

import com.ldp.oa.common.dao.impl.BaseDaoImpl;
import com.ldp.oa.resource.dao.VersionDao;
import com.ldp.oa.resource.domain.Version;

@Repository("versionDao")
public class VersionDaoImpl extends BaseDaoImpl<Version> implements VersionDao{

	@Override
	public void deleteVersionByKynamicId(final Long kynamicId) {

		final String sql = 
			"delete from Version version where version.kynamic.kynamicId=:kynamicId";
		hibernateTemplate.execute(new HibernateCallback() {
			
			@Override
			public Object doInHibernate(Session session) throws HibernateException,
					SQLException {
				
				Query query = session.createQuery(sql);
				query.setLong("kynamicId",kynamicId);
				int rowAffected = query.executeUpdate();
				return rowAffected;
			}
		});
	}

}
