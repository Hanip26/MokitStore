package com.example.praktikumpab

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.praktikumpab.ui.theme.PraktikumPABTheme

data class GamePackage(
    val title: String,
    val bonus: String,
    val price: String
)

class TopUpDetailActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        val namaGame = intent.getStringExtra("NAMA_GAME") ?: "Mobile Legends"
        val listPaket = generatePackages(namaGame)

        setContent {
            PraktikumPABTheme {
                HalamanDetailTopUp(
                    namaGame = namaGame,
                    paketList = listPaket,
                    onBack = { finish() }
                )
            }
        }
    }

    private fun generatePackages(game: String): List<GamePackage> {
        return when (game) {
            "Free Fire" -> listOf(
                GamePackage("Paket 1: 70 Diamond", "+5 Bonus Diamond", "Rp 10.000"),
                GamePackage("Paket 2: 140 Diamond", "+12 Bonus Diamond", "Rp 20.000"),
                GamePackage("Paket 3: 355 Diamond", "+30 Bonus Diamond", "Rp 50.000")
            )
            "Genshin Impact" -> listOf(
                GamePackage("Paket 1: 60 Genesis Crystals", "Tanpa Bonus", "Rp 16.000"),
                GamePackage("Paket 2: 300 Genesis Crystals", "+30 Bonus", "Rp 79.000"),
                GamePackage("Paket 3: 980 Genesis Crystals", "+110 Bonus", "Rp 249.000")
            )
            "PUBG Mobile" -> listOf(
                GamePackage("Paket 1: 60 UC", "Tanpa Bonus", "Rp 15.000"),
                GamePackage("Paket 2: 300 UC", "+25 Bonus UC", "Rp 75.000"),
                GamePackage("Paket 3: 600 UC", "+60 Bonus UC", "Rp 150.000")
            )
            "Valorant" -> listOf(
                GamePackage("Paket 1: 300 VP", "Tanpa Bonus", "Rp 45.000"),
                GamePackage("Paket 2: 625 VP", "Tanpa Bonus", "Rp 90.000"),
                GamePackage("Paket 3: 1125 VP", "+75 Bonus VP", "Rp 150.000")
            )
            else -> listOf(
                GamePackage("Paket 1: 11 Diamond", "+1 Bonus Diamond", "Rp 5.000"),
                GamePackage("Paket 2: 28 Diamond", "+3 Bonus Diamond", "Rp 10.000"),
                GamePackage("Paket 3: 56 Diamond", "+6 Bonus Diamond", "Rp 20.000")
            )
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HalamanDetailTopUp(
    namaGame: String,
    paketList: List<GamePackage>,
    onBack: () -> Unit
) {
    var selectedPackage by remember { mutableStateOf<GamePackage?>(null) }
    var usernameInput by remember { mutableStateOf("") }
    val context = LocalContext.current

    val bannerRes = when (namaGame) {
        "Mobile Legends" -> R.drawable.ml
        "Free Fire" -> R.drawable.freefire
        "Genshin Impact" -> R.drawable.gensin1
        "PUBG Mobile" -> R.drawable.pubg1
        "Valorant" -> R.drawable.valo1
        else -> null
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Top Up $namaGame", color = Color(0xFF1E293B), fontWeight = FontWeight.SemiBold) },
                navigationIcon = {
                    IconButton(onClick = onBack) {
                        Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Back", tint = Color(0xFF1E293B))
                    }
                },
                actions = { IconButton(onClick = {}) { Icon(Icons.Filled.MoreVert, null, tint = Color(0xFF1E293B)) } },
                colors = TopAppBarDefaults.topAppBarColors(containerColor = Color(0xFFF8FAFC))
            )
        },
        bottomBar = {
            Box(modifier = Modifier.fillMaxWidth().background(Color.White).padding(16.dp)) {
                Button(
                    onClick = {
                        if (usernameInput.isBlank() || selectedPackage == null) {
                            Toast.makeText(context, "Lengkapi User ID dan pilih paket!", Toast.LENGTH_SHORT).show()
                        } else {
                            val intent = Intent(context, PaymentConfirmationActivity::class.java).apply {
                                putExtra("NAMA_GAME", namaGame)
                                putExtra("USERNAME", usernameInput)
                                putExtra("PAKET_TITLE", selectedPackage?.title)
                                putExtra("PAKET_PRICE", selectedPackage?.price)
                            }
                            context.startActivity(intent)
                        }
                    },
                    modifier = Modifier.fillMaxWidth().height(50.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF1D72B8)),
                    shape = RoundedCornerShape(25.dp)
                ) {
                    Text("Lanjut ke Pembayaran", fontSize = 16.sp, fontWeight = FontWeight.Bold)
                }
            }
        },
        containerColor = Color(0xFFF1F5F9)
    ) { paddingValues ->
        LazyColumn(
            modifier = Modifier.fillMaxSize().padding(paddingValues),
            contentPadding = PaddingValues(16.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            item {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(200.dp)
                        .clip(RoundedCornerShape(12.dp))
                        .background(Color(0xFF334155)),
                    contentAlignment = Alignment.Center
                ) {
                    if (bannerRes != null) {
                        Image(
                            painter = painterResource(id = bannerRes),
                            contentDescription = "Banner $namaGame",
                            contentScale = ContentScale.Crop,
                            modifier = Modifier.fillMaxSize()
                        )
                    } else {
                        Text("Banner / Poster $namaGame", color = Color.White, fontWeight = FontWeight.Bold)
                    }
                }
                Spacer(modifier = Modifier.height(8.dp))
            }

            item {
                Card(
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(12.dp),
                    colors = CardDefaults.cardColors(containerColor = Color.White),
                    elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
                ) {
                    Column(modifier = Modifier.padding(16.dp)) {
                        Text("Masukkan Data Akun", fontWeight = FontWeight.Bold, fontSize = 16.sp, color = Color(0xFF0F172A))
                        Spacer(modifier = Modifier.height(8.dp))
                        OutlinedTextField(
                            value = usernameInput,
                            onValueChange = { usernameInput = it },
                            label = { Text("User ID / Username") },
                            modifier = Modifier.fillMaxWidth(),
                            singleLine = true,
                            leadingIcon = { Icon(Icons.Filled.Person, null, tint = Color(0xFF64748B)) },
                            shape = RoundedCornerShape(8.dp)
                        )
                    }
                }
            }

            item {
                Text("Daftar Paket", fontWeight = FontWeight.Bold, fontSize = 20.sp, color = Color(0xFF0F172A))
            }

            items(paketList) { paket ->
                val isSelected = selectedPackage == paket
                Card(
                    modifier = Modifier.fillMaxWidth().clickable { selectedPackage = paket },
                    shape = RoundedCornerShape(12.dp),
                    colors = CardDefaults.cardColors(
                        containerColor = if (isSelected) Color(0xFFE0F2FE) else Color.White
                    ),
                    elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
                ) {
                    Row(modifier = Modifier.fillMaxWidth().padding(16.dp), verticalAlignment = Alignment.CenterVertically) {
                        GameIcon()
                        Spacer(modifier = Modifier.width(16.dp))
                        Column {
                            Text(text = paket.title, fontWeight = FontWeight.Bold, fontSize = 16.sp)
                            Text(text = paket.bonus, fontSize = 14.sp, color = Color(0xFF1D72B8))
                            Text(text = paket.price, fontSize = 14.sp, color = Color(0xFF475569))
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun GameIcon() {
    Canvas(modifier = Modifier.size(40.dp)) {
        val path = Path().apply {
            moveTo(size.width / 2f, 0f)
            lineTo(size.width, size.height * 0.35f)
            lineTo(size.width / 2f, size.height)
            lineTo(0f, size.height * 0.35f)
            close()
        }
        drawPath(path = path, color = Color(0xFF3B82F6))
    }
}