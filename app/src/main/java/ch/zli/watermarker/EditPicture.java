package ch.zli.watermarker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.os.Bundle;
import android.widget.ImageView;

public class EditPicture extends AppCompatActivity {

    private ImageView mImageView;

    Intent intent = getIntent();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_picture);
        mImageView = findViewById(R.id.MainImage);
        Bitmap imageBitmap = (Bitmap) intent.getParcelableExtra("BitmapImage");
        mImageView.setImageBitmap(imageBitmap);
    }

}