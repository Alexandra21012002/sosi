package com.example.repit.repositories;

import com.example.repit.entities.Student;
import com.example.repit.entities.Tutor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TutorRepository  extends JpaRepository<Tutor, Integer> {

}
