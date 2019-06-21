A Simple RESTful API for Donair ordering.

Required tools:
1. MongoDB
2. Node JS
3. Postman

1. Install required tools
2. Pull this repository
3. Create a data directory for MongoDB if it doesn't already exist (C:\data\db)
4. Open a terminal and navigate to C:\Program Files\MongoDB\Server\4.0\bin 
5. Start MongoDB by executing 'mongod' in this terminal
6. Open a second terminal and navigate to the pulled DonairAPI folder
7. Execute the following commands to start the API
   - npm install
   - npm start
8. Use Postman to interact with the API
   - GET /donairs
   - POST /donairs
   - GET /donairs/donairID
   - PUT /donairs/donairID
   - DELETE /donairs/donairID
   - GET /donairs/search/donairName

Example Postman interaction:
Select POST as the API method
Enter http://localhost:3001/donairs as the API endpoint
Enter the following under the Body tab:
{

	"name": "Discounted donair",

	"size": "large",

	"discountPercent": 50

}



