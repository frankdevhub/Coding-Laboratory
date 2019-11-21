window.onload =  function(){
	var _isContent = document.getElementById("isContent"), //获取过滤按钮对象
	    _strs = document.getElementById("strs"); //获取被过滤元素
	
    var isContent  = function(chars){
		return !chars ? true: false;
	};
	
	_isContent.onclick = function(){
		console.log('before:',_strs.value+"|");
		_strs.value = _strs.value.replace(/^(\s|\u00A0)+|(\s|\u00A0)+$/g,"");
		console.log('after:',_strs.value+"|");
		
		if(isContent(_strs.value)){
			alert("您的输入为空！");
		}else{
			alert("您的输入不为空！");
		}
	};	
}