@echo off
REM ---------------------------------------------------------------------------
REM  upar.bat - Atalho para rodar o upar.ps1 sem se preocupar com a
REM  ExecutionPolicy do Windows (que por padrao bloqueia scripts .ps1).
REM
REM  Uso:
REM      upar.bat "mensagem do commit"
REM      upar.bat                        (usa mensagem automatica com data/hora)
REM ---------------------------------------------------------------------------

REM  A construcao abaixo cuida das aspas corretamente:
REM    - Se vier argumento, ele e repassado entre aspas (a mensagem pode ter espacos).
REM    - Se nao vier nada, chama o script sem argumento (gera mensagem automatica).
REM  O uso de USEBACKQ evita que o cmd interprete as aspas de forma errada.

if "%~1"=="" (
    powershell -NoProfile -ExecutionPolicy Bypass -File "%~dp0upar.ps1"
) else (
    set "MSG=%*"
    setlocal enabledelayedexpansion
    powershell -NoProfile -ExecutionPolicy Bypass -File "%~dp0upar.ps1" "!MSG!"
    endlocal
)
