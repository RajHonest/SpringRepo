package com.airport.mgmt.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.airport.mgmt.dao.PilotDao;
import com.airport.mgmt.form.Pilot;

@Service
public class PilotServiceImpl implements PilotService{

	private static Logger log=Logger.getLogger(PilotServiceImpl.class);
	private PilotDao pilotDao;
	public void setPilotDao(PilotDao pilotDao) {
		this.pilotDao = pilotDao;
	}

	@Override
	@Transactional
	public void addPilot(Pilot pilot) {
		// TODO Auto-generated method stub
		log.info("Inside service's addPilot");
		pilotDao.addPilot(pilot);
	}

	@Override
	@Transactional
	public void updatePilot(Pilot pilot) {
		// TODO Auto-generated method stub
		log.info("Inside service's updatePilot");
		pilotDao.updatePilot(pilot);
	}

	@Override
	@Transactional
	public List<Pilot> listPilot() {
		// TODO Auto-generated method stub
		log.info("Inside service's listPilot");
		List<Pilot> list=pilotDao.listPilot();
		return list;
	}

	@Override
	@Transactional
	public Pilot getPilotById(int pilotId) {
		// TODO Auto-generated method stub
		log.info("Inside service's getPilotById");
		Pilot pilot=pilotDao.getPilotById(pilotId);
		return pilot;
	}

	@Override
	@Transactional
	public void deletePilot(int pilotId) {
		// TODO Auto-generated method stub
		log.info("Inside service's deletePilot");
		pilotDao.deletePilot(pilotId);
	}
}
