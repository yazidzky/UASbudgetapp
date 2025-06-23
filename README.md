<!--
   _   _           _     _     _     _     _     _             _      
  | | | |         | |   (_)   | |   (_)   | |   | |           | |     
  | |_| | ___  ___| |__  _ ___| |__  _ ___| |__ | |_ _ __ ___ | | ___
  |  _  |/ _ \/ __| '_ \| / __| '_ \| / __| '_ \| __| '__/ _ \| |/ _ \
  | | | |  __/ (__| | | | \__ \ | | | \__ \ | | | |_| | | (_) | |  __/
  \_| |_/\___|\___|_| |_|_|___/_| |_|_|___/_| |_|\__|_|  \___/|_|\___|
-->

<h1 align="center">📝 Spring Boot To‑Do List</h1>
<p align="center">
  <img src="https://img.shields.io/badge/SpringBoot-3.5.0-brightgreen.svg" />
  <img src="https://img.shields.io/badge/Thymeleaf-3.1-blue.svg" />
  <img src="https://img.shields.io/badge/Database-H2-lightgrey.svg" />
</p>
<p align="center">
  <em>A lightweight, no‑frills task manager that lets you focus on <strong>getting things done</strong>.</em><br/>
  Dibangun dengan ❤️ oleh Spring Boot + Thymeleaf + H2
</p>


# 📝 To-Do List Web Application

> A powerful and simple task management app built with Spring Boot + Thymeleaf + H2 Database

---

## 📌 Deskripsi Aplikasi

Aplikasi To-Do List ini adalah aplikasi manajemen tugas berbasis web yang dibangun menggunakan:

- 🌱 **Spring Boot** sebagai backend framework
- 🖼️ **Thymeleaf** sebagai template engine
- 💾 **H2 Database** sebagai in-memory database
- 💻 **HTML, CSS, JavaScript** sebagai frontend stack

### 👤 Pengguna dapat:
✅ Membuat, melihat, memperbarui, dan menghapus tugas  
✅ Menandai tugas selesai atau belum  
✅ Menyaring tugas berdasarkan status, prioritas, atau kata kunci  
✅ Melihat statistik tugas secara real-time  
✅ Memantau tugas yang jatuh tempo hari ini  

---

## ✨ Fitur Utama

### 📋 1. Manajemen Tugas
- ➕ **Buat Tugas Baru**: Tambahkan judul, deskripsi, deadline, dan prioritas
- ✅ **Tandai Selesai**: Toggle status selesai/belum selesai
- 🗑️ **Hapus Tugas**: Hapus tugas yang tidak diperlukan

### 🔍 2. Penyaringan Tugas
- 📚 **Semua Tugas**  
- 🕓 **Tugas Pending**  
- ✅ **Tugas Selesai**  
- 🔥 **Berdasarkan Prioritas** (HIGH, MEDIUM, LOW)  
- 🔎 **Pencarian Berdasarkan Kata Kunci**  

### 📊 3. Statistik Tugas
- 📌 Jumlah tugas *pending*  
- ✅ Jumlah tugas *selesai*  
- ⏰ Jumlah tugas yang *melewati deadline*  
- 📅 Jumlah tugas yang *jatuh tempo hari ini*  

### 🗓️ 4. Panel Tugas Hari Ini
- Tampilkan semua tugas dengan deadline *hari ini*

---

## 🚀 Cara Menjalankan Aplikasi

### 🔧 Prasyarat
- ☕ Java JDK 11+
- 🧰 Maven 3.6.3+

### 📦 Langkah-langkah Instalasi

```bash
# 1. Clone repositori
git clone <URL_REPOSITORY>

# 2. Masuk ke direktori proyek
cd nama-proyek

# 3. Jalankan aplikasi
mvn spring-boot:run
````

🔗 Akses aplikasi melalui browser:

```
http://localhost:8080/tasks
```

🔎 Akses H2 Console:

```
http://localhost:8080/h2-console
```

* **JDBC URL**: `jdbc:h2:mem:todolistdb`
* **Username**: `sa`
* **Password**: *(kosong)*

---

## 📁 Struktur Kode

### 🖥️ Backend

| Folder / File                 | Deskripsi                                     |
| ----------------------------- | --------------------------------------------- |
| `Task.java`                   | Entitas tugas                                 |
| `TaskRepository.java`         | Interface untuk operasi CRUD database         |
| `TaskService.java`            | Logika bisnis aplikasi                        |
| `TaskController.java`         | Mengatur permintaan HTTP & menghubungkan view |
| `TaskNotFoundException.java`  | Exception jika tugas tidak ditemukan          |
| `GlobalExceptionHandler.java` | Penanganan exception secara global            |

### 🎨 Frontend

| Folder / File          | Deskripsi                               |
| ---------------------- | --------------------------------------- |
| `templates/tasks.html` | Halaman utama tugas                     |
| `templates/error.html` | Halaman penanganan error                |
| `static/css/`          | Styling tampilan                        |
| `static/js/`           | Fungsionalitas & interaktivitas halaman |

---

## ⚙️ Konfigurasi Aplikasi

Edit file `application.properties` untuk:

* Mengubah **port server**
* Mengatur **koneksi H2 database**
* Menyesuaikan **pengaturan Thymeleaf**
* Format **tanggal dan waktu**

---

## 🧪 Contoh Penggunaan

1. **➕ Tambahkan Tugas**
   Isi form dan klik `Add Task`.

2. **✅ Ubah Status Tugas**
   Klik ikon lingkaran untuk toggle selesai/belum selesai.

3. **🗑️ Hapus Tugas**
   Klik ikon tong sampah pada card tugas.

4. **🔍 Filter Tugas**
   Gunakan menu filter untuk menyaring berdasarkan status atau prioritas.

---

## ⚠️ Penanganan Error

Aplikasi secara otomatis menampilkan halaman error untuk:

* ❌ **404** - Tugas tidak ditemukan
* 💥 **500** - Kesalahan server internal
* 💡 Disediakan tombol kembali ke halaman utama

---

## 🖼️ Screenshot 

> ![image](https://github.com/user-attachments/assets/b8b29e19-38d0-4530-bf0b-d82a2b7228a8)
> ![image](https://github.com/user-attachments/assets/2b4681d8-dd37-46a5-8ab9-c563d54fcf34)
> ![image](https://github.com/user-attachments/assets/8f0bd9d9-9d1b-4400-bff1-22961c6a7f0f)

---

