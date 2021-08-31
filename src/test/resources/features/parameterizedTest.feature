#language:ru
#encoding:UTF-8

@test @param

@severity=BLOCKER
@issue=1
@tmsLink=01

Функционал: Параметризированный запуск тестов

  Структура сценария: Проверка логирования на сайте
    Допустим открыта страница "https://www.saucedemo.com/"
    И в строку 'Username' введено значение "<Username>"
    А в строку 'Password' введено значение "<Password>"
    И нажата кнопка "<Button>"
    Тогда откроется страница с товарами "<Title>"

    Примеры:
      | Username      | Password     | Title    | Button           |
      | standard_user | secret_sauce | PRODUCTS | login-button     |
