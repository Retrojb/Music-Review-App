const artistsList = document.querySelector('.artists');
console.log('hi')

artistsList.addEventListener('click', function deleteArtist(event) {
	if (event.target.classList.contains('deleteArtist')) {
		console.log('hi')
		const deleteArtistButton = event.target
		
		const artistContainer = deleteArtistButton.parentElement;
		
		const hrefArray = artistContainer.querySelector('a').getAttribute('href').split("/")
		const name = hrefArray[2]
		
		const xhr = new XMLHttpRequest()
		
		xhr.onreadystatechange = function(response) {
			if (xhr.readyState == 4 && xhr.status == 200) {
				console.log('poop');
				console.log(response);
				
				const artistToRemove = JSON.parse(response.currentTarget.response);
				let list = ''
					artistToRemove.forEach(function(artist){
						list += `
						<li>
							<a href="/artists/${artist.name}"> ${artist.name} </a>
							<button id="editArtist">Edit</button>
							<button id="deleteArtist">Delete</button>
						</li>
						`
					})
					artist.innerHTML = list;
			}
		}
	
	xhr.open("DELETE", `/api/artists?name=${name}`, true)
	xhr.send();
	
	}
	
})