# test-job-books

Для получения jar выполняем
cd <Dorectory_of_your_project>
mvn package

Упаковываем приложение в docker контейнер
cd <Dorectory_of_your_project>
docker build -t test-job-books-simple:0.0.1 .

Запускаем полученный образ
docker run -d -p 8080:9090 -t test-job-books-simple:0.0.1
