package com.gg.crud.jpamapping.dao;

import com.gg.crud.jpamapping.entity.Instructor;
import com.gg.crud.jpamapping.entity.InstructorDetail;

public interface AppDAO {

    void save(Instructor theInstructor);
    Instructor findInstructorById(int theId);
    void deleteInstructorById(int theId);
}
