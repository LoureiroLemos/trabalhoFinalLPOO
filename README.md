# 🚗 Locadora de Veículos — Projeto Final de POO

Projeto desenvolvido como trabalho final da disciplina de **Linguagem de Programação Orientada a Objetos** no curso de Análise e Desenvolvimento de Sistemas da UFPR.

O sistema simula o funcionamento de uma locadora de veículos, permitindo o cadastro e gerenciamento de clientes, veículos e aluguéis, com interface gráfica desenvolvida em Java Swing.

---

## 🛠️ Tecnologias Utilizadas

- Java
- Swing (interface gráfica)
- Paradigma Orientado a Objetos

---

## 📌 Funcionalidades

- Cadastro, listagem e remoção de clientes  
- Cadastro e listagem de veículos (automóveis, motocicletas e vans)  
- Registro de aluguéis com controle de datas e disponibilidade  
- Cálculo do valor total com base nos dias de locação  
- Interface gráfica com formulários simples e intuitivos  
- Exibição de dados em tabelas dinâmicas

---

## 🧱 Estrutura do Projeto

### `model/`  
Contém as classes principais da aplicação:
- `VeiculoI` — Interface com o contrato para qualquer veículo  
- `Veiculo` — Classe abstrata com atributos e comportamentos comuns  
- `Automovel`, `Motocicleta`, `Van` — Heranças de `Veiculo`  
- `Cliente` — Representa um cliente da locadora  
- `Aluguel`, `Locacao` — Representam o processo de aluguel de veículos

### `model.enums/`  
Enums usados na modelagem, como tipo de veículo ou categoria, se necessário.

### `model.tablemodel/`  
Modelos personalizados para exibição de dados nas tabelas (`JTable`).

### `repository/`  
Gerencia os dados em memória:
- `ClienteRepository`
- `VeiculoRepository`

### `service/`  
Camada de lógica de negócio:
- `ClienteService`
- `VeiculoService`

### `view/`  
Interface gráfica desenvolvida com Swing (telas de cadastro, listagem, etc.).

---

## 💡 Conceitos de POO Aplicados

- **Encapsulamento** — Atributos privados com acesso controlado  
- **Herança** — Classes específicas que estendem uma classe abstrata  
- **Polimorfismo** — Manipulação de objetos via interface `VeiculoI`  
- **Abstração** — Generalização de características em classes base  
- **Organização em camadas** — Separação entre modelagem, lógica, repositório e interface

---

## ▶️ Como Executar

1. Clone o repositório:
   ```bash
   git clone https://github.com/seuusuario/locadora-veiculos.git
2. Abra o projeto em uma IDE Java (como NetBeans ou IntelliJ IDEA)
3. Compile o projeto
4. Execute a classe principal (ViewPrincipal.java)

---

## 📚 Requisitos Atendidos da Disciplina

- ✅ Interface gráfica com Swing  
- ✅ Uso de interface, classe abstrata e herança  
- ✅ Código organizado em pacotes por responsabilidade  
- ✅ Aplicação dos princípios da programação orientada a objetos  
- ✅ Projeto funcional, modular e bem estruturado

---

## 👨‍💻 Autor

**Pedro Loureiro de Lemos**  
Estudante de Análise e Desenvolvimento de Sistemas — UFPR 

[LinkedIn](https://www.linkedin.com/in/loureirolemos/)

