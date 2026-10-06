package id.ac.polinema.library;

/**
 * Bagian 3: anggota perpustakaan.
 *
 * Jangan ubah nama kelas, nama method, atau signature-nya. Autograder
 * memanggilnya persis seperti yang tertulis di sini.
 *
 * Field tidak dideklarasikan di sini: baca diagram kelas di README
 * (semua field harus private).
 */
public class Member {

    /**
     * Membuat anggota yang belum punya pinjaman.
     * memberId dan name tidak boleh null atau kosong: lempar
     * IllegalArgumentException jika tidak valid.
     */
    public Member(String memberId, String name) {
        // TODO Petunjuk: validasi dulu sebelum mengisi field. Aturan nama sama dengan setName.
        // Bagian 4: kartu anggota juga dibuat di sini (lihat diagram Bagian 4).
        throw new UnsupportedOperationException("Not implemented yet");
    }

    public String getMemberId() {
        // TODO Petunjuk: kembalikan data yang disimpan constructor.
        throw new UnsupportedOperationException("Not implemented yet");
    }

    public String getName() {
        // TODO Petunjuk: sama seperti getMemberId.
        throw new UnsupportedOperationException("Not implemented yet");
    }

    /** Nama tidak boleh null atau kosong: lempar IllegalArgumentException dan biarkan nama lama. */
    public void setName(String name) {
        // TODO Petunjuk: periksa dulu, baru isi field.
        throw new UnsupportedOperationException("Not implemented yet");
    }

    public int getLoanCount() {
        // TODO Petunjuk: kembalikan jumlah pinjaman saat ini.
        throw new UnsupportedOperationException("Not implemented yet");
    }

    /** True jika anggota masih boleh meminjam (batasnya 3 pinjaman). */
    public boolean canBorrow() {
        // TODO Petunjuk: apakah perlu field baru, atau cukup dihitung dari data yang sudah ada?
        throw new UnsupportedOperationException("Not implemented yet");
    }

    /** Menambah jumlah pinjaman. Jika sudah di batas, tidak berubah dan hasilnya false. */
    public boolean addLoan() {
        // TODO Petunjuk: periksa batas dulu. Adakah method lain di kelas ini yang sudah
        // menjawab pertanyaan "boleh atau tidak"?
        throw new UnsupportedOperationException("Not implemented yet");
    }

    /** Mengurangi jumlah pinjaman. Jika sudah tidak ada pinjaman, tidak berubah dan hasilnya false. */
    public boolean returnLoan() {
        // TODO Petunjuk: batas bawah jumlah pinjaman adalah berapa?
        throw new UnsupportedOperationException("Not implemented yet");
    }
}
