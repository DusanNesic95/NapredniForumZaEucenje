app.controller('homeAdminController', ['$scope', 'funkcije', '$localStorage', '$http',
 function($scope, funkcije, $localStorage, $http) {
 	$scope.korisnik = $localStorage.korisnik;

	$scope.logout = function() {
		delete $localStorage.rola;
		delete $localStorage.predmet;
		window.location = "../index.html";
	}

	$scope.idiNaPocetnu = function() {
		window.location = "#/homeadmin";
	}
	
	$scope.idiNaPredmete = function() {
		window.location = "#/predmetprikaz";
	}

	$scope.idiNaKorisnike = function() {
		window.location = "#/korisnikprikaz";	
	}

	$scope.idiNaMaterijale = function() {
		window.location = "#/materijalprikazadmin";	
	}

	$scope.idiNaBlokiranje = function() {
		window.location = "#/blokiranje";
	}

}]);
