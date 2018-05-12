package com.secpisir.secpisir;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link karaliste_fragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link karaliste_fragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class karaliste_fragment extends Fragment {

    private Button TextButton;
    private Button CloseButton;
    private static  String BUTTON_TEXT = "ButtonText";
    private karaliste_fragment.OnFragmentInteractionListener mListener;
    public karaliste_fragment() {
        // Required empty public constructor
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters
     * @param text button name.
     * @return A new instance of fragment karaliste_fragment.
     */
    // TODO: Rename and change types and number of parameters
    public static karaliste_fragment newInstance(String text) {
        karaliste_fragment fragment = new karaliste_fragment();
        Bundle args = new Bundle();
        args.putString(BUTTON_TEXT, text);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_karalistee, container, false);

        TextButton = view.findViewById(R.id.t_button);
        CloseButton = view.findViewById(R.id.c_button);
        CloseButton.setOnClickListener(new karaliste_fragment.FragmentClickListener(this));
        TextButton.setText(getArguments().getString(BUTTON_TEXT));
        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof karaliste_fragment.OnFragmentInteractionListener) {
            mListener = (karaliste_fragment.OnFragmentInteractionListener) context;
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

    public interface OnFragmentInteractionListener {
        void onFragmentClose(karaliste_fragment fr);
    }

    class FragmentClickListener implements View.OnClickListener {
        karaliste_fragment fr;
        FragmentClickListener(karaliste_fragment fr) {
            this.fr = fr;
        }
        @Override
        public void onClick(View v) {
            if (mListener != null) {
                mListener.onFragmentClose(fr);
            }

        }
    }
}