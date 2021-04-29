package com.example.a3communication2activities.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.a3communication2activities.R;
import com.example.a3communication2activities.model.CustomMessage;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static com.example.a3communication2activities.util.Logger.logDebug;
import static com.example.a3communication2activities.view.MainActivity.REQUEST_CODE;

public class MyActivity extends AppCompatActivity {

    @BindView(R.id.message_text)
    TextView msgRec;

    @BindView(R.id.message_edit)
    TextView msgsent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);
        ButterKnife.bind(this);

        CustomMessage message = (CustomMessage) getIntent().getSerializableExtra(READ_KEY);

        if(message != null)
        msgRec.setText(message.getMessage() + " " + message.getTimesent());

        logDebug("onCrate: ");
    }

    public static final String READ_KEY = "READ";

//    @OnClick(R.id.message_editor)  --> You can also use this instead of the button id below,
//    the only difference will be when finished writing in textEditor,
//    just press enter or press tick on mobile's keyboard.

    @OnClick(R.id.send_button)
    public void onClick(View view) {
        String message = msgsent.getText().toString();
        Intent intent = new Intent();
            intent.putExtra(READ_KEY, message);
            setResult(REQUEST_CODE, intent);
            finish();
        }
}