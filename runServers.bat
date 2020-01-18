@echo off

cd %windir%\system32
SET DEVELOPMENT_HOME=E:\GitProjects\SpringCloud\SpringCloud

start cmd.exe /c "cd /d %DEVELOPMENT_HOME%\spring-cloud-config-server && mvn spring-boot:run

start cmd.exe /c "cd /d %DEVELOPMENT_HOME%\netflix-eureka-naming-server && mvn spring-boot:run

SLEEP 100

start cmd.exe /c "cd /d %DEVELOPMENT_HOME%\limits-service && mvn spring-boot:run

start cmd.exe /c "cd /d %DEVELOPMENT_HOME%\currency-exchange-service && mvn spring-boot:run

start cmd.exe /c "cd /d %DEVELOPMENT_HOME%\currency-exchange-service && mvn spring-boot:run -Dspring-boot.run.arguments=--server.port=8001

SLEEP 100

start cmd.exe /c "cd /d %DEVELOPMENT_HOME%\currency-conversion-service && mvn spring-boot:run

start cmd.exe /c "cd /d %DEVELOPMENT_HOME%\currency-conversion-service && mvn spring-boot:run -Dspring-boot.run.arguments=--server.port=8101
