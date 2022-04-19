//功能检查
function check() {
	var username = document.loginForm.username.value;
	var password = document.loginForm.password.value;
	if (username == '' || password == '') {
		alert('请输入用户名或密码');
		return false;
	}
	return true;
}