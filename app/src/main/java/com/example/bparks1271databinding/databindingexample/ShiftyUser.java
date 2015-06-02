package com.example.bparks1271databinding.databindingexample;

import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.databinding.BindingAdapter;
import android.databinding.Observable;
import android.databinding.ObservableField;
import android.databinding.ObservableInt;
import android.os.Handler;
import android.view.View;

import java.util.Random;

/**
 * Created by bparks1271 on 5/31/15.
 *
 * This user is really shifty. Watch out!
 */
public class ShiftyUser extends BaseObservable {
    @Bindable
    public final ObservableField<String> firstName = new ObservableField<>();
    @Bindable
    public final ObservableField<String> lastName = new ObservableField<>();

    /*
    Configurable layout params
     */
    @Bindable
    public final ObservableInt paddingLeft = new ObservableInt();

    public void makeShifty() {



        final Handler handler = new Handler();
        final Runnable runnable = new Runnable() {

            @Override
            public void run() {
                final Random random = new Random();
                int i = random.nextInt(5);
                firstName.set("Hello from ShiftyUser Model class \n" + i);
                lastName.set("Goodbye from ShiftyUser Model class \n" + i);
                randomizeConfigurableLayoutParams();
                handler.postDelayed(this, 1000);
            }
        };
        handler.post(runnable);
    }

    public void randomizeConfigurableLayoutParams() {
        final Random random = new Random();
        int i = random.nextInt(100);
        paddingLeft.set(i);
    }

    @BindingAdapter("android:paddingLeft")
    public static void setPaddingLeft(View view, int padding) {

        view.setPadding(padding,
                view.getPaddingTop(),
                view.getPaddingRight(),
                view.getPaddingBottom());
    }
}