app.controller('korisnikFormaController', ['$scope', 'funkcije', '$localStorage', 
	function($scope, funkcije, $localStorage) {

	$scope.korisnik = $localStorage.korisnik;

	$scope.sacuvajKorisnika = function() {
		if ($scope.korisnik.korisnikId == null) {
			$scope.korisnik.lozinka = $scope.korisnik.korisnickoIme + "123";
			$scope.sacuvaj();
		} else {
			$scope.izmeni();
		}
	}

	$scope.sacuvaj = function() {
		funkcije.dodajkorisnika($scope.korisnik)
		.success(function(response) {
			window.location = "#/korisnikprikaz";
		})
		.error(function() {
			alert("Došlo je do greške pri komunikaciji sa serverom, pokušajte kasnije!");
		});
	}

	$scope.izmeni = function() {
		funkcije.izmenikorisnika($scope.korisnik)
		.success(function(response) {
			window.location = "#/korisnikprikaz";
		})
		.error(function() {
			alert("Došlo je do greške pri komunikaciji sa serverom, pokušajte kasnije!");
		});
	}

	$scope.odustani = function() {
		delete $localStorage.korisnik;
		window.location = "#/korisnikprikaz";
	}

}]);