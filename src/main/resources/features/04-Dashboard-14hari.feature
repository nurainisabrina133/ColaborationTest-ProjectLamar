Feature: Dashboard - 14 Hari

  Scenario: View detail data offering
    When Klik tombol view detail 14 hari
    Then Menampilkan halaman form detail data offering "Detail Data Offering"

  Scenario: Search Data Offering Valid
    When Input keyword by name "Sitti"
    And Click tombol search
    Then Menampilkan data offering

  Scenario Outline: Search Data Offering Invalid
    When Input keyword by name "<Keyword>"
    And Click tombol search
    Then Menampilkan pesan data offering kosong

    Examples:
      | Keyword       |
      | yangseru      |
      | aB12@#$%dfg>. |

  Scenario: Show Entries
    When Klik dropdown value
    And Select value entire "10"
    Then Menampilkan data offering dengan jumlah record berdasarkan value

  Scenario: Back to Dashboard Page
    When Klik tombol back
    Then Kembali ke menu dashboard "Dashboard"