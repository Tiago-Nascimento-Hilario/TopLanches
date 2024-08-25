package com.tiago.toplanches

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.tiago.toplanches.modelo.Produto
import com.tiago.toplanches.ui.theme.Purple40
import com.tiago.toplanches.ui.theme.Teal500
import com.tiago.toplanches.ui.theme.TopLanchesTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Box(Modifier.safeDrawingPadding()) {
                //ItemProduto()
                App()
            }
        }
    }
}

@Composable
fun ItemProduto(produto : Produto) {
    Surface(shape = RoundedCornerShape(15.dp), shadowElevation = 4.dp) {
        Column(
            Modifier
                .heightIn(250.dp, 300.dp)
                .width(200.dp)
        ) {
            Box(
                Modifier
                    .height(100.dp)
                    .background(
                        brush = Brush.horizontalGradient(
                            colors = listOf(
                                Purple40,
                                Teal500
                            )
                        )
                    )
                    .fillMaxWidth()
            ) {
                Image(
                    painter = painterResource(produto.image),
                    contentDescription = "foto Lanche",
                    Modifier
                        .size(100.dp)
                        .offset(y = (50).dp)
                        .clip(shape = CircleShape)
                        .align(Alignment.Center),
                    contentScale = ContentScale.Crop

                )
            }
            Spacer(modifier = Modifier.height(50.dp))
            Column(Modifier.padding(16.dp)) {
                Text(
                    text = produto.nome,
                    Modifier.padding(bottom = 8.dp),
                    fontSize = 18.sp,
                    fontWeight = FontWeight(700),
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis,

                    )
                Text(
                    text = produto.preco.toString(),
                    fontSize = 14.sp,
                    fontWeight = FontWeight(400),
                )
            }
        }
    }

}

@Composable
fun GaleriaProdutos() {
    val moeda: String = "R$"
    Column {
        Text(
            text = "Promoções",
            Modifier.padding(start = 16.dp, top = 16.dp, end = 16.dp),
            fontSize = 20.sp,
            fontWeight = FontWeight(400)
        )
        Row(
            Modifier
                .padding(
                    start = 16.dp,
                    top = 8.dp,
                    bottom = 16.dp
                )
                .fillMaxWidth()
                .horizontalScroll(rememberScrollState()), horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            ItemProduto(Produto(
                nome = "Hamburguer Artesanal",
                preco = "$moeda 14.55",
                image = R.drawable.hamburguer
            ))
            ItemProduto(Produto(
                nome = "Pizza",
                preco = "$moeda 72.99",
                image = R.drawable.pizza
            ))
            ItemProduto(Produto(
                nome = "Sucos e Refrigerantes",
                preco = "$moeda 8.99",
                image = R.drawable.bebidas
            ))
        }
    }
}

@Composable
fun App() {
    TopLanchesTheme {
        Column(
            Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
        ) {
            GaleriaProdutos()
            GaleriaProdutos()
            GaleriaProdutos()
        }
    }
}