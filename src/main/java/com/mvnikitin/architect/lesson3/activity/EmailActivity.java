package com.mvnikitin.architect.lesson3.activity;

import com.mvnikitin.architect.lesson3.dosmth.DoSmth;
import com.mvnikitin.architect.lesson3.dosmth.EmailDoSmth;

public class EmailActivity  extends Activity {

    @Override
    public ActivityType getType() {
        return ActivityType.EMAIL;
    }

    @Override
    public DoSmth createDoSmth() {
        return new EmailDoSmth();
    }
}
