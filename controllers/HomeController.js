app.controller('homeController', ['$scope', 'funkcije', '$localStorage', '$http',
 function($scope, funkcije, $localStorage, $http) {
 	$scope.korisnik = $localStorage.korisnik;

	$scope.logout = function() {
		delete $localStorage.rola;
		delete $localStorage.predmet;
		window.location = "../index.html";
	}

	$scope.idiNaPocetnu = function() {
		window.location = "#/home";
	}
	
	$scope.idiNaPredmete = function() {
		window.location = "#/predmetprikazstudent";
	}

	$scope.idiNaTeme = function() {
		window.location = "#/temaprikazstudent";	
	}

}]);
