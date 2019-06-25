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

exports.delete_a_donair_id = function(req, res) {
  Donair.remove({
    _id: req.params.donairId
  }, function(err, donair) {
    if (err)
      res.send(err);
    res.json({ message: 'donair successfully deleted' });
  });
};

exports.delete_a_donair_name = function(req, res) {
  Donair.remove({
    name: req.params.donairName
  }, function(err, donair) {
    if (err)
      res.send(err);
    res.json({ message: 'donair successfully deleted' });
  });
};

exports.search_for_donair = function(req, res) {
  Donair.find({name: req.params.donairName}, function(err, donairs) {
    if (err)
      res.send(err);
    res.json(donairs);
  });
};
