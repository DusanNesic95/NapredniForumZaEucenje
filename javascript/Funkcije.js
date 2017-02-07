app.factory('funkcije', ['$http', function($http) {

	var funkcije = {};

	//Produkcioni mod
	// var link = 'http://codeline.sytes.net:8080';

	//Dev mod
	var link = 'http://localhost:8080';

	// funkcije.login = function(user) {
	// 	return $http.post(link + '/login', user);
	// }

	funkcije.prijava = function(input) {
		return $http.post(link + '/prijava', input);
	}

	funkcije.ucitajrolukorisnika = function(input) {
		return $http.post(link + '/ucitajrolukorisnika', input);
	}

	funkcije.ucitajsvepredmete = function() {
		return $http.post(link + '/ucitajsvepredmete');
	}

	funkcije.dodajpredmet = function(input) {
		return $http.post(link + '/dodajpredmet', input);
	}

	funkcije.izmenipredmet = function(input) {
		return $http.post(link + '/izmenipredmet', input);
	}

	funkcije.ucitajsveprofesore = function() {
		return $http.post(link + '/ucitajsveprofesore');
	}

	funkcije.dodajpredmetkorisniku = function(input) {
		return $http.post(link + '/dodajpredmetkorisniku', input);
	}

	funkcije.ucitajsvestudente = function() {
		return $http.post(link + '/ucitajsvestudente');
	}

	funkcije.svikorisnici = function() {
		return $http.post(link + '/ucitajsvekorisnike');
	}

	funkcije.dodajkorisnika = function(input) {
		return $http.post(link + '/dodajkorisnika', input);
	}

	funkcije.obrisikorisnika = function(input) {
		return $http.post(link + '/obrisikorisnika', input);
	}

	funkcije.izmenikorisnika = function(input) {
		return $http.post(link + '/izmenikorisnika', input);
	}

	funkcije.svimaterijali = function() {
		return $http.post(link + '/ucitajsvematerijale');
	}

	funkcije.sveteme = function() {
		return $http.post(link + '/ucitajsveteme');
	}

	funkcije.dodajtemu = function(input) {
		return $http.post(link + '/dodajtemu', input);
	}

	funkcije.izmenitemu = function(input) {
		return $http.post(link + '/izmenitemu', input);
	}

	funkcije.ucitajmaterijalepotemi = function(input) {
		return $http.post(link + '/ucitajmaterijalepotemi', input);
	}

	funkcije.dodajmaterijal = function(input) {
		return $http.post(link + '/dodajmaterijal', input);
	}

	funkcije.izmenimaterijal = function(input) {
		return $http.post(link + '/izmenimaterijal', input);
	}

	funkcije.ucitajmaterijalepopredmetu = function(input) {
		return $http.post(link + '/ucitajmaterijalepopredmetu', input);
	}

	return funkcije;
}]);
