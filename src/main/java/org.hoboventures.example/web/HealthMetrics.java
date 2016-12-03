package org.hoboventures.example.web;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.actuate.health.DataSourceHealthIndicator;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.boot.actuate.health.Status;
import org.springframework.context.ApplicationContext;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Scheduled;

/**
 * Created by Asha on 12/2/2016.
 */
public class HealthMetrics implements HealthIndicator {
    Logger log = LoggerFactory.getLogger(HealthMetrics.class);

    private static boolean emailSent = false;

    @Autowired
    ApplicationContext appContext;

    @Autowired
    JavaMailSender mailSender;

    @Value("${email.to}")
    private String toAddress;

    @Scheduled(fixedDelay = 7000)
    public void detectLostDbConnection() {
        checkDataSource();
    }

    @Override
    public Health health() {
        Status errorCode = check(); // perform some specific health check
        if (StringUtils.equalsIgnoreCase(Status.UP.getCode(), errorCode.getCode())) {
            return Health.down().withDetail("Error Code", errorCode).build();
        }
        return Health.up().build();
    }

    public Status check() {
        // Your logic to check health
        return checkDataSource();
    }

    private Status checkDataSource() {
        DataSourceHealthIndicator dshi = appContext.getBean(DataSourceHealthIndicator.class);
        Health health = dshi.health();
        Status status = health.getStatus();

        if (status != null && Status.DOWN.equals(status.getCode())) {
            if (!emailSent) {
                log.error("Database connection lost");
                try {
                    mailSender.send(dbConnectionLostMailMessage());
                    emailSent = true;
                } catch (MailException ex) {
                    log.error("'Database connection lost' email notification failed");
                }
            }
        } else {
            emailSent = false;
        }
        return status;
    }

    private SimpleMailMessage dbConnectionLostMailMessage() {
        SimpleMailMessage msg = new SimpleMailMessage();
        msg.setSubject("Database connection lost");
        msg.setTo(toAddress);
        msg.setText("Houston, we have a problem");

        return msg;
    }

}
