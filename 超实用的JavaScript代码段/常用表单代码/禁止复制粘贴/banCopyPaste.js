window.onload = function(){
	var element = document.getElementById("banCopyPaste");
	
	element.onpaste = function(){
		return false;
	};
	
	element.oncopy = function(){
		return false;
	}
}