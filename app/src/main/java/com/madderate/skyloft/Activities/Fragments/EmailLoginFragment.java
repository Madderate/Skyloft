package com.madderate.skyloft.Activities.Fragments;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.madderate.skyloft.R;
import com.madderate.skyloft.Utils.ActivityUtils;
import com.madderate.skyloft.ViewModels.LoginViewModel;

public class EmailLoginFragment extends Fragment implements View.OnClickListener {

    private Context context;
    private LoginViewModel loginViewModel;

    public void setContext(Context context) {
        this.context = context;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_email_login, container, false);

        try {
            loginViewModel = new ViewModelProvider(getActivity()).get(LoginViewModel.class);

            // Get buttons
            Button toLoginWithPhone = view.findViewById(R.id.to_login_with_phone);
            Button register = view.findViewById(R.id.register);
            // Set onClick listener
            toLoginWithPhone.setOnClickListener(this);
            register.setOnClickListener(this);

            // Get EditTexts
            EditText etEmail = view.findViewById(R.id.et_email);
            EditText etPassword = view.findViewById(R.id.et_password);
            // Restore texts
            etEmail.setText(loginViewModel.getEmail());
            etPassword.setText(loginViewModel.getPassword());
            // Store text while typing
            etEmail.addTextChangedListener(new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence s, int start, int count, int after) {

                }

                @Override
                public void onTextChanged(CharSequence s, int start, int before, int count) {

                }

                @Override
                public void afterTextChanged(Editable s) {
                    loginViewModel.setEmail(s.toString());
                }
            });
            etPassword.addTextChangedListener(new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence s, int start, int count, int after) {

                }

                @Override
                public void onTextChanged(CharSequence s, int start, int before, int count) {

                }

                @Override
                public void afterTextChanged(Editable s) {
                    loginViewModel.setPassword(s.toString());
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }

        return view;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        loginViewModel.setEmail("");
        loginViewModel.setPassword("");
    }

    @Override
    public void onClick(View v) {
        Bundle bundle = new Bundle();
        switch (v.getId()) {
            case R.id.to_login_with_phone:
                bundle.putInt(getString(R.string.replace_to), R.string.phone_login_fragment);
                ActivityUtils.sendReplaceFragmentBroadcast(context, getString(R.string.login_action), bundle);
                break;
            case R.id.register:
                bundle.putInt(getString(R.string.jump_to), R.string.register_activity);
                ActivityUtils.sendReplaceFragmentBroadcast(context, getString(R.string.login_action), bundle);
                break;
        }
    }
}