var eventSource = new EventSource("../SocketClient");
var boardDrawn = false;

var advCol;
var advRow;

eventSource.onopen =function(event){
    console.log(event);
}

eventSource.onmessage = function(event) {
    var grid;
    var data = event.data.split(";");
    if(boardDrawn == false){
        var board = event.data.split(":");
        if(board[0]=="board"){
          grid = createGrid(Math.sqrt(board[1]), Math.sqrt(board[2])); 
          $('html').append(grid);     
          boardDrawn = true;
          advRow = data[1].split(",")[0];
          advCol = data[1].split(",")[1];
          boardDrawn = true;
        }
    }
    else{
        grid.rows[advRow].cells[advCol].innerHTML = grid.rows[advRow].cells[advCol].getAttribute('name');
        advRow = event.data.split(",")[0];
        advCol = event.data.split(",")[1];
        grid.rows[advRow].cells[advCol].innerHTML = "A";
    }
         
};


var lastClicked;
var grid = clickableGrid(10,10);

$('html').append(grid);
     
function createGrid(rows, cols){
    var i=0;
    var grid = document.createElement('table');
    grid.className = 'grid';
    for (var row=0;row<rows;row++){
        var tr = grid.appendChild(document.createElement('tr'));
        for (var col=0;col<cols;col++){
            var cell = tr.appendChild(document.createElement('td'));
            cell.innerHTML = ++i;
            cell.setAttribute('name', i);
        }
    }
    return grid;
}