package id.ac.week4mdp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {
    TextView txtInfo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        txtInfo = findViewById(R.id.textView);
        txtInfo.setText("email:"+getIntent().getStringExtra("email")+"\n"
            +"date:"+getIntent().getStringExtra("inputDate"));
    }
    public void btnCloseClick(View v)
    {
        finish();
    }
}