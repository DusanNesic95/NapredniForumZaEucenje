app.controller('materijalPrikazAdminController', ['$scope', 'funkcije', '$localStorage', 
	function($scope, funkcije, $localStorage) {
	$scope.materijali = [];
	$scope.pretraga = "";

	funkcije.svimaterijali()
	.success(function(response) {
		$scope.materijali = response;
	});
}]);