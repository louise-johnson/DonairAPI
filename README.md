# Donair API
This is a simple RESTful API for donair ordering. It has basic CRUD functionality. 

## Required tools
1. [MongoDB](https://www.mongodb.com/download-center)
2. [Node JS](https://nodejs.org/en/download/)
3. [Postman](https://www.getpostman.com)

## Steps
1. Install the required tools
2. Pull this repository
3. Create a data directory for MongoDB if it doesn't already exist (C:\data\db)
4. Open a terminal and navigate to C:\Program Files\MongoDB\Server\4.0\bin 
5. Start MongoDB by executing ```mongod``` in this terminal
6. Open a second terminal and navigate to the pulled DonairAPI folder
7. Execute the following commands to start the API
   - ```npm install```
   - ```npm start```
8. Use Postman to interact with the API
   - GET /donairs
   - POST /donairs
   - GET /donairs/donairID
   - PUT /donairs/donairID
   - DELETE /donairs/donairID
   - DELETE /donairs/search/donairName
   - GET /donairs/search/donairName

### Example:
Here's how to post a donair with a 50% discount to the database using Postman:
1. Select POST as the API method
2. Enter http://localhost:3001/donairs as the API endpoint
3. Enter the following under the Body tab:
```javascript
{
	"name": "Discounted donair",
	"size": "large",
	"discountPercent": 50
}
```
4. Click send
