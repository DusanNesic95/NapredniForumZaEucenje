app.controller('korisnikPrikazController', ['$scope', 'funkcije', '$localStorage', 
	function($scope, funkcije, $localStorage) {
	$scope.korisnici = [];
	$scope.search = "";

	funkcije.svikorisnici().success(function(response) {
		$scope.korisnici = response;
	});

	$scope.noviKorisnik = function() {
		delete $localStorage.korisnik;
		window.location = "#/korisnikforma";
	}

	$scope.izmeniKorisnika = function(korisnik) {
		$localStorage.korisnik = korisnik;
		window.location = "#/korisnikforma";
	}
}]);