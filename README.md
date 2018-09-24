# single-activity-factory-gms
This project demonstrates how SingleActivityFactory crashes when using apply 'com.google.gms.google-services'.

Project built with AndroidStudio 3.1.4.

We are just focusing on **InterceptingActivitySampleTest.java**

### `master` branch

The master branch does not use google-services.
The test runs successfully.

### `buggy` branch

> classpath 'com.google.gms:google-services:4.0.1'

is added to Project build.gradle

> apply plugin: 'com.google.gms.google-services'

is added to moddule build.gradle

as a result, InterceptingActivitySampleTest.java fails with following result:

    java.lang.NullPointerException: Attempt to invoke virtual method 'java.lang.String[] java.lang.String.split(java.lang.String)' on a null object reference
at com.google.android.gms.internal.measurement.zzih.zzcd(Unknown Source:2)
at com.google.android.gms.internal.measurement.zzih.zze(Unknown Source:21)
at com.google.android.gms.internal.measurement.zzih.onActivityResumed(Unknown Source:0)
at com.google.android.gms.internal.measurement.zzif.onActivityResumed(Unknown Source:6)
at android.app.Application.dispatchActivityResumed(Application.java:288)
at android.app.Activity.onResume(Activity.java:1333)
at android.support.v4.app.FragmentActivity.onResume(FragmentActivity.java:485)
at android.app.Instrumentation.callActivityOnResume(Instrumentation.java:1355)
at android.support.test.runner.MonitoringInstrumentation.callActivityOnResume(MonitoringInstrumentation.java:699)
at android.app.Activity.performResume(Activity.java:7120)
at android.app.ActivityThread.performResumeActivity(ActivityThread.java:3650)
at android.app.ActivityThread.handleResumeActivity(ActivityThread.java:3715)
at android.app.ActivityThread.handleLaunchActivity(ActivityThread.java:2908)
at android.app.ActivityThread.-wrap11(Unknown Source:0)
at android.app.ActivityThread$H.handleMessage(ActivityThread.java:1603)
at android.os.Handler.dispatchMessage(Handler.java:105)
at android.os.Looper.loop(Looper.java:169)
at android.app.ActivityThread.main(ActivityThread.java:6578)
at java.lang.reflect.Method.invoke(Native Method)
at com.android.internal.os.Zygote$MethodAndArgsCaller.run(Zygote.java:240)
at com.android.internal.os.ZygoteInit.main(ZygoteInit.java:767)


java.lang.RuntimeException: Unable to resume activity {com.vogella.android.expressofirst/com.vogella.android.expressofirst.InterceptingActivity}: java.lang.NullPointerException: Attempt to invoke virtual method 'java.lang.String[] java.lang.String.split(java.lang.String)' on a null object reference
at android.app.ActivityThread.performResumeActivity(ActivityThread.java:3675)
at android.app.ActivityThread.handleResumeActivity(ActivityThread.java:3715)
at android.app.ActivityThread.handleLaunchActivity(ActivityThread.java:2908)
at android.app.ActivityThread.-wrap11(Unknown Source:0)
at android.app.ActivityThread$H.handleMessage(ActivityThread.java:1603)
at android.os.Handler.dispatchMessage(Handler.java:105)
at android.os.Looper.loop(Looper.java:169)
at android.app.ActivityThread.main(ActivityThread.java:6578)
at java.lang.reflect.Method.invoke(Native Method)
at com.android.internal.os.Zygote$MethodAndArgsCaller.run(Zygote.java:240)
at com.android.internal.os.ZygoteInit.main(ZygoteInit.java:767)
Caused by: java.lang.NullPointerException: Attempt to invoke virtual method 'java.lang.String[] java.lang.String.split(java.lang.String)' on a null object reference
at com.google.android.gms.internal.measurement.zzih.zzcd(Unknown Source:2)
at com.google.android.gms.internal.measurement.zzih.zze(Unknown Source:21)
at com.google.android.gms.internal.measurement.zzih.onActivityResumed(Unknown Source:0)
at com.google.android.gms.internal.measurement.zzif.onActivityResumed(Unknown Source:6)
at android.app.Application.dispatchActivityResumed(Application.java:288)
at android.app.Activity.onResume(Activity.java:1333)
at android.support.v4.app.FragmentActivity.onResume(FragmentActivity.java:485)
at android.app.Instrumentation.callActivityOnResume(Instrumentation.java:1355)
at android.support.test.runner.MonitoringInstrumentation.callActivityOnResume(MonitoringInstrumentation.java:699)
at android.app.Activity.performResume(Activity.java:7120)
at android.app.ActivityThread.performResumeActivity(ActivityThread.java:3650)
... 10 more

Test running failed: Instrumentation run failed due to 'Process crashed.'

