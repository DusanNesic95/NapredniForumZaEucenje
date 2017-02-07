app.controller('materijalPrikazStampanjeController', ['$scope', 'funkcije', '$localStorage', 
	function($scope, funkcije, $localStorage) {
	$scope.materijali = [];
	$scope.pretraga = "";
	$scope.predmet = $localStorage.predmet;
	$scope.korisnik = $localStorage.korisnik;

	funkcije.ucitajmaterijalepopredmetu($scope.predmet)
	.success(function(response) {
		$scope.materijali = response;
		setTimeout(function() {
			window.print();
			window.location = "#/materijalprikaz";
		}, 500);
	});
}]);