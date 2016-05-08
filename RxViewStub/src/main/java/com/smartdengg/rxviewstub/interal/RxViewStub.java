package com.smartdengg.rxviewstub.interal;

import android.view.ViewStub;
import com.smartdengg.rxviewstub.Utils;
import rx.Observable;

/**
 * Created by Joker on 2016/5/8.
 */
public class RxViewStub {

    private RxViewStub() {
        throw new IllegalStateException("No instances!");
    }

    public static Observable<ViewStubEvent> inflateEvent(ViewStub viewStub) {

        Utils.checkNotNull(viewStub, "viewStub == null");

        return Observable.create(new ViewStubEventOnSubscribe(viewStub));
    }
}
