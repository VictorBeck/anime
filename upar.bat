@echo off
REM ---------------------------------------------------------------------------
REM  upar.bat - Atalho para rodar o upar.ps1 sem se preocupar com a
REM  ExecutionPolicy do Windows (que por padrao bloqueia scripts .ps1).
REM
REM  Uso:
REM      upar.bat "mensagem do commit"
REM      upar.bat                        (usa mensagem automatica com data/hora)
REM ---------------------------------------------------------------------------

powershell -NoProfile -ExecutionPolicy Bypass -File "%~dp0upar.ps1" %*
