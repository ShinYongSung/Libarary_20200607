package my.shin.libarary_20200607

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.math.log

class MainActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(R.layout.activity_main)

        setupEvents()
        setValues()

    }


    override fun setupEvents() {

        profileImg.setOnClickListener {
            val myIntent = intent(mContext, ViewProfileImageActivity::class.java)
            startActivity(myIntent)

        }

    }

    override fun setValues() {

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}
