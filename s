#!/bin/bash

LLVM_SRC_DIR="/path/to/llvm"
CLANG_SRC_DIR="/path/to/clang"
BUILD_DIR="/path/to/build"

mkdir -p "$BUILD_DIR"
cd "$BUILD_DIR" || exit

if [ ! -d "$LLVM_SRC_DIR" ]; then
    echo "LLVM source directory not found. Please provide the correct path."
    exit 1
fi

if [ ! -d "$CLANG_SRC_DIR" ]; then
    echo "Clang source directory not found. Please provide the correct path."
    exit 1
fi

echo "Configuring LLVM..."
cmake -G Ninja "$LLVM_SRC_DIR" -DCMAKE_BUILD_TYPE=Release -DLLVM_ENABLE_PROJECTS="clang"

echo "Building LLVM and Clang..."
ninja llvm clang


echo "Compiling example program..."
clang -o example example.c

echo "Running example program..."
./example

echo "Script execution completed."