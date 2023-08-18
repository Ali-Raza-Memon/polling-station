package com.fastech.pollingstation.repository;

import com.fastech.pollingstation.entity.Poll;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PollRepository extends JpaRepository<Poll,Long> {
    @Query("SELECT p FROM Poll p JOIN p.class_ c JOIN c.students s WHERE s.id =?1")
    List<Poll> findByClass_Polls_Student_Id(Long studentId);
}
