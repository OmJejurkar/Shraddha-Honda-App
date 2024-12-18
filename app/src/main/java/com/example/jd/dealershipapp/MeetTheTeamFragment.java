package com.example.jd.dealershipapp;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.example.jd.dealershipapp.JavaBean.Employee;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link MeetTheTeamFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link MeetTheTeamFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class MeetTheTeamFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    ArrayList<Employee> employees;

    private OnFragmentInteractionListener mListener;

    public MeetTheTeamFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment MeetTheTeamFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static MeetTheTeamFragment newInstance(String param1, String param2) {
        MeetTheTeamFragment fragment = new MeetTheTeamFragment();
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
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_meet_the_team, container, false);

        //creating list
        ArrayList<Employee> personList = new ArrayList<>();
        ArrayList<Integer> imagesOfEmployees = new ArrayList<>();
        imagesOfEmployees.add(R.drawable.pic1);
        imagesOfEmployees.add(R.drawable.pic2);
        imagesOfEmployees.add(R.drawable.pic3);

        String omName = "Om Jejurkar";
        String[] omEmail = {"work.jejurkarom@gmail.com"};

        String shraddhaName = "Shraddha";
        String[] shraddhaEmail = {"jake@wheelerdealer.ca"};

        String sakshiName = "Sakshi";
        String[] sakshiEmail = {"melanie@wheelerdealer.ca"};

        String chanduName = "Chandrashekhar";
        String[] chanduEmail = {"melanie@wheelerdealer.ca"};

        personList.add(new Employee(omName, "Team Leader", R.drawable.pic1, omEmail));
        personList.add(new Employee(shraddhaName, "Mechanic", R.drawable.pic2, shraddhaEmail));
        personList.add(new Employee(sakshiName, "Sales Representative", R.drawable.pic3, sakshiEmail));
        personList.add(new Employee(chanduName, "Sales Representative", R.drawable.pic3, chanduEmail));

        RecyclerView recyclerView = view.findViewById(R.id.recycle_view_employee);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        EmployeeCustomRecycleViewAdapter adapter = new EmployeeCustomRecycleViewAdapter(personList);
        recyclerView.setAdapter(adapter);
        return view;
    }

    // TODO: Rename method, update argument and hook method into UI event
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
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
