package org.xwalk.test;

import android.app.Activity;
import android.os.Message;
import android.util.Log;
import android.view.ViewGroup;
import android.webkit.JsResult;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebView.WebViewTransport;

import java.util.LinkedList;

public class TestWebChromeClient extends WebChromeClient {
    private static final String TAG = "XWalkTest";

    Activity mActivity;
    ViewGroup mRootView;
    LinkedList<WebView> mViewHistory;

    public TestWebChromeClient(Activity activity, ViewGroup rootView, LinkedList<WebView> viewHistory) {
        mActivity = activity;
        mRootView = rootView;
        mViewHistory = viewHistory;
    }

    @Override
    public void onRequestFocus(WebView view) {
        Log.d(TAG, "onRequestFocus");
    }

    @Override
    public boolean onCreateWindow(WebView view, boolean isDialog, boolean isUserGesture,
            Message resultMsg) {
        Log.d(TAG, "onCreateWindow: " + isDialog + "," + isUserGesture);
        TestWebView newView = new TestWebView(mActivity);

        mRootView.removeView(mViewHistory.getLast());
        mRootView.addView(newView);
        mViewHistory.add(newView);

        WebSettings settings = newView.getSettings();
        settings.setSupportMultipleWindows(true);
        settings.setJavaScriptEnabled(true);

        newView.setWebChromeClient(new TestWebChromeClient(mActivity, mRootView, mViewHistory));
        newView.setWebViewClient(new TestWebViewClient());
        newView.addJavascriptInterface();

        WebViewTransport transport = (WebViewTransport) resultMsg.obj;
        transport.setWebView(newView);
        resultMsg.sendToTarget();

        return true;
    }

    @Override
    public boolean onJsAlert(WebView view, String url, String message, JsResult result) {
        Log.d(TAG, "onJsAlert: " + url + "," + message + "," + result);
        return true;
    }
}
