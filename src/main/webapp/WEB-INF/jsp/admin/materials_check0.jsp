<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
	<head>
		<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
		<meta charset="utf-8" />
		<title>物资捐赠管理系统</title>
		<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0" />
		<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/bootstrap.css" />
		<link rel="stylesheet" href="${pageContext.request.contextPath}/components/font-awesome/css/font-awesome.css" />
		<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/ace.css" class="ace-main-stylesheet" id="main-ace-style" />
		<script src="${pageContext.request.contextPath}/assets/js/jquery-3.6.0.js"></script>
	</head>
	<body class="no-skin">
		<div class="main-container ace-save-state" id="main-container">
			<div class="main-content">
				<div class="main-content-inner">
					<div class="page-content">
						<div class="page-header">
							<h1>请您审核以下物资：</h1>
						</div>
						<div class="row">
							<div class="col-xs-12">
								<div class="row">
									<div class="col-xs-12">
										<table id="simple-table" class="table  table-bordered table-hover">
											<thead>
											<tr>
												<th>序号</th>
												<th>物资名称</th>
												<th>捐赠人</th>
												<th>物资类型</th>
												<th>生产日期</th>
												<th>审核日期</th>
												<th>操作</th>
											</tr>
											</thead>
											<tbody>
											<c:choose>
												<c:when test="${not empty materialsList }">
													<c:forEach items="${materialsList }" varStatus="index" var="material">
														<tr>
															<td>
																	${index.count }
																<input type="hidden" name="m_id" value="${material.mId }" />
															</td>
															<td> ${material.mMaterialName }</td>
															<td>${material.mDonator }</td>
															<td>${material.mMaterialType }</td>
															<td>${material.mFactdate }</td>
															<td>${material.mCheckdate  }</td>
															<td>
																	<div class="hidden-sm hidden-xs btn-group">
																		<button class="btn btn-xs btn-info" title="通过审核" onclick="adminCheck_0Success('${material.mId}')">
																			<i class="ace-icon fa fa-check bigger-120"></i>通过审核
																		</button>
																		<button class="btn btn-xs btn-danger" title="审核不通过" onclick="adminCheckNo('${material.mId}')" >
																			<i class="ace-icon fa fa-times bigger-120"></i>审核不通过
																		</button>
																	</div>
																</td>
															</tr>
														</c:forEach>
													</c:when>
													<c:otherwise>
														<tr>
															<td colspan="6"><h1>还未有用户的物资捐赠请求信息！</h1></td>
														</tr>
													</c:otherwise>
												</c:choose>
											</tbody>
										</table>
									</div>
								</div>
								<div class="hr hr-18 dotted hr-double"></div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
		
		<script type="text/javascript">
			
			// 编辑物资
			function toEditCheck0(m_id) {
				window.location.href="toEditCheck0?mId=" + m_id;
			}
			
			// 管理员 审核物资-通过审核
			function adminCheck_0Success(m_id) {
				if (confirm('确定要通过该物资的审核吗？')) {
					$.ajax({
						type : "post",
						url : "adminCheck_0Success",
						data : {mId:m_id},
						dataType : 'json',
						success : function(data){ 
							if (data.msg == 'success') {
								alert("审核已通过！");
								window.location.href="toMaterialCheck_0";
							} else {
								alert("审核操作失败!");
							}
						},
						error : function() {
							alert('操作错误！');
						}
					});
				}
			}
			
			// 审核不通过 m_check=2.
			function adminCheckNo(m_id) {
				if (confirm('确定不通过该物资的捐赠请求吗？')) {
					$.ajax({
						type : "post",
						url : "adminCheckNo",
						data : {mId:m_id},
						dataType : 'json',
						success : function(data){ 
							if (data.msg == 'success') {
								alert("操作成功！");
								window.location.href="toMaterialCheck_0";
							} else {
								alert("操作失败!");
							}
						},
						error : function() {
							alert('操作错误！');
						}
					});
				}
			}
		</script>
	</body>
</html>