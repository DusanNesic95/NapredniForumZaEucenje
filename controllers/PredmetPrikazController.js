app.controller('predmetPrikazController', ['$scope', 'funkcije', '$localStorage',
 function($scope, funkcije, $localStorage) {
	$scope.predmeti = [];
	$scope.pretraga = '';

	funkcije.ucitajsvepredmete()
	.success(function(response) {
		$scope.predmeti = response;
	});

	$scope.dodajPredmet = function() {
		delete $localStorage.predmet;
		window.location = "#/predmetforma";
	}

	$scope.izmeniPredmet = function(predmet) {
		$localStorage.predmet = predmet;
		window.location = "#/predmetforma";
	}

	$scope.dodeliProfesora = function(predmet) {
		$localStorage.predmet = predmet;
		window.location = "#/dodelaprofesora";
	}

	$scope.odaberiStudente = function(predmet) {
		$localStorage.predmet = predmet;
		window.location = "#/odaberistudente";
	}
}]);