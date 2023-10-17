package com.ubtechinc.alpha.mini.sdk.demo;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.ubtechinc.alpha.mini.sdk.demo.databinding.ItemOpenSkillBinding;

import java.util.ArrayList;
import java.util.List;

import static com.ubtechinc.alpha.mini.sdk.demo.R.*;

public class SkillsAdapter extends RecyclerView.Adapter<SkillsAdapter.SKillViewHolder> {

    interface OnClickListener{
        void onClick(SkillData data);
    }

    List<SkillData> skillDatas = new ArrayList<>();

    public SkillsAdapter(List<SkillData> skillData) {
        this.skillDatas = skillData;
    }

    private OnClickListener listener;

    public void setListener(OnClickListener listener) {
        this.listener = listener;
    }

    @NonNull
    @Override
    public SKillViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemOpenSkillBinding binding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.item_open_skill, parent, false);
        return new SKillViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull SKillViewHolder holder, int position) {
        SkillData skillData = skillDatas.get(position);
        holder.binding.name.setText(skillData.getName());
        holder.binding.getRoot().setOnClickListener(view -> {
            if(listener != null){
                listener.onClick(skillData);
            }
        });
    }

    @Override
    public int getItemCount() {
        return skillDatas.size();
    }


    public static class SKillViewHolder extends RecyclerView.ViewHolder{
        ItemOpenSkillBinding binding;
        public SKillViewHolder(ItemOpenSkillBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}
