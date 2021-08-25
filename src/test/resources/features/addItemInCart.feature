#language:ru
#encoding:UTF-8

@test @cart
Функционал: Проверка части основного функционала сайта

  Сценарий: Проверка, что пользователь может добавить товар в корзину
    Допустим открыта страница "https://www.saucedemo.com/"
    И в строку 'Username' введено значение "standard_user"
    А в строку 'Password' введено значение "secret_sauce"
    И нажата кнопка "login"
    Тогда откроется страница с товарами "PRODUCTS"
    И добавлен товар в корзину
    Тогда в корзине появится "1" товар