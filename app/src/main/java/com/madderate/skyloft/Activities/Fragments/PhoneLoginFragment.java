package com.madderate.skyloft.Activities.Fragments;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.madderate.skyloft.R;
import com.madderate.skyloft.Utils.ActivityUtils;
import com.madderate.skyloft.ViewModels.LoginViewModel;

public class PhoneLoginFragment extends Fragment implements View.OnClickListener {

    private Context context;
    private LoginViewModel loginViewModel;

    private EditText etPhone;
    private EditText etPassword;


    public void setContext(Context context) {
        this.context = context;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_phone_login, container, false);

        try {
            if (getActivity() != null)
                loginViewModel = new ViewModelProvider(getActivity()).get(LoginViewModel.class);

            // Get buttons
            Button toLoginWithEmail = view.findViewById(R.id.to_login_with_email);
            Button register = view.findViewById(R.id.register);
            // Set onClick listener
            toLoginWithEmail.setOnClickListener(this);
            register.setOnClickListener(this);

            // Get EditTexts
            etPhone = view.findViewById(R.id.et_phone);
            etPassword = view.findViewById(R.id.et_password);

            etPhone.addTextChangedListener(new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence s, int start, int count, int after) {

                }

                @Override
                public void onTextChanged(CharSequence s, int start, int before, int count) {

                }

                @Override
                public void afterTextChanged(Editable s) {
                    loginViewModel.setPhoneNumber(s.toString());
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
    public void onDestroyView() {
        super.onDestroyView();
        loginViewModel.setPhoneNumber(null);
        loginViewModel.setPassword(null);
    }

    @Override
    public void onClick(View v) {
        Bundle bundle = new Bundle();
        switch (v.getId()) {
            case R.id.to_login_with_email:
                bundle.putInt(getString(R.string.replace_to), R.string.email_login_fragment);
                ActivityUtils.sendReplaceFragmentBroadcast(context, getString(R.string.login_action), bundle);
                break;
            case R.id.register:
                bundle.putInt(getString(R.string.jump_to), R.string.register_activity);
                ActivityUtils.sendReplaceFragmentBroadcast(context, getString(R.string.login_action), bundle);
                break;
        }
    }
}