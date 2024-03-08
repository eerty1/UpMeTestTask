# Up me test task

Some kind of a furniture factory

## Task Requirements

Build a **Spring Boot** application with: **Maven** / **Gradle** , **Spring MVC** , **JPA** , **Postgresql** / **H2**.
UI desirable but not required

Develop API for CRUD operations of holes in furniture 
A detail is a parallelepiped with the height somewhere in between from **4** to **50** mm
The wholes could be places everywhere on the detail with the right angle)
Holes have the following properties **diameter**, **depth**, **drill entrance speed**, **drill exit speed**, **coordinates** 
Coordinates could be set by usual variables OR patterns (L/2 + B*0.5 +H/3), 
The coordinates have to support mathematical operations: addition, subtraction, multiplication, division
The amount of variables is not limited, patterns have to be open for editing

You are proposed to use Java 17.

Current Maven version.

![This is an image](https://i.ibb.co/5M5bxcm/image.png)

There're the steps to unpack my project: 

* git clone UpMeTestTask

* Open it via your IDE

* Connect to your database via application.yml file

## Usage

Build and run application:

* mvn clean install

* Go to the **target**  directory and run **java -jar UpMeDrilling-0.0.1-SNAPSHOT.jar**

* Open http://localhost:8080/detail
