package tw.cgu.b1021136.ch6_arrayadapter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    Spinner drink,temp;
    TextView txv;
    String[] tempset1={"宜蘭","基隆","台北","桃園","新竹","苗栗"};
    String[] tempset2={"台中","彰化","南投"};
    String[] tempset3={"高雄","雲林","嘉義","台南","屏東"};
    String[] tempset4={"花蓮","台東"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txv=(TextView) findViewById(R.id.order);
        temp =(Spinner) findViewById(R.id.temp);
        drink=(Spinner) findViewById(R.id.drink);

        drink.setOnItemSelectedListener(this);
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
        String[] tempSet={};
        if (position==0){
            tempSet=tempset1;
        }
        else if (position==1){
            tempSet=tempset2;
        }
        else if (position==2) {
            tempSet=tempset3;
        }
        else if (position==3) {
            tempSet=tempset4;
        }
        ArrayAdapter<String> tempAd=new ArrayAdapter<>(this, android.R.layout.simple_spinner_item,tempSet);
        tempAd.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        temp.setAdapter(tempAd);
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
    public void showOrder(View v){
        String msg ="您住在"+drink.getSelectedItem()+"的"+temp.getSelectedItem();
        txv.setText(msg);
    }
}