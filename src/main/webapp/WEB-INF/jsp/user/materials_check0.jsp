<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"/>
    <meta charset="utf-8"/>
    <title>物资捐赠管理系统</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/bootstrap.css"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/components/font-awesome/css/font-awesome.css"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/ace.css" class="ace-main-stylesheet"
          id="main-ace-style"/>
    <script src="${pageContext.request.contextPath}/assets/js/jquery-3.6.0.js"></script>
</head>
<body class="no-skin">
<div class="main-container ace-save-state" id="main-container">
    <div class="main-content">
        <div class="main-content-inner">
            <div class="page-content">
                <div class="page-header">
                    <h1>待管理员审核的物资：</h1>
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
                                        <th>捐赠日期</th>
                                        <th>操作</th>
                                    </tr>
                                    </thead>
                                    <tbody>
                                    <c:choose>
                                        <c:when test="${not empty MaterialsList }">
                                            <c:forEach items="${MaterialsList }" varStatus="index" var="material">
                                                <tr>
                                                    <td>
                                                            ${index.count }
                                                        <input type="hidden" name="m_id" value="${material.mId }" />
                                                    </td>
                                                    <td> ${material.mMaterialName }</td>
                                                    <td>${material.mDonator }</td>
                                                    <td>${material.mMaterialType }</td>
                                                    <td>${material.mFactdate }</td>
                                                    <td>${material.mCheckdate }</td>
                                                    <td>${material.mDate }</td>
                                                    <td>
                                                        <div class="hidden-sm hidden-xs btn-group">
                                                            <!-- <button class="btn btn-xs btn-success">
                                                                <i class="ace-icon fa fa-check bigger-120"></i>
                                                            </button> -->
                                                            <button class="btn btn-xs btn-info" title="编辑"
                                                                    onclick="toEditCheck0('${material.mId}')">
                                                                <i class="ace-icon fa fa-pencil bigger-120"></i>
                                                            </button>
                                                            <button class="btn btn-xs btn-danger" title="删除"
                                                                    onclick="deleteCheck0('${material.mId}')">
                                                                <i class="ace-icon fa fa-trash-o bigger-120"></i>
                                                            </button>
                                                        </div>
                                                    </td>
                                                </tr>
                                            </c:forEach>
                                        </c:when>
                                        <c:otherwise>
                                            <tr>
                                                <td colspan="6"><h1>您还未捐赠过物资！</h1></td>
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
        window.location.href = "toEditCheck0?mId=" + m_id;
    }

    // 删除物资.
    function deleteCheck0(m_id) {
        if (confirm('确定要删除该物资信息吗？')) {
            $.ajax({
                type: "post",
                url: "deleteCheck0",
                data: {mId: m_id},
                dataType: 'json',
                success: function (data) {
                    if (data.msg == 'success') {
                        alert("删除成功！");
                        window.location.href = "main";
                    } else {
                        alert("删除失败!");
                    }
                },
                error: function () {
                    alert('操作错误！');
                }
            });
        }
    }
</script>
</body>
</html>