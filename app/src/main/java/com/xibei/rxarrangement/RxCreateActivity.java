package com.xibei.rxarrangement;

import android.nfc.Tag;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/**
 * Created by Xibei on 2019-10-28.
 * Github: https://github.com/jiezongnewstar
 * Email: ibossjia@gmail.com
 * Deeclaration:
 */
public class RxCreateActivity extends AppCompatActivity {

    private static final String TAG = "XB";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.rx_create);


    }


    // 基本用法
    public void basic(View view) {
        Observable observable = Observable.create(new ObservableOnSubscribe() {
            @Override
            public void subscribe(ObservableEmitter emitter) throws Exception {
                emitter.onNext("阿西吧");
                emitter.onComplete();
            }
        });

        Observer observer = new Observer() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(Object o) {
                Log.e(TAG,"onNext " + o);
            }

            @Override
            public void onError(Throwable e) {
                Log.e(TAG,"onError " + e.getMessage());
            }

            @Override
            public void onComplete() {
                Log.e(TAG,"onComplete ");

            }
        };

        observable.subscribe(observer);
    }



    //链式调用
    public void chain(View view) {

        Observable.create(new ObservableOnSubscribe<Object>() {

            @Override
            public void subscribe(ObservableEmitter<Object> emitter) throws Exception {
                emitter.onNext(" 链式 阿西吧");
            }
        }).subscribe(new Observer<Object>() {

            @Override
            public void onSubscribe(Disposable d) {
                Log.e(TAG,"链式 onSubscribe");
            }

            @Override
            public void onNext(Object o) {
                Log.e(TAG,"链式 onNext" + o);

            }


            @Override
            public void onError(Throwable e) {
                Log.e(TAG,"链式 onError" + e);

            }

            @Override
            public void onComplete() {
                Log.e(TAG,"链式 onComplete");

            }
        });
    }



    // 创建型操作符 just 用法
    // 被观察者依次发送 阿西吧1 、阿西吧2 、 阿西吧3 ，观察者依次收到 阿西吧1 、阿西吧2 、 阿西吧3
    public void just(View view) {

        Observable.just("阿西吧1","阿西吧2","阿西吧3")
                .subscribe(new Observer<String>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        Log.e(TAG,"just onSubscribe");
                    }

                    @Override
                    public void onNext(String s) {
                        Log.e(TAG,"just onNext" + s);
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e(TAG,"just onNonErrorext" + e.getMessage());
                    }

                    @Override
                    public void onComplete() {
                        Log.e(TAG,"just onComplete");
                    }
                });
    }


    // 创建型操作符
}
