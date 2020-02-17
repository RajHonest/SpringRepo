package com.airport.mgmt.service;

import java.util.List;

import com.airport.mgmt.form.Pilot;

public interface PilotService {

	public void addPilot(Pilot pilot);
	public void updatePilot(Pilot pilot);
	public List<Pilot> listPilot();
	public Pilot getPilotById(int pilotId);
	public void deletePilot(int pilotId);
	
}
