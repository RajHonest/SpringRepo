package com.airport.mgmt.service;

import java.util.List;

import com.airport.mgmt.form.Plane;

public interface PlaneService {

	public void addPlane(Plane plane);
	public void updatePlane(Plane plane);
	public List<Plane> listPlane();
	public Plane getPlaneById(int planeId);
	public void deletePlane(int planeId);
	
}
