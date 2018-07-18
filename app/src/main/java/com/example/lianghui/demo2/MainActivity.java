package com.example.lianghui.demo2;

import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                click();
            }
        });

        TextView textView = findViewById(R.id.textView);
        textView.setText(String.format(Locale.getDefault(), "Version: %s", getVersionName()));

        // i am demo2
        // i am demo22 change
    }

    private void click() {
        String str = getVersionName();
        Toast.makeText(this, str, Toast.LENGTH_SHORT).show();
    }

    /**
     * 获取当前应用的版本号
     */
    public String getVersionName() {
        PackageInfo pInfo;
        try {
            pInfo = getPackageManager().getPackageInfo(getPackageName(), 0);
            return pInfo.versionName;
        } catch (PackageManager.NameNotFoundException e) {

        }
        return "";
    }
}
