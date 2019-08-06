package com.Nilkant.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class Homecontroller {

	@Autowired
	Serviceimpl service;

	@RequestMapping("/")
	public String indexpage() {
		return "login";
	}

	@RequestMapping("/reg")
	public String registerpage() {
		return "registration";
	}

	@RequestMapping("/register")
	public String registration(ModelMap model, @ModelAttribute Student stu) {
		System.out.println("In register control");
		System.out.println(stu.getUsername());
		String msg = service.savedata(stu);
		Iterable<Student> slist = service.viewalldata();
		for(Student s:slist)
		{
			System.out.println(s.getUsername());
		}
		model.addAttribute("slist", slist);
		return "viewdata";

		/*
		 * System.out.println(msg); model.addAttribute("message", msg); return "login";
		 */
	}

	/*
	 * @RequestMapping("/registerr") public String registrationn(ModelMap
	 * model,@RequestBody Student stu) { System.out.println("In register control");
	 * System.out.println(stu.getUsername()); String msg=service.savedata(stu);
	 * List<Student> stulist=service.viewalldata(); model.addAttribute(stulist);
	 * return "viewdata";
	 * 
	 * 
	 * System.out.println(msg); model.addAttribute("message", msg); return "login";
	 * 
	 * }
	 */
	@RequestMapping("/log")
	public String logincheck(ModelMap model, @ModelAttribute Student loginstudent) {
		Student loguser = service.logincheck(loginstudent);

		if (loginstudent.getUsername().equals("admin") && loginstudent.getPwd().equals("admin")) {
			Iterable<Student> slist = service.viewalldata();
			model.addAttribute("slist", slist);
			return "viewdata";
		}
		if (loguser == null) {
			String msg1 = "Incorrect credentials";
			model.addAttribute("msg1", msg1);
			return "login";
		}
		return "viewdata";
	}

	@RequestMapping("/addbtn")
	public String addButton() {
		return "registration";
	}

	@RequestMapping("/delete")
	public String deleteData(ModelMap model, @ModelAttribute Student deleteuser,@RequestParam("radioName") String id,
			BindingResult validationResult) {
		System.out.println("In delete function");
		System.out.println("Id for delete "+id);
		Student sdel=service.getvaluebyid(id);
		service.deleteData(sdel);
		Iterable<Student> dellist = service.viewalldata();
		model.addAttribute("slist", dellist);
		return "viewdata";
	}

	@RequestMapping("/update")
	public String updatedata(ModelMap model, @ModelAttribute Student stu, @RequestParam("radioName") String id,
			BindingResult validationResult) {
		System.out.println(id);
		Student s = service.getvaluebyid(id);
		int sid = s.getId();
		String uname = s.getUsername();
		String pwd = s.getPwd();
		String mobile = s.getMobile();
		String addr = s.getAddress();
		model.addAttribute("id", sid);
		model.addAttribute("uname", uname);
		model.addAttribute("pass", pwd);
		model.addAttribute("mobil", mobile);
		model.addAttribute("address", addr);
		return "update";
	}

	@RequestMapping("/updatedata")
	public String viewupdatedata(ModelMap model, @ModelAttribute Student s2) {
		Iterable<Student> stulist = service.updatedata(s2);
		model.addAttribute("slist", stulist);
		return "viewdata";
	}
}
