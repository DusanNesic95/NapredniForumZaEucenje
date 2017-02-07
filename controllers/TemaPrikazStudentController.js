app.controller('temaPrikazStudentController', ['$scope', 'funkcije', '$localStorage', 
	function($scope, funkcije, $localStorage) {
	$scope.teme = [];
	$scope.search = "";

	funkcije.sveteme().success(function(response) {
		$scope.teme = response;
	});

	$scope.primaziMaterijale = function(tema) {
		$localStorage.tema = tema;
		window.location = "#/materijalprikazstudent";
	}
}]);