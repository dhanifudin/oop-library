package id.ac.polinema.library;

/**
 * Bagian 2 dan 3: buku perpustakaan.
 *
 * Jangan ubah nama kelas, nama method, atau signature-nya. Autograder
 * memanggilnya persis seperti yang tertulis di sini.
 *
 * Deklarasikan sendiri field-nya: lihat diagram kelas di README.
 * Method untuk bagian berikutnya (setAuthor, getAuthor, describe, dan seterusnya)
 * kamu tambahkan sendiri sesuai diagram di bagian tersebut.
 */
public class Book {

    /**
     * Membuat buku baru yang masih tersedia (belum dipinjam).
     * Bagian 3: isbn tidak boleh kosong; title dan year divalidasi seperti setter-nya.
     */
    public Book(String isbn, String title, int year) {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    public String getIsbn() {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    public String getTitle() {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    public int getYear() {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    /** True jika buku sedang ada di perpustakaan (tidak dipinjam). */
    public boolean isAvailable() {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    /**
     * Meminjam buku. Jika buku tersedia, tandai sebagai dipinjam dan
     * kembalikan true. Jika sudah dipinjam, kembalikan false.
     */
    public boolean checkOut() {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    /** Mengembalikan buku: tandai kembali tersedia. */
    public void returnItem() {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    /**
     * Bagian 3. Mengubah judul. Judul null atau kosong (termasuk hanya spasi)
     * tidak valid: lempar IllegalArgumentException dan biarkan judul lama.
     */
    public void setTitle(String title) {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    /**
     * Bagian 3. Mengubah tahun terbit. Tahun 0 atau negatif tidak valid:
     * lempar IllegalArgumentException dan biarkan tahun lama.
     */
    public void setYear(int year) {
        throw new UnsupportedOperationException("Not implemented yet");
    }
}
