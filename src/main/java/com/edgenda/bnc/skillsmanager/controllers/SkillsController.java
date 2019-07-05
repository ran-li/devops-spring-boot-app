package com.edgenda.bnc.skillsmanager.controllers;

import com.edgenda.bnc.skillsmanager.service.EmployeeService;
import com.edgenda.bnc.skillsmanager.service.SkillService;
import com.edgenda.bnc.skillsmanager.model.Skill;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/skills")
public class SkillsController {
    @Autowired
    private SkillService skillService;

    @Autowired
    private EmployeeService employeeService;

    @RequestMapping(method = RequestMethod.GET)
    public List<Skill> getAll() {
        return skillService.getSkills();
    }

    @RequestMapping(method = RequestMethod.GET, path = "/{id}")
    public Skill getById(@PathVariable Long id) {
        return skillService.getSkill(id);
    }

    @RequestMapping(method = RequestMethod.GET, params = "employeeId")
    public List<Skill> getByEmployeeId(@RequestParam Long employeeId) {
        return employeeService.getEmployeeSkills(employeeId);
    }
}
