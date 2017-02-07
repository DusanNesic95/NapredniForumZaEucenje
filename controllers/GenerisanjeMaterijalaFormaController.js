app.controller('generisanjeMaterijalaFormaController', ['$scope', 'funkcije', '$localStorage', 
	function($scope, funkcije, $localStorage) {

	$scope.predmeti = [];

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

	$scope.generisiMaterijal = function() {
		$scope.odabraniPredmet;
		for (var i = 0; i < $scope.predmeti.length; i++) {
			if ($("#predmetSelect").val() == $scope.predmeti[i].predmetId) {
				$scope.odabraniPredmet = $scope.predmeti[i];
			}
		}
		$localStorage.predmet = $scope.odabraniPredmet;
		window.location = "#/materijalprikaz";
	}

}]);