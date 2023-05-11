package tw.cgu.b1021136.ch7_toast;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {
    String[] queArr={"誰是萬獸之王？", "什麼人死後還會出現？", "什麼帽不能戴？","什麼桶子裝不滿？"
    ,"什麼車最長？","什麼地方自討苦吃？", "什麼人最不聽話？", "什麼牛不會吃草？", "什麼地方看的月亮最大？",
            "什麼東西比細菌還小？" };
    String[] ansArr={"動物園園長","電影中的人","螺帽","馬桶","塞車","藥店","聾子","蝸牛","月球上","細菌的兒子"};
    Toast tos;
    //Snackbar sbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ArrayAdapter<String> adapter=new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1,queArr);
        ListView lv=(ListView) findViewById(R.id.lv);
        lv.setAdapter(adapter);
        lv.setOnItemClickListener(this);
        tos=Toast.makeText(this,"",Toast.LENGTH_SHORT);
        //sbar=Snackbar.make(findViewById(R.id.root),"",Snackbar.LENGTH_SHORT);
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
        tos.setText("答案:"+ansArr[position]);
        tos.show();
        Toast.makeText(this,"答案:"+ansArr[position],Toast.LENGTH_SHORT).show();
        //sbar.setText("答案:"+ansArr[position]);
        //sbar.show();
    }
}