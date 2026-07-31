package com.axlero.logstream.specification;

import com.axlero.logstream.dto.request.SearchRequest;
import com.axlero.logstream.entity.Log;
import com.axlero.logstream.enums.LogLevel;
import org.springframework.data.jpa.domain.Specification;

import java.util.ArrayList;
import java.util.List;
import jakarta.persistence.criteria.Predicate;

public class LogSpecification {

    public static Specification<Log> search(SearchRequest request){
        return (root, query ,criteriaBuilder)->{
            List<Predicate> predicates = new ArrayList<>();
            if(request.getApplicationName() !=null && !request.getApplicationName().isBlank()){
                predicates.add(
                        criteriaBuilder.equal(root.get("applicationName"),
                                request.getApplicationName())
                );
            }
            if(request.getServiceName() !=null && !request.getServiceName().isBlank()){
                predicates.add(
                        criteriaBuilder.equal(
                                root.get("serviceName"),
                                request.getServiceName()
                        )
                );
            }
            if(request.getHostName() !=null && !request.getHostName().isBlank()){
                predicates.add(criteriaBuilder.equal(
                        root.get("hostName"),
                        request.getHostName()
                        )
                );
            }
            if(request.getLoggerName() !=null && !request.getLoggerName().isBlank()){
                predicates.add(
                        criteriaBuilder.equal(
                                root.get("loggerName"),
                                request.getLoggerName()
                                )
                );
            }
            if(request.getThreadName() !=null && !request.getThreadName().isBlank()){
                predicates.add(
                        criteriaBuilder.equal(
                                root.get("threadName"),
                                request.getThreadName()
                        )
                );

            }
            if(request.getLogLevel() !=null && !request.getLogLevel().isBlank()){
                LogLevel level = LogLevel.valueOf(request.getLogLevel().toUpperCase());
                predicates.add(criteriaBuilder.equal(
                        root.get("logLevel"),
                        level
                ));
            }
            if(request.getStartDate() !=null && request.getEndDate() !=null){

                predicates.add(criteriaBuilder.between(root.get("timestamp"),
                        request.getStartDate(),
                        request.getEndDate())
                );
            }
            if(request.getKeyword() !=null && !request.getKeyword().isBlank()){
                String keyword = "%" + request.getKeyword().toLowerCase() + "%";

                predicates.add(
                        criteriaBuilder.or(
                                criteriaBuilder.like(
                                        criteriaBuilder.lower(root.get("message")),keyword
                                ),
                                criteriaBuilder.like(
                                        criteriaBuilder.lower(root.get("applicationName")),keyword
                                ),
                                criteriaBuilder.like(
                                        criteriaBuilder.lower(root.get("serviceName")),keyword
                                )
                        )
                );
            }
            return criteriaBuilder.and(
                    predicates.toArray(new Predicate[0])
            );
        };
    }

}
