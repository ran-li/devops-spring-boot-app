package com.edgenda.bnc.skillsmanager.rest;

import com.edgenda.bnc.skillsmanager.model.Employee;
import com.edgenda.bnc.skillsmanager.model.Skill;
import com.edgenda.bnc.skillsmanager.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/employees")
public class EmployeeController {

    private final EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.GET)
    public Employee getEmployee(@PathVariable Long id) {
        return employeeService.getEmployee(id);
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<Employee> getAllEmployees() {
        return employeeService.getEmployees();
    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public Employee createEmployee(@RequestBody Employee employee) {
        return employeeService.createEmployee(employee);
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.PUT)
    public void updateEmployee(@PathVariable Long id, @RequestBody Employee employee) {
        employeeService.updateEmployee(
                new Employee(
                        id,
                        employee.getFirstName(),
                        employee.getLastName(),
                        employee.getEmail(),
                        employee.getSkills()
                )
        );
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.DELETE)
    public void deleteEmployee(@PathVariable Long id) {
        employeeService.deleteEmployee(id);
    }

    @RequestMapping(path = "/{id}/skills", method = RequestMethod.GET)
    public List<Skill> getEmployeeSkills(@PathVariable Long id) {
        return employeeService.getEmployeeSkills(id);
    }

}
