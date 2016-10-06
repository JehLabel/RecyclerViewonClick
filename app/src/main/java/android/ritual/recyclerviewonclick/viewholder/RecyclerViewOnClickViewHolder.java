package android.ritual.recyclerviewonclick.viewholder;

import android.ritual.recyclerviewonclick.R;
import android.ritual.recyclerviewonclick.adapter.RecyclerViewOnClickAdapter;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

public class RecyclerViewOnClickViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
  public final TextView name;
  private RecyclerViewOnClickAdapter parent;

  public RecyclerViewOnClickViewHolder(View itemView, RecyclerViewOnClickAdapter parent) {
    super(itemView);
    itemView.setOnClickListener(this);
    this.parent = parent;
    name = (TextView)itemView.findViewById(R.id.name);
  }

  public CharSequence getID(){
    return name.getText();
  }

  @Override
  public void onClick(View v) {
    final RecyclerViewOnClickAdapter.OnItemClickListener listener = parent.getOnItemClickListener();
    if(listener != null){
      listener.onItemClick(this, getPosition(), v);
    }
  }
}
