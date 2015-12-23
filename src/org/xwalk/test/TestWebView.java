package org.xwalk.test;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.webkit.JavascriptInterface;
import android.webkit.WebView;
import android.widget.Toast;

public class TestWebView extends WebView {
    private static final String TAG = "XWalkTest";

    private class TestJavascriptInterface {
        @JavascriptInterface
        public void showText() {
            Toast.makeText(getContext(), "TestJavascriptInterface", Toast.LENGTH_SHORT).show();
        }
    }

    public TestWebView(Context context) {
        super(context);
    }

    public TestWebView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public void addJavascriptInterface() {
        addJavascriptInterface(new TestJavascriptInterface(), "testJavascriptObject");
    }

    @Override
    public InputConnection onCreateInputConnection(EditorInfo outAttrs) {
        Log.d(TAG, "onCreateInputConnection");
        InputConnection inputConnection = super.onCreateInputConnection(outAttrs);
        return inputConnection;
    }

    @Override
    protected boolean overScrollBy(int deltaX, int deltaY, int scrollX, int scrollY,
            int scrollRangeX, int scrollRangeY, int maxOverScrollX, int maxOverScrollY,
            boolean isTouchEvent){
        Log.d(TAG, "overScrollBy: " + deltaX + "," + deltaY + "," + scrollX + "," + scrollY + "," + scrollRangeX
                + "," + scrollRangeY + "," + maxOverScrollX + "," + maxOverScrollY + "," + isTouchEvent);
        return super.overScrollBy(deltaX, deltaY, scrollX, scrollY, scrollRangeX, scrollRangeY,
                maxOverScrollX, maxOverScrollX, isTouchEvent);
    }

    @Override
    protected void onOverScrolled(int scrollX, int scrollY, boolean clampedX, boolean clampedY) {
        Log.d(TAG, "onOverScrolled: " + scrollX + "," + scrollY + "," + clampedX + "," + clampedY);
        super.onOverScrolled(scrollX, scrollY, clampedX, clampedY);
    }

    @Override
    public void onScrollChanged(int l, int t, int oldl, int oldt) {
        //Log.d(TAG, "onScrollChanged: " + l + "," + t + "," + oldl + "," + oldt);
        super.onScrollChanged(l, t, oldl, oldt);
    }
}
