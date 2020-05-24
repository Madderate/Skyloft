package com.madderate.skyloft.views.fragments.before_login;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.os.StrictMode;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;
import com.madderate.skyloft.R;
import com.madderate.skyloft.utils.AccountManager;
import com.madderate.skyloft.utils.CommunicationManager;
import com.madderate.skyloft.utils.SimplifiedToast;
import com.madderate.skyloft.views.BeforeLoginActivity;

import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LoginFragment extends Fragment implements View.OnClickListener {

    private TextInputLayout phoneNumberInput;
    private TextInputLayout passwordInput;
    private Button loginButton;

    // Toast对象，用来快速切换Toast显示
    private SimplifiedToast toast = null;

    private Context context;

    public LoginFragment(Context context) {
        this.context = context;
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

        View view = inflater.inflate(R.layout.login_fragment, container, false);

        phoneNumberInput = view.findViewById(R.id.phoneNumberTextField);
        passwordInput = view.findViewById(R.id.passwordTextField);
        loginButton = view.findViewById(R.id.loginButton);

        // 获取SimplifiedToast单例对象
        toast = SimplifiedToast.getInstance();

        // 设定按钮点击事件
        loginButton.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.loginButton:
                String phoneNumber = Objects.requireNonNull(phoneNumberInput.getEditText()).getText().toString();
                String password = Objects.requireNonNull(passwordInput.getEditText()).getText().toString();
                // 确保phone number和password不为空字符串（长度为0的字符串）
                // 二者有至少一个为空
                if (phoneNumber.equals("") || password.equals("")) {

                    showToastWhenAtLeastOneStringInTwoIsEmpty(phoneNumber, password,
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
                    if (!isPhoneNumber(phoneNumber)) {
                        toast.showToast(context, R.string.toast_while_phone_number_is_invalid, Toast.LENGTH_SHORT);
                    } else {
                        //toast.showToast(LoginActivity.this, "phone number: " + phoneNumber + ", password: " + password, Toast.LENGTH_SHORT);
                        //CommunicationManager communicationManager = new CommunicationManager();
                        //communicationManager.httpGetter(new AccountManager().phoneLoginInter());
                    }
                }
                break;
        }
    }

    private void showToastWhenAtLeastOneStringInTwoIsEmpty(String one, String another, String[] toastText, int duration) {
        // 如果one为空而another不为空
        if (one.equals("") && !another.equals("")) {
            toast.showToast(context, toastText[0], duration);
        }
        // 如果another为空而one不为空
        else if (!one.equals("") && another.equals("")) {
            toast.showToast(context, toastText[1], duration);
        }
        // 两者皆空
        else {
            toast.showToast(context, toastText[2], duration);
        }
    }

    private boolean isPhoneNumber(String num) {
        // 简单判断位数是否合适
        if (num.length() != 11)
            return false;

        // 正则表达式
        String regex = "^((13[0-9])|(14[5,7,9])|(15([0-3]|[5-9]))|(166)|(17[0,1,3,5,6,7,8])|(18[0-9])|(19[8|9]))\\d{8}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(num);
        return matcher.matches();
    }
}
