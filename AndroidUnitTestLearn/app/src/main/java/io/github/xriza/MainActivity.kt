package io.github.xriza

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        send.setOnClickListener {

            val loginId = loginId.text.toString()
            val pwd = password.text.toString()

            val isLoginIdOK = RegisterVerity().isLoginIdVerify(loginId)

            val isPwdOK = RegisterVerity().isPasswordVerify(pwd)

            val builder = AlertDialog.Builder(this)

            if (!isLoginIdOK) {
                builder.setMessage("帳號至少要6碼，第1碼為英文")
                    .setTitle("錯誤")

                builder.show()
            }
            else if (!isPwdOK) {
                builder.setMessage("密碼至少要8碼，第1碼為英文，並包含1碼數字")
                    .setTitle("錯誤")

                builder.show()
            } else {
                val sharedPreferenceManager = SharedPreferenceManager(this)
                Repository(sharedPreferenceManager).saveUserId(loginId)

                val intent = Intent(this, ResultActivity::class.java)
                intent.putExtra("ID", loginId)

                startActivity(intent)
            }
        }
    }
}