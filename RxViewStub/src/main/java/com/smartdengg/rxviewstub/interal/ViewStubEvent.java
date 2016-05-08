package com.smartdengg.rxviewstub.interal;

import android.view.View;
import android.view.ViewStub;

/**
 * Created by Joker on 2016/5/8.
 */
public class ViewStubEvent {

    private View view;
    private View inflated;

    public static ViewStubEvent create(ViewStub viewStub, View inflated) {
        return new ViewStubEvent(viewStub, inflated);
    }

    private ViewStubEvent(ViewStub viewStub, View inflated) {
        this.view = viewStub;
        this.inflated = inflated;
    }

    public View getInflated() {
        return inflated;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) return true;
        if (!(o instanceof ViewStubEvent)) return false;
        ViewStubEvent other = (ViewStubEvent) o;
        return other.view == ViewStubEvent.this.view && other.inflated.equals(ViewStubEvent.this.inflated);
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = result * 37 + view.hashCode();
        result = result * 37 + inflated.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "ViewStubEvent{" +
                "view" + view +
                "inflated=" + inflated +
                '}';
    }
}
