package in.nit.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.nit.model.Employee;
import in.nit.repository.IEmployeeRepository;
import in.nit.service.IEmployeeService;

@Service
public class EmployeeServiceImpl implements IEmployeeService{
	
	@Autowired
	private IEmployeeRepository repo;
	
	@Override
	public Integer saveEmployee(Employee e) {
		// TODO Auto-generated method stub
		return repo.save(e).getEmpId();
	}
	
	@Override
	public List<Employee> getAllStudents() {
		
		return repo.findAll();
	}
	
	@Override
	public void deleteEmployee(Integer id) {
		repo.deleteById(id);
		
	}
	@Override
	public boolean isExist(Integer id) {
		boolean exist=repo.existsById(id);
		return exist;
	}
	
	@Override
	public Optional<Employee> getOne(Integer id) {
		// TODO Auto-generated method stub
		return repo.findById(id);
	}
	
	@Override
	public void updateEmployee(Employee e) {
		repo.save(e);
		
	}
	
	

}
