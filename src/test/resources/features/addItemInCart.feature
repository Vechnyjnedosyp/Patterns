#language:ru
#encoding:UTF-8

@test @cart

@severity=CRITICAL
@issue=2
@tmsLink=02

Функционал: Проверка части основного функционала сайта

  Сценарий: 1.1 Проверка, что пользователь может добавить товар в корзину
    Допустим открыта страница "https://www.saucedemo.com/"
    И в строку 'Username' введено значение "standard_user"
    А в строку 'Password' введено значение "secret_sauce"
    И нажата кнопка "login-button"
    Тогда откроется страница с товарами "PRODUCTS"
    И добавлен "1" товар в корзину
    Тогда в корзине находится "1" товар

  Сценарий: 1.2 Чистка изменений в аккаунте тестового пользователя
    Допустим открыта страница "https://www.saucedemo.com/cart.html"
    Затем удален "1" товар из корзины
    Тогда в корзине осталось "0" товаров
