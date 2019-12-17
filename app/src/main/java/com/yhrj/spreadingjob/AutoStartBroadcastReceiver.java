package com.yhrj.spreadingjob;


import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

//开机自启动广播接受
public class AutoStartBroadcastReceiver extends BroadcastReceiver {
    static final String action_boot ="android.intent.action.BOOT_COMPLETED";
    @Override
    public void onReceive(Context context, Intent intent) {
        if (intent.getAction().equals(action_boot)){
            Intent autoStartIntent=new Intent(context,FullscreenActivity.class);
            autoStartIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(autoStartIntent);
        }
    }
}
