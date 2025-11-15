# Getting Started

Clone the repository locally. You can run the application with the following command in the root directory of the project:

```
./mvnw spring-boot:run
```

## Trade Offs

Considering what we want the frontend to look like: a single screen with a list of consultation questions,
or one question on the screen at one time? The latter would require some sort of paginated API, so for simplicity
we will return all the questions at once. This also allows the user to see previous questions and their answers.
