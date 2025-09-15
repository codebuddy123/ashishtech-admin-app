### Deploying to an External Tomcat Server

1. **Build the WAR file:**
   ```sh
   ./mvnw clean package
   ```
   The WAR will be generated in the `target/` directory (e.g., `ashishtech-admin.war`).

2. **Set environment variables for database connection:**
   Edit `/etc/environment` and add the following lines (replace with your values):
   ```sh
   DB_HOST=your_database_server_ip_or_host
   DB_NAME=your_db_name
   DB_USERNAME=your_db_user
   DB_PASSWORD=your_db_password
   ```
   Save and close the file, then reload the environment:
   ```sh
   source /etc/environment
   ```

3. **Configure Tomcat to use these environment variables:**
   Edit your Tomcat systemd service file (e.g., `/etc/systemd/system/tomcat.service`) and add:
   ```ini
   EnvironmentFile=/etc/environment
   ```
   Example snippet:
   ```ini
   [Service]
   Type=forking
   EnvironmentFile=/etc/environment
   ...
   ```
   Then reload systemd and restart Tomcat:
   ```sh
   sudo systemctl daemon-reload
   sudo systemctl restart tomcat
   ```

4. **Deploy the WAR:**
   Copy the WAR file to Tomcat's `webapps/` directory:
   ```sh
   sudo cp target/ashishtech-admin.war /opt/tomcat/webapps/
   ```

5. **Access the application:**
   Open your browser and go to `http://your-server-ip:8080/ashishtech-admin/registrations`
# AshishTech Admin App

A modern Spring Boot web application for managing student registrations at Ashish Technologies.

## Features
- Register new students with name, email, phone, and course
- List all registered students in a modern, responsive table
- Edit and delete registrations
- View server and client IP addresses

## Technologies Used
- Java 17+
- Spring Boot
- Spring MVC
- Thymeleaf
- Bootstrap 5 & Bootstrap Icons
- Maven

## Getting Started

### Prerequisites
- Java 17 or higher
- Maven 3.6+

### Database Setup (MySQL)

Before running the application, create the database and user in MySQL:

1. Log in to MySQL as root:
   ```sh
   mysql -u root -p
   ```
2. Create a database and user (replace values as needed):
   ```sql
   CREATE DATABASE your_db_name;
   CREATE USER 'your_db_user'@'%' IDENTIFIED BY 'your_db_password';
   GRANT ALL PRIVILEGES ON your_db_name.* TO 'your_db_user'@'%';
   FLUSH PRIVILEGES;
   ```

### Running Locally
1. Clone the repository:
   ```sh
   git clone https://github.com/codebuddy123/ashishtech-admin-app.git
   cd ashishtech-admin-app
   ```
2. Build the project:
   ```sh
   ./mvnw clean package
   ```


3. Run the application (with environment variables for database connection):
   ```sh
   DB_HOST=your_database_server_ip_or_host DB_NAME=your_db_name DB_USERNAME=your_db_user DB_PASSWORD=your_db_password ./mvnw spring-boot:run
   ```
   Replace the values as needed for your environment.

4. Open your browser and go to [http://localhost:8080/registrations](http://localhost:8080/registrations)

## Project Structure
- `src/main/java` - Java source code (controllers, services, entities)
- `src/main/resources/templates` - Thymeleaf HTML templates
- `src/main/resources/static` - Static assets (images, CSS)
- `src/main/resources/application.properties` - App configuration
- `pom.xml` - Maven dependencies and build config

## Customization
- Update logo and trainer images in `src/main/resources/static/`
- Edit HTML templates in `src/main/resources/templates/`
- Modify registration fields in the `Registration` entity

## License
This project is for educational/demo purposes at Ashish Technologies.

---

For questions or support, contact the project maintainer.
