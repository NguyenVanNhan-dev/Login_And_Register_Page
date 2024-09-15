package dayhocstem.com.loginandregistrt;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class RegisterActivity extends AppCompatActivity {

    private EditText userEditText, emailEditText, passwordEditText, confirmPassEditText;
    private Button btnRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        userEditText = findViewById(R.id.user);
        emailEditText = findViewById(R.id.email);
        passwordEditText = findViewById(R.id.password);
        confirmPassEditText = findViewById(R.id.confirmpass);
        btnRegister = findViewById(R.id.btnRegister);

        btnRegister.setOnClickListener(v -> {
            String username = userEditText.getText().toString();
            String email = emailEditText.getText().toString();
            String password = passwordEditText.getText().toString();
            String confirmPassword = confirmPassEditText.getText().toString();

            if (password.equals(confirmPassword)) {
                // Chuyển dữ liệu đến ShowLoginActivity
                Intent intent = new Intent(RegisterActivity.this, ShowLoginActivity.class);
                intent.putExtra("USERNAME", username);
                intent.putExtra("EMAIL", email);
                intent.putExtra("PASSWORD", password);
                startActivity(intent);
            } else {
                // Hiển thị lỗi nếu mật khẩu không khớp
                confirmPassEditText.setError("Passwords do not match!");
            }
        });

        TextView btnAlreadyAccount = findViewById(R.id.alreadyaccount);
        btnAlreadyAccount.setOnClickListener(v -> {
            startActivity(new Intent(RegisterActivity.this, LoginActivity.class));
        });
    }
}
