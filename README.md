
Тесткейс 1 ( реєстрація )
1. Клікнути на кнопку Sing up ( має відкритись відповідна сторінка )
2. Вписати необхідну інформацію ( пошта та пароль )
3. активувати потрібні чекбокси
4. Натиснути кнопку submit
5. Ми маємо перейти на сторінку успішної реєстрації


Тесткейс 2 ( логін )
1. Клікнути на кнопку Lonin ( має відкритись відповідна модалка )
2. Вписати необхідну інформацію ( пошта та пароль )
3. Натиснути кнопку login
5. Ми маємо перейти на сторінку успішного логіну


Тесткейс 3 ( перевірка функціоналу модалки Login )
1. Title Login present and have text - Login
2. email textfield present and we can type in it some email
3. password textfield present and we can type in it some password
4. button Login present, when we hower button - it have red color, can click
5. button "I forgot my password " present and we can click on it


Тесткейс 4 ( перевірка функціоналу Header )
1. Open Home page
2. Click button humburger menu
3. all buttons of Header menu present
4. click on each Header menu button, as a result need to be opened next page


Тесткейс 5 ( перевірка функціоналу Footer )
1. Open Home page
2. scroll down to the Footer menu
3. all buttons of Footer menu present
4. click on each Footer menu button, as a result need to be opened next page
   

Тест кейс 6 (Неуспішні сценарії логіну з data provider)
1. open the home page
2. click on the button login
3. fill in the Login form, using data from the data provider
4. click the button login
5. check info messages on each step of the data provider scenario

Scenarios:

1. empty email, empty pass
2. incorrect email, empty pass
3. empty email, incorrect pass
4. incorrect email, incorrect pass
5. email without "@", correct pass
6. correct email, incorrect pass
7. incorrect email, correct pass

Завдання 2:

1. створити тест сьюти та обєднати в них тести по функціоналу
2. запускати конкретно тести із тест сьюти, або запускати тест сьюту зі всіма тестами в середині за допомогою терміналу та maven команди