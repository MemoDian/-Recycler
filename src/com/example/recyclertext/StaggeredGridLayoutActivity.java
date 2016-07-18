package com.example.recyclertext;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;

public class StaggeredGridLayoutActivity extends Activity {
	private RecyclerView rv;
	private List<String> datas;
	private StaggeredAdapter staggeredAdapter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_staggered);
		
		initDatas();
		
		initViews();
		
		setAdapter();
	}

	private void setAdapter() {
		staggeredAdapter = new StaggeredAdapter(this, datas);
		rv.setAdapter(staggeredAdapter);
		//设置布局管理
//		LinearLayoutManager layoutManager = new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
//		GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 3);
		StaggeredGridLayoutManager staggeredLayoutManager = new StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.VERTICAL);
		rv.setLayoutManager(staggeredLayoutManager);
		//设置分割线
//		rv.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL_LIST));
//		rv.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.HORIZONTAL_LIST));
	}

	private void initViews() {
		rv = (RecyclerView) findViewById(R.id.recyclerView);
	}

	private void initDatas() {
		datas = new ArrayList<String>();
		for(int i='A';i<='z';i++){
			datas.add(""+(char)i);
		}
	}

}
