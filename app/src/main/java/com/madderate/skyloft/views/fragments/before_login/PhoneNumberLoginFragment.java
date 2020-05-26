package com.madderate.skyloft.views.fragments.before_login;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.os.StrictMode;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;
import com.madderate.skyloft.R;
import com.madderate.skyloft.utils.SimplifiedToast;
import com.madderate.skyloft.utils.Util;
import com.madderate.skyloft.views.fragments.BaseFragment;

import org.jetbrains.annotations.NotNull;

import java.util.Objects;

public class PhoneNumberLoginFragment extends BaseFragment implements View.OnClickListener {

    private TextInputLayout phoneNumberInput;
    private TextInputLayout passwordInput;
    private Button loginButton;

    // Toast单例，用来快速切换Toast显示
    private SimplifiedToast toast = null;

    public PhoneNumberLoginFragment(@NotNull Context context, @NotNull Window window) {
        super(context, window);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        StrictMode.setThreadPolicy(
                new StrictMode.ThreadPolicy.Builder().
                        detectDiskReads().
                        detectDiskWrites().
                        detectNetwork().
                        penaltyLog().
                        build()
        );
        StrictMode.setVmPolicy(
                new StrictMode.VmPolicy.Builder().
                        detectLeakedSqlLiteObjects().
                        detectLeakedClosableObjects().
                        penaltyLog().
                        penaltyDeath().
                        build()
        );
    }



    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        assert container != null;

        View view = inflater.inflate(R.layout.fragment_phone_login_in, container, false);

        phoneNumberInput = view.findViewById(R.id.phoneNumberTextField);
        passwordInput = view.findViewById(R.id.passwordTextField);
        loginButton = view.findViewById(R.id.phoneNumberLoginButton);

        // 获取SimplifiedToast单例对象
        toast = SimplifiedToast.getInstance();

        // 设定按钮点击事件
        loginButton.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.phoneNumberLoginButton:
                String phoneNumber = Objects.requireNonNull(phoneNumberInput.getEditText()).getText().toString();
                String password = Objects.requireNonNull(passwordInput.getEditText()).getText().toString();
                // 确保phone number和password不为空字符串（长度为0的字符串）
                // 二者有至少一个为空
                if (phoneNumber.equals("") || password.equals("")) {

                    toast.showToastWhenAtLeastOneStringInTwoIsEmpty(context, phoneNumber, password,
                            new String[]{
                                    getString(R.string.toast_while_empty_phone_number),
                                    getString(R.string.toast_while_empty_password),
                                    getString(R.string.toast_while_both_phone_number_password_empty)
                            },
                            Toast.LENGTH_SHORT
                    );
                }
                // 二者皆不空
                else {
                    if (!Util.isPhoneNumber(phoneNumber)) {
                        toast.showToast(context, R.string.toast_while_phone_number_is_invalid, Toast.LENGTH_SHORT);
                    } else {
                        password = Util.replaceURLSpecialChar(password); // 将特殊字符进行转换
                        toast.showToast(context, "phone number: " + phoneNumber + ", password: " + password, Toast.LENGTH_SHORT);
                        //CommunicationManager communicationManager = new CommunicationManager();
                        //communicationManager.httpGetter(new AccountManager().phoneLoginInter());
                    }
                }
                break;
        }
    }
}
