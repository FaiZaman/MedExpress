# Getting Started

Clone the repository locally. You can run the application with the following command in the root directory of the project:

```
./mvnw spring-boot:run
```

```
curl --header "Content-Type: application/json" --request POST --data '[ { "questionId": 1, "answer": "john"} ]' localhost:8080/v1/consultation-result
```

## Trade-Offs

Considering what we want the frontend to look like: a single screen with a list of consultation questions,
or one question on the screen at one time? The latter would require some sort of paginated API, so for simplicity
we will return all the questions at once. This also allows the user to see previous questions and their answers.

When calling the consultation endpoint to get a list of questions, the types of the answers will also be returned
to the frontend. This is so that the frontend knows what type of input to use for each question and how to validate it.

All questions are required by default. With more time, we could add some optional questions and min/max validation
on number and date-based inputs, e.g. height, weight, and DOB.

Questions currently have integer enumerated IDs. If we expand MedExpress across Genovia, it would be good to switch
to using UUIDs instead for global uniqueness.

Answers when received by the backend are typed as Strings and parsed in the service class.
The alternative is to use some interface and have classes for each answer type implement the interface,
but this seems unnecessary for now.
