package android.ritual.recyclerviewonclick;

import android.os.Bundle;
import android.ritual.recyclerviewonclick.adapter.RecyclerViewOnClickAdapter;
import android.ritual.recyclerviewonclick.viewholder.RecyclerViewOnClickViewHolder;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class RecyclerViewOnClickActivity extends AppCompatActivity implements RecyclerViewOnClickAdapter.OnItemClickListener{
    private RecyclerViewOnClickAdapter myRecyclerViewAdapter;
    private RecyclerView recyclerView;
    private List<String> listItem = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view_onclick);

        myRecyclerViewAdapter = new RecyclerViewOnClickAdapter(RecyclerViewOnClickActivity.this);
        myRecyclerViewAdapter.setOnItemClickListener(this);
        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(RecyclerViewOnClickActivity.this, LinearLayoutManager.VERTICAL, false));
        recyclerView.setAdapter(myRecyclerViewAdapter);
        addItem();
    }

    public void addItem(){
        for (int i = 0; i<20; i++){
            listItem.add("Item "+i);
        }
        myRecyclerViewAdapter.addItem(listItem);
    }

    @Override
    public void onItemClick(RecyclerViewOnClickViewHolder item, int position, View v) {
        Snackbar.make(v, "item "+position+" has been clicked", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show();
    }
}
