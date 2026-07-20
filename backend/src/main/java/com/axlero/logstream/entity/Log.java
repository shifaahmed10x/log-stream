package com.axlero.logstream.entity;

import com.axlero.logstream.enums.LogLevel;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDateTime;

/**
 * Represents a single log entry received by the Log Stream platform.
 */

@Entity
@Table(name="logs")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Log {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    @Column(name = "application_name", nullable = false)
    private String applicationName;
    @NotBlank
    @Column(name = "service_name", nullable = false)
    private String serviceName ;
    @NotBlank
    @Column(name = "host_name", nullable = false)
    private String hostName;
    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name="log_level",nullable = false)
    private LogLevel logLevel;
    @NotBlank
    @Column(columnDefinition = "TEXT",nullable = false)
    private String message ;
    @Column(name = "logger_name")
    private String loggerName;
    @Column(name = "thread_name")
    private String threadName;
    @NotNull
    @Column(name="timestamp",nullable = false)
    private LocalDateTime timestamp;
    @CreationTimestamp
    @Column(name="created_at",nullable = false,updatable = false)
    private LocalDateTime createdAt;

}
