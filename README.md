
# 💸 Personal Budget Manager

> *“Take control of your finances — one transaction at a time.”*
---

## 📚 Daftar Isi

1. [📘 Deskripsi Aplikasi](#-deskripsi-aplikasi)
2. [🚀 Fitur Utama](#-fitur-utama)
3. [🧰 Teknologi yang Digunakan](#-teknologi-yang-digunakan)
4. [📂 Struktur Proyek](#-struktur-proyek)
5. [💻 Persyaratan Sistem](#-persyaratan-sistem)
6. [⚙️ Panduan Instalasi](#-panduan-instalasi)
7. [📝 Panduan Penggunaan](#-panduan-penggunaan)
8. [🔧 Konfigurasi](#-konfigurasi)
9. [🧪 Testing](#-testing)
10. [🤝 Berkontribusi](#-berkontribusi)
11. [📄 Lisensi](#-lisensi)

---

## 📘 Deskripsi Aplikasi

**Personal Budget Manager** adalah aplikasi berbasis web untuk mencatat, memantau, dan menganalisis keuangan pribadimu.
Dengan fitur pencatatan pemasukan/pengeluaran, visualisasi laporan, dan manajemen kategori, kamu bisa mengelola anggaranmu dengan mudah dan efisien.

---

## 🚀 Fitur Utama

### ✅ Manajemen Transaksi

* CRUD Transaksi: Tambah, lihat, edit, hapus
* Filter berdasarkan jenis (Income/Expense) & tanggal
* Saldo real-time

### 📂 Manajemen Kategori

* Buat, ubah, hapus kategori
* Tipe kategori: Income atau Expense

### 📊 Laporan Keuangan

* **Pie Chart**: Visualisasi pemasukan & pengeluaran per kategori
* **Tabel Data**: Daftar transaksi berdasarkan filter

---

## 🧰 Teknologi yang Digunakan

### Backend

* `Spring Boot 3.x`
* `Spring Data JPA`
* `Lombok`
* `Thymeleaf`

### Frontend

* `Bootstrap 5`
* `Chart.js`
* `Font Awesome`

### Database

* `H2 Database` (default)
* `MySQL` (optional untuk production)

---

## 📂 Struktur Proyek

```
personal-budget-manager/
├── src/
│   ├── main/
│   │   ├── java/com/example/budgetapp/
│   │   │   ├── config/
│   │   │   ├── controller/
│   │   │   ├── dto/
│   │   │   ├── exception/
│   │   │   ├── model/
│   │   │   ├── repository/
│   │   │   ├── service/
│   │   │   └── BudgetAppApplication.java
│   │   └── resources/
│   │       ├── static/
│   │       ├── templates/
│   │       └── application.properties
│   └── test/
├── pom.xml
└── README.md
```

---

## 💻 Persyaratan Sistem

| Komponen | Minimum                         |
| -------- | ------------------------------- |
| JDK      | Versi 17                        |
| Maven    | Versi 3.6.3                     |
| Browser  | Chrome / Firefox / Edge terbaru |
| RAM      | 2GB                             |
| Storage  | 500MB                           |

---

## ⚙️ Panduan Instalasi

### 1️⃣ Kloning Proyek

```bash
git clone https://github.com/username/personal-budget-manager.git
cd personal-budget-manager
```

### 2️⃣ Konfigurasi Database

```properties
# Default H2
spring.datasource.url=jdbc:h2:mem:budgetdb
spring.datasource.driverClassName=org.h2.Driver
spring.datasource.username=sa
spring.datasource.password=
spring.h2.console.enabled=true

# Optional MySQL
# spring.datasource.url=jdbc:mysql://localhost:3306/budgetdb
# spring.datasource.username=root
# spring.datasource.password=yourpassword
```

### 3️⃣ Build & Jalankan

```bash
mvn clean install
mvn spring-boot:run
```

### 4️⃣ Akses Aplikasi

* Aplikasi: [http://localhost:8080/transactions](http://localhost:8080/transactions)
* H2 Console: [http://localhost:8080/h2-console](http://localhost:8080/h2-console)

---

## 📝 Panduan Penggunaan

### 🔹 Tambah Transaksi

1. Klik "Add Transaction"
2. Isi form (nama, jumlah, kategori)
3. Klik "Save Transaction"

### 🔹 Filter Transaksi

1. Pilih jenis transaksi atau rentang tanggal
2. Klik "Apply Filter"

### 🔹 Kelola Kategori

* Akses: `http://localhost:8080/categories`
* Tambah/Edit/Hapus sesuai kebutuhan

### 🔹 Laporan Keuangan

* Akses: `http://localhost:8080/reports`
* Lihat pie chart dan tabel laporan

---

## 🔧 Konfigurasi

Contoh tambahan untuk `application.properties`:

```properties
# Server port
server.port=8080

# Thymeleaf
spring.thymeleaf.cache=false
spring.thymeleaf.prefix=classpath:/templates/
spring.thymeleaf.suffix=.html
```

---

## 🧪 Testing

Jalankan testing:

```bash
mvn test
```

Testing mencakup:

* Unit test service
* Integration test controller
* Validasi data

---

## 🤝 Berkontribusi

Punya ide keren? Yuk kontribusi!
Langkah-langkah:

1. Fork repo
2. Buat branch (`git checkout -b fitur-baru`)
3. Commit (`git commit -am 'Menambahkan fitur baru'`)
4. Push (`git push origin fitur-baru`)
5. Buat Pull Request



## 🖼️ Screenshot 

> ![image](https://github.com/user-attachments/assets/b8b29e19-38d0-4530-bf0b-d82a2b7228a8)
> ![image](https://github.com/user-attachments/assets/2b4681d8-dd37-46a5-8ab9-c563d54fcf34)
> ![image](https://github.com/user-attachments/assets/8d3df46e-3238-4641-80ee-595941204034)
> ![image](https://github.com/user-attachments/assets/8f0bd9d9-9d1b-4400-bff1-22961c6a7f0f)

---

