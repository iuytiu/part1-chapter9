package fastcampus.part1.chapter9

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import fastcampus.part1.chapter9.databinding.ActivityMainBinding
import fastcampus.part1.chapter9.navigation.FeedFragment
import fastcampus.part1.chapter9.navigation.HomeFragment
import fastcampus.part1.chapter9.navigation.LibraryFragment
import fastcampus.part1.chapter9.navigation.ProfileFragment
import fastcampus.part1.chapter9.navigation.SearchFragment

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //앱 상단 상태바(status bar) 제거
        enableEdgeToEdge()

        //시작화면 지정
        replaceFragment(HomeFragment())

        //아이콘을 통해 각 Fragment로 화면이동
        binding.bottomNavigation.setOnItemSelectedListener {
            when(it.itemId) {
                R.id.menu_home -> replaceFragment(HomeFragment())
                R.id.menu_feed -> replaceFragment(FeedFragment())
                R.id.menu_library -> replaceFragment(LibraryFragment())
                R.id.menu_search -> replaceFragment(SearchFragment())
                R.id.menu_profile -> replaceFragment(ProfileFragment())
                else -> throw IllegalArgumentException("not found itemId")
            }
            true
        }
    }

    private fun replaceFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction().replace(R.id.fragment, fragment).commit()
    }
}