package com.lab02.m02.collections;

import android.app.Activity;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.CheckedTextView;
import android.widget.TextView;
import android.widget.Toast;

import com.lab02.m02.R;

public class MenuCollection extends BaseExpandableListAdapter {
    private final SparseArray<ItemCollection> grupos;
    public LayoutInflater inflater;
    public Activity activity;

    public MenuCollection(Activity activity, SparseArray<ItemCollection> grupos) {
        this.activity = activity;
        this.grupos = grupos;
        this.inflater = activity.getLayoutInflater();
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return this.grupos.get(groupPosition).getSubItems().get(childPosition);
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return 0;
    }

    @Override
    public View getChildView(int groupPosition, final int childPosition,
                             boolean isLastChild, View convertView, ViewGroup parent) {
        final String children = (String) getChild(groupPosition, childPosition);
        TextView text = null;

        if (convertView == null) {
            convertView = inflater.inflate(R.layout.menu_item_expand, null);
        }

        text = (TextView) convertView.findViewById(R.id.menu_item_text);
        text.setText(children);

        convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(activity, children, Toast.LENGTH_SHORT).show();
            }
        });

        return convertView;
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return grupos.get(groupPosition).getSubItems().size();
    }

    @Override
    public Object getGroup(int groupPosition) {
        return grupos.get(groupPosition);
    }

    @Override
    public int getGroupCount() {
        return grupos.size();
    }

    @Override
    public void onGroupCollapsed(int groupPosition) {
        super.onGroupCollapsed(groupPosition);
    }

    @Override
    public void onGroupExpanded(int groupPosition) {
        super.onGroupExpanded(groupPosition);
    }

    @Override
    public long getGroupId(int groupPosition) {
        return 0;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded,
                             View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.menu_item, null);
        }

        ItemCollection grupo = (ItemCollection) getGroup(groupPosition);
        ((CheckedTextView)convertView).setText(grupo.getTitulo());
        ((CheckedTextView)convertView).setChecked(isExpanded);

        return convertView;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return false;
    }
}
