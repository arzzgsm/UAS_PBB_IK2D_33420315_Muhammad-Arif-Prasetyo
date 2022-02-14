package com.example.uaspbbpraktek

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Html
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.AlertDialog
import androidx.core.content.ContextCompat
import androidx.viewpager2.widget.ViewPager2
import com.example.uaspbbpraktek.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter: ImageSliderAdapter
    private val list = ArrayList<ImageData>()
    private lateinit var  dots: ArrayList<TextView>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        list.add(
            ImageData(
                "https://image.shutterstock.com/image-vector/people-selling-stuff-online-vector-600w-1558471598.jpg"
            )
        )
        list.add(
            ImageData(
                "https://img.freepik.com/free-vector/tiny-people-customers-buy-babies-goods-online-from-smartphone-niche-service-marketplace-innovative-online-retail-particular-goods-e-trade-concept-illustration_335657-2528.jpg?w=996"
            )
        )

        adapter = ImageSliderAdapter(list)
        binding.viewPager.adapter = adapter
        dots = ArrayList()
        setIndicator()

        binding.viewPager.registerOnPageChangeCallback(object :  ViewPager2.OnPageChangeCallback(){
            override fun onPageSelected(position:Int) {
                selectedDot(position)
                super.onPageSelected(position)
            }
        })



        val imgFood: ImageView = findViewById(R.id.imgRestaurant)
        imgFood.setOnClickListener(this)

        val imgHome: ImageView = findViewById(R.id.imgHome)
        imgHome.setOnClickListener(this)

        val imgBaby: ImageView = findViewById(R.id.imgBaby)
        imgBaby.setOnClickListener(this)

        val imgHealth: ImageView = findViewById(R.id.imgHealth)
        imgHealth.setOnClickListener(this)

        val actionbar = supportActionBar
        actionbar?.setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM)
        actionbar?.setCustomView(R.layout.abs_layout)
    }

    private fun selectedDot(position: Int) {
        for(i in 0 until list.size){
            if (i == position)
                dots[i].setTextColor(ContextCompat.getColor(this, R.color.design_default_color_primary))
            else
                dots[i].setTextColor(ContextCompat.getColor(this, R.color.design_default_color_secondary))
        }
    }

    private fun setIndicator() {
        for(i in 0 until list.size){
            dots.add(TextView(this))
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N){
                dots[i].text = Html.fromHtml("&#9679", Html.FROM_HTML_MODE_LEGACY).toString()
            } else {
                dots[i].text = Html.fromHtml("&#9679")
            }
            dots[i].textSize = 18f
            binding.dotsIndicator.addView(dots[i])
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.menuexit -> {
                val alertdialog: AlertDialog = AlertDialog.Builder(this).create()
                alertdialog.setTitle("Dialog Exit")
                alertdialog.setMessage("Apakah anda ingin keluar ?")

                alertdialog.setButton(AlertDialog.BUTTON_POSITIVE, "Yes") { dialog, which ->
                    finish()
                    dialog.dismiss()
                }

                alertdialog.setButton(AlertDialog.BUTTON_NEGATIVE, "No") { dialog, which ->
                    dialog.dismiss()
                }
                alertdialog.show()
                return true
            }
            else -> return true
        }
    }

    override fun onClick(view : View){
        when(view.id){
            R.id.imgRestaurant -> {
                val FoodActivity = Intent(this, FoodActivity::class.java)
                startActivity(FoodActivity)
            }
            R.id.imgHome -> {
                val HomeActivity = Intent(this, HomeActivity::class.java)
                startActivity(HomeActivity)
            }
            R.id.imgBaby -> {
                val BabyActivity = Intent(this, BabyActivity::class.java)
                startActivity(BabyActivity)
            }
            R.id.imgHealth-> {
                val HealthActivity = Intent(this, HealthActivity::class.java)
                startActivity(HealthActivity)
            }
        }
    }
}
