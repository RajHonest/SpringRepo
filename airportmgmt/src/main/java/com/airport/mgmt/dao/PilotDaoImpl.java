package com.airport.mgmt.dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.airport.mgmt.form.Pilot;

@Repository
public class PilotDaoImpl implements PilotDao {

	private static Logger log=Logger.getLogger(PilotDaoImpl.class);
	private SessionFactory sessionFactory;
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public void addPilot(Pilot pilot) {
		// TODO Auto-generated method stub
		log.info("Inside dao's addPilot");
		sessionFactory.getCurrentSession().save(pilot);
	}

	@Override
	public void updatePilot(Pilot pilot) {
		// TODO Auto-generated method stub
		log.info("Inside dao's updatePilot");
		sessionFactory.getCurrentSession().update(pilot);
	}

	@Override
	public List<Pilot> listPilot() {
		// TODO Auto-generated method stub
		Query q=sessionFactory.getCurrentSession().createQuery("from Pilot");
		List l=q.list();
		return l;
	}

	@Override
	public Pilot getPilotById(int pilotId) {
		// TODO Auto-generated method stub
		Query q=sessionFactory.getCurrentSession().createQuery("from Pilot p where p.id=:id");
		q.setParameter("id", pilotId);
		Pilot pilot=(Pilot)q.uniqueResult();
		return pilot;
	}

	@Override
	public void deletePilot(int pilotId) {
		// TODO Auto-generated method stub
		Pilot pilot=(Pilot)sessionFactory.getCurrentSession().get(Pilot.class, pilotId);
		if(pilot != null)
		{
			sessionFactory.getCurrentSession().delete(pilot);
		}
	}
}
