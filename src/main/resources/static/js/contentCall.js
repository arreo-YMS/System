// Sidebar Dropdown
var dropdown = document.getElementsByClassName("dropdown-btn");
var i;

for (i = 0; i < dropdown.length; i++) {
    dropdown[i].addEventListener("click", function() {
    this.classList.toggle("active");
    var dropdownContent = this.nextElementSibling;
    if (dropdownContent.style.display === "block") {
    dropdownContent.style.display = "none";
    } else {
    dropdownContent.style.display = "block";
    }
    });
}

// 회원가입
function signUp() {
    $("#section *").remove(); 
    var tmpAppendVar = "";
    tmpAppendVar = '<iframe id="signUp" src="signUp.html" width="757" height="1150" frameborder="0" scrolling="no"></iframe>';
    $("#section").append(tmpAppendVar);

    $(window).scrollTop(0);
}

// 실명인증
function authName() {
    $("#section *").remove(); 
    var tmpAppendVar = "";
    tmpAppendVar = '<iframe id="authName" src="authName.html" width="757" height="1100" frameborder="0" scrolling="no"></iframe>';
    $("#section").append(tmpAppendVar);

    $(window).scrollTop(0);
}

// 아이디 및 비밀번호 찾기
function findLogInInfo() {
    $("#section *").remove(); 
    var tmpAppendVar = "";
    tmpAppendVar = '<iframe id="findLogInInfo" src="findLogInInfo.html" width="757" height="900" frameborder="0" scrolling="no"></iframe>';
    $("#section").append(tmpAppendVar);

    $(window).scrollTop(0);
}

//전송관리
function sendManagement(){
    $("#section *").remove();
    var tmpAppendVar = "";
    tmpAppendVar = '<iframe id="sendManagement" src="sendManagement.html" width="757" height="900" frameborder="0" scrolling="no"></iframe>';
    $("#section").append(tmpAppendVar);

    $(window).scrollTop(0);
}

//내역
function history1(){
    $("#section *").remove();
    var tmpAppendVar = "";
    tmpAppendVar = '<iframe id="history" src="history.html" width="757" height="900" frameborder="0" scrolling="no"></iframe>';
    $("#section").append(tmpAppendVar);

    $(window).scrollTop(0);
}

//변경 및 초기화
function update(){
    $("#section *").remove();
    var tmpAppendVar = "";
    tmpAppendVar = '<iframe id="update" src="update.html" width="757" height="1000" frameborder="0" scrolling="no"></iframe>';
    $("#section").append(tmpAppendVar);

    $(window).scrollTop(0);
}

//영수증 발급
function receipt(){
    $("#section *").remove();
    var tmpAppendVar = "";
    tmpAppendVar = '<iframe id="receipt" src="receipt.html" width="1000" height="1000" frameborder="0" scrolling="no"></iframe>';
    $("#section").append(tmpAppendVar);

    $(window).scrollTop(0);
}

//명의이전
function changename(){
    $("#section *").remove();
    var tmpAppendVar = "";
    tmpAppendVar = '<iframe id="changename" src="changename.html" width="1000" height="1000" frameborder="0" scrolling="no"></iframe>';
    $("#section").append(tmpAppendVar);

    $(window).scrollTop(0);
}

//캐쉬관리
function cash(){
    $("#section *").remove();
    var tmpAppendVar = "";
    tmpAppendVar = '<iframe id="cash" src="cash.html" width="1000" height="1500" frameborder="0" scrolling="no"></iframe>';
    $("#section").append(tmpAppendVar);

    $(window).scrollTop(0);
}

//회원탈퇴
function withdrawal(){
    $("#section *").remove();
    var tmpAppendVar = "";
    tmpAppendVar = '<iframe id="withdrawal" src="withdrawal.html" width="1000" height="1150" frameborder="0" scrolling="no"></iframe>';
    $("#section").append(tmpAppendVar);

    $(window).scrollTop(0);
}

//캐쉬 및 포인트
function point(){
    $("#section *").remove();
    var tmpAppendVar = "";
    tmpAppendVar = '<iframe id="point" src="point.html" width="1000" height="3500" frameborder="0" scrolling="no"></iframe>';
    $("#section").append(tmpAppendVar);

    $(window).scrollTop(0);
}

//결제방법
function payment(){
    $("#section *").remove();
    var tmpAppendVar = "";
    tmpAppendVar = '<iframe id="payment" src="payment.html" width="1000" height="2000" frameborder="0" scrolling="no"></iframe>';
    $("#section").append(tmpAppendVar);

    $(window).scrollTop(0);
}

//서비스 요금
function service(){
    $("#section *").remove();
    var tmpAppendVar = "";
    tmpAppendVar = '<iframe id="service" src="service.html" width="1000" height="1300" frameborder="0" scrolling="no"></iframe>';
    $("#section").append(tmpAppendVar);

    $(window).scrollTop(0);
}

//결제 취소
function cancelpay(){
    $("#section *").remove();
    var tmpAppendVar = "";
    tmpAppendVar = '<iframe id="cancelpay" src="cancelpay.html" width="1000" height="1000" frameborder="0" scrolling="no"></iframe>';
    $("#section").append(tmpAppendVar);

    $(window).scrollTop(0);
}

//현금영수증
function cashreceipt(){
    $("#section *").remove();
    var tmpAppendVar = "";
    tmpAppendVar = '<iframe id="cashreceipt" src="cashreceipt.html" width="1200" height="3000" frameborder="0" scrolling="no"></iframe>';
    $("#section").append(tmpAppendVar);

    $(window).scrollTop(0);
}

//세금계산서
function taxbill(){
    $("#section *").remove();
    var tmpAppendVar = "";
    tmpAppendVar = '<iframe id="taxbill" src="taxbill.html" width="1200" height="3200" frameborder="0" scrolling="no"></iframe>';
    $("#section").append(tmpAppendVar);

    $(window).scrollTop(0);
}

//그룹 및 주소록 등록 관련
function address(){
    $("#section *").remove();
    var tmpAppendVar = "";
    tmpAppendVar = '<iframe id="address" src="address.html" width="1200" height="2800" frameborder="0" scrolling="no"></iframe>';
    $("#section").append(tmpAppendVar);

    $(window).scrollTop(0);
}

//명함 보내기
function businesscard(){
    $("#section *").remove();
    var tmpAppendVar = "";
    tmpAppendVar = '<iframe id="businesscard" src="businesscard.html" width="1200" height="700" frameborder="0" scrolling="no"></iframe>';
    $("#section").append(tmpAppendVar);

    $(window).scrollTop(0);
}

//발신번호 사전등록
function registration(){
    $("#section *").remove();
    var tmpAppendVar = "";
    tmpAppendVar = '<iframe id="registration" src="registration.html" width="1200" height="1700" frameborder="0" scrolling="no"></iframe>';
    $("#section").append(tmpAppendVar);

    $(window).scrollTop(0);
}

//전송관련
function send(){
    $("#section *").remove();
    var tmpAppendVar = "";
    tmpAppendVar = '<iframe id="send" src="send.html" width="1200" height="3300" frameborder="0" scrolling="no"></iframe>';
    $("#section").append(tmpAppendVar);

    $(window).scrollTop(0);
}

//모바일 상품권
function giftcard(){
    $("#section *").remove();
    var tmpAppendVar = "";
    tmpAppendVar = '<iframe id="giftcard" src="giftcard.html" width="1200" height="1150" frameborder="0" scrolling="no"></iframe>';
    $("#section").append(tmpAppendVar);

    $(window).scrollTop(0);
}

//전송결과
function sendresult(){
    $("#section *").remove();
    var tmpAppendVar = "";
    tmpAppendVar = '<iframe id="sendresult" src="sendresult.html" width="1200" height="1150" frameborder="0" scrolling="no"></iframe>';
    $("#section").append(tmpAppendVar);

    $(window).scrollTop(0);
}

//080문자전송
function send2(){
    $("#section *").remove();
    var tmpAppendVar = "";
    tmpAppendVar = '<iframe id="send2" src="send2.html" width="1200" height="1150" frameborder="0" scrolling="no"></iframe>';
    $("#section").append(tmpAppendVar);

    $(window).scrollTop(0);
}

//선거용 계정 등록
function election(){
    $("#section *").remove();
    var tmpAppendVar = "";
    tmpAppendVar = '<iframe id="election" src="election.html" width="1200" height="1150" frameborder="0" scrolling="no"></iframe>';
    $("#section").append(tmpAppendVar);

    $(window).scrollTop(0);
}

//문자 마케팅
function marketing(){
    $("#section *").remove();
    var tmpAppendVar = "";
    tmpAppendVar = '<iframe id="marketing" src="marketing.html" width="1200" height="1150" frameborder="0" scrolling="no"></iframe>';
    $("#section").append(tmpAppendVar);

    $(window).scrollTop(0);
}

//대량 메일
function bigmail(){
    $("#section *").remove();
    var tmpAppendVar = "";
    tmpAppendVar = '<iframe id="bigmail" src="bigmail.html" width="1200" height="500" frameborder="0" scrolling="no"></iframe>';
    $("#section").append(tmpAppendVar);

    $(window).scrollTop(0);
}

//폰메일 서비스
function phnmail(){
    $("#section *").remove();
    var tmpAppendVar = "";
    tmpAppendVar = '<iframe id="phnmail" src="phnmail.html" width="1200" height="500" frameborder="0" scrolling="no"></iframe>';
    $("#section").append(tmpAppendVar);

    $(window).scrollTop(0);
}

//메일 도착 알림 서비스
function mailalarm(){
    $("#section *").remove();
    var tmpAppendVar = "";
    tmpAppendVar = '<iframe id="mailalarm" src="mailalarm.html" width="1200" height="800" frameborder="0" scrolling="no"></iframe>';
    $("#section").append(tmpAppendVar);

    $(window).scrollTop(0);
}

//무료문자 쿠폰
function freesend(){
    $("#section *").remove();
    var tmpAppendVar = "";
    tmpAppendVar = '<iframe id="freesend" src="freesend.html" width="1200" height="800" frameborder="0" scrolling="no"></iframe>';
    $("#section").append(tmpAppendVar);

    $(window).scrollTop(0);
}

//팩스 보내기
function faxsend(){
    $("#section *").remove();
    var tmpAppendVar = "";
    tmpAppendVar = '<iframe id="faxsend" src="faxsend.html" width="757" height="900" frameborder="0" scrolling="no"></iframe>';
    $("#section").append(tmpAppendVar);

    $(window).scrollTop(0);
}

//받은 팩스함
function faxreceive(){
    $("#section *").remove();
    var tmpAppendVar = "";
    tmpAppendVar = '<iframe id="faxreceive" src="faxreceive.html" width="757" height="900" frameborder="0" scrolling="no"></iframe>';
    $("#section").append(tmpAppendVar);

    $(window).scrollTop(0);
}

//팩스함 관리
function faxmanagement(){
    $("#section *").remove();
    var tmpAppendVar = "";
    tmpAppendVar = '<iframe id="faxmanagement" src="faxmanagement.html" width="757" height="500" frameborder="0" scrolling="no"></iframe>';
    $("#section").append(tmpAppendVar);

    $(window).scrollTop(0);
}

//팩스 전송 상태
function faxstatus(){
    $("#section *").remove();
    var tmpAppendVar = "";
    tmpAppendVar = '<iframe id="faxstatus" src="faxstatus.html" width="757" height="600" frameborder="0" scrolling="no"></iframe>';
    $("#section").append(tmpAppendVar);

    $(window).scrollTop(0);
}

//015 번호 관련
function num015(){
    $("#section *").remove();
    var tmpAppendVar = "";
    tmpAppendVar = '<iframe id="num015" src="num015.html" width="757" height="900" frameborder="0" scrolling="no"></iframe>';
    $("#section").append(tmpAppendVar);

    $(window).scrollTop(0);
}

//환경설정
function setting(){
    $("#section *").remove();
    var tmpAppendVar = "";
    tmpAppendVar = '<iframe id="setting" src="setting.html" width="1200" height="1150" frameborder="0" scrolling="no"></iframe>';
    $("#section").append(tmpAppendVar);

    $(window).scrollTop(0);
}

//기타
function etc(){
    $("#section *").remove();
    var tmpAppendVar = "";
    tmpAppendVar = '<iframe id="etc" src="etc.html" width="1000" height="2000" frameborder="0" scrolling="no"></iframe>';
    $("#section").append(tmpAppendVar);

    $(window).scrollTop(0);
}