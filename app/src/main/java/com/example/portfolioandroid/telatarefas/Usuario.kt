package com.example.portfolioandroid.telatarefas

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.portfolioandroid.R
import com.example.portfolioandroid.itemLista.UsuarioItem
import com.example.portfolioandroid.model.Usuarios
import com.example.portfolioandroid.repositorio.BackGrounde

@SuppressLint("UnusedMaterialScaffoldPaddingParameter", "SuspiciousIndentation")
@Composable
fun UsuarioTarefa(
    navController: NavController
)
{
    val imagem: ImageVector = ImageVector.vectorResource(id = R.drawable.ic_home)
    val imagem2: ImageVector = ImageVector.vectorResource(id = R.drawable.ic_estatistica)
    val imagem3: ImageVector = ImageVector.vectorResource(id = R.drawable.ic_gasto)
    val imagem4: ImageVector = ImageVector.vectorResource(id = R.drawable.ic_usuario)
    val items = listOf(
        BottomBarItem("ListaDeTarefas",imagem) , // Substitua "Screen1" e Icons.Default.Screen1 pelos seus destinos e ícones reais
        BottomBarItem("Metas", imagem2 ),
        BottomBarItem("Gasto",imagem3),
        BottomBarItem("Usuario",imagem4)
    )
    Scaffold(topBar = {
        TopAppBar(backgroundColor = BackGrounde,
            title = { Text(text = "Usuario",
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White)
            })
    },  bottomBar = { BottomBar(navController = navController, items = items)

    },
        floatingActionButton = {
            FloatingActionButton(onClick = {
                navController.navigate(route = "SalvarTarefa")
            },backgroundColor = BackGrounde
            ) {
                Image(
                    imageVector = ImageVector.vectorResource(id = R.drawable.baseline_edit_note_24),
                    contentDescription = "Botao de Salvar"
                )
            }
        },
        backgroundColor = BackGrounde

    )

    {
        val listarUsuarios: MutableList<Usuarios> = mutableListOf(
            Usuarios(
              icone = 1,
                nomeUsu = "Marcio Oliveira",
                perfil = "Jogador de Basquete em busca de um App para melhorar meu rendimento!"
            )

        )
        LazyColumn(){
            itemsIndexed(listarUsuarios){position, _ ->
                UsuarioItem(position,listarUsuarios)
            }
        }
    }

    }

