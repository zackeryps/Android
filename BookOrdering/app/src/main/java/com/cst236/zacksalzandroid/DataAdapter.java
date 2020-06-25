package com.cst236.zacksalzandroid;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.ThemedSpinnerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DataAdapter extends ArrayAdapter<Book> {
    private List<Book> bookList;
    public Map<String, Book> bookMap = new HashMap<>();

    public DataAdapter(Context context, int resource, List<Book> books) {
        super(context, resource, books);

        this.bookList = books;
    }

    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        if(convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.single_book, parent, false);
        }

        Book book = bookList.get(position);
        TextView txtBookName = convertView.findViewById(R.id.txtBookName);
        txtBookName.setText(book.getName());
        TextView txtBookPrice = convertView.findViewById(R.id.txtBookPrice);
        txtBookPrice.setText(Helper.getPriceFormatted(book.getPrice()));
        ImageView imgSingleBook = convertView.findViewById(R.id.imgSingleBook);
        Bitmap bitmap = Helper.getBitmapFromAsset(getContext(), book.getId());
        imgSingleBook.setImageBitmap(bitmap);
        return convertView;
    }
}
