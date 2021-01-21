package ch.zli.watermarker;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    private static final int RESULT_LOAD_IMG = 1;
    private ImageView mImageView;
    private static final int REQUEST_IMAGE_CAPTURE = 101;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mImageView = findViewById(R.id.MainImage);
    }

    public void takePicture(View view)
    {
        Intent takeImageIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if(takeImageIntent.resolveActivity(getPackageManager())!=null)
        {
          startActivityForResult(takeImageIntent, REQUEST_IMAGE_CAPTURE);
        }
    }

    public void getPictureFormGallery(View view)
    {
        Intent getPhotoIntent = new Intent(Intent.ACTION_PICK);
        getPhotoIntent.setType("image/*");
        if(getPhotoIntent.resolveActivity(getPackageManager())!=null)
        {
            startActivityForResult(getPhotoIntent, RESULT_LOAD_IMG);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data)
    {
        super.onActivityResult(requestCode, resultCode, data);
        if ((requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK) || (requestCode == RESULT_LOAD_IMG && resultCode == RESULT_OK))
        {
            Bundle extras = data.getExtras();
            Bitmap imageBitmap = (Bitmap) extras.get("data");
            mImageView.setImageBitmap(imageBitmap);
            Intent passBitmap = new Intent(MainActivity.this, ChooseWatermark.class);
            passBitmap.putExtra("MainBitmap", imageBitmap);

            startActivity(passBitmap);
        }
    }
}