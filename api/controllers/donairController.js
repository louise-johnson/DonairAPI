// write the diffrent functions here
// list_all_donairs, create_a_donair, read_a_donair, update_a_donair, delete_a_donair 

'use strict';

var mongoose = require('mongoose'),
	Donair = mongoose.model('Donairs');
	
exports.list_all_donairs = function(req, res) {
  Donair.find({}, function(err, donair) {
    if (err)
      res.send(err);
    res.json(donair);
  });
};

exports.create_a_donair = function(req, res) {
	var new_donair = new Donair(req.body);
	new_donair.save(function(err, donair) {
		if (err)
			res.send(err);
		res.json(donair);
	});
};

exports.read_a_donair = function(req, res) {
  Donair.findById(req.params.donairId, function(err, donair) {
    if (err)
      res.send(err);
    res.json(donair);
  });
};

exports.update_a_donair = function(req, res) {
  Donair.findOneAndUpdate({_id: req.params.donairId}, req.body, {new: true}, function(err, donair) {
    if (err)
      res.send(err);
    res.json(donair);
  });
};


exports.delete_a_donair = function(req, res) {
  Donair.remove({
    _id: req.params.donairId
  }, function(err, donair) {
    if (err)
      res.send(err);
    res.json({ message: 'donair successfully deleted' });
  });
};

//Search for donairs with same keyword
exports.search_for_donair = function(req, res) {
  Donair.find({name: req.params.donairName}, function(err, donairs) {
    if (err)
      res.send(err);
    res.json(donairs);
  });
};