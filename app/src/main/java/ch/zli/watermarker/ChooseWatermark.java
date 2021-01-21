package ch.zli.watermarker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;

public class ChooseWatermark extends AppCompatActivity {

    private static final int RESULT_LOAD_IMG = 1;
    Intent storeEverything = getIntent();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_watermark);
    }

    public void getWatermarkFormGallery(View view)
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
        if (requestCode == RESULT_LOAD_IMG && resultCode == RESULT_OK)
        {
            Bundle extras = data.getExtras();
            Bitmap MainBitmap = (Bitmap) storeEverything.getParcelableExtra("MainBitmap");
            Bitmap WatermarkBitmap = (Bitmap) extras.get("data");
            Intent passBitmapToEdit = new Intent(ChooseWatermark.this, EditPicture.class);
            passBitmapToEdit.putExtra("WatermarkBitmap", WatermarkBitmap);
            passBitmapToEdit.putExtra("MainBitmap", MainBitmap);
            startActivity(passBitmapToEdit);
        }
    }
}