# GenAI Java Project

This is a Spring Boot application that integrates with AI models using Spring AI framework.

## Technical Stack

- Java 17
- Spring Boot 3.4.5
- Spring AI Framework 1.0.0-M8
- Gradle (Build Tool)
- Ollama AI Model Integration
- Jackson (JSON Processing)
- HTML5/CSS3/JavaScript (Frontend)

## Prerequisites

- Java 17 or higher
- Gradle
- Ollama (for local AI model)

## Installation Steps

1. Clone the repository:
   ```bash
   git clone <repository-url>
   cd GenAI-Java
   ```

2. Install Ollama (if not already installed):
    - For macOS:
      ```bash
      curl https://ollama.ai/install.sh | sh
      ```
    - For other platforms, visit [Ollama Installation Guide](https://ollama.ai/download)

## Setup Steps

1. Ensure Java 17 is installed and configured:
   ```bash
   java -version
   ```

2. Verify Gradle installation:
   ```bash
   ./gradlew --version
   ```

3. Build the project:
   ```bash
   ./gradlew build
   ```

## Running the Application

1. Start the application using Gradle:
   ```bash
   ./gradlew bootRun
   ```

2. The application will start on the default port 8080.

3. Open your web browser and navigate to:
   ```
   http://localhost:8080
   ```

## Project Structure

```
src/
├── main/
│   ├── java/        # Java source files
│   └── resources/   # Configuration files
└── test/           # Test files
```

## Dependencies

The project uses the following main dependencies:

- Spring Boot Web Starter
- Spring AI Starter (Ollama)
- Jackson Core, Annotations, and Databind

## Feature Implementation

### Tic Tac Toe Game with AI Integration

The application implements a Tic Tac Toe game with the following features:

#### Backend (Spring Boot)

- REST API endpoint at `/api/ai/openai/nextMove` for AI moves
- Integration with Spring AI framework for game logic
- JSON response handling for game state updates

#### Frontend (HTML/CSS/JavaScript)

1. **User Interface**
    - Modern, responsive design with gradient background
    - Animated particle effects
    - Glass-morphism UI elements
    - Interactive game board with hover effects

2. **Game Features**
    - Player vs AI gameplay
    - Real-time board updates
    - Win detection for rows, columns, and diagonals
    - Draw detection
    - Game reset functionality
    - Visual feedback for winning combinations

3. **AI Integration**
    - Automatic AI moves after player's turn
    - REST API communication with backend
    - Error handling for API calls
    - State management for game board

## Additional Notes

- The application uses Spring AI framework for AI model integration
- Ollama is used as the default AI model provider
- The project is configured to use Java 17 features
- The frontend is built with vanilla JavaScript for optimal performance
- The game implements a responsive design that works on various screen sizes 