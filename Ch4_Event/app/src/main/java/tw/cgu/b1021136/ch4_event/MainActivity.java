package tw.cgu.b1021136.ch4_event;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener,View.OnLongClickListener{

    TextView txv;
    Button btn;
    int counter = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txv =(TextView) findViewById(R.id.textView);
        btn =(Button) findViewById(R.id.button);
        btn.setOnClickListener(this);
        btn.setOnLongClickListener(this);
        txv.setOnLongClickListener(this);
    }

    @Override
    public void onClick(View v) {
        txv.setText(String.valueOf(++counter));
    }

    @Override
    public boolean onLongClick(View v) {
        if(v.getId()==R.id.textView){
            counter =0;
            txv.setText("0");
        }
        else{
            counter+=2;
            txv.setText(String.valueOf(counter));
        }
        return true;
    }
}