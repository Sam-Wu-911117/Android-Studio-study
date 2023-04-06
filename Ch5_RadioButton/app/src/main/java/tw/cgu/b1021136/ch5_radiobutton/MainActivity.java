package tw.cgu.b1021136.ch5_radiobutton;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void show(View v){
        TextView txv=(TextView) findViewById(R.id.txv);
        RadioGroup ticketType=(RadioGroup) findViewById(R.id.ticketType);

        switch (ticketType.getCheckedRadioButtonId()){
            case R.id.adult:
                txv.setText("買全票");
                break;
            case R.id.child:
                txv.setText("買半票");
                break;
            case R.id.senior:
                txv.setText("買敬老票");
                break;
        }
    }
}