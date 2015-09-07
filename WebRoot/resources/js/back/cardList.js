/**
 * 调用后台批量删除
 */
function deleteBatch(basePath){
	$("#mainForm").attr("action",basePath+"/DeleteBatchServlet.action");
	$("#mainForm").submit();
			
}

function toEdit(basePath,card_no,card_owner){
	var card_owners = card_owner;
	var card_nos = card_no;
	alert(card_owners+","+card_nos);
	//return;
	window.open(basePath+"modify/edit?cardNo="+card_nos+"&cardOwner="+card_owners, 'edit',  'top=0, left=0, toolbar=no, menubar=no, scrollbars=no, resizable=no, location=no, status=no');
	
}
/**跳转到新增页面**/
function addCard(basePath){
	window.open(basePath+"add/newCard", "newCard",'top=0, left=0, toolbar=no, menubar=no, scrollbars=no, resizable=no, location=no, status=no');
}
/**保存新增的数据**//*
function saveCard(basePath){
	
}*/