package com.example.recyclertext;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity {
	private RecyclerView rv;
	private List<String> datas;
	private SimpleAdapter adapter;
	private Button btn;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		initDatas();
		
		initViews();
		
		setAdapter();
		
		setOnclick();
	}

	private void setOnclick() {
		btn.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent=new Intent(MainActivity.this, StaggeredGridLayoutActivity.class);
				startActivity(intent);
			}
		});
	}

	private void setAdapter() {
		adapter = new SimpleAdapter(this, datas);
		rv.setAdapter(adapter);
		//设置布局管理
//		LinearLayoutManager layoutManager = new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
		GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 3);
		rv.setLayoutManager(gridLayoutManager);
		//设置分割线
		rv.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL_LIST));
		rv.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.HORIZONTAL_LIST));
	}

	private void initViews() {
		rv = (RecyclerView) findViewById(R.id.recyclerView);
		btn = (Button) findViewById(R.id.btm_huan);
	}

	private void initDatas() {
		datas = new ArrayList<String>();
		for(int i='A';i<='z';i++){
			datas.add(""+(char)i);
		}
	}

}
