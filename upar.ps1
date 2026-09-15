<#
    upar.ps1 - Envia as alteracoes do projeto para o GitHub em um unico comando.

    Uso:
        .\upar.bat "mensagem do commit"      <- forma recomendada (nao depende de ExecutionPolicy)
        .\upar.ps1 "mensagem do commit"
        .\upar.bat                           <- usa mensagem automatica com data/hora

    O que ele faz:
        1. Verifica se ha alteracoes pendentes (se nao houver, encerra sem fazer nada)
        2. git add -A
        3. git commit -m "<mensagem>"
        4. git push
#>

# Garante que qualquer erro pare o script imediatamente.
$ErrorActionPreference = 'Stop'

function Write-Passo {
    param([string]$Texto)
    Write-Host "`n>> $Texto" -ForegroundColor Cyan
}

function Write-Ok {
    param([string]$Texto)
    Write-Host "   [OK] $Texto" -ForegroundColor Green
}

function Write-Aviso {
    param([string]$Texto)
    Write-Host "   [!] $Texto" -ForegroundColor Yellow
}

# ---------------------------------------------------------------------------
# 0. Garante que o script roda a partir da pasta onde ele esta salvo.
# ---------------------------------------------------------------------------
try {
    Push-Location -Path $PSScriptRoot
}
catch {
    Write-Host "Nao foi possivel acessar a pasta do script: $_" -ForegroundColor Red
    exit 1
}

# ---------------------------------------------------------------------------
# 1. Confere se estamos dentro de um repositorio Git com remoto configurado.
# ---------------------------------------------------------------------------
$dentroDoGit = git rev-parse --is-inside-work-tree 2>$null
if ($dentroDoGit -ne 'true') {
    Write-Host "Esta pasta nao e um repositorio Git. Rode 'git init' primeiro." -ForegroundColor Red
    Pop-Location
    exit 1
}

$remoto = git remote get-url origin 2>$null
if ([string]::IsNullOrWhiteSpace($remoto)) {
    Write-Host "Nenhum remoto 'origin' configurado. Rode:" -ForegroundColor Red
    Write-Host "  git remote add origin https://github.com/VictorBeck/anime.git" -ForegroundColor Yellow
    Pop-Location
    exit 1
}

# ---------------------------------------------------------------------------
# 2. Monta a mensagem do commit.
#    Se o usuario passar um texto, usa ele. Senao, gera automaticamente.
# ---------------------------------------------------------------------------
$mensagem = ($args -join ' ').Trim()

if ([string]::IsNullOrWhiteSpace($mensagem)) {
    $mensagem = "Atualizacao automatica - $(Get-Date -Format 'dd/MM/yyyy HH:mm')"
    Write-Aviso "Nenhuma mensagem informada. Usando: $mensagem"
}

# ---------------------------------------------------------------------------
# 3. Verifica se ha algo para enviar (evita commit vazio).
# ---------------------------------------------------------------------------
# `git status --porcelain` lista arquivos modificados/novos. Se vier vazio, nao ha nada a fazer.
$alteracoes = @(git status --porcelain)

if ($alteracoes.Count -eq 0) {
    Write-Passo "Verificando alteracoes..."

    # Mesmo sem alteracoes locais, pode haver commits locais ainda nao enviados.
    $aEnviar = @(git log origin/main..main --oneline 2>$null)

    if ($aEnviar.Count -eq 0) {
        Write-Ok "Nada para enviar. Tudo ja esta sincronizado com o GitHub."
        Pop-Location
        exit 0
    }

    Write-Aviso "Sem alteracoes novas, mas existem $($aEnviar.Count) commit(s) local(is) aguardando envio."
}
else {
    Write-Passo "Alteracoes encontradas: $($alteracoes.Count) arquivo(s)"
    foreach ($linha in $alteracoes) {
        Write-Host "   $linha" -ForegroundColor DarkGray
    }
}

# ---------------------------------------------------------------------------
# 4. Adiciona, commita e envia.
# ---------------------------------------------------------------------------
if ($alteracoes.Count -gt 0) {
    Write-Passo "Preparando arquivos (git add -A)..."
    git add -A
    if ($LASTEXITCODE -ne 0) {
        Write-Host "Falha no 'git add'." -ForegroundColor Red
        Pop-Location
        exit 1
    }
    Write-Ok "Arquivos preparados."

    Write-Passo "Criando commit..."
    git commit -m $mensagem
    if ($LASTEXITCODE -ne 0) {
        Write-Host "Falha no 'git commit'." -ForegroundColor Red
        Pop-Location
        exit 1
    }
    Write-Ok "Commit criado: $mensagem"
}

Write-Passo "Enviando para o GitHub..."
git push
if ($LASTEXITCODE -ne 0) {
    Write-Host "`nFalha no 'git push'. Causas comuns:" -ForegroundColor Red
    Write-Host "  - Sem conexao com a internet" -ForegroundColor Yellow
    Write-Host "  - Credenciais do GitHub expiradas (rode: git push e refaca o login)" -ForegroundColor Yellow
    Write-Host "  - O remoto tem commits que voce nao tem (rode: git pull)" -ForegroundColor Yellow
    Pop-Location
    exit 1
}

Write-Host "`nTudo pronto! Alteracoes enviadas para $remoto" -ForegroundColor Green

# ---------------------------------------------------------------------------
# 5. Resumo final.
# ---------------------------------------------------------------------------
Write-Host "`n--- Resumo ---" -ForegroundColor Cyan
git log --oneline -3

Pop-Location
