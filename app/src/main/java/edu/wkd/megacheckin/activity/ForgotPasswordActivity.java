package edu.wkd.megacheckin.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import edu.wkd.megacheckin.R;
import edu.wkd.megacheckin.api.ApiService;
import edu.wkd.megacheckin.models.postdata.DataForgotPass;
import edu.wkd.megacheckin.models.response.ResponseForgotPass;
import edu.wkd.megacheckin.util.CustomProgressDialog;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ForgotPasswordActivity extends AppCompatActivity {
    private EditText ed_email;
    private Button btn_send;
    private CustomProgressDialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
                WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);

        init();

        btn_send.setOnClickListener(view -> {
            forgotPasswordApp();
        });
    }

    private void forgotPasswordApp() {
        String strEmail = ed_email.getText().toString().trim();
        DataForgotPass dataForgotPass = new DataForgotPass(strEmail);
        dialog.show();

        ApiService.apiService.forgetPassword(dataForgotPass).enqueue(new Callback<ResponseForgotPass>() {
            @Override
            public void onResponse(Call<ResponseForgotPass> call, Response<ResponseForgotPass> response) {
                ResponseForgotPass responseForgotPass = response.body();
                dialog.cancel();
                Log.d("zzzzzzzzz", "onResponse: " + responseForgotPass.getKetqua());
                Toast.makeText(ForgotPasswordActivity.this, responseForgotPass.getKetqua(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<ResponseForgotPass> call, Throwable t) {
                Toast.makeText(ForgotPasswordActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();
                Log.d("zzzzzzzzz", "ForgotPassword: " + t.toString());
                dialog.cancel();
            }
        });
    }

    private void init() {
        ed_email = findViewById(R.id.ed_email);
        btn_send = findViewById(R.id.btn_send);

        dialog = new CustomProgressDialog(ForgotPasswordActivity.this, 1);
    }
}