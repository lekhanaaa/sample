package com.example.gridviewlink;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    GridView grid;
    ArrayList<Integer> img=new ArrayList<Integer>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        grid=findViewById(R.id.gridview);

        img.add(R.drawable.whtsp);
        img.add(R.drawable.fb);
        img.add(R.drawable.insatgram);
        img.add(R.drawable.twit);
        img.add(R.drawable.linkdin);
        img.add(R.drawable.snapchat);

        gridadapter adapter=new gridadapter();
        grid.setAdapter(adapter);

        grid.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                switch (position) {
                    case 0:
                        Intent wp= getPackageManager().getLaunchIntentForPackage("com.whatsapp");
                        startActivity(wp);
                        break;
                    case 1:
                        Intent fb=new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.facebook.com"));
                        startActivity(fb);
                        break;
                    case 2:
                        Intent ig=new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.instagram.com"));
                        startActivity(ig);
                        break;
                    case 3:
                        Intent tw=new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.twitter.com/"));
                        startActivity(tw);
                        break;
                    case 4:
                        Intent li=new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.linkdin.com/"));
                        startActivity(li);
                        break;
                    case 5:
                        Intent sn=new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.snapchat.com/"));
                        startActivity(sn);
                        break;
                }
            }
        });
    }
    class gridadapter extends BaseAdapter{

        @Override
        public int getCount() {
            return img.size();
        }

        @Override
        public Object getItem(int i) {
            return null;
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

        @Override
        public View getView(int i, View convertview, ViewGroup viewGroup) {
            View view1= getLayoutInflater().inflate(R.layout.gridlayout,viewGroup,false);
            ImageView imgs=view1.findViewById(R.id.imgs);

            imgs.setImageResource(img.get(i));
            return view1;
        }
    }
}