package id.ac.week4mdp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class MainActivity3 extends AppCompatActivity {
    public static final String EXTRA_OBJ="obj";
    TextView tv2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        tv2 = findViewById(R.id.textView2);

        DataUser du = getIntent().getParcelableExtra(EXTRA_OBJ);
        tv2.setText("Email:"+du.getEmail()+",Date:"+du.getDate());
    }
}