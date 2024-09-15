package dayhocstem.com.loginandregistrt;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ShowLoginActivity extends AppCompatActivity {

    private TextView showUsername, showEmail, showPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_show);

        showUsername = findViewById(R.id.display_username);
        showEmail = findViewById(R.id.display_email);
        showPassword = findViewById(R.id.display_password);

        // Nhận dữ liệu từ Intent
        Intent intent = getIntent();
        String username = intent.getStringExtra("USERNAME");
        String email = intent.getStringExtra("EMAIL");
        String password = intent.getStringExtra("PASSWORD");

        // Hiển thị dữ liệu
        showUsername.setText("Username: " + username);
        showEmail.setText("Email: " + email);
        showPassword.setText("Password: " + password);
    }
}
