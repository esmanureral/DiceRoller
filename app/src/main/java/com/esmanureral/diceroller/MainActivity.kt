package com.esmanureral.diceroller

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.esmanureral.diceroller.ui.theme.DiceRollerTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DiceRollerTheme {
                DiceRollerApp()
            }
        }
    }

    @Preview
    @Composable
    fun DiceRollerApp() {
        DiceWithButtonAndImage()
    }
}

/*
 DiceWithButtonAndImage Composable fonksiyonu,zarın görselini ve bir butonu içeren kullanıcı arayüzünü temsil eder.
 */
@Composable
fun DiceWithButtonAndImage(modifier: Modifier = Modifier) {
    // Zarın sonucunu saklamak için bir durum değişkeni tanımladık.
    var result by remember { mutableStateOf(1) }

    //Zar sonucuna bağlı olarak görüntülenecek resim kaynağı belirledik.
    val imageResource = when (result) {
        1 -> R.drawable.dice_1
        2 -> R.drawable.dice_2
        3 -> R.drawable.dice_3
        4 -> R.drawable.dice_4
        5 -> R.drawable.dice_5
        else -> R.drawable.dice_6
    }

    // Kullanıcı arayüzü düzeni
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally // Elemanların yatay hizalanması
    ) {
        // Zar sonucunu gösteren görsel
        Image(
            painter = painterResource(imageResource),
            contentDescription = result.toString()
        )
        Spacer(modifier = Modifier.height(16.dp)) // Görsel ile buton arasında boşluk
        Button(onClick = {
            // Yeni bir rastgele zar sonucu oluşturuluyor
            result = (1..6).random()
        }) {
            Text(stringResource(R.string.diceroller)) // Butonun üzerindeki metin
        }
    }
}
