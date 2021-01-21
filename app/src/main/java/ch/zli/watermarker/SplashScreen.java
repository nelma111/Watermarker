package ch.zli.watermarker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

//activity_splash_screen
public class SplashScreen extends AppCompatActivity {

    Animation logoAnimation;
    ImageView logo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        getSupportActionBar().hide();

        logoAnimation = AnimationUtils.loadAnimation(this, R.anim.logo_splashscreeen);

        logo = findViewById(R.id.splashscreen_logo);

        logo.setAnimation(logoAnimation);

        new Handler().postDelayed(() -> {
            Intent mainIntent = new Intent(SplashScreen.this, MainActivity.class);
            startActivity(mainIntent);
            finish();
        }, 3000);

    }
}