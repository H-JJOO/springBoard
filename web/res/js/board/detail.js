const btnContainerElem = document.querySelector('#btnContainer');
if(btnContainerElem) {
    const btnDelElem = btnContainerElem.querySelector('#btnDel');
    btnDelElem.addEventListener('click', function () {
        if (confirm('삭제하시겠습니까?')) {
            //주소 이동
            location.href='/board/del?iboard=' + btnContainerElem.dataset.iboard;
        }
    });
}


// var btnModElem = btnContainerElem.querySelector('#btnMod');
// btnModElem.addEventListener('click', function () {
//     location.href='/board/mod?iboard=' + btnContainerElem.dataset.iboard;
// })