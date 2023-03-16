package tw.cgu.b1021136.changeofcolor;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    TextView txvR,txvG,txvB;
    EditText rn,gn,bn;
    View bg;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txvR =(TextView) findViewById(R.id.txvR);
        txvG =(TextView) findViewById(R.id.txvG);
        txvB =(TextView) findViewById(R.id.txvB);
        rn=(EditText) findViewById(R.id.rn);
        gn=(EditText) findViewById(R.id.gn);
        bn=(EditText) findViewById(R.id.bn);
        bg=findViewById(R.id.bg);

    }




    public void chword(View v){
        int R = Integer.parseInt(rn.getText().toString());
        int G = Integer.parseInt(gn.getText().toString());
        int B = Integer.parseInt(bn.getText().toString());
        txvR.setTextColor(Color.rgb(R,G,B));
        txvG.setTextColor(Color.rgb(R,G,B));
        txvB.setTextColor(Color.rgb(R,G,B));


    }
    public void chbg(View v){
        int R = Integer.parseInt(rn.getText().toString());
        int G = Integer.parseInt(gn.getText().toString());
        int B = Integer.parseInt(bn.getText().toString());
        bg.setBackgroundColor(Color.rgb(R,G,B));
    }
    public void chrd(View v){
        int R = Integer.parseInt(rn.getText().toString());
        int G = Integer.parseInt(gn.getText().toString());
        int B = Integer.parseInt(bn.getText().toString());
        Random x =new Random();
        int red =x.nextInt(256);
        txvR.setText("紅:"+red);
        txvR.setTextColor(Color.rgb(red,0,0));

        int green =x.nextInt(256);
        txvG.setText("綠:"+green);
        txvG.setTextColor(Color.rgb(0,green,0));

        int blue =x.nextInt(256);
        txvB.setText("藍:"+blue);
        txvB.setTextColor(Color.rgb(0,0,blue));
        bg.setBackgroundColor(Color.rgb(red,green,blue));

    }
}