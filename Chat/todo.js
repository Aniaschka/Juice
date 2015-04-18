var currName;
var MessageList = [];
var count = 0;
var totalCount = 0;
function run(){
   var array = restore() || [];
   createAll(array);
   
        }
function theMessage(message, nick, id) {
    return {
        description: message,
        nameId: nick,
        id: id
    };
}

function uniqueId() {
    var date = Date.now();
    var random = Math.random() * Math.random();
    return Math.floor(date * random).toString();
}

function isEmail(){
      var Text =    document.getElementById('todoText');
      var  Rectangle  = document.getElementById('block2');
      var div = document.createElement('div');
      div.innerHTML =  currName +': '+ Text.value;
      div.setAttribute("onclick", 'select(this)');
      div.id = uniqueId();
	div.description = Text.value;
	div.nameId = currName;
      MessageList.push(theMessage(Text.value,currName, div.id));
      store(MessageList);
      Rectangle.appendChild(div);
      Text.value = '';
}  
function select(elem) {
    if (elem.style.color == 'black') {
        elem.style.background = 'LightSlateGray';
        elem.style.color = 'red';
    }
     else {
        elem.style.background = 'Cornsilk';
        elem.style.color = 'black';
    }
}
function Delete() {
      var children = document.getElementById('block2').childNodes;
        var count = 0;
    for (var i = 0; i < children.length; i++) {
        if (children[i].style.color == 'red') {
            var deleteDiv = children[i];
            remove(deleteDiv);
        }
    }
    
    
    
}
function edit(){
	var Text = document.getElementById('Name');
       	Text.value = '';   
}
function remove(elem) {
    var parentElement = elem.parentNode;
    parentElement.removeChild(elem);
}
function save(){
	var Text = document.getElementById('Name');
       	currName = Text.value;
	
}
function store(listToSave) {
      if (typeof (Storage) == "undefined") {
        return;
    }
    localStorage.setItem("aNN", JSON.stringify(listToSave));
}
function restore() {
    if (typeof (Storage) == "undefined") {
        return;
    }

    var item = localStorage.getItem("aNN");
    return item && JSON.parse(item);
}
function createAll(arr) {
    var parentElem = document.getElementById('block2');
    for (var i = 0; i < arr.length; i++) {
        var div = document.createElement('div');
        div.setAttribute("onclick", 'select(this)');
        div.id = arr[i].id;
        div.nameId = arr[i].nameId;
        div.description = arr[i].description;
        div.innerHTML = div.nameId + ': ' + div.description;
        parentElem.appendChild(div);
        MessageList.push(arr[i]);
        document.getElementById('Name').value = arr[arr.length - 1].nameId;
    }
}

