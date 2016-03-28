<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" session="false" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <link href="http://gmpg.org/xfn/11" rel="profile">
    <title>少壮不努力，长大抢粮票</title>
    <link rel="stylesheet" href="static/style/style.css">
    <link rel="stylesheet" href="static/style/button.css">
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.2/html5shiv.js"></script>
    <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->

</head>
<body>
<div class="container">
    <div class="post">
        <img src="static/img/u=3961369646,892642885&fm=21&gp=0.jpg" />
        <img src="static/img/01300000172566125318704296867.png"/>
        <p>鲁迅先生小时候上私塾，有一天迟到了，被老师用戒尺打手心，于是在课桌上刻下了一个“草”字，
            还是因为勤奋，他手肘把艹磨掉了，就有了我们课本上的课文。据说还因为破坏公物又被打了一戒尺。从这个故事当中，
            我领悟到一定要学好雕刻，要是当年鲁迅先生刻了个精美的篆体“草”，兴许老是对他会爱护有加呢。</p>
        <img src="static/img/dfc69553jw1e9t1dqd2hqj20dw0epaas.jpg">
        <p>我<span style="color: crimson">${param.ID}</span>作为一枚<span style="color: crimson">${param.1}</span>级的资深屌丝，哪有什么机会学习篆刻。
            要是我，当你就会快手将草字刻在同桌的的桌上然后举手告诉老师他破坏公物，
            再领一朵小红花。这个故事又告诉你们，只要手快，是可以改变世界的。</p>
        <img src="static/img/u=2963533407,2381538161&fm=11&gp=0.jpg">
        <p>现在我依靠极速手指头，已经在${param.5}抢到一张${param.2}元的粮票了，
            然后不知不觉中，合计抢到了${param.3}张${param.4}元的粮票了。
            我经常请女神吃饭，可是她始终没有对我有过一丝暧昧的眼神，
            难道我告诉过她我很快，两三秒就完事？拜托！！那是抢粮票好不好！</p>
        <img src="static/img/1451032558641423.jpg">
    </div>
    <footer class="colophon">
        <ul>
            <li><div class="button yellow"><div class="shine"></div>APP STORE</div></li>
            <li><div class="button yellow"><div class="shine"></div>ANDROID</div></li>
        </ul>
        <ul>
            <li><div class="button pink"><div class="shine"></div>我的邀请码 : 123456</div></li>
        </ul>
        <ul>
            <li style="font-size: 1.3em;color: #F2353F"> 觉得你朋友的名字出现在文章里很好玩？ </li>
        </ul>
        <ul>
            <li style="font-size: 1.3em;color: #F2353F"> 帮你朋友转发有现金奖励等你拿,快长按指纹扫描关注订阅号吧! </li>
        </ul>
        <img src="static/img/footer.png" style="text-align: center">
    </footer>
</div>
</body>
</html>