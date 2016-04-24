package com.example.raghavendra.college;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Raghavendra on 4/14/2016.
 */
public class card_frag extends Fragment{
    View myView;
    RecyclerView recyclerView;
    CardAdapter adapter;
    List<Dashboard> dashboards;
    LinearLayoutManager llm;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater,ViewGroup container,Bundle savedInstanceState){
        System.out.println("YUP");
        View rootview = inflater.inflate(R.layout.recycle,container,false);
        recyclerView=(RecyclerView)rootview
                .findViewById(R.id.cardList);

        llm = new LinearLayoutManager(getActivity());

        recyclerView.setLayoutManager(llm);
        //recyclerView.setHasFixedSize(true);

        initializeData();

        adapter = new CardAdapter(dashboards);
        recyclerView.setAdapter(adapter);

        return rootview;
        // return super.onCreateView(inflater,container,savedInstanceState);

    }


    private void initializeData() {

        dashboards = new ArrayList<>();
        //dashboards.add(new Dashboard("Students enjoying the Ethnic day celebrations in student lounge ",R.drawable.at));
        dashboards.add(new Dashboard("Team Samarpana paying gratitude and respect to martyrs by honouring their families.",R.drawable.samarpana));
       // dashboards.add(new Dashboard("Jaatre celebrations", R.drawable.jaatre));

    }

}
