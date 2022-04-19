function check(){
		var isSubmit = true;
		var name = document.studentAddForm.name.value;
		var age = document.studentAddForm.age.value;
		var score = document.studentAddForm.score.value;
		var address = document.studentAddForm.address.value;
		var stuClass = document.studentAddForm.stuClass.value;
		
		var nameError = '';
		var ageError = '';
		var scoreError = '';
		var addressError = '';
		var stuClassError = '';
		
		if(name == '') {
			nameError = '学生名前入力ください';
			isSubmit = false;
		}
		if(age == '') {
			ageError = '年齢入力ください';
			isSubmit = false;
		}
		if(score == '') {
			scoreError = '成績を入力ください';
			isSubmit = false;
		}
		if(address == '') {
			addressError = 'アドレスを入力ください';
			isSubmit = false;
		}
		if(stuClass = '') {
			stuClassError = 'クラスを入力ください';
			isSubmit = false;
		}
		//获取名称
		document.getElementsByName("nameError")[0].innerText = nameError;
		document.getElementsByName("ageError")[0].innerText = ageError;
		document.getElementsByName("scoreError")[0].innerText = scoreError;
		document.getElementsByName("addressError")[0].innerText = addressError;
		document.getElementsByName("stuClassError")[0].innerText = stuClassError;
		return isSubmit;
	}