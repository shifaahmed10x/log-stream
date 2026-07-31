package com.axlero.logstream.repository;

import com.axlero.logstream.entity.Log;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface LogRepository extends JpaRepository<Log , Long>, JpaSpecificationExecutor<Log>
{

}
