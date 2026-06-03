@echo off
REM Compile and Run Java Modules

REM Set the modules directory
set MODULES_DIR=%~dp0

REM Create output directory for compiled classes
if not exist "%MODULES_DIR%out" mkdir "%MODULES_DIR%out"

echo.
echo ========================================
echo Compiling Java Modules
echo ========================================
echo.

REM Compile com.utils module first (no dependencies)
echo Compiling com.utils module...
javac --module-source-path "%MODULES_DIR%" -d "%MODULES_DIR%out" "%MODULES_DIR%com.utils\module-info.java" "%MODULES_DIR%com.utils\com\utils\MessageUtil.java"

if %ERRORLEVEL% NEQ 0 (
    echo Error compiling com.utils!
    exit /b 1
)
echo com.utils compiled successfully!
echo.

REM Compile com.greetings module (depends on com.utils)
echo Compiling com.greetings module...
javac --module-source-path "%MODULES_DIR%" --module-path "%MODULES_DIR%out" -d "%MODULES_DIR%out" "%MODULES_DIR%com.greetings\module-info.java" "%MODULES_DIR%com.greetings\com\greetings\Main.java"

if %ERRORLEVEL% NEQ 0 (
    echo Error compiling com.greetings!
    exit /b 1
)
echo com.greetings compiled successfully!
echo.

echo ========================================
echo Running the Application
echo ========================================
echo.

REM Run the application
java --module-path "%MODULES_DIR%out" ^
     --module com.greetings/com.greetings.Main

echo.
echo ========================================
echo Done!
echo ========================================
