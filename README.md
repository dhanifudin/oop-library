# Latihan OOP: Aplikasi Konsol Perpustakaan (Pertemuan 1 sampai 7)

## Aturan

- Jangan ubah `src/test/**`, `.github/**`, dan `.wakatime-project`.
- Ikuti diagram persis: nama kelas, field, constructor, dan method.
- Buat semua field `private`, kecuali `title` dan `year` di `LibraryItem` (`protected`).
- Pakai array biasa. Jangan pakai `List` atau `ArrayList`.
- Jangan pakai `System.out.println` di `Library` dan kelas model. Tampilan hanya di `Main` dan `LibraryApp`.
- Nyalakan WakaTime setiap kali mengerjakan (lihat Langkah 0).
- Kerjakan sendiri. Diskusi konsep boleh. Kode dan laporan harus hasil kerjamu.

## Langkah 0: Pasang WakaTime (wajib, sebelum menulis kode apa pun)

WakaTime mencatat waktu kamu mengetik kode. Dosen memakainya untuk menilai usaha.

1. Buat akun gratis di [wakatime.com](https://wakatime.com).
2. Salin API key dari [wakatime.com/settings/api-key](https://wakatime.com/settings/api-key). Jangan bagikan key ini.
3. Pasang plugin di editormu:
   - **NetBeans**: `Tools > Plugins`, cari "WakaTime". Jika tidak ada, ikuti [wakatime.com/netbeans](https://wakatime.com/netbeans).
   - **VS Code**: pasang ekstensi `WakaTime` (`WakaTime.vscode-wakatime`).
   - **IntelliJ IDEA**: `Settings > Plugins`, cari "WakaTime".
4. Tempel API key saat plugin memintanya.
5. Ketik kode beberapa menit, lalu buka [wakatime.com/dashboard](https://wakatime.com/dashboard). Pastikan project **oop-library** muncul.

Ketentuan:

- `.wakatime-project` berisi `oop-library`. Jangan ubah atau hapus.
- Waktu pengerjaan tanpa plugin tidak dihitung.
- Sertakan screenshot dashboard di laporan (lihat [Laporan (PDF)](#laporan-pdf)).

## Daftar Isi

1. [Aturan](#aturan)
2. [Langkah 0: Pasang WakaTime](#langkah-0-pasang-wakatime-wajib-sebelum-menulis-kode-apa-pun)
3. [Studi Kasus](#studi-kasus)
4. [Memulai](#memulai)
5. [Membuka Proyek](#membuka-proyek)
6. [Cara Membaca Diagram dan Petunjuk](#cara-membaca-diagram-dan-petunjuk)
7. [Bagian 1 sampai 7](#bagian-1-pertemuan-1-pengantar)
8. [Coba Aplikasinya](#coba-aplikasinya)
9. [Laporan (PDF)](#laporan-pdf)
10. [Pengumpulan](#pengumpulan)
11. [Penilaian](#penilaian)

## Studi Kasus

Perpustakaan Polinema meminjamkan tiga jenis koleksi:

- **Buku**: dipinjam 14 hari, punya ISBN dan penulis.
- **DVD**: dipinjam 3 hari, punya durasi.
- **Majalah**: dipinjam 7 hari, punya nomor edisi.

Setiap **anggota** punya kartu perpustakaan dan boleh meminjam paling banyak **3** koleksi. Petugas memakai aplikasi konsol untuk menambah koleksi, mendaftarkan anggota, meminjamkan, menerima pengembalian, dan mencari koleksi.

## Memulai

Pastikan WakaTime aktif ([Langkah 0](#langkah-0-pasang-wakatime-wajib-sebelum-menulis-kode-apa-pun)).

1. Di GitHub, klik **Use this template**, lalu **Create a new repository**.
2. Pilih **Private**, lalu ikuti arahan Dosen tentang siapa yang kamu undang.
3. Clone repositori barumu.
4. Commit dan push setiap selesai satu bagian.
5. Buka tab **Actions**. Autograder berjalan di setiap push dan menampilkan nilai kodemu.

Jalankan semua tes di komputermu:

```
mvn -q test
```

Jalankan satu kelas tes:

```
mvn -q test -Dtest=P02BookTest
```

Baca pesan tes yang gagal. Pesannya menjelaskan apa yang kurang.

## Membuka Proyek

**NetBeans**: `File > Open Project`, pilih folder repositori. Jalankan satu file dengan `Run File` atau `Shift+F6`.

**VS Code**: buka folder, pasang "Extension Pack for Java", lalu klik `Run` di atas `main`.

**Command line** (butuh JDK 17 atau lebih dan Maven):

```
mvn -q compile exec:java
```

Perintah ini menjalankan `Main`, satu-satunya titik awal program.

## Cara Membaca Diagram dan Petunjuk

Diagram kelas adalah spesifikasi utama. Semua kelas, field, constructor, dan method yang kamu butuhkan ada di diagram.

| Simbol | Arti |
|---|---|
| `+` | `public` |
| `-` | `private` |
| `#` | `protected` |
| `nama : Tipe` | field atau parameter bernama `nama` bertipe `Tipe` |
| `metode() : Tipe` | method yang mengembalikan `Tipe` |
| `<<buat kelas ini>>` | kelas belum ada di starter, kamu yang membuatnya |
| garis dengan panah terbuka `-->` | asosiasi |
| garis dengan belah ketupat kosong `o--` | agregasi |
| garis dengan belah ketupat penuh `*--` | komposisi |
| garis putus-putus `..>` | dependensi |
| panah segitiga kosong `<\|--` | inheritance (`extends`) |
| `0..5`, `1`, `*` | multiplicity (jumlah objek) |

Baca per kotak kelas: field di atas, constructor dan method di bawah. Lalu baca garis antar kelas.

Buka Petunjuk 1 dulu. Buka Petunjuk 2 hanya jika masih buntu.

---

## Bagian 1 (Pertemuan 1): Pengantar

### Aturan yang dicek autograder

- Baris **pertama** output `Main` adalah persis `Welcome to Polinema Library`.
- Setelah baris itu, kamu bebas menambah baris lain.

### Pertanyaan pemandu

- Apa yang terjadi saat kamu menekan Run: apa yang dikerjakan compiler, dan apa yang dikerjakan JVM?
- Method mana yang pertama kali dijalankan Java, dan mengapa harus `static`?

<details>
<summary>Petunjuk 1</summary>

- Cek `java -version` di terminal. Kamu butuh versi 17 atau lebih.
- Di Java, perintah untuk menampilkan teks ke layar berbentuk `System.out.println("teks kamu");`.
- Teks yang ingin ditampilkan ditulis di dalam tanda kutip ganda. Ganti `teks kamu` dengan teks dari soal.
- Perintah ini ditulis di dalam `main`, di antara kurung kurawalnya.

</details>

<details>
<summary>Petunjuk 2 (langkah demi langkah, buka jika Petunjuk 1 belum cukup)</summary>

1. Buka `Main.java`. Cari bagian `main`. Tulis kodemu **di dalam kurung kurawalnya**, menggantikan komentar `TODO`.
2. Satu baris perintah cukup. Bentuknya sudah ada di Petunjuk 1.
3. Isi teks di antara tanda kutip ganda. Huruf besar-kecil, spasi, dan ejaan harus persis sama dengan `Welcome to Polinema Library`.
4. Pastikan baris perintah diakhiri **titik koma**.
5. Jalankan `Main` (di NetBeans: klik kanan file, `Run File`, atau `Shift+F6`). Teks yang kamu tulis muncul di jendela Output.
6. Jika ada garis merah atau error, periksa kesalahan yang paling sering terjadi:
   - `System` ditulis dengan huruf kecil (Java membedakan huruf besar dan kecil).
   - Tanda kutip tidak berpasangan.
   - Titik koma terlupa.
   - Kode ditulis di luar kurung kurawal `main`.
7. Cek hasilnya: baris pertama output hanya berisi teks itu, tanpa tambahan spasi atau karakter lain.

</details>

### Telusuri

Tidak dinilai, tulis jawabannya di laporan: sebutkan 5 benda di perpustakaan yang menurutmu adalah *objek*. Untuk masing-masing, tulis satu *data* yang dimilikinya dan satu *aksi* yang bisa dilakukannya.

### Cek dirimu

`P01MainOutputTest` lulus.

---

## Bagian 2 (Pertemuan 2): Class dan Object

![Diagram Bagian 2](docs/p02-author-book.png)

### Aturan yang dicek autograder

- Constructor menyimpan semua parameternya, dan getter mengembalikan nilai yang sama.
- `Author.getInfo()` mengembalikan teks berbentuk `nama (negara)`. Contoh: `Andrea Hirata (Indonesia)`.
- Buku yang baru dibuat **tersedia**.
- `checkOut()` berhasil (`true`) satu kali. Selama buku masih dipinjam, memanggilnya lagi menghasilkan `false`.
- `returnItem()` membuat buku bisa dipinjam lagi.
- Dua objek `Book` tidak saling memengaruhi.
- Di bagian ini field boleh `public` (seperti di diagram). Di Bagian 3 kamu akan menutupnya.

### Pertanyaan pemandu

- Data apa saja yang perlu diingat setiap objek `Book`? Mana yang berasal dari parameter, mana yang diatur sendiri oleh objek?
- Agar objek tahu sedang dipinjam atau tidak, apa yang harus diingatnya?
- Di constructor, nama parameter sama dengan nama field. Bagaimana Java membedakannya?

<details>
<summary>Petunjuk 1</summary>

- Deklarasikan field di dalam kelas, di luar method. Tipe field bisa dibaca dari diagram.
- Kata kunci `this` menunjuk ke objek yang sedang dikerjakan.
- Status "dipinjam atau tidak" cocok disimpan sebagai tipe `boolean`. Apa nilai awalnya?
- Method yang mengembalikan `boolean` boleh punya dua `return` yang berbeda. Cek kondisi lebih dulu.
- Di `Main`, coba buat dua objek `Book` dan cetak datanya. Ini membantu kamu melihat bahwa objek berdiri sendiri.

</details>

<details>
<summary>Petunjuk 2 (langkah per kelas, buka jika Petunjuk 1 belum cukup)</summary>

- **`Author`**: (1) buat dua field, nama dan negara, keduanya bertipe `String`. (2) Constructor menyalin setiap parameter ke field yang bernama sama. Pakai `this.` di sisi kiri agar Java tahu mana field dan mana parameter. (3) Setiap getter hanya mengembalikan field-nya. (4) `getInfo` menyusun teks dari nama, sebuah spasi, tanda kurung buka, negara, dan tanda kurung tutup.
- **`Book`**: (1) buat empat field: `isbn` dan `title` bertipe `String`, `year` bertipe `int`, dan satu `boolean` bernama `available`. (2) Constructor menyalin `isbn`, `title`, dan `year` dari parameter. Field `available` tidak punya parameter. Karena buku baru langsung tersedia, isi dengan nilai `true`. (3) Setiap getter hanya mengembalikan field-nya. `isAvailable` mengembalikan `available`.
- **`checkOut`**: (1) jika `available` bernilai `false`, hentikan dengan `return false`. (2) Jika tidak, ubah `available` menjadi `false` dan `return true`. Dua jalur `return` ini sudah cukup, tanpa `else`.
- **`returnItem`**: satu baris yang mengubah `available` menjadi `true`. Method ini bertipe `void`, jadi tanpa `return` nilai.
- Cara memeriksa tanpa tes: di `Main`, buat dua `Book`. Panggil `checkOut()` pada yang pertama dua kali dan cetak hasilnya (`true`, lalu `false`). Cetak `isAvailable()` kedua buku dan pastikan hanya yang pertama berubah.

</details>

### Telusuri

Tidak dinilai: perhatikan kode ini, lalu tebak outputnya.

```java
Book a = new Book("1", "Clean Code", 2008);
Book b = a;
b.checkOut();
System.out.println(a.isAvailable());
Book c = new Book("2", "Refactoring", 1999);
System.out.println(c.isAvailable());
```

Mengapa hasil baris pertama dan kedua berbeda? Gambar `a`, `b`, dan `c` di stack, dan objeknya di heap.

### Cek dirimu

`P02AuthorTest` dan `P02BookTest` lulus.

---

## Bagian 3 (Pertemuan 3): Enkapsulasi

![Diagram Bagian 3](docs/p03-encapsulation.png)

### Aturan yang dicek autograder

Semua kelas:

- Semua field `private`. Bandingkan diagram Bagian 3 dengan Bagian 2.

`Book`:

- Judul `null`, kosong, atau hanya spasi **ditolak**. Tahun 0 atau negatif **ditolak**.
- Penolakan berarti `IllegalArgumentException` dilempar dan nilai lama **tetap**.
- Constructor juga menolak data tidak valid. `isbn` tidak boleh kosong.
- `isbn` read-only (tanpa setter). Status tersedia tidak punya setter dan hanya berubah lewat `checkOut()` dan `returnItem()`.

`Member` (kelas ini kamu isi dari stub sesuai diagram):

- `memberId` dan `loanCount` read-only (tanpa setter). `memberId` dan nama tidak boleh kosong.
- `setName` menolak nama kosong dan menjaga nama lama.
- Jumlah pinjaman selalu antara 0 dan 3. `addLoan()` dan `returnLoan()` mengembalikan `true` jika berhasil dan `false` jika sudah di batas.
- `canBorrow()` menjawab apakah anggota masih boleh meminjam.

### Pertanyaan pemandu

- Jika `Member` punya `public int loanCount`, baris kode apa yang merusak aturan "maksimal 3"? Bagaimana `private` mencegahnya?
- Constructor dan setter punya aturan validasi yang sama. Bagaimana menghindari menulis aturannya dua kali?
- Apakah `canBorrow()` perlu field sendiri? Apa yang terjadi jika datanya tidak sinkron dengan `loanCount`?
- Mengapa `memberId` tidak boleh punya setter?

<details>
<summary>Petunjuk 1</summary>

- Ubah modifier field, lalu lihat apa yang error di `Main` kamu. Itu pelajaran enkapsulasinya.
- Urutan aman di setter: **periksa dulu**, baru isi field. Kalau tidak valid, hentikan sebelum field disentuh.
- Untuk menolak data, ingat kata kunci `throw` dan tipe exception yang disebut di atas.
- Constructor boleh memanggil setter milik kelasnya sendiri.
- Untuk teks kosong, class `String` punya method yang menjawab apakah teks kosong atau hanya spasi.
- `canBorrow()` bisa dihitung langsung dari `loanCount` setiap kali dipanggil.

</details>

<details>
<summary>Petunjuk 2 (langkah per kelas, buka jika Petunjuk 1 belum cukup)</summary>

- **Langkah awal**: ubah semua field `Author` dan `Book` menjadi `private`. Jalankan `P02AuthorTest` dan `P02BookTest`: harus tetap lulus karena getter sudah ada. Jika `Main` kamu error, ganti akses langsung ke field dengan getter.
- **`Book.setTitle`**: (1) jika `title` bernilai `null`, lempar `IllegalArgumentException` (cek `null` **lebih dulu**, karena memanggil method pada `null` menimbulkan error lain). (2) Jika `title` hanya berisi spasi atau kosong, lempar exception yang sama. Method `isBlank()` milik `String` menjawab ini. (3) Jika lolos kedua pemeriksaan, baru isi field.
- **`Book.setYear`**: jika `year` kurang dari atau sama dengan 0, lempar `IllegalArgumentException`. Jika tidak, isi field.
- **`Book` constructor**: (1) periksa `isbn` dengan pola yang sama dengan judul (`null` atau kosong ditolak). (2) Isi `isbn`. (3) Panggil `setTitle(title)` dan `setYear(year)` untuk judul dan tahun, bukan mengisi field langsung, supaya aturannya tidak ditulis dua kali. (4) Status `available` tetap `true`.
- **`Member` field**: `memberId` dan `name` bertipe `String`, `loanCount` bertipe `int` dengan nilai awal 0. Semuanya `private`.
- **`Member` constructor**: (1) periksa `memberId` (`null` atau kosong ditolak). (2) Isi `memberId`. (3) Panggil `setName(name)` agar aturan nama tidak ditulis dua kali.
- **`Member.setName`**: pola yang sama dengan `Book.setTitle`.
- **Tanpa setter**: tulis hanya getter untuk `memberId` dan `loanCount`. Perubahan `loanCount` hanya lewat `addLoan` dan `returnLoan`.
- **`canBorrow`**: kembalikan hasil perbandingan `loanCount` dengan batas 3. Tidak ada field baru.
- **`addLoan`**: (1) jika `canBorrow()` bernilai `false`, `return false`. (2) Jika tidak, naikkan `loanCount` satu dan `return true`. Manfaatkan `canBorrow()` supaya angka batas hanya ada di satu tempat.
- **`returnLoan`**: (1) jika `loanCount` sama dengan 0, `return false`. (2) Jika tidak, turunkan satu dan `return true`.

</details>

### Telusuri

Tidak dinilai: tulis satu baris kode di `Main` yang akan merusak aturan "maksimal 3 pinjaman" jika field `loanCount` `public`. Mengapa baris itu tidak bisa dikompilasi setelah field menjadi `private`?

### Cek dirimu

`P03EncapsulationTest` dan `P03MemberTest` lulus. Tes Bagian 2 harus tetap lulus.

---

## Bagian 4 (Pertemuan 4): Relasi Class

![Diagram Bagian 4](docs/p04-relations.png)

### Aturan yang dicek autograder

`Book` dan `Author` (asosiasi):

- Buku baru belum punya penulis. `getAuthor()` mengembalikan objek `Author` **yang sama** dengan yang diberikan ke `setAuthor`, dan dua buku boleh berbagi satu `Author`.

`Member` dan `LibraryCard` (komposisi):

- Setiap `Member` punya kartu dengan nomor berbentuk `CARD-` diikuti `memberId`. Contoh: `CARD-M001`.
- Kartu **tidak** diberikan dari luar. `Member` tidak punya constructor yang menerima `LibraryCard`. Dua anggota punya dua kartu berbeda.

`Shelf` (agregasi):

- Kapasitas rak **5** buku. `addBook` mengembalikan `false` jika rak penuh atau bukunya `null`.
- `findByIsbn` mengembalikan objek `Book` yang sama (bukan salinan), atau `null` jika tidak ada.
- `countAvailable` menghitung buku yang saat ini tersedia.

`Librarian` (dependensi):

- Tidak punya field sama sekali.
- `lend(member, book)` berhasil hanya jika anggota boleh meminjam **dan** buku tersedia. Jika berhasil, buku dipinjam dan pinjaman anggota bertambah. Jika gagal, tidak ada yang berubah.
- `receive(member, book)` berhasil hanya jika buku sedang dipinjam dan anggota punya pinjaman. Jika berhasil, buku tersedia lagi dan pinjaman anggota berkurang.

### Pertanyaan pemandu

Jawab untuk **setiap** garis relasi di diagram:

- Siapa yang **membuat** objek di ujung garis: kelas ini sendiri, atau kode di luarnya?
- Jika pemilik objek dibuang, apakah objek di ujung garis ikut hilang?
- Apakah objek di ujung garis perlu disimpan sebagai **field**, atau cukup muncul sebagai **parameter** method?
- Apa arti `0..5` dan `0..1` pada garis tersebut?

<details>
<summary>Petunjuk 1</summary>

- Relasi yang disimpan sebagai field berarti kelas **mengingat** objek itu. Relasi dependensi tidak mengingat apa pun.
- Pada komposisi, field diisi **di dalam constructor**, bukan dari parameter constructor.
- Array di Java punya ukuran tetap. Kamu butuh satu variabel lagi untuk tahu berapa slot yang sudah terisi.
- `findByIsbn`: telusuri hanya slot yang terisi. Bandingkan teks dengan `equals`, bukan `==`.
- `Librarian`: method milik `Member` dan `Book` yang sudah ada sudah menjawab sebagian besar pertanyaanmu. Panggil, jangan tulis ulang aturannya.
- Urutan pemeriksaan di `lend` penting. Apa yang terjadi jika kamu meminjam bukunya dulu, baru sadar anggotanya sudah mencapai batas?

</details>

<details>
<summary>Petunjuk 2 (langkah per kelas, buka jika Petunjuk 1 belum cukup)</summary>

- **`Book` dan `Author` (asosiasi)**: (1) tambahkan field bertipe `Author` di `Book`, `private`. Tidak ada yang mengisinya di constructor, jadi nilai awalnya `null`. (2) `getAuthor` mengembalikan field itu. (3) `setAuthor` hanya **menyimpan referensi** yang diterima. Jangan membuat `Author` baru di dalamnya, supaya dua buku bisa menunjuk ke objek yang sama.
- **`LibraryCard`**: satu field `private` untuk nomor. Constructor menyimpannya, dan `getNumber` mengembalikannya.
- **`Member` (komposisi)**: (1) tambahkan field bertipe `LibraryCard`. (2) Di constructor `Member`, setelah semua validasi lolos, buat objek `LibraryCard` dengan `new` dan simpan di field. Nomornya dibentuk dari teks `CARD-` yang digabung dengan `memberId`. (3) `getCard` mengembalikan field. Jangan menambahkan parameter kartu ke constructor, dan jangan membuat kartu baru setiap `getCard` dipanggil.
- **`Shelf`**: (1) field: kode rak, array `Book` berukuran 5, dan penghitung jumlah buku terisi dengan nilai awal 0. (2) `addBook`: jika bukunya `null` atau penghitung sudah sama dengan panjang array, kembalikan `false`. Jika tidak, simpan buku di slot yang ditunjuk penghitung, naikkan penghitung, dan kembalikan `true`. (3) `getBookCount` mengembalikan penghitung. (4) `findByIsbn`: ulangi dari slot 0 sampai sebelum penghitung. Jika ISBN buku di slot itu sama dengan yang dicari (pakai `equals`), kembalikan buku itu. Jika perulangan selesai, kembalikan `null`. (5) `countAvailable`: ulangi dengan batas yang sama. Setiap buku yang tersedia menambah satu ke hitungan.
- **`Librarian` (dependensi)**: tanpa field dan tanpa constructor khusus. Method-nya menerima `Member` dan `Book` sebagai parameter dan tidak menyimpannya.
  - `lend`: (1) jika anggota tidak boleh meminjam, kembalikan `false`. (2) Pinjam bukunya. Jika gagal, kembalikan `false`. (3) Tambah pinjaman anggota, lalu kembalikan `true`. Cek anggota **sebelum** mengubah buku.
  - `receive`: (1) jika buku tidak sedang dipinjam, kembalikan `false`. (2) Kurangi pinjaman anggota. Jika gagal (tidak punya pinjaman), kembalikan `false`. (3) Kembalikan bukunya, lalu kembalikan `true`.

</details>

<details>
<summary>Kerangka kode (belum lengkap, buka jika Petunjuk 2 belum cukup)</summary>

Kerangka ini **belum bisa dikompilasi**. Ganti setiap `____` dengan kode yang benar, lalu hapus komentar yang tidak perlu.

```java
// LibraryCard.java
package id.ac.polinema.library;

public class LibraryCard {
    private String number;

    public LibraryCard(String number) {
        this.number = ____;
    }

    public String getNumber() {
        return ____;
    }
}
```

```java
// Book.java (tambahan)
private Author author;   // belum diisi, jadi nilainya null

public Author getAuthor() {
    return ____;
}

public void setAuthor(Author author) {
    this.author = ____;   // simpan referensinya, jangan membuat Author baru
}
```

```java
// Member.java (tambahan)
private LibraryCard card;

// di constructor, setelah semua validasi:
this.card = new LibraryCard("____" + memberId);

public LibraryCard getCard() {
    return ____;
}
```

```java
// Shelf.java
package id.ac.polinema.library;

public class Shelf {
    private String code;
    private Book[] books = new Book[____];   // kapasitas rak
    private int count;                        // jumlah slot terisi, awalnya 0

    public Shelf(String code) {
        this.code = code;
    }

    public String getCode() { return code; }

    public int getBookCount() {
        return ____;
    }

    public boolean addBook(Book book) {
        if (book == null || count == ____) {
            return false;
        }
        books[count] = ____;
        count++;
        return true;
    }

    public Book findByIsbn(String isbn) {
        for (int i = 0; i < ____; i++) {
            if (books[i].getIsbn().equals(____)) {
                return books[i];
            }
        }
        return ____;
    }

    public int countAvailable() {
        int total = 0;
        for (int i = 0; i < count; i++) {
            if (books[i].____()) {
                total++;
            }
        }
        return total;
    }
}
```

```java
// Librarian.java
package id.ac.polinema.library;

public class Librarian {

    public boolean lend(Member member, Book book) {
        if (!member.____()) {
            return false;
        }
        if (!book.____()) {
            return false;
        }
        member.____();
        return true;
    }

    public boolean receive(Member member, Book book) {
        if (book.____()) {          // buku tidak sedang dipinjam?
            return false;
        }
        if (!member.____()) {
            return false;
        }
        book.____();
        return true;
    }
}
```

</details>

### Telusuri

Tidak dinilai: jika objek `Member` dibuang, apa yang terjadi pada `LibraryCard`-nya? Jika objek `Shelf` dibuang, apa yang terjadi pada `Book` di dalamnya? Jelaskan perbedaan keduanya dengan kata-katamu sendiri.

### Cek dirimu

`P04AssociationTest`, `P04ShelfAggregationTest`, `P04MemberCardCompositionTest`, dan `P04LibrarianDependencyTest` lulus.

---

## Bagian 5 (Pertemuan 6): Inheritance

![Diagram Bagian 5](docs/p06-inheritance.png)

### Aturan yang dicek autograder

- `Book`, `Dvd`, dan `Magazine` adalah subclass langsung dari `LibraryItem`.
- `LibraryItem` memvalidasi `title` dan `year` seperti `Book` di Bagian 3. Field `title` dan `year` bersifat `protected`, dan tidak ada field `public`.
- `Book` tidak lagi menyimpan `title`, `year`, dan status tersedia sendiri, dan tidak menulis ulang method yang sama dengan `LibraryItem`.
- `Dvd` dan `Magazine` menyimpan data khususnya sesuai diagram (`private`). Getter judul dan tahun serta `checkOut`/`returnItem` dipakai dari `LibraryItem`.
- Validasi setter ikut berlaku di semua subclass.
- Semua tes Bagian 2 sampai 4 masih lulus.

### Pertanyaan pemandu

- Bandingkan `Book` di diagram Bagian 4 dengan `Dvd` di diagram Bagian 5. Apa yang **sama** di keduanya? Apa yang **khusus**?
- Kalimat "`Dvd` adalah sebuah `LibraryItem`" masuk akal. Apakah "`Library` adalah sebuah `Book`" juga masuk akal?
- Mengapa `title` dan `year` ditandai `#` dan bukan `-`?
- Jika `LibraryItem` punya constructor yang meminta `title` dan `year`, siapa yang harus mengisinya saat sebuah `Dvd` dibuat?

<details>
<summary>Petunjuk 1</summary>

- Kata kunci `extends` menyatakan hubungan IS-A.
- Constructor tidak diwariskan. Subclass memanggil constructor parent dengan `super(...)`, dan harus menjadi **baris pertama**.
- `protected` bisa diakses subclass, tetapi tidak oleh kelas lain di luar paket dan keluarga.
- Kerjakan bertahap: buat `LibraryItem`, pindahkan satu bagian, jalankan tes, ulangi. Jangan memindahkan semuanya sekaligus.
- Jika tes lama merah setelah memindahkan sesuatu, sebuah method atau constructor kemungkinan hilang atau berubah.

</details>

<details>
<summary>Petunjuk 2 (urutan kerja refactoring, buka jika Petunjuk 1 belum cukup)</summary>

Kerjakan urut. Jalankan seluruh tes setelah **setiap** langkah. Hasilnya harus tetap sama dengan sebelum langkah itu, kecuali tes `P06InheritanceTest` yang baru lulus di akhir.

1. **Buat `LibraryItem` dan salin dulu, jangan hapus dulu.** Buat file `LibraryItem.java`. Salin dari `Book` ke sana: field `title`, `year`, dan `available`, serta method `getTitle`, `setTitle`, `getYear`, `setYear`, `isAvailable`, `checkOut`, dan `returnItem`. Ubah `title` dan `year` menjadi `protected`. Tulis constructor `LibraryItem(String title, int year)` yang mengisi judul dan tahun lewat setter-nya dan membuat status `available` bernilai `true`.
2. **Hubungkan `Book` ke `LibraryItem`.** Ubah deklarasi kelas `Book` menjadi `extends LibraryItem`. Di constructor `Book`, baris pertamanya memanggil `super` dengan judul dan tahun. Setelah itu periksa `isbn` dan isi `isbn`.
3. **Hapus duplikat dari `Book`.** Hapus field `title`, `year`, `available` dan semua method yang sudah ada di `LibraryItem`. `Book` tinggal menyimpan `isbn`, `author`, dan method yang berhubungan dengan keduanya. Jalankan tes Bagian 2 sampai 4. Semua harus tetap lulus.
4. **Buat `Dvd`.** `extends LibraryItem`, satu field `private` untuk durasi. Constructor menerima `title`, `year`, dan durasi. Baris pertamanya memanggil `super` dengan judul dan tahun, lalu menyimpan durasi. Tambahkan getter durasi.
5. **Buat `Magazine`** dengan pola yang sama dengan `Dvd`, tetapi menyimpan nomor edisi.
6. Jika muncul error "constructor LibraryItem ... cannot be applied to given types", artinya sebuah subclass belum memanggil `super(...)` dengan argumen yang sesuai. Periksa constructor subclass yang disebut di pesan error.

</details>

<details>
<summary>Kerangka kode (belum lengkap, buka jika Petunjuk 2 belum cukup)</summary>

Kerangka ini **belum bisa dikompilasi**. Ganti setiap `____` dengan kode yang benar, lalu hapus komentar yang tidak perlu.

```java
// LibraryItem.java
package id.ac.polinema.library;

public class LibraryItem {
    protected String title;
    protected int year;
    private boolean available;

    public LibraryItem(String title, int year) {
        setTitle(title);
        setYear(____);
        this.available = ____;
    }

    // Pindahkan dari Book ke sini:
    // getTitle, setTitle, getYear, setYear, isAvailable, checkOut, returnItem
}
```

```java
// Book.java
public class Book extends ____ {
    private String isbn;
    private Author author;

    public Book(String isbn, String title, int year) {
        ____(title, year);                // baris pertama
        if (isbn == null || ____) {
            throw new IllegalArgumentException("ISBN must not be blank");
        }
        this.isbn = isbn;
    }

    // getIsbn, getAuthor, dan setAuthor tetap di Book
}
```

```java
// Dvd.java
public class Dvd extends ____ {
    private int durationMinutes;

    public Dvd(String title, int year, int durationMinutes) {
        ____(title, year);
        this.durationMinutes = ____;
    }

    public int getDurationMinutes() {
        return ____;
    }
}
```

```java
// Magazine.java
public class Magazine extends ____ {
    private int issueNumber;

    public Magazine(String title, int year, int issueNumber) {
        ____;                             // panggil constructor parent
        ____;                             // simpan nomor edisi
    }

    // getIssueNumber()
}
```

</details>

### Telusuri

Tidak dinilai: apa yang diwarisi `Dvd` dari `LibraryItem`, dan apa yang tidak? Mengapa constructor `LibraryItem` tidak ikut diwariskan, tetapi tetap harus dipanggil saat `Dvd` dibuat?

### Cek dirimu

`P06InheritanceTest` lulus, dan tes Bagian 2 sampai 4 tidak ada yang rusak.

---

## Bagian 6 (Pertemuan 7): Overriding dan Overloading

![Diagram Bagian 6](docs/p07-override-overload.png)

### Aturan yang dicek autograder

Method baru di `LibraryItem` (baca daftarnya di diagram):

- `loanDays()` mengembalikan **7**.
- `describe()` mengembalikan deskripsi singkat, dan `toString()` mengembalikan hasil yang sama dengan `describe()`.
- `extendLoan()` menambah perpanjangan **7** hari. `extendLoan(int days)` menambah sebanyak `days`, dan menolak 0 atau negatif dengan `IllegalArgumentException`.
- `getTotalLoanDays()` adalah lama pinjam ditambah semua perpanjangan.

Nilai yang diharapkan:

| Objek | `loanDays()` | `describe()` |
|---|---|---|
| `LibraryItem("Generic", 2000)` | 7 | `Generic (2000)` |
| `Book` tanpa penulis | 14 | `Clean Code (2008) by Unknown` |
| `Book` dengan penulis Robert Martin | 14 | `Clean Code (2008) by Robert Martin` |
| `Dvd("Inception", 2010, 148)` | 3 | `Inception (2010) [148 min]` |
| `Magazine("Tempo", 2024, 7)` | 7 | `Tempo (2024)` |

Constructor baru (lihat diagram):

- `Book(isbn, title, year, author)` langsung mengisi penulis.
- `Magazine(title, year)` memberi nomor edisi **1**. Versi 3 parameter tetap berfungsi.

Struktur:

- `Book` dan `Dvd` meng-override `loanDays()`. `Magazine` **tidak** meng-override-nya.

### Pertanyaan pemandu

- Bandingkan `describe()` milik `Book` dan milik `LibraryItem`. Bagian mana yang sudah dikerjakan parent? Perlukah kamu menulisnya ulang?
- `Magazine` tidak perlu `loanDays()` sendiri. Mengapa? Versi siapa yang berjalan?
- `extendLoan()` dan `extendLoan(int)` sama-sama bernama `extendLoan`. Apa yang membedakannya bagi compiler? Bisakah salah satu memakai yang lain?
- Dua constructor `Book` hampir sama. Bagaimana menghindari menyalin isinya?

<details>
<summary>Petunjuk 1</summary>

- Anotasi `@Override` membuat compiler menolak jika nama atau parameter salah. Pasang pada setiap override.
- Kata kunci `super` bisa dipakai bukan hanya untuk constructor, tetapi juga untuk memanggil method milik parent.
- Constructor boleh memanggil constructor lain di kelas yang **sama**, dengan kata kunci yang berbeda dari `super(...)`. Pemanggilan ini juga harus berada di baris pertama.
- `toString()` sudah ada di `Object`. Kamu meng-override-nya.
- Teks `Unknown` hanya dipakai jika `author` bernilai `null`.
- Perpanjangan perlu diingat di sebuah field di `LibraryItem`. Bagaimana `getTotalLoanDays()` memakainya agar tetap benar untuk `Book` (14) dan `Dvd` (3)?

</details>

<details>
<summary>Petunjuk 2 (langkah per kelas, buka jika Petunjuk 1 belum cukup)</summary>

- **`LibraryItem`**:
  - `loanDays()` mengembalikan 7.
  - `describe()` menyusun teks dari `title`, sebuah spasi, lalu `year` di dalam tanda kurung (hasil seperti `Generic (2000)`).
  - `toString()` cukup memanggil `describe()`. Tidak perlu menyusun teks lagi.
  - Tambahkan field `private` untuk total hari perpanjangan, nilai awal 0.
  - `extendLoan(int days)`: jika `days` 0 atau negatif, lempar `IllegalArgumentException`. Jika tidak, tambahkan ke field perpanjangan.
  - `extendLoan()` tidak perlu mengulang isi di atas. Cukup panggil `extendLoan(int)` dengan angka 7.
  - `getTotalLoanDays()` menjumlahkan **hasil pemanggilan `loanDays()`** dan field perpanjangan. Jangan menulis angka 7 langsung. Dengan memanggil method, `Book` otomatis memakai 14 dan `Dvd` memakai 3 (inilah polymorphism).
- **`Book`**:
  - `loanDays()` mengembalikan 14.
  - `describe()`: (1) ambil hasil `describe()` milik parent dengan `super`. (2) Tentukan nama penulis: `Unknown` jika `author` `null`, selain itu nama dari objek `Author`. (3) Gabungkan hasil parent, teks ` by ` (dengan spasi di kiri dan kanan), dan nama penulis.
  - Constructor 4 parameter: baris pertamanya memanggil constructor 3 parameter milik `Book` sendiri (kata kunci `this` diikuti kurung). Setelah itu baru isi penulisnya.
- **`Dvd`**: `loanDays()` mengembalikan 3. `describe()` mengambil hasil parent, lalu menambahkan spasi, tanda kurung siku berisi durasi dan teks `min` (hasil seperti `Inception (2010) [148 min]`).
- **`Magazine`**: tidak ada override sama sekali. Constructor 2 parameter: baris pertamanya memanggil constructor 3 parameter milik `Magazine` sendiri dengan nomor edisi 1.
- Cara memeriksa tanpa tes: di `Main`, taruh `Book`, `Dvd`, dan `Magazine` dalam satu array `LibraryItem[]`, cetak `loanDays()` dan `describe()` setiap elemen, lalu bandingkan dengan tabel nilai yang diharapkan.

</details>

<details>
<summary>Kerangka kode (belum lengkap, buka jika Petunjuk 2 belum cukup)</summary>

Kerangka ini **belum bisa dikompilasi**. Ganti setiap `____` dengan kode yang benar, lalu hapus komentar yang tidak perlu.

```java
// LibraryItem.java (tambahan)
private int extraDays;   // total hari perpanjangan, awalnya 0

public int loanDays() {
    return ____;
}

public String describe() {
    return title + " (" + ____ + ")";
}

@Override
public String toString() {
    return ____();
}

public void extendLoan() {
    extendLoan(____);
}

public void extendLoan(int days) {
    if (days ____ 0) {
        throw new IllegalArgumentException("____");
    }
    extraDays += ____;
}

public int getTotalLoanDays() {
    return ____() + extraDays;      // panggil method, jangan tulis angka langsung
}
```

```java
// Book.java (tambahan)
@Override
public int loanDays() {
    return ____;
}

@Override
public String describe() {
    String name = (author == null) ? "____" : author.____();
    return ____.describe() + " by " + name;     // versi milik parent
}

public Book(String isbn, String title, int year, Author author) {
    ____(isbn, title, year);                     // panggil constructor 3 parameter
    this.author = author;
}
```

```java
// Dvd.java (tambahan)
@Override
public int loanDays() {
    return ____;
}

@Override
public String describe() {
    return super.describe() + " [" + ____ + " min]";
}
```

```java
// Magazine.java (tambahan)
public Magazine(String title, int year) {
    ____(title, year, 1);
}
```

</details>

### Telusuri

Tidak dinilai: di `Main`, buat array bertipe `LibraryItem[]` berisi satu `Book`, satu `Dvd`, dan satu `Magazine`, lalu cetak `loanDays()` dan `describe()` masing-masing dengan satu perulangan. Variabelnya bertipe `LibraryItem`, tetapi hasilnya `14`, `3`, dan `7`, bukan `7` untuk semuanya. Siapa yang menentukan versi method mana yang berjalan: tipe variabel atau objeknya?

### Cek dirimu

`P07OverrideTest` dan `P07OverloadTest` lulus.

---

## Bagian 7 (Gabungan P1 sampai P7): Aplikasi Konsol

![Diagram Bagian 7](docs/p08-console-app.png)

### Pertanyaan pemandu

- `Library` tidak boleh mencetak apa pun. Mengapa? Apa yang kamu ganti di proyek akhir saat tampilannya menjadi GUI, dan apa yang tidak perlu disentuh?
- Array `items` berisi `Book`, `Dvd`, dan `Magazine` sekaligus. Mengapa itu diizinkan? Konsep apa namanya?
- Mengapa `LibraryApp` menerima `Scanner` dan `PrintStream` lewat constructor, bukan langsung memakai `System.in` dan `System.out`?
- Pada alur "pinjam": objek mana yang dipanggil, dan method apa yang berjalan di masing-masingnya?

### Aturan yang dicek autograder: kelas `Library`

Buat kelas `Library` sesuai diagram. Tidak boleh ada `System.out` di dalamnya.

| Method | Aturan |
|---|---|
| `addItem` | `false` jika `null` atau array penuh (20 item). |
| `addMember` | `false` jika `null`, penuh (10 anggota), atau `memberId` sudah terdaftar. |
| `getItems`, `getMembers` | Array baru yang **hanya berisi elemen terisi**. |
| `findItemByTitle` | Judul dicocokkan **tanpa peduli huruf besar-kecil**. `null` jika tidak ada. |
| `findMember` | Berdasarkan `memberId`. `null` jika tidak ada. |
| `searchByKeyword` | Semua koleksi yang judulnya **memuat** kata kunci (tanpa peduli huruf besar-kecil). Jika tidak ada, kembalikan array **kosong**, bukan `null`. |
| `lend(memberId, title)` | `true` hanya jika anggota ada, koleksi ada, anggota boleh meminjam, dan koleksi tersedia. Setelah itu koleksi dipinjam dan pinjaman anggota bertambah. |
| `receive(memberId, title)` | `true` hanya jika anggota dan koleksi ada, koleksi sedang dipinjam, dan anggota punya pinjaman. Setelah itu koleksi tersedia lagi dan pinjaman anggota berkurang. |

<details>
<summary>Petunjuk 1: Library</summary>

- Dua array (`items` dan `members`) masing-masing perlu penghitung isi, seperti di `Shelf`.
- Tipe elemen array koleksi adalah `LibraryItem`. Itu sebabnya `Book`, `Dvd`, dan `Magazine` bisa masuk bersama.
- Untuk memotong array menjadi hanya bagian yang terisi, pelajari `java.util.Arrays.copyOf`. Memakai `Arrays` untuk array biasa tetap sesuai aturan (bukan koleksi).
- Untuk mengabaikan huruf besar-kecil, `String` punya method khusus perbandingan dan method untuk mengubah huruf.
- `lend` dan `receive` cukup memanggil method yang sudah ada di `Member` dan `LibraryItem`. Tulis alurnya: cari, periksa, ubah.
- Hasil `searchByKeyword` panjangnya belum diketahui sebelum menghitung. Pikirkan cara menampungnya dulu.

</details>

<details>
<summary>Petunjuk 2: Library (langkah per method, buka jika Petunjuk 1 belum cukup)</summary>

Field yang dibutuhkan: nama, array koleksi berukuran 20 dan penghitungnya, array anggota berukuran 10 dan penghitungnya. Nilai awal kedua penghitung adalah 0.

- **`addItem`**: (1) jika item `null` atau penghitung sudah sama dengan panjang array, kembalikan `false`. (2) Simpan item di slot yang ditunjuk penghitung. (3) Naikkan penghitung. (4) Kembalikan `true`.
- **`addMember`**: sama dengan `addItem`, ditambah satu pemeriksaan: panggil `findMember` dengan `memberId` anggota itu. Jika hasilnya bukan `null`, id sudah terdaftar.
- **`getItems`** dan **`getMembers`**: salin array dari indeks 0 sampai sebelum penghitung ke array baru. `Arrays.copyOf(array, panjangBaru)` melakukannya.
- **`findItemByTitle`** dan **`findMember`**: gunakan perulangan dari 0 sampai sebelum penghitung (bukan sampai panjang array, karena sisanya `null`). Jika ada yang cocok, langsung kembalikan. Jika perulangan selesai, kembalikan `null`. Untuk judul, cari method `String` yang membandingkan tanpa peduli huruf besar-kecil.
- **`searchByKeyword`**: (1) buat array sementara sepanjang jumlah koleksi. (2) Telusuri koleksi. Ubah judul dan kata kunci ke huruf kecil, lalu periksa apakah judul memuat kata kunci. Jika ya, simpan di array sementara dan naikkan penghitung hasil. (3) Salin array sementara sepanjang penghitung hasil. Tanpa hasil, kamu otomatis mendapat array kosong.
- **`lend`**: (1) cari anggota dan koleksi. (2) Jika salah satunya `null`, kembalikan `false`. (3) Jika anggota tidak boleh meminjam, kembalikan `false`. (4) Pinjam koleksinya. Jika gagal, kembalikan `false`. (5) Tambah pinjaman anggota, lalu kembalikan `true`. Perhatikan urutan 3 dan 4: koleksi baru boleh diubah setelah anggota dipastikan boleh meminjam.
- **`receive`**: (1) cari anggota dan koleksi, `null` berarti `false`. (2) Jika koleksi tidak sedang dipinjam, kembalikan `false`. (3) Kurangi pinjaman anggota. Jika gagal (tidak punya pinjaman), kembalikan `false`. (4) Kembalikan koleksinya, lalu kembalikan `true`.

</details>

<details>
<summary>Kerangka kode: Library (belum lengkap, buka jika Petunjuk 2 belum cukup)</summary>

Kerangka ini **belum bisa dikompilasi**. Ganti setiap `____` dengan kode yang benar, lalu hapus komentar yang tidak perlu.

```java
// Library.java
package id.ac.polinema.library;

import java.util.Arrays;

public class Library {
    private String name;
    private LibraryItem[] items = new LibraryItem[____];
    private int itemCount;
    private Member[] members = new Member[____];
    private int memberCount;

    public Library(String name) {
        this.name = name;
    }

    public String getName() {
        return ____;
    }

    public boolean addItem(LibraryItem item) {
        if (item == null || itemCount == ____) {
            return false;
        }
        items[itemCount] = ____;
        itemCount++;
        return true;
    }

    public boolean addMember(Member member) {
        // sama seperti addItem, ditambah satu syarat: id belum terdaftar
        if (member == null || memberCount == ____ || findMember(member.____()) != null) {
            return false;
        }
        // simpan di members, lalu naikkan memberCount
        return true;
    }

    public LibraryItem[] getItems() {
        return Arrays.copyOf(items, ____);
    }

    // getMembers(): pola yang sama dengan getItems

    public LibraryItem findItemByTitle(String title) {
        for (int i = 0; i < ____; i++) {
            if (items[i].getTitle().____(title)) {      // abaikan huruf besar-kecil
                return items[i];
            }
        }
        return null;
    }

    // findMember(String memberId): pola yang sama, bandingkan dengan getMemberId()

    public LibraryItem[] searchByKeyword(String keyword) {
        LibraryItem[] found = new LibraryItem[____];
        int total = 0;
        for (int i = 0; i < itemCount; i++) {
            if (items[i].getTitle().toLowerCase().____(keyword.toLowerCase())) {
                found[total] = ____;
                total++;
            }
        }
        return Arrays.copyOf(found, ____);
    }

    public boolean lend(String memberId, String title) {
        Member member = ____(memberId);
        LibraryItem item = ____(title);
        if (member == null || item == null) {
            return false;
        }
        if (!member.____()) {
            return false;
        }
        if (!item.____()) {
            return false;
        }
        member.____();
        return true;
    }

    // receive(String memberId, String title): cari, periksa item sedang dipinjam,
    // kurangi pinjaman anggota, lalu kembalikan item
}
```

</details>

### Kelas `LibraryApp`

Buat file `LibraryApp.java`. Perulangan menu (`run`) dan pembacaan input dengan `Scanner` (`readLine`, `readInt`) **sudah lengkap**. Salin, lalu isi method yang masih kosong. Setiap method punya petunjuk dan kerangka di komentarnya: ganti `____`, lalu hapus tanda `//` di depan baris kode.

```java
package id.ac.polinema.library;

import java.io.PrintStream;
import java.util.Scanner;

public class LibraryApp {

    private Library library;
    private Scanner in;
    private PrintStream out;

    public LibraryApp(Library library, Scanner in, PrintStream out) {
        this.library = library;
        this.in = in;
        this.out = out;
    }

    // Perulangan tanpa akhir: menu tampil lagi dan lagi sampai pengguna memilih 0.
    public void run() {
        while (true) {
            printMenu();
            if (!in.hasNextLine()) {      // input habis: berhenti, jangan crash
                return;
            }
            String choice = in.nextLine().trim();
            switch (choice) {
                case "1": showItems(); break;
                case "2": addBook(); break;
                case "3": addDvd(); break;
                case "4": addMagazine(); break;
                case "5": registerMember(); break;
                case "6": lendItem(); break;
                case "7": returnItem(); break;
                case "8": searchItems(); break;
                case "9": showMembers(); break;
                case "0":
                    out.println("Goodbye");
                    return;               // keluar dari run, perulangan berhenti
                default:
                    out.println("Invalid choice");
            }
        }
    }

    // Mencetak prompt (tanpa pindah baris), lalu membaca satu baris. Spasi di ujung dibuang.
    private String readLine(String prompt) {
        out.print(prompt);
        if (!in.hasNextLine()) {
            return "";
        }
        return in.nextLine().trim();
    }

    // Membaca bilangan bulat positif. Mengembalikan -1 jika isinya bukan bilangan positif.
    private int readInt(String prompt) {
        String text = readLine(prompt);
        if (text.isEmpty() || text.length() > 9) {
            return -1;
        }
        for (int i = 0; i < text.length(); i++) {
            if (!Character.isDigit(text.charAt(i))) {
                return -1;
            }
        }
        int value = Integer.parseInt(text);
        return value > 0 ? value : -1;
    }

    private void printMenu() {
        out.println("=== " + library.getName() + " ===");
        out.println("1. List items");
        out.println("2. Add book");
        // TODO: lanjutkan baris 3 sampai 9 dan "0. Exit" sesuai tabel "Teks yang harus dicetak".
        out.print("Choose: ");
    }

    // Satu baris untuk satu koleksi: describe, status, lama pinjam.
    private String line(LibraryItem item) {
        // String status = item.____() ? "Available" : "Borrowed";
        // return item.describe() + " | " + status + " | " + item.____() + " days";
        return "";
    }

    private void showItems() {
        // LibraryItem[] items = library.____();
        // if (items.length == 0) {
        //     out.println("No items");
        // }
        // for (LibraryItem item : items) {
        //     out.println(line(item));
        // }
    }

    private void addBook() {
        // String isbn = readLine("ISBN: ");
        // String title = readLine("Title: ");
        // int year = readInt("Year: ");
        // if (year < 0) {
        //     out.println("Invalid number");
        //     return;
        // }
        // if (isbn.isEmpty() || ____) {
        //     out.println("Invalid input");
        //     return;
        // }
        // Book book = new Book(isbn, title, year);
        // String authorName = readLine("____");
        // if (!authorName.isEmpty()) {
        //     String country = readLine("____");
        //     book.setAuthor(new Author(____, ____));
        // }
        // out.println(library.____(book) ? "Item added" : "Library is full");
    }

    private void addDvd() {
        // String title = readLine("Title: ");
        // int year = readInt("Year: ");
        // int minutes = readInt("____");
        // if (year < 0 || ____) { out.println("Invalid number"); return; }
        // if (title.isEmpty()) { out.println("Invalid input"); return; }
        // out.println(library.addItem(new Dvd(title, year, minutes)) ? "Item added" : "Library is full");
    }

    private void addMagazine() {
        // Pola yang sama dengan addDvd. Prompt ketiga: "Issue number: ".
    }

    private void registerMember() {
        // String id = readLine("Member ID: ");
        // String name = readLine("____");
        // if (id.isEmpty() || ____) {
        //     out.println("Invalid input");
        //     return;
        // }
        // boolean added = library.addMember(new Member(id, name));
        // out.println(added ? "Member registered" : "____");
    }

    private void lendItem() {
        // String id = readLine("Member ID: ");
        // String title = readLine("Title: ");
        // out.println(library.____(id, title) ? "Loan successful" : "Loan failed");
    }

    private void returnItem() {
        // Pola yang sama dengan lendItem, tetapi memanggil receive dan pesan "Return ...".
    }

    private void searchItems() {
        // String keyword = readLine("____");
        // LibraryItem[] found = library.____(keyword);
        // if (found.length == 0) {
        //     out.println("No items found");
        // }
        // for (LibraryItem item : found) {
        //     out.println(line(item));
        // }
    }

    private void showMembers() {
        // Member[] members = library.getMembers();
        // if (members.length == 0) {
        //     out.println("No members");
        // }
        // for (Member m : members) {
        //     out.println(m.getMemberId() + " - " + m.____() + " (" + m.____() + " loans)");
        // }
    }
}
```

`LibraryApp` tidak memakai `System.in` dan `System.out` langsung. Itu yang membuat autograder bisa "mengetik" menu untuk aplikasimu.

### `Main`: satu-satunya titik awal program

Buka `Main.java` dan lanjutkan di bawah baris sapaan. `Main` membuat `Library`, mengisi data contoh, lalu menjalankan `LibraryApp` dengan keyboard dan layar sungguhan. `LibraryApp` tidak punya `main` sendiri.

```java
import java.util.Scanner;   // di bagian atas file

public static void main(String[] args) {
    System.out.println("Welcome to Polinema Library");

    Library library = new Library("Polinema Library");
    Book book = new Book("978-0132350884", "Clean Code", 2008);
    book.setAuthor(new Author("Robert Martin", "____"));
    library.addItem(____);
    library.addItem(new Dvd("Inception", 2010, ____));
    library.addItem(new Magazine("Tempo", 2024, ____));
    library.addMember(new Member("M001", "____"));

    LibraryApp app = new LibraryApp(____, new Scanner(System.in), System.out);
    app.____();
}
```

<details>
<summary>Petunjuk 2: LibraryApp (langkah per method, buka jika komentar TODO belum cukup)</summary>

Gunakan `out` untuk mencetak dan `in` untuk membaca, bukan `System.out` dan `System.in`. Method `run`, `readLine`, dan `readInt` sudah ada di kerangka.

- **`printMenu`**: satu `println` untuk judul (`=== ` + nama perpustakaan + ` ===`), sepuluh `println` untuk baris menu, lalu satu `print` (tanpa `ln`) untuk `Choose: `. Nama perpustakaan diminta dari `library`.
- **`showItems`**: (1) ambil array dari `library`. (2) Jika panjangnya 0, cetak `No items`. (3) Jika tidak, telusuri dan cetak satu baris per koleksi. Susun barisnya dari tiga bagian: hasil `describe()`, status (cek `isAvailable()` untuk memilih `Available` atau `Borrowed`), dan `loanDays()` diikuti ` days`, dipisahkan ` | `. Karena baris ini juga dipakai `searchItems`, pertimbangkan menaruhnya di satu method bantu.
- **`addBook`**: (1) baca `ISBN`, `Title`, lalu `Year` dengan `readInt`. (2) Jika tahun -1, cetak `Invalid number` dan hentikan method. (3) Jika `ISBN` atau judul kosong, cetak `Invalid input` dan hentikan. (4) Buat objek `Book`. (5) Baca nama penulis. Jika tidak kosong, baca negara, buat `Author`, lalu pasang ke buku. (6) Serahkan buku ke `library` dan cetak `Item added` atau `Library is full` sesuai hasilnya.
- **`addDvd`** dan **`addMagazine`**: pola yang sama, tanpa langkah penulis. Pesan hasilnya sama dengan `addBook`, sehingga bisa dipakai bersama lewat method bantu yang menerima hasil `addItem`.
- **`registerMember`**: (1) baca id dan nama. (2) Jika salah satunya kosong, cetak `Invalid input` dan hentikan. (3) Buat `Member`. (4) Cetak `Member registered` atau `Member ID already exists` sesuai hasil `addMember`.
- **`lendItem`** dan **`returnItem`**: baca id dan judul, panggil method yang sesuai di `library`, lalu pilih salah satu dari dua pesan berdasarkan hasilnya. Tidak ada aturan peminjaman di sini.
- **`searchItems`**: baca kata kunci, minta hasil dari `library`, cetak `No items found` jika kosong, dan jika tidak cetak setiap hasil dengan format yang sama seperti `showItems`.
- **`showMembers`**: minta array anggota. Jika kosong cetak `No members`. Jika tidak, cetak satu baris per anggota dengan bentuk `id - nama (N loans)`.
- **`Main.main`** (di `Main.java`): (1) cetak sapaan. (2) Buat `Library`. (3) Buat beberapa objek (`Book` yang sudah punya penulis, `Dvd`, `Magazine`, `Member`) dan tambahkan ke `library`. (4) Buat `LibraryApp` dengan `new Scanner(System.in)` dan `System.out`, lalu panggil `run()`.

</details>

### Teks yang harus dicetak

`Main` mencetak sapaan, membuat `Library` bernama `Polinema Library` berisi data contoh, lalu menjalankan `LibraryApp` dengan `System.in` dan `System.out`.

Tulis output **persis** seperti tabel. Cetak pesan dengan `println` dan prompt dengan `print` (tanpa pindah baris).

| Menu | Prompt (berurutan) | Hasil |
|---|---|---|
| (tiap putaran) | Judul `=== <nama perpustakaan> ===`, lalu baris `1. List items`, `2. Add book`, `3. Add DVD`, `4. Add magazine`, `5. Register member`, `6. Lend item`, `7. Return item`, `8. Search items`, `9. List members`, `0. Exit`, lalu prompt `Choose: ` | menu tampil lagi setelah setiap aksi |
| 1 List items | tidak ada | Satu baris per koleksi: `describe() \| status \| N days`. Status: `Available` atau `Borrowed`. N = `loanDays()`. Jika kosong: `No items`. |
| 2 Add book | `ISBN: `, `Title: `, `Year: `, `Author name (blank for none): `, lalu `Author country: ` hanya jika nama penulis tidak kosong | `Item added`, atau `Library is full` |
| 3 Add DVD | `Title: `, `Year: `, `Duration (minutes): ` | `Item added`, atau `Library is full` |
| 4 Add magazine | `Title: `, `Year: `, `Issue number: ` | `Item added`, atau `Library is full` |
| 5 Register member | `Member ID: `, `Name: ` | `Member registered`, atau `Member ID already exists` |
| 6 Lend item | `Member ID: `, `Title: ` | `Loan successful`, atau `Loan failed` |
| 7 Return item | `Member ID: `, `Title: ` | `Return successful`, atau `Return failed` |
| 8 Search items | `Keyword: ` | Satu baris per hasil (format sama dengan menu 1). Jika tidak ada: `No items found` |
| 9 List members | tidak ada | Satu baris per anggota: `M001 - Budi (1 loans)`. Jika kosong: `No members` |
| 0 Exit | tidak ada | `Goodbye`, lalu program selesai |
| lainnya | tidak ada | `Invalid choice` |

Aturan input untuk menu 2, 3, dan 4:

- Jika `Year` (atau durasi atau nomor edisi) bukan bilangan bulat positif: cetak `Invalid number` dan batalkan penambahan.
- Jika `ISBN` atau `Title` kosong: cetak `Invalid input` dan batalkan.
- Untuk menu 5, jika `Member ID` atau `Name` kosong: cetak `Invalid input` dan batalkan.
- Kamu **tidak** perlu menangkap exception. Cek dulu inputnya, sehingga constructor tidak pernah menerima data tidak valid.
- Untuk menu 2: `ISBN`, `Title`, dan `Year` dibaca dulu. Data penulis dibaca setelah ketiganya valid.

Contoh baris menu 1: `Clean Code (2008) by Robert Martin | Available | 14 days`.

### Telusuri

Tidak dinilai: ikuti satu alur peminjaman dari menu 6 sampai selesai. Sebutkan urutan objek yang dipanggil: `LibraryApp`, `Library`, `Member`, `LibraryItem`. Method apa saja yang berjalan di setiap objek? Tulis di laporan.

### Cek dirimu

`P08LibraryTest` dan `P08LibraryAppTest` lulus, lalu jalankan aplikasinya dan coba semua menu.

---

## Coba Aplikasinya

Setelah `Main` selesai, jalankan:

```
mvn -q compile exec:java
```

Contoh sesi (data awal: buku `Clean Code`, DVD `Inception`, majalah `Tempo`, anggota `M001 - Budi`):

```
=== Polinema Library ===
1. List items
...
0. Exit
Choose: 6
Member ID: M001
Title: Clean Code
Loan successful
...
Choose: 1
Clean Code (2008) by Robert Martin | Borrowed | 14 days
Inception (2010) [148 min] | Available | 3 days
Tempo (2024) | Available | 7 days
...
Choose: 9
M001 - Budi (1 loans)
...
Choose: 0
Goodbye
```

## Laporan (PDF)

Serahkan satu file PDF: `laporan/Laporan_<NIM>_<Nama>.pdf`, contoh `laporan/Laporan_2441720001_Budi_Santoso.pdf`. Commit dan push ke repositori. Tulis dengan kata-katamu sendiri. Laporan salinan tidak dinilai.

Isi laporan:

1. **Identitas**: nama, NIM, kelas, link repositori GitHub.
2. **Setiap Bagian 1 sampai 7**:
   - Penjelasan konsep dengan kata-katamu sendiri (3 sampai 5 kalimat): apa itu, mengapa dipakai, di kelas mana kamu memakainya. Jawab juga pertanyaan pemandu.
   - Potongan kode buatanmu (5 sampai 15 baris) dan penjelasannya baris per baris.
   - Jawaban "Telusuri".
   - Kendala dan solusi. Tulis Petunjuk yang kamu buka.
3. **Tambahan Bagian 7**:
   - Screenshot aplikasi berjalan (minimal satu sesi pinjam dan kembali).
   - Penjelasan kerja sama `LibraryApp`, `Library`, `Member`, dan `LibraryItem` pada satu alur peminjaman.
4. **Hasil pengujian**: screenshot `mvn test` atau tab Actions yang menampilkan nilai.
5. **Bukti WakaTime**: screenshot dashboard project `oop-library` (total waktu dan grafik per hari) dan total jam dalam teks.
6. **Refleksi**: konsep yang masih membingungkan dan rencana belajarmu.

## Pengumpulan

Kumpulkan **seluruh repositori**. Sebelum batas waktu, pastikan:

- [ ] WakaTime aktif selama kamu mengerjakan, dan project `oop-library` muncul di dashboard.
- [ ] Semua kode sudah di-push.
- [ ] Autograder di tab Actions sudah berjalan dan menampilkan nilai.
- [ ] `laporan/Laporan_<NIM>_<Nama>.pdf` ada, bernama benar, dan sudah di-push.
- [ ] Laporan memuat screenshot WakaTime.
- [ ] `.wakatime-project` tidak berubah.

Kirim link repositori sesuai arahan Dosen.

## Penilaian

Autograder menilai kode (100 poin). Dosen menilai laporan dan usaha (WakaTime) secara manual. **Ketiganya wajib ada.**

| Tes | Bagian | Poin |
|---|---|---|
| `P01MainOutputTest` | 1 | 5 |
| `P02AuthorTest` | 2 | 5 |
| `P02BookTest` | 2 | 10 |
| `P03EncapsulationTest` | 3 | 10 |
| `P03MemberTest` | 3 | 10 |
| `P04AssociationTest` | 4 | 5 |
| `P04ShelfAggregationTest` | 4 | 10 |
| `P04MemberCardCompositionTest` | 4 | 5 |
| `P04LibrarianDependencyTest` | 4 | 5 |
| `P06InheritanceTest` | 5 | 10 |
| `P07OverrideTest` | 6 | 10 |
| `P07OverloadTest` | 6 | 5 |
| `P08LibraryTest` | 7 | 5 |
| `P08LibraryAppTest` | 7 | 5 |
| **Total** | | **100** |

Satu kelas tes dinilai penuh hanya jika **semua** tesnya lulus.
