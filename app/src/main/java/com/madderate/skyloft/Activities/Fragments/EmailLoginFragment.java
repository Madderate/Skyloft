package com.madderate.skyloft.Activities.Fragments;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.madderate.skyloft.R;
import com.madderate.skyloft.Utils.Util;

public class EmailLoginFragment extends Fragment implements View.OnClickListener {

    private Context context;

    public EmailLoginFragment(Context context) {
        this.context = context;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_email_login, container, false);

        // Get buttons
        Button toLoginWithPhone = view.findViewById(R.id.to_login_with_phone);
        Button register = view.findViewById(R.id.register);
        // Set onClick listener
        toLoginWithPhone.setOnClickListener(this);
        register.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View v) {
        Bundle bundle = new Bundle();
        switch (v.getId()) {
            case R.id.to_login_with_phone:
                bundle.putInt(getString(R.string.replace_to), R.string.phone_login_fragment);
                Util.sendReplaceFragmentBroadcast(context, getString(R.string.login_action), bundle);
                break;
            case R.id.register:
                bundle.putInt(getString(R.string.jump_to), R.string.register_activity);
                Util.sendReplaceFragmentBroadcast(context, getString(R.string.login_action), bundle);
                break;
        }
    }

}