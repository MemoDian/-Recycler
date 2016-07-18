package com.example.recyclertext;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.TextView;

public class StaggeredAdapter extends RecyclerView.Adapter<StaggeredAdapter.MyViewHolder> {
	private Context context;
	private List<String> data;
	private LayoutInflater inflater;
	private List<Integer> heights;

	public StaggeredAdapter(Context context, List<String> data) {
		super();
		this.context = context;
		this.data = data;
		inflater=LayoutInflater.from(context);
		heights=new ArrayList<Integer>();
		for(int i=0;i<data.size();i++){
			heights.add((int) (100+Math.random()*300));
		}
	}

	@Override
	public int getItemCount() {
		return data.size();
	}

	@Override
	public void onBindViewHolder(MyViewHolder holder, int position) {
		LayoutParams lp = holder.itemView.getLayoutParams();
		lp.height=heights.get(position);
		holder.itemView.setLayoutParams(lp);;
		holder.tvText.setText(data.get(position));
	}

	@Override
	public StaggeredAdapter.MyViewHolder onCreateViewHolder(ViewGroup arg0, int arg1) {
		View view = (ViewGroup) inflater.inflate(R.layout.item_text, arg0, false);
		MyViewHolder viewHolder=new MyViewHolder(view);
		return viewHolder;
	}
	
	class MyViewHolder extends ViewHolder {
		TextView tvText;

		public MyViewHolder(View itemView) {
			super(itemView);
			tvText=(TextView) itemView.findViewById(R.id.tvText);
		}
	}

}

