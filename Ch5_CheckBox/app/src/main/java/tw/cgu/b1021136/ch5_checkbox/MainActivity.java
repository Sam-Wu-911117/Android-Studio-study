package tw.cgu.b1021136.ch5_checkbox;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements CompoundButton.OnCheckedChangeListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        int[] chk_id={R.id.chk1,R.id.chk2,R.id.chk3,R.id.chk4,R.id.chk5,R.id.chk6,R.id.chk7,R.id.chk8,R.id.small};

        for(int id:chk_id){
            CheckBox chk=(CheckBox) findViewById(id);
            chk.setOnCheckedChangeListener(this);
        }
    }

    ArrayList<CompoundButton> selected=new ArrayList<>();

    public void onCheckedChanged(CompoundButton buttonView,boolean isChecked){
        if(isChecked) selected.add(buttonView);
        else selected.remove(buttonView);

        if(buttonView.getId()==R.id.small){
            TextView txv=(TextView) findViewById(R.id.showOrder);
            if(isChecked) txv.setTextSize(15);
            else txv.setTextSize(30);
            return;
        }
    }

    public void takeOrder(View v){
        String msg="";

        for(CompoundButton chk:selected) msg+="\n"+chk.getText();

        if(msg.length()>0) msg="你點購的餐點是："+msg;
        else msg="請點餐";
        ((TextView) findViewById(R.id.showOrder)).setText(msg);
    }
}