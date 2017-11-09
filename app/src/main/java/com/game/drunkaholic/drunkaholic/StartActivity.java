package com.game.drunkaholic.drunkaholic;

import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class StartActivity extends AppCompatActivity
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        ConstraintLayout r1 = findViewById(R.id.layout_disclaimer);
        r1.setBackgroundColor(getResources().getColor(R.color.colorBackground));

        final TextView tv =findViewById(R.id.disclaimer);
        tv.setTextColor(getResources().getColor(R.color.colorText));
    }
}
