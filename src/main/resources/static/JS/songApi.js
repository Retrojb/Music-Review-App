console.log('poop');

const submitButton = document.getElementById("submitSongButton");
const songList = document.getElementById("song-list");
//const name = document.querySelector("[name = 'apiName']");
//const albumName = document.querySelector("[name = 'apiAlbumName']");
//const releaseDate = document.querySelector("[name = 'apiReleaseDate]");
//const genre = document.querySelector("[name = 'apiGenre]");
//const coverImage= document.querySelector("[name = 'apiCoverImage]");
const songName = document.querySelector("[name = 'apiSongName']");
const length = document.querySelector("[name = 'apiLength']");
const lyrics = document.querySelector("[name = 'apiLyrics']");
const rating = document.querySelector("[name = 'apiRating']");
console.log('poop');
console.log(length);
console.log(songName);

submitButton.addEventListener ("click" , function addSong(){
	console.log('tits');
	const xhr = new XMLHttpRequest()
	
	xhr.addEventListener("readystatechange", function(response){
		if(xhr.readyState == 4 && xhr.status == 200) {
		
		console.log(response.currentTarget.response)
		const song = JSON.parse(response.currentTarget.response)
		let list = ''
			songs.forEach(function(song)  {
				list += `
					<li>
					<a href="/album/${album.songName}">
					<span>${song.songName}</span>
					</a>
					</li>
					`
			})
			songs.innerHTML = list
			console.log(response);
		}
	})
		xhr.open("POST", `/api/songs?songName=${songName.value}&length=${length.value}&lyrics=${lyrics}&rating=${rating}`, true)
		xhr.send();
	})

	


//function showSong() {
//	
//	const xhr = new XMLHttpRequest()
//	xhr.onreadystatechange = function(response) {
//		if(xhr.readyState == 4 && xhr.response == 200) {
//			
//			const allSong = JSON.parse(response.currentTarget.response);
//			let list = ''
//			allArtists.forEach(function(song){
//				list +=`
//				<li> 
//					<a href="/album/${album.albumName}"> ${album.songName} </a>
// 				`
//			})
//			songList.innerHTML = list
//		}
//	}
//	
//	xhr.open("GET", `/api/album`, true)
//	xhr.send()
//}