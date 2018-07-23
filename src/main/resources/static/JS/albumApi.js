const submitButton = document.getElementById("submitAlbumButton");
const albumList = document.getElementById("album-list");
const name = document.querySelector("[name = 'apiName']");
const recordLabel = document.querySelector("[name = 'apiRecordLabel']");
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
			albums.forEach(function(album)  {
				list += `
					<li>
					<a href="/artist/albums/${album.albumName}">
					<span>${album.albumName}</span>
					<img src="${album.coverImgUrl}"  />
					</a>
					</li>
					`
			})
			album.innerHTML = list;
		}
	})
		xhr.open("POST", `/api/albums?name=${name.value}&recordLabel=${recordLabel.value}&albumName=${albumName.value}&genre=${genre.value}&releaseDate=${releaseDate.value}&coverImgUrl=${coverImgUrl.value}`, true)
		xhr.send();
	})