Feature: Dashboard - Jumlah Client

  Scenario: View detail Jumlah Client
    When Klik tombol jumlah client
    Then Menampilkan halaman form detail client "Detail Client"

  Scenario: Show Entries
    When Klik dropdown value clients
    And Select value client entire "10"
    Then Menampilkan data client dengan jumlah record berdasarkan value

  Scenario: Search Data Client Valid
    When Input keyword by client name "HCI"
    And Click tombol search
    Then Menampilkan data client

  Scenario Outline: Search Data Client Invalid
    When Input keyword by client name "<Keyword>"
    And Click tombol search
    Then Menampilkan pesan data client kosong

    Examples:
      | Keyword    |
      | dfgdfjhj   |
      | aB12@#$%>. |

  Scenario: Back to Dashboard Page
    When Klik tombol back client
    Then Kembali ke menu dashboard "Dashboard"