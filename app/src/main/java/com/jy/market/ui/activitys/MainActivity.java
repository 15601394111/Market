package com.jy.market.ui.activitys;

import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.design.internal.BottomNavigationItemView;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.FrameLayout;

import com.jy.market.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.fragmentBox)
    FrameLayout mFragmentBox;
    @BindView(R.id.navigation)
    BottomNavigationItemView mNavigation;
    @BindView(R.id.container)
    ConstraintLayout mContainer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        mNavigation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()) {
                    case R.id.item_home:
                        break;
                    case R.id.item_project:
                        break;
                    case R.id.item_classification:
                        break;
                    case R.id.item_shopping_cart:
                        break;
                    case R.id.item_my:
                        break;
                }
            }
        });
    }
}
