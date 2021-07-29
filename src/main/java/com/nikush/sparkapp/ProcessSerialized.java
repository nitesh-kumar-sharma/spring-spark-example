package com.nikush.sparkapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

import java.io.Serializable;


@Component
@ConditionalOnProperty(name = "process.dummy.serialize", havingValue = "true")
class ProcessSerialized extends Process implements Serializable {
  /* @Autowired
      private Record record;
*/
    public void setName(String name) {
        this.name = name;
    }


    private String name;

    @Override
    public String toString() {
        return "ProcessSerialized";
    }
}