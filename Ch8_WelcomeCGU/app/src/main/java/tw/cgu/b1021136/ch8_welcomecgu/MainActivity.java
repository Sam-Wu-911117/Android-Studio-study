package tw.cgu.b1021136.ch8_welcomecgu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }
    public void toSecond(View v){
        Intent it =new Intent(this, MainActivity2.class);
        startActivity(it);
    }
    public void finish(View v){
        finish();
    }
}