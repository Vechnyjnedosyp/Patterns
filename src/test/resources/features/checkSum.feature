#language:ru
#encoding:UTF-8

@test @cart
Функционал: Проверка части основного функционала сайта

  Сценарий: Проверка, что пользователь может отменить покупку
    Допустим открыта страница "https://www.saucedemo.com/"
    И в строку 'Username' введено значение "standard_user"
    А в строку 'Password' введено значение "secret_sauce"
    И нажата кнопка "login-button"
    Тогда откроется страница с товарами "PRODUCTS"
    И добавлен "2" товар в корзину
    И нажата ссылка "shopping_cart"
    И нажата кнопка "checkout"
    И вводится информация
    Тогда проверяется точность итоговой суммы до налогообложения