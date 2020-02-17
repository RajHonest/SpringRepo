package com.airport.mgmt.dao;

import java.util.List;

import com.airport.mgmt.form.Pilot;

public interface PilotDao {

	public void addPilot(Pilot pilot);
	public void updatePilot(Pilot pilot);
	public List<Pilot> listPilot();
	public Pilot getPilotById(int pilotId);
	public void deletePilot(int pilotId);
}
