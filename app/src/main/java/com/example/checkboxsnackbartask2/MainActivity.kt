package com.example.checkboxsnackbartask2

import android.os.Bundle
import android.widget.CheckBox
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    private  lateinit var checkboxCB: CheckBox
    private  lateinit var info_textET: EditText
    private lateinit var rules_cardLL: LinearLayout
    private lateinit var rules_containerLL: LinearLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        checkboxCB = findViewById(R.id.checkboxCB)
        info_textET = findViewById(R.id.info_textET)
        rules_cardLL = findViewById(R.id.rules_cardLL)
        rules_containerLL = findViewById(R.id.rules_containerLL)

        checkboxCB.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                //Устанавливаем текст в поле "Информация"
                info_textET.setText("Правила дорожного движения")

                //Показываем правила
                rules_cardLL.visibility = LinearLayout.VISIBLE

                //Добавляем правила в контейнер
                addRulesToContainer(rules_containerLL)
            } else {

                //Очищаем поле "Информация"
                info_textET.setText("")

                //Скрываем правила
                rules_cardLL.visibility = LinearLayout.GONE

                //Очищаем контейнер
                rules_containerLL.removeAllViews()
            }
        }
    }

    fun addRulesToContainer(container: LinearLayout) {
        val rules = listOf(
            "1. Движение транспортных средств осуществляется по правой стороне дороги",
            "2. Водитель обязан иметь при себе водительское удостоверение",
            "3. Превышение установленной скорости движения запрещено",
            "4. Обгон запрещен на пешеходных переходах, перекрестках, железнодорожных преездах и в тонелях",
            "5. Водитель и пассажиры обязаны пристегиваться ремнями безопасности"
        )

        for (rule in rules) {
            val ruleTextView = TextView(this).apply {
                text = rule
                textSize = 16f
                setPadding(20,10,20,10) //прямо задаем отступы
            }
            container.addView(ruleTextView)
        }
    }
}