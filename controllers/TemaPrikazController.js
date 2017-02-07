app.controller('temaPrikazController', ['$scope', 'funkcije', '$localStorage', 
	function($scope, funkcije, $localStorage) {
	$scope.teme = [];
	$scope.search = "";

	funkcije.sveteme().success(function(response) {
		$scope.teme = response;
	});

	$scope.novaTema = function() {
		delete $localStorage.tema;
		window.location = "#/temaforma";
	}

	$scope.izmeniTemu = function(tema) {
		$localStorage.tema = tema;
		window.location = "#/temaforma";
	}

	$scope.prikaziMaterijale = function(tema) {
		$localStorage.tema = tema;
		window.location = "#/materijalprikazprofesor";
	}
}]);