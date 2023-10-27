package br.senai.sp.jandira

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import com.google.gson.JsonObject

class CadastroLivro : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.cadastro_livro)

        //RECUPERANDO OS ELEMENTOS DE VIEW
        val txtTitulo = findViewById<EditText>(R.id.txtTitulo)
        val txtPreco = findViewById<EditText>(R.id.txtPreco)
        val txtCategoria = findViewById<EditText>(R.id.txtCategoria)
        val txtDescricao = findViewById<EditText>(R.id.txtLivroDescricao)
        val btnCadastrar = findViewById<Button>(R.id.btnCadastrarLivro)

        //TRATAMENTO DA AÇÃO DE CLIQUE NO BOTÃO CADASTRAR
        btnCadastrar.setOnClickListener {

            //RECEBENDO OS DADOS DIGITADOS
            val titulo = txtTitulo.text.toString()
            val preco = txtPreco.text.toString()
            val categoria = txtCategoria.text.toString()
            val descricao = txtDescricao.text.toString()

            //CONSTRUÇÃO DO CORPO DE DADOS EM JSON
            val body = JsonObject().apply {
                addProperty("titulo", titulo)
                addProperty("preco", preco)
                addProperty("categoria", categoria)
                addProperty("descricao", descricao)
            }

            //TESTE DO CORPO DE DADOS JSON
            Log.w("BODY-JSON", "onCreate: $body")

            //NAVEGAÇÃO PARA A TELA DE IMAGENS COM CORPO DE DADOS JSON
            val intent = Intent(this, CadastroLivroImagem::class.java).apply {
                putExtra("bodyJSON", body.toString())
            }

            startActivity(intent)

        }


    }
}