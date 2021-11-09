# test_simple-group.ru

## Задание
Имеется набор входных данных, представленных текстовыми файлами в формате JSON.  
Необходимо реализовать приложение, обладающее следующим функционалом:
1.	Выводит в лог список названий всех уникальных параметров, встречающихся в wellParameters.json.
2.	Для скважин с id от 10 до 30 (предусмотреть подачу на вход метода других значений) выводит в лог название скважины, а также название и минимальное, максимальное и среднее арифметическое значения каждого параметра, если по нему имеется хоть 1 значение в wellParameters.json.
3.	Выводит в лог название скважины и её принадлежность к месторождению.

## Пояснения к решению
Решение базовой задачи тестового задания выполнено на Java.  
Методы задания реализованы в пакете service.  
Для логирования ошибок подключен логгер slf4j.  
Для десериализации объектов из Json подключен Jackson.

### 03.11.2021 Реализованы следующие пункты из раздела "Усложнения" тестового задания.  
2.	Предусмотреть возможность задания пути до файлов без необходимости перекомпиляции программы.  
  Сборка проекта в корне: "mvn package"  
  Файлы с данными json разместить в директории, например директории "target/input"  
  Запуск приложения: "java -jar test_simpl-group.ru-1.0-SNAPSHOT-jar-with-dependencies.jar <относительный путь к директории с файлами json>".   
  При размещении файлов в папке "target/input" запуск приложения: "java -jar test_simpl-group.ru-1.0-SNAPSHOT-jar-with-dependencies.jar input".  
  Запуск приложения со стандартным размещением файлов json в директории resources: "java -jar test_simpl-group.ru-1.0-SNAPSHOT-jar-with-dependencies.jar ../src/main/resources".  
    
3.	Кроме выведения данных в лог (консоль) сформировать один или несколько файлов с результатами работы программы, а также временем выполнения каждого обязательного задания.  
  Запись логов производится в консоль и файл logs/output.log с указанием времени выполнения записи.

### 08.11.2021 Реализован следующий пункт из раздела "Усложнения" тестового задания.
1.	Предусмотреть возможность изменения источника данных для приложения без существенных изменений в коде программы (например, на БД).  

C новой реализацией можно ознакомиться в новой ветке spring_mysql_add
Подключена база MySQL.
Для заполнения базы данных MySQL сформирован класс AddedDataFromJsonToBd. В работе приложения не участвует.  
Т.к. задача была выполнить пункт без существенных изменений, добавлен Spring, обращение к базе данных производится через JDBCTemplate.  
При условии наличия уже сформированной базы данных, изменения в коде Java включают только новый класс для конфигурации SpringConfig и новый класс DBReaderImpl, реализующий интерфейс DataReader.

### 09.11.2021 Реализован следующий пункт из раздела "Усложнения" тестового задания.
5.	Реализовать REST веб-сервис, ендпоинты которого будут вызывать методы по обязательным заданиям (1-3). В качестве базы можно использовать файл базы H2.  

Добавлен Spring Boot.  
Реализован RestController.  
C новой реализацией можно ознакомиться в новой ветке rest_h2  
Однако, в качестве базы данных пока используется MySQL.
