# Employe service using Spring Boot, Maven, MongoDB and Docker 

1. My Dev enviroment 👍
   - Windows 10
   - Visual Studio Code
		- Plugins
			- Extension Pack for Java - Microsoft
			- Project Manager for Java - Microsoft
			- Debugger for Java - Microsoft
			- Maven for Java - Microsoft
			- Remote - Containers - Microsoft
			- Test Runner for Java - Microsoft
			- Spring Initializr Java Support - Microsoft
			- Spring Boot Dashboard - Microsoft
			- Spring Boot Extension Pack - Pivotal
			- Spring Boot Tools - Pivotal
			- Dependency Analytics - Red Hat
			- Language Support for Java(TM) by Red Hat
			- YAML - Red Hat
			- Lombok Annotations Support for VS Code
   - JDK 17.0.1
   - Maven  3.6.3
   - git 2.34.0.windows.1
   - gh version 2.2.0
   - curl 7.55.1
   - Postman for Windows Version 9.1.5
   - MongoDB Comunity 6.0.6
   - Docker
		- Docker for Windows (Docker version 20.10.11) 
		- Docker Desktop for Windows 4.3.0

2. Install if necessary git, follow the instruction on the link below.
	- ```  https://git-scm.com/downloads ```
	- After install run the command below in the terminal
		- ``` git config --global core.autocrlf true ```

3. Install if necessary gh, follow the instruction on the link below.
	- ``` https://cli.github.com/manual/installation ```

4. try to access the link below
	- ``` https://github.com/pontalti/employe ```

5. Clone the repository
	- ``` git clone git@github.com:pontalti/employe.git ```

6. If necessary install the JDK 17, download it on the link below
	- ``` https://www.oracle.com/java/technologies/downloads/ ```
	- Choose your distribution and install the JDK
	- Create the Java Home
		- Windows -> ``` JAVA_HOME = [YOUR_PATCH]\jdk-17.0.1 ```
		- Linux -> ``` JAVA_HOME = [YOUR_PATCH]/jdk-17.0.1 ```
	- Put the JAVA_HOME on the System Patch
		- For Windows -> ``` %JAVA_HOME%\bin ```
		- For Linux -> ``` export PATH=$JAVA_HOME/bin:$PATH ```
	- Test JDK on command line
		- ``` java -version ```		

7. If necessary install Maven, download it on the link below
	- ``` https://maven.apache.org/download.cgi ```
	- Extract compressed file in your prefered tool folder.
	- Create the M2_HOME
		- Windows -> ``` M2_HOME = [YOUR_PATCH]\apache-maven-3.6.3 ```
		- Linux -> ``` M2_HOME = [YOUR_PATCH]/apache-maven-3.6.3 ```
	- Put the Maven on the System Patch
		- For Windows -> ``` %M2_HOME%\bin ```
		- For Linux -> ``` export PATH=$M2_HOME/bin:$PATH ```
	- Test Maven on command line
		- ``` mvn --version ```

8. If necessary install your favorite IDE with support to JDK 17.

9. if necessary Install the project Lombok on your IDE, follow the instruction on the link below.
	- ``` https://projectlombok.org/setup/overview ```

10. Open the project in favotite IDE

11. To build please.
	- Go to the project root folder.
	- Run the command below.
		- ``` mvn clean install package -U ```

12. To run the SpringBoot application with Docker.
	- Please install Docker.
	- Go to the project root folder.
	- Run the commands below.
		- ``` docker-compose build ```			
		- ``` docker-compose up -d ```
	- To check the log, please run the command below.
		- ``` docker logs -f employe ```
	- To use the Spring dev tools features please configure the -> ``` Spring Boot Remote ```
		- Remote URL -> ``` http://localhost:8080/ ```
	- To debug
		- connect in remote JVM using the port -> ``` 8000 ```
	
13. if necessary install curl on Windows or Linux.
	- for Windows -> ``` choco install curl ```
	- for Linux(Ubuntu/Debian) -> ``` apt-get install curl ```
	- for Linux(RHEL/CentOS/Fedora) -> ``` yum install curl ```
	
14. You call the end-points below using curl on your terminal or other tool like POSTMAN.
	- End-point type POST to create a document -> ``` http://localhost:8080/employe/ ```
		- Use the Json below as a model.
			``` 
			{
				"name": "Edmundo",
				"surname": "Souza",
				"salary": "7500",
				"emails": [
					"blabla@google.com",
					"blabla@msn.com"
				],
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
	- End-point type GET to list all documents ->  ``` http://localhost:8080/employe/all ```
	- End-point type GET TO get documet by id ->  ``` http://localhost:8080/employe/id/<PASTE_THE_DOCUMENT_ID> ```
	- End-point type DELETE to delete the documet by id ->  ``` http://localhost:8080/employe/id/<PASTE_THE_DOCUMENT_ID>  ```
	- End-point type GET to list of documents by salary range -> ``` http://localhost:8080/employe/salary/range/<INITIAL_INTEGER_SALARY_AMONT>/<END_INTEGER_SALARY_AMONT> ```
	- End-point type PUT to update document content -> ``` http://localhost:8080/employe/ ```7
		- Use the Json below as a model, paste the id of the document and feel free to change, add or remove any data.
			``` 
			{
				"id": "<PASTE_THE_DOCUMENT_ID>",
				"name": "Edmundo",
				"surname": "Souza",
				"salary": "7500",
				"emails": [
					"blabla@google.com",
					"blabla@msn.com"
				],
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

15. To access the OpenAPI definition, please use the link below
	- ``` http://localhost:8080/swagger-ui/index.html?configUrl=/v3/api-docs/swagger-config#/ ``` 


