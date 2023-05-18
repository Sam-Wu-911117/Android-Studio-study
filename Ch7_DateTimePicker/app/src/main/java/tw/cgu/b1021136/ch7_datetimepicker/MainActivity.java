package tw.cgu.b1021136.ch7_datetimepicker;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity implements View.OnClickListener,
        DatePickerDialog.OnDateSetListener, TimePickerDialog.OnTimeSetListener {

    Calendar c=Calendar.getInstance();
    TextView txDate,txTime;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txDate=(TextView) findViewById(R.id.txv1);
        txTime=(TextView) findViewById(R.id.txv2);
        txDate.setOnClickListener(this);
        txTime.setOnClickListener(this);
    }

    @Override
    public void onDateSet(DatePicker datePicker, int y, int m, int d) {
        txDate.setText("您設定的日期為\n"+y+"年"+(m+1)+"月"+d+"日");
        txDate.setTextColor(Color.BLUE);
    }

    @Override
    public void onTimeSet(TimePicker timePicker, int h, int m) {

        txTime.setText("您設定的時間為\n"+h+"點"+m+"分");
        txTime.setTextColor(Color.BLUE);
    }

    @Override

    public void onClick(View v) {
        if(v==txDate){
            new DatePickerDialog(this,this,c.get(Calendar.YEAR),
                    c.get(Calendar.MONTH),c.get(Calendar.DAY_OF_MONTH)).show();
        }
        else if(v==txTime){
            new TimePickerDialog(this,this,c.get(Calendar.HOUR_OF_DAY),
                    c.get(Calendar.MINUTE),true).show();
        }

    }

}