package in.nit.service;

import java.util.List;
import java.util.Optional;

import in.nit.model.Employee;

public interface IEmployeeService {
	Integer saveEmployee(Employee e);
	List<Employee>getAllStudents();
	void deleteEmployee(Integer id);
	boolean isExist(Integer id);
	Optional<Employee>getOne(Integer id);
	void updateEmployee(Employee e);

}
