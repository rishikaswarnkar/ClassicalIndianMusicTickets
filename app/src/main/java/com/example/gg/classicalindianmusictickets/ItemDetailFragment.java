package com.example.gg.classicalindianmusictickets;
import android.app.Activity;
import android.app.DatePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.support.design.widget.CollapsingToolbarLayout;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;

import com.example.gg.classicalindianmusictickets.dummy.DummyContent;
import java.text.DateFormat;
import java.util.Calendar;

/**
 * A fragment representing a single Item detail screen.
 * This fragment is either contained in a {@link ItemListActivity}
 * in two-pane mode (on tablets) or a {@link ItemDetailActivity}
 * on handsets.
 */
public class ItemDetailFragment extends Fragment {
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
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        if (getArguments().containsKey(ARG_ITEM_ID)) {
            // Load the dummy content specified by the fragment
            // arguments. In a real-world scenario, use a Loader
            // to load content from a content provider.
            mItem = DummyContent.ITEM_MAP.get(getArguments().getString(ARG_ITEM_ID));
            Activity activity = this.getActivity();
            CollapsingToolbarLayout appBarLayout = (CollapsingToolbarLayout) activity.findViewById(R.id.toolbar_layout);
            if (appBarLayout != null)
            {
                appBarLayout.setTitle(mItem.content);
            }
        }
    }
    Context context;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.item_detail, container, false);

        // Show the dummy content as text in a TextView.
        if (mItem.id.equals("1")) {
            rootView = inflater.inflate(R.layout.about, container, false);
        }
        if (mItem.id.equals("2")) {
            rootView = inflater.inflate(R.layout.music, container, false);
            context = getContext(); // Assign your rootView to context
            Button btSample= (Button) rootView.findViewById(R.id.btnSample);
            btSample.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v)
                {
                    //Pass the context and the Activity class you need to open from the Fragment Class, to the Intent
                    Intent intent = new Intent(context, music.class);
                    context.startActivity(intent);
                    // startActivity(new Intent(context, reserve.class));
                }
            });
        }
        if (mItem.id.equals("3")) {
                rootView = inflater.inflate(R.layout.reserve, container, false);
                //((WebView)rootView.findViewById(R.id.item_detail)).loadUrl(mItem.item_url);
                context = getContext(); // Assign your rootView to context
                Button btDate = (Button) rootView.findViewById(R.id.btnDate);
               btDate.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v)
                    {
                        //Pass the context and the Activity class you need to open from the Fragment Class, to the Intent
                        Intent intent = new Intent(context, Reservation.class);
                        context.startActivity(intent);
                       // startActivity(new Intent(context, reserve.class));
                    }
                });
            }
            return rootView;
        }
    }