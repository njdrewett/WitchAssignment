# Tracker Microservice Application

## Can be used to Mock the real Tracker Application.

Exposes a Tracker Rest Controller with api methods of:
/api/{emailaddress}/directions : Returns Directions in the form of a JSON string e.g. {"directions":["forward","right","forward"]}

/api/{emailaddress}/location/{x}/{y} : Returns whether the location given matches the true location in the scenarios directions from 0,0

Scenarios are retrieved using the email address request parameter as the filename.


