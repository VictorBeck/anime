# anime

Catalogo de animes em Java com conexao a banco de dados.

## Estrutura do projeto

| Pasta | Descricao |
|---|---|
| `connection/` | Conexao com o banco de dados (pool HikariCP) |
| `controller/` | Regras de negocio e acesso aos dados |
| `model/` | Classes que representam as entidades |
| `view/` | Telas e interface grafica (Swing) |
| `uwu/` | Testes e experimentos |

## Como enviar alteracoes para o GitHub

O projeto inclui um script que faz tudo em um comando so: adiciona os arquivos,
cria o commit e envia para o GitHub.

```powershell
upar.bat "descricao da alteracao"
```

Se voce nao quiser escrever a descricao, rode sem argumento e ele gera uma
mensagem automatica com a data e hora:

```powershell
upar.bat
```

O script verifica antes se ha algo para enviar, entao pode rodar sem medo:
se nao houver mudancas, ele apenas avisa e nao cria commit vazio. 
