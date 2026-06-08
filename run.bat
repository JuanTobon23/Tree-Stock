@echo off
REM Script para compilar y ejecutar el Sistema de Inventario

echo ═══════════════════════════════════════════════════════════
echo   COMPILACION - Sistema de Inventario con Árbol BST
echo ═══════════════════════════════════════════════════════════

REM Compilar los archivos Java
echo.
echo [1/2] Compilando archivos Java...
javac src\Producto.java src\ArbolInventario.java src\Main.java

REM Verificar si la compilación fue exitosa
if %ERRORLEVEL% neq 0 (
    echo.
    echo ✗ ERROR: La compilación falló.
    pause
    exit /b 1
)

echo ✓ Compilación exitosa
echo.
echo [2/2] Ejecutando la aplicación...
echo ═══════════════════════════════════════════════════════════
echo.

REM Ejecutar la aplicación
java -cp src Main

echo.
echo ═══════════════════════════════════════════════════════════
echo.
pause
