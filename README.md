# Демо автоматизации UI-тестов для сайта [ГК "Иннотех"](https://inno.tech/ru/)
![image](https://user-images.githubusercontent.com/98316705/218818302-e839d809-55ac-4b59-8eab-f225c114ac90.png)


## :bookmark_tabs: <a id="list"></a> Содержание 

* <a href="#tools">Технологии и инструменты</a>

* <a href="#cases">Реализованные проверки</a>

* <a href="#integrations">Подключенные интеграции</a>

* <a href="#console">Запуск из терминала</a>

* <a href="#jenkins">Сборка в Jenkins</a>

* <a href="#allure">Allure отчеты</a>

* <a href="#telegram">Отчёт в Telegram</a>

* <a href="#testops">Интеграция с Allure TestOps</a>

* <a href="#jira">Интеграция с Jira</a>

* <a href="#video">Пример прогона теста в Selenoid</a>


## :hammer_and_wrench: <a id="tools"></a> Технологии и инструменты
<p align="center">
<a href="https://www.jetbrains.com/idea/"><img width="75" alt="IDEA" src="readme/icons/Intelij_IDEA.svg"></a>
<a href="https://www.java.com/"><img width="75" alt="JAVA" src="readme/icons/Java.svg"></a>
<a href="https://github.com/"><img width="75" alt="Github" src="readme/icons/GitHub.svg"></a>
<a href="https://junit.org/junit5/"><img width="75" alt="JUnit5" src="readme/icons/JUnit5.svg"></a>
<a href="https://gradle.org/"><img width="75" alt="Gradle" src="readme/icons/Gradle.svg"></a>
<a href="https://selenide.org/"><img width="75" alt="Selenide" src="readme/icons/Selenide.svg"></a>
<a href="https://aerokube.com/selenoid/"><img width="75" alt="Selenoid" src="readme/icons/Selenoid.svg"></a>
<a href="https://github.com/allure-framework/allure2"><img width="75" alt="Allure" src="readme/icons/Allure.svg"></a>
<a href="https://qameta.io)"><img width="55" alt="TestOps" src="readme/icons/TestOpspng.png"></a>
<a href="https://www.jenkins.io/"><img width="75" alt="Jenkins" src="readme/icons/Jenkins.svg"></a>
<a href="https://telegram.org/"><img width="75" alt="Telegram" src="readme/icons/Telegram.svg"></a>
<a href="https://www.atlassian.com/ru/software/jira"><img width="75" alt="Jira" src="readme/icons/Jira.svg"></a>
</p>


## :white_check_mark: <a id="cases"></a> Реализованные проверки
:heavy_check_mark: Проверка основных элементов на главной странице   
:heavy_check_mark: Проверка перехода в Личный кабинет без vpn   
:heavy_check_mark: Проверка перехода на страницу Карьера   
:heavy_check_mark: Проверка работы фильтра вакансий - есть хотя бы 1 вакансия   
:heavy_check_mark: Проверка работы фильтра вакансий - вакансий не найдено   

<a href="#list">К Содержанию</a>

## :on:	<a id="integrations"></a> Подключенные интеграции
:heavy_check_mark: Запуск автотестов в Jenkins   
:heavy_check_mark: Allure Report + SelenideLogger.addListener + step()   
:heavy_check_mark: Уведомление от бота в Telegram с отчетом о прохождении тестов   
:heavy_check_mark: Allure TestOps   
:heavy_check_mark: Jira   
:heavy_check_mark: Selenoid   

<a href="#list">К Содержанию</a>

## :desktop_computer: <a id="console"></a> Запуск из терминала
### Локальный запуск тестов

```
gradle clean innotech_test 
```

### Удаленный запуск тестов

```
gradle clean innotech_test
"-Dbrowser=${BROWSER}"
"-DbrowserVersion=${BROWSER_VERSION}"
"-DbrowserSize=${BROWSER_SIZE}"
"-Dremote=${REMOTE}"
```

> `${BROWSER}` - наименование браузера (_по умолчанию - <code>chrome</code>_).
>
> `${BROWSER_VERSION}` - версия браузера (_по умолчанию - <code>100.0</code>_).
>
> `${BROWSER_SIZE}` - размер окна браузера (_по умолчанию - <code>1920x1080</code>_).
>
> `${REMOTE_URL}` - адрес удаленного сервера, на котором будут запускаться тесты.

<a href="#list">К Содержанию</a>

## <a id="jenkins"></a> <img width="30" alt="Jenkins" src="readme/icons/Jenkins_ico.svg"> Сборка в Jenkins

:information_source: При сборке в Jenkins можно выбрать параметры из выпадающих списков   

<img alt="Jenkins_screenshot" src="readme/screenshots/Jenkins.PNG">

<a href="#list">К Содержанию</a>

## <a id="allure"></a> <img width="30" alt="Allure" src="readme/icons/Allure_ico.svg"> Allure отчеты

:information_source: По итогам сборки в Jenkins собирается отчет в Allure Report   
* Автотесты написаны как "шаги" через SelenideLogger.addListener + step() = описание пройденных тестов понятно любому сотруднику
* Подключено добавление в отчет:   
  - последнего скриншота
  - ресурсов страницы
  - логов браузера
  - видео прохождения тестов

<img alt="Jenkins_screenshot" src="readme/screenshots/AllureReportMain.PNG">
<img alt="Jenkins_screenshot" src="readme/screenshots/AllureReportSuites.PNG">

<a href="#list">К Содержанию</a>

## <a id="telegram"></a> <img width="30" alt="Telegram" src="readme/icons/Telegram_ico.svg"> Отчёт в Telegram


<a href="#list">К Содержанию</a>

## <a id="testops"> <img width="25" alt="TestOps" src="readme/icons/TestOpspng.png"> Интеграция с Allure TestOps


<a href="#list">К Содержанию</a>

## <a id="jira"></a> <img width="30" alt="Jira" src="readme/icons/Jira.svg"> Интеграция с Jira


<a href="#list">К Содержанию</a>

## <a id="video"></a> <img width="30" alt="Selenoid" src="readme/icons/Selenoid_ico.svg"> Пример прогона теста в Selenoid


<a href="#list">К Содержанию</a>
