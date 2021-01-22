const chai = require('chai');
chai.should();

const app = require('../../app')();
const request = require('supertest');

describe('POST /auth/v1', function() {
  it('should return a new token', function(done) {
    request(app)
      .post('/auth/v1')
      .send({username: 'admin', password: 'password'})
      .expect(201)
      .expect('Content-Type', /json/)
      .end((err, res) => {
        if(err) { done(err); return; }
        res.body.should.have.property('token');
        done();
      });
  });
});
