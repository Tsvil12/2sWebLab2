# Лабораторная работа №2: Spring Boot. Начало
## Выполнил Цвиль Павел ФИТ-231

## Описание
REST API на Spring Boot + Kotlin. Реализованы эндпоинты по спецификации `specs.yaml`.

### 1. Подготовка репозитория
- Репозиторий-шаблон `NeonBite/spring-first` склонирован с GitVerse.
- Создан собственный репозиторий на GitHub: `Tsvil12/2sWebLab2`.


### 3. Реализованные эндпоинты

| Метод | URL | Описание |
|-------|-----|----------|
| GET | `/greeting` | Без `id` → `{"text":"Hello World"}`. С `id` → поиск пользователя |
| POST | `/greeting` | Принимает `{"name":"...","surname":"..."}`, возвращает `id` |
| GET | `/greeting/{id}` | Поиск пользователя по UUID из пути |

### Пример работы системы: 

- Запрос: Invoke-RestMethod -Uri "http://localhost:8080/greeting"
- Вывод: Hello World

- Запрос: Invoke-RestMethod -Uri "http://localhost:8080/greeting" -Method Post -Body '{"name":"pavel","surname":"tsvil"}' -ContentType "application/json" 
- Вывод: Hello, tsvil pavel fa85241d-5a8c-4791-bb1d-e7ce7bfcb323

- Запрос: Invoke-RestMethod -Uri "http://localhost:8080/greeting?id=fa85241d-5a8c-4791-bb1d-e7ce7bfcb323"
- Вывод: pavel tsvil