package me.khrystal.htb;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void first(View view) {
        startActivity(new Intent(MainActivity.this,FirstActivity.class));
    }

    public void second(View view) {
        startActivity(new Intent(MainActivity.this,SecondActivity.class));
    }

    public void third(View view) {
        startActivity(new Intent(MainActivity.this,ThridActivity.class));
    }
}
