package com.example.administrator.sunqueyu20170410;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.administrator.sunqueyu20170410.view.ProgressView;

/**
 * 类的用途：主显示界面
 * Created by ${孙鹊禹}
 * on 2017/4/10 9:05
 */
public class MainActivity extends AppCompatActivity {
    int progress = 0;
    private ProgressView progressView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        Button button = (Button) findViewById(R.id.bu_download);
        progressView = (ProgressView) findViewById(R.id.progress);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 1000公里
                progressView.setMax(100);
                progress=0;
                new Thread() {
                    public void run() {
                        while (true) {
                            progress = progress + 1;
                            String text = progress + "%";
                            progressView.setProgressAndText(progress, text);
                            try {
                                sleep(30);
                            } catch (InterruptedException e) {
                                // TODO Auto-generated catch block
                                e.printStackTrace();
                            }
                            if (progress == 78) {
                                break;
                            }
                        }
                    }
                }.start();
            }
        });
    }
}
