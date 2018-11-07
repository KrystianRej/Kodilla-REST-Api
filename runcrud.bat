call gradlew build
if "%ERRORLEVEL%" == "0" goto rename
echo.
echo GRADLEW BUILD has errors - breaking work
goto fail

:rename
del build\libs\crud.war
echo file deleted
ren build\libs\tasks-0.0.1-SNAPSHOT.war crud.war
echo file renamed
if "%ERRORLEVEL%" == "0" goto stoptomcat
echo Cannot rename file
goto fail

:stoptomcat
call %CATALINA_HOME%\bin\shutdown.bat
echo zatrzymano

:copyfile
copy build\libs\crud.war %CATALINA_HOME%\webapps
echo zatrzymano po raz 2
if "%ERRORLEVEL%" == "0" goto runtomcat
echo Cannot copy file
goto fail

:runtomcat
call %CATALINA_HOME%\bin\startup.bat
echo zatrzymano po raz 3
goto end

:fail
echo.
echo There were errors

:end
echo.
echo Work is finished.
