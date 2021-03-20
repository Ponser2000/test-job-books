# test-job-books

Для получения jar выполняем<br> 
cd <Dorectory_of_your_project><br>
mvn package

Упаковываем приложение в docker контейнер <br>
cd <Dorectory_of_your_project><br>
docker build -t test-job-books-simple:0.0.1 .

Запускаем полученный образ<br>
docker run -d -p 8080:9090 -t test-job-books-simple:0.0.1
