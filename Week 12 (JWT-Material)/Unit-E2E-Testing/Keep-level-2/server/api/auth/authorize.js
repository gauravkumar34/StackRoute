const verifyToken = require('./verifyToken');

function authorize(authorizedScopes) {
  return function(req, res, next) {
    const authorizationHeader = req.get('Authorization');
    if(!authorizationHeader) { res.status(403).json({message: 'Unauthorized'}); return; }

    const token = authorizationHeader.replace('Bearer ', '');
    if(!token) { res.status(403).json({message: 'Unauthorized'}); return; }

    verifyToken(token, (err, claims) => {
      if(err) { res.status(403).json({message: 'Unauthorized'}); return; }

      const availableScopes = claims.scopes;

      let authorized = false;

      authorizedScopes.forEach((authorizedScope) => {
        authorized = availableScopes.indexOf(authorizedScope) >= 0 || authorized;
      });

      if(!authorized) { res.status(403).json({message: 'Unauthorized'}); return; }

      req.claims = claims;
      next();
    });
  }
}

module.exports = authorize;
