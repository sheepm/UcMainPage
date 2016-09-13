package sheepm.ucclient;

import android.animation.ObjectAnimator;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.ViewTreeObserver;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import sheepm.ucclient.fragment.MainFragment;
import sheepm.ucclient.fragment.SecondFragment;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    private ViewPager mVpMain;
    private MyPagerAdapter mAdapter;
    private LinearLayout mLlTitle;

    private int height;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        mLlTitle = (LinearLayout) findViewById(R.id.title_view);
        mVpMain = (ViewPager) findViewById(R.id.vp_main);
        mAdapter = new MyPagerAdapter(getSupportFragmentManager());
        mVpMain.setAdapter(mAdapter);
        mVpMain.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                Log.e(TAG,"position : " + position + "positionOffset : " + positionOffset + "positionOffsetPixels : " + positionOffsetPixels);
                if (position == 0 && positionOffset != 0.0){
                    RelativeLayout.LayoutParams lp = (RelativeLayout.LayoutParams) mLlTitle.getLayoutParams();
                    lp.topMargin = (int) (- (height - 150) * positionOffset);
                    mLlTitle.setLayoutParams(lp);
//                    ObjectAnimator.ofFloat(mLlTitle,"translateY",height,height -  (height - 150 ) * positionOffset ).start();
                }
            }

            @Override
            public void onPageSelected(int position) {
                Log.e(TAG,"position : " + position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {
                Log.e(TAG,"state : " + state);
            }
        });
        mLlTitle.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener() {
            @Override
            public boolean onPreDraw() {
                height = mLlTitle.getMeasuredHeight();
                mLlTitle.getViewTreeObserver().removeOnPreDrawListener(this);
                return true;
            }
        });
    }


    private class MyPagerAdapter extends FragmentPagerAdapter{

        public MyPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            switch (position){
                case 0:
                    return MainFragment.newInstance();
                case 1:
                    return SecondFragment.newInstance();
                default:
                    return MainFragment.newInstance();
            }
        }

        @Override
        public int getCount() {
            return 2;
        }
    }
}
