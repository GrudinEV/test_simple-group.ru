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
