package com.airport.mgmt.controller;

import java.util.Map;
import java.util.Random;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.airport.mgmt.form.Plane;
import com.airport.mgmt.service.PlaneService;

@Controller
@RequestMapping("/plane")
public class PlaneController {

	private static Logger log=Logger.getLogger(PlaneController.class);
	private PlaneService planeService;
	
	@Autowired(required=true)
	@Qualifier(value="planeService")
	public void setPlaneService(PlaneService planeService) {
		this.planeService = planeService;
	}

	@RequestMapping(value="/")
	public String listPlane(Map<String,Object> map)
	{
		map.put("plane", new Plane());
		map.put("planeList", planeService.listPlane());
		log.info("Inside list plane");
		return "plane";
	}
	
	@RequestMapping(value="/add",method=RequestMethod.POST)
	public String addPlane(@ModelAttribute("plane")@Validated Plane plane,BindingResult bindingResult,Model model)
	{
		if(bindingResult.hasErrors())
		{
			log.info("Validation error");
			model.addAttribute("planeList", planeService.listPlane());
			return "plane";
		}
		else
		{
			log.info("Inside add plane");
			if(null==plane.getId())
			{
				Random rand=new Random();
				int num=rand.nextInt(900000)+1000000;
				plane.setId(num);
				log.info("Before add plane");
				planeService.addPlane(plane);
			}
			else
			{
				log.info("Before update plane");
				planeService.updatePlane(plane);
			}
			return "redirect:/plane/";
		}
	}
	
	@RequestMapping("/edit/{planeId}")
	public String editPlane(@PathVariable("planeId")Integer planeId,Map<String,Object>map)
	{
		map.put("plane", planeService.getPlaneById(planeId));
		log.info("Getting details for palne ID"+planeId);
		
		map.put("planeList", planeService.listPlane());
		log.info("Retrieving plane information");
		
		return "plane";
	}
	
	@RequestMapping("/delete/{planeId}")
	public String deletePlane(@PathVariable("planeId")Integer planeId)
	{
		planeService.deletePlane(planeId);
		log.info("Deleting plane information"+planeId);
		return "redirect:/plane/";
	}
}
