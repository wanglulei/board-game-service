@echo off  
if exist src rd /S /Q src  
mkdir src\main\java  
mkdir src\main\resources  
java -cp extend-1.0.jar;mybatis-generator-core-1.3.6.jar org.mybatis.generator.api.ShellRunner -configfile generatorConfig.xml -overwrite
pause 