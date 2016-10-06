package android.ritual.recyclerviewonclick.adapter;

import android.content.Context;
import android.ritual.recyclerviewonclick.R;
import android.ritual.recyclerviewonclick.viewholder.RecyclerViewOnClickViewHolder;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

public class RecyclerViewOnClickAdapter extends RecyclerView.Adapter<RecyclerViewOnClickViewHolder> {

    private List<String> bungkus = new ArrayList<String>();
    Context c;
    private LayoutInflater layoutInflater;
    private OnItemClickListener onItemClickListener;


    public RecyclerViewOnClickAdapter(Context context) {
        this.c = context;
        layoutInflater = LayoutInflater.from(context);
    }

    @Override
    public RecyclerViewOnClickViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LinearLayout itemLayout = (LinearLayout)layoutInflater.inflate(R.layout.recycler_view_onclick_item, parent, false);
        RecyclerViewOnClickViewHolder itemViewHolder = new RecyclerViewOnClickViewHolder(itemLayout, this);
        return itemViewHolder;
    }

    @Override
    public void onBindViewHolder(final RecyclerViewOnClickViewHolder holder, final int position) {
        holder.name.setText(bungkus.get(position));
    }

    @Override
    public int getItemCount() {
        return bungkus.size();
    }

    public void addItem(List<String> listData){
        bungkus.addAll(listData);
        notifyDataSetChanged();
    }

    public void clearItem(){
        bungkus.clear();
        notifyDataSetChanged();
    }

    public void setOnItemClickListener(OnItemClickListener listener){
        onItemClickListener = listener;
    }

    public OnItemClickListener getOnItemClickListener(){
        return onItemClickListener;
    }

    public interface OnItemClickListener{
        public void onItemClick(RecyclerViewOnClickViewHolder item, int position, View v);
    }
}
