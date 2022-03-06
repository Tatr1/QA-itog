### ДИПЛОМНАЯ РАБОТА профессии Тестировщик

Автоматизация тестирования представленного сервиса (оплата/кредит по спецпредложению).

#### Начало работы
Открыть IntelliJ IDEA

#### Установка и запуск
(ОС Windows)
1. Открыть дипломную работу по ссылке: https://github.com/Tatr1/QA-itog.git;
2. Скачать работу (git clone);
3. Запустить сервис: docker-compose up;
4. Запустить приложение: <!---java -jar artifacts/aqa-shop.jar-->
- c MySQL: java <!---"-Dspring.datasource.url=jdbc:mysql://localhost:3300/app"--> -jar artifacts/aqa-shop.jar
- c PostgreSQL: java "-Dspring.datasource.url=jdbc:postgresql://localhost:5432/app" -jar artifacts/aqa-shop.jar
5. Запустить тесты: 
- c MySQL: ./gradlew clean test <!---"-Ddb.url=jdbc:mysql://localhost:3300/app"-->
- c PostgreSQL: ./gradlew clean test "-Ddb.url=jdbc:postgresql://localhost:5432/app"
6. Сгенерировать отчет о тестировании: ./gradlew allureServe;
7. Остановить приложение: Ctrl-C;
8. Остановить сервис: docker-compose down 

Документация к проекту:
1. [План автоматизации](./doc/Plan.md)
2. [Отчет о проведенном тестировании](./doc/Report.md)
3. [Отчет по итогам автоматизации](./doc/Summary.md)

