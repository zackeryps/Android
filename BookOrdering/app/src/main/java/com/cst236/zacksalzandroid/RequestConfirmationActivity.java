package com.cst236.zacksalzandroid;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class RequestConfirmationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_request_confirmation);

        BookRequestDetails bookRequest =(BookRequestDetails) getIntent().getSerializableExtra("RequestData");

        TextView confirmationMessage = findViewById(R.id.textConfirmInfo);
        StringBuffer stringBuffer = new StringBuffer();

        stringBuffer.append("Thank You! ");
        stringBuffer.append(bookRequest.getRequestingPersonName());
        stringBuffer.append("\nYour book has been reserved for:\n");
        stringBuffer.append(bookRequest.getRequestMadeDate());
        stringBuffer.append("\nBook:\n");
        stringBuffer.append("Title: ");
        stringBuffer.append(bookRequest.getBookTitle());
        stringBuffer.append("\nAuthor: ");
        stringBuffer.append(bookRequest.getAuthor());
        stringBuffer.append("\nISBN: ");
        stringBuffer.append(bookRequest.getIsbn());

        confirmationMessage.setText(stringBuffer);
    }
}
