package resources

import ch.qos.logback.classic.encoder.PatternLayoutEncoder

import static ch.qos.logback.classic.Level.*

appender('CONSOLE', ConsoleAppender) {
  encoder(PatternLayoutEncoder) {
    pattern = '%d{HH:mm:ss.SSS} [%thread] %-5level %logger{36} - %msg %ex{20}%n'
  }
}

logger('com.github.bhrother', DEBUG)

root(INFO, ['CONSOLE'])