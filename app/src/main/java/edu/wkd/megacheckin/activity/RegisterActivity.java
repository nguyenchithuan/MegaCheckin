package edu.wkd.megacheckin.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.WindowManager;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import edu.wkd.megacheckin.R;

public class RegisterActivity extends AppCompatActivity {
    private TextView tv_login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
                WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);

        // Khởi tạo UI
        initUI();

        tv_login.setOnClickListener(view -> {
            Intent intent = new Intent(getBaseContext(), LoginActivity.class);
            startActivity(intent);
            finish();
        });
    }

    private void initUI() {
        tv_login = findViewById(R.id.tv_login);
    }
}