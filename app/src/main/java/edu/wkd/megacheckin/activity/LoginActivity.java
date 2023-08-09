package edu.wkd.megacheckin.activity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import edu.wkd.megacheckin.R;
import edu.wkd.megacheckin.api.ApiService;
import edu.wkd.megacheckin.models.postdata.DataLogin;
import edu.wkd.megacheckin.models.response.ResponseLogin;
import edu.wkd.megacheckin.util.Utit;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class LoginActivity extends AppCompatActivity {
    public static final String TAG = "zzzzzzzzzzzz";
    private TextView tv_register;
    private Button btn_login;
    private EditText ed_email;
    private EditText ed_password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);

        initUI();

        btn_login.setOnClickListener(v -> {
            loginApp();
        });

        tv_register.setOnClickListener(view -> {
            Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
            startActivity(intent);
            finish();
        });
    }

    private void loginApp() {
        String strEmail = ed_email.getText().toString().trim();
        String strPassword = ed_password.getText().toString().trim();
        DataLogin dataLogin = new DataLogin(strEmail, strPassword);

        ApiService.apiService.login(dataLogin).enqueue(new Callback<ResponseLogin>() {
            @Override
            public void onResponse(Call<ResponseLogin> call, Response<ResponseLogin> response) {
                ResponseLogin responseLogin = response.body();
                Utit.TOKEN = responseLogin.getToken(); // Set data vào token để ở đâu cx có thể sử dụng
                Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }

            @Override
            public void onFailure(Call<ResponseLogin> call, Throwable t) {
                Log.d(TAG, "Login: " + t.toString());
            }
        });
    }

    private void initUI() {
        tv_register = findViewById(R.id.tv_register);
        btn_login = findViewById(R.id.btn_login);
        ed_email = findViewById(R.id.ed_email);
        ed_password = findViewById(R.id.ed_password);
    }
}