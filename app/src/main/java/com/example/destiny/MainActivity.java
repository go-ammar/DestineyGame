package com.example.destiny;

import androidx.appcompat.app.AppCompatActivity;

import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.SoundPool;
import android.net.sip.SipSession;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    Button ans1;
    Button ans2;
    TextView story;
    int mIndex;
    int mStory;

    MediaPlayer mMediaPlayer;
    private SoundPool mSoundPool;
    private int mBgMusic;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if(mMediaPlayer==null){
            mMediaPlayer = MediaPlayer.create(this, R.raw.music);

        }
        mMediaPlayer.start();

        ans1 = findViewById(R.id.buttonTop);
        ans2 = findViewById(R.id.buttonBottom);
        story = findViewById(R.id.storyTextView);
        mIndex = 1;

        ans1.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if(mIndex==1||mIndex==2){
//Go to story 3
               mIndex = 3;
               story.setText(R.string.T3_Story);
               ans1.setText(R.string.T3_Ans1);
               ans2.setText(R.string.T3_Ans2);
            }else if (mIndex ==3){
//Go to end 6
                story.setText(R.string.T6_End);
                ans1.setVisibility(View.INVISIBLE);
                ans2.setVisibility(View.INVISIBLE);
            }



        }
     }
        );

        ans2.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if(mIndex == 1){
                mIndex =2;
                story.setText(R.string.T2_Story);
                ans1.setText(R.string.T2_Ans1);
                ans2.setText(R.string.T2_Ans2);

            }else if(mIndex == 2){
                story.setText(R.string.T4_End);
                ans1.setVisibility(View.INVISIBLE);
                ans2.setVisibility(View.INVISIBLE);
            }else if (mIndex ==3){
                story.setText(R.string.T5_End);
                ans1.setVisibility(View.INVISIBLE);
                ans2.setVisibility(View.INVISIBLE);
            }

        }
     }
        );

    }

    @Override
    protected void onPause() {
        super.onPause();
        mMediaPlayer.pause();
    }

}