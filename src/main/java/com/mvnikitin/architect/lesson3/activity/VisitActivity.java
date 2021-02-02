package com.mvnikitin.architect.lesson3.activity;

import com.mvnikitin.architect.lesson3.dosmth.DoSmth;
import com.mvnikitin.architect.lesson3.dosmth.VisitDoSmth;

public class VisitActivity extends Activity {

    @Override
    public ActivityType getType() {
        return ActivityType.VISIT;
    }

    @Override
    public DoSmth createDoSmth() {
        return new VisitDoSmth();
    }
}
