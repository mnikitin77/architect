package com.mvnikitin.architect.lesson3;

import com.mvnikitin.architect.lesson3.activity.*;

import java.util.HashMap;
import java.util.Map;

public class ActivityFactoryMethod {

    private static Map<ActivityType, Activity> activities = new HashMap<>();
    static {
        activities.put(ActivityType.CALL, new CallActivity());
        activities.put(ActivityType.CHAT, new ChatActivity());
        activities.put(ActivityType.EMAIL, new EmailActivity());
        activities.put(ActivityType.SMS, new SMSActivity());
        activities.put(ActivityType.VISIT, new VisitActivity());
    }

    private static final ActivityFactoryMethod instance = new ActivityFactoryMethod();

    private ActivityFactoryMethod() {}

    public static ActivityFactoryMethod getInstance() {
        return instance;
    }

    Activity getActivity(ActivityType type) {
        return activities.get(type);
    }
}
