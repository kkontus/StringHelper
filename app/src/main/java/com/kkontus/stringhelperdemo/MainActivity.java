package com.kkontus.stringhelperdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.kkontus.stringhelper.StringHelper;

import java.util.LinkedHashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String broken = StringHelper.trimString("JustTestingMyLib", 5, "....");
        System.out.println(broken);

        //use case 1
        String[] partToChange = new String[] { "first_name", "age"};
        String[] newValues = new String[] { "Kristijan", "28"};
        String formatted = StringHelper.stringFormatter("Hi first_name, you are age years old.", partToChange, newValues);
        System.out.println("CASE 1: " + formatted);

        //use case 2
        String[][] replacementsArray = {{"first_name", "Kristijan"}, {"age", "28"}};
        String formattedUsingArray = StringHelper.stringFormatter("Hi first_name, you are age years old.", replacementsArray);
        System.out.println("CASE 2: " + formattedUsingArray);

        //use case 3
        Map<String, String> valueMapping = new LinkedHashMap<>();
        valueMapping.put("first_name", "Kristijan");
        valueMapping.put("age", "28");
        String formattedUsingMap = StringHelper.stringFormatter("Hi first_name, you are age years old.", valueMapping);
        System.out.println("CASE 3: " + formattedUsingMap);
    }
}
