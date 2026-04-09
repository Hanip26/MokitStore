package com.example.praktikumpab

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.praktikumpab.ui.theme.PraktikumPABTheme

// Data class dengan properti imageResId untuk ikon game
data class GameData(
    val namaGame: String,
    val publisher: String,
    val infoTopUp: String,
    val imageResId: Int? = null
)

class ProfileActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        // List game dengan masing-masing resource gambar dari drawable
        val listGame = listOf(
            GameData("Mobile Legends", "Moonton", "Diamond mulai dari Rp 1.500", R.drawable.kalea),
            GameData("Free Fire", "Garena", "Diamond mulai dari Rp 1.000", R.drawable.ff),
            GameData("Genshin Impact", "HoYoverse", "Genesis Crystal mulai Rp 16.000", R.drawable.gensin),
            GameData("PUBG Mobile", "Level Infinite", "UC mulai dari Rp 2.500", R.drawable.pubg),
            GameData("Valorant", "Riot Games", "VP mulai dari Rp 15.000", R.drawable.valo)
        )

        setContent {
            PraktikumPABTheme {
                HalamanTopUpGame(
                    gameList = listGame,
                    onBack = { finish() },
                    onGameClick = { game ->
                        val intent = Intent(this@ProfileActivity, TopUpDetailActivity::class.java).apply {
                            putExtra("NAMA_GAME", game.namaGame)
                        }
                        startActivity(intent)
                    }
                )
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HalamanTopUpGame(
    gameList: List<GameData>,
    onBack: () -> Unit,
    onGameClick: (GameData) -> Unit
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Top Up Game Online", color = Color(0xFF1E293B), fontWeight = FontWeight.SemiBold) },
                navigationIcon = {
                    IconButton(onClick = onBack) {
                        Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Back", tint = Color(0xFF1E293B))
                    }
                },
                actions = {
                    IconButton(onClick = { /* TODO Action */ }) {
                        Icon(Icons.Filled.MoreVert, contentDescription = "Menu", tint = Color(0xFF1E293B))
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(containerColor = Color(0xFFF8FAFC))
            )
        },
        containerColor = Color(0xFFF1F5F9)
    ) { paddingValues ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues),
            contentPadding = PaddingValues(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            items(gameList) { game ->
                GameCard(game = game, onClick = { onGameClick(game) })
            }
        }
    }
}

@Composable
fun GameCard(game: GameData, onClick: () -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onClick() },
        shape = RoundedCornerShape(12.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            // Bagian Gambar Ikon Game
            if (game.imageResId != null) {
                Image(
                    painter = painterResource(id = game.imageResId),
                    contentDescription = "Gambar ${game.namaGame}",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .size(80.dp)
                        .clip(RoundedCornerShape(8.dp))
                )
            } else {
                Box(
                    modifier = Modifier
                        .size(80.dp)
                        .background(Color(0xFFE2E8F0), RoundedCornerShape(8.dp)),
                    contentAlignment = Alignment.Center
                ) {
                    Text("Gambar", color = Color(0xFF64748B), fontSize = 12.sp)
                }
            }

            Spacer(modifier = Modifier.width(16.dp))

            Column(
                modifier = Modifier.weight(1f)
            ) {
                Text(text = game.namaGame, fontWeight = FontWeight.Bold, fontSize = 18.sp, color = Color(0xFF334155))
                Spacer(modifier = Modifier.height(4.dp))
                Text(text = game.publisher, fontSize = 14.sp, color = Color(0xFF64748B))
                Spacer(modifier = Modifier.height(8.dp))
                Text(text = game.infoTopUp, fontSize = 12.sp, color = Color(0xFF64748B))
            }
        }
    }
}