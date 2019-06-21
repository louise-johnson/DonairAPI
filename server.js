var express = require('express'),
	app = express(),
	port = process.env.PORT || 3001,
	mongoose = require('mongoose'),
  	Donair = require('./api/models/donairModel'), //created model loading here
  	bodyParser = require('body-parser');

// mongoose instance connection url connection
mongoose.Promise = global.Promise;
mongoose.connect('mongodb://localhost/Donairdb'); 


app.use(bodyParser.urlencoded({ extended: true }));
app.use(bodyParser.json());


var routes = require('./api/routes/donairRoutes'); //importing route
routes(app); //register the route
	
app.listen(port);

console.log('donair RESTful API server started on: ' + port);