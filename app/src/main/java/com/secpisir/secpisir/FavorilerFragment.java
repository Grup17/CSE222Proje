package com.secpisir.secpisir;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.support.v4.app.Fragment;


public class FavorilerFragment extends Fragment {
    private Button TextButton;
    private Button CloseButton;

    private static  String BUTTON_TEXT = "ButtonText";
    private OnFragmentInteractionListener mListener;

    public FavorilerFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters
     * @param text button name.
     * @return A new instance of fragment FavorilerFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static FavorilerFragment newInstance(String text) {
        FavorilerFragment fragment = new FavorilerFragment();
        Bundle args = new Bundle();
        args.putString(BUTTON_TEXT, text);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
    //*******Karaliste için değişecek kısım
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.favoriler_fragment, container, false);

        TextButton = view.findViewById(R.id.text_button);
        CloseButton = view.findViewById(R.id.close_button);
        CloseButton.setOnClickListener(new FragmentClickListener(this));
        TextButton.setText(getArguments().getString(BUTTON_TEXT));
        return view;
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
        void onFragmentClose(FavorilerFragment fr);
    }

    class FragmentClickListener implements View.OnClickListener {
        FavorilerFragment fr;
        FragmentClickListener(FavorilerFragment fr) {
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