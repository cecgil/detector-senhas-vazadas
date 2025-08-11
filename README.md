# 🛡️ Verificador de Senhas Vazadas - Pwned Passwords API

Pequeno projeto em **Spring Boot** que consome a API pública do **[Pwned Passwords](https://haveibeenpwned.com/Passwords)** para verificar se uma senha já foi exposta em vazamentos de dados conhecidos.

A API utiliza o método **k-anonymity** para garantir que a senha original nunca seja enviada em texto puro.

## 📌 Funcionalidades

- Consumo da API `https://api.pwnedpasswords.com/range/{prefix}`.
- Verificação segura utilizando hash **SHA-1**.
- Retorno com a quantidade de vezes que a senha foi encontrada em vazamentos.
- Fácil integração com outros sistemas de validação de senha.

## 🚀 Tecnologias Utilizadas

- **Java 17+**
- **Spring Boot**
- **Spring WebFlux** (para uso do `WebClient`)
- **Apache Commons Codec** (para gerar SHA-1)
- **Maven**
