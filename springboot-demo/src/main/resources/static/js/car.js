/*
*@Name: 母婴商城
*@Author: xuzhiwen
*@Copyright:layui.com
*/

layui.define(['layer','jquery'],function(exports){
    var $=layui.jquery;
    var layer = layui.layer;


    var car = {
        init : function(){
            var uls = document.getElementById('list-cont').getElementsByTagName('ul');//每一行
            var checkInputs = document.getElementsByClassName('check'); // 所有勾选框
            var checkAll = document.getElementsByClassName('check-all'); //全选框
            var SelectedPieces = document.getElementsByClassName('Selected-pieces')[0];//总件数
            var piecesTotal = document.getElementsByClassName('pieces-total')[0];//总价
            var batchdeletion = document.getElementsByClassName('batch-deletion')[0]//批量删除按钮
            var balancebutto=document.getElementById('balancebu');
            var totalmoney;
            balancebutto.onclick=function f() {
                var nameArray=new Array();
                var idArray=new Array();
                var eprice=new Array();
                var num=new Array();
                var goodimage=new Array();
                var j=0;
                for(var i=0;i<uls.length;i++){
                    if(uls[i].getElementsByTagName('input')[0].checked) {
                        nameArray[j] = $(uls[i]).find('.title').text() //商品名
                        idArray[j] = $(uls[i]).find('.Idd').text() //商品id
                        eprice[j] = $(uls[i]).find('.th-su').text()//商品的价格
                        num[j] = $(uls[i]).find('.Quantity-input')[0].value //选购的数量
                        goodimage[j] = $(uls[i]).find('img').attr("src")
                        j++;
                        // console.log("图片"+goodimage[i])
                        // console.log(nameArray + idArray + eprice + num)
                    }
                    // if(uls[i].getElementsByTagName('input')[0].checked&&i!=uls.length-1) {
                    //     nameArray[i] = $(uls[i]).find('.title').text()+"/"//商品名
                    //     idArray[i] = $(uls[i]).find('.Idd').text()+"/"//商品id
                    //     eprice[i] = $(uls[i]).find('.th-su').text()+"/"//商品的价格
                    //     num[i] = $(uls[i]).find('.Quantity-input')[0].value+"/"//选购的数量
                    //     goodimage[i]=$(uls[i]).find('img').attr("src")+"/"
                    //     // console.log("图片"+goodimage[i])
                    //     // console.log(nameArray + idArray + eprice + num)
                    // }else if(uls[i].getElementsByTagName('input')[0].checked&&i==uls.length-1) {
                    //     nameArray[i] = $(uls[i]).find('.title').text()//商品名
                    //     idArray[i] = $(uls[i]).find('.Idd').text()//商品id
                    //     eprice[i] = $(uls[i]).find('.th-su').text()//商品的价格
                    //     num[i] = $(uls[i]).find('.Quantity-input')[0].value//选购的数量
                    //     goodimage[i]=$(uls[i]).find('img').attr("src")
                    //     // console.log(nameArray + idArray + eprice + num)
                    // }
                }
                var localUserId=localStorage.getItem("localUserId")
                var UserName=localStorage.getItem("UserName")
                localStorage.clear();
                localStorage.setItem("localUserId",localUserId)
                localStorage.setItem("UserName",UserName)
                localStorage.setItem("name",nameArray)
                localStorage.setItem("id",idArray)
                localStorage.setItem("price",eprice)
                localStorage.setItem("num",num)
                localStorage.setItem("goodimage",goodimage)
                totalmoney=$("#totalMoney").text();
                localStorage.setItem("totalmoney",totalmoney)
                // alert(idArray)
                alert(totalmoney)
                window.location.href="/countpay.html"
            }
            //计算总价钱
            function getTotal(){
                var seleted = 0,price = 0;
                for(var i = 0; i < uls.length;i++){
                    if(uls[i].getElementsByTagName('input')[0].checked){
                        seleted += parseInt(uls[i].getElementsByClassName('Quantity-input')[0].value);
                        price += parseFloat(uls[i].getElementsByClassName('sum')[0].innerHTML);
                    }
                }
                piecesTotal.innerHTML = price.toFixed(2);
                SelectedPieces.innerHTML=seleted;
            }
            // 每个商品的小计
            function getSubTotal(ul){
                var unitprice = parseFloat(ul.getElementsByClassName('th-su')[0].innerHTML);
                var count = parseInt(ul.getElementsByClassName('Quantity-input')[0].value);
                var SubTotal = parseFloat(unitprice*count)
                ul.getElementsByClassName('sum')[0].innerHTML = SubTotal.toFixed(2);
            }
            for(var i = 0;i < checkInputs.length;i++){
                checkInputs[i].onclick = function(){
                    if(this.className === 'check-all check'){//全选
                        for(var j = 0;j < checkInputs.length; j++){
                            checkInputs[j].checked = this.checked;
                        }
                    }
                    if(this.checked == false){
                        for(var k = 0;k < checkAll.length;k++){//有一个没选，就关闭全选
                            checkAll[k].checked = false;
                        }
                    }
                    getTotal()
                }
            }
            // var key=0;
            // var cartId = new Array();
            // $(".Idd").each(function(){
            //     cartId[key] = $(this).text();
            //     key++;
            // })
            // console.log(cartId)
            // console.log(cartId[0])

            for(var i = 0; i < uls.length;i++){
                uls[i].onclick = function(e){
                    //console.log(cartIdchild)
                    e = e || window.event;
                    var el = e.srcElement;
                    var cls = el.className;
                    var input = this.getElementsByClassName('Quantity-input')[0];
                    var less = this.getElementsByClassName('less')[0];
                    var val = parseInt(input.value);
                    var that = this;
                    switch(cls){
                        case 'add layui-btn':
                            input.value = val + 1;
                            getSubTotal(this)
                            $.ajax({
                                url:"cart/up/good/"+$(that).find('.Idd').text()+"/"+parseInt(localStorage.getItem("localUserId")),
                                type:"get",
                                dataType:"json",
                                success:function (res) {
                                    alert(res)
                                }
                            })
                            break;
                        case 'less layui-btn':
                            if(val > 1){
                                input.value = val - 1;
                            }
                            getSubTotal(this)
                            $.ajax({
                                url:"cart/down/good/"+$(that).find('.Idd').text()+"/"+parseInt(localStorage.getItem("localUserId")),
                                type:"get",
                                dataType:"json",
                                success:function (res) {
                                    alert(res)
                                }
                            })
                            break;
                        case 'dele-btn':
                            layer.confirm('你确定要删除吗',{
                                yes:function(index,layero){
                                    var deleteId=$(that).find(".Idd").text()
                                    $.ajax({
                                        url:"/user/"+parseInt(localStorage.getItem("localUserId"))+"/cart/delete/"+deleteId,
                                        type:"get",
                                        dataType:"json",
                                        success:function (res) {

                                        }
                                    })
                                    // console.log($(that).find(".Idd").text())
                                    layer.close(index)
                                    that.parentNode.removeChild(that);
                                }
                            })
                            break;
                    }
                    getTotal()
                }
            }
            batchdeletion.onclick = function(){
                if(SelectedPieces.innerHTML != 0){
                    layer.confirm('你确定要删除吗',{
                        yes:function(index,layero){
                            layer.close(index)
                            for(var i = 0;i < uls.length;i++){
                                var input = uls[i].getElementsByTagName('input')[0];
                                if(input.checked){
                                    uls[i].parentNode.removeChild(uls[i]);
                                    i--;
                                }
                            }
                            getTotal()
                        }

                    })
                }else{
                    layer.msg('请选择商品')
                }

            }
            checkAll[0].checked = true;
            checkAll[0].onclick();

        },
        balance:function () {
            alert("结算啦" )
        }

    }


    exports('car',car)
});