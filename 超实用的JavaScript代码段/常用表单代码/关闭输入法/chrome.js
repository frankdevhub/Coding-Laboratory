window.onload = function(){
	
	//除Chrome浏览器以外的浏览器支持
	var getElement = function(str){
		return document.getElementById(str);
	};
	
	function banInputMethodGoogle(_elementArr){
		var arr = _elementArr,  //待处理的节点元素
		    self = this;
			
		if(_elementArr instanceof Array){
			arr = [_elementArr];
		}	
		
		for(var i=0; i<arr.length; i++){
			var arrElement = arr[i];
			arrElement.onfocus = function(){
				this.style.imeMode = 'disabled';  //除Chrome浏览器以外的浏览器支持
			}
		}
	};
	
	banInputMethodGoogle(getElement("banInputMethodGoogle"));
}