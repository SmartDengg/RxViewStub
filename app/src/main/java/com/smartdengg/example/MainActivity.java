package com.smartdengg.example;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewStub;
import android.widget.ImageView;
import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.smartdengg.rxviewstub.interal.RxViewStub;
import com.smartdengg.rxviewstub.interal.ViewStubEvent;
import rx.functions.Action1;

public class MainActivity extends AppCompatActivity {

    @Nullable
    @Bind(R.id.viewstub)
    protected ViewStub viewStub;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(MainActivity.this);

        RxViewStub.inflateEvent(viewStub)
                  .subscribe(new Action1<ViewStubEvent>() {
                      @Override
                      public void call(ViewStubEvent viewStubEvent) {
                          ((ImageView) viewStubEvent.getInflated()).setImageDrawable(getResources().getDrawable(R.drawable.ic_android));
                      }
                  });
    }

    @OnClick(R.id.button)
    protected void onStubClick() {
        this.viewStub.setVisibility(View.VISIBLE);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ButterKnife.unbind(MainActivity.this);
    }
}
