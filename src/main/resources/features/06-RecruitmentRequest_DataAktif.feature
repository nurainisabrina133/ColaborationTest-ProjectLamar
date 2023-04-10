Feature: Recruitment Request - Data Aktif

  Scenario: View data aktif
    When Klik menu Reqruitment Request
    And Klik menu data aktif
    Then Menampilkan halaman data aktif "Data Recruitment Request"

  Scenario Outline: Filter data berdasarkan status
    When Pilih value status "<Status>"
    And Klik tombol filter
    Then Menampilkan data aktif berdasarkan status
    When Klik tombol + pada kolom No
    Then Check data sesuai dengan status "<TxtStatus>"

    Examples:
      | Status | TxtStatus |
      | open   | OPEN      |
      | closed | CLOSED    |
      | cancel | CANCEL    |
      | hold   | HOLD      |

  Scenario: Reset value pada filter status
    When Pilih value status
    And Klik tombol reset
    Then Value pada kolom filter status ter-reset

  Scenario: Show Entries
    When Klik dropdown value entries
    And Pilih value entrie
    Then Menampilkan data aktif dengan jumlah record berdasarkan value

  Scenario Outline: Search by invalid keyword
    When Input keyword search "<Keyword>"
    And Klik tombol search
    Then Menampilkan data aktif dengan invalid keyword "<txtResult>"

    Examples:
      | Keyword           | txtResult                 |
      | IniInvalidKeyword | No matching records found |
      | aBC21%$#?         | No matching records found |

  Scenario Outline: Search by valid keyword
    When Input keyword search "<Keyword>"
    And Klik tombol search
    Then Menampilkan data aktif sesuai dengan keyword search "<txtResult>"

    Examples:
      | Keyword    | txtResult  |
      | ZARA       | ZARA       |
      | HCI        | HCI        |
      | job_supply | job_supply |
      | It support | IT Support |
      | Magang     | MAGANG     |
      | Bandung    | Bandung    |
      | Shift      | Shift      |
      | Diploma    | DIPLOMA    |

  Scenario: View detail data recruitment request aktif
    When Klik tombol + pada kolom No
    And Klik tombol View Data
    Then Menampilkan view detail data recruitment request aktif

  Scenario: Back to Data Aktif Page
    When Klik tombol back data aktif
    Then Menampilkan halaman data aktif "Data Recruitment Request"

  Scenario: Download data aktif
    When Klik tombol + pada kolom No
    And Klik tombol Download Data
    Then Data aktif terdownload

  Scenario Outline: Update Status data Recruitment request
    When Klik tombol update status
    And Pilih status pada tampilan modal update status "<Status>"
    And Input notes "<Notes>"
    And Klik tombol update
    And Klik tombol Ok pada pesan alert
    Then Menampilkan pesan alert success "<txtAlert>"

    Examples:
      | Status | Notes          | txtAlert |
      | OPEN   | this notesss   | Success  |
      |        | Notess apa aja | true     |

    Scenario: Update Status data Recruitment request
      When Klik tombol update
      And Klik tombol Ok pada pesan alert
      Then Menampilkan pesan alert success "true"
    
  Scenario: Cancel Update Status data Recruitment request
    And Klik tombol cancel
    Then Menampilkan halaman data aktif "Data Recruitment Request"