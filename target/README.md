# woolies-challenge

This project automates for checkout flow for web and api testing.

### Frameworks
 * Selenium Java Web driver
 * Cucumber BDD - Gherkins
 * Page objects pattern for creating java page classes corresponding to website page
 * Maven to compile, packaging, build and reporting (surefire plugin) tool
 * Jackson for De-serialization of JSON responses to Java
 
### IDE used
This project is built and tested on IntelliJ IDEA
 
### Project Dependencies 
 * Java 8
 * Maven 3.6.3
 * Selenium 3.141.59
 * Cucumber 1.2.5
 * RestAssured 4.3.0
 * maven surefire plugin 2.22.2
 * webdrivermanager - 4.1.0 (https://github.com/bonigarcia/webdrivermanager)

### Cloning the project 
```markdown
git clone
```

### Compiling and running the project

#### Web automation 
```markdown
mvn clean install -Denv=prod -Dbrowser=chrome-Dcucumber.options="--tags '@websmoke'"
```
#### API testing
mvn clean install -Denv=prod -Dcucumber.options="--tags '@HappyHolidayMaker'"

### System parameters
 * `env` - can be specified in the maven commandline as -Denv=prod or stg
 * `browser` - supports chrome and firefox and specified with maven command line as __-Dbrowser=chrome__ or __-Dbrowser=firefox__
 
## Note
forcast5 api has been used for doing api testing