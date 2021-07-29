package com.nikush.sparkapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SparkExperimentApplication implements CommandLineRunner {

    @Autowired
    private HiveService hiveService;

    public static void main(String[] args) {
        SpringApplication.run(SparkExperimentApplication.class, args);
    }

    @Override
    public void run(String... strings) {
        hiveService.getTablesName();
        System.exit(0);
    }
}