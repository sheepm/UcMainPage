package sheepm.ucclient.behavior;

import android.content.Context;
import android.support.design.widget.CoordinatorLayout;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

import java.util.List;

import sheepm.ucclient.R;

/**
 * Created by paomo on 2016/9/13.
 */
public class WebsiteBehavior extends CoordinatorLayout.Behavior<View> {

    private static final String TAG = "WebsiteBehavior";

    public WebsiteBehavior() {
    }

    public WebsiteBehavior(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public boolean onLayoutChild(CoordinatorLayout parent, View child, int layoutDirection) {
        List<View> dependencies = parent.getDependencies(child);
        Log.e(TAG,dependencies.toString());
        return super.onLayoutChild(parent, child, layoutDirection);
    }

    @Override
    public boolean layoutDependsOn(CoordinatorLayout parent, View child, View dependency) {
        Log.e(TAG,"depen" + isDepend(dependency));
        return isDepend(dependency);
    }

    private boolean isDepend(View dependency){
        return dependency != null && dependency.getId() == R.id.vp_main;
    }
}
