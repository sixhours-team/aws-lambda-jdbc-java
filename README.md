# AWS Lambda JDBC Java

Sample AWS Lambda integration with MySQL relational database. 

## Build

To build the lambda service run this command:

`./gradlew clean build`

## Properties

Lambda configuration properties can be set in your `application.yml` file. Below is the
full list of supported properties for the lambda function:

```.properties
database:
  url: # DB url
  username: # DB username
  password: # DB password
```

## Usage


