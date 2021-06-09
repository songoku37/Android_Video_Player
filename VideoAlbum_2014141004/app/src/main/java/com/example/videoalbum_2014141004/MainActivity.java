package com.example.videoalbum_2014141004;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle(R.string.main_title); // string.xml에 해당하는 부분은 다 해쉬코드처럼 암호화 된 값임 그래서 int형
    }

    public void onViedoItemClicked(View view){
        int id = view.getId();
        LinearLayout list_item = (LinearLayout)findViewById(id);
        String selected_tag = (String)list_item.getTag();

        Intent second_screen_change = new Intent(this,autumn_player.class);

        second_screen_change.putExtra("s_tag",selected_tag);

        startActivity(second_screen_change);
    }
}