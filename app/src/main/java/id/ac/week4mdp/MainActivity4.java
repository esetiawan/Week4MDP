package id.ac.week4mdp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity4 extends AppCompatActivity {
    EditText txtNama;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
        txtNama = findViewById(R.id.txtNama);
    }
    public void btnSubmitClick(View v)
    {
        Intent returnIntent = new Intent();
        returnIntent.putExtra("nama", txtNama.getText().toString());
        setResult(Activity.RESULT_OK,returnIntent);
        finish();
    }
}