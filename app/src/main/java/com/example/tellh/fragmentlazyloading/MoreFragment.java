package com.example.tellh.fragmentlazyloading;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MoreFragment extends LazyFragment {
    private TextView tvLoading;
    private ImageView ivContent;
    private int tabIndex;
    public static final String INTENT_INT_INDEX="index";

    public static MoreFragment newInstance(int tabIndex) {

        Bundle args = new Bundle();
        args.putInt(INTENT_INT_INDEX, tabIndex);
        MoreFragment fragment = new MoreFragment();
        fragment.setArguments(args);
        return fragment;
    }
    @Override
    protected void onCreateViewLazy(Bundle savedInstanceState) {
        super.onCreateViewLazy(savedInstanceState);
        setContentView(R.layout.fragment_tabmain_item);
		tabIndex = getArguments().getInt(INTENT_INT_INDEX);
        ivContent = (ImageView) findViewById(R.id.iv_content);
        tvLoading = (TextView) findViewById(R.id.tv_loading);
        getData();
    }

    private void getData() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                //异步处理加载数据
                //...
                //完成后，通知主线程更新UI
                handler.sendEmptyMessageDelayed(1, 2000);
            }
        }).start();
    }

    @Override
    public void onDestroyViewLazy() {
        super.onDestroyViewLazy();
        handler.removeMessages(1);
    }

    private Handler handler = new Handler() {
        public void handleMessage(android.os.Message msg) {
            tvLoading.setVisibility(View.GONE);
            int id=0;
            switch (tabIndex){
                case 1:
                    id=R.drawable.a;
                    break;
                case 2:
                    id=R.drawable.b;
                    break;
                case 3:
                    id=R.drawable.c;
                    break;
                case 4:
                    id=R.drawable.d;
                    break;
            }
            ivContent.setImageResource(id);
            ivContent.setVisibility(View.VISIBLE);
        }
    };
}