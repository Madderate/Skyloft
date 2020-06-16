package com.madderate.skyloft.Views;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.Toolbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.madderate.skyloft.Dialog.MsgDialog;
import com.madderate.skyloft.R;
import com.madderate.skyloft.Adapter.ListAdapter;
import com.madderate.skyloft.Utils.StatusBarUtils;

import java.util.ArrayList;
import java.util.List;

public class MusicSheetActivity extends AppCompatActivity {
    String TAG = "歌单";
    private Toolbar mToolbar;
    private ImageView mHeaderBg;
    private RecyclerView mRecyclerView;
    private ListAdapter mListAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.music_sheet);
        initView();

    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            Toast.makeText(MusicSheetActivity.this, "返回", Toast.LENGTH_SHORT).show();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.toolbar_right_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    private Toolbar.OnMenuItemClickListener onMenuItemClick = new Toolbar.OnMenuItemClickListener() {
        @Override
        public boolean onMenuItemClick(MenuItem item) {
            switch (item.getItemId()){
                case R.id.Function:
                    Toast.makeText(MusicSheetActivity.this, "更多功能", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.quick:
                    Toast.makeText(MusicSheetActivity.this, "查询", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.message:
                    View view = getLayoutInflater().inflate(R.layout.sheet_msg, null);
                    MsgDialog mMyDialog = new MsgDialog(MusicSheetActivity.this, 0, 0, view, R.style.DialogTheme);
                    mMyDialog.setCancelable(true);
                    mMyDialog.show();
                    break;
                case R.id.share:
                    break;
                case R.id.add:
                    break;
            }
            return true;
        }
    };



    private void initView(){
        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        mToolbar.setBackgroundColor(0xFF3C3C3C);
        mToolbar.inflateMenu(R.menu.toolbar_right_menu);
        mToolbar.setTitleTextColor(Color.WHITE);
        mToolbar.setTitle(R.string.sheet_name);
        mHeaderBg = (ImageView) findViewById(R.id.header_image);

        //激活toolbar的home键
        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);

        mToolbar.setOverflowIcon(ContextCompat.getDrawable(this,R.mipmap.more_function));
        mToolbar.setOnMenuItemClickListener(onMenuItemClick);

        mRecyclerView = (RecyclerView) findViewById(R.id.recycler_view);

        mListAdapter = new ListAdapter();
        mListAdapter.setData(getData());
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mRecyclerView.setLayoutManager(layoutManager);
        mRecyclerView.setAdapter(mListAdapter);

        // toolbar 的高
        int toolbarHeight = mToolbar.getLayoutParams().height;
        Log.i(TAG,"toolbar height:"+toolbarHeight);
        final int headerBgHeight = toolbarHeight + getStatusBarHeight(this);
        Log.i(TAG,"headerBgHeight:"+headerBgHeight);
        ViewGroup.LayoutParams params =  mHeaderBg.getLayoutParams();
        params.width = ViewGroup.LayoutParams.MATCH_PARENT;
        params.height = headerBgHeight;

        mHeaderBg.setImageAlpha(0);

        StatusBarUtils.setTranslucentImageHeader(this,0,mToolbar);

        mRecyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
            }

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                View headerView = null;

                LinearLayoutManager manager = (LinearLayoutManager) recyclerView.getLayoutManager();
                int firstVisibleItem = manager.findFirstVisibleItemPosition();
                if(firstVisibleItem == 0){
                    headerView = recyclerView.getChildAt(firstVisibleItem);
                }
                float alpha = 0;
                if(headerView == null){
                    alpha = 1;// 如果headerView 为null ,说明已经到达header滑动的最大高度了
                }else{
                    alpha = Math.abs(headerView.getTop()) * 1.0f / headerView.getHeight();
                    Log.i(TAG,"alpha:"+alpha + "top :"+headerView.getTop() + " height: "+headerView.getHeight());
                }

                Drawable drawable = mHeaderBg.getDrawable();
                if(drawable!=null){
                    drawable.mutate().setAlpha((int) (alpha * 255));
                    mHeaderBg.setImageDrawable(drawable);
                }
            }
        });

        //mToolbar.setOnMenuItemClickListener();
    }

    public List<String> getData(){
        List<String> list = new ArrayList<>();
        for(int i=0;i<100;i++){
            list.add("item :"+i);
        }
        return list;
    }

    private static int getStatusBarHeight(Context context) {
        // 获得状态栏高度
        int resourceId = context.getResources().getIdentifier("status_bar_height", "dimen", "android");
        return context.getResources().getDimensionPixelSize(resourceId);
    }
}
