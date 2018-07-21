const submitButton = document.getElementById("submitButton");
const name = document.querySelector("[name = 'apiName']");
const recordLabek = document.querySelector("[name = 'apiRecordLabel']");
const artistList = document.querySelector(".artistList");
console.log('poop');

submitButton.addEventListener ("click" , function addArtist(){

	console.log('poop');
    if(event.target.parentElement.classList.contains('add-artist')) {
        const xhr = new XMLHttpRequest()

        xhr.onreadystatechange = function(response) {
            if(xhr.readyState == 4 && xhr.status == 200) {

                const remainingArtist = JSON.parse(this.response.currentTarget.response);
                let list = ''
                remainingArtistforEach(function(artist) {
                    
                    list += `
                    <li>
                        <a href="/artists/${artist.name}"></a>

                    </li>
                    `
                });

                artistList.innerHTML = list;
            }
        }
        xhr.open("POST", `/api/artist?name=${name.value}&recordLabel=${recordLabel}`, true)
        xhr.send();
    }

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