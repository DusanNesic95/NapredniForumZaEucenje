app.controller('odaberiStudenteController', ['$scope', 'funkcije', '$localStorage',
 function($scope, funkcije, $localStorage) {
	$scope.studenti = [];
	$scope.pretraga = '';
	$scope.predmet = $localStorage.predmet;

	funkcije.ucitajsvestudente()
	.success(function(response) {
		$scope.studenti = response;
	})
	.error(function(error) {
		alert("Nije moguće uspostaviti vezu sa serverom, pokušajte kasnije! " + error);
	});

	$scope.dodajStudenta = function(student) {
		var predmetStudenta = {
			korisnikId : student,
			predmetId : $scope.predmet
		}

		var data = JSON.stringify(predmetStudenta);
		$scope.izvrsiFunkciju(data);
	}

	$scope.izvrsiFunkciju = function(data) {
		funkcije.dodajpredmetkorisniku(data)
		.success(function(response) {
			if (response) {
				alert("Uspešno ste dodelili predmet studentu!");
			} else {
				alert("Već ste dodelili predmet studentu!");
			}
		})
		.error(function(error) {
			alert("Nije moguće uspostaviti vezu sa serverom, pokušajte kasnije! " + error);
		});
	}

	$scope.nazad = function() {
		window.location = "#/predmetprikaz";
	}
}]);