package com.nikush.sparkapp;

import org.apache.spark.sql.Row;

public abstract class DemoAbstract {
    abstract String convert(Row row);
}
