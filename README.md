### Hexlet tests and linter status:
[![Actions Status](https://github.com/AlexanderKireev/java-project-71/workflows/hexlet-check/badge.svg)](https://github.com/AlexanderKireev/java-project-71/actions)
[![Linter Status](https://github.com/AlexanderKireev/java-project-71/workflows/Build/badge.svg)](https://github.com/AlexanderKireev/java-project-71/actions)
[![Maintainability](https://api.codeclimate.com/v1/badges/53ebfd13723a6a6bd91d/maintainability)](https://codeclimate.com/github/AlexanderKireev/java-project-71/maintainability)
[![Test Coverage](https://api.codeclimate.com/v1/badges/53ebfd13723a6a6bd91d/test_coverage)](https://codeclimate.com/github/AlexanderKireev/java-project-71/test_coverage)
## Проект "Вычислитель отличий" ("Difference Calculator")
Выполнен в рамках обучения в компании "Хекслет" ("Hexlet Ltd.") на курсе java-программирования.

Сдан на проверку: ХХ ноября 2022 года. Студент: Киреев Александр. Куратор: Теплинская Мария ("Hexlet Ltd.").

[![Hexlet Ltd. logo](https://raw.githubusercontent.com/Hexlet/assets/master/images/hexlet_logo128.png)](https://ru.hexlet.io/pages/about?utm_source=github&utm_medium=link&utm_campaign=java-package)

Резульат Проекта - консольная утилита *gendiff*, сравнивающая содержимое двух текстовых файлов (информацию об обмене данными). Поддерживаются два формата сравниваемых файлов: Json и Yaml.

Формат командной строки утилиты:
```java
gendiff [-hV] [-f=<formatName>] <filepath1> <filepath2>
```

Возможны как абсолютные, так и относительные пути к файлам. 

Параметры утилиты gendiff: 
```java
-h, --help      вывод справки по утилите
-V, --version   версия утилиты 
<filepath1>     путь к первому файлу     
<filepath2>     путь ко второму файлу
-f, --format    выбор формата вывода информации
```
#### Пример вывода справки (4 шаг Проекта):
[![asciicast](https://asciinema.org/a/531153.svg)](https://asciinema.org/a/531153)

#### Пример сравнения Json-файлов (5 шаг Проекта):
[![asciicast](https://asciinema.org/a/531479.svg)](https://asciinema.org/a/531479)

#### Пример сравнения Yaml-файлов (7 шаг Проекта):
[![asciicast](https://asciinema.org/a/531456.svg)](https://asciinema.org/a/531456)

Необязательный параметр - выбор формата вывода результата на экран. Определяется командой -f (--format) из трех возможных: *stylish* (по умолчанию), *plain* и *json*.
#### Шаг 8 Проекта: вывод в формате stylish
[![asciicast](https://asciinema.org/a/531467.svg)](https://asciinema.org/a/531467)

#### Шаг 9 Проекта: вывод в формате plain
[![asciicast](https://asciinema.org/a/531469.svg)](https://asciinema.org/a/531469)

#### Шаг 10 Проекта: вывод в формате json
[![asciicast](https://asciinema.org/a/531473.svg)](https://asciinema.org/a/531473)
