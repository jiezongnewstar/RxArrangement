package com.xibei.rxarrangement;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ListView menu_list;

    private List<String> titles = new ArrayList<>();

    private List<Class> activities = new ArrayList<>();

    private MyAdapter myAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        menu_list = findViewById(R.id.menu_list);

        addData();

        myAdapter = new MyAdapter();
        menu_list.setAdapter(myAdapter);
        menu_list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                startActivity(new Intent(MainActivity.this,activities.get(i)));
            }
        });


    }

    private void addData() {
        titles.add("rx_create");
        activities.add(RxCreateActivity.class);
    }


    class MyAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return titles.size();
        }

        @Override
        public Object getItem(int i) {
            return titles.get(i);
        }

        @Override
        public long getItemId(int i) {
            return i;
        }

        @Override
        public View getView(final int i, View view, ViewGroup viewGroup) {

            view = LayoutInflater.from(MainActivity.this).inflate(R.layout.item,null);

            TextView textView = view.findViewById(R.id.tv_content);

            textView.setText(titles.get(i));

            return view;
        }
    }

}
