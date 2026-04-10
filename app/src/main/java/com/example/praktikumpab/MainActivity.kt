package com.example.praktikumpab

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.praktikumpab.ui.theme.PraktikumPABTheme

val ColorPrimary = Color(0xFF03A9F4)
val ColorBackground = Color(0xFFF8FAFC)
val ColorTextPrimary = Color(0xFF1E293B)
val ColorTextSecondary = Color(0xFF64748B)

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            PraktikumPABTheme {
                HalamanUtama(
                    onGoToGameList = {
                        // Membuka halaman daftar game (ProfileActivity)
                        val intent = Intent(this, ProfileActivity::class.java)
                        startActivity(intent)
                    }
                )
            }
        }
    }
}

@Composable
fun HalamanUtama(
    onGoToGameList: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(ColorBackground)
            .verticalScroll(rememberScrollState())
            .padding(horizontal = 24.dp, vertical = 48.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text(
            text = "Mokit Store",
            fontSize = 32.sp,
            fontWeight = FontWeight.ExtraBold,
            color = ColorPrimary,
            textAlign = TextAlign.Center,
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(24.dp))

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp)
                .clip(RoundedCornerShape(12.dp))
                .background(Color(0xFFCBD5E1)),
            contentAlignment = Alignment.Center
        ) {
            Image(
                painter = painterResource(id = R.drawable.mokit),
                contentDescription = "Banner Mokit Store",
                contentScale = ContentScale.Crop,
                modifier = Modifier.fillMaxSize()
            )
        }

        Spacer(modifier = Modifier.height(24.dp))

        Box(
            modifier = Modifier
                .width(48.dp)
                .height(4.dp)
                .background(ColorPrimary, RoundedCornerShape(2.dp))
        )

        Spacer(modifier = Modifier.height(20.dp))

        Text(
            text = "Top Up Murah Sedunia!",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            color = ColorTextPrimary
        )

        Spacer(modifier = Modifier.height(12.dp))

        Text(
            text = "Selamat datang di Mokit Store. Tempat terbaik untuk top up game favoritmu! " +
                    "Harga termurah, proses otomatis, aman, dan terpercaya 100%.",
            textAlign = TextAlign.Center,
            color = ColorTextSecondary,
            lineHeight = 22.sp
        )

        Spacer(modifier = Modifier.height(36.dp))

        Button(
            onClick = onGoToGameList,
            modifier = Modifier
                .fillMaxWidth()
                .height(54.dp),
            shape = RoundedCornerShape(27.dp),
            colors = ButtonDefaults.buttonColors(containerColor = ColorPrimary)
        ) {
            Text("Lihat Daftar Game", fontSize = 16.sp, fontWeight = FontWeight.Bold)
        }
    }
}