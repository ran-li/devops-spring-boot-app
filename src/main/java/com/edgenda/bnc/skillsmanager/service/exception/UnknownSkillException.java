package com.edgenda.bnc.skillsmanager.service.exception;

public class UnknownSkillException extends RuntimeException {

    public UnknownSkillException(Long id) {
        super("Unknown Skill with ID=" + id);
    }

}
