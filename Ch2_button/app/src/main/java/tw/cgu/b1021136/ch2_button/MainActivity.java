package tw.cgu.b1021136.ch2_button;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    //<JAVA>Object : 所有類別的最上層父類別
    //<Android> View : 所有類別的最上層父類別 (多型)

    public void Test(View v){
        //cout<<"as",printf("as")
        //textV.setText("abc");
        //text.setTextSize("20");//20sp
        //editT.getText();//取得內容
        //editT.getText().toString();//取得內容後轉文字格式

        //R.id.txv<-- 元件名稱
        // 常用物件的類別 TextView,EditText

    }
    int size=30;
    public void bigger(View V){
        TextView txv =findViewById(R.id.txv);
        txv.setTextSize(++size);
    }
    public void smaller(View V){
        TextView txv  =findViewById(R.id.txv);
        txv.setTextSize(--size);
    }

    public void confirm (View V){
        EditText name =findViewById(R.id.name);
        TextView txv =findViewById(R.id.txv);
        txv.setText("你好!"+name.getText().toString());
    }
}