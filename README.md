

# 🕋 Aplikasi Tata Cara Sholat

Aplikasi Android berbasis Java yang dirancang sebagai panduan ibadah lengkap bagi umat Muslim. Aplikasi ini menyajikan tuntunan langkah demi langkah pengerjaan sholat, niat sholat fardhu, serta kumpulan doa harian dengan antarmuka yang bersih dan mudah digunakan.

## ✨ Fitur Utama

* **Panduan Sholat Visual**: Menampilkan langkah-langkah gerakan sholat dari Takbiratul Ihram hingga Salam, lengkap dengan gambar ilustrasi, teks bacaan Arab, Latin, dan terjemahannya.
* **Niat Sholat Fardhu**: Daftar niat sholat lima waktu (Subuh, Dzuhur, Ashar, Maghrib, Isya) yang disajikan dengan ringkas.
* **Kumpulan Doa Harian**: Menu khusus yang berisi berbagai doa sehari-hari untuk melengkapi ibadah pengguna.
* **Navigasi Bottom Navigation**: Memudahkan pengguna berpindah antar menu utama (Beranda, Panduan, dan Doa) secara cepat.
* **Antarmuka Responsif**: Menggunakan komponen Material Design 3 untuk tampilan yang modern dan nyaman di mata.

## 🛠️ Teknologi & Library

* **Bahasa Pemrograman**: Java.
* **UI Framework**: Material Design Components (CoordinatorLayout, RecyclerView, BottomNavigationView).
* **Arsitektur**: Menggunakan `Adapter` pattern untuk pengelolaan daftar data yang dinamis (`DoaAdapter`, `GuideAdapter`).
* **Resources**: Data gambar dan teks dikelola secara lokal di dalam folder `res/drawable` dan kelas model Java.

## 📂 Struktur Proyek Penting

* `MainActivity.java`: Mengatur logika navigasi utama dan perpindahan fragment/menu.
* `PrayerStep.java` & `Doa.java`: Kelas model untuk menstrukturkan data panduan sholat dan doa.
* `res/layout/`: Berisi tata letak XML untuk berbagai komponen antarmuka.
* `res/drawable/`: Menyimpan aset visual seperti gambar gerakan sholat (`img_takbir`, `img_ruku`, dsb).

---

## 📸 Panduan Screenshot Aplikasi

Untuk membuat dokumentasi visual yang menarik, disarankan mengambil screenshot pada bagian berikut:

| **Halaman Beranda** | **Daftar Panduan** | **Halaman Doa** |
| --- | --- | --- |
|  |  |  |
| Menampilkan ringkasan niat sholat fardhu dan menu navigasi bawah. | Menampilkan daftar gerakan sholat beserta gambar ilustrasinya. | Menampilkan daftar doa-doa harian dalam bentuk list yang rapi. |

---

## 🚀 Cara Menjalankan

1. *Clone* atau unduh repositori ini.
2. Buka proyek menggunakan **Android Studio** (Versi terbaru direkomendasikan).
3. Pastikan konfigurasi Gradle sinkron dengan benar.
4. Hubungkan perangkat Android atau gunakan Emulator (Minimal Android API 33).
5. Klik tombol **Run** untuk memasang aplikasi.

## 📝 Lisensi

Proyek ini dikembangkan oleh **Hafiz Fauzi Nugraha** bertujuan sebagai media pembelajaran ibadah digital.
