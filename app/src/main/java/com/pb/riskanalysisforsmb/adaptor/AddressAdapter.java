package com.pb.riskanalysisforsmb.adaptor;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import com.pb.riskanalysisforsmb.R;
import com.pb.riskanalysisforsmb.activity.MultiAddressSelectActivity;
import com.pb.riskanalysisforsmb.beans.AddressVO;

import java.util.ArrayList;
import java.util.List;

public class AddressAdapter extends RecyclerView.Adapter<AddressAdapter.AddressViewHolder> {
    List<AddressVO> addressBeanList = new ArrayList();
    MultiAddressSelectActivity activity;
    Context context;

    public AddressAdapter(List<AddressVO> addressBeanList, Context context) {
        this.addressBeanList = addressBeanList;

        this.context = context;
        this.activity = (MultiAddressSelectActivity) context;
    }

    @Override
    public AddressViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_view_layout, parent, false);
        return new AddressViewHolder(view, activity);
    }

    @Override
    public void onBindViewHolder(AddressViewHolder holder, int position) {
        AddressVO address = addressBeanList.get(position);
        holder.name.setText(address.getName());
        holder.address.setText(address.getAddress());

        boolean recycleViewInAction = activity.isRecycleViewInAction();

        if (!recycleViewInAction) {
            holder.checkBox.setVisibility(View.GONE);
        } else {
            holder.checkBox.setVisibility(View.VISIBLE);
            holder.checkBox.setSelected(false);

        }

    }

    @Override
    public int getItemCount() {
        return addressBeanList.size();
    }


    public static class AddressViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView name;
        TextView address;
        CheckBox checkBox;
        MultiAddressSelectActivity multiAddressSelectActivity;

        CardView cardView;

        public AddressViewHolder(View itemLayoutView, MultiAddressSelectActivity activity) {
            super(itemLayoutView);

            name = (TextView) itemLayoutView.findViewById(R.id.name_card_box);
            address = (TextView) itemLayoutView.findViewById(R.id.card_box_address);
            checkBox = (CheckBox) itemLayoutView.findViewById(R.id.checkBox);


            multiAddressSelectActivity = activity;

            cardView = (CardView) itemLayoutView.findViewById(R.id.card_view);

            cardView.setOnLongClickListener(multiAddressSelectActivity);

            checkBox.setOnClickListener(this);


        }


        @Override
        public void onClick(View v) {
            multiAddressSelectActivity.prepareSelection(v, getAdapterPosition());

        }
    }
}
