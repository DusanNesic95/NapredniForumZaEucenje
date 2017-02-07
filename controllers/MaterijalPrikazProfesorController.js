app.controller('materijalPrikazProfesorController', ['$scope', 'funkcije', '$localStorage', 
	function($scope, funkcije, $localStorage) {
	$scope.materijali = [];
	$scope.pretraga = "";
	$scope.tema = $localStorage.tema;

	funkcije.ucitajmaterijalepotemi($scope.tema)
	.success(function(response) {
		$scope.materijali = response;
	});

	$scope.nazad = function() {
		delete $localStorage.tema;
		window.location = "#/temaprikaz";
	}

	$scope.dodajMaterijal = function() {
		delete $localStorage.materijal;
		window.location = "#/materijalforma";
	}
}]);