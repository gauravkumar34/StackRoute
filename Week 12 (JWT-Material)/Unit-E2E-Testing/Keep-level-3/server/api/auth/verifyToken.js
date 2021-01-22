const jwt = require('jsonwebtoken');
const {jwtSecret} = require('../../config');

function verifyToken(token, done) {
  jwt.verify(token, jwtSecret, done);
}

module.exports = verifyToken;
