package com.smartdengg.rxviewstub.interal;

import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.atomic.AtomicBoolean;
import rx.Subscription;

/**
 * Created by SmartDengg on 2016/5/8.
 */
public abstract class MainThreadSubscription extends AtomicBoolean implements Subscription, Runnable {

    private static final Handler mainThread = new Handler(Looper.getMainLooper());

    @Override
    public final boolean isUnsubscribed() {
        return this.get();
    }

    @Override
    public final void unsubscribe() {
        if (this.compareAndSet(false, true)) {
            if (Looper.getMainLooper() == Looper.myLooper()) {
                onUnsubscribe();
            } else {
                mainThread.post(this);
            }
        }
    }

    @Override
    public final void run() {
        this.onUnsubscribe();
    }

    protected abstract void onUnsubscribe();
}
