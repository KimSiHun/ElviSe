package com.project.myprecious.elvis.myprecious.widget;

import android.content.Context;
import android.graphics.PointF;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import com.dlazaro66.qrcodereaderview.QRCodeReaderView;
import com.google.gson.Gson;

import java.io.IOException;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;

/**
 * this view will load information from http using QR code information <br>
 * QR code may include http url and this view will request using that urls <br>
 *
 * @see HttpQRCodeInfoReaderView.OnHttpQRCodeInfoListener
 * @param <T> http response json data.
 */
public abstract class HttpQRCodeInfoReaderView<T> extends RelativeLayout implements QRCodeReaderView.OnQRCodeReadListener {

    private static final String LOG_TAG = HttpQRCodeInfoReaderView.class.getSimpleName();

    private OnHttpQRCodeInfoListener<T> mHttpQRCodeInfoListener;

    private OkHttpClient mHttpClient;
    private Gson mGson = new Gson();

    private QRCodeReaderView mQRCodeView;

    private String mQrString;

    private Type mGenericType = ((ParameterizedType)getClass().getGenericSuperclass()).getActualTypeArguments()[0];

    public interface OnHttpQRCodeInfoListener<T> {
        /**
         * this callback will be invoked when http information is loaded from server <br>
         * @param uri
         * @param info
         */
        void onHttpQRInfoReadCompleted(String uri, T info);
        void onHttpQRInfoReadError(String uri);
    }

    public HttpQRCodeInfoReaderView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public HttpQRCodeInfoReaderView(Context context) {
        this(context, null);
    }

    private void init(Context context) {
        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        // set your desired log level
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);
        mHttpClient = new OkHttpClient.Builder().addInterceptor(logging).build();
    }

    public void setOnHttpQRCodeReadListener(OnHttpQRCodeInfoListener<T> listener) {
        mHttpQRCodeInfoListener = listener;
    }

    public void show() {
        stop();
        if (!isShowing()) {
            mQRCodeView = new QRCodeReaderView(getContext());
            mQRCodeView.setOnQRCodeReadListener(this);
            addView(mQRCodeView, ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        }
    }

    public void pause() {
        if (isShowing()) {
            mQRCodeView.getCameraManager().stopPreview();
        }
    }

    public void stop() {
        if (isShowing()) {
            mQRCodeView.getCameraManager().stopPreview();
            removeView(mQRCodeView);
            mQRCodeView = null;
        }
    }

    @Override
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        stop();
    }

    public boolean isShowing() {
        return mQRCodeView != null;
    }

    private Runnable mHttpRequestRunnable = new Runnable() {
        @Override
        public void run() {

            Request request = new Request.Builder().url(mQrString).addHeader("Content-Type", "application/json").build();
            mHttpClient.newCall(request).enqueue(new Callback() {
                @Override
                public void onFailure(Call call, IOException e) {

                }

                @Override
                public void onResponse(Call call, Response response) throws IOException {
                    String body = response.body().string();
                    Log.d(LOG_TAG, "onResponse. body - " + body);
                    try {
                        final T data = mGson.fromJson(body, mGenericType);
                        post(new Runnable() {
                            @Override
                            public void run() {
                                dispatchInfoRead(mQrString, data);
                            }
                        });
                    } catch (Exception e) {
                        e.printStackTrace();
                        dispatchInfoReadError(mQrString);
                    }

                }
            });
        }
    };

    @Override
    public void onQRCodeRead(final String text, PointF[] points) {
        Log.d(LOG_TAG, "onQRCodeRead. text - " + text);

        pause();

        if (!TextUtils.isEmpty(text) && text.startsWith("http")) {
            mQrString = text;
            removeCallbacks(mHttpRequestRunnable);
            postDelayed(mHttpRequestRunnable, 500);
        }
    }

    protected void dispatchInfoRead(String http, T model) {
        Log.d(LOG_TAG, "dispatchInfoRead. model - " + model);
        if (mHttpQRCodeInfoListener != null) {
            mHttpQRCodeInfoListener.onHttpQRInfoReadCompleted(http, model);
        }
    }

    protected void dispatchInfoReadError(String http) {
        if (mHttpQRCodeInfoListener != null) {
            mHttpQRCodeInfoListener.onHttpQRInfoReadError(http);
        }
    }

    @Override
    public void cameraNotFound() {

    }

    @Override
    public void QRCodeNotFoundOnCamImage() {

    }
}
