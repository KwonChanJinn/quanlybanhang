function handleRegisterAccount() {
    var usernameInput = $("#username").val();
    var passwordInput = $("#password").val();
    var account = {
        email: $("#emailID").val(),
        userName: $("#usernameID").val(),
        fullName: $("#fullnameID").val(),
        departmentId: 1,
        positionId: 1,
        role: "EMPLOYEE",
        password: $("#password").val(),
    };

    $.ajax({
        type: "POST",
        url: "http://localhost:8080/api/v1/account/register",
        data: JSON.stringify(account),
        contentType: "application/json; charset=UTF-8",
        beforeSend: function (xhr) {
            xhr.setRequestHeader(
                "Authorization",
                // xử lý lại đoạn này làm sao mà ko cần đăng nhập mà nó vẫn có thể vào
                // su dung jwt
                "Basic " + btoa("thanhsong:123")
                // btoa(`${usernameInput}:${passwordInput}`)
            );
        },
        success: function (response) {
            alert("Đăng ký tài khoản thành công");
            window.open("Login.html", "_self");
        },
        error: function (error) {
            alert("Đăng ký không thành công");
        },
    });
}
