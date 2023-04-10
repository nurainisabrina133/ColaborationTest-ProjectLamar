Feature: Approve RRF - Data Aktif

  Scenario: View Halaman Data Aktif
    When Klik Data Aktif
    Then Menampilkan Index RRF Aktif

  Scenario: Pilih value show entries Data Aktif
    When Klik dropdown value Data Aktif
    And Pilih value entries "10" Data Aktif
    Then Menampilkan data aktif dengan jumlah record berdasarkan value Data Aktif

  Scenario Outline: Search by valid keyword from Data Aktif
    When Input valid keyword "<Keyword>" from Data Aktif
    And Klik tombol search from Data Aktif
    Then Menampilkan data sesuai dengan keyword yang diinput form Data Aktif
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

  Scenario Outline: Input invalid keyword di kolom search from Data Aktif
    When Input invalid keyword "<Keyword>" from data aktif
    And Klik tombol search from Data Aktif
    Then Menampilkan No data available in table pada tabel data from Data Aktif
    Examples:
      | Keyword |
      | TOPAN33 |
      | a@#$R23 |

  Scenario: Refresh from Data Aktif
    When Klik tombol Refresh From Data Aktif
    Then Kembali ke Halaman Index RRF Aktif

  Scenario: View Data Aktif
    When Klik View Data
    Then Menampilkan Halaman Data Aktif

    Scenario: Download Data
      When Klik Data Aktif
      And Klik tombol Download Data
      Then Download Berhasil

  Scenario: Logout
    When Klik Icon User
    And Klik tombol Logout
    Then Menampilkan Halaman Login





