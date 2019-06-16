package com.coroutine.bod.shanghai_jounery.fm;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.coroutine.bod.shanghai_jounery.R;

public class FragmentBd extends LazyLoadFragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return LayoutInflater.from(inflater.getContext()).inflate(R.layout.fragment_aaa,container);
    }

    @Override
    protected void loadData() {
        Log.d("BobFm","try to load data "+getClass().getSimpleName());
    }
}
