function moveToDetail(iboard) {//매개변수
    location.href='/board/detail?iboard=' + iboard;
}

var trList = document.querySelectorAll('.record')
console.log(trList);


for(var i = 0; i < trList.length; i++) {
    var tr = trList[i];
    setEvent(tr);
}

function setEvent(tr) {//호이스팅 문제 해결, 클로저 closure
    tr.addEventListener('click', function () {
        moveToDetail(tr.dataset.iboard);
    });

}