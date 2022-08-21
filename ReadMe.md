# Which Assignment

## Consisting of:
    Locator
    Tracker-Server

## Requirement Scope

"The woman uses a grid system to navigate. She starts facing north at coordinate (0, 0) and uses relative directions to find her way. For example, if she is heading east and turns 'right', she will be facing south. When she moves 'forward', her coordinate is updated based on the direction she is facing."

The forensics API can be accessed from this host and has just two actions: 'directions' and 'location'. Both actions require that a valid email address be passed in, to prove your identity:

| HTTP | Verb      | 	Action Path                |
| ---- | --------- |-----------------------------|
|GET  |	directions | 	/api/:email/directions     |
|GET  |	location  | 	/api/:email/location/:x/:y |

The 'directions' action may be called freely and returns the forensics evidence we have gathered. The response body is in JSON format and it should be apparent how to process it.

## High Level Design - Locator

Receive / Retrieve Directions String
- Use Proxy Interface to retrieve or test stub the directions

Validate the directions String
- Iterate the returned string and return directions

Instantiate the Tracked Object with initial position and Initial orientation

Iterate through the direction Commands

Apply the commands against the tracked
- Apply the command against the Tracked using the Command Strategy pattern

Reply the final location

