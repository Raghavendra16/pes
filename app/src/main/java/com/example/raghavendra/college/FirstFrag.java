package com.example.raghavendra.college;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class FirstFrag extends Fragment {
    View myView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater,ViewGroup container,Bundle savedInstanceState){
       System.out.println("YUP");
        return inflater.inflate(R.layout.content_qa,container,false);
       // return super.onCreateView(inflater,container,savedInstanceState);

    }


}
