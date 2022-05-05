package  com.example.practice
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class SplashActivity: AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash);
        supportActionBar?.hide()
        val hander = Handler(Looper.getMainLooper());
        hander.postDelayed({
            this.skipSplash();
        },10000);
        val skipBtn = findViewById<Button>(R.id.skipSplashBtn);
        skipBtn.setOnClickListener ( View.OnClickListener {
            this.skipSplash();
        })



    }

    private fun skipSplash(){
        val intent: Intent = Intent(this,MainActivity::class.java);
        startActivity(intent);
        finish();
    }

}