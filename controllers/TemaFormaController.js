app.controller('temaFormaController', ['$scope', 'funkcije', '$localStorage', 
	function($scope, funkcije, $localStorage) {

	$scope.predmeti = [];
	$scope.tema = $localStorage.tema;

	funkcije.ucitajsvepredmete()
	.success(function(response) {
		$scope.predmeti = response;
		$localStorage.predmeti = $scope.predmeti;
		for (var i = 0; i < $scope.predmeti.length; i++) {
			$('#predmetSelect')
			.append($('<option>', {
    			value: $scope.predmeti[i].predmetId,
    			text: $scope.predmeti[i].nazivPredmeta
			}));
		}
	})
	.error(function() {
		alert("Nije moguće povezivanje na server, pokušajte kasnije!");
	});

	$scope.sacuvajTemu = function() {
		if ($scope.tema.temaId == null) {
			$scope.tema.predmetId;
			for (var i = 0; i < $scope.predmeti.length; i++) {
				if ($("#predmetSelect").val() == $scope.predmeti[i].predmetId) {
					$scope.tema.predmetId = $scope.predmeti[i];
				}
			}
			$scope.dodajTemu();
		} else {
			$scope.izmeniTemu();
		}
	}

	$scope.odustani = function() {
		delete $localStorage.tema;
		window.location = "#/temaprikaz";
	}

	$scope.dodajTemu = function() {
		funkcije.dodajtemu($scope.tema)
		.success(function(response) {
			window.location = "#/temaprikaz";
		})
		.error(function() {
			alert("Nije moguće povezivanje na server, pokušajte kasnije!");
		});
	}

	$scope.izmeniTemu = function() {
		funkcije.izmenitemu($scope.tema)
		.success(function(response) {
			window.location = "#/temaprikaz";
		})
		.error(function() {
			alert("Nije moguće povezivanje na server, pokušajte kasnije!");
		});
	}

}]);