# AWS Lambda JDBC Java

This is a sample project showing the AWS Lambda integration with MySQL relational database.
 

## Build

To build and package the Lambda function run following gradle command:

`./gradlew clean build`

The resulting *.zip* deployment package can be found in `/build/distributions` directory of the project.

## Properties

Lambda configuration properties can be set in your `application.yml` file. Below is the
full list of supported properties for the lambda function:

```.properties
datasource:
  url: # DB url
  username: # DB username
  password: # DB password
```

## Usage

Build the project and create the Lambda function by uploading the *.zip* deployment package.
