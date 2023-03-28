Feature: Login Page

  Scenario Outline: Check access url login page
    Given Input url web lamar yang benar "<Url>"
    Then Menampilkan halaman login "<TxtLoginPage>"
    Examples:
      | Url                                     | TxtLoginPage       |
      | https://dev.ptdika.com/lamar2/loginuser | 404 Page Not Found |
      | https://dev.ptdika.com/lamar2/login     | Login Page         |

  Scenario Outline: Check login page
    When Input username yang terdaftar "<Username>"
    And Input password yang terdaftar "<Password>"
    And Klik tombol Sign In
    Then Berhasil login dan menampilkan halaman dashboard "<msgResponses>"

    Examples:
      | Username | Password | msgResponses                    |
      | basdfa   | 12345678 | Username or Password Incorrect! |
      | bd       | 12345678 | Dashboard                       |

