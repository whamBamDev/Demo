/*jslint         browser : true,
  devel  : true, indent : 2,    maxerr   : 50,
  newcap : true, nomem  : true, plusplus : true,
  regexp : true, sloppy : true, vars     : true,
  white  : true
*/
/*global $, io, spa */
demoApp.data = (function() {
  'use strict';
  var
    stateMap = { sio: null },
    makeSio, getSio, initModule;
  
  makeSio = function() {
    var socket = io.connect( '/chat');
    
    return {
      emit : function ( event_name, data ) {
        socket.emit( event_name, data);
        },
      on : function ( event_name, callback ) {
        socket.on( event_name, function() {
          callback( arguments );
        });
      }
    };    
  };
  
  getSio = function() {
    if ( ! stateMap.sio ) { stateMap.sio = makeSio(); }
    return stateMap.sio;
  };
  
  initModule = function() {};
  
  return {
    getSio: getSio,
    initModule: initModule
  };

}());

