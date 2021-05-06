package com.wt.anfs2;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

//am start -a android.intent.action.VIEW -d  http://www.google.cn/
//am start com.wt.anfs/.MainActivity
//am start com.wt.anfs/.MainActivityTL
//am start com.wt.anfs/.MainActivityTR
//am start com.wt.anfs/.MainActivityBL
//am start com.wt.anfs/.MainActivityBR
//input keyevent 4

public class MainActivity extends Activity {

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
//        layoutParams.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM);
//        layoutParams.addRule(RelativeLayout.ALIGN_PARENT_RIGHT);
//        layoutParams.addRule(RelativeLayout.CENTER_IN_PARENT);
        layoutParams.addRule(RelativeLayout.CENTER_VERTICAL);
        layoutParams.addRule(RelativeLayout.ALIGN_PARENT_RIGHT);
        mContentLayout.setLayoutParams(layoutParams);
    }
}
