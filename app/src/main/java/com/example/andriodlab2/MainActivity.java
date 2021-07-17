package com.example.andriodlab2;

import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Locale;


public class MainActivity extends AppCompatActivity {

    EditText Text;
    Button btnText;
    TextView answer;
    TextToSpeech textToSpeech;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Text = findViewById(R.id.text);
        btnText = findViewById(R.id.button);
        answer = findViewById(R.id.answer);

        textToSpeech = new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int i) {

                if(i!=TextToSpeech.ERROR){

                    textToSpeech.setLanguage(Locale.GERMANY);
                  }
            }
        });

        btnText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),"Speaking in German!",Toast.LENGTH_SHORT).show();

                textToSpeech.speak(Text.getText().toString(),TextToSpeech.QUEUE_FLUSH,null);
                answer.setText("Your Input : \n\n"+Text.getText());
            }
        });

    }
}