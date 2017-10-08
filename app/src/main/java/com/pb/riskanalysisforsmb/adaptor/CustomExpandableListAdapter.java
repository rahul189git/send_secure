package com.pb.riskanalysisforsmb.adaptor;

import android.content.Context;
import android.graphics.Typeface;
import android.os.Handler;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ExpandableListView;
import android.widget.TextView;
import android.widget.Toast;

import com.pb.riskanalysisforsmb.R;
import com.pb.riskanalysisforsmb.RiskProfileItem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class CustomExpandableListAdapter extends BaseExpandableListAdapter {

    public static HashMap<String, String> checkedChilds = new HashMap<>();
    private Context context;
    private LinkedHashMap<RiskProfileItem, List<RiskProfileItem>> expandableListDetail;
    private int[] groupStatus;
    private List<RiskProfileItem> mainGroup;
    private boolean checkAll = true;

    public CustomExpandableListAdapter(Context context, ExpandableListView listView,
                                       final LinkedHashMap<RiskProfileItem, List<RiskProfileItem>> expandableListDetail) {
        this.context = context;
        this.expandableListDetail = expandableListDetail;

        groupStatus = new int[expandableListDetail.size()];

        listView.setOnGroupExpandListener(new ExpandableListView.OnGroupExpandListener() {

            public void onGroupExpand(int groupPosition) {
                RiskProfileItem group = mainGroup.get(groupPosition);
                if (expandableListDetail.get(group).size() > 0)
                    groupStatus[groupPosition] = 1;

            }
        });

        listView.setOnGroupCollapseListener(new ExpandableListView.OnGroupCollapseListener() {

            public void onGroupCollapse(int groupPosition) {
                RiskProfileItem group = mainGroup.get(groupPosition);
                if (expandableListDetail.get(group).size() > 0)
                    groupStatus[groupPosition] = 0;

            }
        });

        mainGroup = new ArrayList<>();
        for (Map.Entry<RiskProfileItem, List<RiskProfileItem>> mapEntry : expandableListDetail.entrySet()) {
            mainGroup.add(mapEntry.getKey());
        }
    }

    @Override
    public RiskProfileItem getChild(int groupPosition, int childPosition) {
        RiskProfileItem riskProfileItem = mainGroup.get(groupPosition);
        return expandableListDetail.get(riskProfileItem).get(childPosition);
    }

    @Override
    public long getChildId(int listPosition, int expandedListPosition) {
        return 0;
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        RiskProfileItem riskProfileItem = mainGroup.get(groupPosition);
        return expandableListDetail.get(riskProfileItem).size();
    }

    @Override
    public RiskProfileItem getGroup(int groupPosition) {
        return mainGroup.get(groupPosition);
    }

    @Override
    public int getGroupCount() {
        return mainGroup.size();
    }

    @Override
    public long getGroupId(int listPosition) {
        return listPosition;
    }

    @Override
    public View getChildView(final int listPosition, final int expandedListPosition,
                             boolean isLastChild, View convertView, ViewGroup parent) {

        final String expandedListText = getChild(listPosition, expandedListPosition).getAddress();
        final CustomExpandableListAdapter.ChildHolder holder;
        if (convertView == null) {
            LayoutInflater layoutInflater = (LayoutInflater) this.context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = layoutInflater.inflate(R.layout.list_item, null);
            holder = new CustomExpandableListAdapter.ChildHolder();
            holder.cb = (CheckBox) convertView.findViewById(R.id.cb);
            holder.expandedListItem = (TextView) convertView.findViewById(R.id.expandedListItem);
            convertView.setTag(holder);
        } else {
            holder = (CustomExpandableListAdapter.ChildHolder) convertView.getTag();
        }

        final RiskProfileItem child = getChild(listPosition, expandedListPosition);
        holder.cb.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            public void onCheckedChanged(CompoundButton buttonView,
                                         boolean isChecked) {
                RiskProfileItem parentGroup = getGroup(listPosition);
                child.setChecked(isChecked);

                //if the CHILD is checked
                //TODO: Here add/remove from list

                if (isChecked) {
                    List<RiskProfileItem> childList = getChild(parentGroup);
                    int childIndex = childList.indexOf(child);
                    boolean isAllChildClicked = true;
                    for (int i = 0; i < childList.size(); i++) {
                        if (i != childIndex) {
                            RiskProfileItem siblings = childList.get(i);
                            if (!siblings.isChecked()) {
                                isAllChildClicked = false;
                                //if(checkedChilds.containsKey(child.name)==false){
                                checkedChilds.put(child.getAddress(),
                                        parentGroup.getAddress());
                                //	}
                                break;
                            }
                        }
                    }

                    //All the children are checked
                    if (isAllChildClicked) {
                        Log.i("All should be checked", "Each child is Clicked!!");
                        parentGroup.setChecked(true);
                        if (!(checkedChilds.containsKey(child.getAddress()) == true)) {
                            checkedChilds.put(child.getAddress(),
                                    parentGroup.getAddress());
                        }
                        checkAll = false;
                    }
                }
                //not all of the children are checked
                else {
                    if (parentGroup.isChecked()) {
                        parentGroup.setChecked(false);
                        checkAll = false;
                        checkedChilds.remove(child.getAddress());
                    } else {
                        checkAll = true;
                        checkedChilds.remove(child.getAddress());
                    }
                    // child.isChecked =false;
                }
                notifyDataSetChanged();
            }
        });
        holder.cb.setChecked(child.isChecked());

        holder.expandedListItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(
                        getContext(),
                        child.getRiskDetails(),
                        Toast.LENGTH_SHORT
                ).show();
            }
        });
        TextView expandedListTextView = (TextView) convertView
                .findViewById(R.id.expandedListItem);
        expandedListTextView.setText(expandedListText);
        return convertView;
    }

    @Override
    public View getGroupView(int listPosition, boolean isExpanded,
                             View convertView, ViewGroup parent) {

        final CustomExpandableListAdapter.GroupHolder holder;

        String listTitle = getGroup(listPosition).getAddress();
        if (convertView == null) {
            LayoutInflater layoutInflater = (LayoutInflater) this.context.
                    getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = layoutInflater.inflate(R.layout.list_group, null);
            holder = new CustomExpandableListAdapter.GroupHolder();
            holder.cb = (CheckBox) convertView.findViewById(R.id.cb);
            convertView.setTag(holder);
        } else {
            holder = (CustomExpandableListAdapter.GroupHolder) convertView.getTag();
        }

        final RiskProfileItem groupRiskProfileItem = getGroup(listPosition);

        TextView listTitleTextView = (TextView) convertView
                .findViewById(R.id.listTitle);
        listTitleTextView.setTypeface(null, Typeface.BOLD);
        listTitleTextView.setText(listTitle);

        holder.cb.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            public void onCheckedChanged(CompoundButton buttonView,
                                         boolean isChecked) {
                if (checkAll) {
                    List<RiskProfileItem> childRiskProfileItem = getChild(groupRiskProfileItem);

                    for (RiskProfileItem children : childRiskProfileItem) {
                        children.setChecked(isChecked);
                        //TODO: Here update the list
                    }
                }
                groupRiskProfileItem.setChecked(isChecked);
                notifyDataSetChanged();
                new Handler().postDelayed(new Runnable() {

                    public void run() {
                        // TODO Auto-generated method stub
                        if (!checkAll)
                            checkAll = true;
                    }
                }, 50);

            }

        });
        holder.cb.setChecked(groupRiskProfileItem.isChecked());

        return convertView;
    }

    @Override
    public boolean hasStableIds() {
        return true;
    }

    @Override
    public boolean isChildSelectable(int listPosition, int expandedListPosition) {
        return true;
    }

    private List<RiskProfileItem> getChild(RiskProfileItem group) {
        return expandableListDetail.get(group);
    }

    public Context getContext() {
        return this.context;
    }

    private class GroupHolder {
        public CheckBox cb;

    }

    private class ChildHolder {
        public TextView expandedListItem;
        public CheckBox cb;
    }

    public boolean isCrimeRiskChecked() {
        for (Map.Entry<String, String> entry : checkedChilds.entrySet()) {
            String group = entry.getValue();
            if (group.startsWith("High Crime") | group.startsWith("Moderate Crime") | group.startsWith("Low Crime")) {
                return true;
            }
        }
        return false;
    }

    public boolean isWeatherRiskChecked() {
        for (Map.Entry<String, String> entry : checkedChilds.entrySet()) {
            String group = entry.getValue();
            if (group.startsWith("Weather Risk")) {
                return true;
            }
        }
        return false;
    }
}