package com.victor.coordinatorlayoutdemo;

import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class CollapsingActivity extends AppCompatActivity {

    // 模仿RecyclerView的数据
    String[] mDatas = {"Each of us holds a unique place in the world. You are special,no matter what others say or what you may think. So forget about being replaced. You can’t be.",
            "How beautiful it was, falling so silently, all day long, all night long, on the mountains, on the meadows, on the roofs of the living, on the graves1) of the dead!",
            "All white save the river, that marked2) its course by a winding black line across the landscape3), and the leafless trees, that against the leaden4) sky now revealed more fully the wonderful beauty and intricacy5) of their branches!",
            "What silence, too, came with the snow, and what seclusion6)! Every sound was muffled7); every noise changed to something soft and musical.",
            "In the entire world there's nobody like me. Since the beginning of time, there has never been another person like me. Nobody has my smile. Nobody has my eyes, my nose, my hair, my hands, or my voice.",
            "If you give up when it's winter, you will miss the promise of your spring, the beauty of your summer, fulfillment of your fall. Don't let the pain of one season destroy the joy of all the rest.",
            "A burning desire is the starting point of all accomplishment. Just like a small fire cannot give much heat, a weak desire cannot produce great results.",
            "I have drunk the cup of life down to its very dregs7). They have only sipped the bubbles on top of it. I know things they will never know. I see things to which they are blind.",
            "It is only the women whose eyes have been washed clear with tears who get the broad vision that makes them little sisters to all the world."};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_collapsing);
        initToolBar();
        CollapsingToolbarLayout ctlLayout = (CollapsingToolbarLayout) findViewById(R.id.ctl_layout);
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.rv);
        ctlLayout.setTitle("Victor");
        ctlLayout.setExpandedTitleColor(Color.WHITE);
        ctlLayout.setCollapsedTitleTextColor(Color.YELLOW);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        recyclerView.setAdapter(new MyAdapter());
    }

    private void initToolBar() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolBar);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setHomeButtonEnabled(true);
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    class MyAdapter extends RecyclerView.Adapter<MyViewHolder> {

        @Override
        public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = View.inflate(getApplicationContext(), R.layout.list_item, null);
            MyViewHolder viewHolder = new MyViewHolder(view);
            return viewHolder;
        }

        @Override
        public void onBindViewHolder(MyViewHolder holder, int position) {
            holder.mTextView.setText(mDatas[position]);
        }

        @Override
        public int getItemCount() {
            return mDatas.length;
        }
    }

    class MyViewHolder extends RecyclerView.ViewHolder {

        public TextView mTextView;

        public MyViewHolder(View itemView) {
            super(itemView);
            mTextView = (TextView) itemView.findViewById(R.id.tv_item);
        }
    }
}
