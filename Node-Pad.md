# Node.JS Tidbits

## If you're using Node.js, you're doing life wrong
http://codeslinger.posterous.com/if-youre-using-nodejs-youre-doing-life-wrong
* V8 is unstable
* Callback - Hell
	* hard to follow and maintain spaghetti code
	* JS consurrency model is very weak
* Non-blocking != fast != scalable
	* Node runs in a single thread

## Tracking Down Memory Leaks in Node.js
https://hacks.mozilla.org/2012/11/tracking-down-memory-leaks-in-node-js-a-node-js-holiday-season/
* V8 can become very aggressve about garbage collection -> always an issue in Java
* mostly about memory leaks

## Building a Real-time SMS Voting App Part 3: Scaling Node.js and CouchDB
http://www.twilio.com/blog/2013/01/building-a-real-time-sms-voting-app-part-3-scaling-node-js-and-couchdb.html
* Aktikelserie über "Hochskalierende" SMS Voting App

## Deploy on Heroku
https://devcenter.heroku.com/articles/nodejs

# Links
* https://github.com/learnboost/kue

# Node Use Cases
* Wordsquared
	* http://wordsquared.com/
	* Scrabble-artiges Spiel realisiert mit Node

* Etherpad
	* http://etherpad.org/
	* kollaborativer online Editor
	* Github-Repo enthält einen Vergleich zw. d. aktuellen Node Implementierung und der ältern Etherpad-Version @ https://github.com/ether/etherpad-lite
	
* Middleware
	* Opa
		* http://opalang.org/
		* Framework um in einem Stack Applikationen zu bauen, die über Client und Server hinweg laufen
	* Meteor
		* http://meteor.com/
		* ähnlich zu Opa