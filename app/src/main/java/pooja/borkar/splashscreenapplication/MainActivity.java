package pooja.borkar.splashscreenapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.widget.ImageView;

import com.bumptech.glide.Glide;


public class MainActivity extends AppCompatActivity {
  ImageView imageView;
  Thread timer;
MediaPlayer mediaPlayer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       imageView=findViewById(R.id.imageId);
        Glide.with(this).load(R.raw.music).into(imageView);
        mediaPlayer= MediaPlayer.create(MainActivity.this,R.raw.backgroundmusic);
        mediaPlayer.start();
        timer=new Thread()
        {
            @Override
            public void run() {
                try {
                    sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();

                }
                finally {
                    mediaPlayer.stop();

                    Intent intent_my = new Intent(getApplicationContext(),WelcomeActivity.class);
                    startActivity(intent_my);

                }
            }
        };

timer.start();


    }
}
