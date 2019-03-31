@echo off
for /f "delims=" %%i in ('dir /o-d /b "*.jar"') do (
  set "aa=%%i"
  goto done
)
:done
echo %aa%
java -Xbootclasspath/a:./resources -jar %aa% spring