package id.ac.polinema.library;

/**
 * Bagian 2 dan 3: buku perpustakaan.
 *
 * Jangan ubah nama kelas, nama method, atau signature-nya. Autograder
 * memanggilnya persis seperti yang tertulis di sini.
 *
 * Field tidak dideklarasikan di sini: baca diagram kelas di README.
 * Method untuk bagian berikutnya (setAuthor, getAuthor, dan seterusnya) kamu
 * tambahkan sendiri sesuai diagram di bagian tersebut.
 */
public class Book {

    /**
     * Membuat buku baru yang masih tersedia (belum dipinjam).
     * Bagian 3: data yang tidak valid ditolak, aturannya ada di README.
     */
    public Book(String isbn, String title, int year) {
        // TODO Petunjuk: isi semua field. Buku baru: apakah sedang dipinjam atau tidak?
        // Bagian 3: aturan validasi judul dan tahun sama dengan setter. Bisakah constructor
        // memakai setter-nya?
        throw new UnsupportedOperationException("Not implemented yet");
    }

    public String getIsbn() {
        // TODO Petunjuk: kembalikan data yang disimpan constructor.
        throw new UnsupportedOperationException("Not implemented yet");
    }

    public String getTitle() {
        // TODO Petunjuk: sama seperti getIsbn.
        throw new UnsupportedOperationException("Not implemented yet");
    }

    public int getYear() {
        // TODO Petunjuk: sama seperti getIsbn.
        throw new UnsupportedOperationException("Not implemented yet");
    }

    /** True jika buku sedang ada di perpustakaan (tidak dipinjam). */
    public boolean isAvailable() {
        // TODO Petunjuk: field apa yang menyimpan status pinjam?
        throw new UnsupportedOperationException("Not implemented yet");
    }

    /**
     * Meminjam buku. Berhasil (true) jika buku tersedia. Jika buku sedang
     * dipinjam, hasilnya false dan keadaan buku tidak berubah.
     */
    public boolean checkOut() {
        // TODO Petunjuk: apa yang harus kamu periksa lebih dulu sebelum mengubah status?
        // Method ini punya dua jalur return yang berbeda.
        throw new UnsupportedOperationException("Not implemented yet");
    }

    /** Mengembalikan buku: buku bisa dipinjam lagi. */
    public void returnItem() {
        // TODO Petunjuk: satu baris saja. Status apa yang berubah?
        throw new UnsupportedOperationException("Not implemented yet");
    }

    /**
     * Bagian 3. Mengubah judul. Judul null, kosong, atau hanya spasi ditolak
     * dengan IllegalArgumentException, dan judul lama tetap.
     */
    public void setTitle(String title) {
        // TODO Petunjuk: periksa dulu, baru isi field. Class String punya method untuk
        // memeriksa teks kosong atau hanya spasi. Jangan lupa kemungkinan null.
        throw new UnsupportedOperationException("Not implemented yet");
    }

    /**
     * Bagian 3. Mengubah tahun terbit. Tahun 0 atau negatif ditolak dengan
     * IllegalArgumentException, dan tahun lama tetap.
     */
    public void setYear(int year) {
        // TODO Petunjuk: pola yang sama dengan setTitle. Apa syarat tahun yang valid?
        throw new UnsupportedOperationException("Not implemented yet");
    }
}
