package com.vogella.android.expressofirst;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.support.test.runner.intercepting.SingleActivityFactory;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.InstrumentationRegistry.getInstrumentation;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.intent.matcher.IntentMatchers.hasAction;
import static android.support.test.espresso.matcher.ViewMatchers.assertThat;
import static android.support.test.espresso.matcher.ViewMatchers.withId;

/**
 * Demonstrates the usage of
 * {@link ActivityTestRule#ActivityTestRule(SingleActivityFactory, boolean, boolean)}  to intercept
 * methods of Activity and/or its parent classes.
 */
@RunWith(AndroidJUnit4.class)
public class InterceptingActivitySampleTest {
    private Intent broadcastIntent;
    @Rule
    public ActivityTestRule<InterceptingActivity> activityTestRule =
            new ActivityTestRule<InterceptingActivity>(getActivityFactory(), true, false);
    @Before
    public void setUp() throws Exception {
        broadcastIntent = null;
    }
    @Test
    public void shouldSendBroadcastOnButtonClick() throws Exception {
        activityTestRule.launchActivity(null);
        onView(withId(R.id.btn_send_broadcast)).perform(click());
        getInstrumentation().waitForIdleSync();
        assertThat(broadcastIntent, hasAction("A_CUSTOM_ACTION"));
    }
    @NonNull
    private SingleActivityFactory<InterceptingActivity> getActivityFactory() {
        return new SingleActivityFactory<InterceptingActivity>(InterceptingActivity.class) {
            @Override
            public InterceptingActivity create(Intent intent) {
                return new InterceptingActivity() {
                    @Override
                    public void sendBroadcast(Intent intent) {
                        broadcastIntent = intent;
                    }
                };
            }
        };
    }
}