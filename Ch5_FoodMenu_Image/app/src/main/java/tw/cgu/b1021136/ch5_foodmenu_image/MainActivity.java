package tw.cgu.b1021136.ch5_foodmenu_image;

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
        int[] chk_id={R.id.chk1,R.id.chk2,R.id.chk3,R.id.chk4};
        for(int id:chk_id){
            ((CheckBox) findViewById(id)).setOnCheckedChangeListener(this);
        }
    }

    int i=0;
    ArrayList<CompoundButton> selected=new ArrayList<>();
    String msg;
    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        int visible;
        if(isChecked){
            selected.add(buttonView);
            i++;
            visible= View.VISIBLE;
        }
        else {
            selected.remove(buttonView);
            i--;
            visible=View.GONE;
        }

        switch (buttonView.getId()){
            case R.id.chk1:
                findViewById(R.id.op1).setVisibility(visible);
                break;
            case R.id.chk2:
                findViewById(R.id.op2).setVisibility(visible);
                break;
            case R.id.chk3:
                findViewById(R.id.op3).setVisibility(visible);
                break;
            case R.id.chk4:
                findViewById(R.id.op4).setVisibility(visible);
                break;
        }

        msg="";
        if (i>0) msg= "你點的餐點如下:";
        else msg="請點餐";
        ((TextView) findViewById(R.id.showOrder)).setText(msg);
    }
    public void takeOrder(View v){
         msg="";

        for(CompoundButton chk:selected)
            msg+="\n"+chk.getText();

        if(msg.length()>0) msg="你點購的餐點是："+msg;
        else msg="請點餐";
        ((TextView) findViewById(R.id.showOrder)).setText(msg);
    }
}