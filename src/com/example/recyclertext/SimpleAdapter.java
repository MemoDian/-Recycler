package com.example.recyclertext;

import java.util.List;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class SimpleAdapter extends RecyclerView.Adapter<MyViewHolder> {
	private Context context;
	private List<String> data;
	private LayoutInflater inflater;

	public SimpleAdapter(Context context, List<String> data) {
		super();
		this.context = context;
		this.data = data;
		inflater=LayoutInflater.from(context);
	}

	@Override
	public int getItemCount() {
		return data.size();
	}

	@Override
	public void onBindViewHolder(MyViewHolder holder, int position) {
		holder.tvText.setText(data.get(position));
	}

	@Override
	public MyViewHolder onCreateViewHolder(ViewGroup arg0, int arg1) {
		View view = (ViewGroup) inflater.inflate(R.layout.item_text, arg0, false);
		MyViewHolder viewHolder=new MyViewHolder(view);
		return viewHolder;
	}

}

class MyViewHolder extends ViewHolder {
	TextView tvText;

	public MyViewHolder(View itemView) {
		super(itemView);
		tvText=(TextView) itemView.findViewById(R.id.tvText);
	}
}
