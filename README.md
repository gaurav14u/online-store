Onilne store application

A RESTful service that implments a online store checkout system.

Generates total bill based on products and applicable taxes on each product.

### Build

$ mvn clean package

$ java -jar target/online-store-0.1.0.jar

When you eun the application it will load necessary tables and data during initialization.
I have used in memory database.

### Usage

Go to http://localhost:8080/checkout.html
