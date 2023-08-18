package com.fastech.pollingstation.repository;

import com.fastech.pollingstation.entity.Class_;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClassRepository extends JpaRepository<Class_,Long> {
}
