**Game concept:**

Users have 3 buttons hit to chose from once per day. If they are part of the group that selected the least pushed button. The will win a point for that day. At then end of the season, whomever has the most points wins. 


To run: 
>npm install 
<br/>
>npm run start

___
**For Developer:**

*https://least-picked.herokuapp.com/login/oauth2/code/facebook* was added to Valid OAuth Redirect URIs on fb portal

'npm install husky --save-dev'
https://github.com/spring-projects/spring-security/tree/master/samples/boot/oauth2login#facebook-login
gradlew wrapper --gradle-version 5.5

  "husky": {
    "hooks": {
      "pre-commit": "pretty-quick --staged"
    }
  },