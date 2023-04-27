package tw.cgu.b1021136.ch6_1_sport_calc;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener, TextWatcher {
    Spinner volt;
    EditText current,timespan,spd;
    TextView total;
    double[] volts={110.220};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        current=(EditText) findViewById(R.id.current);
        timespan=(EditText) findViewById(R.id.timeSpan);
        spd=(EditText) findViewById(R.id.spd);
        total=(TextView) findViewById(R.id.total);
        volt=(Spinner) findViewById(R.id.volt);
        volt.setOnItemSelectedListener(this);
        current.addTextChangedListener(this);
        timespan.addTextChangedListener(this);
        spd.addTextChangedListener(this);
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        calc();
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }

    @Override
    public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

    }

    @Override
    public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

    }

    @Override
    public void afterTextChanged(Editable editable) {
        calc();
    }
    @SuppressLint("DefaultLocale")
    public void calc(){
        String A=current.getText().toString();
        String t=timespan.getText().toString();
        String m= spd.getText().toString();
        if(A.isEmpty()||A.equals(".")||t.isEmpty()||t.equals(".") ||
                m.isEmpty()||m.equals(".") ){
            total.setText("請輸入完整資訊");
            return;
        }
        int get=volt.getSelectedItemPosition();

        long sum=Math.round(volts[get]*Double.parseDouble(A)*Double.parseDouble(t)*Double.parseDouble(m)*30/1000);
        total.setText(String.format(" $ %d",sum));
    }
}