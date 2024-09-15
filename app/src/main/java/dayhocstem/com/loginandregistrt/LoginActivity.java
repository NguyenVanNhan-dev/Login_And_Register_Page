package dayhocstem.com.loginandregistrt;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class LoginActivity extends AppCompatActivity {
    private boolean isPasswordVisible = false;
    private EditText usernameEditText, passwordEditText1;
    private TextView displayUsername, displayPassword;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        TextView btn=findViewById(R.id.signup);
        EditText passwordEditText = findViewById(R.id.new_pass);
        ImageView eyeIcon = findViewById(R.id.eye_icon);
        eyeIcon.setOnClickListener(new View.OnClickListener() {
                                       @Override
                                       public void onClick(View v) {
                                           if (isPasswordVisible) {
                                               // Ẩn mật khẩu
                                               passwordEditText.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
                                               eyeIcon.setImageResource(R.drawable.pikpng_com_cute_anime_eyes_png_850945);
                                               isPasswordVisible = false;
                                           } else {
                                               // Hiện mật khẩu
                                               passwordEditText.setInputType(InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD);
                                               eyeIcon.setImageResource(R.drawable.pikpng_com_close_icon_png_905213);
                                               isPasswordVisible = true;
                                           }

                                           // Đảm bảo con trỏ vẫn ở cuối văn bản sau khi thay đổi chế độ
                                           passwordEditText.setSelection(passwordEditText.getText().length());
                                       }
                                   });
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LoginActivity.this,RegisterActivity.class));
            }
        });
        usernameEditText = findViewById(R.id.new_username);
        passwordEditText1 = findViewById(R.id.new_pass);
        displayUsername = findViewById(R.id.display_username);
        displayPassword = findViewById(R.id.display_password);
        Button loginButton = findViewById(R.id.btnlogin);

        // Xử lý sự kiện khi nhấn nút "Login"
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = usernameEditText.getText().toString();
                String password = passwordEditText1.getText().toString();

                // Hiển thị username và password trên TextView
                displayUsername.setText("Username: " + username);
                displayPassword.setText("Password: " + password);

                // Cho TextView hiển thị
                displayUsername.setVisibility(View.VISIBLE);
                displayPassword.setVisibility(View.VISIBLE);
            }
        });

    }

}
