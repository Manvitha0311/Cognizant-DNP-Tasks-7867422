# Compile and Run Java Modules

$MODULES_DIR = Get-Location
$OUT_DIR = Join-Path $MODULES_DIR "out"

# Create output directory
if (-not (Test-Path $OUT_DIR)) {
    New-Item -ItemType Directory -Path $OUT_DIR | Out-Null
}

Write-Host ""
Write-Host "========================================"
Write-Host "Compiling Java Modules"
Write-Host "========================================"
Write-Host ""

# Compile com.utils module first (no dependencies)
Write-Host "Compiling com.utils module..."
$utilsModuleInfo = Join-Path $MODULES_DIR "com.utils\module-info.java"
$utilsMessageUtil = Join-Path $MODULES_DIR "com.utils\com\utils\MessageUtil.java"

javac --module-source-path $MODULES_DIR `
       -d $OUT_DIR `
       $utilsModuleInfo `
       $utilsMessageUtil

if ($LASTEXITCODE -ne 0) {
    Write-Host "Error compiling com.utils!"
    exit 1
}
Write-Host "com.utils compiled successfully!"
Write-Host ""

# Compile com.greetings module (depends on com.utils)
Write-Host "Compiling com.greetings module..."
$greetingsModuleInfo = Join-Path $MODULES_DIR "com.greetings\module-info.java"
$greetingsMain = Join-Path $MODULES_DIR "com.greetings\com\greetings\Main.java"

javac --module-source-path $MODULES_DIR `
       --module-path $OUT_DIR `
       -d $OUT_DIR `
       $greetingsModuleInfo `
       $greetingsMain

if ($LASTEXITCODE -ne 0) {
    Write-Host "Error compiling com.greetings!"
    exit 1
}
Write-Host "com.greetings compiled successfully!"
Write-Host ""

Write-Host "========================================"
Write-Host "Running the Application"
Write-Host "========================================"
Write-Host ""

# Run the application
java --module-path $OUT_DIR `
     --module com.greetings/com.greetings.Main

Write-Host ""
Write-Host "========================================"
Write-Host "Done!"
Write-Host "========================================"
