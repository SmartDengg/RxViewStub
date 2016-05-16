package com.smartdengg.example;

import android.graphics.drawable.Drawable;
import android.graphics.drawable.TransitionDrawable;
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
    private ImageView hero;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(MainActivity.this);

        RxViewStub.inflateEvent(viewStub)
                  .subscribe(new Action1<ViewStubEvent>() {
                      @Override
                      public void call(ViewStubEvent viewStubEvent) {

                          hero = (ImageView) viewStubEvent.getInflated();

                          Drawable[] layers = new Drawable[2];
                          layers[0] = getResources().getDrawable(R.drawable.ic_android_y);
                          layers[1] = getResources().getDrawable(R.drawable.ic_android_g);

                          TransitionDrawable transitionDrawable = new TransitionDrawable(layers);
                          hero.setImageDrawable(transitionDrawable);
                          transitionDrawable.setCrossFadeEnabled(true);
                          transitionDrawable.startTransition(3 * 1000);
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
        this.hero.setImageBitmap(null);
        ButterKnife.unbind(MainActivity.this);
    }
}
