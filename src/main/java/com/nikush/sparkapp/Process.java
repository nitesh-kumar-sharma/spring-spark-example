package com.nikush.sparkapp;

import org.apache.spark.sql.Row;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

@Component
@ConditionalOnProperty(name = "process.serialize", havingValue = "true")
class Process extends DemoAbstract {
    String convert(Row row) {
        return row.mkString();
    }
}