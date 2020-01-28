package com.example.scrollact;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.net.URLEncoder;

public class Contactus_CustomAdapter extends RecyclerView.Adapter<Contactus_CustomAdapter.Myviewholder> {

    Context context;

    public Contactus_CustomAdapter(Context context) {
        this.context = context;

    }
    @NonNull
    @Override
    public Contactus_CustomAdapter.Myviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.activity_contactsus, null);
        Myviewholder usersViewHolder = new Myviewholder(view);
        return usersViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull final Contactus_CustomAdapter.Myviewholder holder, int position) {

            holder.phone.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(context, "Phone Clicked", Toast.LENGTH_SHORT).show();
                    Intent intentsms = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:9176868337" /*+ holder.mobile.getText().toString()*/));
                    context.startActivity(intentsms);
                }
            });

            holder.mail.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(context, "Mail Clicked", Toast.LENGTH_SHORT).show();
                    String[] TO = {"ajith@uniqtechnologies.co.in"};
                    String[] CC = {"sanjay@uniqtechnologies.co.in"};
                    Intent emailIntent = new Intent(Intent.ACTION_SEND);
                    emailIntent.setData(Uri.parse("mailto:"));
                    emailIntent.setType("text/plain");
                    emailIntent.putExtra(Intent.EXTRA_EMAIL, TO);
                    emailIntent.putExtra(Intent.EXTRA_CC, CC);
                    emailIntent.putExtra(Intent.EXTRA_SUBJECT, "REG : UNIQ TECHNOLOGIES");
                    emailIntent.putExtra(Intent.EXTRA_TEXT, "Dear Sanjay"+ /*+ holder.sname.getText() +*/ ",");
                    try {
                        context.startActivity(Intent.createChooser(emailIntent, "Send mail..."));

                    } catch (android.content.ActivityNotFoundException ex) {
                        Toast.makeText(context,
                                "There is no email client installed.", Toast.LENGTH_SHORT).show();
                    }
                }
            });

        holder.whatsapp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context, "Whatsapp Clicked", Toast.LENGTH_SHORT).show();
                try {
                    Intent sendMsg = new Intent(Intent.ACTION_VIEW);
                    String url = "https://api.whatsapp.com/send?phone=" + "+91 " + /*holder.mobile.getText().toString() +*/ "&text=" + URLEncoder.encode("Hello this is Uniq technologies", "UTF-8");
                    sendMsg.setPackage("com.whatsapp");
                    sendMsg.setData(Uri.parse(url));
                    if (sendMsg.resolveActivity(context.getPackageManager()) != null) {
                        context.startActivity(sendMsg);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class Myviewholder extends RecyclerView.ViewHolder {
        ImageView phone, mail, whatsapp;
        TextView testing;
        public Myviewholder(@NonNull View itemView) {
            super(itemView);

            testing = (TextView) itemView.findViewById(R.id.testing);
            phone = (ImageView) itemView.findViewById(R.id.phone);
            mail = (ImageView) itemView.findViewById(R.id.mail);
            whatsapp = (ImageView) itemView.findViewById(R.id.whatsapp);
        }
    }
}
