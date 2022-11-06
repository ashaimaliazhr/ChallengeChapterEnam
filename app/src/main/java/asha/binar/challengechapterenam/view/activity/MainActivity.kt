package asha.binar.challengechapterenam.view.activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import asha.binar.challengechapterenam.R
import com.google.firebase.analytics.FirebaseAnalytics
import com.google.firebase.analytics.ktx.analytics
import com.google.firebase.ktx.Firebase
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var analytics: FirebaseAnalytics

    override fun onCreate(savedInstanceState: Bundle?) {
        analytics = Firebase.analytics
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

}