var userName = [];
var MessageList = [];
var count = 0;
var amount = 0;
var amountOfMes = [];
var totalCount = 0;
function run(){
   var Store = restore();
   recreate(Store);
   var Name = restoreName();
   var Amount = restoreAmount();
   writeStatistics(Name,Amount);
   var message = document.getElementById('todoText');
   if(!isEmpty(message.value)){
   isEmail();
   }
  
        }
function isEmpty(str) {
return (!/S/.test(str));
}

function isEmail(){
      var Text =    document.getElementById('todoText');
      var  Rectangle  = document.getElementById('Rectangle');
      var Show = document.createElement('textarea');
      Show.value = Text.value;
      MessageList[totalCount++] = Text.value;
      amount++;
      store(MessageList);
      Rectangle.appendChild(Show);
      Text.value = '';
}  
function edit(){
	var Text = document.getElementById('Name');
       	Text.value = '';   
}
function save(){
	var Text =    document.getElementById('Name');
        userName[count] = Text.value;
	amountOfMes[count++] = amount;
        amount = 0; 
       	storeName(userName);
        storeAmount(amountOfMessage);
}
function store(listToSave) {
		
	localStorage.setItem("taskList", JSON.stringify(listToSave));
}
function storeAmount(listToSave) {
		
	localStorage.setItem("Amount", JSON.stringify(listToSave));
}
function storeName(listToSave) {
		
	localStorage.setItem("Name", JSON.stringify(listToSave));
}
function restore() {
	if(typeof(Storage) == "undefined") {
		alert('localStorage is not accessible');
		return;
	}

	var item = localStorage.getItem("taskList");
	return item && JSON.parse(item);
}
function restoreName(){
 	var item = localStorage.getItem("Name");
	return item && JSON.parse(item);

}
function restoreAmount(){
 	var item = localStorage.getItem("Amount");
	return item && JSON.parse(item);

}

function recreate(Store){
        var  Rectangle  = document.getElementById('Rectangle');
	for(var i=0; i<Store.length; i++)
	{
	var Show = document.createElement('textarea');
        Show.value = Store[i];
	Rectangle.appendChild(Show);
	}

}
function writeStatistics(name,amount){
	var Text = document.createElement('textarea');
	Text.value = "kk";
        var  Rectangle  = document.getElementById('Statistics');
        for(var i =0; i <name.length; i++){
           Text.value = name[i] +" "+amount[i]+"\n";
        }
        count = 0;
        Rectangle.appendChild(Text);
}