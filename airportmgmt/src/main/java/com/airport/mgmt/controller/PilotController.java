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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.airport.mgmt.form.Pilot;
import com.airport.mgmt.service.PilotService;

@Controller
@RequestMapping("/api/pilot")
public class PilotController {


	private static Logger log=Logger.getLogger(PilotController.class);
	private PilotService pilotService;
	
	@Autowired(required=true)
	@Qualifier(value="pilotService")
	public void setPilotService(PilotService pilotService) {
		this.pilotService = pilotService;
	}

	@RequestMapping(value="/")
	public String listPilot(Map<String,Object> map)
	{
		map.put("pilot", new Pilot());
		map.put("pilotList", pilotService.listPilot());
		log.info("Inside list pilot");
		return "pilot";
	}
	
	@RequestMapping(value="/add",method=RequestMethod.POST)
	public String addPilot(@ModelAttribute("pilot")@Validated Pilot pilot,BindingResult bindingResult,Model model)
	{
		if(bindingResult.hasErrors())
		{
			log.info("Validation error");
			model.addAttribute("pilotList", pilotService.listPilot());
			return "pilot";
		}
		else
		{
			log.info("Inside add pilot");
			if(null==pilot.getPilotId())
			{
				Random rand=new Random();
				int num=rand.nextInt(900000)+1000000;
				pilot.setPilotId(num);
				log.info("Before add pilot");
				pilotService.addPilot(pilot);
			}
			else
			{
				log.info("Before update pilot");
				pilotService.updatePilot(pilot);
			}
			return "redirect:/api/pilot/";
		}
	}
	
	@RequestMapping("/edit/{pilotId}")
	public String editPilot(@PathVariable("pilotId")Integer pilotId, Map<String,Object>map)
	{
		map.put("pilot", pilotService.getPilotById(pilotId));
		log.info("Getting details for palne ID"+pilotId);
		
		map.put("pilotList", pilotService.listPilot());
		log.info("Retrieving pilot information");
		
		return "pilot";
	}
	
	@RequestMapping("/delete/{pilotId}")
	public String deletePilot(@PathVariable("pilotId")Integer pilotId, Map<String,Object>map, RedirectAttributes redirectAttrs)
	{
		log.info("Deleting pilot information:"+pilotId);
		pilotService.deletePilot(pilotId);
		map.put("message", "Pilot details deleted successfully");
		redirectAttrs.addFlashAttribute("message", "Pilot details deleted successfully");
		return "redirect:/result";
	}
}
