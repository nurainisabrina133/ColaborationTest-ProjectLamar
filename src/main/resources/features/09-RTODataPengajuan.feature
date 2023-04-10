Feature: Approve RRF - Data Pengajuan

  Scenario: View Halaman Approve RRF
    When Klik Approve RRF
    Then Menampilkan Halaman Approve RRF

  Scenario: View from data pengajuan
    When Klik View Data Pengajuan
    Then Menampilkan Halaman Data Aktif Pengajuan

  Scenario Outline: Search by Valid Keyword
    When Input valid keyword "<Keyword>"
    And Klik tombol search
    Then Menampilkan data sesuai dengan keyword yang diinput
    Examples:
      | Keyword  |
      | finaccel |
      | Kredivo  |
      | BSH      |
      | Jakarta  |
      | Magang   |
      | Mitra    |
      | PKWTT    |
      | PKWT     |

  Scenario Outline: Input invalid keyword di kolom search
    When Input invalid keyword "<Keyword>"
    And Klik tombol search
    Then Menampilkan No data available in table pada tabel data
    Examples:
      | Keyword |
      | TOPAN33 |
      | a@#$R23 |

  Scenario: Refresh from data pengajuan
    When Klik tombol Refresh
    Then Kembali ke halaman Approve RRF


  Scenario: Approve from data pengajuan IT
    When Klik tombol Approve
    And Klik tombol IT
    And Klik ok pada notifikasi approve recruitment request
    Then Status berhasil diupdate

  Scenario: Cancel Approve from data pengajuan IT
    When Klik tombol Approve
    And Klik tombol IT
    And Klik cancel pada notifikasi approve recruitment request
    Then Menampilkan Halaman Approve RRF

  Scenario: Approve from data pengajuan NON IT
    When Klik tombol Approve
    And Klik tombol NON IT
    And Klik ok pada notifikasi approve recruitment request
    Then Status berhasil diupdate

  Scenario: Cancel Approve from data pengajuan NON IT
    When Klik tombol Approve
    And Klik tombol NON IT
    And Klik cancel pada notifikasi approve recruitment request
    Then Menampilkan Halaman Approve RRF

  Scenario: Return from data pengajuan
    When Klik tombol Return
    And Input Keyword Note
    Then Klik tombol Update

  Scenario: Cancel Return from data pengajuan
    When Klik tombol Return
    And Klik tombol Batal
    Then Menampilkan Halaman Approve RRF

  Scenario: Pilih value show entries
    When Klik dropdown value
    And Pilih value entries "10"
    Then Menampilkan data aktif dengan jumlah record berdasarkan value






