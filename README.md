# Todo List Exercise

This is a small gradle based multi-project to test your familiarity with Angular frontend in general and Spring boot backend.
The project consists of 2 modules `todo-list-frontend` and `todo-list-backend`.

## todo-list-frontend

This module was generated with [Angular CLI](https://github.com/angular/angular-cli) version 12.2.2.

## Development server

Run `ng serve` for a dev server. Navigate to `http://localhost:4200/`. The app will automatically reload if you change any of the source files
and all `/api` request will be automatically redirected on the backend server with the help of `proxy.config.json`.

## Code scaffolding

Run `ng generate component component-name` to generate a new component. You can also use `ng generate directive|pipe|service|class|guard|interface|enum|module`.

## Build

Run `ng build` to build the project. The build artifacts will be stored in the `dist/` directory.

## Further help

To get more help on the Angular CLI use `ng help` or go check out the [Angular CLI Overview and Command Reference](https://angular.io/cli) page.

## todo-list-backend

This module was generated with [Spring boot](https://spring.io/projects/spring-boot) version 2.3.0.RELEASE.

## Development server

Run `TodoApplication.java` for the backend server. All endpoints will be served under `http://localhost:8099/api`

**Please note that until you reach last part of the exercise and implement the backend you will be receiving an exception like:**

`org.hibernate.tool.schema.spi.CommandAcceptanceException: Error executing DDL "INSERT INTO todo (id, task, priority) VALUES (1, 'Implement loading - frontend only', 1)" via JDBC Statement`

# Exercise

Please implement the following as separate commits:

### Show the loading bar only while data as loading

Currently, TODOs are fetched through a mock service (todo.service.ts) with an artificial delay of 2s.
Hide the loading bar when data has finished loading.
#SOLUTION: Create a variable "loading" true, when getAll is finished with a subscribe I change "loading" to false, with an \*ngIf in the progress-bar it appears only while it is true

### Implement search

Wire up the existing search field, so the TODO list is filtered when the input changes.
#SOLUTION: Create a pipe to filter the array with the string, use the filter in the ngFor, take care of the null initialize with async

### Implement delete on click

Using the existing method `remove` on todo.service.ts, remove a TODO when it's clicked.
Note that the `remove` method is intentionally made, so it randomly sometimes fails. This error should be handled as you see fit.
#SOLUTION: Adds a click event in the todo-item component, which will be triggered when the user clicks on the list item. In the event handler, call the remove method of the todoService, which will remove the todo from the todo list. It updates the todo list after removing using the getAll method of the todoService. To solve the failure of the remove, you can do a try-catch, and handle the error in the catch, from now it only prints by console that has failed

### Replace the mock service by backend API calls

#### todo-list-backend

Provide the API call endpoints with the help of Spring (entity, repository, controller etc.) that will be used in from the front-end.

#SOLUTION:
Due to dependency problems with the different versions of java, gradle, spring boot, maven... I have not been able to run the backend exercise and therefore, I have not been able to test anything. For this reason, I leave here explained each step, and the code that has to be done in the corresponding files. The same happens with the use of this back from the frontend, I have not been able to test it either, and therefore I leave the todo.service.ts so that you can see how the frontend works.
For the backend we must create the data structure that represents each of the insertions to be made, for this I create the Todo.java class.#A repository is created that extends the JpaRepository in which all objects will be stored, it is called TodoRepository.java
The TodoController.java file is created where I implement all the functions required for the management of the backend, allowing to get all, add, modify and delete one by one.
A file (TodoNotFoundException.java) is created to handle the exception if the object to be updated or deleted is not found.
TodoApplication.java is already implemented to run the repository.
The file LoadTodoDatabase.java has been created where the corresponding insertions are made to fill the database.

#### todo-list-frontend

Using the backend API, replace the method definitions at todo.service.ts with actual API calls
