const chai = require('chai');
const expect = chai.expect;
const script = require('../public/js/script.js');
const fetchMock = require('fetch-mock');
const jsdom = require('mocha-jsdom');

describe('Movie Cruiser', () => {
	jsdom();

	const moviesTestData = [{
      voteCount: 0,
      id: 476307,
      video: false,
      voteAverage: 0,
      title: 'The Unique Lama',
      popularity: 1,
      posterPath: '../images/The_Unique_Lama.jpg',
      originalLanguage: 'zh',
      originalTitle: 'Da la ma',
      adult: false,
      overview: 'The Unique Lama is a 1978 Wuxia film from Taiwan',
      releaseDate: '1978-09-15'
    },
    {
      voteCount: 74,
      id: 27621,
      video: false,
      voteAverage: 5,
      title: 'The Cheetah Girls: One World',
      popularity: 5.000945,
      posterPath: '../images/The_Cheetah_Girls.jpg',
      originalLanguage: 'en',
      originalTitle: 'The Cheetah Girls: One World',
      adult: false,
      overview: `Chanel, Dorinda, and Aqua, are off to India to star in a Bollywood movie. 
      But when there they discover that they will have to compete against each other 
      to get the role in the movie. Will the Cheetah\'s break up again?`,
      releaseDate: '2008-08-22'
    },
    {
      voteCount: 0,
      id: 142109,
      video: false,
      voteAverage: 0,
      title: 'Unique 8',
      popularity: 1.007201,
      posterPath: '/images/Unique_8.jpg',
      originalLanguage: 'en',
      originalTitle: 'Unique 8',
      adult: false,
      overview: 'We are back with our new 2012 snowboard film release, UNIQUE 8!',
      releaseDate: '2012-01-01'
    }];

    const favouritesTestData = [{
      voteCount: 0,
      id: 444143,
      video: false,
      voteAverage: 0,
      title: 'A Unique Movie',
      popularity: 2.474547,
      posterPath: '../images/A_Unique_Movie.jpg',
      originalLanguage: 'ko',
      originalTitle: '특이점이 온 영화',
      adult: false,
      overview: `Ep.01 My wife\'s healing  Yumi and Hyun-tae are on a journey of 
      reconciliation overnight to overcome bourgeoisie. Eating dinner together  
      I\'m going to join the couple who stayed in the next room.`,
      releaseDate: '2017-03-07'
    }];

	beforeEach(() => {
		document.body.innerHTML =
		`<div class="container">
			<div class="row">
				<div class="col-12 col-md-6">
					<h2>Movies</h2>
					<ul id="moviesList"></ul>
				</div>
				<div class="col-12 col-md-6">
					<h2>Favourites</h2>
					<ul id="favouritesList"></ul>
				</div>
			</div>
		</div>`;
	});

	afterEach(fetchMock.restore);

	it('getMovies() shall hit correct api and return correct response', (done) => {
		fetchMock.get('http://localhost:3000/movies', moviesTestData);

		script.getMovies()
			.then(res => {
				expect(fetchMock.lastUrl()).to.equal('http://localhost:3000/movies');
				expect(res).to.deep.equal(moviesTestData);
				done();
			})
			.catch(err => {
				expect(err).to.equal(null, err);
				done();
			});
	});

	it('there shall be only one server call in getMovies()', (done) => {
		fetchMock.get('http://localhost:3000/movies', moviesTestData);

		script.getMovies()
			.then(() => {
				expect(fetchMock.done()).to.equal(true);
				done();
			})
			.catch(err => {
				expect(err).to.equal(null, err);
				done();
			});
	});

	it('data fetched from getMovies() to be populated in DOM at appropriate place', (done) => {
		fetchMock.get('http://localhost:3000/movies', moviesTestData);

		script.getMovies()
			.then(() => {
				expect(document.getElementById('moviesList').innerHTML)
				.to.include('The Unique Lama');
				expect(document.getElementById('moviesList').innerHTML)
				.to.include('The Cheetah Girls: One World');
				done();
			})
			.catch(err => {
				expect(err).to.equal(null, err);
				done();
			});
	});

	it('getFavourites() shall hit correct api and return correct response', (done) => {
		fetchMock.get('http://localhost:3000/favourites', favouritesTestData);

		script.getFavourites()
			.then(res => {
				expect(fetchMock.lastUrl()).to.equal('http://localhost:3000/favourites');
				expect(res).to.deep.equal(favouritesTestData);
				done();
			})
			.catch(err => {
				expect(err).to.equal(null, err);
				done();
			});
	});

	it('there shall be only one server call in getFavourites()', (done) => {
		fetchMock.get('http://localhost:3000/favourites', favouritesTestData);

		script.getFavourites()
			.then(() => {
				expect(fetchMock.done()).to.equal(true);
				done();
			})
			.catch(err => {
				expect(err).to.equal(null, err);
				done();
			});
	});

	it('data fetched from getFavourites() to be populated in DOM at appropriate place', (done) => {
		fetchMock.get('http://localhost:3000/favourites', favouritesTestData);

		script.getFavourites()
			.then(() => {
				expect(document.getElementById('favouritesList').innerHTML).to.include('A Unique Movie');
				done();
			})
			.catch(err => {
				expect(err).to.equal(null, err);
				done();
			});
	});

	it(`addFavourites() shall hit the correct api with correct data and 
		return correct response`, (done) => {
			fetchMock.get('http://localhost:3000/movies', moviesTestData);
			fetchMock.get('http://localhost:3000/favourites', favouritesTestData);
			fetchMock.post('http://localhost:3000/favourites', moviesTestData[0]);

			script.getMovies()
			.then(() => {
				return script.getFavourites();
			})
			.then(() => {
				return script.addFavourite(476307);
			})
			.then((res) => {
				const lastCallArgs = fetchMock.lastCall();
				expect(lastCallArgs[0]).to.equal('http://localhost:3000/favourites');
				expect(lastCallArgs[1].method).to.equal('POST');
				expect(lastCallArgs[1].body).to.equal(JSON.stringify(moviesTestData[0]));
				favouritesTestData.push(moviesTestData[0]);
				expect(res).to.deep.equal(favouritesTestData);
				expect(document.getElementById('favouritesList').innerHTML)
				.to.include('The Unique Lama');
				done();
			})
			.catch((err) => {
				expect(err).to.equal(null, err);
				done();
			});
	});

	it('there shall be only one server call in addFavourites()', (done) => {
			fetchMock.get('http://localhost:3000/movies', moviesTestData);
			fetchMock.get('http://localhost:3000/favourites', favouritesTestData);

			script.getMovies()
			.then(() => {
				return script.getFavourites();
			})
			.then(() => {
				fetchMock.restore();
				fetchMock.post('http://localhost:3000/favourites', moviesTestData[1]);
				return script.addFavourite(27621);
			})
			.then(() => {
				expect(fetchMock.done()).to.equal(true);
				done();
			})
			.catch((err) => {
				expect(err).to.equal(null, err);
				done();
			});
	});

	it('server error in addFavourites() is handled', (done) => {
		fetchMock.get('http://localhost:3000/movies', moviesTestData);
		fetchMock.get('http://localhost:3000/favourites', favouritesTestData);
		fetchMock.post('http://localhost:3000/favourites',
			{ throws: { message: 'Dummy error from server' }});

		script.getMovies()
		.then(() => {
			return script.getFavourites();
		})
		.then(() => {
			return script.addFavourite(142109);
		})
		.catch((err) => {
			expect(err).to.not.equal(null, err);
			expect(err.message).to.equal('Dummy error from server');
			done();
		});
	});

	it('adding of same movie as favourite twice shall be restricted', (done) => {
		fetchMock.get('http://localhost:3000/movies', moviesTestData);
		fetchMock.get('http://localhost:3000/favourites', favouritesTestData);
		fetchMock.post('http://localhost:3000/favourites', moviesTestData[0]);

		script.getMovies()
		.then(() => {
			return script.getFavourites();
		})
		.then(() => {
			return script.addFavourite(476307);
		})
		.catch((err) => {
			expect(err).to.not.equal(null, err);
			expect(err.message).to.equal('Movie is already added to favourites');
			done();
		});
	});
});
