app.controller('materijalPrikazController', ['$scope', 'funkcije', '$localStorage', 
	function($scope, funkcije, $localStorage) {
	$scope.materijali = [];
	$scope.pretraga = "";
	$scope.predmet = $localStorage.predmet;

	funkcije.ucitajmaterijalepopredmetu($scope.predmet)
	.success(function(response) {
		$scope.materijali = response;
	});

	$scope.nazad = function() {
		delete $localStorage.tema;
		window.location = "#/generisanjematerijalaforma";
	}

	$scope.stampaj = function() {
		window.location = "#/materijalprikazstampanje";
	}
}]);