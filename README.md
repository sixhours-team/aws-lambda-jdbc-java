[![Build Status](https://travis-ci.org/sixhours-team/aws-lambda-jdbc-java.svg?branch=master)](https://travis-ci.org/sixhours-team/aws-lambda-jdbc-java)

# AWS Lambda JDBC Java

This is a sample project showing the AWS Lambda integration with MySQL relational database.

When triggered the lambda function will access the `employee` table ([schema](src/test/resources/db/schema.sql)) in the MySQL RDS instance 
that you created in the VPC, and return the list of all employees found in the table. The connection to the database is 
obtained using the `DataSource` interface. 

AWS Lambda might reuse container when lambda function is invoked again. Any declarations in lambda function code (outside 
the handler method) remains initialized e.g. database connections. Instead of reestablishing the new connection, the 
original connection is used in subsequent invocations. For this reason the [HikariCP](https://github.com/brettwooldridge/HikariCP) JDBC connection pool is used.

## Build

To build and package the lambda function run following gradle command:

    ./gradlew clean build

The resulting *.zip* deployment package can be found in `build/distributions` directory of the project.

## Properties

Lambda configuration properties can be set in your `application.yml` file. Below is the full list of supported properties 
for the lambda function:

```yaml
datasource:
  url: # DB url
  username: # DB username
  password: # DB password
```

## Usage

Build the project and create the lambda function by uploading the *.zip* deployment package using the [AWS Management Console](https://aws.amazon.com/console/)
or the [AWS CLI](https://aws.amazon.com/cli/).
