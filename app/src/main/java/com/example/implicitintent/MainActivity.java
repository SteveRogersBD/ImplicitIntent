package com.example.implicitintent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

import com.example.implicitintent.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.dialBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent iDial = new Intent(Intent.ACTION_DIAL);
                iDial.setData(Uri.parse("tel: 6602322649"));
                startActivity(iDial);
            }
        });

        binding.msgBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent iMsg = new Intent(Intent.ACTION_SENDTO);
                // Correct the URI by adding a colon (:) after "smsto"
                iMsg.setData(Uri.parse("smsto:" + Uri.encode("6602322649")));
                iMsg.putExtra("sms_body", "Hi, this is your captain Steve Rogers speaking."); // Use "sms_body" instead of "message"
                startActivity(iMsg);
            }
        });


        binding.emailBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent iEmail = new Intent(Intent.ACTION_SEND);
                iEmail.setType("message/rfc822"); //type of that action
                iEmail.putExtra(Intent.EXTRA_EMAIL, new String[]{"atanubisu105@gmail.com"});
                iEmail.putExtra(Intent.EXTRA_SUBJECT, "Queries");
                iEmail.putExtra(Intent.EXTRA_TEXT, "Please help me with this problem.");
                startActivity(Intent.createChooser(iEmail,"Email via"));
            }
        });
        binding.shareBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent iShare = new Intent(Intent.ACTION_SEND);
                iShare.setType("text/plain");
                iShare.putExtra(Intent.EXTRA_TEXT,"Please help me with this!!!");
                startActivity(Intent.createChooser(iShare,"Share via"));
            }
        });
    }
}