package com.example.mobileprogramming;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

//public class ListFragment extends Fragment {
//    MainActivity activity;
//
//    @Override
//    public void onAttach(@NonNull Context context) {
//        super.onAttach(context);
//        activity = (MainActivity) getActivity();
//    }
//
//    @Override
//    public void onDetach() {
//        super.onDetach();
//        activity = null;
//    }
//
//    @Nullable
//    @Override
//    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
//        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment_list, container, false);
//        Button button = (Button) rootView.findViewById(R.id.button);
//        Button button2 = (Button) rootView.findViewById(R.id.button2);
//        Button button3 = (Button) rootView.findViewById(R.id.button3);
//        button.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                activity.onImageChange(0);
//            }
//        });
//
//        button2.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                activity.onImageChange(1);
//
//            }
//        });
//
//        button3.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                activity.onImageChange(2);
//            }
//        });
//        return rootView;
//    }
//}
