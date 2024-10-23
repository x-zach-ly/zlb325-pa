#!/bin/bash

# Script to run JPF code coverage analysis
# Usage: ./s <java_file>

# Exit on any error
set -e

# Check if input file is provided
if [ $# -ne 1 ]; then
    echo "Usage: ./s <java_file>"
    echo "Example: ./s Example.java"
    exit 1
fi

# Input file
INPUT_FILE="$1"
FILENAME=$(basename "$INPUT_FILE" .java)

# Create results directory if it doesn't exist
mkdir -p results

# Verify input file exists
if [ ! -f "$INPUT_FILE" ]; then
    echo "Error: File $INPUT_FILE not found"
    exit 1
fi

# Setup classpath
JPF_HOME=${JPF_HOME:-"../jpf-core"}  # Default JPF home directory, adjust if needed
JPF_JAR="$JPF_HOME/build/jpf.jar"
JPF_CLASSPATH="$JPF_HOME/build/jpf-classes.jar"

if [ ! -f "$JPF_JAR" ]; then
    echo "Error: JPF jar not found at $JPF_JAR"
    echo "Please set JPF_HOME environment variable to point to your jpf-core directory"
    exit 1
fi

# Compile the Java file
echo "Compiling $INPUT_FILE..."
javac "$INPUT_FILE"

# Compile the CoverageListener
echo "Compiling CoverageListener..."
javac -cp "$JPF_JAR:." CoverageListener.java

# Create JPF properties file for the target program
cat > "$FILENAME.jpf" << EOF
target=$FILENAME
classpath=.
listener=CoverageListener

# JPF configuration options
report.console.property=error
EOF

# Run JPF
echo "Running JPF analysis..."
java -jar "$JPF_JAR" "$FILENAME.jpf"

# Move results to results directory
if [ -f "report.txt" ]; then
    mv report.txt "results/coverage_report.txt"
    echo "Coverage report generated at results/coverage_report.txt"
else
    echo "Warning: Coverage report was not generated"
fi

# Clean up temporary files
rm -f "$FILENAME.jpf"
echo "Analysis complete"
