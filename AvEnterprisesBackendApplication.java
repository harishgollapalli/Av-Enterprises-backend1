package com.aventerprises.backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AvEnterprisesBackendApplication {

    public static void main(String[] args) {
        var context = SpringApplication.run(AvEnterprisesBackendApplication.class, args);
        String activeProfiles = String.join(", ", context.getEnvironment().getActiveProfiles());
        System.out.println("✅ Active Profiles: " + (activeProfiles.isEmpty() ? "default" : activeProfiles));
    }
}
