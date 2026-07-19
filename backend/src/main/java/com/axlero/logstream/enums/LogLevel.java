package com.axlero.logstream.enums;
/**
 * Supported log levels for log entries.
 */
public enum LogLevel {
    TRACE, // Most detailed logging
    DEBUG, //Debugging information
    INFO, //Normal application events
    WARN,//Something unexpected, but application continues
    ERROR, //Error occurred
    FATAL //Critical error, application may stop
}
