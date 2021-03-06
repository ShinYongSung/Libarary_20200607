package my.shin.libarary_20200607

import android.Manifest
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import android.widget.Toast
import com.bumptech.glide.Glide
import com.gun0912.tedpermission.PermissionListener
import com.gun0912.tedpermission.TedPermission
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

        callBtn.setOnClickListener {

//            전화를 걸기 전에 CALL 권한을 얻었는지 체크.
//            권한을 허가 받은 경우에만 => 실제로 전화

            val permissionListener = object : PermissionListener {
                override fun onPermissionGranted() {
//                    허가가 난 경우 짜잉짜잉
//                    실제로 전화 거는 코드 곤지 ~~~~~~~~~~~~~~~

                    val myUri = Uri.parse("tel:${phoneNumTxt.text}")
                    val myIntent = Intent(Intent.ACTION_CALL, myUri)
                    startActivity(myIntent)

                }

                override fun onPermissionDenied(deniedPermissions: MutableList<String>?) {
                    Toast.makeText(mContext, "권한이 거부되어 통화를 할 수 없습니다.", Toast.LENGTH_SHORT).show()

                }

            }

            TedPermission.with(mContext)
                .setPermissionListener(permissionListener)
                .setDeniedMessage("거절되면 통화할 수 없으니 [설정]에서 권한을 허가해주세요.")
                .setPermissions(Manifest.permission.CALL_PHONE)
                .check()
        }

        profileImg.setOnClickListener {
            val myIntent = Intent(mContext, ViewProfileImageActivity::class.java)
            startActivity(myIntent)
        }

    }
    override fun setValues() {

        Glide.with(mContext).load("http://img.hankyung.com/photo/201910/03.20863999.1.jpg").into(profileImg)
    }

}
