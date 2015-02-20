package com.example.com.ytkoff.gre;

import java.util.Collections;
import java.util.List;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class MenuAdapter extends
		RecyclerView.Adapter<MenuAdapter.MenuViewHolder> {
	LayoutInflater inflator;
	List<MenuList> menulist = Collections.emptyList();
	Context context;

	public MenuAdapter(Context context, List<MenuList> menulist) {
		inflator = LayoutInflater.from(context);
		this.menulist = menulist;
		this.context = context;
	}

	@Override
	public int getItemCount() {
		// TODO Auto-generated method stub
		return menulist.size();
	}

	@Override
	public void onBindViewHolder(MenuViewHolder holder, int position) {
		// TODO Auto-generated method stub
		holder.title.setText(menulist.get(position).getTitle());
		holder.image.setImageResource(menulist.get(position).getImageResId());

	}

	@Override
	public MenuViewHolder onCreateViewHolder(ViewGroup arg0, int arg1) {
		// TODO Auto-generated method stub
		View view = inflator.inflate(
				com.example.com.ytkoff.gre.R.layout.menuitem, arg0, false);
		MenuViewHolder viewholder = new MenuViewHolder(view);
		return viewholder;
	}

	class MenuViewHolder extends RecyclerView.ViewHolder {

		TextView title;
		ImageView image;

		public MenuViewHolder(View view) {
			super(view);
			// TODO Auto-generated constructor stub
			title = (TextView) view
					.findViewById(com.example.com.ytkoff.gre.R.id.title);
			image = (ImageView) view
					.findViewById(com.example.com.ytkoff.gre.R.id.thumbnail);
		}
	}

}
