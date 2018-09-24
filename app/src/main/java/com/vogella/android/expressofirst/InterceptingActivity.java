package com.vogella.android.expressofirst;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.view.View;
import android.widget.EditText;

import java.util.List;

import pub.devrel.easypermissions.AfterPermissionGranted;
import pub.devrel.easypermissions.EasyPermissions;

public class InterceptingActivity extends ProgressActivity implements
        EasyPermissions.PermissionCallbacks,
        View.OnClickListener{

    private static final int RC_HONE_STATE_PERM = 201;
    private EditText mPhoneNumberField;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intercepting);
        mPhoneNumberField = findViewById(R.id.field_phone_number);
        TelephonyManager tMgr = (TelephonyManager) getSystemService(this.TELEPHONY_SERVICE);
        requestPermissions();

    }

    public void btnOnClicked(View view) {
        sendBroadcast(new Intent("A_CUSTOM_ACTION"));
    }

    @Override
    public void onClick(View view) {

    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        // Forward results to EasyPermissions
        EasyPermissions.onRequestPermissionsResult(requestCode, permissions, grantResults, this);
    }

    @AfterPermissionGranted(RC_HONE_STATE_PERM)
    private void requestPermissions() {

        String[] perms = {Manifest.permission.READ_PHONE_STATE, Manifest.permission.READ_SMS};
        if (EasyPermissions.hasPermissions(this, perms)) {
            setDefaultPhoneNumber();
        } else {
            EasyPermissions.requestPermissions(this, "permission requied", RC_HONE_STATE_PERM, perms);
        }
    }
    @Override
    public void onPermissionsGranted(int requestCode, @NonNull List<String> perms) {
        //Log.d(TAG, "permissions denied !");
    }

    @Override
    public void onPermissionsDenied(int requestCode, @NonNull List<String> perms) {
        //Log.d(TAG, "----> permissions granted");
        setDefaultPhoneNumber();
    }

    private void setDefaultPhoneNumber() {

        mPhoneNumberField.setText("+123456788");
    }

}
