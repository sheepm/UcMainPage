package sheepm.ucclient.behavior;

import android.content.Context;
import android.support.design.widget.CoordinatorLayout;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

import sheepm.ucclient.R;

/**
 * Created by paomo on 2016/9/14.
 */
public class ViewPagerBehavior extends CoordinatorLayout.Behavior<View> {

    private static final String TAG = "ViewPagerBehavior";

    public ViewPagerBehavior() {
    }

    public ViewPagerBehavior(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public boolean onDependentViewChanged(CoordinatorLayout parent, View child, View dependency) {
        Log.e(TAG,"" + dependency.getTranslationY());
        child.setTranslationY(dependency.getTranslationY());
        return super.onDependentViewChanged(parent, child, dependency);
    }

    @Override
    public boolean layoutDependsOn(CoordinatorLayout parent, View child, View dependency) {
        return isDepend(dependency);
    }

    private boolean isDepend(View dependency){
        return dependency != null && dependency.getId() == R.id.title_view;
    }
}
