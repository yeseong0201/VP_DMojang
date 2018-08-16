package com.example.ys020.vp_dmojang;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    TextView setTitle, setContent;
    ListView mListView;
    MyAdapter mMyAdapter;
    ArrayList mMyModel;

    MyModel mModel;
    ArrayList<MyModel> items = new ArrayList<>();
    FloatingActionButton mFab;
    FloatingActionButton drawing_btn;


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1000 || data !=null){
            String title = data.getStringExtra("title");
            String content = data.getStringExtra("content");

            items.add(new MyModel(title,content));
            mMyAdapter.notifyDataSetChanged();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        mModel.setTitle("title");
//        mModel.setContent("content");
        mMyAdapter = new MyAdapter(items, this);
        mFab = (FloatingActionButton) findViewById(R.id.floating_action_btn);
        drawing_btn = (FloatingActionButton) findViewById(R.id.drawing_btn); //여기
        mListView = (ListView) findViewById(R.id.main_list_view);
        mListView.setAdapter(mMyAdapter);
        mFab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Memo.class);
                startActivityForResult(intent, 1000);
            }
        });
        drawing_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Drawing.class);
                startActivityForResult(intent, 1000);


            }


        });
    }
}
