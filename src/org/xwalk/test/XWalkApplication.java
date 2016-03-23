package org.xwalk.test;

import android.app.Application;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.XmlResourceParser;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.util.TypedValue;

public class XWalkApplication extends Application {
    private static final String TAG = "XWalkTest";

    private XWalkResources mResources;

    private class XWalkResources extends Resources {
        XWalkResources(Resources base) {
            super(base.getAssets(), base.getDisplayMetrics(), base.getConfiguration());
        }

        @Override
        public CharSequence getText(int id) {
            Log.d(TAG, "getText " + super.getText(id));
            return super.getText(id);
        }

        @Override
        public Drawable getDrawable(int id) {
            Log.d(TAG, "getDrwable " + id);
            return super.getDrawable(id);
        }

        @Override
        public XmlResourceParser getLayout(int id) {
            Log.d(TAG, "getLayout " + id);
            return super.getLayout(id);
        }

        @Override
        public int getIdentifier(String name, String defType, String defPackage) {
            Log.d(TAG, "getIdentifier " + name);
            return super.getIdentifier(name, defType, defPackage);
        }

        @Override
        public void getValue(int id, TypedValue outValue, boolean resolveRefs) {
            Log.d(TAG, "getValue " + id);
            super.getValue(id, outValue, resolveRefs);
        }

        @Override
        public void getValueForDensity(int id, int density, TypedValue outValue, boolean resolveRefs) {
            Log.d(TAG, "getValueForDensity " + id);
            super.getValueForDensity(id, density, outValue, resolveRefs);
        }
    }

    @Override
    public Resources getResources() {
        Log.d(TAG, "getResources");
        return mResources != null ? mResources : new XWalkResources(super.getResources());
    }
}
