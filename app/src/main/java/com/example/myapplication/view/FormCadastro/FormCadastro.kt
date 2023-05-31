package com.example.myapplication.view.FormCadastro

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.databinding.ActivityFormCadastroBinding
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase


class FormCadastro : AppCompatActivity() {

    private lateinit var binding: ActivityFormCadastroBinding
    private lateinit var bd: DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
          binding = ActivityFormCadastroBinding.inflate(layoutInflater)
          setContentView(binding.root)

        bd = FirebaseDatabase.getInstance().getReference("Usuario")

            var etNome = binding.etNome
            var etSobrenome = binding.etSobrenome
            var etIdade = binding.etIdade
            var bt_Cadastrar =binding.btCadastrar

        bd = FirebaseDatabase.getInstance().getReference("Usuario")
        bt_Cadastrar.setOnClickListener {
            val usNome = etNome.text.toString()
            val usSobrenome = etSobrenome.text.toString()
            val usIdade = etIdade.text.toString()

            if (usNome.isEmpty())   {
                etNome.error = "Insira um nome"
                }
            if (usSobrenome.isEmpty()){
                    etSobrenome.error = "Insira um sobrenome"
                }
            if (usIdade.isEmpty()){
                    etIdade.error = "Insira uma idade"
                }
            val usId = bd.push().key!!
            val usuario = UsuarioModelo(usId,usNome,usSobrenome,usIdade)

            bd.child(usId).setValue(usuario)
                .addOnCompleteListener {
                    Toast.makeText(this, "Cadastro realizado", Toast.LENGTH_SHORT).show()

                    etNome.text.clear()
                    etSobrenome.text.clear()
                    etIdade.text.clear()

                }.addOnFailureListener { err ->
                    Toast.makeText( this,"Error ${err.message}", Toast.LENGTH_SHORT).show()
                }

            }
    }

    }
