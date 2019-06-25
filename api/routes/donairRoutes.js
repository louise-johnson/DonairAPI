'use strict';
module.exports = function(app) {
	var donair = require('../controllers/donairController');
	
	//donair Routes
	app.route('/donairs')
		.get(donair.list_all_donairs)
		.post(donair.create_a_donair);
		
	app.route('/donairs/:donairId')
		.get(donair.read_a_donair)
		.put(donair.update_a_donair)
		.delete(donair.delete_a_donair_id);
		
	app.route('/donairs/search/:donairName')
		.get(donair.search_for_donair)
		.delete(donair.delete_a_donair_name);
};
