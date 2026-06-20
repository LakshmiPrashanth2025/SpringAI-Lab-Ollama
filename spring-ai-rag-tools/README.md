# Spring AI Example with OpenAI LLM, RAG, Tool Calling/ MCP, Chat Memory

## Spring AI RAG Tools

This repository demonstrates a **Retrieval-Augmented Generation (RAG)** system built with **Spring AI** and **Ollama**. It enables you to chat with your own documents by leveraging local Large Language Models (LLMs) and vector-based semantic search.

## 🤝 Overview

The goal of this project is to provide a functional example of how to implement a RAG pipeline in a Spring Boot application. The system processes documents, converts them into vector embeddings, stores them in a vector database, and uses Ollama to provide grounded, context-aware answers to user queries.

## 🛠 Tech Stack

* **Java**: 21+
* **Spring Boot**: 3.x
* **Spring AI**: Current Version
* **Ollama**: Local LLM Runtime
* **Vector Store**: [Insert your database, e.g., PGVector, Chroma, or SimpleVectorStore]
* **Build Tool**: Maven/Gradle

## 📋 Prerequisites

Before running the application, ensure you have the following installed:

1.  **Ollama**: [Download and install Ollama](https://ollama.com/).
2.  **Pull Required Models**: Run the following commands in your terminal:
    ```bash
    ollama pull llama3
    ollama pull nomic-embed-text
    ```
3.  **Vector Database**: Ensure your database is running.

## ⚙️ Setup and Configuration

1.  **Clone the Repository**:
    ```bash
    git clone https://github.com/LakshmiPrashanth2025/SpringAI-Lab-Ollama.git
    cd spring-ai-rag-tools
    ```

2.  **Configure `application.yml`**:
    Update the `src/main/resources/application.yml` file with your specific configurations (e.g., database credentials, Ollama API base URL).

3.  **Build the Application**:
    ```bash
    ./mvnw clean install
    ```

4.  **Run the Application**:
    ```bash
    ./mvnw spring-boot:run
    ```

## 💡 How It Works

1.  **Ingestion**: Documents are loaded, split into smaller, manageable chunks.
2.  **Embedding**: These chunks are converted into numerical vectors using an embedding model.
3.  **Storage**: The vectors are saved into the Vector Store.
4.  **Retrieval**: When a user asks a question, the system searches the vector store for the most relevant document chunks.
5.  **Generation**: The retrieved context + the user's question are sent to the LLM (via Ollama) to generate a natural language response.

## 🧠 Conversation Memory

To maintain context across interactions, ChatController in this project utilizes `ChatMemoryAdvisor`. By implementing a `MessageWindowChatMemory` bean, the application manages the conversation history efficiently using a sliding window approach:

```java
@Bean
public ChatMemory chatMemory(JdbcChatMemoryRepository chatMemoryRepository) {
    return MessageWindowChatMemory.builder()
            .chatMemoryRepository(chatMemoryRepository)
            .maxMessages(10)
            .build();
}
