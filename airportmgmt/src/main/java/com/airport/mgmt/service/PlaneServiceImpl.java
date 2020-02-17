package com.airport.mgmt.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.airport.mgmt.dao.PlaneDao;
import com.airport.mgmt.form.Plane;

@Service
public class PlaneServiceImpl implements PlaneService {

	private static Logger log=Logger.getLogger(PlaneServiceImpl.class);
	
	private PlaneDao planeDao;
	public void setPlaneDao(PlaneDao planeDao) {
		this.planeDao = planeDao;
	}

	@Override
	@Transactional
	public void addPlane(Plane plane) {
		// TODO Auto-generated method stub
		log.info("Inside service's addPlane");
		planeDao.addPlane(plane);
	}

	@Override
	@Transactional
	public void updatePlane(Plane plane) {
		// TODO Auto-generated method stub
		log.info("Inside service's updatePlane");
		planeDao.updatePlane(plane);
	}

	@Override
	@Transactional
	public List<Plane> listPlane() {
		// TODO Auto-generated method stub
		log.info("Inside service's listPlane");
		List<Plane> list=planeDao.listPlane();
		return list;
	}

	@Override
	@Transactional
	public Plane getPlaneById(int planeId) {
		// TODO Auto-generated method stub
		log.info("Inside service's getPlaneById");
		Plane plane=planeDao.getPlaneById(planeId);
		return plane;
	}

	@Override
	@Transactional
	public void deletePlane(int planeId) {
		// TODO Auto-generated method stub
		log.info("Inside service's deletePlane");
		planeDao.deletePlane(planeId);
	}
}
