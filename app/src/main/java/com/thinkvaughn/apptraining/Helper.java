package com.thinkvaughn.apptraining;


import android.telephony.SmsManager;
import java.util.Calendar;
import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 * Created by jon on 4/12/2015.
 */
public class Helper {

    public void sendSMS(String number, String message){
        SmsManager smsManager =     SmsManager.getDefault();
        smsManager.sendTextMessage(number, null, message, null, null);
    }

    public long getTimeInMilli(){
        long mills = 0;
        try{
           /* SimpleDateFormat sdf = new SimpleDateFormat("dd-M-yyyy hh:mm:ss");
            String dateInString = "22-01-2015 10:20:56";
            Date date = sdf.parse(dateInString);
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(date);
             mills = calendar.getTimeInMillis();
             */
            mills =  System.currentTimeMillis();
        }catch(Exception e){

        }
       return mills;
    }

}
