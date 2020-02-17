package com.airport.mgmt.dao;

import java.util.List;

import com.airport.mgmt.form.Plane;

public interface PlaneDao {
	public void addPlane(Plane plane);
	public void updatePlane(Plane plane);
	public List<Plane> listPlane();
	public Plane getPlaneById(int planeId);
	public void deletePlane(int planeId);
}
