'use strict';
var mongoose = require('mongoose');
var Schema = mongoose.Schema;

var DonairSchema = new Schema({
	name: {
		type: String,
    	maxlength: [32, "Maximum name length is 32."],
		required: [true, 'Name field is required.'],
		unique: [true, 'That donair name has already been chosen. Please pick another name.']
	},
	Created_date: {
		type: Date,
		default: Date.now
	},
	toppings: {
		type: Array,
		default: ['donair sauce', 'tomato', 'onion']
	},
	size: {
		type: String,
		//the size must be one of the following values
		enum: ['small', 'medium', 'large'],
		default: 'medium'
	},
	discountPercent: {
		type: Number,
		min: [0, "Minimum discount percentage is 0."],
		max: [100, "Maximum discount percentage is 100."],
		default: 0
	}
});

module.exports = mongoose.model('Donairs', DonairSchema);
