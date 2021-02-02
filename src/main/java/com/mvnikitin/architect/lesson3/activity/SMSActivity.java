package com.mvnikitin.architect.lesson3.activity;

import com.mvnikitin.architect.lesson3.dosmth.DoSmth;
import com.mvnikitin.architect.lesson3.dosmth.SMSDoSmth;

public class SMSActivity   extends Activity {

    @Override
    public ActivityType getType() {
        return ActivityType.SMS;
    }

    @Override
    public DoSmth createDoSmth() {
        return new SMSDoSmth();
    }
}
