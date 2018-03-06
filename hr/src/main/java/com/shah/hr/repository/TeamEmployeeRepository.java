package com.shah.hr.repository;

import com.shah.hr.model.TeamEmployee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeamEmployeeRepository extends JpaRepository<TeamEmployee, Long> {

}
