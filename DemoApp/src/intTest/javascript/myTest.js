

console.error("myTest ----------------- Hello World ----------------------");

var testCase = require('mocha').describe
var pre = require('mocha').before
var assertions = require('mocha').it
var assert = require('assert')

console.error("testCase = ", testCase);

testCase('Array', function(){
  pre(function(){
    // ...
  });

  testCase('#indexOf()', function(){
    assertions('should return -1 when not present', function(){
      assert.equal([1,2,3].indexOf(4), -1);
    });
  });

  testCase('#indexOf2()', function(){
	    assertions('should return -1 when not present', function(){
	      assert.equal([1,2,3].indexOf(3), -1);
	    });
	  });

});
