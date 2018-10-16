package com.edgenda.bnc.skillsmanager.rest;

import com.edgenda.bnc.skillsmanager.model.Employee;
import com.edgenda.bnc.skillsmanager.model.Skill;
import com.edgenda.bnc.skillsmanager.service.SkillService;
import com.edgenda.bnc.skillsmanager.service.exception.UnknownSkillException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/skills")
public class SkillController {

    private final SkillService skillService;

    @Autowired
    public SkillController(SkillService skillService) {
        this.skillService = skillService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<Skill> getSkills() {
        return skillService.getSkills();
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> getSkill(@PathVariable Long id) {
        try {
            return new ResponseEntity<>(skillService.getSkill(id), HttpStatus.OK);
        } catch (UnknownSkillException e) {
            return new ResponseEntity<>(e, HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(path = "/{id}/employees", method = RequestMethod.GET)
    public List<Employee> getEmployeesWithSkill(@PathVariable Long id) {
        return skillService.getEmployeesWithSkill(id);
    }
}
