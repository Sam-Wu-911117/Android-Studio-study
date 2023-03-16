package tw.cgu.b1021136.ch3_constraintlayout;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.view.View;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    TextView txvR,txvG,txvB;
    View colorBlock;
    Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txvR =(TextView) findViewById(R.id.txvR);
        txvG =(TextView) findViewById(R.id.txvG);
        txvB =(TextView) findViewById(R.id.txvB);
        colorBlock =findViewById(R.id.colorblock);
        btn=(Button) findViewById(R.id.btn);

    }
    public void changeColor(View v){
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
        btn.setTextColor(Color.rgb(red,green,blue));
        colorBlock.setBackgroundColor(Color.rgb(red,green,blue));

    }
}