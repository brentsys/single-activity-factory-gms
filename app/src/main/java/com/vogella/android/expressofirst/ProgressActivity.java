package com.vogella.android.expressofirst;

import android.support.v7.app.AppCompatActivity;
import android.widget.ProgressBar;

public abstract class ProgressActivity extends AppCompatActivity {

    private ProgressBar mPBar;

    public void setProgressBar(ProgressBar pBar){
        mPBar = pBar;
    }

    public ProgressBar getProgressBar(){
        return mPBar;
    }
}
