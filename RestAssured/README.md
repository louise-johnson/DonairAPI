# REST-assured Testing
These files contain REST-assured tests of the Donair API.
### Tools Required
- [Java](https://www.java.com/en/download/)
- [Eclipse](https://www.eclipse.org/downloads/)
###### The following should be included with Eclipse, but may need to be downloaded separately:
- [TestNg](https://www.toolsqa.com/selenium-webdriver/install-testng/)
- [Maven](https://www.eclipse.org/m2e/)
## Steps
How to use REST-assured for API testing on DonairAPI
1. Install the required tools
2. Start the API from the command line
	- Navigate to the DonairAPI folder
	- Execute:
		```npm install```
		```npm start```
3. Start MongoDB from another terminal (C:\Program Files\MongoDB\Server\4.0\bin) by executing ```mongod```
4. In Eclipse, create a new Maven project:
      - File > New > Other... > Maven > Maven Project
      - Select: Create a simple project (skip archetype selection)
      - Set the Group Id and Artifact Id to restAssuredFramework
5. Copy deleteRequest, postRequest and getRequest from the repository into the new Maven project path src/test/java
6. Replace pom.xml in the new Maven project with pom.xml from the repository
7. Run the tests with TestNG in the following order:
    1. PostDonair.java
    2. GetDonair.java
    3. DeleteDonair.java

#### Using TestNG
To run tests with TestNG,
- run all tests by right clicking within the file > Run As > TestNG
- run an individual test by highlighting the method name,
	  right click > Run As > TestNG