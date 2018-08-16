package com.example.ys020.vp_dmojang;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MyAdapter extends BaseAdapter {
    private Context mContext;
    private LayoutInflater mInflate;
    private List<MyModel> mData;

    public MyAdapter(ArrayList<MyModel> data, Context context) {
        mData = data;
        mContext = context;
        mInflate = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return mData.size();
    }

    @Override
    public MyModel getItem(int position) {
        return mData.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
//        View v=LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_listitem,null);
//        ViewHolder holder = new ViewHolder();

        if (convertView == null) {
            convertView = mInflate.inflate(R.layout.activity_memo, parent, false);
        }

        TextView title = (TextView) convertView.findViewById(R.id.title_edt);
        TextView content = (TextView) convertView.findViewById(R.id.content_edt);

        MyModel model = getItem(position);
        title.setText(model.getTitle());
        content.setText(model.getContent());

        return convertView;
    }

    class ViewHolder {
        TextView title;
        TextView content;
    }
}


