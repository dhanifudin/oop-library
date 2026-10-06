package id.ac.polinema.library;

/**
 * Bagian 3: anggota perpustakaan.
 *
 * Jangan ubah nama kelas, nama method, atau signature-nya. Autograder
 * memanggilnya persis seperti yang tertulis di sini.
 *
 * Deklarasikan sendiri field-nya: lihat diagram kelas di README
 * (semua field harus private).
 */
public class Member {

    /**
     * Membuat anggota dengan jumlah pinjaman 0.
     * memberId dan name tidak boleh null atau kosong: lempar
     * IllegalArgumentException jika tidak valid.
     */
    public Member(String memberId, String name) {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    public String getMemberId() {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    public String getName() {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    /** Nama tidak boleh null atau kosong: lempar IllegalArgumentException dan biarkan nama lama. */
    public void setName(String name) {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    public int getLoanCount() {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    /** True jika jumlah pinjaman masih di bawah 3. Nilai ini dihitung, bukan disimpan. */
    public boolean canBorrow() {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    /** Menambah jumlah pinjaman. Jika sudah 3, tidak berubah dan mengembalikan false. */
    public boolean addLoan() {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    /** Mengurangi jumlah pinjaman. Jika sudah 0, tidak berubah dan mengembalikan false. */
    public boolean returnLoan() {
        throw new UnsupportedOperationException("Not implemented yet");
    }
}
