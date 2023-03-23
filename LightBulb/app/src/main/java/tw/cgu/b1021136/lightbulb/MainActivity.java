package tw.cgu.b1021136.lightbulb;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity implements View.OnClickListener,View.OnLongClickListener {
    TextView txvo,txvc,txvcolor;
    Button btno,btnc;
    View back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txvo=(TextView) findViewById(R.id.txvo);
        txvc =(TextView) findViewById(R.id.txvc);
        txvcolor=(TextView) findViewById(R.id.txvcolor);
        btno=(Button) findViewById(R.id.btno);
        btnc=(Button) findViewById(R.id.btnc);
        back=(View) findViewById(R.id.back);
        btno.setOnClickListener(this);
        btno.setOnLongClickListener(this);
        btnc.setOnClickListener(this);
        btnc.setOnLongClickListener(this);

    }

    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.btno){
            txvo.setTextColor(Color.BLACK);
            txvc.setTextColor(Color.WHITE);
            txvcolor.setTextColor(Color.WHITE);
            btnc.setText("關燈");
            btno.setText(" ");
            back.setBackgroundColor(Color.WHITE);

        }
        if(v.getId()==R.id.btnc){
            txvo.setTextColor(Color.BLACK);
            txvc.setTextColor(Color.WHITE);
            txvcolor.setTextColor(Color.BLACK);
            btnc.setText(" ");
            btno.setText("開燈");
            back.setBackgroundColor(Color.BLACK);
        }
    }

    @Override
    public boolean onLongClick(View v) {
        if(v.getId()==R.id.btno){
            Random w= new Random();

            int red= w.nextInt(256);
            int green =w.nextInt(256);
            int blue =w.nextInt(256);

            int R= 256-red;
            int G =256-green;
            int B =256-blue;
            txvo.setTextColor(Color.rgb(R,G,B));
            txvc.setTextColor(Color.rgb(R,G,B));
            txvcolor.setTextColor(Color.rgb(red,green,blue));
            btno.setText("開燈");
            btnc.setText(" ");
            txvcolor.setText("隨機彩色");
            back.setBackgroundColor(Color.rgb(R,G,B));
        }
        if(v.getId()==R.id.btnc){
            txvo.setTextColor(Color.BLACK);
            txvc.setTextColor(Color.BLACK);
            btnc.setText("關燈");
            back.setBackgroundColor(Color.BLACK);
            txvcolor.setText("關");
            txvcolor.setTextSize(90);
            txvcolor.setTextColor(Color.WHITE);
        }
        return true;
    }
}