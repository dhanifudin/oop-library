# Latihan OOP: Aplikasi Konsol Perpustakaan (Pertemuan 1 sampai 7)

Dalam latihan ini kamu membangun **aplikasi konsol yang benar-benar berjalan**: sebuah sistem perpustakaan dengan menu, data buku, anggota, dan peminjaman. Kamu membangunnya sedikit demi sedikit, mengikuti materi Pertemuan 1 sampai 7.

Mengapa aplikasi konsol? Di proyek akhir kamu akan membuat aplikasi dengan GUI. Aplikasi GUI yang baik dibangun di atas kelas-kelas OOP yang sudah rapi. Latihan ini melatih bagian tersulitnya lebih dulu: merancang kelas, menghubungkannya, dan membuatnya bekerja bersama. Nanti, hanya tampilannya yang kamu ganti.

## Daftar Isi

1. [Studi Kasus](#studi-kasus)
2. [Peta Materi](#peta-materi)
3. [Wajib: Pasang WakaTime](#wajib-pasang-wakatime)
4. [Memulai](#memulai)
5. [Membuka Proyek](#membuka-proyek)
6. [Cara Membaca Diagram](#cara-membaca-diagram)
7. [Bagian 1 sampai 7](#bagian-1-pertemuan-1-pengantar)
8. [Coba Aplikasinya](#coba-aplikasinya)
9. [Laporan (PDF)](#laporan-pdf)
10. [Pengumpulan](#pengumpulan)
11. [Penilaian](#penilaian)
12. [Aturan](#aturan)

## Studi Kasus

Perpustakaan Polinema meminjamkan tiga jenis koleksi:

- **Buku** (dipinjam 14 hari), punya ISBN dan penulis.
- **DVD** (dipinjam 3 hari), punya durasi.
- **Majalah** (dipinjam 7 hari), punya nomor edisi.

Setiap **anggota** punya kartu perpustakaan dan boleh meminjam paling banyak **3** koleksi sekaligus. Petugas memakai aplikasi konsol untuk menambah koleksi, mendaftarkan anggota, meminjamkan, menerima pengembalian, dan mencari koleksi.

## Peta Materi

| Bagian | Pertemuan | Konsep | Kelas yang kamu kerjakan |
|---|---|---|---|
| 1 | P1 Pengantar | Cara compile dan run, objek di sekitar kita | `Main` |
| 2 | P2 Class dan Object | class, object, constructor, `this`, method, return value | `Author`, `Book` |
| 3 | P3 Enkapsulasi | `private`, validasi, read-only, derived getter | `Book`, `Author`, `Member` |
| 4 | P4 Relasi Class | asosiasi, agregasi, komposisi, dependensi, array of objects | `Book`, `Member`, `LibraryCard`, `Shelf`, `Librarian` |
| 5 | P6 Inheritance | `extends`, `super(...)`, `protected`, IS-A | `LibraryItem`, `Book`, `Dvd`, `Magazine` |
| 6 | P7 Overriding dan Overloading | `@Override`, `super.method()`, `toString()`, overload method dan constructor | kelas yang sama dengan Bagian 5 |
| 7 | Gabungan P1 sampai P7 | polymorphism dalam array, memisahkan logika dan tampilan | `Library`, `LibraryApp` |

Pertemuan 5 adalah kuis, jadi tidak ada bagian untuknya.

Kerjakan **berurutan**. Setiap bagian memakai hasil bagian sebelumnya.

## Wajib: Pasang WakaTime

WakaTime adalah plugin yang mencatat berapa lama kamu benar-benar mengetik kode. Dosen memakainya untuk melihat **usaha** kamu, bukan hanya hasil akhirnya. Pasang **sebelum** menulis satu baris kode pun.

1. Buat akun gratis di [wakatime.com](https://wakatime.com).
2. Buka [wakatime.com/settings/api-key](https://wakatime.com/settings/api-key), lalu salin API key kamu. Jangan bagikan key ini kepada siapa pun.
3. Pasang plugin di editor yang kamu pakai:
   - **NetBeans**: menu `Tools > Plugins`, cari "WakaTime". Jika tidak ketemu, ikuti petunjuk di [wakatime.com/netbeans](https://wakatime.com/netbeans).
   - **VS Code**: pasang ekstensi `WakaTime` (ID: `WakaTime.vscode-wakatime`).
   - **IntelliJ IDEA**: `Settings > Plugins`, cari "WakaTime".
4. Saat plugin meminta, tempel API key kamu.
5. Ketik kode beberapa menit, lalu buka [wakatime.com/dashboard](https://wakatime.com/dashboard). Pastikan project **oop-library** muncul di sana.

Aturan WakaTime:

- File `.wakatime-project` sudah ada di repositori ini dan berisi `oop-library`. File ini membuat semua mahasiswa memakai nama project yang sama. **Jangan ubah atau hapus.**
- Nyalakan WakaTime **setiap kali** mengerjakan latihan ini. Waktu pengerjaan tanpa plugin tidak tercatat sebagai usaha.
- Screenshot dashboard WakaTime wajib ada di laporan kamu (lihat [Laporan (PDF)](#laporan-pdf)).

## Memulai

1. Di halaman GitHub repositori ini, klik **Use this template**, lalu **Create a new repository**.
2. Pilih visibilitas **Private**, lalu ikuti arahan Dosen tentang siapa yang perlu kamu undang.
3. Clone repositori barumu ke komputer.
4. Setiap kali selesai satu bagian, lakukan commit dan push.
5. Buka tab **Actions** di GitHub. Autograder berjalan otomatis setiap kali kamu push, dan menampilkan nilai kodemu.

Untuk menjalankan tes di komputermu sendiri:

```
mvn -q test
```

Untuk menjalankan satu kelas tes saja, contohnya:

```
mvn -q test -Dtest=P02BookTest
```

Di awal, hampir semua tes gagal. Itu normal. Tujuanmu adalah membuat semuanya lulus satu per satu. Pesan di tes yang gagal sudah dibuat agar menjelaskan apa yang kurang.

## Membuka Proyek

**NetBeans**: `File > Open Project`, pilih folder repositori ini (NetBeans mengenali `pom.xml` sebagai proyek Maven). Untuk menjalankan satu file: klik kanan file, pilih `Run File`, atau tekan `Shift+F6`.

**VS Code**: buka foldernya, pasang "Extension Pack for Java". Tombol `Run` muncul di atas method `main`.

**Tanpa IDE** (command line):

```
mvn -q compile exec:java -Dexec.mainClass=id.ac.polinema.library.Main
```

Ganti `Main` dengan `LibraryApp` untuk menjalankan aplikasi akhir. Kamu butuh JDK 17 atau lebih baru dan Maven.

## Cara Membaca Diagram

Diagram kelas adalah **spesifikasi utama** latihan ini. Semua nama kelas, field, constructor, dan method yang kamu butuhkan ada di diagram. Tidak ada file sumber diagram di repositori ini, jadi kamu harus membacanya sendiri dari gambar.

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

Tips: baca per kotak kelas, dari atas ke bawah. Bagian atas adalah field, bagian bawah adalah constructor dan method. Setelah itu baca garis antar kelas.

---

## Bagian 1 (Pertemuan 1): Pengantar

**Mengapa ini penting?** Sebelum membuat objek, kamu harus yakin bahwa alat kerjamu berfungsi: menulis kode, compile, lalu run.

**Langkah**

1. Pastikan JDK terpasang: jalankan `java -version` di terminal.
2. Buka `src/main/java/id/ac/polinema/library/Main.java`.
3. Isi method `main` agar mencetak `Welcome to Polinema Library` sebagai baris pertama output.
4. Jalankan `Main` dari IDE kamu.

**Telusuri** (tidak dinilai, tulis jawabannya di laporan): sebutkan 5 benda di perpustakaan yang menurutmu adalah *objek*. Untuk masing-masing, tulis satu *data* yang dimilikinya dan satu *aksi* yang bisa dilakukannya.

**Cek dirimu**: `P01MainOutputTest` lulus.

---

## Bagian 2 (Pertemuan 2): Class dan Object

**Mengapa ini penting?** Class adalah cetakan, object adalah hasil cetakannya. Semua bagian berikutnya memakai class dan object.

![Diagram Bagian 2](docs/p02-author-book.png)

**Langkah**

1. Buka `Author.java`. Deklarasikan field sesuai diagram, lalu isi constructor dan semua method.
2. Buka `Book.java`. Lakukan hal yang sama. Aturan perilakunya:
   - Buku baru langsung **tersedia** (`isAvailable()` bernilai `true`).
   - `checkOut()` mengembalikan `true` dan menandai buku dipinjam. Jika buku sudah dipinjam, ia mengembalikan `false`.
   - `returnItem()` membuat buku tersedia lagi.
3. Di Bagian ini field boleh `public` (seperti di diagram). Kamu akan menutupnya di Bagian 3.
4. Di `Main`, coba buat dua objek `Book` dan cetak datanya.

**Telusuri** (tidak dinilai): perhatikan kode ini, lalu tebak outputnya.

```java
Book a = new Book("1", "Clean Code", 2008);
Book b = a;
b.checkOut();
System.out.println(a.isAvailable());
Book c = new Book("2", "Refactoring", 1999);
System.out.println(c.isAvailable());
```

Mengapa hasil baris pertama dan kedua berbeda? Gambar `a`, `b`, dan `c` di stack, dan objeknya di heap.

**Cek dirimu**: `P02AuthorTest` dan `P02BookTest` lulus.

---

## Bagian 3 (Pertemuan 3): Enkapsulasi

**Mengapa ini penting?** Kalau field `public`, siapa pun bisa mengisi `year = -5` atau `title = ""`. Enkapsulasi membuat objek menjaga datanya sendiri.

![Diagram Bagian 3](docs/p03-encapsulation.png)

**Langkah**

1. Jadikan **semua field** `Author` dan `Book` menjadi `private`. Bandingkan dengan diagram Bagian 2: apa saja yang berubah?
2. Tambahkan validasi di `Book`:
   - `setTitle`: judul `null`, kosong, atau hanya spasi tidak valid.
   - `setYear`: tahun 0 atau negatif tidak valid.
   - Jika tidak valid: `throw new IllegalArgumentException(...)` dan **biarkan nilai lama**.
   - Constructor juga harus menolak data yang tidak valid. `isbn` juga tidak boleh kosong.
3. `isbn` bersifat **read-only**: tidak ada `setIsbn`. Status `available` juga tidak punya setter. Ia hanya berubah lewat `checkOut()` dan `returnItem()`.
4. Buka `Member.java` dan buat kelasnya sesuai diagram:
   - `memberId` dan `loanCount` read-only (tanpa setter).
   - `setName` menolak nama kosong dan menjaga nama lama.
   - `canBorrow()` bernilai `true` selama `loanCount < 3`. Nilai ini **dihitung**, jangan disimpan sebagai field.
   - `addLoan()` menambah `loanCount`. Jika sudah 3, tidak berubah dan mengembalikan `false`.
   - `returnLoan()` mengurangi `loanCount`. Jika sudah 0, tidak berubah dan mengembalikan `false`.

**Telusuri** (tidak dinilai): jika `Member` punya `public int loanCount`, tulis satu baris kode di `Main` yang merusak aturan "maksimal 3 pinjaman". Mengapa `private` mencegahnya?

**Cek dirimu**: `P03EncapsulationTest` dan `P03MemberTest` lulus. Tes Bagian 2 harus tetap lulus.

---

## Bagian 4 (Pertemuan 4): Relasi Class

**Mengapa ini penting?** Objek jarang bekerja sendirian. Memilih relasi yang tepat menentukan siapa memiliki siapa, dan siapa yang ikut hilang ketika objek lain hilang.

![Diagram Bagian 4](docs/p04-relations.png)

Baca diagramnya dengan teliti. Ada empat relasi, dan setiap relasi punya konsekuensi di kode:

| Relasi | Di diagram | Artinya di kode |
|---|---|---|
| Asosiasi | `Book` ke `Author` | `Book` menyimpan **referensi** ke `Author`, tetapi `Author` dibuat di luar dan bisa dipakai banyak buku. |
| Agregasi | `Shelf` ke `Book` | `Shelf` menyimpan array `Book`, tetapi `Book` ada di luar rak juga. |
| Komposisi | `Member` ke `LibraryCard` | `Member` **membuat** `LibraryCard` sendiri di constructor. Kartu tidak datang dari parameter. |
| Dependensi | `Librarian` ke `Member` dan `Book` | `Librarian` hanya memakai keduanya sebagai **parameter** method, tanpa menyimpannya. |

**Langkah**

1. Di `Book`, tambahkan field `author`, `getAuthor()`, dan `setAuthor(Author)`. Buku baru belum punya penulis (`null`).
2. Buat kelas `LibraryCard`. Nomor kartu diberikan lewat constructor.
3. Di `Member`, tambahkan `getCard()`. Constructor `Member` membuat kartu bernomor `"CARD-"` ditambah `memberId`, misalnya `CARD-M001`.
4. Buat kelas `Shelf`:
   - Array `Book` berkapasitas **5**, dan penghitung jumlah buku yang terisi.
   - `addBook` mengembalikan `false` jika rak penuh atau bukunya `null`.
   - `findByIsbn` mengembalikan objek `Book` yang sama (bukan salinan), atau `null` jika tidak ketemu.
   - `countAvailable` menghitung buku yang masih tersedia.
5. Buat kelas `Librarian` (tanpa field):
   - `lend(Member, Book)`: berhasil jika anggota boleh meminjam **dan** buku tersedia. Setelah itu buku dipinjam dan pinjaman anggota bertambah. Jika tidak, kembalikan `false` tanpa mengubah apa pun.
   - `receive(Member, Book)`: berhasil jika buku sedang dipinjam dan anggota punya pinjaman. Setelah itu buku tersedia lagi dan pinjaman anggota berkurang.

**Telusuri** (tidak dinilai): jika objek `Member` dibuang, apa yang terjadi pada `LibraryCard`-nya? Jika objek `Shelf` dibuang, apa yang terjadi pada `Book` di dalamnya? Jelaskan perbedaan keduanya dengan kata-katamu sendiri.

**Cek dirimu**: `P04AssociationTest`, `P04ShelfAggregationTest`, `P04MemberCardCompositionTest`, dan `P04LibrarianDependencyTest` lulus.

---

## Bagian 5 (Pertemuan 6): Inheritance

**Mengapa ini penting?** Perpustakaan tidak hanya punya buku. Kalau `Dvd` dan `Magazine` menyalin kode `Book`, setiap perbaikan harus dilakukan tiga kali. Inheritance membuat kode yang sama cukup ditulis sekali.

![Diagram Bagian 5](docs/p06-inheritance.png)

Ini adalah bagian **refactoring**: kamu memindahkan kode yang sudah ada ke tempat yang lebih tepat, dan semua tes lama harus **tetap lulus**.

**Langkah**

1. Buat kelas `LibraryItem` sesuai diagram. Ia menerima `title` dan `year` di constructor, dan memvalidasinya seperti `Book` di Bagian 3. Field `title` dan `year` bersifat `protected`.
2. Pindahkan dari `Book` ke `LibraryItem`: field `title`, `year`, `available`, serta method `getTitle`, `setTitle`, `getYear`, `setYear`, `isAvailable`, `checkOut`, dan `returnItem`.
3. Ubah `Book` menjadi `extends LibraryItem`. Constructor `Book` memanggil `super(title, year)`. `Book` hanya menyimpan `isbn` dan `author`.
4. Buat `Dvd` dan `Magazine` yang juga `extends LibraryItem`, dengan field dan constructor sesuai diagram.
5. Jalankan seluruh tes. Tes Bagian 2 sampai 4 harus tetap lulus.

**Telusuri** (tidak dinilai): apa yang diwarisi `Dvd` dari `LibraryItem`, dan apa yang tidak? Mengapa constructor `LibraryItem` tidak ikut diwariskan, tetapi tetap harus dipanggil oleh `Dvd`?

**Cek dirimu**: `P06InheritanceTest` lulus, dan tes Bagian 2 sampai 4 tidak ada yang rusak.

---

## Bagian 6 (Pertemuan 7): Overriding dan Overloading

**Mengapa ini penting?** Subclass sering perlu perilaku sendiri. Buku dipinjam 14 hari, DVD hanya 3 hari. Overriding mengganti perilaku turunan, overloading menyediakan beberapa cara memanggil method atau constructor yang sama.

![Diagram Bagian 6](docs/p07-override-overload.png)

**Langkah**

1. Di `LibraryItem` tambahkan:
   - `loanDays()` mengembalikan `7`.
   - `describe()` mengembalikan teks `"judul (tahun)"`, misalnya `Generic (2000)`.
   - `toString()` mengembalikan `describe()`.
   - `extendLoan()` menambah **7** hari perpanjangan.
   - `extendLoan(int days)` menambah sebanyak `days`. Nilai 0 atau negatif ditolak dengan `IllegalArgumentException`.
   - `getTotalLoanDays()` = `loanDays()` ditambah semua hari perpanjangan.
2. **Override** di subclass (beri `@Override`):

   | Kelas | `loanDays()` | `describe()` |
   |---|---|---|
   | `Book` | 14 | `super.describe()` + `" by "` + nama penulis (atau `Unknown` jika belum ada) |
   | `Dvd` | 3 | `super.describe()` + `" ["` + durasi + `" min]"` |
   | `Magazine` | tidak di-override (memakai versi `LibraryItem`) | tidak di-override |

   Contoh hasil: `Clean Code (2008) by Robert Martin` dan `Inception (2010) [148 min]`.
3. **Overload constructor**:
   - `Book(isbn, title, year, author)` memanggil `this(isbn, title, year)` lalu mengisi penulis.
   - `Magazine(title, year)` memanggil `this(title, year, 1)`.
4. Di `Main`, buat array bertipe `LibraryItem[]` berisi satu `Book`, satu `Dvd`, dan satu `Magazine`. Cetak `loanDays()` dan `describe()` masing-masing dengan satu perulangan.

**Telusuri** (tidak dinilai): pada langkah 4, variabelnya bertipe `LibraryItem`. Mengapa yang dicetak tetap `14`, `3`, dan `7`, bukan `7` untuk semuanya? Siapa yang menentukan versi method mana yang berjalan: tipe variabel atau objeknya?

**Cek dirimu**: `P07OverrideTest` dan `P07OverloadTest` lulus.

---

## Bagian 7 (Gabungan P1 sampai P7): Aplikasi Konsol

**Mengapa ini penting?** Sekarang semua kelas dirangkai menjadi aplikasi utuh. Kuncinya adalah memisahkan **logika** dari **tampilan**:

- `Library` hanya berisi logika (menyimpan koleksi dan anggota, meminjam, mengembalikan). **Ia tidak boleh mencetak apa pun.**
- `LibraryApp` hanya mengurus tampilan konsol (menu, membaca input, mencetak hasil).

Di proyek akhir, `LibraryApp` akan diganti oleh tampilan GUI, sedangkan `Library` dan kelas lainnya tidak perlu diubah sama sekali.

![Diagram Bagian 7](docs/p08-console-app.png)

### Kelas `Library`

Buat kelas `Library` sesuai diagram. Array `items` berisi `Book`, `Dvd`, dan `Magazine` **dalam satu array yang sama**. Ini mungkin karena ketiganya adalah `LibraryItem` (polymorphism).

| Method | Perilaku |
|---|---|
| `addItem` | Menambah koleksi. `false` jika `null` atau array penuh (20). |
| `addMember` | Menambah anggota. `false` jika `null`, penuh (10), atau `memberId` sudah ada. |
| `getItems`, `getMembers` | Array baru yang **hanya berisi elemen terisi** (bukan 20 atau 10 elemen dengan banyak `null`). |
| `findItemByTitle` | Mencari berdasarkan judul, **tidak peduli huruf besar-kecil**. `null` jika tidak ada. |
| `findMember` | Mencari berdasarkan `memberId`. `null` jika tidak ada. |
| `searchByKeyword` | Semua koleksi yang judulnya **memuat** kata kunci (tidak peduli huruf besar-kecil). Jika tidak ada, kembalikan array kosong (bukan `null`). |
| `lend(memberId, title)` | `true` jika anggota ada, koleksi ada, anggota boleh meminjam, dan koleksi tersedia. Lalu koleksi dipinjam dan pinjaman anggota bertambah. Selain itu `false`. |
| `receive(memberId, title)` | `true` jika anggota dan koleksi ada, koleksi sedang dipinjam, dan anggota punya pinjaman. Lalu koleksi tersedia lagi dan pinjaman anggota berkurang. Selain itu `false`. |

Catatan: latihan ini belum mencatat siapa meminjam apa. Itu sengaja, supaya kamu fokus pada kerja sama antar kelas.

### Kelas `LibraryApp`

Buat file `LibraryApp.java`. Kerangka di bawah ini sudah menangani perulangan menu dan pembacaan input supaya kamu fokus pada pemakaian objek. Salin, lalu **isi semua method bertanda `TODO`**.

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

    public void run() {
        boolean running = true;
        while (running) {
            printMenu();
            if (!in.hasNextLine()) {
                break;
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
                    running = false;
                    break;
                default:
                    out.println("Invalid choice");
            }
        }
    }

    private void printMenu() {
        out.println("=== " + library.getName() + " ===");
        out.println("1. List items");
        out.println("2. Add book");
        out.println("3. Add DVD");
        out.println("4. Add magazine");
        out.println("5. Register member");
        out.println("6. Lend item");
        out.println("7. Return item");
        out.println("8. Search items");
        out.println("9. List members");
        out.println("0. Exit");
        out.print("Choose: ");
    }

    // Mencetak prompt lalu membaca satu baris (tanpa spasi di ujung).
    private String readLine(String prompt) {
        out.print(prompt);
        return in.hasNextLine() ? in.nextLine().trim() : "";
    }

    // Mencetak prompt lalu membaca bilangan bulat positif. Mengembalikan -1 jika tidak valid.
    private int readInt(String prompt) {
        String text = readLine(prompt);
        try {
            int value = Integer.parseInt(text);
            return value > 0 ? value : -1;
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    private void showItems() { /* TODO */ }
    private void addBook() { /* TODO */ }
    private void addDvd() { /* TODO */ }
    private void addMagazine() { /* TODO */ }
    private void registerMember() { /* TODO */ }
    private void lendItem() { /* TODO */ }
    private void returnItem() { /* TODO */ }
    private void searchItems() { /* TODO */ }
    private void showMembers() { /* TODO */ }

    public static void main(String[] args) {
        // TODO: buat Library bernama "Polinema Library", isi beberapa data contoh,
        // lalu jalankan: new LibraryApp(library, new Scanner(System.in), System.out).run();
    }
}
```

Pelajari kerangkanya dulu. Perhatikan bahwa `LibraryApp` menerima `Scanner` dan `PrintStream` dari luar. Itu yang membuat autograder bisa "mengetik" menu untuk aplikasimu.

### Teks yang harus dicetak

Autograder membandingkan output, jadi tulis **persis** seperti tabel ini. Setiap pesan dicetak dengan `println`. Prompt dicetak dengan `print` (tanpa pindah baris).

| Menu | Prompt (berurutan) | Hasil |
|---|---|---|
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

- Baca **semua** isian dulu (kecuali data penulis buku, yang dibaca setelah validasi).
- Jika `Year` (atau durasi atau nomor edisi) bukan bilangan bulat positif: cetak `Invalid number` dan batalkan penambahan.
- Jika `ISBN` atau `Title` kosong: cetak `Invalid input` dan batalkan.
- Untuk menu 5, jika `Member ID` atau `Name` kosong: cetak `Invalid input` dan batalkan.
- Kamu **tidak** perlu menangkap exception. Cek dulu inputnya, sehingga constructor tidak pernah menerima data tidak valid.

Contoh baris menu 1: `Clean Code (2008) by Robert Martin | Available | 14 days`.

**Telusuri** (tidak dinilai): ikuti satu alur peminjaman dari menu 6 sampai selesai. Sebutkan urutan objek yang dipanggil: `LibraryApp`, `Library`, `Member`, `LibraryItem`. Method apa saja yang berjalan di setiap objek? Tulis di laporan.

**Cek dirimu**: `P08LibraryTest` dan `P08LibraryAppTest` lulus, lalu jalankan aplikasinya dan coba semua menu.

---

## Coba Aplikasinya

Setelah `main` di `LibraryApp` selesai, jalankan:

```
mvn -q compile exec:java
```

Contoh sesi (jawaban yang kamu ketik ada setelah prompt). Data contoh di `main` berisi buku `Clean Code`, DVD `Inception`, dan majalah `Tempo`, serta anggota `M001 - Budi`:

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

Selain kode, kamu wajib menyerahkan **laporan dalam satu file PDF**. Tujuannya agar Dosen tahu kamu **paham**, bukan hanya kodenya jalan.

- Nama file: `Laporan_<NIM>_<Nama>.pdf`, contoh `Laporan_2441720001_Budi_Santoso.pdf`.
- Simpan di folder `laporan/` di repositori ini, lalu commit dan push.
- Tulis dengan kata-katamu sendiri. Laporan yang disalin dari README atau dari teman tidak dinilai.

Isi laporan:

1. **Identitas**: nama, NIM, kelas, dan link repositori GitHub.
2. **Untuk setiap Bagian 1 sampai 7**:
   - **Penjelasan konsep** dengan kata-katamu sendiri (minimal 3 sampai 5 kalimat). Jawab pertanyaan pemandu: apa itu konsep ini, mengapa dipakai, dan di kelas mana kamu memakainya.
   - **Potongan kode** buatanmu (5 sampai 15 baris) beserta penjelasan baris per baris.
   - **Jawaban "Telusuri"** untuk bagian tersebut.
   - **Kendala dan solusi**: apa yang sulit, bagaimana kamu mengatasinya.
3. **Tambahan Bagian 7**:
   - Screenshot aplikasi konsol saat berjalan (minimal satu sesi meminjam dan mengembalikan).
   - Penjelasan bagaimana `LibraryApp`, `Library`, `Member`, dan `LibraryItem` bekerja sama pada satu alur peminjaman.
4. **Hasil pengujian**: screenshot hasil `mvn test` atau tab Actions di GitHub yang menampilkan nilai.
5. **Bukti WakaTime**: screenshot dashboard WakaTime untuk project `oop-library` (total waktu dan grafik per hari), ditambah total jam yang kamu tulis dalam teks.
6. **Refleksi**: konsep mana yang masih membingungkan, dan apa rencanamu untuk memahaminya.

## Pengumpulan

Kamu mengumpulkan **seluruh repositori**, bukan hanya kode. Sebelum batas waktu, pastikan:

- [ ] Semua kode sudah di-push ke GitHub.
- [ ] Autograder di tab Actions sudah dijalankan dan nilainya tampil.
- [ ] `laporan/Laporan_<NIM>_<Nama>.pdf` ada, bernama benar, dan sudah di-push.
- [ ] Laporan memuat screenshot WakaTime, dan WakaTime aktif selama kamu mengerjakan.
- [ ] File `.wakatime-project` tidak berubah.

Kirim link repositori sesuai arahan Dosen.

## Penilaian

Nilai kode (100 poin) dihitung otomatis oleh autograder. Laporan dan usaha (WakaTime) dinilai manual oleh Dosen. **Ketiganya wajib ada.**

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

## Aturan

- Jangan mengubah isi `src/test/**`, `.github/**`, dan `.wakatime-project`.
- Ikuti diagram persis: nama kelas, field, constructor, dan method. Autograder memanggilnya dengan nama itu.
- Semua field harus `private`, kecuali `title` dan `year` di `LibraryItem` yang `protected`.
- Gunakan **array biasa**. Jangan memakai `List` atau `ArrayList` (koleksi dipelajari di materi berikutnya).
- Tidak ada `System.out.println` di `Library` dan kelas model. Semua tampilan hanya di `Main` dan `LibraryApp`.
- Kerjakan sendiri. Boleh berdiskusi tentang konsep, tetapi kode dan laporan harus hasil kerjamu.
