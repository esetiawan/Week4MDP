package id.ac.week4mdp;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContract;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    EditText txtInput;
    TextView tvNama;
    ActivityResultLauncher<Intent> myActivityResultLauncher;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtInput = findViewById(R.id.editTextTextEmailAddress);
        tvNama = findViewById(R.id.tvNama);
        myActivityResultLauncher = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                new ActivityResultCallback<ActivityResult>() {
                    @Override
                    public void onActivityResult(ActivityResult result) {
                        Intent data = result.getData();
                        tvNama.setText(data.getStringExtra("nama"));
                    }
                }
        );
    }
    public void btnClick(View v)
    {
        if (v.getId()==R.id.btnGo) {
            Intent i = new Intent(this, MainActivity2.class);
            i.putExtra("email", txtInput.getText().toString()); //kirim Data

            Date dNow = Calendar.getInstance().getTime();
            SimpleDateFormat df = new SimpleDateFormat("dd-MMM-yyyy",
                    Locale.getDefault());
            i.putExtra("inputDate", df.format(dNow)); //kirim Data

            startActivity(i); //seperti showDialog
        }
        else if (v.getId()==R.id.btnGoPOJO) {
            Date dNow = Calendar.getInstance().getTime();
            SimpleDateFormat df = new SimpleDateFormat("dd-MMM-yyyy",
                    Locale.getDefault());
            DataUser du = new DataUser(txtInput.getText().toString(),df.format(dNow));

            Intent i = new Intent(this, MainActivity3.class);
            i.putExtra(MainActivity3.EXTRA_OBJ,du);
            startActivity(i);
        }
        else if (v.getId()==R.id.btnSendEmail) {
            //implicit intent
            Intent i = new Intent(Intent.ACTION_SENDTO);
            i.setData(Uri.parse("mailto:"+txtInput.getText().toString()));
            i.putExtra(Intent.EXTRA_EMAIL,txtInput.getText().toString());
            i.putExtra(Intent.EXTRA_SUBJECT,"Hello World");
            startActivity(i);
        }
        else if (v.getId()==R.id.btnActivityResult) {
            //startActivityForResult
            Intent i = new Intent(this,MainActivity4.class);
            myActivityResultLauncher.launch(i);
        }
    }
}