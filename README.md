# 🎮 Mokit Store: Solusi Top-Up Game Tercepat & Terpercaya

[![Kotlin Version](https://img.shields.io/badge/Kotlin-1.9.0-blue.svg)](https://kotlinlang.org/)
[![Compose Version](https://img.shields.io/badge/Jetpack%20Compose-2023.10.01-green.svg)](https://developer.android.com/jetpack/compose)
[![Platform](https://img.shields.io/badge/Platform-Android-brightgreen.svg)](https://developer.android.com/)

**Mokit Store** adalah aplikasi Android berbasis Mobile yang dikembangkan menggunakan **Jetpack Compose**. Aplikasi ini menyediakan alur transaksi lengkap untuk kebutuhan *top-up* berbagai judul game populer dengan antarmuka yang modern, bersih, dan intuitif. 

---

## 📸 Tampilan Aplikasi (Mockups)

| Landing Page | Game Catalog | Detail & Order | Payment | Struk |
| :---: | :---: | :---: | :---: | :---: |
 | <img width="351" height="780" alt="image" src="https://github.com/user-attachments/assets/f2b8329e-4451-4637-8657-1290f00042d5" /> | <img width="350" height="785" alt="image" src="https://github.com/user-attachments/assets/cdd84fdc-0f8b-44ba-8523-a699fe8c5631" /> | <img width="349" height="783" alt="image" src="https://github.com/user-attachments/assets/ee24ced3-aec0-4207-9106-a2b43cf8cb31" /> | <img width="352" height="783" alt="image" src="https://github.com/user-attachments/assets/eb0ce93a-54c4-4077-9fdf-32aa638d8f45" /> | <img width="351" height="782" alt="image" src="https://github.com/user-attachments/assets/a7570aa7-5632-4f00-aa38-91ecc4b2d089" />





---

## 🚀 Fitur Utama

1.  **Dynamic Game Catalog**: Menampilkan daftar game populer (Mobile Legends, Free Fire, Genshin Impact, dll) lengkap dengan ikon dan informasi harga mulai dari.
2.  **Smart Form Validation**: Sistem validasi yang memastikan pengguna telah memasukkan User ID dan memilih paket sebelum melanjutkan ke pembayaran.
3.  **Adaptive Detail Page**: Halaman detail akan secara otomatis berubah (Banner, Nama Game, Ikon, dan Paket Harga) berdasarkan game yang diklik oleh pengguna.
4.  **Order Summary (Invoice)**: Sebelum melakukan bayar, pengguna diberikan ringkasan data akun dan nominal yang harus dibayar untuk meminimalisir kesalahan input.
5.  **Success State Handling**: Animasi status berhasil dan ringkasan akhir pembayaran sebagai bukti transaksi.

---

## 🛠️ Arsitektur & Teknologi

Aplikasi ini dikembangkan menggunakan pendekatan modern Android dengan mengedepankan performa, skalabilitas, serta kemudahan dalam pemeliharaan kode. Seluruh pengembangan dilakukan menggunakan bahasa Kotlin (100%) yang memanfaatkan fitur modern seperti coroutines untuk pemrosesan asynchronous, null safety untuk meminimalkan error, serta extension function untuk meningkatkan keterbacaan kode.

Pada sisi antarmuka, aplikasi ini menggunakan Jetpack Compose sebagai UI framework berbasis deklaratif yang memungkinkan pengembangan tampilan lebih cepat, fleksibel, dan reaktif terhadap perubahan state. Dengan pendekatan state-driven UI, setiap perubahan data secara otomatis akan memperbarui tampilan tanpa perlu manipulasi manual. Desain UI juga mengadopsi Material Design 3 untuk memberikan pengalaman pengguna yang modern dan konsisten.

Arsitektur aplikasi menerapkan pola MVVM (Model-View-ViewModel) yang memisahkan logika bisnis, pengelolaan data, dan tampilan. ViewModel bertanggung jawab dalam mengelola state UI dan berkomunikasi dengan layer data, sehingga meningkatkan modularitas serta mempermudah proses testing. State management dilakukan menggunakan kombinasi `remember`, `mutableStateOf`, `rememberSaveable`, serta integrasi dengan StateFlow atau LiveData untuk pengelolaan state yang lebih kompleks.

Untuk struktur tampilan, digunakan komponen seperti Scaffold sebagai kerangka utama layout, TopAppBar untuk navigasi, serta LazyColumn dan LazyRow untuk menampilkan daftar data secara efisien dengan performa optimal. Navigasi antar halaman dapat dilakukan menggunakan Intent maupun Navigation Compose untuk pendekatan single-activity yang lebih modern.

Dalam pengelolaan data, aplikasi ini dapat menggunakan Room Database sebagai penyimpanan lokal berbasis SQLite, serta DataStore atau SharedPreferences untuk menyimpan preferensi pengguna. Repository pattern diterapkan untuk mengelola sumber data baik dari lokal maupun remote secara terpusat.

Koneksi jaringan dilakukan menggunakan Retrofit yang dipadukan dengan OkHttp sebagai HTTP client, serta Kotlin Coroutines dan Flow untuk menangani proses asynchronous secara efisien. Untuk manajemen dependensi, digunakan Hilt atau Dagger guna menyederhanakan injeksi dependensi dan meningkatkan skalabilitas aplikasi.

Dari sisi resource, aplikasi memanfaatkan custom drawables, vector graphics, serta material icons untuk memastikan tampilan tetap tajam dan konsisten di berbagai ukuran layar. Selain itu, pengujian dilakukan menggunakan unit testing (JUnit) dan UI testing (Compose Test) untuk menjaga kualitas aplikasi.

Proses build dikelola menggunakan Gradle (Kotlin DSL), dengan pengembangan dilakukan di Android Studio serta version control menggunakan Git. Berbagai optimasi performa juga diterapkan, seperti menghindari recomposition yang tidak perlu pada Compose serta penggunaan komponen lazy untuk efisiensi rendering.

---

## 📁 Struktur Navigasi Proyek
<pre>📦 Struktur Proyek
├── app/src/
│   ├── androidTest/              
│   ├── main/
│   │   ├── java/com/example/praktik...
│   │   │   ├── ui/theme/         
│   │   │   ├── MainActivity.kt                 
│   │   │   ├── PaymentConfirmationActivity.kt  
│   │   │   ├── PaymentSuccessActivity.kt       
│   │   │   ├── ProfileActivity.kt              
│   │   │   └── TopUpDetailActivity.kt          
│   │   ├── res/                  
│   │   └── AndroidManifest.xml   
│   └── test/                     
├── gradle/
│   ├── wrapper/                  
│   └── libs.versions.toml        
├── build.gradle.kts (Project)    
├── build.gradle.kts (Module)     
├── gradle.properties             
├── settings.gradle.kts           
└── README.md                     
</pre>

Proyek ini terbagi menjadi beberapa Activity utama yang saling terintegrasi:

1.  **`MainActivity`**: Gerbang utama aplikasi (Landing Page) yang berisi branding Mokit Store.
2.  **`ProfileActivity`**: Berfungsi sebagai Katalog Utama. Menggunakan `LazyColumn` untuk merender daftar game secara dinamis.
3.  **`TopUpDetailActivity`**: Mesin utama aplikasi yang menangani input user dan logika pemilihan paket game.
4.  **`PaymentConfirmationActivity`**: Halaman konfirmasi yang bertindak sebagai *middleware* sebelum transaksi diproses.
5.  **`PaymentSuccessActivity`**: Halaman final yang menampilkan status keberhasilan transaksi.

---

## 🛠️ Instalasi & Pengembangan

**Prasyarat:**
* Android Studio Hedgehog | 2023.1.1 atau versi terbaru.
* JDK 17+.
* SDK Android API 24 (Nougat) ke atas.

**Langkah-langkah:**
1.  **Clone the Repo**:
    ```bash
    git clone [https://github.com/Hanip26/MokitStore.git]
    ```
2.  **Import Project**: Buka Android Studio, pilih `Open` dan arahkan ke folder hasil clone.
3.  **Sync Gradle**: Biarkan Android Studio mengunduh dependensi yang diperlukan.
4.  **Run**: Jalankan di Emulator atau Device fisik melalui tombol `Shift + F10`.

---

## 📜 Tim Pengembang

Proyek ini dikembangkan untuk memenuhi tugas Praktikum **Mobile Application Programming (PAB)**. 

1. Hanief Fahrel Wilianto (L0324016)
2. Muhammad Affan Nur Zhafariza (L0324022)
3. Muhammad Rafii Setianto (L0324026)
   
---

## Link Youtube
https://youtu.be/lq5lG4W1YxA

---
