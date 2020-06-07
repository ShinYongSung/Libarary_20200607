package my.shin.libarary_20200607

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.math.log

class MainActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupEvents()
        setValues()
    }

    override fun setupEvents() {

        profileImg.setOnClickListener {
            val myIntent = Intent(mContext, ViewProfileImageActivity::class.java)
            startActivity(myIntent)
        }

    }
    override fun setValues() {

        Glide.with(mContext).load("http://img.hankyung.com/photo/201910/03.20863999.1.jpg").into(profileImg)
    }

}
