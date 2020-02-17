package com.airport.mgmt.dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.airport.mgmt.form.Plane;

@Repository
public class PlaneDaoImpl implements PlaneDao {
	
	private static Logger log=Logger.getLogger(PlaneDaoImpl.class);
	private SessionFactory sessionFactory;
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public void addPlane(Plane plane) {
		// TODO Auto-generated method stub
		log.info("Inside dao's addPlane");
		sessionFactory.getCurrentSession().save(plane);
	}

	@Override
	public void updatePlane(Plane plane) {
		// TODO Auto-generated method stub
		log.info("Inside dao's updatePlane");
		sessionFactory.getCurrentSession().update(plane);
	}

	@Override
	public List<Plane> listPlane() {
		// TODO Auto-generated method stub
		Query q=sessionFactory.getCurrentSession().createQuery("from Plane");
		List l=q.list();
		return l;
	}

	@Override
	public Plane getPlaneById(int planeId) {
		// TODO Auto-generated method stub
		Query q=sessionFactory.getCurrentSession().createQuery("from Plane p where p.id=:id");
		q.setParameter("id", planeId);
		Plane plane=(Plane)q.uniqueResult();
		return plane;
	}

	@Override
	public void deletePlane(int planeId) {
		// TODO Auto-generated method stub
		Plane plane=(Plane)sessionFactory.getCurrentSession().get(Plane.class, planeId);
		if(plane != null)
		{
			sessionFactory.getCurrentSession().delete(plane);
		}
	}
}
