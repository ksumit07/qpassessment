
# Grocery Booking API

The Grocery Booking API is a backend service designed to manage grocery items, user accounts, orders, and order items. It provides endpoints for administrators to manage inventory and for users to view available items and place orders.

## Technologies Used

- Java
- Spring Boot
- Hibernate
- Spring Data JPA
- H2 Database (for demonstration purposes)

## Getting Started

### Prerequisites

- Java 8 or later
- Maven

### Installation

1. Clone the repository:

   ```bash
   git clone https://github.com/ksumit07/qpassessment.git
   ```

2. Navigate to the project directory:

   ```bash
   cd grocery-booking-api
   ```

3. Build the project using Maven:

   ```bash
   mvn clean install
   ```

4. Run the application:

   ```bash
   mvn spring-boot:run
   ```

### Usage

The API provides the following endpoints:

- **Admin Endpoints**:
    CRUD operations for managing grocery items.
  - `/api/grocery/items`
  - `/api/grocery/addItems`
  - `/api/grocery/editItems`
  - `/api/grocery/deleteItems`
- **User Endpoints**:
  - `/api/grocery/availableItems`: View available grocery items.
  - `/api/user/orders`: Place an order for multiple grocery items.

### Database Configuration

The project uses an H2 in-memory database by default for demonstration purposes. You can modify the `application.properties` file to configure a different database.

### Project Structure

- `src/main/java`: Contains the Java source code.
  - `com.qpassessment.qpassessment.entity`: Entity classes representing database tables.
  - `com.qpassessment.qpassessment.repository`: Spring Data JPA repositories.
  - `com.qpassessment.qpassessment.service`: Service classes implementing business logic.
  - `com.qpassessment.qpassessment.controller`: Controllers defining API endpoints.
- `src/main/resources`: Contains application properties and configuration files.
- `src/main/resources/static/ddl.sql`: Contains Data Definition Queries and dummy data insertion queries.
- `src/main/resources/static/ER-diagram.pdf`: Contains ER diagram for the solution of the assessment.
### License

This project is licensed under the [MIT License](LICENSE).

### Acknowledgments

- This project is created for assessment purposes.
- Special thanks to [Spring](https://spring.io/) and [Hibernate](https://hibernate.org/) communities for their excellent frameworks.

---

This README provides an overview of the project, its setup, usage, and other relevant details for developers and contributors. Adjust the content according to your project's specific functionalities and requirements.

Remember to include relevant sections such as installation instructions, API documentation, testing procedures, and any other information that might be useful for users and contributors.