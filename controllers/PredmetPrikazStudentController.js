app.controller('predmetPrikazStudentController', ['$scope', 'funkcije', '$localStorage',
 function($scope, funkcije, $localStorage) {
	$scope.predmeti = [];
	$scope.pretraga = '';

	funkcije.ucitajsvepredmete()
	.success(function(response) {
		$scope.predmeti = response;
	});
}]);