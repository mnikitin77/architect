package com.mvnikitin.architect.lesson3;

import com.mvnikitin.architect.lesson3.activity.ActivityType;

public class StupidCRMApplication {
    public static void main(String[] args) {
        ActivityFactoryMethod.getInstance()
                .getActivity(ActivityType.CALL).doSmth();
        ActivityFactoryMethod.getInstance()
                .getActivity(ActivityType.VISIT).doSmth();
    }
}
