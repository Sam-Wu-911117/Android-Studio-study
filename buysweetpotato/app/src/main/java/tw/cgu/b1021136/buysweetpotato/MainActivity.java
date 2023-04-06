package tw.cgu.b1021136.buysweetpotato;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements RadioGroup.OnCheckedChangeListener, TextWatcher {
    RadioGroup unit1,unit2;
    EditText price,weight;
    TextView txv3,txv4,txv6,txv7,txv8;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        unit1=(RadioGroup) findViewById(R.id.unit1);
        unit1.setOnCheckedChangeListener(this);

        unit2=(RadioGroup) findViewById(R.id.unit2);
        unit2.setOnCheckedChangeListener(this);

        price=(EditText) findViewById(R.id.price);
        price.addTextChangedListener(this);
        weight=(EditText) findViewById(R.id.weight);
        weight.addTextChangedListener(this);

        txv3=(TextView) findViewById(R.id.txv3);
        txv4=(TextView) findViewById(R.id.txv4);
        txv6=(TextView) findViewById(R.id.txv6);
        txv7=(TextView) findViewById(R.id.txv7);
        txv8=(TextView) findViewById(R.id.txv8);
    }

    public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

    public void onTextChanged(CharSequence s, int start, int before, int count) {}

    @Override
    public void afterTextChanged(Editable s) {
        calc();
    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        calc();
    }
    protected void calc(){
        double p,c1,k1;
        String str1=price.getText().toString();
        try{
            p=Double.parseDouble(str1);
        }catch(Exception e){
            p=0;
        }
        double w,c2,k2;
        String str2=weight.getText().toString();
        try{
            w=Double.parseDouble(str2);
        }catch (Exception e){
            w=0;
        }
        if(unit1.getCheckedRadioButtonId()==R.id.catty1){
            c1=p;
            k1=c1*5/3;
        }else{
            k1=p;
            c1=k1*3/5;
        }
        txv3.setText("每斤價錢: "+String.format("%.1f",c1));
        txv4.setText("每公斤價錢: "+String.format("%.1f",k1));
        if(unit2.getCheckedRadioButtonId()==R.id.catty2){
            c2=w;
            k2=c2*3/5;
        }else{
            k2=w;
            c2=k2*5/3;
        }
        txv6.setText(String.format("%.1f",c2)+"斤");
        txv7.setText(String.format("%.1f",k2)+"公斤");
        double pay=k1*k2;
        txv8.setText("總共"+String.format("%.1f",pay)+"元");
    }
}
