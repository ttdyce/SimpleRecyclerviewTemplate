package com.github.ttdyce.simplerecyclerviewtemplate;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //init recycler view
        String[] arr = {"1", "1", "1"
                , "2", "2", "2"
                ,"3", "3", "3"};
        RecyclerView rvMain = findViewById(R.id.rvMain);
        mRecyclerviewAdapter adapter = new mRecyclerviewAdapter(arr);
        GridLayoutManager layoutManager = new GridLayoutManager(this, 3);

        rvMain.setAdapter(adapter);
        rvMain.setLayoutManager(layoutManager);

    }

    private class mViewHolder extends RecyclerView.ViewHolder {
        TextView tvTitle;

        public mViewHolder(@NonNull View itemView) {
            super(itemView);

            tvTitle = itemView.findViewById(R.id.tvItem);
        }
    }

    private class mRecyclerviewAdapter extends RecyclerView.Adapter<mViewHolder> {
        private String[] dataArr;

        public mRecyclerviewAdapter(String[] arr){
            dataArr = arr;
        }

        @NonNull
        @Override
        public mViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
            View v = LayoutInflater.from(viewGroup.getContext())
                    .inflate(R.layout.list_item, viewGroup, false);
            return new mViewHolder(v);
        }

        @Override
        public void onBindViewHolder(@NonNull mViewHolder viewHolder, int i) {
            viewHolder.tvTitle.setText(dataArr[i]);
        }

        @Override
        public int getItemCount() {
            return dataArr.length;
        }
    }


}
