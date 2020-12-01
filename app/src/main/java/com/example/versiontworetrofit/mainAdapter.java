package com.example.versiontworetrofit;

import android.content.Context;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class mainAdapter extends RecyclerView.Adapter<mainAdapter.mainAdapterVH> {

    private ArrayList<String> arrayList;
    private Context context;
    private TextView textView;
    private ClickedItem clickedItem;

    public mainAdapter(ClickedItem clickedItem){
        this.clickedItem = clickedItem;
    }

    public void setData(ArrayList<String> choices){
        this.arrayList = choices;
        notifyDataSetChanged();

    }
    public interface  ClickedItem{
        public void ClickedUser(String string);
    }

    @NonNull
    @Override
    public mainAdapterVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = parent.getContext();

        return new mainAdapter.mainAdapterVH(LayoutInflater.from(context).inflate(R.layout.recycler_content, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull mainAdapterVH holder, int position) {
        String choices = arrayList.get(position);
        holder.choices.setText(choices);
        holder.choices.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                clickedItem.ClickedUser((String)holder.choices.getText());
            }
        });
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class mainAdapterVH extends RecyclerView.ViewHolder {

        TextView choices,joke;
        public mainAdapterVH(@NonNull View itemView) {
            super(itemView);
            choices = itemView.findViewById(R.id.information);

        }
    }
}
