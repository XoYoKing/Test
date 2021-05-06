package com.wt.anfs2;

import android.app.Activity;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

public class MainActivityTR extends Activity {

    private LinearLayout mContentLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mContentLayout = (LinearLayout)findViewById(R.id.layout_content);

        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) mContentLayout.getLayoutParams();

        //layoutParams.removeRule(RelativeLayout.ALIGN_PARENT_START);
        //layoutParams.removeRule(RelativeLayout.CENTER_IN_PARENT);
        //layoutParams.addRule(RelativeLayout.ALIGN_PARENT_END);
        layoutParams.addRule(RelativeLayout.ALIGN_PARENT_TOP);
        layoutParams.addRule(RelativeLayout.ALIGN_PARENT_RIGHT);
        //layoutParams.addRule(RelativeLayout.CENTER_IN_PARENT);
        mContentLayout.setLayoutParams(layoutParams);
    }
}
