const submitButton = document.getElementById("submitButton");
const artistList = document.querySelector(".artistList");
const name = document.querySelector("[name = 'apiName']");
const recordLabel = document.querySelector("[name = 'apiRecordLabel']");
console.log('poop');
console.log(recordLabel);
console.log(name);

submitButton.addEventListener ("click" , function addArtist(){
	
	const xhr = new XMLHttpRequest()
	
	xhr.addEventListener("readystatechange", function(response){
		if(xhr.readyState == 4 && xhr.status == 200) {
		
		console.log(response.currentTarget.response)
		const artists = JSON.parse(response.currentTarget.response)
		let list = ''
			artists.forEach(function(artist)  {
				list += `
					<li>
					<a href="/artists/${artist.name}">
					<span>${artist.name}</span>
					</a>
					</li>
					`
			})
			artists.innerHTML = list
		}
	})
		xhr.open("POST", `/api/artists/?name=${name.value}&recordLabel=${recordLabel.value}`, true)
		xhr.send();
	})
		


function showArtists() {
	
	const xhr = new XMLHttpRequest()
	xhr.onreadystatechange = function(response) {
		if(xhr.readyState == 4 && xhr.response == 200) {
			
			const allArtists = JSON.parse(response.currentTarget.response);
			let list = ''
			allArtists.forEach(function(artist){
				list +=`
				<li> 
					<a href="/artists/${artist.name}"> ${artist.name} </a>
 				`
			})
			artistList.innerHTML = list
		}
	}
	
	xhr.open("GET", `/api/artists`, true)
	xhr.send()
}