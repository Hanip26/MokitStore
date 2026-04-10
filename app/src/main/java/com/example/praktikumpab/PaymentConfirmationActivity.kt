package com.example.praktikumpab

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.praktikumpab.ui.theme.PraktikumPABTheme

class PaymentConfirmationActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        val namaGame = intent.getStringExtra("NAMA_GAME") ?: "-"
        val username = intent.getStringExtra("USERNAME") ?: "-"
        val paketTitle = intent.getStringExtra("PAKET_TITLE") ?: "-"
        val paketPrice = intent.getStringExtra("PAKET_PRICE") ?: "-"

        setContent {
            PraktikumPABTheme {
                HalamanKonfirmasi(
                    namaGame = namaGame,
                    username = username,
                    paketTitle = paketTitle,
                    paketPrice = paketPrice,
                    onBack = { finish() },
                    onConfirm = {
                        val intent = Intent(this@PaymentConfirmationActivity, PaymentSuccessActivity::class.java).apply {
                            putExtra("TOTAL_BAYAR", paketPrice)
                        }
                        startActivity(intent)

                        finish()
                    }
                )
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HalamanKonfirmasi(
    namaGame: String,
    username: String,
    paketTitle: String,
    paketPrice: String,
    onBack: () -> Unit,
    onConfirm: () -> Unit
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Detail Pembayaran", color = Color(0xFF1E293B), fontWeight = FontWeight.SemiBold) },
                navigationIcon = {
                    IconButton(onClick = onBack) {
                        Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Back", tint = Color(0xFF1E293B))
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(containerColor = Color(0xFFF8FAFC))
            )
        },
        containerColor = Color(0xFFF1F5F9)
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Text(
                text = "Ringkasan Pesanan",
                fontSize = 22.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFF0F172A),
                modifier = Modifier.padding(bottom = 24.dp, top = 16.dp)
            )

            Card(
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(16.dp),
                colors = CardDefaults.cardColors(containerColor = Color.White),
                elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
            ) {
                Column(
                    modifier = Modifier.padding(24.dp)
                ) {
                    DetailRow(label = "Game", value = namaGame)
                    HorizontalDivider(modifier = Modifier.padding(vertical = 12.dp))

                    DetailRow(label = "User ID", value = username)
                    HorizontalDivider(modifier = Modifier.padding(vertical = 12.dp))

                    DetailRow(label = "Item", value = paketTitle)
                    HorizontalDivider(modifier = Modifier.padding(vertical = 12.dp))

                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text("Total Bayar", color = Color(0xFF64748B), fontSize = 16.sp)
                        Text(paketPrice, fontWeight = FontWeight.Bold, color = Color(0xFF1D72B8), fontSize = 18.sp)
                    }
                }
            }

            Spacer(modifier = Modifier.weight(1f))

            Button(
                onClick = onConfirm,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF10B981)),
                shape = RoundedCornerShape(25.dp)
            ) {
                Text("Konfirmasi & Bayar", fontSize = 16.sp, fontWeight = FontWeight.Bold)
            }
        }
    }
}

@Composable
fun DetailRow(label: String, value: String) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(label, color = Color(0xFF64748B), fontSize = 14.sp)
        Text(value, fontWeight = FontWeight.SemiBold, color = Color(0xFF334155), fontSize = 14.sp, textAlign = TextAlign.End)
    }
}