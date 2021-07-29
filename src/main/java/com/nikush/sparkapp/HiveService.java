package com.nikush.sparkapp;

import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SparkSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
public class HiveService {

    @Autowired
    private SparkSession sparkSession;

    @Value("${spark.sql.query}")
    private String sqlQuery;

    @Value("${spark.sql.query.column}")
    private String column;


    @Autowired
    private ApplicationContext applicationContext;

    public void getTablesName() {

        Dataset<Row> sqlDf = sparkSession.sql(sqlQuery); // 8 partitions
        DemoAbstract process = new ProcessSerialized();

        System.out.println("object name=>" + process.toString());
        List<String> listColumns = sqlDf.select(column)
                .javaRDD()
                .map(row -> {
                    return process.convert(row);
                })
                .collect();


      /*   .mapPartitions(iterator -> {
                    // iterator [125k] rows (row->{
                        // transformation - jar
                    // })
                }) */

    }
}