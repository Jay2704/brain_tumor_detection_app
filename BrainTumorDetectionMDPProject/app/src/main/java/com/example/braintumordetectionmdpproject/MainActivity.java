package com.example.braintumordetectionmdpproject;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
//import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.braintumordetectionmdpproject.ml.Model;

import org.tensorflow.lite.DataType;
import org.tensorflow.lite.support.image.TensorImage;
import org.tensorflow.lite.support.tensorbuffer.TensorBuffer;

import java.io.IOException;
import java.nio.ByteBuffer;

public class MainActivity extends AppCompatActivity {
    private ImageView imgview;
    public Button select, predict;
    private TextView tv;
    private Bitmap img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imgview=findViewById(R.id.imageView);
        select=findViewById(R.id.button);
        predict=findViewById(R.id.button2);
        tv=findViewById(R.id.textView);

        select.setOnClickListener(v -> {
            Intent intent=new Intent(Intent.ACTION_GET_CONTENT);
            intent.setType("image/*");
            startActivityForResult(intent,100);
        });

        predict.setOnClickListener(v -> {
            img=Bitmap.createScaledBitmap(img,240,240,true);
            try {
                Model model = Model.newInstance(getApplicationContext());

                // Creates inputs for reference.
                TensorBuffer inputFeature0 = TensorBuffer.createFixedSize(new int[]{1, 240, 240, 3}, DataType.FLOAT32);
                TensorImage tensorImage=new TensorImage(DataType.FLOAT32);
                tensorImage.load(img);
                ByteBuffer byteBuffer=tensorImage.getBuffer();
                inputFeature0.loadBuffer(byteBuffer);

                // Runs model inference and gets result.
                Model.Outputs outputs = model.process(inputFeature0);
                TensorBuffer outputFeature0 = outputs.getOutputFeature0AsTensorBuffer();
                if(outputFeature0.getFloatArray()[0]<0.5)
                    tv.setText("No tumors detected"+"\n");
                else
                    tv.setText("Tumors is/are detected"+"\n");

                // Releases model resources if no longer used.
                model.close();

            } catch (IOException e) {
                // TODO Handle the exception
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==100)
        {
            assert data != null;
            imgview.setImageURI(data.getData());
            Uri uri=data.getData();
            try {
                img= MediaStore.Images.Media.getBitmap(this.getContentResolver(),uri);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}