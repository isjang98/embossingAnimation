package io.github.isang98.embossinganimation;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {



    Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mContext = this;


        setContentView(new EmbossingThumbView(mContext));
    }
}
