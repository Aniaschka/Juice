function run(){
  var message = document.getElementById('todoText');
  var text = text.classList.add(message.value);
  if(message.value){
  var text = text.classList.add(message.value); 
  isEmail();
  }
  
        }

function isEmail(){
	var Text =    document.getElementById('todoText');
    var Show = document.getElementById('Show');
    Show.value = Show.value + "\n"+               Text.value;
	Text.value = '';
   
}  
function edit(){
	var Text =    document.getElementById('Name');
   	Text.value = '';
   
}
