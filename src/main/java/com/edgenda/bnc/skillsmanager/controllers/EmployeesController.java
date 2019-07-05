package com.edgenda.bnc.skillsmanager.controllers;

import com.edgenda.bnc.skillsmanager.model.Employee;
import com.edgenda.bnc.skillsmanager.service.EmployeeService;
import com.edgenda.bnc.skillsmanager.service.SkillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeesController {

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private SkillService skillService;

    @RequestMapping(method = RequestMethod.GET)
    public List<Employee> getAll() {
        return employeeService.getEmployees();
    }

    @RequestMapping(method = RequestMethod.GET, path = "/{id}")
    public ResponseEntity getById(@PathVariable Long id) {
        Employee emp = employeeService.getEmployee(id);
        if (emp == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(emp, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public void createEmployee(@RequestBody Employee emp) {
        employeeService.createEmployee(emp);
    }

    @RequestMapping(method = RequestMethod.PUT)
    public void updatEmployee(@RequestBody Employee emp) {
        employeeService.updateEmployee(emp);
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.DELETE)
    public void deleteById(@PathVariable Long id) {
        employeeService.deleteEmployee(id);
    }

    @RequestMapping(method = RequestMethod.GET, params = "skillId")
    public List<Employee> getBySkillId(@RequestParam Long skillId) {
        return skillService.getEmployeesWithSkill(skillId);
    }
}
