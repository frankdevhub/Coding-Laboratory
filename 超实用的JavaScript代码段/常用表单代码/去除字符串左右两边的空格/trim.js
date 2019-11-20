window.onload =  function(){
	var _rstrsBtn = document.getElementById("rstrsBtn"), //获取过滤按钮对象
	    _strs = document.getElementById("strs"); //获取被过滤元素
		
	_rstrsBtn.onclick = function(){
		console.log('before:',_strs.value+"|");
		_strs.value = _strs.value.replace(/^(\s|\u00A0)+|(\s|\u00A0)+$/g,"");
		console.log('after:',_strs.value+"|");
	}	
}