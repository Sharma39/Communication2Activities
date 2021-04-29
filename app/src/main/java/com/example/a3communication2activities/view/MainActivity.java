package com.example.a3communication2activities.view;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.a3communication2activities.R;
import com.example.a3communication2activities.model.CustomMessage;
import com.google.android.material.snackbar.Snackbar;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static com.example.a3communication2activities.util.Logger.logDebug;
import static com.example.a3communication2activities.view.MyActivity.READ_KEY;

public class MainActivity extends AppCompatActivity {

    public static final String TAG = "TAG_X";

//    @BindView(R.id.clickme)
//    TextView myclick;

    @BindView(R.id.reply_editor)
    EditText replyEdit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

//        replyEdit.setText("Reply not Recieved");

        logDebug("onCrate: ");
    }

    public static final int  REQUEST_CODE = 777;
    @OnClick(R.id.clickme)
    public void onClick(View view){

        String timestamp = new SimpleDateFormat("HH:mm", Locale.US).format(new Date());

        String  reply_text = replyEdit.getText().toString().trim();

        CustomMessage cMessage = new CustomMessage(timestamp, reply_text+";");

            //Explicit Intent
            Intent intent = new Intent(this, MyActivity.class);

            intent.putExtra(READ_KEY, cMessage);
            startActivityForResult(intent, REQUEST_CODE);

            Toast.makeText(this, "Message Sent", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(REQUEST_CODE == requestCode){
            String message = data.getStringExtra(READ_KEY);
            replyEdit.setText(message);
            Snackbar.make(findViewById(R.id.main_view), message, Snackbar.LENGTH_LONG).show();
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        logDebug("onStart: ");
    }

    @Override
    protected void onResume() {
        super.onResume();
        logDebug("onResume: ");
    }


    @Override
    protected void onPause() {
        super.onPause();
        logDebug("onPause: ");
    }

    @Override
    protected void onStop() {
        super.onStop();
        logDebug("onStop: ");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        logDebug("onRestart: ");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        logDebug("onDestroy: ");
    }
}