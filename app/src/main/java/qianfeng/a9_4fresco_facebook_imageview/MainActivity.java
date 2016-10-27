package qianfeng.a9_4fresco_facebook_imageview;

import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.controller.AbstractDraweeController;
import com.facebook.drawee.generic.RoundingParams;
import com.facebook.drawee.view.SimpleDraweeView;

import java.io.File;

/*
    自己可上网搜一下fresco，然后找到它的官方文档，有中文版的，在那里读懂即可。
 */
public class MainActivity extends AppCompatActivity {

    private SimpleDraweeView sdv1;
    private String imageUrl = "http://h.hiphotos.baidu.com/baike/c0%3Dbaike72%2C5%2C5%2C72%2C24/sign=c7d9d471750e0cf3b4fa46a96b2f997a/9d82d158ccbf6c81d781558bbb3eb13533fa401a.jpg";
    private SimpleDraweeView sdv2;
    private SimpleDraweeView sdv3;
    private SimpleDraweeView sdv4;
    private SimpleDraweeView sdv5;
    private Uri uri3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sdv1 = ((SimpleDraweeView) findViewById(R.id.sdv1));
        sdv2 = ((SimpleDraweeView) findViewById(R.id.sdv2));
        sdv3 = ((SimpleDraweeView) findViewById(R.id.sdv3));
        sdv4 = ((SimpleDraweeView) findViewById(R.id.sdv4));
        sdv5 = ((SimpleDraweeView) findViewById(R.id.sdv5));

        Uri uri = Uri.parse(imageUrl);
        sdv1.setImageURI(uri);

        sdv2.setImageURI(Uri.parse("res:///" + R.mipmap.ic_launcher));

        uri3 = Uri.fromFile(new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS), "a8.jpg"));
        sdv3.setImageURI(uri3);

        // java代码创建圆角矩形
        RoundingParams roundingParams = RoundingParams.fromCornersRadius(20);
        sdv4.getHierarchy().setRoundingParams(roundingParams);
        sdv4.setImageURI(uri3);

        //用fresco加载gif图片，如果是ImageView的话，是无法加载gif图片的，会直接显示一团黑
        Uri uri5 = Uri.parse("res:///" + R.drawable.p3);

        AbstractDraweeController controller = Fresco.newDraweeControllerBuilder()
                .setUri(uri5)
                .setAutoPlayAnimations(true) // 设置gif图片是否为自动播放，true是自动播放
                .build();
        sdv5.setController(controller); // 注意播放动画用的是：setController()


    }
}
