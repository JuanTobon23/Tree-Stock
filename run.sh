#!/bin/bash
# Script para compilar y ejecutar el Sistema de Inventario

echo "═══════════════════════════════════════════════════════════"
echo "   COMPILACION - Sistema de Inventario con Árbol BST"
echo "═══════════════════════════════════════════════════════════"

# Compilar los archivos Java
echo ""
echo "[1/2] Compilando archivos Java..."
javac src/Producto.java src/ArbolInventario.java src/Main.java

# Verificar si la compilación fue exitosa
if [ $? -ne 0 ]; then
    echo ""
    echo "✗ ERROR: La compilación falló."
    exit 1
fi

echo "✓ Compilación exitosa"
echo ""
echo "[2/2] Ejecutando la aplicación..."
echo "═══════════════════════════════════════════════════════════"
echo ""

# Ejecutar la aplicación
java -cp src Main

echo ""
echo "═══════════════════════════════════════════════════════════"
echo ""
