package com.example.android.dictionary;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import java.util.List;

/**
 * Created by SHREYA on 4/16/2017.
 */
public class WordAdapter extends ArrayAdapter<Word> {

    public WordAdapter(Context context, int resource, ArrayList<Word> objects) {
        super(context, 0, objects);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View listItemView = convertView;
        if (listItemView == null)
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent, false);
        Word current = getItem(position);
        TextView word = (TextView) listItemView.findViewById(R.id.name);
        word.setText(current.getWord());
        TextView mean = (TextView) listItemView.findViewById(R.id.summary);
        mean.setText(current.getMean());
        return listItemView;
    }
}
