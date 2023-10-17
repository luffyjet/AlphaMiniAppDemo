package com.ubtechinc.alpha.mini.sdk.demo;

import android.os.Bundle;
import android.util.Log;

import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.ubtechinc.alpha.mini.sdk.AlphaMiniSdk;
import com.ubtechinc.alpha.mini.sdk.demo.databinding.ActivitySkillsBinding;
import com.ubtechinc.alpha.mini.sdk.interfaces.IAlphaMiniCallback;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;

public class SkillsActivity extends BaseActivity {

    private ActivitySkillsBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_skills);
        String json = getSkills();
        List<SkillData> skillData = new Gson().fromJson(json, new TypeToken<List<SkillData>>() {}.getType());
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        binding.skills.setLayoutManager(layoutManager);
        SkillsAdapter skillsAdapter = new SkillsAdapter(skillData);
        binding.skills.setAdapter(skillsAdapter);
        skillsAdapter.setListener(data -> {
            AlphaMiniSdk.instance().sendData(data.getSkillPath(), data.getName(), "", new IAlphaMiniCallback<String>(){
                @Override
                public void onSuccess(String s) {
                    Log.d("MainActivity", "s: " + s);
                }

                @Override
                public void onError(String s, int i) {
                    Log.d("MainActivity", "onError: " + s + ", i: " + i);
                }
            });
        });
    }

    public String getSkills(){
        try {
            InputStreamReader inputReader = new InputStreamReader(getAssets().open("skills.json"));
            BufferedReader bufReader = new BufferedReader(inputReader);
            String line="";
            String Result="";
            while((line = bufReader.readLine()) != null) {
                Result += line;
            }
            return Result;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }
}
