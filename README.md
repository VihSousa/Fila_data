# 📈 Análise de Desempenho de Estrutura de Fila com Dados Estudantis em Java

![Java](https://img.shields.io/badge/Java-17-blue)
![GitHub](https://img.shields.io/badge/Status-Concluído-brightgreen)

**Objetivo**: Implementar uma fila eficiente para processar 11.000 registros de estudantes, analisando operações básicas (inserção, remoção e busca) com medição de desempenho.

## 🧠 Contexto
Projeto acadêmico para comparar eficiência de estruturas de dados no processamento de grandes volumes de informação.

## 🛠️ Tecnologias
| Ferramenta | Descrição              |
|------------|------------------------|
| Java 17    | Linguagem principal    |
| Queue      | Estrutura implementada |
| CSV        | Dataset de estudantes  |

## 🗂️ Estrutura do Código
``` Java
projeto/
├── bin/                # Onde os arquivos compilados .class serão gerados
├── data/               # Nomeie o dataset como Student_Data.csv
├── src/                # Contém os arquivos .java
│   ├── Main.java
│   ├── Queue.java
│   ├── Student.java
│   ├── DataClear.java
│   ├── CSVReader.java
│   └── resultados/
│       └── StatsResult.java
├── README.md           # Documentação
```

## 🔨 Compilar o projeto
No terminal, dentro da raiz do projeto:

```bash
javac -d bin src/**/*.java
java -cp bin Main
```
Isso compila todos os .java da pasta src/ e salva os .class organizados dentro de bin/.

## 🚀 Executar o projeto

Se Main.java não estiver em um pacote, execute:


```bash
java -cp bin Main
```

Se Main.java estiver em um pacote (ex: package resultados;), use:

```bash
java -cp bin resultados.Main
```

📊 Dataset
Fonte: [Dados acadêmicos simulados](https://www.kaggle.com/datasets/jayaantanaath/student-habits-vs-academic-performance)
