app.controller('materijalFormaController', ['$scope', 'funkcije', '$localStorage', 
	function($scope, funkcije, $localStorage) {

	$scope.materijal = $localStorage.materijal;
	$scope.defaultImage = "http://dummyimage.com/400x200/f5f5f5000.jpg&text=Click+here+to+upload+your+image";

	if ($scope.materijal != null && $scope.materijal != "" && $scope.materijal != undefined) {
		$scope.defaultImage = $scope.materijal.video;
	} 

	$scope.dodajMaterijal = function() {
		$scope.materijal.korisnikId = $localStorage.korisnik.korisnikId;
		$scope.materijal.temaId = $localStorage.tema;
		funkcije.dodajmaterijal($scope.materijal)
		.success(function(response) {
			window.location = "#/materijalprikazstudent";
		})
		.error(function() {
			alert("Došlo je do greške u komunikaciji sa serverom, pokušajte kasnije!");
		});
	}

	$scope.odustani = function() {
		delete $localStorage.materijal;
		$scope.rola = $localStorage.rola;

		if ($scope.rola == 'STUDENT') {
			window.location = "#/materijalprikazstudent";
		} else {
			window.location = "#/materijalprikazprofesor";
		}
	}

	$scope.readURL = function() {
		var input = document.getElementById('image-picker');

	    if (input.files && input.files[0]) {
        	var reader = new FileReader();

        	reader.onload = function (e) {
        		$scope.materijal.video = e.target.result;
	        	document.getElementById('image-preview').src = e.target.result;
	       	}

        	reader.readAsDataURL(input.files[0]);
	   	}
	}

}]);