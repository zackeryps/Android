package com.cst236.zacksalzandroid;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class BookList extends Fragment {

    private List<Book> books = DataProvider.books;
    public static final String BOOK_ID = "BOOK_ID";

    public BookList() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_book_list, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        DataAdapter adapter = new DataAdapter(getContext(), R.layout.single_book, books);
        ListView listView = view.findViewById(R.id.bookListView);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(
                new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        Book book = books.get(position);

                        getActivity().getIntent().putExtra(BOOK_ID, book.getId());
                        FragmentTransaction transaction = getFragmentManager().beginTransaction();
                        transaction.replace(R.id.item_detail_container, new BookDetail());
                        transaction.addToBackStack(null);
                        transaction.commit();
                    }
                }
        );
    }
}
