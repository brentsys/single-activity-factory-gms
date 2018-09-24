package com.vogella.android.expressofirst;

import android.content.Intent;
import android.support.test.rule.ActivityTestRule;

import org.junit.Rule;
import org.junit.Test;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.junit.Assert.*;

public class SecondActivityTest {
    @Rule
    // third parameter is set to false which means the activity is not started automatically
    public ActivityTestRule<SecondActivity> rule =
            new ActivityTestRule(SecondActivity.class, true, false);

    @Test
    public void demonstrateIntentPrep() {
        Intent intent = new Intent();
        intent.putExtra("input", "Test");
        rule.launchActivity(intent);
        onView(withId(R.id.resultView)).check(matches(withText("Test")));
    }
}