package jp.techacademy.kota.hisamatsu.aisatsuapp;

import android.app.TimePickerDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.TimePicker;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    TextView mTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button1 = (Button) findViewById(R.id.button1);
        button1.setOnClickListener(this);

        mTextView = (TextView) findViewById(R.id.textView1);
    }

    @Override
    public void onClick(View v) {
        showTimePickerDialog();
    }

    private void showTimePickerDialog() {
        TimePickerDialog timePickerDialog = new TimePickerDialog(this,
                new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                        setGreeting(hourOfDay);
                    }
                },
                0,
                0,
                true);
        timePickerDialog.show();
    }

    private void setGreeting(int hourOfDay) {
        if (hourOfDay >= 2 && hourOfDay <= 9) {
            mTextView.setText("おはよう");
        } else if (hourOfDay >= 10 && hourOfDay <= 17) {
            mTextView.setText("こんにちは");
        } else {
            mTextView.setText("こんばんは");
        }
    }
}
