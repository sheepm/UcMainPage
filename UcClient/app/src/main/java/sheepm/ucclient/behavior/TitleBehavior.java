package sheepm.ucclient.behavior;

import android.content.Context;
import android.support.design.widget.CoordinatorLayout;
import android.support.v4.view.ViewCompat;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by paomo on 2016/9/13.
 */
public class TitleBehavior extends CoordinatorLayout.Behavior<View> {

    private static final String TAG = "TitleBehavior";

    public TitleBehavior() {
    }

    public TitleBehavior(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public boolean onStartNestedScroll(CoordinatorLayout coordinatorLayout, View child, View directTargetChild, View target, int nestedScrollAxes) {
        canScroll(child);
        return (nestedScrollAxes & ViewCompat.SCROLL_AXIS_VERTICAL) != 0;
    }

    @Override
    public void onNestedPreScroll(CoordinatorLayout coordinatorLayout, View child, View target, int dx, int dy, int[] consumed) {
        if (canScrollDown(dy,child)) {
            child.setTranslationY(-dy);
            consumed[1] = dy;
        }else {
            child.setTranslationY(0);
        }
    }

    @Override
    public boolean onNestedPreFling(CoordinatorLayout coordinatorLayout, View child, View target, float velocityX, float velocityY) {
        return true;
    }

    private boolean canScroll(View child){
        Log.e(TAG,"TRAN" + child.getTranslationY());
        return true;
    }

    private boolean canScrollDown(int dy , View child){
        if (child.getTranslationY() == 0 && dy > 0){
            return true;
        }else if (child.getTranslationY() < 0 ){
            return true;
        }
        return false;
    }
}
