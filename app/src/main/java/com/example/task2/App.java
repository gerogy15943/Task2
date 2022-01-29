package com.example.task2;

import android.app.Application;
import android.content.SharedPreferences;
import android.util.Log;
import android.widget.Toast;

public class App extends Application {

    private final String PREF_NAME = "app";
    private final String PREFERENCES_KEY = "key";
    private int counter = 0;

    @Override
    public void onCreate() {
        super.onCreate();

        SharedPreferences sPref = getSharedPreferences(PREF_NAME, MODE_PRIVATE);
        SharedPreferences.Editor editor = sPref.edit();
        if(sPref.getInt(PREFERENCES_KEY, 0) == 0) {
            counter++;
            editor.putInt(PREFERENCES_KEY, counter);
            editor.commit();
        }
        else {
            int temp = sPref.getInt(PREFERENCES_KEY, -1);
            temp++;
            if(temp == 3)
                Toast.makeText(this,
                        "Произвольный текст, Произвольный текст, Произвольный текст",
                        Toast.LENGTH_SHORT).show();
            editor.putInt(PREFERENCES_KEY, temp);
            editor.commit();
        }
    }
}