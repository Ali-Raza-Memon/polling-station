package com.fastech.pollingstation.repository;

import com.fastech.pollingstation.entity.Student_Poll;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentPollRepository extends JpaRepository<Student_Poll,Long> {

}
