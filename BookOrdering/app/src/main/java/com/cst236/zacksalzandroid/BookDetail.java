package com.cst236.zacksalzandroid;


import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class BookDetail extends Fragment {


    public BookDetail() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_book_detail, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        String bookId = getActivity().getIntent().getStringExtra(BookList.BOOK_ID);
        Book book = DataProvider.bookMap.get(bookId);
        TextView bookName = view.findViewById(R.id.txtBookName);
        bookName.setText(book.getId());
        TextView bookPrice = view.findViewById(R.id.txtBookPrice);
        bookPrice.setText(Helper.getPriceFormatted(book.getPrice()));
        TextView bookDescription = view.findViewById(R.id.txtBookDescription);
        bookDescription.setText(book.getDescription());
        ImageView imageView = view.findViewById(R.id.imgBookDetail);
        Bitmap bitmap = Helper.getBitmapFromAsset(getContext(), book.getId());
        imageView.setImageBitmap(bitmap);
    }
}
