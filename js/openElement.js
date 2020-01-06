
// 以100毫秒间隔点击页面元素
setInterval(
    function () {
        var aElements = document.getElementsByClassName('click-to-expand js-click-to-expand');
        var aEle = [];//内容矩阵
        for (var i = 0; i < aElements.length; i++) {
            aEle.push(aElements[i]);
        }
        aEle[0].click();
        //以100毫秒间隔点击内容矩阵中第一个元素
    }, 50);

// 以100毫秒间隔每次点击5个页面元素
setInterval(
    function () {
        var aElements = document.getElementsByClassName('click-to-expand js-click-to-expand');
        var aEle = [];//内容矩阵
        for (var i = 0; i < aElements.length; ) {
            aEle.push(aElements[i++]);
            aEle.push(aElements[i++]);
            aEle.push(aElements[i++]);
            aEle.push(aElements[i++]);
            aEle.push(aElements[i++]);
        }
        aEle[0].click();
        aEle[1].click();
        aEle[2].click();
        aEle[3].click();
        aEle[4].click();
    }, 100);//以100毫秒间隔点击内容矩阵中第一个元素
