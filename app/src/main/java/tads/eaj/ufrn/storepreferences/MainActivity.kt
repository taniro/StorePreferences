package tads.eaj.ufrn.storepreferences

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    val PREFS = "prefs_file"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val settings = getSharedPreferences(PREFS, Context.MODE_PRIVATE)
        val salvar = settings.getBoolean("salvar", false)
        val texto = settings.getString("texto", "")

        if (salvar){
            checkBox.isChecked = salvar
            editText.setText(texto)
        }

        sairButton.setOnClickListener {
            finish()
        }
    }

    override fun onStop() {
        super.onStop()


        val settings = getSharedPreferences(PREFS,Context.MODE_PRIVATE)
        var editor = settings.edit()

        if (checkBox.isChecked){

            /*
            editor.putBoolean("salvar", checkBox.isChecked)
            editor.putString("texto", editText.text.toString())

            editor.commit()
            */


            with(settings.edit()){
                putBoolean("salvar", checkBox.isChecked)
                putString("texto", editText.text.toString())
                commit()
            }


        }else{
            /*
            editor.remove("salvar")
            editor.remove("texto")
            editor.commit()
            */


            with(settings.edit()){
                remove("salvar")
                remove("texto")
                commit()
            }

        }
    }
}
