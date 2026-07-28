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

    @Column(name = "application_name", nullable = false)
    private String applicationName;

    @Column(name = "service_name", nullable = false)
    private String serviceName;

    @Column(name = "host_name", nullable = false)
    private String hostName;

    @Enumerated(EnumType.STRING)
    @Column(name = "log_level", nullable = false)
    private LogLevel logLevel;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String message;

    @Column(name = "logger_name")
    private String loggerName;

    @Column(name = "thread_name")
    private String threadName;

    @Column(name = "timestamp", nullable = false)
    private LocalDateTime timestamp;

    @CreationTimestamp
    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

}
