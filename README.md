# Getting Started

Clone the repository locally. You can run the application with the following command in the root directory of the project:

```
./mvnw spring-boot:run
```

To get a list of consultation questions, call the GET `/v1/consultation` API like so:

```
curl localhost:8080/v1/consultation
```

To submit a set of answers to get a consultation result, call the POST `/v1/consultation-result` API like so:

```
curl --header "Content-Type: application/json" --request POST --data '[ { "questionId": 1, "answer": "john"} ]' localhost:8080/v1/consultation-result
```

The above request should return an `APPROVED` result from the consultation, as question 1 does not have any rejection criteria.
To see an example of a `REJECTED` consultation result, call the same API like so:

```
curl --header "Content-Type: application/json" --request POST --data '[ { "questionId": 8, "answer": "true"} ]' localhost:8080/v1/consultation-result
```

Question 8 relates to adverse reactions to the medication, and this request answers the question with `true` (meaning 
the user had an adverse reaction), so we reject the prescription for them.

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

Answers when received by the backend are all typed as Strings.
The alternative is to use some interface and have classes for each answer type implement the interface,
but this seems unnecessary for now.

