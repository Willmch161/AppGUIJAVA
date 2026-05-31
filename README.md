1. Kata Kunci Dasar Java
import: Perintah untuk meminjam kode yang sudah dibuat oleh pembuat Java. Tanpa ini, Java tidak tahu apa itu tombol atau jendela.

public: Artinya kode atau kelas ini terbuka dan bisa diakses dari mana saja oleh sistem.

class: Cetak biru (blueprint) dari program kita. Semua kode program harus berada di dalam sebuah class.

static: Artinya fungsi ini nempel langsung ke class dan bisa langsung dijalankan oleh sistem tanpa harus membuat salinan objeknya dulu.

void: Artinya fungsi ini hanya menjalankan tugas/perintah, tapi tidak "mengembalikan" data apa pun ke sistem.

main: Ini adalah kata sakti. Sistem Java selalu mencari fungsi bernama main sebagai garis start untuk memulai balapan.

String[] args: Variabel bawaan Java untuk menangkap teks jika kamu menjalankan program lewat terminal dengan kata tambahan (jarang dipakai untuk aplikasi GUI pemula).

new: Perintah untuk "menciptakan" barang baru. Contoh: new JButton() berarti "tolong ciptakan satu tombol baru di memori".

2. Alat Pembuat Jendela (Swing Components)
JFrame: Kanvas atau jendela aplikasi paling luar. Ini adalah bingkai utamanya.

JPanel: Wadah kecil transparan di dalam JFrame. Gunanya untuk mengelompokkan barang. (Misal: panel khusus form isian, panel khusus tombol).

JLabel: Teks biasa yang menempel di layar (contoh: tulisan "Name:"). User tidak bisa mengedit ini.

JTextField: Kotak putih kosong tempat user mengetikkan data.

JButton: Tombol yang bisa diklik oleh user.

JTable: Visual tabel yang muncul di layar (dengan baris dan kolom).

DefaultTableModel: Ini adalah "otak" atau tempat penyimpanan data dari JTable. JTable hanya bertugas menampilkan, sementara DefaultTableModel yang bertugas menyimpan, menambah, atau menghapus datanya.

JScrollPane: Wadah khusus agar jika data tabelmu sangat banyak, tabelnya bisa di-scroll ke atas dan ke bawah.

3. Logika & Interaksi
addActionListener: Ini adalah "telinga" untuk tombol. Gunanya mendengarkan apakah user mengklik tombol tersebut atau tidak.

e -> { ... }: Ini disebut Lambda Expression. Ini adalah cara singkat untuk menulis: "Ketika event (e) klik terjadi, lakukan semua perintah di dalam kurung kurawal ini".

.getText().trim(): Mengambil teks dari kotak isian, lalu memotong (trim) spasi kosong yang tidak sengaja terketik di awal atau akhir kata.

if - else: Logika percabangan. "Jika kotak nama tidak kosong, tambahkan data. Jika kosong (else), munculkan pesan peringatan."

JOptionPane.showMessageDialog: Perintah untuk memunculkan kotak pop-up kecil di layar (biasanya untuk pesan error atau peringatan).