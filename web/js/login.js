//Các xử lí kịch bản cho login.html

function checkValidLogin(fn){
    //lấy thông tin đăng nhập
    var username = fn.UserName.value;
    var userpass = fn.Pass.value;

    //biến xác nhận sự hợp lệ của giá trị
    var validUserName = true;
    var validPass = true;

    //biến ghi nhận thông báo sau mỗi lần kiểm tra
    var message="";

    //kiểm tra tên đăng nhập
    username = username.trim();
    if(username==""){
        validUserName = false;
        message = "Thiếu tên đăng nhập vào hệ thống.";
    }
    else{
        if(username.indexOf(" ")!=-1){
            validUserName = false;
            message = "Tên đăng nhập chứa dấu cách";
        }
        else if(username.length > 30){
            validUserName - false;
            message = "Tên đăng nhập quá dài có thể không chính xác.";
        }
        else if(username.indexOf("@")!=-1){
            //khai báo cấu trúc
            var partten = /\w+@\w+[.]\w/;
            if(!username.match(partten)){
                validUserName = false;
                message = "Không đúng cấu trúc hộp thư.";
            }
        }
    }
    //kiểm tra mật khẩu
    userpass = userpass.trim();
    if(userpass==""){
        validPass = false;
        message += "\n Thiếu mật khẩu đăng nhập hệ thống.";
    }
    else{
        if(userpass.length <6){
            validPass = false;
            message +="\n Mật khẩu không hợp lệ.";
        }
    }
    //xuất thông báo
    if(message!=""){
        //hiển thị thông báo
        window.alert(message);

        //di chuyển con trỏ về vị trí sai sót
        if(!validUserName){
            fn.UserName.select();
            fn.UserName.focus();
        }
        else if(!validUserPass){
            fn.Pass.select();
            fn.Pass.focus();
        }
    }
    //trả về kết quả kiểm tra
    return validUserName && validPass;

}

function login(fn){
    if(this.checkValidLogin(fn)){
        // fn.method="Post";//gọi phương thức doPost
        // fn.action="loginuser.jsp";//đường dẫn servlet
        // fn.submit();//Cơ chế thực thi gửi dữ liệu để xử lí
    }
}