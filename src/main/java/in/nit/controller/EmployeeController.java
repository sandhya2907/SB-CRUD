package in.nit.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import in.nit.model.Employee;
import in.nit.service.IEmployeeService;

@Controller
@RequestMapping("/employee")
public class EmployeeController {
	
	@Autowired
	private IEmployeeService service;
	
	@RequestMapping("/register")
	public String showRegister(Model model) {
		model.addAttribute("emp", new Employee());
		return "EmployeeRegisterPage";
		
	}
	
	@RequestMapping(value="/create",method = RequestMethod.POST)
	public String saveEmployee(@ModelAttribute Employee e,Model model) {
		Integer id=service.saveEmployee(e);
		String message="Employee Data saved : "+id;
		model.addAttribute("msg", message);
		//form backing object
		model.addAttribute("emp", new Employee());
		return "EmployeeRegisterPage";
		
		
	}
	
	@RequestMapping("/all")
	public String fetchAllEmployees(Model  model) {
		List<Employee>list=service.getAllStudents();
		model.addAttribute("list",list);
		return "EmployeeData";
		
	}
	
	
	@RequestMapping("/delete/{id}")
	public String removeEmployee(@PathVariable Integer id,Model model) {
		String msg=null;
		if(service.isExist(id)) {
			service.deleteEmployee(id);
			msg="Employee record deleted: "+id;
		}else {
			msg="Records not found";
		}
		model.addAttribute("msg", msg);
		List<Employee>list=service.getAllStudents();
		model.addAttribute("list",list);
		return "EmployeeData";
		
	}
	
	
	@RequestMapping("/edit/{id}")
	public String editEmployee(@PathVariable Integer id,Model model) {
		String page=null;
		Optional<Employee>opt=service.getOne(id);
		if(opt.isPresent()) {
			Employee e=opt.get();
			model.addAttribute("emp",e);
			page="EditEmployeePage";
		}else {
			page="redirect.../all";
		}
		return page;
		
	}
	
	@RequestMapping(value="/update",method=RequestMethod.POST)
	public String updateEmployee(@ModelAttribute Employee e,Model model) {
		service.updateEmployee(e);
		String message="Updated Record" +e.getEmpId();
		model.addAttribute("msg", message);
		//fetch other rows
		List<Employee>list=service.getAllStudents();
		model.addAttribute("list",list);
		return "EmployeeData";
		
	}

}
