package com.example.pract2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private String TAG = "Жизненный цикл";
    private TextView mInfoTextView;
    static final String SOCCER_SCORE = "soccer_score";
    public static int mCurrentScore=0;
    TextView ScoreText;
    @Override
    public void onSaveInstanceState(Bundle savedInstanceState){
        savedInstanceState.putInt(SOCCER_SCORE,mCurrentScore);
        super.onSaveInstanceState(savedInstanceState);
    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(savedInstanceState!=null){
            mCurrentScore=savedInstanceState.getInt(SOCCER_SCORE);
        } else{
            setContentView(R.layout.activity_main);
            mInfoTextView = (TextView) findViewById(R.id.textViewInfo);
            Toast.makeText(this, "", Toast.LENGTH_SHORT).show();
            Log.i(TAG, "onCreate()");
        }

    }
    @Override
    protected void onStart() {
        super.onStart();

        Toast.makeText(getApplicationContext(), "onStart()", Toast.LENGTH_SHORT).show();
        Log.i(TAG, "onStart()");
    }
    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        mCurrentScore=savedInstanceState.getInt(SOCCER_SCORE);
        ScoreText = findViewById(R.id.ScoreTextView);
        ScoreText.setText(String.valueOf(mCurrentScore));
    }
    @Override
    protected void onRestart() {
        super.onRestart();

        Toast.makeText(getApplicationContext(), "onRestart()", Toast.LENGTH_SHORT).show();
        Log.i(TAG, "onRestart()");
    }

    @Override
    protected void onResume() {
        super.onResume();

        Toast.makeText(getApplicationContext(), "onResume()", Toast.LENGTH_SHORT).show();
        Log.i(TAG, "onResume()");
    }

    @Override
    protected void onPause() {
        super.onPause();

        Toast.makeText(getApplicationContext(), "onPause()", Toast.LENGTH_SHORT).show();
        Log.i(TAG, "onPause()");
    }

    @Override
    protected void onStop() {
        super.onStop();

        Toast.makeText(getApplicationContext(), "onStop()", Toast.LENGTH_SHORT).show();
        Log.i(TAG, "onStop()");
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();

        Toast.makeText(getApplicationContext(), "onDestroy()", Toast.LENGTH_SHORT).show();
        Log.i(TAG, "onDestroy()");
    }

    public void onClick(View v) {
        ScoreText = findViewById(R.id.ScoreTextView);
        switch (v.getId()) {
            case R.id.buttonTouchMe:
                mInfoTextView.setText("Приложение уже было запущено!");
                break;
            case R.id.buttonExit:
                finish();
                break;
            case R.id.PlusScore:
                mCurrentScore+=1;
                ScoreText.setText(String.valueOf(mCurrentScore));
                break;
            case R.id.MinusScore:
                mCurrentScore--;
                ScoreText.setText(String.valueOf(mCurrentScore));
                break;
            default:
                break;
        }
    }
}