package com.ubtechinc.alpha.mini.sdk.demo;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.ubtechinc.alpha.mini.sdk.AlphaMiniSdk;
import com.ubtechinc.alpha.mini.sdk.demo.databinding.ActivityMainBinding;
import com.ubtechinc.alpha.mini.sdk.exceptions.AlphaMiniException;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        binding.connectRobot.setOnClickListener(view -> AlphaMiniSdk.router().toConnBle(this));

        binding.prp.setOnClickListener(view -> AlphaMiniSdk.router().toPrp(this));

        binding.workspace.setOnClickListener(view -> AlphaMiniSdk.router().toCodemao(this));

        binding.dance.setOnClickListener(view -> AlphaMiniSdk.router().toDance(this));

        binding.configNet.setOnClickListener(view -> {
            try {
                AlphaMiniSdk.router().toBleConfigNet(this);
            } catch (AlphaMiniException e) {
                e.printStackTrace();
            }
        });

        binding.sendCmd.setOnClickListener(view -> {
            startActivity(new Intent(MainActivity.this, SkillsActivity.class));
        });
    }
}
