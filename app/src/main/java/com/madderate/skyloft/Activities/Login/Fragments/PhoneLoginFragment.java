package com.madderate.skyloft.Activities.Login.Fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
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
import com.madderate.skyloft.ViewModels.Login.LoginViewModel;

public class PhoneLoginFragment extends Fragment implements View.OnClickListener {

    private LoginViewModel loginViewModel;

    private Button phoneLoginButton;
    private Button toLoginWithEmail;
    private Button register;

    private EditText etPhone;
    private EditText etPassword;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.login_login_activity_phone_fragment, container, false);

        try {
            if (getActivity() != null)
                loginViewModel = new ViewModelProvider(getActivity()).get(LoginViewModel.class);

            // Get buttons
            phoneLoginButton = view.findViewById(R.id.phone_login_button);
            toLoginWithEmail = view.findViewById(R.id.to_login_with_email);
            register = view.findViewById(R.id.register);
            // Set onClick listener
            phoneLoginButton.setOnClickListener(this);
            toLoginWithEmail.setOnClickListener(this);
            register.setOnClickListener(this);

            // Get EditTexts
            etPhone = view.findViewById(R.id.et_phone);
            etPassword = view.findViewById(R.id.et_password);

            // 监听文本输入框的变化
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

            etPhone.setText("15070922393");
            etPassword.setText("bushengtao16b");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return view;
    }

    // 页面被Destroy时，说明页面经过切换
    // 如果只是暂时退到后台，用户及时打开，数据不会丢失
    // 但若是切换Fragment，则需要清空ViewModel中对应的一些数据
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
            // 切换到邮箱登录
            case R.id.to_login_with_email:
                bundle.putInt(getString(R.string.replace_fragment), R.string.login_fragment_email);
                ActivityUtils.sendReplaceFragmentBroadcast(getActivity(), getString(R.string.login_activity_action), bundle);
                break;
            // 切换到注册
            case R.id.register:
                bundle.putInt(getString(R.string.replace_activity), R.string.login_activity_register);
                ActivityUtils.sendReplaceFragmentBroadcast(getActivity(), getString(R.string.login_activity_action), bundle);
                break;
            // 登录
            case R.id.phone_login_button:
                loginViewModel.phoneLogin(getActivity());
                break;
        }
    }
}