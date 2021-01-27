package com.mvnikitin.architect.lesson3.activity;

import com.mvnikitin.architect.lesson3.dosmth.CallDoSmth;
import com.mvnikitin.architect.lesson3.dosmth.DoSmth;

public class CallActivity extends Activity {

    @Override
    public ActivityType getType() {
        return ActivityType.CALL;
    }

    @Override
    public DoSmth createDoSmth() {
        return new CallDoSmth();
    }
}
