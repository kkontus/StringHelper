package com.kkontus.stringhelperdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.kkontus.stringhelper.StringHelper;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        StringHelper s = new StringHelper();
//        s.test();
        String broken = StringHelper.trimString("JustTestingMyLib", 5, "....");
        System.out.println(broken);
    }
}
