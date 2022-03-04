### ДИПЛОМНАЯ РАБОТА профессии Тестировщик

Автоматизация тестирования представленного сервиса (оплата/кредит по спецпредложению).

##### НАЧАЛО РАБОТЫ
Открыть IntelliJ IDEA

##### Установка и запуск
1. Открыть дипломную работу по ссылке:
2. Скачать работу (git clone);
3. Запустить сервис docker-compose up
4. Запустить приложение: <!---java -jar artifacts/aqa-shop.jar-->
- c MySQL: java <!---"-Dspring.datasource.url=jdbc:mysql://localhost:3300/app"--> -jar artifacts/aqa-shop.jar
- c PostgreSQL: java "-Dspring.datasource.url=jdbc:postgresql://localhost:5432/app" -jar artifacts/aqa-shop.jar
5. Запустить тесты: 
- c MySQL: ./gradlew clean test <!---"-Ddb.url=jdbc:mysql://localhost:3300/app"-->
- c PostgreSQL: ./gradlew clean test "-Ddb.url=jdbc:postgresql://localhost:5432/app"
6. Сгенерировать отчет ./gradlew allureServe
7. Остановить сервис docker-compose down 

