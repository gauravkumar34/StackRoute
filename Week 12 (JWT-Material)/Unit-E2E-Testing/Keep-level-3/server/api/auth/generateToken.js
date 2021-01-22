const jwt = require('jsonwebtoken');
const {jwtSecret} = require('../../config');

function generateToken({username, scopes}, done) {
  jwt.sign({scopes},jwtSecret,{subject: username}, done);
}

module.exports = generateToken;
