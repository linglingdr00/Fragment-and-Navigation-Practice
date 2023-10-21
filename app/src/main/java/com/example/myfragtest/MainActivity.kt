package com.example.myfragtest

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupActionBarWithNavController
import com.example.myfragtest.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    // 建立 navController
    private lateinit var navController : NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        /* 小筆記：LayoutInflater 的意思
           Inflater 是指打氣機的意思，比如把氣球充滿氣，所以 LayoutInflater 就是把 layout 充氣充滿的機制，
           可以想像成製作出一個 layout 的意思。 */

        // 將xml(activity_main.xml)實例化為相應的 view 物件，並使用 binding 存取 view 物件
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        /* 小筆記：NavHost 的意思
           NavHost是用來顯示在 activity 內來自 Navigation Graph 的目的地。
           您需要在 MainActivity 中使用內建的實作，名為 NavHostFragment */
        val navHostFragment = supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment

        /* 小筆記：NavController 的意思
           NavController 物件(object)可讓您控制 NavHost 中顯示的目的地之間的導覽(navigation)動作
           您可以使用 navigation component 呼叫 NavController 的 navigate() 方法，調換所顯示的 fragment */
        navController = navHostFragment.navController

        // 呼叫 setupActionBarWithNavController() 並傳入 navController，確保畫面上會顯示 action bar button
        setupActionBarWithNavController(navController)

    }

    /* 導入 onSupportNavigateUp()
       除了在 XML 中將 defaultNavHost 設定為 true 之外，此方法也可用來處理 up(回上一頁) button */
    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp() || super.onSupportNavigateUp()
    }
}