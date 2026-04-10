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

Aplikasi ini dibangun dengan standar pengembangan Android modern:
* **Language**: Kotlin (100%)
* **UI Framework**: Jetpack Compose (Declarative UI)
* **Components**: 
    * `Scaffold` & `TopAppBar` untuk struktur halaman.
    * `LazyColumn` untuk daftar game yang efisien.
    * `State Management` (`remember`, `mutableStateOf`) untuk interaksi UI.
    * `Intent System` untuk navigasi antar Activity dan pengiriman data (Parcelable/Extra).
* **Resources**: Custom Drawables & Vector Graphics.

---

## 📁 Struktur Navigasi Proyek

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
    git clone [https://github.com/Punyaadapaa/MokitStore.git](https://github.com/Punyaadapaa/MokitStore.git)
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
