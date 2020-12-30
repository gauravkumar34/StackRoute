function getAllMovies() {
  fetch("http://localhost:3000/movies")
    .then((response) => {
      if (response.status === 200) {
        return response.json();
      }
    })
    .then((movies) => {
      let tbody = document
        .getElementById("movieList")
        .getElementsByClassName("row")[0];
      let tbodyhtml = "";
      movies.forEach((movie) => {
        tbodyhtml += `<div class="row ">
        <div class="col-4">
            <div class="card" style="width: 20rem ">
              <img
              class="img-container"
                src=${movie.posterUrl}
              />
              <div class="card-body">
                <h5 class="card-title">${movie.title}</h5>
                <p><span class="badge bg-primary text-dark">Diector</span> : ${movie.director} </p>
                <p><span class="badge bg-info text-dark">Actor</span> : ${movie.actors} </p>
                <p><span class="badge bg-secondary text-dark">Plot</span> : ${movie.plot} </p>
                <span class="badge badge-success">${movie.year}</span>
              </div>
            </div>
          </div></div>`;
      });
      tbody.innerHTML = tbodyhtml;
    })
    .catch((error) => {
      console.log(error);
    });
}
getAllMovies();
