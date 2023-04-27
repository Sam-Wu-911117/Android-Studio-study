package tw.cgu.b1021136.ch6_1_spinner;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView txv;
    Spinner cinema,count;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txv=(TextView) findViewById(R.id.txv);
        cinema=(Spinner) findViewById(R.id.cinema);
        count=(Spinner) findViewById(R.id.count);
    }
    public void order(View v){
        String[] cinemas=getResources().getStringArray(R.array.cinemas);
        String[] counts=getResources().getStringArray(R.array.counts);
        int index=cinema.getSelectedItemPosition();
        int time =count.getSelectedItemPosition();
        txv.setText("訂"+cinemas[index]+counts[time]+"的票");
    }
}