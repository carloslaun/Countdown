package com.example.countdown;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    TextView crono;
    int tiempo = 10;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        new Cronometro().execute();
    }

    private void init(){
        crono = findViewById(R.id.tx_cronometro);
    }

    class Cronometro extends AsyncTask<Void,Integer,Void> {


        @Override
        protected Void doInBackground(Void... voids) {
            try{
                while(tiempo>=0){
                    publishProgress(tiempo);
                    Thread.sleep(1000);
                    tiempo --;
                }

            }catch(Exception ex){

            }
            return null;
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);
            crono.setText(String.valueOf(values[0].intValue()));
        }

        @Override
        protected void onPostExecute(Void Avoid) {
            super.onPostExecute(Avoid);
            Toast.makeText(getApplicationContext(),"Time Over", Toast.LENGTH_LONG).show();
        }
    }
}