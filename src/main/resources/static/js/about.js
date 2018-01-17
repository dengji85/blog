/*

@Name：不落阁整站模板源码 
@Author：Absolutely 
@Site：http://www.lyblogs.cn

*/

		
	var biryear = 2018;
	var birmonth = 1;
	var birday = 17;
	var year = new Date();
	var getyear = year.getYear();
	TMonth = new Array('Jan','Feb','Mar','Apr','May','June','July','Aug','Sep','Oct','Nov','Dec');
	nowMonth = birmonth - 1;
	bmonth = TMonth[nowMonth];
	var timerid;
	var timerRunning = false;
	var today = new Date();
	var startday = new Date();
	var enday = new Date();
	var minPerDay = 0;
	var secsLeft = 0;
	var secsRound = 0;
	var secsRemain = 0;
	var minLeft = 0;
	var minRound = 0;
	var minRemain = 0;
	var timeRemain = 0;
	function showtime() 
	{
		startday = new Date(""+bmonth+" "+birday+", "+biryear+" 00:00 EDT");
		startday.setYear(""+biryear+"");
		today = new Date();
		secsPerDay = 1000 ;
		minPerDay = 60 * 1000 ;
		hoursPerDay = 60 * 60 * 1000;
		PerDay = 24 * 60 * 60 * 1000;
		secsLeft = (today.getTime() - startday.getTime()) / minPerDay;
		secsRound = Math.round(secsLeft);
		secsRemain = secsLeft - secsRound;
		secsRemain = (secsRemain < 0) ? secsRemain = 60 - ((secsRound - secsLeft) * 60) : secsRemain = (secsLeft - secsRound) * 60;
		secsRemain = Math.round(secsRemain);
		minLeft = ((today.getTime() - startday.getTime()) / hoursPerDay);
		minRound = Math.round(minLeft);
		minRemain = minLeft - minRound;
		minRemain = (minRemain < 0) ? minRemain = 60 - ((minRound - minLeft) * 60) : minRemain = ((minLeft - minRound) * 60);
		minRemain = Math.round(minRemain - 0.495);
		hoursLeft = ((today.getTime() - startday.getTime()) / PerDay);
		hoursRound = Math.round(hoursLeft);
		hoursRemain = hoursLeft - hoursRound;
		hoursRemain = (hoursRemain < 0) ? hoursRemain = 24 - ((hoursRound - hoursLeft) * 24)  : hoursRemain = ((hoursLeft - hoursRound) * 24);
		hoursRemain = Math.round(hoursRemain - 0.5);
		daysLeft = ((today.getTime() - startday.getTime()) / PerDay);
		daysLeft = (daysLeft - 0.5);
		daysRound = Math.round(daysLeft);
		daysRemain = daysRound;
		day_rem = " 天 ： "
		hour_rem = " 小时 ： "
		min_rem = " 分 ： "
		sec_rem = " 秒"
		timeRemain = daysRemain + day_rem + hoursRemain + hour_rem + minRemain + min_rem + secsRemain + sec_rem;
		document.getElementById("face").innerText=timeRemain
		timerid = setTimeout("showtime()",1000);
		timerRunning = true;
	}
	



layui.use(['element', 'jquery', 'form', 'layedit'], function () {
    var element = layui.element;
    var form = layui.form;
    var $ = layui.jquery;
    var layedit = layui.layedit;

    //评论和留言的编辑器
    var editIndex = layedit.build('remarkEditor', {
        height: 150,
        tool: ['face', '|', 'left', 'center', 'right', '|', 'link'],
    });
    //评论和留言的编辑器的验证
    layui.form.verify({
        content: function (value) {
            value = $.trim(layedit.getText(editIndex));
            if (value == "") return "自少得有一个字吧";
            layedit.sync(editIndex);
        }
    });

    //Hash地址的定位
    var layid = location.hash.replace(/^#tabIndex=/, '');
    if (layid == "") {
        element.tabChange('tabAbout', 1);
    }
    element.tabChange('tabAbout', layid);

    element.on('tab(tabAbout)', function (elem) {
        location.hash = 'tabIndex=' + $(this).attr('lay-id');
    });

    //监听留言提交
    form.on('submit(formLeaveMessage)', function (data) {
        var index = layer.load(1);
        //模拟留言提交
        setTimeout(function () {
            layer.close(index);
            var content = data.field.editorContent;
            var html = '<li><div class="comment-parent"><img src="../images/Logo_40.png"alt="模拟留言"/><div class="info"><span class="username">模拟留言</span></div><div class="content">' + content + '</div><p class="info info-footer"><span class="time">2017-03-18 18:09</span><a class="btn-reply"href="javascript:;" onclick="btnReplyClick(this)">回复</a></p></div><!--回复表单默认隐藏--><div class="replycontainer layui-hide"><form class="layui-form"action=""><div class="layui-form-item"><textarea name="replyContent"lay-verify="replyContent"placeholder="请输入回复内容"class="layui-textarea"style="min-height:80px;"></textarea></div><div class="layui-form-item"><button class="layui-btn layui-btn-mini"lay-submit="formReply"lay-filter="formReply">提交</button></div></form></div></li>';
            $('.blog-comment').append(html);
            $('#remarkEditor').val('');
            editIndex = layui.layedit.build('remarkEditor', {
                height: 150,
                tool: ['face', '|', 'left', 'center', 'right', '|', 'link'],
            });
            layer.msg("留言成功", { icon: 1 });
        }, 500);
        return false;
    });

    //监听留言回复提交
    form.on('submit(formReply)', function (data) {
        var index = layer.load(1);
        //模拟留言回复
        setTimeout(function () {
            layer.close(index);
            var content = data.field.replyContent;
            var html = '<div class="comment-child"><img src="../images/Absolutely.jpg"alt="Absolutely"/><div class="info"><span class="username">模拟回复</span><span>' + content + '</span></div><p class="info"><span class="time">2017-03-18 18:26</span></p></div>';
            $(data.form).find('textarea').val('');
            $(data.form).parent('.replycontainer').before(html).siblings('.comment-parent').children('p').children('a').click();
            layer.msg("回复成功", { icon: 1 });
        }, 500);
        return false;
    });
});
function btnReplyClick(elem) {
    var $ = layui.jquery;
    $(elem).parent('p').parent('.comment-parent').siblings('.replycontainer').toggleClass('layui-hide');
    if ($(elem).text() == '回复') {
        $(elem).text('收起')
    } else {
        $(elem).text('回复')
    }
}
systemTime();

function systemTime() {
    //获取系统时间。
    var dateTime = new Date();
    var year = dateTime.getFullYear();
    var month = dateTime.getMonth() + 1;
    var day = dateTime.getDate();
    var hh = dateTime.getHours();
    var mm = dateTime.getMinutes();
    var ss = dateTime.getSeconds();

    //分秒时间是一位数字，在数字前补0。
    mm = extra(mm);
    ss = extra(ss);

    //将时间显示到ID为time的位置，时间格式形如：19:18:02
    document.getElementById("time").innerHTML = year + "-" + month + "-" + day + " " + hh + ":" + mm + ":" + ss;
    //每隔1000ms执行方法systemTime()。
    setTimeout("systemTime()", 1000);
}

//补位函数。
function extra(x) {
    //如果传入数字小于10，数字前补一位0。
    if (x < 10) {
        return "0" + x;
    }
    else {
        return x;
    }
}