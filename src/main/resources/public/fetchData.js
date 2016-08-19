//Establish the WebSocket connection and set up event handlers
//var webSocket = new WebSocket("ws://" + location.hostname + ":" + location.port + "/hello/");
//webSocket.onmessage = function (msg) { updateSprites(msg); };
//webSocket.onclose = function () { alert("WebSocket connection closed") };


// temp, to replace with the call to websocket
$(document).ready(function(){

   setInterval(function(){
   $.ajax({
      url: "http://localhost:4567/hello",
      success: function( result ) {
      	$( "#console" ).html(result[2].x);
        updateSprites(result);
      },
      error: function (textStatus, errorThrown) {
         alert(textStatus);
      }
    });
}, 2000) /* time in milliseconds (ie 2 seconds)*/
}); 

//Update the game area with new locations for each rover
function updateSprites(msg) {
    var data = JSON.parse(msg);
    id("sprites").innerHTML = "";
    data.forEach(function (position) {
        update("sprites", position.x, position.y);
    });
}

//Helper function for inserting HTML as the first child of an element
function update(targetId, x, y) {
    insert(targetId, "<img src=\"sprite.png\" alt=\"Mars Rover\" style=\"left: "+ x +"px; top: "+ y + "px;\" />");
}

//Helper function for inserting HTML as the first child of an element
function insert(targetId, message) {
    id(targetId).insertAdjacentHTML("afterbegin", message);
}

//Helper function for selecting element by id
function id(id) {
    return document.getElementById(id);
}

//id("sprites").innerHTML = "";
//update("sprites", 20, 20);
//update("sprites", 100, 100);
//update("sprites", 300, 300);