package com.example.lab3

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import com.example.lab3.figures.*
import java.io.File


class MainActivity : AppCompatActivity() {
    private lateinit var shape: CanvasShape
    lateinit var mainMenu: Menu
    companion object {
        var currentFigure: Shape = Point(0f, 0f, 0f, 0f)
        var figures = ArrayList<Shape>()
        var tableFile = File("/data/user/0/com.example.lab3", "Shapes Table.txt")
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        shape = CanvasShape(this, Color.BLACK, Color.BLACK)
        setContentView(shape)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        if (menu != null) {
            mainMenu = menu
        }

        menuInflater.inflate(R.menu.main, menu)
        return true
    }

    fun setIconOff() {
        mainMenu.getItem(0).icon?.setTint(Color.BLACK)
        mainMenu.getItem(1).icon?.setTint(Color.BLACK)
        mainMenu.getItem(2).icon?.setTint(Color.BLACK)
        mainMenu.getItem(3).setIcon(R.drawable.ic_oval_off)
        mainMenu.getItem(4).icon?.setTint(Color.BLACK)
        mainMenu.getItem(5).icon?.setTint(Color.BLACK)
    }




    override fun onOptionsItemSelected(item: MenuItem): Boolean {

       setIconOff()


            when (item.itemId) {
                R.id.action_point -> {setPoint(); item.icon?.setTint(Color.rgb(218, 215, 218))}
                R.id.action_line -> {setLine(); item.icon?.setTint(Color.rgb(218, 215, 218))}
                R.id.action_rectangle -> {setRectangle(); item.icon?.setTint(Color.rgb(218, 215, 218))}
                R.id.action_ellipse -> {setEllipse(); item.setIcon(R.drawable.ic_oval_on)}
                R.id.action_table -> {openTable();item.icon?.setTint(Color.rgb(218, 215, 218)) }
                R.id.action_cube -> {setCube();item.icon?.setTint(Color.rgb(218, 215, 218)) }
                R.id.action_section -> {setSection(); item.icon?.setTint(Color.rgb(218, 215, 218))}
            }
            return super.onOptionsItemSelected(item)

    }

    private fun openTable() {
        val intent = Intent(this, Table::class.java)
        startActivity(intent)
    }

    private fun setPoint(){
        supportActionBar?.title = "Точка"
        currentFigure = Point(0f, 0f, 0f, 0f)

    }
    private fun setLine(){
        supportActionBar?.title = "Лінія"
        currentFigure = Line(0f, 0f, 0f, 0f)
    }
    private fun setRectangle(){
        supportActionBar?.title = "Прямокутник"
        currentFigure = Rectangle(0f, 0f, 0f, 0f)
    }
    private fun setEllipse(){
        supportActionBar?.title = "Еліпс"
        currentFigure = Ellipse(0f, 0f, 0f, 0f)
    }
    private fun setSection(){
        supportActionBar?.title = "Відрізок"
        currentFigure = Section(0f, 0f, 0f, 0f)

    }
    private fun setCube(){
        supportActionBar?.title = "Куб"
        currentFigure = Cube(0f, 0f, 0f, 0f)

    }
}