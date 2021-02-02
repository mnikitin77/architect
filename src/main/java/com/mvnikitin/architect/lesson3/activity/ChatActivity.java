package com.mvnikitin.architect.lesson3.activity;

import com.mvnikitin.architect.lesson3.dosmth.ChatDoSmth;
import com.mvnikitin.architect.lesson3.dosmth.DoSmth;

public class ChatActivity extends Activity {

    @Override
    public ActivityType getType() {
        return ActivityType.CHAT;
    }

    @Override
    public DoSmth createDoSmth() {
        return new ChatDoSmth();
    }
}
