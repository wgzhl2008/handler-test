package com.hongshu;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

import com.hongshu.scancode.R;


/**
 * Created by Administrator on 2014/7/6.
 */
public class Active extends Activity implements OnClickListener{
    private Button button;
    private TextView textView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        this.button= (Button) findViewById(R.id.btnScan);
        this.button.setOnClickListener(this);
        this.textView= (TextView) this.findViewById(R.id.txtScan  );
    }

    public void onClick(View view) {

        Intent intent = new Intent("com.google.zxing.client.android.SCAN");
        this.startActivityForResult(intent,0);


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        if(requestCode!=0){
            this.textView.setText(R.string.noresult);
            return;
        }
        if (resultCode==RESULT_OK) {
            String contents = data.getStringExtra("SCAN_RESULT");
            String format = data.getStringExtra("SCAN_RESULT_FORMAT");
            textView.setText("条形码为" + contents + "条形码类型为：" + format);
        }

    }
}
