package com.axlero.logstream.repository;

import com.axlero.logstream.entity.Log;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface LogRepository extends JpaRepository<Log, Long>, JpaSpecificationExecutor<Log> {

    @Query("""
SELECT l.logLevel, COUNT(l)
FROM Log l
GROUP BY l.logLevel
""")
    List<Object[]> countByLogLevel();


    @Query("""
SELECT l.applicationName, COUNT(l)
FROM Log l
GROUP BY l.applicationName
""")
    List<Object[]> countByApplicationName();


    @Query("""
SELECT DATE(l.timestamp), COUNT(l)
FROM Log l
GROUP BY DATE(l.timestamp)
ORDER BY DATE(l.timestamp)
""")
    List<Object[]> countLogsPerDay();
}
