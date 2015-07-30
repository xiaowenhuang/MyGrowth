/**
 * 调用后台批量删除
 */
function deleteBatch(basePath){
	$("#mainForm").attr("action",basePath+"/DeleteBatchServlet.action");
	$("#mainForm").submit();
			
}

function modifyContent(basePath){
	window.open(basePath+"WEB-INF/jsp/back/Edit.jsp", 'edit',  'height=100, width=400, top=0, left=0, toolbar=no, menubar=no, scrollbars=no, resizable=no, location=no, status=no');
	
}