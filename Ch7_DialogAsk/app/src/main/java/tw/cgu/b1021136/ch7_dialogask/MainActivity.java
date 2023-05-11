package tw.cgu.b1021136.ch7_dialogask;

import androidx.appcompat.app.AppCompatActivity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.graphics.Color;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements DialogInterface.OnClickListener {
    TextView txv;
    Button start;
    ImageView work,choise,cheap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txv=(TextView) findViewById(R.id.txv);
        start=(Button)findViewById(R.id.start);
        work=(ImageView)findViewById(R.id.work);
        choise=(ImageView)findViewById(R.id.choise);
        cheap=(ImageView)findViewById(R.id.cheap);


    }

    @Override
    public void onClick(DialogInterface dialogInterface, int which) {
        if(which==DialogInterface.BUTTON_POSITIVE){
            txv.setText("長庚五年一貫便宜又快速");
            txv.setTextColor(Color.BLUE);
            cheap.setVisibility(View.VISIBLE);
            work.setVisibility(View.GONE);
            choise.setVisibility(View.GONE);

        }
        else if(which==DialogInterface.BUTTON_NEGATIVE){
            txv.setText("可以慢慢找工作了");
            txv.setTextColor(Color.RED);
            cheap.setVisibility(View.GONE);
            work.setVisibility(View.VISIBLE);
            choise.setVisibility(View.GONE);
        }
        else if (which==DialogInterface.BUTTON_NEUTRAL) {
            txv.setText("祝你有個好的決定");
            txv.setTextColor(Color.GREEN);
            cheap.setVisibility(View.GONE);
            choise.setVisibility(View.VISIBLE);
            work.setVisibility(View.GONE);
        }
    }
    public void start(View v){
        new AlertDialog.Builder(this)
                .setMessage("你打算念研究所嗎?")
                .setCancelable(false)
                .setIcon(android.R.drawable.ic_menu_edit)
                .setTitle("畢業問卷調查")
                .setPositiveButton("打算",this)
                .setNegativeButton("不打算",this)
                .setNeutralButton("考慮中",this)
                .show();
        start.setText("再問一遍");
    }

}