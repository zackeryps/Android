package com.cst236.zacksalzandroid;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.net.Uri;
import android.support.design.widget.CollapsingToolbarLayout;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.text.InputType;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;

import com.cst236.zacksalzandroid.dummy.DummyContent;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * A fragment representing a single Item detail screen.
 * This fragment is either contained in a {@link ItemListActivity}
 * in two-pane mode (on tablets) or a {@link ItemDetailActivity}
 * on handsets.
 */
public class ItemDetailFragment extends Fragment {

    private Calendar calendar = Calendar.getInstance();
    private DateFormat dateFormat = DateFormat.getDateInstance();
    /**
     * The fragment argument representing the item ID that this fragment
     * represents.
     */
    public static final String ARG_ITEM_ID = "item_id";

    /**
     * The dummy content this fragment is presenting.
     */
    private DummyContent.DummyItem mItem;

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public ItemDetailFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments().containsKey(ARG_ITEM_ID)) {
            // Load the dummy content specified by the fragment
            // arguments. In a real-world scenario, use a Loader
            // to load content from a content provider.
            mItem = DummyContent.ITEM_MAP.get(getArguments().getString(ARG_ITEM_ID));

            Activity activity = this.getActivity();
            CollapsingToolbarLayout appBarLayout = (CollapsingToolbarLayout) activity.findViewById(R.id.toolbar_layout);
            if (appBarLayout != null) {
                appBarLayout.setTitle(mItem.content);
            }
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.item_detail, container, false);

        // Show the dummy content as text in a TextView.
        if (mItem != null) {
            ((TextView) rootView.findViewById(R.id.item_detail)).setText(mItem.details);
        }

        if(mItem.id.equals("1")) {
            //request book
            rootView = inflater.inflate(R.layout.activity_request_form, container, false);
            final View rootViewReservation = rootView;
            final EditText name = rootViewReservation.findViewById(R.id.editName);
            final EditText date = rootViewReservation.findViewById(R.id.editDate);
            final EditText isbn = rootViewReservation.findViewById(R.id.editIsbn);
            final EditText title = rootViewReservation.findViewById(R.id.editTitle);
            final EditText author = rootViewReservation.findViewById(R.id.editAuthor);
            final Button button = rootViewReservation.findViewById(R.id.btnSubmit);
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    final BookRequestDetails requestData = new BookRequestDetails(
                            name.getText().toString(),
                            date.getText().toString(),
                            isbn.getText().toString(),
                            title.getText().toString(),
                            author.getText().toString()
                    );

                    Intent intent = new Intent(rootViewReservation.getContext(), RequestConfirmationActivity.class);
                    intent.putExtra("RequestData", requestData);
                    startActivity(intent);
                }
            });

            date.setInputType(InputType.TYPE_NULL);
            date.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    showDateDialog(date);
                }
            });

            date.setOnFocusChangeListener(new View.OnFocusChangeListener() {
                @Override
                public void onFocusChange(View v, boolean hasFocus) {
                    if(hasFocus)
                        showDateDialog(date);
                }
            });
        }
        if(mItem.id.equals("2")) {
            //book list
            FragmentTransaction transaction = getFragmentManager().beginTransaction();
            transaction.replace(R.id.item_detail_container, new BookList());
            transaction.addToBackStack(null);
            transaction.commit();
        }
        if(mItem.id.equals("3")) {
            startActivity(new Intent(getContext(), MapsActivity.class));
        }
        if(mItem.id.equals("4")) {
            double lat = 45.5206712506;
            double lng = -122.675615631;
            String uriString = "geo:" + lat + "," + lng + "?q=" + lat + "," + lng + "(Powell's Books)";
            Uri uriForMap = Uri.parse(uriString);
            Intent mapIntent = new Intent(Intent.ACTION_VIEW, uriForMap);
            mapIntent.setPackage("com.google.android.apps.maps");
            if(mapIntent.resolveActivity(getActivity().getPackageManager()) != null) {
                startActivity(mapIntent);
            }
        }
        return rootView;
    }

    private void showDateDialog(final EditText date)
    {
        DatePickerDialog.OnDateSetListener datePicker = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                calendar.set(Calendar.YEAR, year);
                calendar.set(Calendar.MONTH, month);
                calendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);

                date.setText(dateFormat.format(calendar.getTime()));
            }
        };

        new DatePickerDialog(
                getContext(),
                datePicker,
                calendar.get(Calendar.YEAR),
                calendar.get(Calendar.MONTH),
                calendar.get(Calendar.DAY_OF_MONTH)
                ).show();
    }
}
