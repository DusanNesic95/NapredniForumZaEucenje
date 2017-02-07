app.controller('predmetFormaController', ['$scope', 'funkcije', '$localStorage', 
	function($scope, funkcije, $localStorage) {

	$scope.predmet = $localStorage.predmet;

	$scope.sacuvajIliIzmeni = function() {
		if ($scope.predmet.predmetId == null) {
			$scope.dodajPredmet();
		} else {
			$scope.izmeniPredmet();
		}
	}

	$scope.dodajPredmet = function() {
		funkcije.dodajpredmet($scope.predmet)
		.success(function(response) {
			window.location = "#/predmetprikaz";
		})
		.error(function() {
			alert("Nije moguće povezivanje na server, pokušajte kasnije!");
		});
	}

	$scope.izmeniPredmet = function() {
		funkcije.izmenipredmet($scope.predmet)
		.success(function(response) {
			window.location = "#/predmetprikaz";
		})
		.error(function() {
			alert("Nije moguće povezivanje na server, pokušajte kasnije!");
		});
	}

	$scope.odustani = function() {
		delete $localStorage.predmet;
		window.location = "#/predmetprikaz";
	}

}]);