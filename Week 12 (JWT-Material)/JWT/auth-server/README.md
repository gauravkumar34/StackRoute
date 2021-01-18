## Authentication Server

### Steps to start server
1. `npm install`
2. `node server`

### API Endpoints
1. For the products('Authorization' header with Bearer token required)
     - GET    - http://localhost:8761/products          - get all products
     - GET    - http://localhost:8761/products/{category}   - get products in a category  
     - GET    - http://localhost:8761/products/{id}  - get a particular product

2. For login
     - POST   - http://localhost:8761/auth/login - authenticate user and create authentication token

3. For Register
     - POST   - http://localhost:8761/auth/register - create new users