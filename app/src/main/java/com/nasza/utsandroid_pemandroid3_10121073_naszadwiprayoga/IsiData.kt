package com.nasza.utsandroid_pemandroid3_10121073_naszadwiprayoga

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import com.google.android.material.bottomsheet.BottomSheetDialog

class IsiData : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_isi_data)

        // Set up the toolbar
        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)

        // Enable the Up button
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(true)

        // Ambil data yang dikirim dari MainActivity
        val nama = intent.getStringExtra("nama")
        val tanggal = intent.getStringExtra("tanggal")
        val nik = intent.getStringExtra("nik")
        val tanggalLahir = intent.getStringExtra("tanggal_lahir")
        val jenisKelamin = intent.getStringExtra("jenis_kelamin")
        val hubungan = intent.getStringExtra("hubungan")
        val jenisTes = intent.getStringExtra("jenis_tes")

        // Temukan TextView di layout
        val textViewNamaData = findViewById<TextView>(R.id.textViewNamaData)
        val textViewTanggalData = findViewById<TextView>(R.id.textViewTanggalData)
        val textViewNikData = findViewById<TextView>(R.id.textViewNikData)
        val textViewTanggalLahirData = findViewById<TextView>(R.id.textViewTanggalLahirData)
        val textViewJenisKelaminData = findViewById<TextView>(R.id.textViewJenisKelaminData)
        val textViewHubunganData = findViewById<TextView>(R.id.textViewHubunganData)
        val textViewJenisTesData = findViewById<TextView>(R.id.textViewJenisTesData)

        // Setel teks pada TextView sesuai dengan data yang diterima
        textViewNamaData.text = nama
        textViewTanggalData.text = tanggal
        textViewNikData.text = nik
        textViewTanggalLahirData.text = tanggalLahir
        textViewJenisKelaminData.text = jenisKelamin
        textViewHubunganData.text = hubungan
        textViewJenisTesData.text = jenisTes

        // Tambahkan fungsi untuk menampilkan popup saat tombol cek hasil diklik
        val btnCekHasil: Button = findViewById(R.id.button_hasil)
        btnCekHasil.setOnClickListener {
            // Menampilkan popup
            showBottomSheetDialog()
        }

        // Tambahkan fungsi untuk kembali ke MainActivity saat tombol ubah diklik
        val btnUbah: Button = findViewById(R.id.button_ubah)
        btnUbah.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            // Pass the existing data back to MainActivity
            intent.putExtra("nama", nama)
            intent.putExtra("tanggal", tanggal)
            intent.putExtra("nik", nik)
            intent.putExtra("tanggal_lahir", tanggalLahir)
            intent.putExtra("jenis_kelamin", jenisKelamin)
            intent.putExtra("hubungan", hubungan)
            intent.putExtra("jenis_tes", jenisTes)
            startActivity(intent)
        }
    }

    private fun showBottomSheetDialog() {
        // Inflate layout popup_success.xml
        val inflater: LayoutInflater = LayoutInflater.from(this)
        val view: View = inflater.inflate(R.layout.activity_popup_hasil, null)

        // Membuat BottomSheetDialog
        val dialog = BottomSheetDialog(this)
        dialog.setContentView(view)

        // Mendapatkan tombol OK dari layout popup
        val btnOk: Button = view.findViewById(R.id.button_ok)
        btnOk.setOnClickListener {
            // Menutup popup ketika tombol OK diklik
            dialog.dismiss()
        }

        // Menampilkan popup
        dialog.show()
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}
