const submitButton = document.getElementById("submitAlbumButton");
const artistList = document.querySelector(".albumList");
const name = document.querySelector("[name = 'apiName']");
const albumName = document.querySelector("[name = 'apiAlbumName']");
const genre = document.querySelector("[name = 'apiGenre']");
const releaseDate = document.querySelector("[name = 'apiReleaseDate']");
const coverImgUrl = document.querySelector("[name = 'apiCoverImgUrl']");


//console.log('poop');
//console.log(recordLabel);
//console.log(name);

submitAlbumButton.addEventListener ("click" , function addAlbum(){
	
	const xhr = new XMLHttpRequest()
	
	xhr.addEventListener("readystatechange", function(response){
		if(xhr.readyState == 4 && xhr.status == 200) {
		
		console.log(response.currentTarget.response)
		const albums = JSON.parse(response.currentTarget.response)
		let list = ''
			albums.forEach(function(albums)  {
				list += `
					<li>
					<a href="/artist/album/${album.albumName}">
					<span>${album.albumName}</span>
					</a>
					</li>
					`
			})
			albums.innerHTML = list
		}
	})
		xhr.open("POST", `/api/artists/albums/?name=${name.value}&albumName=${albumName.value}&genre=${genre.value}&releaseDate=${releaseDate.value}&coverImgUrl=${coverImgUrl.value}`, true)
		xhr.send();
	})