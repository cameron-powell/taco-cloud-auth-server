## Testing
- Kick off login/consent grant
    - `http://localhost:9000/oauth2/authorize?response_type=code&client_id=taco-admin-client&redirect_uri=http%3A%2F%2F127.0.0.1%3A9090%2Flogin%2Foauth2%2Fcode%2Ftaco-admin-client&scope=writeIngredients%20deleteIngredients`
- Exchange auth code for access token
    - `curl localhost:9000/oauth2/token -H"Content-type: application/x-www-form-urlencoded" -d"grant_type=authorization_code" -d"redirect_uri=http://127.0.0.1:9090/login/oauth2/code/taco-admin-client" -d"code=$code" -u taco-admin-client:secret`
        - Replace `$code` with the code from step 1
- Request a new token using the refresh token
    - `curl localhost:9000/oauth2/token -H"Content-type: application/x-www-form-urlencoded" -d"grant_type=refresh_token&refresh_token=$refreshToken" -u taco-admin-client:secret`
        - Replace `$refreshToken` with a refresh token from step 1