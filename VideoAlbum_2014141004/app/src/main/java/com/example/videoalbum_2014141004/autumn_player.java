package com.example.videoalbum_2014141004;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.VideoView;

import org.w3c.dom.Text;

public class autumn_player extends AppCompatActivity {

    TextView title_txt;
    VideoView video;
    TextView detail_txt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_autumn_player);

        setTitle(R.string.second_title);

        Intent receive_intent = getIntent();
        String tag =    receive_intent.getStringExtra("s_tag"); // 1 , 2 , 3 문자열


        title_txt = (TextView)findViewById(R.id.titleTxt);
        video = (VideoView)findViewById(R.id.videoView);
        detail_txt = (TextView)findViewById(R.id.detailTxt);

        Resources res = getResources();
        int title_id = res.getIdentifier("title" + tag , "string",getPackageName());
//        String title = res.getString(title_id);
//        title_txt.setText(title);
        Log.e("title_id" ,"title_id" + title_id);
        title_txt.setText(res.getString(title_id));

        int video_id = res.getIdentifier("video" + tag , "string",getPackageName());
        String vedio_file_name = res.getString(video_id);

        int id = res.getIdentifier(vedio_file_name,"raw",getPackageName());

        Uri uri = Uri.parse("android.resource://" + getPackageName() +"/" + id); // 비디오 경로 설정
        video.setVideoURI(uri);
        video.start();

        MediaController cont = new MediaController(this);
        video.setMediaController(cont);
        // 비디오 기본 설정들을 사용할 수 있게 설정


        int detail_id = res.getIdentifier("detail" + tag , "string",getPackageName());
        detail_txt.setText(res.getString(detail_id));


    }

    public void onViedoStart(View view){
        video.start();
    }


    public void onViedoPause(View view){
        video.pause();
    }


    public void onViedoStop(View view){
        // video.stopPlayback(); // 완전 멈춤 다시 시작 안 됨
        video.seekTo(0); // 0초로 이동
        video.pause(); // 멈추기
    }
}
