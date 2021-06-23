# spring-boot-demo

This is a basic RESTful SpringBoot application. The application uses a Contact object to perform basic CURD using REST architecture.

We can see the usage of ModelMapper for mapping data from the entity class to DTO, which restricts the data that is sent to the client.

It uses H2 DB, an in-memory DB, to store, retrive and modify the data as required by the application.

We can use the hard-coded list with predefined objects as well by making changes in Service class and using the ContactsRepo component. 
