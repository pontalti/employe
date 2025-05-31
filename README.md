# 👨‍💼 Employee Service with Spring Boot, Maven, MongoDB, and Docker

A RESTful service to manage employee records using Spring Boot, Maven, MongoDB, and Docker.

---

## 🧰 Development Environment

- **OS**: Windows 10
- **Java**: JDK 21  
- **Build Tool**: Maven 3.6.3  
- **Version Control**: Git 2.34.0  
- **GitHub CLI**: gh 2.2.0  
- **API Client**: Postman v9.1.5  
- **Database**: MongoDB Community 6.0.6 (Local)  
- **Containerization**: Docker + Docker Desktop

---

## ⚙️ Prerequisites & Setup

### 1. Install Git  
👉 [https://git-scm.com/downloads](https://git-scm.com/downloads)  
Then run:  
```bash
git config --global core.autocrlf true
```

### 2. Install GitHub CLI  
👉 [https://cli.github.com/manual/installation](https://cli.github.com/manual/installation)

### 3. Clone the Repository  
```bash
git clone git@github.com:pontalti/employe.git
```

### 4. Install JDK 21  
👉 [https://www.oracle.com/java/technologies/downloads/](https://www.oracle.com/java/technologies/downloads/)

Set `JAVA_HOME` and update your `PATH`:  
**Windows:**
```bash
JAVA_HOME=C:\Path\To\jdk-21
set PATH=%JAVA_HOME%\bin;%PATH%
```
**Linux:**
```bash
export JAVA_HOME=/path/to/jdk-21
export PATH=$JAVA_HOME/bin:$PATH
```

Verify:  
```bash
java -version
```

### 5. Install Maven  
👉 [https://maven.apache.org/download.cgi](https://maven.apache.org/download.cgi)

Set `M2_HOME` and update your `PATH`:  
**Windows:**
```bash
M2_HOME=C:\Path\To\apache-maven-3.6.3
set PATH=%M2_HOME%\bin;%PATH%
```
**Linux:**
```bash
export M2_HOME=/path/to/apache-maven-3.6.3
export PATH=$M2_HOME/bin:$PATH
```

Verify:  
```bash
mvn --version
```

### 6. Install Project Lombok  
👉 [https://projectlombok.org/setup/overview](https://projectlombok.org/setup/overview)

---

## 🚀 Build & Run

### Build the Application
```bash
mvn -U clean install package spring-boot:repackage
```

### Run with Docker
```bash
docker-compose build
docker-compose up -d
```

Check logs:
```bash
docker logs -f employe
```

Debugging:
- Connect to remote JVM on port `8000`

Spring Boot Remote DevTools:
- URL: `http://localhost:8080/`

---

## 🧪 API Usage

### Install curl *(if needed)*  
**Windows**:  
```bash
choco install curl
```  
**Linux (Ubuntu/Debian)**:  
```bash
sudo apt-get install curl
```  
**Linux (RHEL/CentOS/Fedora)**:  
```bash
sudo yum install curl
```

### REST Endpoints

#### ➕ Create Employee (POST)
```bash
http://localhost:8080/
```
**Request Body:**
```json
{
  "name": "Edmundo",
  "surname": "Souza",
  "salary": "7500",
  "emails": ["blabla@google.com", "blabla@msn.com"],
  "address": [
    {
      "addressType": "Street",
      "street": "Ortigara 9620",
      "city": "Trento",
      "country": "Italy"
    },
    {
      "addressType": "Street",
      "street": "Ortigara 171",
      "city": "Vimercate",
      "country": "Italy"
    }
  ]
}
```

#### 📃 List All Employees (GET)
```bash
http://localhost:8080/all
```

#### 🔍 Get Employee by ID (GET)
```bash
http://localhost:8080/id/<PASTE_THE_DOCUMENT_ID>
```

#### ❌ Delete Employee by ID (DELETE)
```bash
http://localhost:8080/id/<PASTE_THE_DOCUMENT_ID>
```

#### 💵 Filter Employees by Salary Range (GET)
```bash
http://localhost:8080/salary/range/<START_SALARY>/<END_SALARY>
```

#### ✏️ Update Employee (PUT)
```bash
http://localhost:8080/
```
**Request Body Example:**
```json
{
  "id": "<PASTE_THE_DOCUMENT_ID>",
  "name": "Edmundo",
  "surname": "Souza",
  "salary": "7500",
  "emails": ["blabla@google.com", "blabla@msn.com"],
  "address": [
    {
      "addressType": "Street",
      "street": "Ortigara 9620",
      "city": "Trento",
      "country": "Italy"
    },
    {
      "addressType": "Street",
      "street": "Ortigara 171",
      "city": "Vimercate",
      "country": "Italy"
    }
  ]
}
```

---

## 📚 API Documentation

Access the Swagger UI at:  
👉 `http://localhost:8080/swagger-ui/index.html`
