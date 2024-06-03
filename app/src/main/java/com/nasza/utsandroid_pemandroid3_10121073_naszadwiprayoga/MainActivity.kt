package com.nasza.utsandroid_pemandroid3_10121073_naszadwiprayoga

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var radioGroupTest: RadioGroup
    private lateinit var editTextTanggal: EditText
    private lateinit var editTextNama: EditText
    private lateinit var editTextNik: EditText
    private lateinit var editTextTanggalLahir: EditText
    private lateinit var radioGroupJenisKelamin: RadioGroup
    private lateinit var radioGroupRelationship: RadioGroup
    private lateinit var button: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Inisialisasi komponen
        editTextTanggal = findViewById(R.id.editTextTanggal)
        editTextNik = findViewById(R.id.editTextNik)
        editTextNama = findViewById(R.id.editTextNama)
        editTextTanggalLahir = findViewById(R.id.editTextTanggalLahir)
        radioGroupJenisKelamin = findViewById(R.id.jeniskelamin)
        radioGroupRelationship = findViewById(R.id.radioGroupRelationship)
        radioGroupTest = findViewById(R.id.radioGroupTest)
        button = findViewById(R.id.button)

        // Atur data jika ada yang dikirim dari IsiData
        val nama = intent.getStringExtra("nama") ?: ""
        val tanggal = intent.getStringExtra("tanggal") ?: ""
        val nik = intent.getStringExtra("nik") ?: ""
        val tanggalLahir = intent.getStringExtra("tanggal_lahir") ?: ""
        val jenisKelamin = intent.getStringExtra("jenis_kelamin") ?: ""
        val hubungan = intent.getStringExtra("hubungan") ?: ""
        val jenisTes = intent.getStringExtra("jenis_tes") ?: ""

        // Set data ke EditText
        editTextNama.setText(nama)
        editTextTanggal.setText(tanggal)
        editTextNik.setText(nik)
        editTextTanggalLahir.setText(tanggalLahir)

        // Set data ke RadioGroup
        if (jenisKelamin.isNotEmpty()) {
            for (i in 0 until radioGroupJenisKelamin.childCount) {
                val radioButton = radioGroupJenisKelamin.getChildAt(i) as RadioButton
                if (radioButton.text.toString() == jenisKelamin) {
                    radioButton.isChecked = true
                    break
                }
            }
        }
        if (hubungan.isNotEmpty()) {
            for (i in 0 until radioGroupRelationship.childCount) {
                val radioButton = radioGroupRelationship.getChildAt(i) as RadioButton
                if (radioButton.text.toString() == hubungan) {
                    radioButton.isChecked = true
                    break
                }
            }
        }
        if (jenisTes.isNotEmpty()) {
            for (i in 0 until radioGroupTest.childCount) {
                val radioButton = radioGroupTest.getChildAt(i) as RadioButton
                if (radioButton.text.toString() == jenisTes) {
                    radioButton.isChecked = true
                    break
                }
            }
        }

        // Atur OnClickListener untuk tombol
        button.setOnClickListener {
            // Ambil data dari EditText dan RadioButton
            val nama = editTextNama.text.toString()
            val tanggal = editTextTanggal.text.toString()
            val nik = editTextNik.text.toString()
            val tanggalLahir = editTextTanggalLahir.text.toString()
            val jenisKelaminId = radioGroupJenisKelamin.checkedRadioButtonId
            val hubunganId = radioGroupRelationship.checkedRadioButtonId
            val jenisTesId = radioGroupTest.checkedRadioButtonId

            // Validasi data
            if (nama.isEmpty() || tanggal.isEmpty() || nik.isEmpty() || tanggalLahir.isEmpty() ||
                jenisKelaminId == -1 || hubunganId == -1 || jenisTesId == -1) {
                Toast.makeText(this, "Harap isi semua data yang diperlukan.", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            // Jika semua data sudah diisi, lanjutkan ke aktivitas berikutnya
            val jenisKelamin = findViewById<RadioButton>(jenisKelaminId).text.toString()
            val hubungan = findViewById<RadioButton>(hubunganId).text.toString()
            val jenisTes = findViewById<RadioButton>(jenisTesId).text.toString()

            // Buat Intent untuk ActivityIsiData
            val intent = Intent(this@MainActivity, IsiData::class.java)
            // Masukkan data ke Intent
            intent.putExtra("nama", nama)
            intent.putExtra("tanggal", tanggal)
            intent.putExtra("nik", nik)
            intent.putExtra("tanggal_lahir", tanggalLahir)
            intent.putExtra("jenis_kelamin", jenisKelamin)
            intent.putExtra("hubungan", hubungan)
            intent.putExtra("jenis_tes", jenisTes)
            // Mulai ActivityIsiData
            startActivity(intent)
        }
    }
}
