# Node.JS Tidbits

## If you're using Node.js, you're doing life wrong
http://codeslinger.posterous.com/if-youre-using-nodejs-youre-doing-life-wrong
* V8 is unstable
* Callback - Hell
	** hard to follow and maintain spaghetti code
	** JS consurrency model is very weak
* Non-blocking != fast != scalable
	** Node runs in a single thread


# Node Use Cases
* Wordsquared
	** http://wordsquared.com/
	** Scrabble-artiges Spiel realisiert mit Node

* Etherpad
	** http://etherpad.org/
	** kollaborativer online Editor
	** Github-Repo enthält einen Vergleich zw. d. aktuellen Node Implementierung und der ältern Etherpad-Version @ https://github.com/ether/etherpad-lite
	
* Middleware
	** Opa
		*** http://opalang.org/
		*** Framework um in einem Stack Applikationen zu bauen, die über Client und Server hinweg laufen
	** Meteor
		*** http://meteor.com/
		*** ähnlich zu Opa