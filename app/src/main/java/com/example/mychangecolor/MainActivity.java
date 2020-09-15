package com.example.mychangecolor;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import net.margaritov.preference.colorpicker.ColorPickerDialog;

public class MainActivity extends AppCompatActivity {
Button btn;
TextView text;
RelativeLayout layout;
ColorPickerDialog colord;
int color;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        text=findViewById(R.id.textview);
        layout=findViewById(R.id.layout);
        btn=findViewById(R.id.button);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                color= Color.parseColor("#005500");
                colord=new ColorPickerDialog(MainActivity.this,color);
                colord.setAlphaSliderVisible(true);
                colord.setTitle("Color Piker");
                colord.setOnColorChangedListener(new ColorPickerDialog.OnColorChangedListener() {
                    @Override
                    public void onColorChanged(int i) {
                        color=i;
                        layout.setBackgroundColor(color);
                        text.setText("#"+ Integer.toHexString(color));
                        text.setTextColor(color);
                    }
                });colord.show();
            }
        });
    }

    public void btn_start(View view) {
        Toast toast=new Toast(this);
        toast.setDuration(Toast.LENGTH_LONG);
        toast.setGravity(Gravity.CENTER,0,0);
        LayoutInflater ly=getLayoutInflater();
            View view1= ly.inflate(R.layout.toast_welcome,(ViewGroup)findViewById(R.id.linear_layout_toast));
            TextView txt=(TextView)view1.findViewById(R.id.txttoast);
        TextView txt1=(TextView)view1.findViewById(R.id.txt1toast);
            txt.setText("مرحبا بكم في التطبيق");
            txt1.setText("السلام عليكم ورحمة الله وبركاته");
            toast.setView(view1);
            toast.show();
    }
}
