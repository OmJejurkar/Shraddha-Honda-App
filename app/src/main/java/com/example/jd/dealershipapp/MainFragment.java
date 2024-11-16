package com.example.jd.dealershipapp;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Toast;
import android.util.Log;

public class MainFragment extends Fragment {
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;

    LinearLayout websiteLayout;
    LinearLayout locationLayout;
    LinearLayout facebookLayout;
    LinearLayout twitterLayout;
    LinearLayout callLayout;

    private OnFragmentInteractionListener mListener;

    public MainFragment() {
        // Required empty public constructor
    }

    public static MainFragment newInstance(String param1, String param2) {
        MainFragment fragment = new MainFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main, container, false);

        // Create 4 buttons for each intent
        websiteLayout = view.findViewById(R.id.websiteLayout);
        locationLayout = view.findViewById(R.id.locationLayout);
        facebookLayout = view.findViewById(R.id.facebookLayout);
        twitterLayout = view.findViewById(R.id.twitterLayout);
        callLayout = view.findViewById(R.id.callLayout);

        // Simplified intents for testing
        websiteLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //openURL("https://www.google.com", "No application available to handle website intent");
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("https://taupe-mermaid-4cafcd.netlify.app/"));
                startActivity(intent);
            }
        });

        locationLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Uri geoLocation = Uri.parse("geo:0,0?q=42.246598,-83.019553");
                //openURL(geoLocation.toString(), "No application available to handle location intent");
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("https://maps.app.goo.gl/nqQsKiAQzJFMPk2w9"));
                startActivity(intent);
            }
        });

        facebookLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openURL("https://www.facebook.com", "No application available to handle Facebook intent");
            }
        });

        twitterLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openURL("https://www.twitter.com", "No application available to handle Twitter intent");
            }
        });

        callLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:9067725111"));
                startActivityWithFallback(intent, "No application available to handle call intent");
            }
        });

        return view;
    }

    private void openURL(String url, String errorMessage) {
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
        startActivityWithFallback(intent, errorMessage);
    }

    private void startActivityWithFallback(Intent intent, String errorMessage) {
        if (intent.resolveActivity(getActivity().getPackageManager()) != null) {
            startActivity(intent);
        } else {
            Toast.makeText(getContext(), errorMessage, Toast.LENGTH_SHORT).show();
            Log.e("MainFragment", errorMessage);
        }
    }

    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString() + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    public interface OnFragmentInteractionListener {
        void onFragmentInteraction(Uri uri);
    }
}
