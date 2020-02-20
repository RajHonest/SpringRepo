package com.hcl;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class ReferenceDataController {
	@Autowired
	CountryDao dao;

	@RequestMapping("/index")
	public ModelAndView IndexPage() {
		return new ModelAndView("index");

	}

	@RequestMapping("add")
	public ModelAndView addForm(@ModelAttribute("country") Country country) {
		return new ModelAndView("addForm");
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public ModelAndView SavePage(@ModelAttribute("country") Country country) {
		if (country.getId() == 0) {
			dao.save(country);
		} else {
			dao.save(country);
		}

		return new ModelAndView("redirect:show");

	}

	@RequestMapping(value = "/show")
	public ModelAndView showPage(@PageableDefault(value = 3, page = 0) Pageable pageable) {
		
		Page page = dao.findAll(pageable);
		List ls = page.getContent();
		ModelAndView m = new ModelAndView("Success", "list", ls);
		System.out.println("entered into show method"+page.getTotalPages()+page.getNumber());
		m.addObject("total", page.getTotalPages());
		m.addObject("current", page.getNumber());
		
		return m;

	}

	// @RequestMapping("editemployee")
	// public ModelAndView EditPage(@ModelAttribute("person") Country person,
	// HttpServletRequest req) {
	// int id = Integer.parseInt(req.getParameter("id"));
	// System.out.println("Id" + id);
	// Country pers = perdao.findById(id);
	// // List<Person> lp=perdao.FetchPerson();
	// return new ModelAndView("empform", "person", pers);
	//
	// }
	//
	// @RequestMapping("deleteemployee")
	// public ModelAndView DeletePage(@ModelAttribute("person") Country person,
	// HttpServletRequest req) { // int
	// // id=Integer.parseInt(req.getParameter("id"));
	// perdao.delete(person);
	// List<Country> lp = (List<Country>) perdao.findAll();
	// return new ModelAndView("Success", "listperson", lp);
	//
	// }
	//
	// @RequestMapping("viewemp")
	// public ModelAndView viewPage(@ModelAttribute("person") Country person) {
	// List<Country> lp = (List<Country>) perdao.findAll();
	// return new ModelAndView("Success", "listperson", lp);
	//
	// }
}