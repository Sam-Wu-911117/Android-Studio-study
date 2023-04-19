package tw.cgu.b1021136.mid_109;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener,
        RadioGroup.OnCheckedChangeListener, CompoundButton.OnCheckedChangeListener, View.OnLongClickListener {
    TextView txvS, txvNT, txvC, txvM;
    View InL1;
    Button btnO, btnM;

    int sum =0;
    int price[] = {150,230,510,620};
    int priceT[] ={0,0,0,0};

    int [] chk_id = {R.id.chk1,R.id.chk2,R.id.chk3,R.id.chk4};

    RadioGroup currency;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txvS = (TextView) findViewById(R.id.txvS);
        txvNT = (TextView) findViewById(R.id.txvNT);
        txvM = (TextView) findViewById(R.id.txvM);
        txvC = (TextView) findViewById(R.id.txvC);

        btnO = (Button) findViewById(R.id.btnO);
        btnM = (Button) findViewById(R.id.btnM);
        InL1 = (View)findViewById(R.id.lnL1);
        currency = (RadioGroup) findViewById(R.id.currency);
        //(B)
        currency.setOnCheckedChangeListener(this);
        btnO.setOnClickListener(this);
        btnO.setOnLongClickListener(this);
        btnM.setOnClickListener(this);
        btnM.setOnLongClickListener(this);
        for(int id: chk_id){
            CheckBox chk = (CheckBox)findViewById(id);
            chk.setOnCheckedChangeListener(this);
        }

    }
    String msg;
    int money;
    @Override
    public void onClick(View view){
        msg = "";
        for(int p: priceT){
            sum+=p;
        }
        for(CompoundButton chk: selected)
            msg += "\n" + chk.getText();
        if(view.getId()==R.id.btnO){
            if(msg.length()>0) {
                txvS.setText("您購買了:" + msg);
                txvNT.setText("總金額: " + sum + "元");
            }
            else{
                txvS.setText("購物車是空的!");
                txvNT.setText("總金額: 0");
                txvM.setText("");
            }
        }
        if(view.getId()==R.id.btnM){
            btnO.setText("訂購");
            btnM.setText("長按關閉購物車");
            InL1.setBackgroundColor(Color.rgb(255,255,255));
            txvNT.setText("總金額: 0");
            txvM.setText("0");
            sum = 0;
        }
        money = sum;
        txvC.setText("付款金額 NTD:");
        txvM.setText(String.valueOf(money));
        sum = 0;
    }
    public boolean onLongClick(View v){
        if(v.getId()==R.id.btnO){
            msg = "";
            txvS.setText("購物車是空的!");
        }
        if(v.getId()==R.id.btnM){
            InL1.setBackgroundColor(Color.rgb(0,0,0));
            btnO.setText("請開啟購物車");
            btnM.setText("開啟購物車");
            txvNT.setText("總金額: 0");
            txvM.setText("0");
            txvS.setText("");
        }
        sum = 0;
        return true;
    }
    ArrayList<CompoundButton>selected = new ArrayList<>();
    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        int i = buttonView.getId();
        if (isChecked) {
            switch (i) {
                case R.id.chk1:
                    priceT[0] = price[0];
                    break;
                case R.id.chk2:
                    priceT[1] = price[1];
                    break;
                case R.id.chk3:
                    priceT[2] = price[2];
                    break;
                case R.id.chk4:
                    priceT[3] = price[3];
                    break;
            }
            selected.add(buttonView);
        }
        else{
            switch (i) {
                case R.id.chk1:
                    priceT[0] = 0;
                    break;
                case R.id.chk2:
                    priceT[1] = 0;
                    break;
                case R.id.chk3:
                    priceT[2] = 0;
                    break;
                case R.id.chk4:
                    priceT[3] = 0;
                    break;
            }
            selected.remove(buttonView);
        }
    }
    @Override
    public void onCheckedChanged(RadioGroup radioGroup, int i) {
        calc();
    }
    protected void calc(){
        double Krw,Usd;
        if(currency.getCheckedRadioButtonId()==R.id.rUsd){
            Usd = money*0.033;
            txvC.setText("付款金額 USD:");
            txvM.setText(String.valueOf(Usd));
        }
        if(currency.getCheckedRadioButtonId()==R.id.rKrw){
            Krw = money*43.19;
            txvC.setText("付款金額 KRW:");
            txvM.setText(String.valueOf(Krw));
        }
        if(currency.getCheckedRadioButtonId()==R.id.rNtd){
            txvC.setText("付款金額 NTD:");
            txvM.setText(String.valueOf(money));
        }
    }

}
