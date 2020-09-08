package com.codeclan.example.departmentservice;

import com.codeclan.example.departmentservice.models.Department;
import com.codeclan.example.departmentservice.models.Employee;
import com.codeclan.example.departmentservice.models.Project;
import com.codeclan.example.departmentservice.repositories.DepartmentRepository;
import com.codeclan.example.departmentservice.repositories.EmployeeRepository;
import com.codeclan.example.departmentservice.repositories.ProjectRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DepartmentserviceApplicationTests {

	@Autowired
	DepartmentRepository departmentRepository;

	@Autowired
	EmployeeRepository employeeRepository;

	@Autowired
	ProjectRepository projectRepository;

	@Test
	void contextLoads() {
	}

	@Test
	public void createEmployeeAndDepartment() {
		Department department = new Department("Finance");
		departmentRepository.save(department);

		Employee employee = new Employee("Jo", "Bloggs", 56789, department);
		employeeRepository.save(employee);
	}

	@Test
	public void createEmployeesAndProjects() {
		Department department = new Department("HR");
		departmentRepository.save(department);

		Employee employee = new Employee("Ali", "Smith", 98765, department);
		employeeRepository.save(employee);

		Project project = new Project("Contracts", 10);
		projectRepository.save(project);

		project.addEmployee(employee);
		projectRepository.save(project);
	}
}
