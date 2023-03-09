package tw.cgu.b1021136.ch3_layout;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText name,grade,phone,pw;
    TextView txv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        name=(EditText) findViewById(R.id.setname);
        grade=(EditText) findViewById(R.id.setgrade);
        phone=(EditText) findViewById(R.id.phone);
        pw=(EditText) findViewById(R.id.pw);
        txv =(TextView) findViewById(R.id.txv);

    }
    public void onclick(View V){
        String stA = pw.getText().toString();
        String stB = "cgu2018";
        if (stA.equals(stB)){
            txv.setText("密碼正確");
        }
        else{
            txv.setText("密碼錯誤");
        }

    }
}