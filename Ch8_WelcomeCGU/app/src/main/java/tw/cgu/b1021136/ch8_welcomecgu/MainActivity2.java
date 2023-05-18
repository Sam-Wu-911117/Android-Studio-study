package tw.cgu.b1021136.ch8_welcomecgu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
    }
    public void toThird(View v){
        Intent it=new Intent(this,MainActivity3.class);
        startActivity(it);
    }
    public void toFourth(View v){
        Intent it=new Intent(this,MainActivity4.class);
        startActivity(it);
    }
    public void goBack(View v){
        finish();
    }
}