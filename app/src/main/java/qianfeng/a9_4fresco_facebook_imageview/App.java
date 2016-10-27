package qianfeng.a9_4fresco_facebook_imageview;

import android.app.Application;

import com.facebook.drawee.backends.pipeline.Fresco;

/**
 * Created by Administrator on 2016/10/27 0027.
 */
public class App extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        // 记得使用这个fresco要在Application中初始化啊！
        Fresco.initialize(this);
    }
}
