package edu.temple.inclassactivity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Fetch images into IntArray called imageArray
        val typedArray = resources.obtainTypedArray(R.array.image_ids)
        val imageArray = IntArray(typedArray.length()) { typedArray.getResourceId(it, 0) }
        typedArray.recycle()

        if (savedInstanceState == null) {
            val fragment = ImageDisplayFragment.newInstance(imageArray)
            supportFragmentManager.beginTransaction()
                .replace(R.id.image_fragment_container, fragment)
                .commit()
        }
    }
}
