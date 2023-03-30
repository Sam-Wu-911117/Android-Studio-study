package tw.cgu.b1021136.motionneon;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Vibrator;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    TextView txv ;
    View bg;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txv=(TextView)findViewById(R.id.txv);
        bg=(View)findViewById(R.id.BG);


    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        Vibrator vb =(Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
        if(event.getAction()==MotionEvent.ACTION_DOWN){
            vb.vibrate(1000);
            txv.setText("七彩霓虹燈\n震動中");
            txv.setTextSize(50);
            txv.setTextColor(Color.WHITE);
            bg.setBackgroundColor(Color.BLACK);
        }
        else if (event.getAction()==MotionEvent.ACTION_MOVE) {
            vb.vibrate(1000);
            Random x=new Random();
            int r =x.nextInt(256);
            int g = x.nextInt(256);
            int b =x.nextInt(256);
            txv.setTextColor(Color.rgb(r, g, b));
            txv.setText("七彩霓虹燈\n震動中");
            txv.setTextSize(50);
            bg.setBackgroundColor(Color.rgb(255-r,255-g,255-b));
        }
        else if (event.getAction()==MotionEvent.ACTION_UP) {
            bg.setBackgroundColor(Color.BLACK);
            txv.setText("動霓虹");
            txv.setTextColor(Color.WHITE);
            txv.setTextSize(40);
            vb.cancel();
        }
        return true;
    }
}